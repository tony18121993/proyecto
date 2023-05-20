/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.BD.MyDataSource;
import com.mycompany.crudjdbcdemo.Entidades.Matricula;
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
public class MatriculaDaoimp implements MatriculaDao {
     private static MatriculaDaoimp instance;
    //este static es como el constructor de abajo solo se accede una vez
    static {
        instance=new MatriculaDaoimp();
    }
    
    private MatriculaDaoimp(){
       // instance=new CursoAcademicoDAOimp();
    }
    public static MatriculaDaoimp getInstance(){
        return instance;
    }
    @Override
    public int add(Matricula c) throws SQLException {
        String sql="insert into matricula(idalumno,idunidad,descripcion,FMatricula) values(?,?,?,?) ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            //pstm.setInt(1, c.getId());
            pstm.setInt(1,c.getIdalumno());
            pstm.setInt(2, c.getIdunidad());
            pstm.setString(3,c.getDescripcion());
            pstm.setDate(4, c.getFMatricula());
            

            return pstm.executeUpdate();
        }
    }

    @Override
    public Matricula getById(int idmatricula) throws SQLException {
        String sql="Select * from matricula where idmatricula=?"; 
       Matricula c=new Matricula();
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, idmatricula);
            
            ResultSet rs=pstm.executeQuery();
            
            if(rs.next()){
                
                c.setIdmatricula(rs.getInt("idmatricula"));
                c.setIdalumno(rs.getInt("idalumno"));
                c.setIdunidad(rs.getInt("idunidad"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setFMatricula(rs.getDate("FMatricula"));
                
            }
        }
      return c;
    }

    @Override
    public List<Matricula> getAll() throws SQLException {
        String sql="Select * from matricula "; 
        List<Matricula> badeDatos = new ArrayList<>();
        Matricula c;
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            ResultSet rs=pstm.executeQuery();
            
            while(rs.next()){
                c=new Matricula();
                c.setIdmatricula(rs.getInt("idmatricula"));
                c.setIdalumno(rs.getInt("idalumno"));
                c.setIdunidad(rs.getInt("idunidad"));
                c.setDescripcion(rs.getString("descripcion"));  
                c.setFMatricula(rs.getDate("FMatricula"));

                badeDatos.add(c);
            }
            
        }
        return badeDatos;
    }

    @Override
    public int update(int id,Matricula c) throws SQLException {
        String sql="update matricula set idalumno=?,idunidad=?,descripcion=?,FMAtricula=? where idmatricula=? ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            
            pstm.setInt(1,c.getIdalumno());
            pstm.setInt(2, c.getIdunidad());
            pstm.setString(3,c.getDescripcion());
            pstm.setString(4, c.getFMatricula().toString());
            pstm.setInt(5,id);
            return pstm.executeUpdate();
        }
    }
    public int updateBaja(int id,Matricula c) throws SQLException {
        String sql="update matricula set idalumno=?,idunidad=?,descripcion=?,FMAtricula=?,fBaja=? where idmatricula=? ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            
            pstm.setInt(1,c.getIdalumno());
            pstm.setInt(2, c.getIdunidad());
            pstm.setString(3,c.getDescripcion());
            pstm.setString(4, c.getFMatricula().toString());
            pstm.setString(5,c.getFBaja().toString());
            pstm.setInt(6,id);
            return pstm.executeUpdate();
        }
    }

    @Override
    public void delete(int idmatricula) throws SQLException {
        String sql="delete from matricula where idmatricula=?;";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setInt(1,idmatricula);
            pstm.executeUpdate();
        }
    }

    @Override
    public List<Matricula> buscar(String s) throws SQLException {
        String sql="Select * from matricula where concat_ws(idmatricula,idalumno,idunidad,descripcion) like '%?%'"; 
        List<Matricula> badeDatos = new ArrayList<>();
        Matricula c;
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setString(1, s);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                c=new Matricula();
                c.setIdmatricula(rs.getInt("idmatricula"));
                c.setIdalumno(rs.getInt("idalumno"));
                c.setIdunidad(rs.getInt("idunidad"));
                c.setDescripcion(rs.getString("descripcion"));  
                c.setFMatricula(rs.getDate("FMAtricula"));
                badeDatos.add(c);
            }
    }
    return badeDatos;
    }
    
}
