package GUI;

import DataSrc.User;
import Logic.DataManipulation;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Rubén Darío Martínez
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
        this.setLocationRelativeTo(null);
        transparenciaButton();
    }

    
    public void transparenciaButton(){
        Back.setOpaque(false);
        Back.setContentAreaFilled(false);
        Back.setBorderPainted(false);
        
        Registrar.setOpaque(false);
        Registrar.setContentAreaFilled(false);
        Registrar.setBorderPainted(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nombres = new javax.swing.JTextField();
        Correo = new javax.swing.JTextField();
        Contraseña = new javax.swing.JTextField();
        Telefono = new javax.swing.JTextField();
        Cedula = new javax.swing.JTextField();
        Nacimiento = new javax.swing.JTextField();
        Apellidos = new javax.swing.JTextField();
        Registrar = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nombres.setFont(new java.awt.Font("Rubik", 1, 18)); // NOI18N
        Nombres.setForeground(new java.awt.Color(61, 61, 61));
        Nombres.setToolTipText("User");
        Nombres.setBorder(null);
        Nombres.setSelectedTextColor(new java.awt.Color(87, 81, 81));
        Nombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombresActionPerformed(evt);
            }
        });
        getContentPane().add(Nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 190, 30));

        Correo.setFont(new java.awt.Font("Rubik", 1, 18)); // NOI18N
        Correo.setForeground(new java.awt.Color(61, 61, 61));
        Correo.setToolTipText("User");
        Correo.setBorder(null);
        Correo.setSelectedTextColor(new java.awt.Color(87, 81, 81));
        Correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorreoActionPerformed(evt);
            }
        });
        getContentPane().add(Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 220, 20));

        Contraseña.setFont(new java.awt.Font("Rubik", 1, 18)); // NOI18N
        Contraseña.setForeground(new java.awt.Color(61, 61, 61));
        Contraseña.setToolTipText("User");
        Contraseña.setBorder(null);
        Contraseña.setSelectedTextColor(new java.awt.Color(87, 81, 81));
        Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseñaActionPerformed(evt);
            }
        });
        getContentPane().add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 180, 30));

        Telefono.setFont(new java.awt.Font("Rubik", 1, 18)); // NOI18N
        Telefono.setForeground(new java.awt.Color(61, 61, 61));
        Telefono.setToolTipText("User");
        Telefono.setBorder(null);
        Telefono.setSelectedTextColor(new java.awt.Color(87, 81, 81));
        Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, 190, 30));

        Cedula.setFont(new java.awt.Font("Rubik", 1, 18)); // NOI18N
        Cedula.setForeground(new java.awt.Color(61, 61, 61));
        Cedula.setToolTipText("User");
        Cedula.setBorder(null);
        Cedula.setSelectedTextColor(new java.awt.Color(87, 81, 81));
        Cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CedulaActionPerformed(evt);
            }
        });
        getContentPane().add(Cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 580, 210, 30));

        Nacimiento.setFont(new java.awt.Font("Rubik", 1, 18)); // NOI18N
        Nacimiento.setForeground(new java.awt.Color(61, 61, 61));
        Nacimiento.setToolTipText("User");
        Nacimiento.setBorder(null);
        Nacimiento.setSelectedTextColor(new java.awt.Color(87, 81, 81));
        Nacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NacimientoActionPerformed(evt);
            }
        });
        getContentPane().add(Nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 650, 180, 30));

        Apellidos.setFont(new java.awt.Font("Rubik", 1, 18)); // NOI18N
        Apellidos.setForeground(new java.awt.Color(61, 61, 61));
        Apellidos.setToolTipText("User");
        Apellidos.setBorder(null);
        Apellidos.setSelectedTextColor(new java.awt.Color(87, 81, 81));
        Apellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApellidosActionPerformed(evt);
            }
        });
        getContentPane().add(Apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 288, 200, -1));

        Registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 710, 200, 50));

        Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src_images/Register.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombresActionPerformed

    private void CorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CorreoActionPerformed

    private void ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContraseñaActionPerformed

    private void TelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelefonoActionPerformed

    private void CedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CedulaActionPerformed

    private void NacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NacimientoActionPerformed

    private void ApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApellidosActionPerformed

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        // TODO add your handling code here:
        if(DataManipulation.listaUsuariosHM.containsKey(Cedula.getText())){
            JOptionPane.showMessageDialog(null,"Usuario ya exitente con la cedula escrita.");          
        } else if(Nombres.getText().isEmpty() || Apellidos.getText().isEmpty() || Cedula.getText().isEmpty() ||
                  Contraseña.getText().isEmpty() || Correo.getText().isEmpty() || Nacimiento.getText().isEmpty() 
                ||Telefono.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Faltan Campos por llenar, verifique.");          
        } else{
            DataManipulation.listaUsuariosHM.put(Cedula.getText(),
                    new User(Nombres.getText(),
                            Apellidos.getText(),
                            Correo.getText(),
                            Contraseña.getText(), 
                            Cedula.getText(),
                            Nacimiento.getText()));
            JOptionPane.showMessageDialog(null,"Usuario creado con exito");
            new Login().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_RegistrarActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apellidos;
    private javax.swing.JButton Back;
    private javax.swing.JTextField Cedula;
    private javax.swing.JTextField Contraseña;
    private javax.swing.JTextField Correo;
    private javax.swing.JTextField Nacimiento;
    private javax.swing.JTextField Nombres;
    private javax.swing.JButton Registrar;
    private javax.swing.JTextField Telefono;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
