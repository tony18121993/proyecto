/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.BD.MyDataSource;
import com.mycompany.crudjdbcdemo.Entidades.Curso;
import com.mycompany.crudjdbcdemo.Entidades.CursoAcademico;
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
public class CursoDAOimp implements CursoDAO {
    
    private static CursoDAOimp instance;
    //este static es como el constructor de abajo solo se accede una vez
    static {
        instance=new CursoDAOimp();
    }
    
    private CursoDAOimp(){
       // instance=new CursoAcademicoDAOimp();
    }
    public static CursoDAOimp getInstance(){
        return instance;
    }
    
    
    @Override
    public int add(Curso c) throws SQLException {
        String sql="insert into curso (codigo,nombre,observaciones) values(?,?,?) ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            //pstm.setInt(1, c.getId());
            pstm.setString(1,c.getCodigo());
            pstm.setString(2,c.getNombre());
            pstm.setString(3, c.getObservaciones());
            return pstm.executeUpdate();
        }
        
    }

    @Override
    public Curso getById(int id) throws SQLException {
            String sql="Select * from curso where id=?"; 
       Curso cursoaca=new Curso();
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if(rs.next()){
                
                cursoaca.setId(rs.getInt("id"));
                cursoaca.setCodigo(rs.getString("codigo"));
                cursoaca.setNombre(rs.getString("nombre"));
                cursoaca.setObservaciones(rs.getString("observaciones"));
                cursoaca.setIdCursoAcademico(rs.getInt("IdCursoAcademico"));
                
            }
        }
      return cursoaca;
    }

    @Override
    public List<Curso> getAll() throws SQLException {
        String sql="Select * from curso "; 
    List<Curso> badeDatos = new ArrayList<>();
       Curso cursoaca;
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            ResultSet rs=pstm.executeQuery();
            
            while(rs.next()){
                cursoaca=new Curso();
                cursoaca.setId(rs.getInt("id"));
                cursoaca.setCodigo(rs.getString("codigo"));
                cursoaca.setNombre(rs.getString("nombre"));
                cursoaca.setObservaciones(rs.getString("observaciones"));
                cursoaca.setIdCursoAcademico(rs.getInt("idcursoacademico"));
                badeDatos.add(cursoaca);
            }
            
        }
        return badeDatos;
    }
    

    @Override
    public int update(int id, Curso c) throws SQLException {
    String sql="update curso set codigo=?,nombre=?,observaciones=? where id=? ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            
            pstm.setString(1,c.getCodigo());
            pstm.setString(2,c.getNombre());
            pstm.setString(3, c.getObservaciones());
            pstm.setInt(4, c.getId());
            return pstm.executeUpdate();
        }
}

    @Override
    public void delete(int id) throws SQLException {
        String sql="delete from curso where id=?;";
    try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         pstm.setInt(1,id);
         pstm.executeUpdate();
    }
    
}

    @Override
    public CursoAcademico getCursoAcademico(Curso cu) throws SQLException {
     return null;   
    }

    @Override
    public List<Curso> getAllbyCursoAcademico(int idcursoacademico) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
