/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.Entidades.Curso;
import com.mycompany.crudjdbcdemo.Entidades.CursoAcademico;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TONY
 */
public interface CursoDAO {
    public int add(Curso c) throws SQLException;
   
   Curso getById(int id) throws SQLException;
   
   List<Curso> getAll() throws SQLException;
   
   int update(int id,Curso c) throws SQLException;
   
   void delete(int id) throws SQLException;
   
   CursoAcademico getCursoAcademico(Curso cu)throws SQLException;
   
   List<Curso> getAllbyCursoAcademico(int idcursoacademico) throws SQLException;
}
