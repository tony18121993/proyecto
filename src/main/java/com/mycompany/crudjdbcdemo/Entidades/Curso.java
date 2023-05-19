/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudjdbcdemo.Entidades;

/**
 *
 * @author TONY
 */
public class Curso {
    private int id;
    private String codigo;
    private String nombre;
    private String observaciones;
    private int idCursoAcademico;
    
    public Curso() {
    }

    public Curso(String codigo, String nombre, String observaciones,int idCursoAcademico) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.observaciones = observaciones;
        this.idCursoAcademico=idCursoAcademico;
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", observaciones=" + observaciones + ", idCursoAcademico=" + idCursoAcademico + '}';
    }

    

    public int getIdCursoAcademico() {
        return idCursoAcademico;
    }

    public void setIdCursoAcademico(int idCursoAcademico) {
        this.idCursoAcademico = idCursoAcademico;
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
        final Curso other = (Curso) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        return this.idCursoAcademico == other.idCursoAcademico;
    }

   

   
    

    
    
    
    
}
