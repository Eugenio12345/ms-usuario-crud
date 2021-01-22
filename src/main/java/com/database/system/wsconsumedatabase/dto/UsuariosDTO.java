package com.database.system.wsconsumedatabase.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TB_USUARIOS")
@Data
public class UsuariosDTO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Long idUsuario;
	
	@Column(name = "NOMBRE_USUARIO")
	private String nombreUsuario;
	
	@Column(name = "CORREO_ELECTRONICO")
	private String correoElectronico;
	
	@Column(name = "ANNIO_NACIMIENTO")
	private String annioNacimiento;
	
	@Column(name = "PASSWORD_USUARIO")
	private String password;

	
	
	
	
}
