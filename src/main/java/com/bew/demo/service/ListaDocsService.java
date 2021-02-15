package com.bew.demo.service;

import java.util.List;

import com.bew.demo.dto.ListaDocsDTO;


public interface ListaDocsService {
	List<ListaDocsDTO> findAll();
	ListaDocsDTO findById(Integer idLista);
	void saveListaDocs(ListaDocsDTO listaDocsDTO);
	void updateListaDocs(ListaDocsDTO listaDocsDTO);
	void deleteListaDocs(Integer idLista);
	
}
