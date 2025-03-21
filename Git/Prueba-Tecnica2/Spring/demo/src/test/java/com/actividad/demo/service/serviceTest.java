package com.actividad.demo.service;

import java.util.List;
import java.util.Optional;

import javax.print.attribute.standard.MediaSize.NA;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;

import com.actividad.demo.model.Nave;
import com.actividad.demo.repository.NaveRepository;

@SpringBootTest
public class serviceTest {

   

    @Autowired
     NaveService naveService;







  

    @Test
    void añadirNave(){

        Nave nave1 = new Nave("nave1");

       Nave result =naveService.añadirNave(nave1);

        assertNotNull(result);


    }


    @Test
    void eliminarNave(){

        Nave nave2 = new Nave("nave2");
        naveService.añadirNave(nave2);
        
        
        //Compruebo que no sea nulo
        assertNotNull(naveService.buscarNaveId(nave2.getId()));
        //elimino
        naveService.eliminarNave(nave2.getId());
        //Compruebo que se ha eliminado
        assertNull(naveService.buscarNaveId(nave2.getId()));
           
    }


    @Test
    void buscarNaveId(){


        Nave nave3 = new Nave("nave3");
        naveService.añadirNave(nave3);

        

        Nave guardar = naveService.buscarNaveId(nave3.getId());
        assertNotNull(guardar);

    
        assertEquals(guardar.getId(), nave3.getId());

    
    }

    @Test
    public void modificarNave(){

        Nave nave4 = new Nave("nave4");
        naveService.añadirNave(nave4);

       nave4.setNave("modificada");

       naveService.modificarNave(nave4);
        

      System.out.println("Nave4----->"+ nave4.getNave());
      assertEquals("modificada", nave4.getNave());

    }




    @Test
    public void listaNaves(){

        Pageable pageable = PageRequest.of(0, 2);

        Nave nave5 = new Nave("uno");
        naveService.añadirNave(nave5);
        Nave nave6 = new Nave("dos");
        naveService.añadirNave(nave6);


        Page <Nave> naves = naveService.listaNaves(pageable);

        System.out.println(naves.getSize());

        assertEquals(naves.getSize(), 2);

    }



    @Test
    void buscarPorParametro(){




    }


    /* 
    @Test
    public void buscarPorParametro(){


        Nave nave1= new Nave("nave");

        naveService.añadirNave(nave1);


        
        List<Nave> naves = naveService.buscarPorParametro("nave");
    
        assertThat(naves).isNotNull();

       assertThat(naves.contains(nave1.getNave()));

       //assertFalse(naves.isEmpty());

    }

*/

   

  



/* 
    @Test
    public void listaNaves(){
        Pageable pageable=PageRequest.of(0,10);

        Nave nave1 = new Nave("primera");
        naveService.añadirNave(nave1);
        


        Page<Nave> naves = naveService.listaNaves(pageable);

       // System.out.println("Tamaño"+naves.getNumberOfElements());
       
        assertThat(naves).isNotNull();
        assertThat(naves.getSize()).isEqualTo(1);
        
    }
*/





}
    
