/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.BD.MyDataSource;
import com.mycompany.crudjdbcdemo.Entidades.Alumno;
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
public class AlumnoDaoimp implements AlumnoDAO {
    
    private static AlumnoDaoimp instance;
    //este static es como el constructor de abajo solo se accede una vez
    static {
        instance=new AlumnoDaoimp();
    }
    
    private AlumnoDaoimp(){
       // instance=new CursoAcademicoDAOimp();
    }
    public static AlumnoDaoimp getInstance(){
        return instance;
    }
    @Override
    public int add(Alumno c) throws SQLException {
        String sql="insert into alumno(dni,nombre,apellido1,apellido2,fnacimiento,telefono,email,direccion,cp,poblacion,provincia) values(?,?,?,?,?,?,?,?,?,?,?) ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            //pstm.setInt(1, c.getId());
            pstm.setString(1,c.getDni());
            pstm.setString(2,c.getNombre());
            pstm.setString(3, c.getApellido1());
            pstm.setString(4,c.getApellido2());
            pstm.setString(5,c.getFnacimiento().toString());
            pstm.setString(6, c.getTelefono());
            pstm.setString(7,c.getEmail());
            pstm.setString(8,c.getDireccion());
            pstm.setString(9, c.getCp());
            pstm.setString(10,c.getPoblacion());
            pstm.setString(11,c.getProvincia());
            
        
            return pstm.executeUpdate();
        }
    }

    @Override
    public Alumno getById(int id) throws SQLException {
        String sql="Select * from alumno where id=?"; 
       Alumno c=new Alumno();
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
                c.setFnacimiento(rs.getDate("fnacimiento").toLocalDate());
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                c.setDireccion(rs.getString("direccion"));
                c.setCp(rs.getString("cp"));
                c.setPoblacion(rs.getString("poblacion"));
                c.setProvincia(rs.getString("provincia"));
            
            }
        }
      return c;
    }

    @Override
    public List<Alumno> getAll() throws SQLException {
        String sql="Select * from alumno "; 
    List<Alumno> badeDatos = new ArrayList<>();
       Alumno c;
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            ResultSet rs=pstm.executeQuery();
            
            while(rs.next()){
                c=new Alumno();
                c.setId(rs.getInt("id"));
                c.setId(rs.getInt("id"));
                c.setDni(rs.getString("dni"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido1(rs.getString("apellido1"));
                c.setApellido2(rs.getString("apellido2"));
                c.setFnacimiento(rs.getDate("fnacimiento").toLocalDate());
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                c.setDireccion(rs.getString("direccion"));
                c.setCp(rs.getString("cp"));
                c.setPoblacion(rs.getString("poblacion"));
                c.setProvincia(rs.getString("provincia"));
                badeDatos.add(c);
            }
            
        }
        return badeDatos;
    }

    @Override
    public int update(int id,Alumno c) throws SQLException {
        String sql="update alumno set dni=?,nombre=?,apellido1=?,apellido2=?,fnacimiento=?,telefono=?,email=?,direccion=?,cp=?,poblacion=?,provincia=? where id=? ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            
            pstm.setString(1,c.getDni());
            pstm.setString(2,c.getNombre());
            pstm.setString(3, c.getApellido1());
            pstm.setString(4,c.getApellido2());
            pstm.setString(5,c.getFnacimiento().toString());
            pstm.setString(6, c.getTelefono());
            pstm.setString(7,c.getEmail());
            pstm.setString(8,c.getDireccion());
            pstm.setString(9, c.getCp());
            pstm.setString(10,c.getPoblacion());
            pstm.setString(11,c.getProvincia());
            pstm.setInt(12, c.getId());
            return pstm.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
         String sql="delete from alumno where id=?;";
    try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         pstm.setInt(1,id);
         pstm.executeUpdate();
    }
    }

    @Override
    public List<Alumno> buscar(String s) throws SQLException {
        String sql="Select * from alumno where concat_ws(id,dni,nombre,apellido1,apellido2,fnacimiento,telefono,email,direccion,cp,poblacion,provincia) like %?%"; 
    List<Alumno> badeDatos = new ArrayList<>();
       Alumno c;
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setString(1, s);
            ResultSet rs=pstm.executeQuery();
            
            
            
            while(rs.next()){
                c=new Alumno();
                c.setId(rs.getInt("id"));
                c.setId(rs.getInt("id"));
                c.setDni(rs.getString("dni"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido1(rs.getString("apellido1"));
                c.setApellido2(rs.getString("apellido2"));
                c.setFnacimiento(rs.getDate("fnacimiento").toLocalDate());
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                c.setDireccion(rs.getString("direccion"));
                c.setCp(rs.getString("cp"));
                c.setPoblacion(rs.getString("poblacion"));
                c.setProvincia(rs.getString("provincia"));
                badeDatos.add(c);
            }
    }
        return badeDatos;
 }
}