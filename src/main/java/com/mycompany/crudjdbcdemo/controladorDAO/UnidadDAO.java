/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.Entidades.Unidad;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TONY
 */
public interface UnidadDAO {
    public int add(Unidad c) throws SQLException;
   
   Unidad getById(int id) throws SQLException;
   
   List<Unidad> getAll() throws SQLException;
   
   int update(int id,Unidad c) throws SQLException;
   
   void delete(int id) throws SQLException;
}
