package beans;

public class ExcepcionAp extends Exception{
	
	protected String mensaje;
	protected int codigoError;
	
	public ExcepcionAp(String pMensaje,int pCodigo){
		
		this.mensaje=pMensaje;
		this.codigoError=pCodigo;
		
	}
	public int getCodError(){
		return this.codigoError;
	}
	public String getMensajeError(){
		
		return this.mensaje;
	}
}
