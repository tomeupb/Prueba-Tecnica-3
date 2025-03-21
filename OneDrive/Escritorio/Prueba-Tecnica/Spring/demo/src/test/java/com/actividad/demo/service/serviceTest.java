package com.actividad.demo.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.actividad.demo.model.Nave;

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
        

      //System.out.println("Nave4----->"+ nave4.getNave());
      assertEquals("modificada", nave4.getNave());

    }




    @Test
    public void listaNaves(){

        Pageable pageable = PageRequest.of(0, 2);

        Nave nave5 = new Nave("nave5");
        naveService.añadirNave(nave5);
        Nave nave6 = new Nave("nave6");
        naveService.añadirNave(nave6);


        Page <Nave> naves = naveService.listaNaves(pageable);

        //System.out.println(naves.getSize());

        assertEquals(naves.getSize(), 2);

    }



    /* 
    @Test
    void buscarPorParametro() {
        Nave nave7 = new Nave("nave7");
      
        naveService.añadirNave(nave7);
        List<Nave> naves1 = naveService.buscarPorParametro("n");
     
        assertTrue(naves1.contains(nave7));
    
    }
    
*/




}
    
