package beans;

public class ExcepcionClaveIncorrecta extends ExcepcionAp {
	
	
	private Exception error;

	public ExcepcionClaveIncorrecta(String pMensaje,int pCodigo){
		
		super(pMensaje,pCodigo);
		
	}
	
	public ExcepcionClaveIncorrecta(String pMensaje,int pCodigo,Exception exc){
		
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
