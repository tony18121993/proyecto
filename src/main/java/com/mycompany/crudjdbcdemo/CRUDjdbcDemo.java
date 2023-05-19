/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.crudjdbcdemo;

import com.mycompany.crudjdbcdemo.BD.MyDataSource;
import com.mycompany.crudjdbcdemo.Entidades.Curso;
import com.mycompany.crudjdbcdemo.Entidades.CursoAcademico;
import com.mycompany.crudjdbcdemo.Entidades.Unidad;
import com.mycompany.crudjdbcdemo.Entidades.Usuario;
import com.mycompany.crudjdbcdemo.controladorDAO.CursoAcademicoDAOimp;
import com.mycompany.crudjdbcdemo.controladorDAO.CursoDAOimp;
import com.mycompany.crudjdbcdemo.controladorDAO.UnidadDAOimp;
import com.mycompany.crudjdbcdemo.controladorDAO.UsuarioDaoimp;
import java.sql.Connection;


/**
 *
 * @author TONY
 */
public class CRUDjdbcDemo {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Connection cnlocal=MyDataSource.getConnection();
        Test();
        
        
        
        
    }
    public static void Test(){
    }
    
}
