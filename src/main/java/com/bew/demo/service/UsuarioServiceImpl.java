package com.bew.demo.service;

import com.bew.demo.dao.UsuarioRepository;
import com.bew.demo.dto.UsuarioDTO;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.model.Usuario;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		
		UsuarioDTO usuarioDTO = new UsuarioDTO(); 
		Usuario usuario = null;
		Optional<Usuario> opUsuario = usuarioRepository.findById(idUsuario);
		usuario = opUsuario.get();
		
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    	usuarioDTO = ( mapper.map(usuario, UsuarioDTO.class));
		
		return usuarioDTO;
	}
	@Override
	public UsuarioDTO UsuarioEmail(UsuarioDTO usuarioDTO) {
			
		 
		Usuario usuario = null;
		Optional<Usuario> opUsuario  = usuarioRepository.findByEmail(usuarioDTO.getEmail());
		usuario = opUsuario.get();
		
		 if( usuario.getContraseña().equals(usuarioDTO.getContraseña())) {
			
			
			 Mapper mapper = DozerBeanMapperBuilder.buildDefault();
			 usuarioDTO = ( mapper.map(usuario , UsuarioDTO.class));
			 usuarioDTO.setStatus(true);
			 usuarioDTO.setContraseña("");
		 }
		 else {
		
			 usuarioDTO.setStatus(false);
			 usuarioDTO.setContraseña("");

		 }
		
	   
		return usuarioDTO;
	}
	@Override
	public UsuarioDTO UsuarioContraseña(String contraseña) {
			
		UsuarioDTO usuarioDTO = new UsuarioDTO(); 
		Usuario usuario = null;
		Optional<Usuario> opUsuario  = usuarioRepository.findByContraseña(contraseña);
		usuario = opUsuario.get();
			
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	    usuarioDTO = ( mapper.map(usuario , UsuarioDTO.class));
		return usuarioDTO;
	}
	@Override
	public UsuarioDTO UsuarioTipo(Boolean tipoUsuario) {
			
		UsuarioDTO usuarioDTO = new UsuarioDTO(); 
		Usuario usuario = null;
		Optional<Usuario> opUsuario  = usuarioRepository.findByTipo(tipoUsuario);
		usuario = opUsuario.get();
			
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	    usuarioDTO = ( mapper.map(usuario , UsuarioDTO.class));
		return usuarioDTO;
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

	@Override
    public UsuarioDTO findUsuarioByEmail(String email) throws EmptyResultException {
		UsuarioDTO usuarioDTO = new UsuarioDTO(); 
		Usuario usuario = null;


        usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new EmptyResultException("Sin Resultados"));


//		Optional<Usuario> opUsuario  = usuarioRepository.findByEmail(email);
//		usuario = opUsuario.get();
        if (usuario == null) {
            usuarioDTO = null;
        } else {
            Mapper mapper = DozerBeanMapperBuilder.buildDefault();
            usuarioDTO = (mapper.map(usuario, UsuarioDTO.class));
        }
		return usuarioDTO;
	}

}
