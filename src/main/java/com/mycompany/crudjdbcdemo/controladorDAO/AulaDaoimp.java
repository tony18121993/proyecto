/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.BD.MyDataSource;
import com.mycompany.crudjdbcdemo.Entidades.Aula;
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
public class AulaDaoimp implements AulaDao {
    private static AulaDaoimp instance;
    //este static es como el constructor de abajo solo se accede una vez
    static {
        instance=new AulaDaoimp();
    }
    
    private AulaDaoimp(){
       // instance=new CursoAcademicoDAOimp();
    }
    public static AulaDaoimp getInstance(){
        return instance;
    }
    @Override
    public int add(Aula c) throws SQLException {
        String sql="insert into aula(codigo,descripcion) values(?,?) ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            //pstm.setInt(1, c.getId());
            pstm.setString(1,c.getCodigo());
            pstm.setString(2, c.getDescripcion());
            return pstm.executeUpdate();
        }
    }

    @Override
    public Aula getById(int id) throws SQLException {
        String sql="Select * from aula where id=?"; 
       Aula c=new Aula();
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if(rs.next()){
                
                c.setId(rs.getInt("id"));
                c.setCodigo(rs.getString("codigo"));
                c.setDescripcion(rs.getString("descripcion"));
                
            }
        }
      return c;
    }

    @Override
    public List<Aula> getAll() throws SQLException {
        String sql="Select * from aula "; 
        List<Aula> badeDatos = new ArrayList<>();
        Aula cursoaca;
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            ResultSet rs=pstm.executeQuery();
            
            while(rs.next()){
                cursoaca=new Aula();
                cursoaca.setId(rs.getInt("id"));
                cursoaca.setCodigo(rs.getString("codigo"));
                cursoaca.setDescripcion(rs.getString("descripcion"));
                badeDatos.add(cursoaca);
            }
            
        }
        return badeDatos;
    }

    @Override
    public int update(Aula c) throws SQLException {
        String sql="update aula set codigo=?,descripcion=? where id=? ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            
            pstm.setString(1,c.getCodigo());
            pstm.setString(2, c.getDescripcion());
            pstm.setInt(3, c.getId());
            return pstm.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="delete from aula where id=?;";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setInt(1,id);
            pstm.executeUpdate();
        }
    }

    @Override
    public List<Aula> buscar(String s) throws SQLException {
        String sql="Select * from aula where concat_ws(id,codigo,descripcion) like '%?%'"; 
        List<Aula> badeDatos = new ArrayList<>();
        Aula cursoaca;
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setString(1, s);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                cursoaca=new Aula();
                cursoaca.setId(rs.getInt("id"));
                cursoaca.setCodigo(rs.getString("codigo"));
                cursoaca.setDescripcion(rs.getString("descripcion"));
                badeDatos.add(cursoaca);
            }
    }
    return badeDatos;
    }
    
}
