package beans;

public class ExcepcionConexionBaseDatos extends ExcepcionAp {

	
	private Exception error;

	public ExcepcionConexionBaseDatos(String pMensaje,int pCodigo){
		
		super(pMensaje,pCodigo);
		
	}
	
	public ExcepcionConexionBaseDatos(String pMensaje,int pCodigo,Exception exc){
		
		super(pMensaje,pCodigo);
		this.error = exc;
		
	
	}

public int getCodError(){
		
		return this.codigoError;
	}

public String getMensajeError(){
	
	return this.mensaje;
}
}
