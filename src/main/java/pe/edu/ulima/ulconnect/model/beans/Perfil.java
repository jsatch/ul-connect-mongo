/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.ulima.ulconnect.model.beans;

import org.bson.types.ObjectId;

/**
 *
 * @author hquintana
 */
public class Perfil {
    private ObjectId id;
    private String nombre;

    public Perfil(ObjectId id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
