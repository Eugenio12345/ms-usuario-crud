package com.database.system.wsconsumedatabase.service;

import java.util.List;

import com.database.system.wsconsumedatabase.model.Usuario;


/**
 * The Interface UsuariosService.
 */
public interface UsuariosService {

	/**
	 * Guardar usuario.
	 *
	 * @param usuario the usuario
	 */
	void guardarUsuario(Usuario usuario);
	
	/**
	 * Eliminar usuario.
	 *
	 * @param idUsuario the id usuario
	 */
	void eliminarUsuario(Long idUsuario);
	
	/**
	 * Obtener lista usuarios.
	 *
	 * @return the list
	 */
	List<Usuario> obtenerListaUsuarios();
	
	/**
	 * Obtener por id.
	 *
	 * @param id the id
	 * @return the usuario
	 */
	Usuario obtenerPorId(Long id);
	
	
	Usuario actualizarUsuario(Usuario usuario);
}
