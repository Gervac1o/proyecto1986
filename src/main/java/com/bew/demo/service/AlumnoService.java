/**
 * 
 */
package com.bew.demo.service;

import java.util.List;
import com.bew.demo.dto.AlumnoDTO;
import com.bew.demo.exception.EmptyResultException;

/**
 * @author Erick
 *
 */
public interface AlumnoService {
	List<AlumnoDTO> findAll();
	AlumnoDTO findById(Integer idAlumno);
	void saveAlumno(AlumnoDTO alumnoDTO);
	void updateAlumno(AlumnoDTO alumnoDTO)throws EmptyResultException;
	void deleteAlumno(Integer idAlumno)throws EmptyResultException;
	List<AlumnoDTO> AlumnoNombre (String nombre);
	AlumnoDTO AlumnoApellidoPaterno (String apellidoPaterno);
	AlumnoDTO AlumnoApellidoMaterno (String apellidoMaterno);
	AlumnoDTO AlumnoBoleta (Integer boleta);
	AlumnoDTO findByIdUsuario(Integer idUsuario);
	
}
