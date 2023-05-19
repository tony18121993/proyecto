/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.Entidades.Autorizaciones;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TONY
 */
public interface AutorizacionesDao {
     public int add(Autorizaciones c) throws SQLException;
   
   Autorizaciones getById(int idalumno) throws SQLException;
   
   List<Autorizaciones> getAll() throws SQLException;
   
   int update(Autorizaciones c) throws SQLException;
   
   void delete(int idalumno) throws SQLException;
   
   List<Autorizaciones> buscar(String s) throws SQLException;
}
