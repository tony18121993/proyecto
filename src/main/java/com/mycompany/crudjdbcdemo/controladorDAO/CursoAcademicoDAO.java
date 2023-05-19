/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.Entidades.CursoAcademico;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TONY
 */
public interface CursoAcademicoDAO {
   public int add(CursoAcademico c) throws SQLException;
   
   CursoAcademico getById(int id) throws SQLException;
   
   List<CursoAcademico> getAll() throws SQLException;
   
   int update(int i,CursoAcademico c) throws SQLException;
   
   void delete(int id) throws SQLException;
   
   List<CursoAcademico> buscar(String s) throws SQLException;
   
}
