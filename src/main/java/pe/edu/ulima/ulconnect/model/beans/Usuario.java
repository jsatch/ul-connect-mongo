/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.ulima.ulconnect.model.beans;

/**
 *
 * @author hquintana
 */
public class Usuario {
    private String codigo;
    private String nombre;
    private String password;
    private Perfil perfil;
    private Carrera carrera;

    public Usuario(String codigo, String nombre, String password, Perfil perfil, Carrera carrera) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.password = password;
        this.perfil = perfil;
        this.carrera = carrera;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    
}
