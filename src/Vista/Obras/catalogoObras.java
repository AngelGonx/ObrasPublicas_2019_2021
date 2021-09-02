/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Obras;

import Vista.Principal.ventanaPrincipal;
import Vista.Obras.obrasAgregadas;
import Vista.Obras.agregarObras;

/**
 * @author Ángel González Rincón
 * Date: 01-sep-2021
 */
public class catalogoObras extends javax.swing.JFrame {

    /**
     * Creates new form catalogoObras
     */
    public catalogoObras() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        obrasAnios = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        labelObrasAgregadas = new javax.swing.JLabel();
        labelAgregarObra = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        izquierda_Button = new javax.swing.JLabel();
        derecha_Botton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Obras Públicas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        obrasAnios.setEditable(false);
        obrasAnios.setBackground(new java.awt.Color(143, 195, 131));
        obrasAnios.setFont(new java.awt.Font("Comic Sans MS", 1, 32)); // NOI18N
        obrasAnios.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        obrasAnios.setText(" Obras 20--");
        obrasAnios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(obrasAnios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 600, 60));

        jTextField3.setEditable(false);
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 600, 40));

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jTextField4.setText(" Obras Públicas");
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        labelObrasAgregadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/obrasAgregadas.JPG"))); // NOI18N
        labelObrasAgregadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelObrasAgregadasMouseClicked(evt);
            }
        });

        labelAgregarObra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/agregarObras.JPG"))); // NOI18N
        labelAgregarObra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAgregarObraMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(labelObrasAgregadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(labelAgregarObra)
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAgregarObra)
                    .addComponent(labelObrasAgregadas))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 600, 410));

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
                .addContainerGap(526, Short.MAX_VALUE))
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

    private void derecha_BottonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_derecha_BottonMouseClicked

    }//GEN-LAST:event_derecha_BottonMouseClicked

    private void izquierda_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_izquierda_ButtonMouseClicked
        ventanaPrincipal menuPrincipal = new ventanaPrincipal();
        this.dispose();
        menuPrincipal.show();

    }//GEN-LAST:event_izquierda_ButtonMouseClicked

    private void labelObrasAgregadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelObrasAgregadasMouseClicked
        obrasAgregadas obAdd = new obrasAgregadas();
        this.dispose();
        obAdd.show();
    }//GEN-LAST:event_labelObrasAgregadasMouseClicked

    private void labelAgregarObraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAgregarObraMouseClicked
        agregarObras addOb = new agregarObras();
        this.dispose();
        addOb.show();
    }//GEN-LAST:event_labelAgregarObraMouseClicked

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
            java.util.logging.Logger.getLogger(catalogoObras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(catalogoObras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(catalogoObras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(catalogoObras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new catalogoObras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel derecha_Botton;
    private javax.swing.JLabel izquierda_Button;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel labelAgregarObra;
    private javax.swing.JLabel labelObrasAgregadas;
    private javax.swing.JTextField obrasAnios;
    // End of variables declaration//GEN-END:variables
}