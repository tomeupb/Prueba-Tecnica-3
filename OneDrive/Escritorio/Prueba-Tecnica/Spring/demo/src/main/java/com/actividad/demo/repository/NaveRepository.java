package com.actividad.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.actividad.demo.model.Nave;

public interface NaveRepository  extends JpaRepository<Nave, Integer>{

    List<Nave> findByNaveContainingIgnoreCase(String param);

  
}
