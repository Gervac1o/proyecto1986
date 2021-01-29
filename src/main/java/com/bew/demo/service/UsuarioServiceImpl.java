package com.bew.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bew.demo.dao.UsuarioRepository;
import com.bew.demo.dto.UsuarioDTO;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.model.Usuario;
import com.github.dozermapper.core.DozerBeanMapperBuilder;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public List<UsuarioDTO> findAll() {
		
		List<UsuarioDTO> usuarioDTO;
		List<Usuario> usuarios = usuarioRepository.findAll();
		usuarioDTO = new ArrayList<>();
		for(Usuario usuario: usuarios) {
			Mapper mapper = DozerBeanMapperBuilder.buildDefault();
			usuarioDTO.add(mapper.map(usuario, UsuarioDTO.class));
		}
		// TODO Auto-generated method stub
		return usuarioDTO;
	}

	@Override
	public UsuarioDTO findById(Integer idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUsuario(UsuarioDTO usuarioDTO) {
		// TODO Auto-generated method stub
		Usuario usuario;
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		usuario = (mapper.map(usuarioDTO, Usuario.class));
    	usuarioRepository.save(usuario);
	}

	@Override
	public void updateUsuario(UsuarioDTO usuarioDTO) throws EmptyResultException {
		// TODO Auto-generated method stub
		Usuario usuario;
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		usuario = (mapper.map(usuarioDTO, Usuario.class));
		usuarioRepository.save(usuario);
	}

	@Override
	public void deleteUsuario(Integer idUsuario) throws EmptyResultException {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(idUsuario);
	}

}
