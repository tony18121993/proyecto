/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.Entidades.Aula;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TONY
 */
public interface AulaDao {
    public int add(Aula c) throws SQLException;
   
   Aula getById(int id) throws SQLException;
   
   List<Aula> getAll() throws SQLException;
   
   int update(Aula c) throws SQLException;
   
   void delete(int id) throws SQLException;
   
   List<Aula> buscar(String s) throws SQLException;
}
