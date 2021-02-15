package com.bew.demo.service;

import java.util.List;



import com.bew.demo.dto.ListaDocsDTO;


public interface ListaDocsService {
	List<ListaDocsDTO> findAll();
	ListaDocsDTO findById(Integer idLista);
	void saveListaDocs(ListaDocsDTO listaDocsDTO);
	void updateListaDocs(ListaDocsDTO listaDocsDTO);
	void deleteListaDocs(Integer idLista);
	List<ListaDocsDTO> findDictamen(Integer idAlumno);
	List<ListaDocsDTO> findLiberacion(Integer idAlumno);
	List<ListaDocsDTO> findBaja(Integer idAlumno);
	List<ListaDocsDTO> findServicio(Integer idAlumno);

}
