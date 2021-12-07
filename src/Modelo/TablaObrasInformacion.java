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
public class TablaObrasInformacion {
    /*
    id int AI PK 
    obra varchar(60) 
    localidad varchar(45) 
    fondo varchar(45) 
    folio varchar(45) 
    numero varchar(45) 
    inicio varchar(45) 
    fin varchar(45) 
    age int 
    id_tipo_obra int 
    created_at datetime
    */
    private int id;
    private String obra;
    private String localidad;
    private String fondo;
    private String folio;
    private String numero;
    private String inicio;
    private String fin;
    private int age;
    private int id_tipo_obra;
    private Timestamp created_at;

    public TablaObrasInformacion() {
    }

    public TablaObrasInformacion(int id, String obra, String localidad, String fondo, String folio, String numero, String inicio, String fin, int age, int id_tipo_obra, Timestamp created_at) {
        this.id = id;
        this.obra = obra;
        this.localidad = localidad;
        this.fondo = fondo;
        this.folio = folio;
        this.numero = numero;
        this.inicio = inicio;
        this.fin = fin;
        this.age = age;
        this.id_tipo_obra = id_tipo_obra;
        this.created_at = created_at;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObra() {
        return obra;
    }

    public void setObra(String obra) {
        this.obra = obra;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getFondo() {
        return fondo;
    }

    public void setFondo(String fondo) {
        this.fondo = fondo;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId_tipo_obra() {
        return id_tipo_obra;
    }

    public void setId_tipo_obra(int id_tipo_obra) {
        this.id_tipo_obra = id_tipo_obra;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "TablaObrasInformacion{" + "id=" + id + ", obra=" + obra + ", localidad=" + localidad + ", fondo=" + fondo + ", folio=" + folio + ", numero=" + numero + ", inicio=" + inicio + ", fin=" + fin + ", age=" + age + ", id_tipo_obra=" + id_tipo_obra + ", created_at=" + created_at + '}';
    }
    
    
    
}
