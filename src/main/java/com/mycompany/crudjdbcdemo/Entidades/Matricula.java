/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudjdbcdemo.Entidades;

import java.sql.Date;

/**
 *
 * @author TONY
 */
public class Matricula {
    private int idmatricula;
    private int idalumno;
    private int idunidad;
    private String descripcion;
    private Date FMatricula;
    private Date FBaja;

    public Matricula() {
    }

    public Matricula(int idmatricula, int idalumno, int idunidad) {
        this.idmatricula = idmatricula;
        this.idalumno = idalumno;
        this.idunidad = idunidad;
    }

    public int getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(int idmatricula) {
        this.idmatricula = idmatricula;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public int getIdunidad() {
        return idunidad;
    }

    public void setIdunidad(int idunidad) {
        this.idunidad = idunidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Matricula other = (Matricula) obj;
        if (this.idmatricula != other.idmatricula) {
            return false;
        }
        if (this.idalumno != other.idalumno) {
            return false;
        }
        return this.idunidad == other.idunidad;
    }

    public Date getFMatricula() {
        return FMatricula;
    }

    public void setFMatricula(Date FMatricula) {
        this.FMatricula = FMatricula;
    }

    public Date getFBaja() {
        return FBaja;
    }

    public void setFBaja(Date FBaja) {
        this.FBaja = FBaja;
    }

    @Override
    public String toString() {
        return "Matricula{" + "idmatricula=" + idmatricula + ", idalumno=" + idalumno + ", idunidad=" + idunidad + ", descripcion=" + descripcion + ", FMatricula=" + FMatricula + ", FBaja=" + FBaja + '}';
    }
}
