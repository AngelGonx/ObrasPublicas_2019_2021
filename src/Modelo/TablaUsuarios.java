/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Timestamp;
import java.util.logging.Logger;

/**
 * @see Modelo TablaUsuarios
 * @author josel
 * @since 05/11/2021
 * @param 
 *   id int AI PK 
 *   name varchar(45) 
 *   username varchar(45) 
 *   password varchar(45) 
 *   created_at datetime
 */
public class TablaUsuarios {
    private int  id;
    private String name;
    private String username;
    private String password;
    private Timestamp created_at;

    public TablaUsuarios(int id, String name, String username, String password, Timestamp created_at) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.created_at = created_at;
    }

    public TablaUsuarios() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "TablaUsuarios{" + "id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", created_at=" + created_at + '}';
    }
    
}
