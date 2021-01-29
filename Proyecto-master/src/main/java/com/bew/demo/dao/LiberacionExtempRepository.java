package com.bew.demo.dao;

import org.springframework.stereotype.Repository;

import com.bew.demo.model.LiberacionExtemp;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface LiberacionExtempRepository extends JpaRepository <LiberacionExtemp,Integer>{

}
