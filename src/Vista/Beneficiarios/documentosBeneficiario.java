/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Beneficiarios;

import Controlador.ControladorBaseDeDatos;
import Controlador.ControladorUtilerias;
import Modelo.TablaBeneficiarios;
import Modelo.TablaDocumentosBeneficiarios;
import Vista.Obras.catalogoObras;
import Vista.SeccionesObras.beneficiariosObra;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class documentosBeneficiario extends javax.swing.JFrame {

    /**
     * Creates new form documentosBeneficiario
     */
    ControladorUtilerias cut = new ControladorUtilerias();
    TablaBeneficiarios tbf = new TablaBeneficiarios();
    TablaDocumentosBeneficiarios tdb = new TablaDocumentosBeneficiarios();
    ControladorBaseDeDatos cbd = new ControladorBaseDeDatos();
    String ageObra = "";
    public documentosBeneficiario(String ageObra,TablaBeneficiarios tbf) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ageObra = ageObra;
        this.tbf = tbf;
        System.out.println("El año es:"+ageObra+" La informacion de id beneficiario: "+tbf.getId());
        tdb.setDoc_uno("");
        tdb.setDoc_dos("");
        tdb.setDoc_tres("");
        tdb.setDoc_cuatro("");
        tdb.setDoc_cinco("");
        tdb.setId_beneficiario(tbf.getId());
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
        jTextField4 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnEliminarUno = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btnEliminarCinco = new javax.swing.JButton();
        btnEliminarDos = new javax.swing.JButton();
        btnEliminarTres = new javax.swing.JButton();
        btnEliminarCuatro = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jProgressBar3 = new javax.swing.JProgressBar();
        jProgressBar4 = new javax.swing.JProgressBar();
        jProgressBar5 = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
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

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jTextField4.setText("Documentos \"beneficiario\"");
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminarUno.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarUno.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnEliminarUno.setText("Eliminar");
        btnEliminarUno.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 6, 4, new java.awt.Color(0, 0, 0)));
        btnEliminarUno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarUno.setOpaque(false);
        btnEliminarUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUnoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 105, -1));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel1.setText("name.pdf");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 57, -1, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel2.setText("name.pdf");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 123, -1, -1));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel3.setText("name.pdf");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 193, -1, -1));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel4.setText("name.pdf");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel5.setText("name.pdf");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jButton3.setText("Buscar ..");
        jButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 6, 4, new java.awt.Color(0, 0, 0)));
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 85, 21));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jButton4.setText("Buscar ..");
        jButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 6, 4, new java.awt.Color(0, 0, 0)));
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setOpaque(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 85, 21));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jButton5.setText("Buscar ..");
        jButton5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 6, 4, new java.awt.Color(0, 0, 0)));
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setOpaque(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 85, 21));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jButton6.setText("Buscar ..");
        jButton6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 6, 4, new java.awt.Color(0, 0, 0)));
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setOpaque(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 85, 21));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jButton7.setText("Buscar ..");
        jButton7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 6, 4, new java.awt.Color(0, 0, 0)));
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setOpaque(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 85, 21));

        btnEliminarCinco.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarCinco.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnEliminarCinco.setText("Eliminar");
        btnEliminarCinco.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 6, 4, new java.awt.Color(0, 0, 0)));
        btnEliminarCinco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarCinco.setOpaque(false);
        btnEliminarCinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCincoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarCinco, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 105, -1));

        btnEliminarDos.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarDos.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnEliminarDos.setText("Eliminar");
        btnEliminarDos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 6, 4, new java.awt.Color(0, 0, 0)));
        btnEliminarDos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarDos.setOpaque(false);
        btnEliminarDos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDosActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarDos, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 105, -1));

        btnEliminarTres.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarTres.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnEliminarTres.setText("Eliminar");
        btnEliminarTres.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 6, 4, new java.awt.Color(0, 0, 0)));
        btnEliminarTres.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarTres.setOpaque(false);
        btnEliminarTres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTresActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarTres, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 105, -1));

        btnEliminarCuatro.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarCuatro.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnEliminarCuatro.setText("Eliminar");
        btnEliminarCuatro.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 6, 4, new java.awt.Color(0, 0, 0)));
        btnEliminarCuatro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarCuatro.setOpaque(false);
        btnEliminarCuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCuatroActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarCuatro, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 105, -1));
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 57, 226, 21));
        jPanel1.add(jProgressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 226, 21));
        jPanel1.add(jProgressBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 226, 21));
        jPanel1.add(jProgressBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 226, 21));
        jPanel1.add(jProgressBar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 226, 21));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel6.setText("Actualiza o Añadir un Archivo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, -1));

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel7.setText("Actualiza o Añadir un Archivo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel9.setText("Actualiza o Añadir un Archivo");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel10.setText("Actualiza o Añadir un Archivo");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel11.setText("Actualiza o Añadir un Archivo");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 100, -1));

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
        beneficiariosObra benOb = new beneficiariosObra(ageObra);
        this.dispose();
        benOb.show();
    }//GEN-LAST:event_izquierda_ButtonMouseClicked

    private void derecha_BottonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_derecha_BottonMouseClicked

    }//GEN-LAST:event_derecha_BottonMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        String ruta = cut.obtenerRuta(2);
        System.out.println(ruta);
        if(!ruta.equals("")){
            jProgressBar1.setValue(100);
            jButton7.setEnabled(false);
            tdb.setDoc_uno(ruta);
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor, carga una archivo válido");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String ruta = cut.obtenerRuta(2);
        System.out.println(ruta);
        if(!ruta.equals("")){
            jProgressBar3.setValue(100);
            jButton3.setEnabled(false);
            tdb.setDoc_dos(ruta);
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor, carga una archivo válido");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String ruta = cut.obtenerRuta(2);
        System.out.println(ruta);
        if(!ruta.equals("")){
            jProgressBar5.setValue(100);
            jButton4.setEnabled(false);
            tdb.setDoc_tres(ruta);
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor, carga una archivo válido");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String ruta = cut.obtenerRuta(2);
        System.out.println(ruta);
        if(!ruta.equals("")){
            jProgressBar4.setValue(100);
            jButton5.setEnabled(false);
            tdb.setDoc_cuatro(ruta);
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor, carga una archivo válido");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String ruta = cut.obtenerRuta(2);
        System.out.println(ruta);
        if(!ruta.equals("")){
            jProgressBar2.setValue(100);
            jButton6.setEnabled(false);
            tdb.setDoc_cinco(ruta);
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor, carga una archivo válido");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnEliminarUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUnoActionPerformed
        // TODO add your handling code here:
            tdb.setDoc_uno("");
            jProgressBar1.setValue(0);
            jButton7.setEnabled(true);
    }//GEN-LAST:event_btnEliminarUnoActionPerformed

    private void btnEliminarDosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDosActionPerformed
        // TODO add your handling code here:
            tdb.setDoc_dos("");
            jProgressBar3.setValue(0);
            jButton3.setEnabled(true);
    }//GEN-LAST:event_btnEliminarDosActionPerformed

    private void btnEliminarTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTresActionPerformed
        // TODO add your handling code here:
            tdb.setDoc_tres("");
            jProgressBar5.setValue(0);
            jButton4.setEnabled(true);
    }//GEN-LAST:event_btnEliminarTresActionPerformed

    private void btnEliminarCuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCuatroActionPerformed
        // TODO add your handling code here:
            tdb.setDoc_cuatro("");
            jProgressBar4.setValue(0);
            jButton5.setEnabled(true);
    }//GEN-LAST:event_btnEliminarCuatroActionPerformed

    private void btnEliminarCincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCincoActionPerformed
        // TODO add your handling code here:
            tdb.setDoc_cinco("");
            jProgressBar2.setValue(0);
            jButton6.setEnabled(true);
    }//GEN-LAST:event_btnEliminarCincoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       cbd.openConnection();
       int procesoExitoso = 0;
        System.out.println(tdb.toString());
       if(!tdb.getDoc_uno().isEmpty() && !tdb.getDoc_dos().isEmpty() && 
               !tdb.getDoc_tres().isEmpty() && 
               !tdb.getDoc_cuatro().isEmpty()&& 
               !tdb.getDoc_cinco().isEmpty()){
        procesoExitoso = cbd.insertaDocumentos(tdb);
        if(procesoExitoso !=0){
                JOptionPane.showMessageDialog(null, "Se guardaron los documentos de manera éxitosa.");
//                documentosBeneficiario docben = new documentosBeneficiario(ageObra, tbf);
//                docben.show();
                catalogoObras cob = new catalogoObras(ageObra);
                cob.show();
                this.dispose();
           }
        else{
               JOptionPane.showMessageDialog(null, "No se guardaron los documentos de manera éxitosa.");
        }
       }
       else{
            JOptionPane.showMessageDialog(null, "Por favor, ingresa toda la documentación solicitada.");
       }
       
       cbd.closeConnection();
    }//GEN-LAST:event_jButton1ActionPerformed

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
//            java.util.logging.Logger.getLogger(documentosBeneficiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(documentosBeneficiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(documentosBeneficiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(documentosBeneficiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new documentosBeneficiario().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a;
    private javax.swing.JButton btnEliminarCinco;
    private javax.swing.JButton btnEliminarCuatro;
    private javax.swing.JButton btnEliminarDos;
    private javax.swing.JButton btnEliminarTres;
    private javax.swing.JButton btnEliminarUno;
    private javax.swing.JLabel derecha_Botton;
    private javax.swing.JLabel izquierda_Button;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JProgressBar jProgressBar5;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
