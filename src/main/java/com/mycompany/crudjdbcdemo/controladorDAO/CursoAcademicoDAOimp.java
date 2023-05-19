/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.BD.MyDataSource;
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
public class CursoAcademicoDAOimp implements CursoAcademicoDAO {
    
    private static CursoAcademicoDAOimp instance;
    //este static es como el constructor de abajo solo se accede una vez
    static {
        instance=new CursoAcademicoDAOimp();
    }
    
    private CursoAcademicoDAOimp(){
       // instance=new CursoAcademicoDAOimp();
    }
    public static CursoAcademicoDAOimp getInstance(){
        return instance;
    }
    
    @Override
    public int add(CursoAcademico c) throws SQLException {
        String sql="insert into cursoacademico(yearinicio,yearfin,descripcion) values(?,?,?) ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            //pstm.setInt(1, c.getId());
            pstm.setInt(1,c.getYearinicio());
            pstm.setInt(2,c.getYearfin());
            pstm.setString(3, c.getDescripcion());
            return pstm.executeUpdate();
        }
        
    }

    @Override
    public CursoAcademico getById(int id) throws SQLException {
       String sql="Select * from cursoacademico where id=?"; 
       CursoAcademico cursoaca=new CursoAcademico();
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if(rs.next()){
                
                cursoaca.setId(rs.getInt("id"));
                cursoaca.setYearinicio(rs.getInt("yearinicio"));
                cursoaca.setYearfin(rs.getInt("yearfin"));
                cursoaca.setDescripcion(rs.getString("descripcion"));
                
            }
        }
      return cursoaca;
    }

    @Override
    public List<CursoAcademico> getAll() throws SQLException {
    String sql="Select * from cursoacademico order by yearinicio desc"; 
    List<CursoAcademico> badeDatos = new ArrayList<>();
       CursoAcademico cursoaca;
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            ResultSet rs=pstm.executeQuery();
            
            while(rs.next()){
                cursoaca=new CursoAcademico();
                cursoaca.setId(rs.getInt("id"));
                cursoaca.setYearinicio(rs.getInt("yearinicio"));
                cursoaca.setYearfin(rs.getInt("yearfin"));
                cursoaca.setDescripcion(rs.getString("descripcion"));
                badeDatos.add(cursoaca);
            }
            
        }
        return badeDatos;
    }

    @Override
    public int update(int id,CursoAcademico c) throws SQLException {
        String sql="update cursoacademico set yearinicio=?,yearfin=?,descripcion=? where id=? ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            
            pstm.setInt(1,c.getYearinicio());
            pstm.setInt(2,c.getYearfin());
            pstm.setString(3, c.getDescripcion());
            pstm.setInt(4, c.getId());
            return pstm.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="delete from cursoacademico where id=?;";
    try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         pstm.setInt(1,id);
         pstm.executeUpdate();
    }
    }

    @Override
    public List<CursoAcademico> buscar(String s) throws SQLException {
        String sql="Select * from cursoacademico where concat_ws(id,yearinicio,yearfin,descripcion) like '%?%'"; 
    List<CursoAcademico> badeDatos = new ArrayList<>();
       CursoAcademico cursoaca;
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setString(1, s);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                cursoaca=new CursoAcademico();
                cursoaca.setId(rs.getInt("id"));
                cursoaca.setYearinicio(rs.getInt("yearinicio"));
                cursoaca.setYearfin(rs.getInt("yearfin"));
                cursoaca.setDescripcion(rs.getString("descripcion"));
                badeDatos.add(cursoaca);
            }
    }
    return badeDatos;
}
}