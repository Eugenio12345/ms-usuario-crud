package com.database.system.wsconsumedatabase.exception;

public class UsuarioNoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    
	public UsuarioNoEncontradoException(Long idProducto) {
		super("Id: " + idProducto + " No encontrado");
	}
	
	
	public UsuarioNoEncontradoException(String message) {
		super("Error debido a "+ message);
	}
}
