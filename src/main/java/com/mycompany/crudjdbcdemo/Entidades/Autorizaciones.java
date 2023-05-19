/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudjdbcdemo.Entidades;

/**
 *
 * @author TONY
 */
public class Autorizaciones {
    private int idalumno;
    private int idautorizado;

    public Autorizaciones() {
    }

    public Autorizaciones(int idalumno, int idautorizado) {
        this.idalumno = idalumno;
        this.idautorizado = idautorizado;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public int getIdautorizado() {
        return idautorizado;
    }

    public void setIdautorizado(int idautorizado) {
        this.idautorizado = idautorizado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Autorizaciones other = (Autorizaciones) obj;
        if (this.idalumno != other.idalumno) {
            return false;
        }
        return this.idautorizado == other.idautorizado;
    }

    @Override
    public String toString() {
        return "Autorizaciones{" + "idalumno=" + idalumno + ", idautorizado=" + idautorizado + '}';
    }
    
    
}
