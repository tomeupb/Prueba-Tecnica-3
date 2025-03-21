package com.actividad.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="naves")

public class Nave {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private Integer id;
    private String nave;



    public Nave(){

    }


    
    public Nave(String nave) {
        this.nave = nave;
    }


    public Nave(Integer id ,String nave) {
        this.id=id;
        this.nave = nave;
        
    }











    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNave() {
        return nave;
    }
    public void setNave(String nave) {
        this.nave = nave;
    }












    


}
