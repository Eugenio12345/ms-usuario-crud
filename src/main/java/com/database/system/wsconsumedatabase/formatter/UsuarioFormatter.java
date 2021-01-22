package com.database.system.wsconsumedatabase.formatter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.database.system.wsconsumedatabase.dto.UsuariosDTO;
import com.database.system.wsconsumedatabase.model.Usuario;

@Component
public class UsuarioFormatter {

	@Autowired
	private ModelMapper modelMapper;
	
	public UsuariosDTO modelToDto(Usuario model) {
		UsuariosDTO dto = modelMapper.map(model, UsuariosDTO.class);
		return dto;
	}
	
	public Usuario dtoToModel(UsuariosDTO dto) {
		Usuario model = modelMapper.map(dto, Usuario.class);
		return model;
	}
	
	public List<Usuario> listDtoToModel(List<UsuariosDTO> listDto){
		return listDto.stream().map(s->this.dtoToModel(s)).collect(Collectors.toList());
	}
	
}
