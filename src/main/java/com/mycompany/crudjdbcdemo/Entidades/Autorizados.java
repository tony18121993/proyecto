/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudjdbcdemo.Entidades;

import java.util.Objects;

/**
 *
 * @author TONY
 */
public class Autorizados {
    private int id;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Parentesco parentesco;

    public Autorizados() {
    }

    public Autorizados(String dni, String nombre, String apellido1, String apellido2, Parentesco parentesco) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.parentesco = parentesco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autorizados other = (Autorizados) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return this.parentesco == other.parentesco;
    }

    @Override
    public String toString() {
        return "Autorizados{" + "id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", parentesco=" + parentesco + '}';
    }
    
    
}
