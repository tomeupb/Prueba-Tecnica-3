package com.actividad.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; 
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.actividad.demo.model.Nave;
import com.actividad.demo.service.NaveService;


@RestController
@RequestMapping("/api/naves")
public class NaveController {



    @Autowired
    private NaveService naveService;




    //Añadir Nave
    @PostMapping
    public Nave añadirNave(@RequestBody Nave nave){
        return naveService.añadirNave(nave);

    }







    //Listar Naves Sin Paginación
/* 
    @GetMapping
    public List<Nave> ListaNaves(){
        return naveService.listaNaves();
    }
*/


    //Listar Naves + Paginación
    @GetMapping
    public Page<Nave> ListaNaves(Pageable pageable) {
        return naveService.listaNaves(pageable);  // Llamamos al servicio para obtener las naves con paginación
    }




    //Eliminar Nave por id
    @DeleteMapping("/{id}")
    public void eliminarNave(@PathVariable Integer id){
        naveService.eliminarNave(id);
    }




      //buscar Nave por ID
    @GetMapping("/{id}")
    public Nave buscarNaveId(@PathVariable Integer id){
        return naveService.buscarNaveId(id);

    }



    @PutMapping
    public Nave modificarNave(@RequestBody Nave nave){
        
        return naveService.modificarNave(nave);

    }



    @GetMapping("/buscar")
    public List<Nave> buscarPorParametro(@RequestParam String parametro){
        return naveService.buscarPorParametro(parametro);

    }
}
