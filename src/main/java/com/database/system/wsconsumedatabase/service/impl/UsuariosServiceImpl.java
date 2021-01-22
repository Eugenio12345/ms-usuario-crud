package com.database.system.wsconsumedatabase.service.impl;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.system.wsconsumedatabase.dto.UsuariosDTO;
import com.database.system.wsconsumedatabase.exception.UsuarioNoEncontradoException;
import com.database.system.wsconsumedatabase.firebase.UsuarioFBClient;
import com.database.system.wsconsumedatabase.formatter.UsuarioFormatter;
import com.database.system.wsconsumedatabase.model.Usuario;
import com.database.system.wsconsumedatabase.repository.UsuarioRepository;
import com.database.system.wsconsumedatabase.service.UsuariosService;


/**
 * The Class UsuariosServiceImpl.
 */
@Service
public class UsuariosServiceImpl implements UsuariosService {

	/** The usuario formatter. */
	@Autowired
	private UsuarioFormatter usuarioFormatter;
	
	/** The usuario repository. */
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioFBClient usuarioFBClient;
	
	
	/**
	 * Guardar usuario.
	 *
	 * @param usuario the usuario
	 */
	@Override
	public void guardarUsuario(Usuario usuario) {
		
		UsuariosDTO usuarioDTO = this.usuarioFormatter.modelToDto(usuario);
		usuarioDTO = this.usuarioRepository.save(usuarioDTO);
		try {
			
			this.usuarioFBClient.guardarUsuarioFB(usuarioDTO);
		} catch (InterruptedException | ExecutionException exception) {
		      throw new UsuarioNoEncontradoException(exception.getMessage());
		}
	}

	/**
	 * Eliminar usuario.
	 *
	 * @param idUsuario the id usuario
	 */
	@Override
	public void eliminarUsuario(Long idUsuario) {
		this.obtenerPorId(idUsuario);
		this.usuarioRepository.deleteById(idUsuario);
		this.usuarioFBClient.eliminarUsiarioFB(idUsuario.toString());
	}

	/**
	 * Obtener lista usuarios.
	 *
	 * @return the list
	 */
	@Override
	public List<Usuario> obtenerListaUsuarios() {
		List<Usuario> usuariosFB = null;
		List<Usuario> usuariosMysql = null;
		try {
			usuariosFB = this.usuarioFormatter.listDtoToModel(this.usuarioFBClient.obtenerTodosFB());
			usuariosMysql = this.usuarioFormatter.listDtoToModel((List<UsuariosDTO>)this.usuarioRepository.findAll());
			if(usuariosFB.size() != usuariosMysql.size()) {
				throw new UsuarioNoEncontradoException("Las listas no coinciden!");
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return usuariosFB;
	}

	/**
	 * Obtener por id.
	 *
	 * @param id the id
	 * @return the usuario
	 */
	@Override
	public Usuario obtenerPorId(Long id) {
		UsuariosDTO usuarioDTO = null;
		UsuariosDTO usuarioFB = null;
		try {
			 usuarioFB = this.usuarioFBClient.obtenerUsuarioFB(id.toString());
			 usuarioDTO = this.usuarioRepository.findById(id).orElseThrow(()-> new UsuarioNoEncontradoException("Usuario no encontrado en MySql") );
			 
			 if(usuarioDTO == null || usuarioFB==null) {
				 throw new UsuarioNoEncontradoException("Usuario no encontrado en la BD");
			 }
			 
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.usuarioFormatter.dtoToModel(usuarioFB);
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		UsuariosDTO usuariosDTO = this.usuarioRepository.save(this.usuarioFormatter.modelToDto(usuario));
		try {
			this.usuarioFBClient.actualizarUsuarioFB(usuariosDTO);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.usuarioFormatter.dtoToModel(usuariosDTO);
	}

}
