/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.Entidades.Matricula;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TONY
 */
public interface MatriculaDao {
     public int add(Matricula c) throws SQLException;
   
   Matricula getById(int idmatricula) throws SQLException;
   
   List<Matricula> getAll() throws SQLException;
   
   int update(Matricula c) throws SQLException;
   
   void delete(int idmatricula) throws SQLException;
   
   List<Matricula> buscar(String s) throws SQLException;
}
