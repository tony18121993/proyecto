/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.BD.MyDataSource;
import com.mycompany.crudjdbcdemo.Entidades.Personal;
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
public class PersonalDaoimp implements PersonalDao{
    private static PersonalDaoimp instance;
    //este static es como el constructor de abajo solo se accede una vez
    static {
        instance=new PersonalDaoimp();
    }
    
    private PersonalDaoimp(){
       // instance=new CursoAcademicoDAOimp();
    }
    public static PersonalDaoimp getInstance(){
        return instance;
    }
    @Override
    public int add(Personal c) throws SQLException {
        String sql="insert into personal(dni,nombre,apellido1,apellido2,direccion,cp,poblacion,provincia,telefono,email,tipo) values(?,?,?,?,?,?,?,?,?,?,?) ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            //pstm.setInt(1, c.getId());
            pstm.setString(1,c.getDni());
            pstm.setString(2, c.getNombre());
            pstm.setString(3,c.getApellido1());
            pstm.setString(4, c.getApellido2());
            pstm.setString(5, c.getDireccion());
            pstm.setString(6,c.getCp());
            pstm.setString(7, c.getPoblacion());
            pstm.setString(8,c.getProvincia());
            pstm.setString(9, c.getTelefono());
            pstm.setString(10, c.getEmail());
            pstm.setInt(11, c.getTipo());

            return pstm.executeUpdate();
        }
    }

    @Override
    public Personal getById(int id) throws SQLException {
        String sql="Select * from personal where id=?"; 
       Personal c=new Personal();
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
                c.setDireccion(rs.getString("direccion"));  
                c.setCp(rs.getString("cp"));
                c.setPoblacion(rs.getString("poblacion"));
                c.setProvincia(rs.getString("provincia"));
                c.setTelefono(rs.getString("telefono"));  
                c.setEmail(rs.getString("email"));
                c.setTipo(rs.getInt("tipo"));

            }
        }
      return c;
    }

    @Override
    public List<Personal> getAll() throws SQLException {
        String sql="Select * from personal "; 
        List<Personal> baseDatos = new ArrayList<>();
        Personal c;
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            ResultSet rs=pstm.executeQuery();
            
            while(rs.next()){
                c=new Personal();
                c.setId(rs.getInt("id"));
                c.setDni(rs.getString("dni"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido1(rs.getString("apellido1"));  
                c.setApellido2(rs.getString("apellido2"));
                c.setDireccion(rs.getString("direccion"));  
                c.setCp(rs.getString("cp"));
                c.setPoblacion(rs.getString("poblacion"));
                c.setProvincia(rs.getString("provincia"));
                c.setTelefono(rs.getString("telefono"));  
                c.setEmail(rs.getString("email"));
                c.setTipo(rs.getInt("tipo"));
                baseDatos.add(c);
            }
            
        }
        return baseDatos;
    }

    @Override
    public int update(int id,Personal c) throws SQLException {
        String sql="update personal set dni=?,nombre=?,apellido1=?,apellido2=?,direccion=?,cp=?,poblacion=?,provincia=?,telefono=?,email=?,tipo=? where id=? ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            
            pstm.setString(1,c.getDni());
            pstm.setString(2, c.getNombre());
            pstm.setString(3,c.getApellido1());
            pstm.setString(4, c.getApellido2());
            pstm.setString(5, c.getDireccion());
            pstm.setString(6,c.getCp());
            pstm.setString(7, c.getPoblacion());
            pstm.setString(8,c.getProvincia());
            pstm.setString(9, c.getTelefono());
            pstm.setString(10, c.getEmail());
            pstm.setInt(11, c.getTipo());
            pstm.setInt(12, c.getId());
            return pstm.executeUpdate();
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="delete from personal where id=?;";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setInt(1,id);
            pstm.executeUpdate();
        }
    }

    @Override
    public List<Personal> buscar(String s) throws SQLException {
        String sql="Select * from personal where concat_ws(dni,nombre,apellido1,apellido2,direccion,cp,poblacion,provincia,telefono,email,tipo) like '%?%'"; 
        List<Personal> badeDatos = new ArrayList<>();
        Personal c;
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setString(1, s);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                c=new Personal();
                c.setId(rs.getInt("id"));
                c.setDni(rs.getString("dni"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido1(rs.getString("apellido1"));  
                c.setApellido2(rs.getString("apellido2"));
                c.setDireccion(rs.getString("direccion"));  
                c.setCp(rs.getString("cp"));
                c.setPoblacion(rs.getString("poblacion"));
                c.setProvincia(rs.getString("provincia"));
                c.setTelefono(rs.getString("telefono"));  
                c.setEmail(rs.getString("email"));
                c.setTipo(rs.getInt("tipo"));
                badeDatos.add(c);
            }
    }
    return badeDatos;
    }
    
}
