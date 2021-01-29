package com.bew.demo.service;
import java.util.List;
import com.bew.demo.dto.SolicitudBajaDTO;
import com.bew.demo.exception.EmptyResultException;

public interface SolicitudBajaService {
	List<SolicitudBajaDTO> findAll();
	SolicitudBajaDTO findById(Integer idSolicitud);
	void saveSolicitudBaja(SolicitudBajaDTO solicitudDTO);
	void updateSolicitudBaja(SolicitudBajaDTO solicitudDTO)throws EmptyResultException;
	void deleteSolicitudBaja(Integer idSolicitud)throws EmptyResultException;
}