/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.Entidades.Curso;
import com.mycompany.crudjdbcdemo.Entidades.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TONY
 */
public interface UsuarioDAO {
    public int add(Usuario c) throws SQLException;
   
   Usuario getById(int id) throws SQLException;
   
   List<Usuario> getAll() throws SQLException;
   
   int update(int id,Usuario c) throws SQLException;
   
   void delete(int id) throws SQLException;
   
   boolean valida(String usuario,String password) throws SQLException;
}
