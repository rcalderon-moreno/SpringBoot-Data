
package com.example.entidades;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Persona {
    private Integer id;
    private String nombres;
    private String apellidos;

    public Persona() {
    }

    public Persona(Integer id, String nombres, String apellidos) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
}
