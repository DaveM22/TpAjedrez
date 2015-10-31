package Excepciones;

public class MovInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public MovInvalidoException(String mensaje)
	{
		this.mensaje=mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}



}
