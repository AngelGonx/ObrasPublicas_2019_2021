/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.SeccionesObras;

import Controlador.ControladorBaseDeDatos;
import Controlador.ControladorUtilerias;
import Modelo.TablaBeneficiarios;
import Modelo.TablaDocumentosBeneficiarios;
import Modelo.TablaFotosBeneficiarios;
import Modelo.TablaObrasInformacion;
import Vista.Beneficiarios.actualizarBeneficiarios;
import Vista.Beneficiarios.actualizarDocumentosBeneficiarios;
import Vista.Beneficiarios.actualizarFotosBeneficiarios;
import Vista.Beneficiarios.agregarBeneficiarios;
import Vista.Principal.ventanaPrincipal;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Vista.Beneficiarios.documentosBeneficiario;

import Vista.Beneficiarios.fotosBeneficiario;
/**
 * @author Ángel González Rincón
 * Date: 01-sep-2021
 */
public class beneficiariosObra extends javax.swing.JFrame {

    /**
     * Creates new form detallesObra
     */
    String ageObra = "";
    DefaultTableModel modeloInformacionBeneficiarios;
    TablaObrasInformacion toi = new TablaObrasInformacion();
    String[] columna = new String[]{"Id", "Nombre Beneficiario",
        "Localidad", "Id Obra", "Fecha Creación"};
    String tipoObra = "";
    ControladorUtilerias cut = new ControladorUtilerias();
    ControladorBaseDeDatos cbd = new ControladorBaseDeDatos();
    TablaBeneficiarios tbf = new TablaBeneficiarios();
    TablaFotosBeneficiarios tfb = new TablaFotosBeneficiarios();
    TablaDocumentosBeneficiarios tdb = new TablaDocumentosBeneficiarios();
    String campoValorID = "0";
    public beneficiariosObra(String ageObra, TablaObrasInformacion toi) {
        initComponents();
        this.setLocationRelativeTo(null);
        cbd.openConnection();
        modeloInformacionBeneficiarios = cbd.modeloBeneficiarios(columna, toi.getId());
        cbd.closeConnection();
        this.ageObra = ageObra;
        this.toi = toi; 
        tipoObra = cut.tipoObra(toi.getId_tipo_obra());
        campoNumObra.setText(toi.getNumero());
        campoTipoObra.setText(tipoObra);
        jTable1.setModel(modeloInformacionBeneficiarios);
        
        /*Obtengo el valor que selecciono de la tabla*/
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable1.rowAtPoint(evt.getPoint());
                int col = 0;
                if (row >= 0 && col >= 0) {
                    String valor = jTable1.getModel().getValueAt(row, col).toString(); //Tomo el valor de el modelo de la tabla
                    campoValorID = valor; //Obtengo el valor y lo seteo
                    System.out.println("El ID Seleccionado es: "+campoValorID);
                }
//                col = 1;
//                if (row >= 0 && col >= 0) {
//                    String valor = tablaMultas.getModel().getValueAt(row, col).toString(); //Tomo el valor de el modelo de la tabla
//                    campoNombreMulta.setText(valor); //Obtengo el valor del textfield
//                }
//                col = 3;
//                if (row >= 0 && col >= 0) {
//                    String valor = tablaMultas.getModel().getValueAt(row, col).toString(); //Tomo el valor de el modelo de la tabla
//                    campoPrecio.setText(valor); //Obtengo el valor del textfield
//                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        a = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        campoNumObra = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        fotosbtn = new javax.swing.JButton();
        agregarBTN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        campoTipoObra = new javax.swing.JTextField();
        documentosBtn = new javax.swing.JButton();
        editarButton = new javax.swing.JButton();
        fotosbtn1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        izquierda_Button = new javax.swing.JLabel();
        derecha_Botton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        a.setEditable(false);
        a.setBackground(new java.awt.Color(143, 195, 131));
        a.setFont(new java.awt.Font("Comic Sans MS", 1, 32)); // NOI18N
        a.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 600, 30));

        jTextField3.setEditable(false);
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 600, 40));

        campoNumObra.setEditable(false);
        campoNumObra.setBackground(new java.awt.Color(255, 255, 255));
        campoNumObra.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        campoNumObra.setText("\"NÚMERO OBRA\"");
        campoNumObra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(campoNumObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fotosbtn.setBackground(new java.awt.Color(255, 255, 255));
        fotosbtn.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        fotosbtn.setText("Eliminar");
        fotosbtn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 6, 4, new java.awt.Color(0, 0, 0)));
        fotosbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fotosbtn.setOpaque(false);
        fotosbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fotosbtnActionPerformed(evt);
            }
        });
        jPanel1.add(fotosbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 126, -1));

        agregarBTN.setBackground(new java.awt.Color(255, 255, 255));
        agregarBTN.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        agregarBTN.setText("AÑADIR");
        agregarBTN.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 6, 4, new java.awt.Color(0, 0, 0)));
        agregarBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        agregarBTN.setOpaque(false);
        agregarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBTNActionPerformed(evt);
            }
        });
        jPanel1.add(agregarBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 105, -1));

        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 54, 539, 270));

        campoTipoObra.setEditable(false);
        campoTipoObra.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        campoTipoObra.setText("\"TIPO OBRA\"");
        campoTipoObra.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel1.add(campoTipoObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 540, 40));

        documentosBtn.setBackground(new java.awt.Color(255, 255, 255));
        documentosBtn.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        documentosBtn.setText("Ver Documentos");
        documentosBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 6, 4, new java.awt.Color(0, 0, 0)));
        documentosBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        documentosBtn.setOpaque(false);
        documentosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                documentosBtnActionPerformed(evt);
            }
        });
        jPanel1.add(documentosBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 126, -1));

        editarButton.setBackground(new java.awt.Color(255, 255, 255));
        editarButton.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        editarButton.setText("EDITAR");
        editarButton.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 6, 4, new java.awt.Color(0, 0, 0)));
        editarButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editarButton.setOpaque(false);
        editarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(editarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 105, -1));

        fotosbtn1.setBackground(new java.awt.Color(255, 255, 255));
        fotosbtn1.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        fotosbtn1.setText("Ver Fotos");
        fotosbtn1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 6, 4, new java.awt.Color(0, 0, 0)));
        fotosbtn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fotosbtn1.setOpaque(false);
        fotosbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fotosbtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(fotosbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 126, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 600, 440));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 0, 4, new java.awt.Color(0, 0, 0)));

        izquierda_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/flecha_izquierda.png"))); // NOI18N
        izquierda_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                izquierda_ButtonMouseClicked(evt);
            }
        });

        derecha_Botton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/flecha_derecha.png"))); // NOI18N
        derecha_Botton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                derecha_BottonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(izquierda_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(derecha_Botton)
                .addContainerGap(530, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(izquierda_Button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(derecha_Botton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 600, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void izquierda_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_izquierda_ButtonMouseClicked
//        ventanaPrincipal vp = new ventanaPrincipal();
//        this.dispose();
//        vp.show();
    informacionObra io = new informacionObra(ageObra, toi.getId());
    io.show();
    this.dispose();
    }//GEN-LAST:event_izquierda_ButtonMouseClicked

    private void derecha_BottonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_derecha_BottonMouseClicked

    }//GEN-LAST:event_derecha_BottonMouseClicked

    private void agregarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBTNActionPerformed
        // TODO add your handling code here:
        agregarBeneficiarios agb = new agregarBeneficiarios(this, rootPaneCheckingEnabled, ageObra, toi.getId(), toi);
        agb.show();
        this.dispose();
    }//GEN-LAST:event_agregarBTNActionPerformed

    private void editarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarButtonActionPerformed
        // TODO add your handling code here:
        actualizarBeneficiarios ab = new actualizarBeneficiarios(this, rootPaneCheckingEnabled, ageObra, toi.getId(), toi,  Integer.parseInt(campoValorID));
        ab.show();
        refrescarTabla();
    }//GEN-LAST:event_editarButtonActionPerformed

    private void fotosbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fotosbtnActionPerformed
        // TODO add your handling code here:
        cbd.openConnection();
        int operacionExitosa = cbd.eliminaBeneficiarios(Integer.parseInt(campoValorID));
        cbd.closeConnection();
        if(operacionExitosa == 1){
            JOptionPane.showMessageDialog(null, "El Beneficiarios, sus fotos y documentos fueron eliminados correctamente.");
            refrescarTabla();
        }
        else{
            JOptionPane.showMessageDialog(null, "Ocurrio un error al intentar eliminar ó no seleccionaste un beneficiario, consulte a su administrador.");
        }
    }//GEN-LAST:event_fotosbtnActionPerformed

    private void documentosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_documentosBtnActionPerformed
        // TODO add your handling code here:
        
        tbf.setId(Integer.parseInt(campoValorID));
        cbd.openConnection();
        tdb = cbd.obtenerDocumentos(tbf);
        cbd.closeConnection();
        if(tdb.getId()>=1){
            actualizarDocumentosBeneficiarios actb = new actualizarDocumentosBeneficiarios(ageObra, Integer.parseInt(campoValorID));
            actb.show();
        }
        else{
           if(tbf.getId()<=0){
            JOptionPane.showMessageDialog(null, "Selecciona un beneficiario de la lista para continuar.");
           
           }
           else{
               
               int dialogButton = JOptionPane.YES_NO_OPTION;
           int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea continuar añadiendo los Documentos?","Warning",dialogButton);
           if(dialogResult == JOptionPane.YES_OPTION){
                  // Saving code here
                  //nameArchive archivoGenerado sin permiso :v
                    documentosBeneficiario actb = new documentosBeneficiario(ageObra, tbf);
                    actb.show();
                    this.dispose();

            }else{
                System.out.println("Proceso terminado.");
                informacionObra io = new informacionObra(ageObra, toi.getId());
                io.show();
                this.dispose();
                   // lbtc.deleteDocumento(direccion+nameArchive);
            }
            }
        }
        //this.dispose();
    }//GEN-LAST:event_documentosBtnActionPerformed

    private void fotosbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fotosbtn1ActionPerformed
        // TODO add your handling code here:
        tbf.setId(Integer.parseInt(campoValorID));
        cbd.openConnection();
        tfb = cbd.obtenerFotos(tbf);
        cbd.closeConnection();
         if(tfb.getId()>=1){
            actualizarFotosBeneficiarios actb = new actualizarFotosBeneficiarios(ageObra, Integer.parseInt(campoValorID));
            actb.show();
        }
        else{
           if(tbf.getId()<=0){
               JOptionPane.showMessageDialog(null, "Selecciona un beneficiario de la lista para continuar.");
           }
           else{

           int dialogButton = JOptionPane.YES_NO_OPTION;
           int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea continuar añadiendo las Fotos?","Warning",dialogButton);
           if(dialogResult == JOptionPane.YES_OPTION){
                  // Saving code here
                  //nameArchive archivoGenerado sin permiso :v
                    fotosBeneficiario actb = new fotosBeneficiario(ageObra, tbf);
                    actb.show();
                    this.dispose();

            }else{
                System.out.println("Proceso terminado.");
                informacionObra io = new informacionObra(ageObra, toi.getId());
                io.show();
                this.dispose();
                   // lbtc.deleteDocumento(direccion+nameArchive);
            }
           }
            
        }
        //this.dispose();
    }//GEN-LAST:event_fotosbtn1ActionPerformed
     public void refrescarTabla() {
        cbd.openConnection();
        modeloInformacionBeneficiarios = cbd.modeloBeneficiarios(columna,toi.getId());
        cbd.closeConnection();
        jTable1.setModel(modeloInformacionBeneficiarios);
        modeloInformacionBeneficiarios.fireTableDataChanged();
    }  
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(beneficiariosObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(beneficiariosObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(beneficiariosObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(beneficiariosObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new beneficiariosObra().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a;
    private javax.swing.JButton agregarBTN;
    private javax.swing.JTextField campoNumObra;
    private javax.swing.JTextField campoTipoObra;
    private javax.swing.JLabel derecha_Botton;
    private javax.swing.JButton documentosBtn;
    private javax.swing.JButton editarButton;
    private javax.swing.JButton fotosbtn;
    private javax.swing.JButton fotosbtn1;
    private javax.swing.JLabel izquierda_Button;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
