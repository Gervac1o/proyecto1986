package com.bew.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bew.demo.dao.AlumnoRepository;
import com.bew.demo.dto.AlumnoDTO;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.model.Alumno;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;


@Service
@Transactional
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepository;
	
	@Override
	public List<AlumnoDTO> findAll() {
		
		List<AlumnoDTO> alumnoDTO;
		List<Alumno> alumnos = alumnoRepository.findAll();
		alumnoDTO = new ArrayList<>();
		for(Alumno alumno: alumnos) {
			Mapper mapper = DozerBeanMapperBuilder.buildDefault();
			alumnoDTO.add(mapper.map(alumno, AlumnoDTO.class));
		}
		// TODO Auto-generated method stub
		return alumnoDTO;
	}

	@Override
	public AlumnoDTO findById(Integer idAlumno) {
		
		AlumnoDTO alumnoDTO = new AlumnoDTO(); 
		Alumno alumno = null;
		Optional<Alumno> opAlumno = alumnoRepository.findById(idAlumno);
		alumno = opAlumno.get();
		
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    	alumnoDTO = ( mapper.map(alumno, AlumnoDTO.class));
		
		return alumnoDTO;
	}
	@Override
	public AlumnoDTO findByIdUsuario(Integer idUsuario) {
		AlumnoDTO alumnoDTO = new AlumnoDTO(); 
		Alumno alumno = null;
		try {
			alumno = alumnoRepository.findByIdUsuario(idUsuario).orElseThrow(() -> new EmptyResultException("Sin Resultados"));
			Mapper mapper = DozerBeanMapperBuilder.buildDefault();
			alumnoDTO = ( mapper.map(alumno, AlumnoDTO.class));
		} catch (EmptyResultException e) {
			//meter aqui log informativo de alumno no encontrado
		}

		return alumnoDTO;
	}
	@Override
	public List<AlumnoDTO> AlumnoNombre(String nombre) {
			
		List<AlumnoDTO> alumnoDTO; 
		List<Alumno> alumnos = alumnoRepository.findByNombre(nombre);
		alumnoDTO = new ArrayList<>();
		for(Alumno alumno: alumnos) {
			Mapper mapper = DozerBeanMapperBuilder.buildDefault();
			alumnoDTO.add(mapper.map(alumno, AlumnoDTO.class));
		}
		return alumnoDTO;
	}
	@Override
	public List<AlumnoDTO> AlumnoPrograma(String programaAcademico) {
			
		List<AlumnoDTO> alumnoDTO; 
		List<Alumno> alumnos = alumnoRepository.findByPrograma(programaAcademico);
		alumnoDTO = new ArrayList<>();
		for(Alumno alumno: alumnos) {
			Mapper mapper = DozerBeanMapperBuilder.buildDefault();
			alumnoDTO.add(mapper.map(alumno, AlumnoDTO.class));
		}
		return alumnoDTO;
	}
	@Override
	public AlumnoDTO AlumnoApellidoPaterno(String apellidoPaterno) {
			
		AlumnoDTO alumnoDTO = new AlumnoDTO(); 
		Alumno alumno = null;
		Optional<Alumno> opalumno  = alumnoRepository.findByApellidoPaterno(apellidoPaterno);
		alumno = opalumno.get();
			
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	    alumnoDTO = ( mapper.map(alumno , AlumnoDTO.class));
		return alumnoDTO;
	}
	@Override
	public AlumnoDTO AlumnoApellidoMaterno(String apellidoMaterno) {
			
		AlumnoDTO alumnoDTO = new AlumnoDTO(); 
		Alumno alumno = null;
		Optional<Alumno> opalumno  = alumnoRepository.findByApellidoMaterno(apellidoMaterno);
		alumno = opalumno.get();
			
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	    alumnoDTO = ( mapper.map(alumno , AlumnoDTO.class));
		return alumnoDTO;
	}
	@Override
	public AlumnoDTO AlumnoBoleta(Integer boleta) {
			
		AlumnoDTO alumnoDTO = new AlumnoDTO(); 
		Alumno alumno = null;
		Optional<Alumno> opalumno  = alumnoRepository.findByBoleta(boleta);
		alumno = opalumno.get();
			
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	    alumnoDTO = ( mapper.map(alumno , AlumnoDTO.class));
		return alumnoDTO;
	}
	@Override
	public void saveAlumno(AlumnoDTO alumnoDTO) {
		// TODO Auto-generated method stub
		Alumno alumno;
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		alumno = (mapper.map(alumnoDTO, Alumno.class));
    	alumnoRepository.save(alumno);
	}

	@Override
	public void updateAlumno(AlumnoDTO alumnoDTO) throws EmptyResultException {
		// TODO Auto-generated method stub
		Alumno alumno;
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		alumno = (mapper.map(alumnoDTO, Alumno.class));
		alumnoRepository.save(alumno);
	}

	@Override
	public void deleteAlumno(Integer idAlumno) throws EmptyResultException {
		// TODO Auto-generated method stub
		alumnoRepository.deleteById(idAlumno);
	}


}