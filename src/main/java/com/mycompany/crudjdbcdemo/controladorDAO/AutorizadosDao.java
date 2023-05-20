/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.Entidades.Autorizados;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TONY
 */
public interface AutorizadosDao {
    public int add(Autorizados c) throws SQLException;
   
   Autorizados getById(int id) throws SQLException;
   
   List<Autorizados> getAll() throws SQLException;
   
   int update(int id,Autorizados c) throws SQLException;
   
   void delete(int id) throws SQLException;
   
   List<Autorizados> buscar(String s) throws SQLException;
}
