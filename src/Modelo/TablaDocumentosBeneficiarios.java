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
public class TablaDocumentosBeneficiarios {
    
    private int id;
    private String doc_uno;
    private String doc_dos;
    private String doc_tres;
    private String doc_cuatro;
    private String doc_cinco;
    private int id_beneficiario;
    private Timestamp created_at;

    public TablaDocumentosBeneficiarios() {
    }

    public TablaDocumentosBeneficiarios(int id, String doc_uno, String doc_dos, String doc_tres, String doc_cuatro, String doc_cinco, int id_beneficiario, Timestamp created_at) {
        this.id = id;
        this.doc_uno = doc_uno;
        this.doc_dos = doc_dos;
        this.doc_tres = doc_tres;
        this.doc_cuatro = doc_cuatro;
        this.doc_cinco = doc_cinco;
        this.id_beneficiario = id_beneficiario;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoc_uno() {
        return doc_uno;
    }

    public void setDoc_uno(String doc_uno) {
        this.doc_uno = doc_uno;
    }

    public String getDoc_dos() {
        return doc_dos;
    }

    public void setDoc_dos(String doc_dos) {
        this.doc_dos = doc_dos;
    }

    public String getDoc_tres() {
        return doc_tres;
    }

    public void setDoc_tres(String doc_tres) {
        this.doc_tres = doc_tres;
    }

    public String getDoc_cuatro() {
        return doc_cuatro;
    }

    public void setDoc_cuatro(String doc_cuatro) {
        this.doc_cuatro = doc_cuatro;
    }

    public String getDoc_cinco() {
        return doc_cinco;
    }

    public void setDoc_cinco(String doc_cinco) {
        this.doc_cinco = doc_cinco;
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
        return "TablaDocumentosBeneficiarios{" + "id=" + id + ", doc_uno=" + doc_uno + ", doc_dos=" + doc_dos + ", doc_tres=" + doc_tres + ", doc_cuatro=" + doc_cuatro + ", doc_cinco=" + doc_cinco + ", id_beneficiario=" + id_beneficiario + ", created_at=" + created_at + '}';
    }
    
    
    
}
