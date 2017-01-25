package interfaces;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public interface Dao {
	
	
	public Connection getConnection()throws SQLException;
	
	public void close()throws SQLException;
	
	public boolean consultaDatos(HttpServletRequest request,HttpServletResponse response)throws SQLException;
	
	public Object getModelo();
	
	
}
