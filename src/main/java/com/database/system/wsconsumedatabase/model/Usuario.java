package com.database.system.wsconsumedatabase.model;

import lombok.Data;

@Data
public class Usuario {
    
	private Long idUsuario;
	private String nombreUsuario;
	private String correoElectronico;
	private String annioNacimiento;
	private String password;
	
}
