/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Timestamp;

/**
 *
 * @author josel
 */
public class TablaBeneficiarios {
    /*
        Table: tabla_beneficiarios
        Columns:
        id int AI PK 
        nombre varchar(45) 
        localidad varchar(45) 
        id_obra int 
        created_at datetime
    
    */
    private int id;
    private String nombre;
    private String localidad;
    private int id_obra;
    private Timestamp created_at;

    public TablaBeneficiarios() {
    }

    public TablaBeneficiarios(int id, String nombre, String localidad, int id_obra, Timestamp created_at) {
        this.id = id;
        this.nombre = nombre;
        this.localidad = localidad;
        this.id_obra = id_obra;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getId_obra() {
        return id_obra;
    }

    public void setId_obra(int id_obra) {
        this.id_obra = id_obra;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "TablaBeneficiarios{" + "id=" + id + ", nombre=" + nombre + ", localidad=" + localidad + ", id_obra=" + id_obra + ", created_at=" + created_at + '}';
    }
    
    
}
