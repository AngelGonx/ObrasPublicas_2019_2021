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
public class TablaArchivos {
    private int id;
    private String archivo_uno;
    private String archivo_dos;
    private String archivo_tres;
    private String archivo_cuatro;
    private String archivo_cinco;
    private String archivo_seis;
    private String archivo_siete;
    private int id_obra;
    private Timestamp created_at;

    public TablaArchivos() {
    }
    
    public TablaArchivos(int id, String archivo_uno, String archivo_dos, String archivo_tres, String archivo_cuatro, String archivo_cinco, String archivo_seis, String archivo_siete, int id_obra, Timestamp created_at) {
        this.id = id;
        this.archivo_uno = archivo_uno;
        this.archivo_dos = archivo_dos;
        this.archivo_tres = archivo_tres;
        this.archivo_cuatro = archivo_cuatro;
        this.archivo_cinco = archivo_cinco;
        this.archivo_seis = archivo_seis;
        this.archivo_siete = archivo_siete;
        this.id_obra = id_obra;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArchivo_uno() {
        return archivo_uno;
    }

    public void setArchivo_uno(String archivo_uno) {
        this.archivo_uno = archivo_uno;
    }

    public String getArchivo_dos() {
        return archivo_dos;
    }

    public void setArchivo_dos(String archivo_dos) {
        this.archivo_dos = archivo_dos;
    }

    public String getArchivo_tres() {
        return archivo_tres;
    }

    public void setArchivo_tres(String archivo_tres) {
        this.archivo_tres = archivo_tres;
    }

    public String getArchivo_cuatro() {
        return archivo_cuatro;
    }

    public void setArchivo_cuatro(String archivo_cuatro) {
        this.archivo_cuatro = archivo_cuatro;
    }

    public String getArchivo_cinco() {
        return archivo_cinco;
    }

    public void setArchivo_cinco(String archivo_cinco) {
        this.archivo_cinco = archivo_cinco;
    }

    public String getArchivo_seis() {
        return archivo_seis;
    }

    public void setArchivo_seis(String archivo_seis) {
        this.archivo_seis = archivo_seis;
    }

    public String getArchivo_siete() {
        return archivo_siete;
    }

    public void setArchivo_siete(String archivo_siete) {
        this.archivo_siete = archivo_siete;
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
        return "TablaArchivos{" + "id=" + id + ", archivo_uno=" + archivo_uno + ", archivo_dos=" + archivo_dos + ", archivo_tres=" + archivo_tres + ", archivo_cuatro=" + archivo_cuatro + ", archivo_cinco=" + archivo_cinco + ", archivo_seis=" + archivo_seis + ", archivo_siete=" + archivo_siete + ", id_obra=" + id_obra + ", created_at=" + created_at + '}';
    }
    
}
