/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Principal;

import Controlador.ControladorBaseDeDatos;
import Controlador.ControladorUtilerias;
import Modelo.TablaUsuarios;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 * @author Ángel González Rincón
 * Date: 01-sep-2021
 */
public class accesoPrincipal extends javax.swing.JFrame {

    /**
     * Acceso principal, ventana de loggeo.
     */
    ControladorBaseDeDatos lbd = new ControladorBaseDeDatos();
    ControladorUtilerias ltc = new ControladorUtilerias();
    TablaUsuarios tbu = new TablaUsuarios();
    
    int clicks_u = 0;
    int clicks_p = 0;    
    
    public accesoPrincipal() {
        initComponents();
        Pass_Text.setEchoChar((char)0);
        Pass_Text.setText("");
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

        jPanel1 = new javax.swing.JPanel();
        Button_Entrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        User_TextField = new javax.swing.JTextField();
        CheckBoxPassword = new javax.swing.JCheckBox();
        Pass_Text = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Obras Públicas");
        setLocation(new java.awt.Point(0, 0));
        setPreferredSize(new java.awt.Dimension(615, 589));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        Button_Entrar.setBackground(new java.awt.Color(255, 255, 255));
        Button_Entrar.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Button_Entrar.setText("ENTRAR");
        Button_Entrar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 6, 4, new java.awt.Color(0, 0, 0)));
        Button_Entrar.setOpaque(false);
        Button_Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_EntrarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/usuario_icono.png"))); // NOI18N

        User_TextField.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        User_TextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        User_TextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        User_TextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                User_TextFieldMouseClicked(evt);
            }
        });

        CheckBoxPassword.setBackground(new java.awt.Color(255, 255, 255));
        CheckBoxPassword.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        CheckBoxPassword.setText("Mostrar contraseña");
        CheckBoxPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxPasswordActionPerformed(evt);
            }
        });

        Pass_Text.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        Pass_Text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Pass_Text.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        Pass_Text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pass_TextMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Button_Entrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(CheckBoxPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(231, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Pass_Text)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1))
                    .addComponent(User_TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                .addGap(207, 207, 207))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(User_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Pass_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CheckBoxPassword)
                .addGap(18, 18, 18)
                .addComponent(Button_Entrar)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 600, 430));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(143, 195, 131));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jTextField1.setEnabled(false);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 600, 70));

        jTextField3.setEditable(false);
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 600, 40));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jTextField2.setText(" Obras Públicas");
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void User_TextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_User_TextFieldMouseClicked
        if(clicks_u == 0){
        User_TextField.setText("");
        } 
        clicks_u ++;
    }//GEN-LAST:event_User_TextFieldMouseClicked

    private void CheckBoxPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxPasswordActionPerformed
        if(CheckBoxPassword.isSelected()){
            Pass_Text.setEchoChar((char)0);
        }else{
            Pass_Text.setEchoChar('*');
        }
    }//GEN-LAST:event_CheckBoxPasswordActionPerformed

    private void Pass_TextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pass_TextMouseClicked
        if(clicks_p == 0){
        Pass_Text.setText("");
        Pass_Text.setEchoChar('*');
        } 
        clicks_p ++;
    }//GEN-LAST:event_Pass_TextMouseClicked

    private void Button_EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_EntrarActionPerformed
        clicks_u = 0;
        clicks_p = 0;
        //Ya puedo hacer uso de la conexión
        lbd.openConnection();
        String usuario = User_TextField.getText();
        String password = Pass_Text.getText();
        tbu.setUsername(usuario);
        tbu.setPassword(password);
        TablaUsuarios tablaUser =  lbd.obtenerUsuario(tbu);
        if(tablaUser.getId() > 0){
            JOptionPane.showMessageDialog(null, "Bienvenido al Sistema");
            ventanaPrincipal ventanaPrincipal = new ventanaPrincipal();
            this.dispose();
            ventanaPrincipal.show();
        }else{
            JOptionPane.showMessageDialog(null, "Verifica tus datos.");
        }
        lbd.closeConnection();
                
    }//GEN-LAST:event_Button_EntrarActionPerformed

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
            java.util.logging.Logger.getLogger(accesoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(accesoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(accesoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(accesoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new accesoPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Entrar;
    private javax.swing.JCheckBox CheckBoxPassword;
    private javax.swing.JPasswordField Pass_Text;
    private javax.swing.JTextField User_TextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
