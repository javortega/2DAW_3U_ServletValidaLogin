package beans;

public class ExcepcionLoginNoEncontrado extends ExcepcionAp {

	
	private Exception error;

	public ExcepcionLoginNoEncontrado(String pMensaje,int pCodigo){
		
		super(pMensaje,pCodigo);
		
	}
	
	public ExcepcionLoginNoEncontrado(String pMensaje,int pCodigo,Exception exc){
		
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
