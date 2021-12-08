/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Timestamp;
import java.util.logging.Logger;

/**
 *
 * @author josel
 */
public class TablaFotosBeneficiarios {
    /*
        Columns:
        id int AI PK 
        foto_uno longblob 
        foto_dos longblob 
        foto_tres longblob 
        foto_cuatro longblob 
        foto_cinco longblob 
        id_beneficiario int 
        created_at datetime
    */
    private int id;
    private String foto_uno;
    private String foto_dos;
    private String foto_tres;
    private String foto_cuatro;
    private String foto_cinco;
    private int id_beneficiario;
    private Timestamp created_at;

    public TablaFotosBeneficiarios() {
    }

    public TablaFotosBeneficiarios(int id, String foto_uno, String foto_dos, String foto_tres, String foto_cuatro, String foto_cinco, int id_beneficiario, Timestamp created_at) {
        this.id = id;
        this.foto_uno = foto_uno;
        this.foto_dos = foto_dos;
        this.foto_tres = foto_tres;
        this.foto_cuatro = foto_cuatro;
        this.foto_cinco = foto_cinco;
        this.id_beneficiario = id_beneficiario;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoto_uno() {
        return foto_uno;
    }

    public void setFoto_uno(String foto_uno) {
        this.foto_uno = foto_uno;
    }

    public String getFoto_dos() {
        return foto_dos;
    }

    public void setFoto_dos(String foto_dos) {
        this.foto_dos = foto_dos;
    }

    public String getFoto_tres() {
        return foto_tres;
    }

    public void setFoto_tres(String foto_tres) {
        this.foto_tres = foto_tres;
    }

    public String getFoto_cuatro() {
        return foto_cuatro;
    }

    public void setFoto_cuatro(String foto_cuatro) {
        this.foto_cuatro = foto_cuatro;
    }

    public String getFoto_cinco() {
        return foto_cinco;
    }

    public void setFoto_cinco(String foto_cinco) {
        this.foto_cinco = foto_cinco;
    }

    public int getId_beneficiario() {
        return id_beneficiario;
    }

    public void setId_beneficiario(int id_beneficiario) {
        this.id_beneficiario = id_beneficiario;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "TablaFotosBeneficiarios{" + "id=" + id + ", foto_uno=" + foto_uno + ", foto_dos=" + foto_dos + ", foto_tres=" + foto_tres + ", foto_cuatro=" + foto_cuatro + ", foto_cinco=" + foto_cinco + ", id_beneficiario=" + id_beneficiario + ", created_at=" + created_at + '}';
    }
}
