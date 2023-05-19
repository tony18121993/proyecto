/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.Entidades.Personal;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TONY
 */
public interface PersonalDao {
     public int add(Personal c) throws SQLException;
   
   Personal getById(int id) throws SQLException;
   
   List<Personal> getAll() throws SQLException;
   
   int update(int id,Personal c) throws SQLException;
   
   void delete(int id) throws SQLException;
   
   List<Personal> buscar(String s) throws SQLException;
}
