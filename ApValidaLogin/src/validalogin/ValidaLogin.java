package validalogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import procesosbd.BeanDao;

public class ValidaLogin extends HttpServlet{
	
	private BeanDao beanDao;
	
	
	public void init(ServletConfig configInicial) throws ServletException{
		
		super.init(configInicial);
		
		try {
			InitialContext contextoIni = new InitialContext();
			
			
			this.beanDao=new BeanDao((DataSource)contextoIni.lookup(configInicial.getServletContext().getInitParameter("datasource")));
		} catch (NamingException e) {
			System.out.println("Error en el método init().Namingexception");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Se reenvía hacia el método doPost(), ya que tanto las peticiones GET como
	    // las POST se procesarán igual, y de esta manera, se evita código redundante.
	    doPost(request,response);		
	}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.beanDao.getConnection();
		
		if (this.beanDao.consultaDatos(request, response)){
			
			String vista="WEB-INF/respuesta.jsp";
	    
	      request.setAttribute("modelo",this.beanDao.getModelo());
	      this.beanDao.close();
	      RequestDispatcher rd = request.getRequestDispatcher(vista); 
	      rd.forward(request, response);
	      
	    }
		
	    else
	    {
	    this.beanDao.close();	
	    }
		} catch (SQLException e) {
			System.out.println("Error en la conexion a bd.Metodo doPost()");
		}
	}

}
