package com.actividad.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class naveAspect {
    private static final Logger logger = LoggerFactory.getLogger(naveAspect.class);
    @Before("execution(* com.actividad.demo.service.NaveService.buscar*(..)) && args(id,..)")
    public void negativo(int id) {
        if (id < 0) {
            
           // System.out.print("No puedes buscar un id con un numero negativo");
           logger.error("No puedes buscar una nave con un id negativo: {}", id);
            //throw new IllegalArgumentException("No puedes buscar un id con un numero negativo");
        }
    }




}
