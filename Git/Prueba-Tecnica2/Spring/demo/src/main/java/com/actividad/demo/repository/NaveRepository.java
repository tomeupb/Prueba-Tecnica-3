package com.actividad.demo.repository;

import java.util.List;

import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import  com.actividad.demo.model.Nave; //importante

public interface NaveRepository  extends JpaRepository<Nave, Integer>{

    List<Nave> findByNaveContaining (String param);

  
}
