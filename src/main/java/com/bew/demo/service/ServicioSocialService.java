package com.bew.demo.service;
import java.util.List;
import com.bew.demo.dto.ServicioSocialDTO;
import com.bew.demo.exception.EmptyResultException;

public interface ServicioSocialService {
	List<ServicioSocialDTO> findAll();
	ServicioSocialDTO findById(Integer idServicio);
	void saveServicioSocial(ServicioSocialDTO servicioDTO);
	void updateServicioSocial(ServicioSocialDTO servicioDTO)throws EmptyResultException;
	void deleteServicioSocial(Integer idServicio)throws EmptyResultException;
	ServicioSocialDTO findByIdAlumno(Integer idAlumno);
}