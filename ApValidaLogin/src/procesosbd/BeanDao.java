package procesosbd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.ExcepcionAp;
import beans.ExcepcionClaveIncorrecta;
import beans.ExcepcionConexionBaseDatos;
import beans.ExcepcionLoginNoEncontrado;
import beans.Usuario;
import interfaces.Dao;

public class BeanDao implements Dao {

	private DataSource ds;
	private Connection conexion;
	private Usuario usr;
	private ExcepcionAp error;
	
	public BeanDao(DataSource pDs){
		this.ds=pDs;
		
	}
	public Connection getConnection() throws SQLException {
		this.conexion= this.ds.getConnection();
		return this.conexion;
	}
	


	@Override
	public void close() throws SQLException {
		this.conexion.close();
		
	}

	@Override
	public boolean consultaDatos(HttpServletRequest request,HttpServletResponse response)  {
		
		boolean resultado = false;
		Statement st = null;
		ResultSet rs = null;

		try {
			st = this.conexion.createStatement();
			rs = st.executeQuery(
					"select login,clave,nombre from logins where login='" + request.getParameter("login") + "';");

			while (rs.next()) {
				if (!(rs.getString("clave").equals(request.getParameter("clave")))) {
					this.error = new ExcepcionClaveIncorrecta("La clave no coincide", 1);
				} else {
					this.usr = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3));
					resultado = true;
				}
			}
			if (resultado == false && this.error == null)
				this.error = new ExcepcionLoginNoEncontrado("El login no se encuentra en la base de datos", 2);
		} catch (SQLException e) {
			this.error = new ExcepcionConexionBaseDatos("Error en la conexión a base de datos", 3, e);

		}

		return resultado;
	}

	public Object getModelo(){
		
		return this.usr;
	}
	public ExcepcionAp getError(){
		
		return this.error;
	}
}
