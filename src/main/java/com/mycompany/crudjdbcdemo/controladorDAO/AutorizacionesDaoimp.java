/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.BD.MyDataSource;
import com.mycompany.crudjdbcdemo.Entidades.Autorizaciones;
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
public class AutorizacionesDaoimp implements AutorizacionesDao {
    private static AutorizacionesDaoimp instance;
    //este static es como el constructor de abajo solo se accede una vez
    static {
        instance=new AutorizacionesDaoimp();
    }
    
    private AutorizacionesDaoimp(){
       // instance=new CursoAcademicoDAOimp();
    }
    public static AutorizacionesDaoimp getInstance(){
        return instance;
    }
    @Override
    public int add(Autorizaciones c) throws SQLException {
        String sql="insert into autorizaciones(idalumno,idautorizado) values(?,?) ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            //pstm.setInt(1, c.getId());
            pstm.setInt(1,c.getIdalumno());
            pstm.setInt(2, c.getIdautorizado());
            

            return pstm.executeUpdate();
        }
    }

    @Override
    public Autorizaciones getById(int idalumno) throws SQLException {
        String sql="Select * from autorizaciones where idalumno=?"; 
       Autorizaciones c=new Autorizaciones();
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, idalumno);
            
            ResultSet rs=pstm.executeQuery();
            
            if(rs.next()){
                
                c.setIdalumno(rs.getInt("id"));
                c.setIdautorizado(rs.getInt("dni"));
            }
        }
      return c;
    }

    @Override
    public List<Autorizaciones> getAll() throws SQLException {
        String sql="Select * from autorizaciones "; 
        List<Autorizaciones> badeDatos = new ArrayList<>();
        Autorizaciones c;
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            ResultSet rs=pstm.executeQuery();
            
            while(rs.next()){
                c=new Autorizaciones();
                c.setIdalumno(rs.getInt("id"));
                c.setIdautorizado(rs.getInt("dni"));
                
                badeDatos.add(c);
            }
        }return badeDatos;
    }

   

    @Override
    public int update(Autorizaciones c) throws SQLException {
        String sql="update autorizaciones set idautorizado=? where idalumno=? ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, c.getIdautorizado());
            pstm.setInt(2,c.getIdalumno());
            
            
            return pstm.executeUpdate();
        }
    }

    @Override
    public void delete(int idalumno) throws SQLException {
        String sql="delete from autorizaciones where idalumno=?;";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setInt(1,idalumno);
            pstm.executeUpdate();
        }
    }

    @Override
    public List<Autorizaciones> buscar(String s) throws SQLException {
        String sql="Select * from autorizados where concat_ws(idalumo,idautorizado) like '%?%'"; 
        List<Autorizaciones> badeDatos = new ArrayList<>();
        Autorizaciones c;
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setString(1, s);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                c=new Autorizaciones();
                c.setIdalumno(rs.getInt("id"));
                c.setIdautorizado(rs.getInt("dni"));
               
                badeDatos.add(c);
            }
    }
    return badeDatos;
    }
    
}
