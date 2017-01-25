package beans;

public class Usuario {

	
	private String login;
	
	private String clave;
	
	private String nombre;
	
	
	public Usuario(String pLogin,String pClave,String pNombre){
		
		this.login = pLogin;
		this.clave = pClave;
		this.nombre = pNombre;
	}


	public String getLogin() {
		return login;
	}


	public String getClave() {
		return clave;
	}


	public String getNombre() {
		return nombre;
	}
	
	
}
