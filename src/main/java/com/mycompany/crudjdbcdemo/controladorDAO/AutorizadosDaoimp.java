/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.BD.MyDataSource;
import com.mycompany.crudjdbcdemo.Entidades.Autorizados;
import com.mycompany.crudjdbcdemo.Entidades.Parentesco;
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
public class AutorizadosDaoimp implements AutorizadosDao {
    private static AutorizadosDaoimp instance;
    //este static es como el constructor de abajo solo se accede una vez
    static {
        instance=new AutorizadosDaoimp();
    }
    
    private AutorizadosDaoimp(){
       // instance=new CursoAcademicoDAOimp();
    }
    public static AutorizadosDaoimp getInstance(){
        return instance;
    }
    @Override
    public int add(Autorizados c) throws SQLException {
        String sql="insert into autorizado(dni,nombre,apellido1,apellido2,parentesco) values(?,?,?,?,?) ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            //pstm.setInt(1, c.getId());
            pstm.setString(1,c.getDni());
            pstm.setString(2, c.getNombre());
            pstm.setString(3,c.getApellido1());
            pstm.setString(4, c.getApellido2());
            pstm.setString(5, c.getParentesco().toString());

            return pstm.executeUpdate();
        }
    }

    @Override
    public Autorizados getById(int id) throws SQLException {
        String sql="Select * from autorizado where id=?"; 
       Autorizados c=new Autorizados();
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if(rs.next()){
                
                c.setId(rs.getInt("id"));
                c.setDni(rs.getString("dni"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido1(rs.getString("apellido1"));  
                c.setApellido2(rs.getString("apellido2"));
                c.setParentesco((Parentesco)rs.getObject("parentesco"));
                
            }
        }
      return c;
    }

    @Override
    public List<Autorizados> getAll() throws SQLException {
        String sql="Select * from autorizado "; 
        List<Autorizados> badeDatos = new ArrayList<>();
        Autorizados c;
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            ResultSet rs=pstm.executeQuery();
            
            while(rs.next()){
                c=new Autorizados();
                c.setId(rs.getInt("id"));
                c.setDni(rs.getString("dni"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido1(rs.getString("apellido1"));  
                c.setApellido2(rs.getString("apellido2"));
                System.out.println("que dices");
                c.setParentesco((Parentesco.valueOf(rs.getString("parentesco"))));
                System.out.println("hola");
                badeDatos.add(c);
            }
            
        }
        return badeDatos;
    }

    @Override
    public int update(int id,Autorizados c) throws SQLException {
        String sql="update autorizado set dni=?,nombre=?,apellido1=?,apellido2=?,parentesco=? where id=? ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            
            pstm.setString(1,c.getDni());
            pstm.setString(2, c.getNombre());
            pstm.setString(3,c.getApellido1());
            pstm.setString(4, c.getApellido2());
            pstm.setString(5, c.getParentesco().toString());
            pstm.setInt(6, c.getId());
            return pstm.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="delete from autorizado where id=?;";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setInt(1,id);
            pstm.executeUpdate();
        }
    }

    @Override
    public List<Autorizados> buscar(String s) throws SQLException {
        String sql="Select * from autorizado where concat_ws(id,dni,nombre,apellido1,apellido2,parentesco) like '%?%'"; 
        List<Autorizados> badeDatos = new ArrayList<>();
        Autorizados c;
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setString(1, s);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                c=new Autorizados();
                c.setId(rs.getInt("id"));
                c.setDni(rs.getString("dni"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido1(rs.getString("apellido1"));  
                c.setApellido2(rs.getString("apellido2"));
                c.setParentesco((Parentesco)rs.getObject("parentesco"));
                badeDatos.add(c);
            }
    }
    return badeDatos;
    }
    
}
