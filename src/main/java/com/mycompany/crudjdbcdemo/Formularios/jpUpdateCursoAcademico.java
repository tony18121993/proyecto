/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.crudjdbcdemo.Formularios;

import com.mycompany.crudjdbcdemo.Entidades.CursoAcademico;
import com.mycompany.crudjdbcdemo.controladorDAO.CursoAcademicoDAOimp;
import javax.swing.JOptionPane;

/**
 *
 * @author TONY
 */
public class jpUpdateCursoAcademico extends javax.swing.JPanel {
    public int id;
    /**
     * Creates new form jpUpdateCursoAcademico
     */
    public jpUpdateCursoAcademico() {
        initComponents();
        UnidadCargaDetalle(id);
    }
    public void UnidadCargaDetalle(int id){
        CursoAcademicoDAOimp cursoaca=CursoAcademicoDAOimp.getInstance();
        try{
        CursoAcademico c= cursoaca.getById(id);
        this.id=id;
        txtID.setText(""+id);
        txtInicio2.setText(""+c.getYearinicio());
        txtFin2.setText(""+c.getYearfin());
        txtDescripcion.setText(""+c.getDescripcion());
        
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

        jpcampos2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtInicio2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFin2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        btnactualiza = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 255, 255));

        jpcampos2.setBackground(new java.awt.Color(0, 255, 255));

        jLabel5.setText("Inicio");

        jLabel6.setText("Fin");

        txtFin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFin2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Descripcion");

        btnactualiza.setText("Actualizar");
        btnactualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizaActionPerformed(evt);
            }
        });

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel8.setText("id");

        javax.swing.GroupLayout jpcampos2Layout = new javax.swing.GroupLayout(jpcampos2);
        jpcampos2.setLayout(jpcampos2Layout);
        jpcampos2Layout.setHorizontalGroup(
            jpcampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpcampos2Layout.createSequentialGroup()
                .addGroup(jpcampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpcampos2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jpcampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpcampos2Layout.createSequentialGroup()
                                .addGroup(jpcampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtInicio2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(jpcampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFin2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpcampos2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jpcampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpcampos2Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnactualiza)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jpcampos2Layout.setVerticalGroup(
            jpcampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpcampos2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpcampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpcampos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInicio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnactualiza))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jpcampos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(1, 1, 1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jpcampos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(51, 51, 51)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtFin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFin2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFin2ActionPerformed

    private void btnactualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizaActionPerformed
        // TODO add your handling code here:
        //actualizar un curso academico
        CursoAcademicoDAOimp cursoaca=CursoAcademicoDAOimp.getInstance();
         int i =Integer.parseInt(txtID.getText());
        
       
        try{      
            CursoAcademico c;
            c = new CursoAcademico(Integer.parseInt(txtInicio2.getText()),Integer.parseInt(txtFin2.getText()),txtDescripcion.getText());
            
            cursoaca.update(i,c);
            JOptionPane.showMessageDialog(this, "Curso Academico actualizado correctamente,cierra esta pestaña para ver los cambios");
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
         } 
    }//GEN-LAST:event_btnactualizaActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualiza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jpcampos;
    private javax.swing.JPanel jpcampos1;
    private javax.swing.JPanel jpcampos2;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFin;
    private javax.swing.JTextField txtFin1;
    private javax.swing.JTextField txtFin2;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtInicio;
    private javax.swing.JTextField txtInicio1;
    private javax.swing.JTextField txtInicio2;
    // End of variables declaration//GEN-END:variables
}
