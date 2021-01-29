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

}
