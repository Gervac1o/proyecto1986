package com.bew.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bew.demo.model.FileImage;


@Repository
public interface FileImageRepository extends JpaRepository <FileImage, Integer  >{

	//void save(Integer idDictamen);


	}

