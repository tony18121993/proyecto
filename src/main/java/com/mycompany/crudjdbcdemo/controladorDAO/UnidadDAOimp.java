/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudjdbcdemo.controladorDAO;

import com.mycompany.crudjdbcdemo.BD.MyDataSource;
import com.mycompany.crudjdbcdemo.Entidades.Unidad;
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
public class UnidadDAOimp implements UnidadDAO {
    
    private static UnidadDAOimp instance;
    //este static es como el constructor de abajo solo se accede una vez
    static {
        instance=new UnidadDAOimp();
    }
    
    private UnidadDAOimp(){
       // instance=new CursoAcademicoDAOimp();
    }
    public static UnidadDAOimp getInstance(){
        return instance;
    }
    @Override
    public int add(Unidad c) throws SQLException {
        String sql="insert into unidad (codigo,nombre,observaciones,idcurso,idtutor,idaula) values(?,?,?,?,?,?) ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            //pstm.setInt(1, c.getId());
            pstm.setString(1,c.getCodigo());
            pstm.setString(2,c.getNombre());
            pstm.setString(3, c.getObservaciones());
            pstm.setInt(4, c.getIdcurso());
            pstm.setInt(5, c.getIdtutor());
            pstm.setInt(6, c.getIdaula());
            return pstm.executeUpdate();
        }
    }

    @Override
    public Unidad getById(int id) throws SQLException {
         String sql="Select * from unidad where id=?"; 
        Unidad cursoaca=new Unidad();
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            
            if(rs.next()){
                
                cursoaca.setId(rs.getInt("id"));
                cursoaca.setCodigo(rs.getString("codigo"));
                cursoaca.setNombre(rs.getString("nombre"));
                cursoaca.setObservaciones(rs.getString("observaciones"));
                cursoaca.setIdcurso(rs.getInt("idcurso"));
                cursoaca.setIdtutor(rs.getInt("idtutor"));
                cursoaca.setIdaula(rs.getInt("idaula"));
                
            }
        }
      return cursoaca;
    }
    

    @Override
    public List<Unidad> getAll() throws SQLException {
        String sql="Select * from unidad "; 
    List<Unidad> badeDatos = new ArrayList<>();
      Unidad unidad;
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            ResultSet rs=pstm.executeQuery();
            
            while(rs.next()){
                unidad=new Unidad();
                unidad.setId(rs.getInt("id"));
                unidad.setCodigo(rs.getString("codigo"));
                unidad.setNombre(rs.getString("nombre"));
                unidad.setObservaciones(rs.getString("observaciones"));
                unidad.setIdcurso(rs.getInt("idcurso"));
                unidad.setIdtutor(rs.getInt("idtutor"));
                unidad.setIdaula(rs.getInt("idaula"));
                badeDatos.add(unidad);
            }
            
        }
        return badeDatos;
    }

    @Override
    public int update(int id, Unidad c) throws SQLException {
        String sql="update unidad set codigo=?,nombre=?,observaciones=?,idcurso=?,idtutor=?,idaula=? where id=? ";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            
            
            pstm.setString(1,c.getCodigo());
            pstm.setString(2,c.getNombre());
            pstm.setString(3, c.getObservaciones());
            pstm.setInt(4, c.getIdcurso());
            pstm.setInt(5, c.getIdtutor());
            pstm.setInt(6, c.getIdaula());
            pstm.setInt(7, id);
            return pstm.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql="delete from unidad where id=?;";
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         pstm.setInt(1,id);
         pstm.executeUpdate();
        }
    }
    public List<Unidad> getAllbyCurso(int idcurso) throws SQLException {
        String sql="Select * from unidad where idcurso=?"; 
    List<Unidad> badeDatos = new ArrayList<>();
      Unidad unidad;
        try(Connection cn= MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setInt(1, idcurso);

            ResultSet rs=pstm.executeQuery();
            
            while(rs.next()){
                unidad=new Unidad();
                unidad.setId(rs.getInt("id"));
                unidad.setCodigo(rs.getString("codigo"));
                unidad.setNombre(rs.getString("nombre"));
                unidad.setObservaciones(rs.getString("observaciones"));
                unidad.setIdcurso(rs.getInt("idcurso"));
                unidad.setIdtutor(rs.getInt("idtutor"));
                unidad.setIdaula(rs.getInt("idaula"));
                badeDatos.add(unidad);
            }
            
        }
        return badeDatos;
    }
}
