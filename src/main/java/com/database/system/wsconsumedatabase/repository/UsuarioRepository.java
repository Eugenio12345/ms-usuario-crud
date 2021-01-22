package com.database.system.wsconsumedatabase.repository;

import org.springframework.data.repository.CrudRepository;

import com.database.system.wsconsumedatabase.dto.UsuariosDTO;

public interface UsuarioRepository extends CrudRepository<UsuariosDTO, Long> {

}
