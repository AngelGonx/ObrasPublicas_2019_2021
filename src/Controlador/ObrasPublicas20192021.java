package Controlador;

import Vista.Principal.accesoPrincipal;

/**
 * @author Ángel González Rincón
 * Date: 30-ago-2021
 */
public class ObrasPublicas20192021 {

    public static void main(String[] args) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ObrasPublicas20192021.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ObrasPublicas20192021.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ObrasPublicas20192021.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ObrasPublicas20192021.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        accesoPrincipal mainPrincipal = new accesoPrincipal();
        mainPrincipal.show();        
        
    }
    
}
