/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.crudjdbcdemo.Formularios;

import com.mycompany.crudjdbcdemo.Entidades.Alumno;
import com.mycompany.crudjdbcdemo.Entidades.Autorizaciones;
import com.mycompany.crudjdbcdemo.Entidades.Autorizados;
import com.mycompany.crudjdbcdemo.controladorDAO.AlumnoDaoimp;
import com.mycompany.crudjdbcdemo.controladorDAO.AutorizacionesDaoimp;
import com.mycompany.crudjdbcdemo.controladorDAO.AutorizadosDaoimp;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author TONY
 */
public class frmAutorizaciones extends javax.swing.JFrame {

    /**
     * Creates new form frmAutorizaciones
     */
    List<Alumno> lstalumno =new ArrayList();
    List<Autorizados> lstautorizados =new ArrayList();
    public frmAutorizaciones() {
        initComponents();
        cargaComboBoxAlumno();
        cargaComboBoxAutorizados();
        configTabla();
        cargaTabla();
    }
    private void configTabla(){
        String col[]={"ALUMNO","AUTORIZADO"};
        
        DefaultTableModel modelo=new DefaultTableModel(col,0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
    };
        jtautorizaciones.setModel(modelo);
        
        
        
    }
    
    private void cargaTabla(){
        DefaultTableModel modelo=(DefaultTableModel)jtautorizaciones.getModel();
        AutorizacionesDaoimp autorizaciones=AutorizacionesDaoimp.getInstance();
        AlumnoDaoimp alumDAO=AlumnoDaoimp.getInstance();
        AutorizadosDaoimp autoriDao=AutorizadosDaoimp.getInstance();
       
        String[] fila=new String[2];
        
        modelo.setNumRows(0);
        try{
            System.out.println("omar");
            List<Autorizaciones> auto=autorizaciones.getAll();
            System.out.println("toni");
            for( Autorizaciones curso : auto){
                Alumno alu=alumDAO.getById(curso.getIdalumno());
                fila[0]=alu.getNombre();
                System.out.println("hola");
                Autorizados tutor=autoriDao.getById(curso.getIdautorizado());
                System.out.println("quedices");
                fila[1]=tutor.getNombre();
                
                modelo.addRow(fila);
            }
            
            
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtañadir = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        cbalumno = new javax.swing.JComboBox<>();
        cbautorizado = new javax.swing.JComboBox<>();
        txtbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtautorizaciones = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel1.setText("alumno");

        jLabel2.setText("Autorizado");

        txtañadir.setText("Añadir");
        txtañadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtañadirActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1)
                        .addGap(197, 197, 197)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbalumno, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103)
                                .addComponent(cbautorizado, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtañadir)
                                .addGap(102, 102, 102)
                                .addComponent(btneliminar)
                                .addGap(121, 121, 121)
                                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbalumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbautorizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtañadir)
                    .addComponent(btneliminar)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jtautorizaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "alumno", "autorizado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtautorizaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtautorizacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtautorizaciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtautorizacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtautorizacionesMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
             int idSeleccion=Integer.parseInt(jtautorizaciones.getValueAt(jtautorizaciones.getSelectedRow(), 0).toString());
             AutorizacionesCargaDetalle(idSeleccion);
        }
    }//GEN-LAST:event_jtautorizacionesMouseClicked

    private void txtañadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtañadirActionPerformed
        // TODO add your handling code here:
         AutorizacionesDaoimp auto=AutorizacionesDaoimp.getInstance();

        try{
            auto.add(getCampos());
            JOptionPane.showMessageDialog(this, "Autorizacion agregada correctamente");
            
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
         }
        cargaTabla();
    }//GEN-LAST:event_txtañadirActionPerformed

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
            DefaultTableModel modelo=(DefaultTableModel) jtautorizaciones.getModel();
            TableRowSorter <TableModel> trSorter=new TableRowSorter<TableModel>(modelo);
            
            jtautorizaciones.setRowSorter(trSorter);
            
            if(txtbuscar.getText().length()==0){
                trSorter.setRowFilter(null);
            }else{
                trSorter.setRowFilter(RowFilter.regexFilter(txtbuscar.getText().trim()));
            }
        }
    }//GEN-LAST:event_txtbuscarKeyPressed
    
    public void AutorizacionesCargaDetalle(int id){
         AutorizacionesDaoimp auto=AutorizacionesDaoimp.getInstance();
        try{
        Autorizaciones c= auto.getById(id);
        
        int posicionalumno=0;
        int posicionautorizado=0;
        int idalumno=c.getIdalumno();
        int idautorizado=c.getIdautorizado();
        int j;
        for(j=0;j<lstalumno.size();j++){
            Alumno cu=lstalumno.get(j);
            if(cu.getId()==idalumno){
                posicionalumno=j;
            }
        }
        cbalumno.setSelectedIndex(posicionalumno);
        for(j=0;j<lstautorizados.size();j++){
            Autorizados cu=lstautorizados.get(j);
            if(cu.getId()==idautorizado){
                posicionautorizado=j;
            }
        }
        cbautorizado.setSelectedIndex(posicionautorizado);
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }
    private Autorizaciones getCampos(){
        Autorizaciones c=new Autorizaciones();

        //c.setIdmatricula(Integer.parseInt(txtidmatricula.getText()));
        c.setIdalumno(lstalumno.get(cbalumno.getSelectedIndex()).getId());
        c.setIdautorizado(lstautorizados.get(cbautorizado.getSelectedIndex()).getId());
        return c;
    }
    public void cargaComboBoxAlumno(){
        
        AlumnoDaoimp cursoaca=AlumnoDaoimp.getInstance();
        
        try{
            lstalumno=cursoaca.getAll();
            for( Alumno alum:lstalumno){
                
                cbalumno.addItem(alum.getNombre());
            }
            }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
}
    public void cargaComboBoxAutorizados(){
        
        AutorizadosDaoimp cursoaca=AutorizadosDaoimp.getInstance();
        try{
             
            lstautorizados=cursoaca.getAll();
            for( Autorizados auto:lstautorizados){
                System.out.println("quedices");
                cbautorizado.addItem(auto.getNombre());
            }
            }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
}
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
            java.util.logging.Logger.getLogger(frmAutorizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAutorizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAutorizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAutorizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAutorizaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar;
    private javax.swing.JComboBox<String> cbalumno;
    private javax.swing.JComboBox<String> cbautorizado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtautorizaciones;
    private javax.swing.JButton txtañadir;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
