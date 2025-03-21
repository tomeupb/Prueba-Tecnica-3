package com.actividad.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;  // Importación correcta de Pageable
import org.springframework.stereotype.Component;

import com.actividad.demo.model.Nave;
import com.actividad.demo.repository.NaveRepository;




@Component
public class NaveService {


    @Autowired
    private NaveRepository naveRepository;



    //Añadir Nave
    public Nave añadirNave(Nave nave){
       
        return naveRepository.save(nave);

    }


   
    //Listar Naves Sin Paginación
/* 
    public List<Nave> ListaNaves(){
        return naveRepository.findAll();

    }
*/


    //Listar Naves + Paginación
    public Page<Nave> listaNaves(Pageable pageable) {
        Page<Nave> nave = naveRepository.findAll(pageable);
        System.out.println("Resultado de finAll"+nave);
        return nave;
    }




    //Eliminar Nave por id
    public void eliminarNave(Integer id){

        naveRepository.deleteById(id);
}


    //buscar Nave por ID
public Nave buscarNaveId(Integer id){

    Optional <Nave> nave = naveRepository.findById(id);

    if(nave.isPresent()){
        return nave.get();
    }else{
        return null;  
    }
}


    
public Nave modificarNave(Nave nave){

    return naveRepository.save(nave);
}



public List<Nave>buscarPorParametro(String parametro){
     List<Nave> naves =naveRepository.findByNaveContainingIgnoreCase(parametro);
     return naves;

}
    


}
