/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.BD.MyDataSource;
import com.mycompany.crudjdbcdemo.Entidades.Unidad;
import com.mycompany.crudjdbcdemo.Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TONY
 */
public class UsuarioDaoimp implements UsuarioDAO {
    private static UsuarioDaoimp instance;
    //este static es como el constructor de abajo solo se accede una vez
    static {
        instance=new UsuarioDaoimp();
    }
    public static UsuarioDaoimp getInstance(){
        return instance;
    }
    @Override
    public int add(Usuario c) throws SQLException {
        String sql="insert into usuario(id,usuario,password) values(?,?,?) ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            //pstm.setInt(1, c.getId());
            pstm.setInt(1,c.getId());
            pstm.setString(2,c.getUsuario());
            pstm.setString(3, c.getPassword());
       
            return pstm.executeUpdate();
    }
    }
    @Override
    public Usuario getById(int id) throws SQLException {
        String sql="Select * from usuario where id=?"; 
        Usuario cursoaca=new Usuario();
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if(rs.next()){
                
                cursoaca.setId(rs.getInt("id"));
                cursoaca.setUsuario(rs.getString("Usuario"));
                cursoaca.setPassword(rs.getString("Password"));
                
            }
        }
      return cursoaca;
    }

    @Override
    public List<Usuario> getAll() throws SQLException {
        String sql="Select * from usuario "; 
        List<Usuario> badeDatos = new ArrayList<>();
        Usuario cursoaca;
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            ResultSet rs=pstm.executeQuery();
            
            while(rs.next()){
                cursoaca=new Usuario(rs.getString("usuario"),rs.getString("password"));
                cursoaca.setId(rs.getInt("id"));
                /*cursoaca.setId(rs.getInt("id"));
                cursoaca.setUsuario(rs.getString("usuario"));
                cursoaca.setPassword(rs.getString("password"));*/
                badeDatos.add(cursoaca);
                
            }
            
        }
        return badeDatos;
    }

    @Override
    public int update(int id, Usuario c) throws SQLException {
        String sql="update usuario set usuario=?,password=? where id=? ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            
            pstm.setString(1,c.getUsuario());
            pstm.setString(2,c.getPassword());
            pstm.setInt(3, id);
            return pstm.executeUpdate();
    }
    }
    @Override
    public void delete(int id) throws SQLException {
        String sql="delete from usuario where id=?;";
    try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         pstm.setInt(1,id);
         pstm.executeUpdate();
    }
    }
    @Override
    public boolean valida(String usuario, String password) throws SQLException {
        String sql="Select * from usuario  where usuario=? and password=?"; 
        
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setString(1, usuario);
            pstm.setString(2, password);
                
            ResultSet rs=pstm.executeQuery();
            
            if(rs.next()){
                return true;
            }
            
        }
        return false;
    }
    
}
