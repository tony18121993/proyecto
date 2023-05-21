/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.crudjdbcdemo.Formularios;

import com.mycompany.crudjdbcdemo.Entidades.Aula;
import com.mycompany.crudjdbcdemo.Entidades.Curso;
import com.mycompany.crudjdbcdemo.Entidades.Personal;
import com.mycompany.crudjdbcdemo.Entidades.Unidad;
import com.mycompany.crudjdbcdemo.controladorDAO.AulaDaoimp;
import com.mycompany.crudjdbcdemo.controladorDAO.CursoDAOimp;
import com.mycompany.crudjdbcdemo.controladorDAO.PersonalDaoimp;
import com.mycompany.crudjdbcdemo.controladorDAO.UnidadDAOimp;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author TONY
 */
public class frmUnidad extends javax.swing.JFrame {

    /**
     * Creates new form frmUnidad
     */
    
    List<Curso> lstcursocarga =new ArrayList();
    public frmUnidad() {
        initComponents();
        cargaComboBox();
        configTabla();
        cargaTabla();
        generaTablaUnidad();
    }
    private void configTabla(){
        String col[]={"ID","CODIGO","NOMBRE","OBSERVACIONES","CURSO","TUTOR","AULA"};
        
        DefaultTableModel modelo=new DefaultTableModel(col,0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
    };
        jtUnidad.setModel(modelo);
    }
    public void cargaComboBox(){
        
        CursoDAOimp cursoaca=CursoDAOimp.getInstance();
        try{
             lstcursocarga=cursoaca.getAll();
            
            for( Curso curso:lstcursocarga){
                
                cbcurso.addItem(curso.getCodigo());
            }
            }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
}
    private void cargaTabla(){
        DefaultTableModel modelo=(DefaultTableModel)jtUnidad.getModel();
        AulaDaoimp aulaDAO=AulaDaoimp.getInstance();
        UnidadDAOimp cursoaca=UnidadDAOimp.getInstance();
        CursoDAOimp cursoDAO = CursoDAOimp.getInstance();
        PersonalDaoimp perDAO =PersonalDaoimp.getInstance();
        String[] fila=new String[7];
        
        modelo.setNumRows(0);
        try{
            List<Unidad> lst=cursoaca.getAll();
            for( Unidad curso :lst){
                fila[0]=""+curso.getId();
                fila[1]=""+curso.getCodigo();
                fila[2]=""+curso.getNombre();
                fila[3]=""+curso.getObservaciones();
                Curso cur=cursoDAO.getById(curso.getIdcurso());
                fila[4]=cur.getCodigo();
               ///fila[4]=""+curso.getIdcurso();
                Personal tutor=perDAO.getById(curso.getIdtutor());
                fila[5]=tutor.getNombre();
                //fila[6]=""+curso.getIdaula();
                Aula au=aulaDAO.getById(curso.getIdaula());
                fila[6] = au.getCodigo();
                modelo.addRow(fila);
            }
            
            
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }
    private void cargaTabla1(int idcurso){
        DefaultTableModel modelo=(DefaultTableModel)jtUnidad.getModel();
        AulaDaoimp aulaDAO=AulaDaoimp.getInstance();
        UnidadDAOimp cursoaca=UnidadDAOimp.getInstance();
        CursoDAOimp cursoDAO = CursoDAOimp.getInstance();
        PersonalDaoimp perDAO =PersonalDaoimp.getInstance();
        String[] fila=new String[7];
        
        modelo.setNumRows(0);
        try{
            List<Unidad> lstunidad=cursoaca.getAllbyCurso(idcurso);
            for( Unidad curso :lstunidad){
                fila[0]=""+curso.getId();
                fila[1]=""+curso.getCodigo();
                fila[2]=""+curso.getNombre();
                fila[3]=""+curso.getObservaciones();
                Curso cur=cursoDAO.getById(curso.getIdcurso());
                fila[4]=cur.getCodigo();
               ///fila[4]=""+curso.getIdcurso();
                Personal tutor=perDAO.getById(curso.getIdtutor());
                fila[5]=tutor.getNombre();
                //fila[6]=""+curso.getIdaula();
                Aula au=aulaDAO.getById(curso.getIdaula());
                fila[6] = au.getCodigo();
                modelo.addRow(fila);
            }
            
            
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }
    public void generaTablaUnidad(){
         try{
         cbcurso.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    // Obtener el elemento seleccionado del ComboBox
                    int idcurso= lstcursocarga.get(cbcurso.getSelectedIndex()).getId();
                    
                    // Cargar la tabla correspondiente
                    cargaTabla1(idcurso);
                }
              }
           });
         
         }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtUnidad = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        btnadd = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        cbcurso = new javax.swing.JComboBox<>();

        jtUnidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "codigo", "nombre", "observaciones", "curso", "tutor", "aula"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtUnidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUnidadMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtUnidad);

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
        });

        btnadd.setText("Añadir");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbcurso, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnadd)
                        .addGap(90, 90, 90)
                        .addComponent(btneliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbcurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadd)
                    .addComponent(btneliminar)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
            DefaultTableModel modelo=(DefaultTableModel) jtUnidad.getModel();
            TableRowSorter <TableModel> trSorter=new TableRowSorter<TableModel>(modelo);
            
            jtUnidad.setRowSorter(trSorter);
            
            if(txtbuscar.getText().length()==0){
                trSorter.setRowFilter(null);
            }else{
                trSorter.setRowFilter(RowFilter.regexFilter(txtbuscar.getText().trim()));
            }
        }
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void jtUnidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUnidadMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            JDialog frame =new JDialog();
            frame.setTitle("Detalle Unidad");
            frame.setModal(true);
            jpUnidadUpdate panel=new jpUnidadUpdate();
            int idSeleccion=Integer.parseInt(jtUnidad.getValueAt(jtUnidad.getSelectedRow(), 0).toString());
            panel.UnidadCargaDetalle(idSeleccion);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setVisible(true);
            cargaTabla();

        }
    }//GEN-LAST:event_jtUnidadMouseClicked

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        JDialog frame =new JDialog();
            frame.setTitle("Detalle añadir Unidad");
            frame.setModal(true);
            jpUnidadAdd panel=new jpUnidadAdd();
            

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setVisible(true); 
            cargaTabla();
    }//GEN-LAST:event_btnaddActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
                UnidadDAOimp cursoaca=UnidadDAOimp.getInstance();

        try{
            int i =Integer.parseInt((jtUnidad.getValueAt(jtUnidad.getSelectedRow(), 0)).toString());
            cursoaca.delete(i);
            JOptionPane.showMessageDialog(this, "Curso eliminado correctamente");
            cargaTabla();
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
         } 
          
    }//GEN-LAST:event_btneliminarActionPerformed
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmUnidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUnidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUnidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUnidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUnidad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btneliminar;
    private javax.swing.JComboBox<String> cbcurso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtUnidad;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
