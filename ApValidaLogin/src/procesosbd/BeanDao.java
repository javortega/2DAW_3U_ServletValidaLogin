package procesosbd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.Usuario;
import interfaces.Dao;

public class BeanDao implements Dao {

	private DataSource ds;
	private Connection conexion;
	private Usuario usr;
	
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
		Statement st=null;
		ResultSet rs=null;
		
		
		try {
			st = this.conexion.createStatement();
			rs = st.executeQuery("select login,clave,nombre from logins where login='"+request.getParameter("login")+"';");
		
			while(rs.next()){
				if(rs.getString("login").equals(request.getParameter("login"))){
				this.usr=new Usuario(rs.getString(1),rs.getString(2),rs.getString(3));
				resultado=true;
				}
				}
			
			} catch (SQLException e) {
			System.out.println("Error en la conexion a la base de datos.");
		}
		
		
		return resultado;
	}
	
	public Object getModelo(){
		
		return this.usr;
	}
	
}
