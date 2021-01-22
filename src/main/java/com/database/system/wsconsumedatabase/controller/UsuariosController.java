package com.database.system.wsconsumedatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.database.system.wsconsumedatabase.model.Usuario;
import com.database.system.wsconsumedatabase.service.UsuariosService;


@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuariosController {

	@Autowired
	private UsuariosService usuariosService;
	
	@GetMapping("/usuarios/obtener/registros")
	public ResponseEntity<List<Usuario>>obtenerTodos(){
		return new ResponseEntity<List<Usuario>>(this.usuariosService.obtenerListaUsuarios(), HttpStatus.OK);
	}
	
	
	@PostMapping("/usuarios/crear/registro")
	public ResponseEntity<Void> guardarUsuario(@RequestBody Usuario usuario){
		this.usuariosService.guardarUsuario(usuario);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/usuarios/obtener/registro/{idUsuario}")
	public ResponseEntity<Usuario> obtenerPorId(@PathVariable Long idUsuario){
		return new ResponseEntity<Usuario>(this.usuariosService.obtenerPorId(idUsuario), HttpStatus.OK);
	}
	
	@DeleteMapping("/usuarios/eliminar/registro/{idUsuario}")
	public ResponseEntity<Void> eliminarPorId(@PathVariable Long idUsuario){
		this.usuariosService.eliminarUsuario(idUsuario);
	    return new ResponseEntity<Void>(HttpStatus.OK);	
	}
	
	
	@PutMapping("/usuarios/actualizar/registro")
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario){
		return new  ResponseEntity<Usuario> (this.usuariosService.actualizarUsuario(usuario), HttpStatus.OK);
	}
	
}