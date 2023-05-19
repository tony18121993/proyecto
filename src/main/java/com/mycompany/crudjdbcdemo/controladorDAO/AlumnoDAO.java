/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.Entidades.Alumno;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TONY
 */
public interface AlumnoDAO {
    public int add(Alumno c) throws SQLException;
   
   Alumno getById(int id) throws SQLException;
   
   List<Alumno> getAll() throws SQLException;
   
   int update(int id,Alumno c) throws SQLException;
   
   void delete(int id) throws SQLException;
   
   List<Alumno> buscar(String s) throws SQLException;
}
