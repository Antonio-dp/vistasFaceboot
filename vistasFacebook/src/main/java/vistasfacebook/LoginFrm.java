/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistasfacebook;

import comVista.ComunicadorVista;
import comVista.EventListener;
import comVista.IComunicadorVista;
import entidades.Usuario;
import events.LoginEvent;
import interfaces.ILoginFacebookObserver;
import interfaces.ILoginObserver;
import javax.swing.JOptionPane;
import logins.FacebookStrategy;
import logins.FacebootStrategy;
import logins.LoginContext;
import peticiones.PeticionUsuario;
import utils.Validaciones;

/**
 * Frame para realizar el login
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class LoginFrm extends javax.swing.JFrame implements ILoginObserver, ILoginFacebookObserver  {
    /**
     * Comunicador con vista
     */
    private IComunicadorVista comunicadorVista;
    /**
     * Contexto de login
     */
    private LoginContext loginContext;
    /**
     * Constructor que instancia las variables a las de su parametro
     * @param comunicadorVista comunicador con vista
     */
    public LoginFrm(IComunicadorVista comunicadorVista) {
        initComponents();
        this.loginContext = new LoginContext();
        lblLogo.setIcon(new javax.swing.ImageIcon("src\\main\\java\\imagenes\\faceboot.png"));
        lblImgUser.setIcon(new javax.swing.ImageIcon("src\\main\\java\\imagenes\\login.png"));
        this.comunicadorVista = comunicadorVista;
        LoginEvent.getInstance().suscribirse(this);
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
        lblImgUser = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblO = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtCorreoUser = new javax.swing.JTextField();
        btnRegistrate = new javax.swing.JButton();
        btnEntraFacebook = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        barra1 = new javax.swing.JLabel();
        barra2 = new javax.swing.JLabel();
        rectangulo1 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Faceboot");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(243, 250, 242));
        jPanel1.setMinimumSize(new java.awt.Dimension(910, 600));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(lblImgUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 70, 80));

        lblPassword.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblPassword.setText("Contrase??a");
        jPanel1.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblUsuario.setText("Correo");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, -1));

        lblO.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblO.setText("--------------------------- O ------------------------");
        jPanel1.add(lblO, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 350, 35));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 250, 30));

        txtCorreoUser.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(txtCorreoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 250, 33));

        btnRegistrate.setText("??No tienes cuenta? Registrate");
        btnRegistrate.setBackground(new java.awt.Color(159, 255, 203));
        btnRegistrate.setBorder(null);
        btnRegistrate.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnRegistrate.setToolTipText("");
        btnRegistrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrateActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 350, 33));

        btnEntraFacebook.setText("Entra con Facebook");
        btnEntraFacebook.setBackground(new java.awt.Color(59, 89, 152));
        btnEntraFacebook.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnEntraFacebook.setForeground(new java.awt.Color(255, 255, 255));
        btnEntraFacebook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntraFacebookActionPerformed(evt);
            }
        });
        jPanel1.add(btnEntraFacebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, 350, 35));

        btnIngresar.setBackground(new java.awt.Color(37, 161, 142));
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("INGRESAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 350, 33));

        barra1.setBackground(new java.awt.Color(37, 161, 142));
        barra1.setOpaque(true);
        jPanel1.add(barra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 575, 910, 25));

        barra2.setBackground(new java.awt.Color(37, 161, 142));
        barra2.setOpaque(true);
        jPanel1.add(barra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 25));

        rectangulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rectangulo1.setBackground(new java.awt.Color(159, 255, 203));
        rectangulo1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        rectangulo1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rectangulo1.setOpaque(true);
        jPanel1.add(rectangulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 500, 360));
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 230, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Permite registrar el usuario para login
     * @param evt al presionar el boton
     */
    private void btnRegistrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrateActionPerformed
        this.dispose();
        LoginEvent.getInstance().desuscribir(this);
        RegistrarUsuarioFrm registro = new RegistrarUsuarioFrm(comunicadorVista);
        registro.setVisible(true);
    }//GEN-LAST:event_btnRegistrateActionPerformed
    /**
     * Permite realizar el login en la aplicacion
     * @param evt al presionar el boton
     */
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if(!Validaciones.validarCorreo(txtCorreoUser.getText())){
            JOptionPane.showMessageDialog(this, "El correo no cuenta con un formato correcto", "Informaci??n", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Usuario usuario = new Usuario(this.txtCorreoUser.getText(),this.txtPassword.getText());
        loginContext.setLoginStrategy(new FacebootStrategy(comunicadorVista));
        loginContext.realizarLogin(usuario);
    }//GEN-LAST:event_btnIngresarActionPerformed
    /**
     * Permite realizar el login por facebook
     * @param evt al presionar el boton
     */
    private void btnEntraFacebookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntraFacebookActionPerformed
        loginContext.setLoginStrategy(new FacebookStrategy(comunicadorVista));
        loginContext.realizarLogin(null);
    }//GEN-LAST:event_btnEntraFacebookActionPerformed

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
            java.util.logging.Logger.getLogger(LoginFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        EventListener.getInstance().iniciarListener();
        IComunicadorVista comunicadorVista = new ComunicadorVista();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrm(comunicadorVista).setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barra1;
    private javax.swing.JLabel barra2;
    private javax.swing.JButton btnEntraFacebook;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegistrate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImgUser;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblO;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel rectangulo1;
    private javax.swing.JTextField txtCorreoUser;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
    /**
     * Recibe la peticionUsuario con la accion realizada
     * @param peticionUsuario
     */
    @Override
    public void onLogin(PeticionUsuario peticionUsuario) {
        manejarLogin(peticionUsuario);
    }
    /**
     * Recibe la peticionUsuario con la accion realizada
     * @param usuario 
     */
    @Override
    public void onLoginFacebook(PeticionUsuario usuario) {        
        manejarLogin(usuario);
    }
    /**
     * Permite manejar el login de la aplicacion
     * @param peticionUsuario usuario validado
     */
    public void manejarLogin(PeticionUsuario peticionUsuario){
        if (peticionUsuario.getStatus() < 400) {
            verificarTelefono(peticionUsuario.getUsuario());
            this.dispose();
            LoginEvent.getInstance().desuscribir(this);
            MuroFrm muro = new MuroFrm(comunicadorVista, peticionUsuario.getUsuario());
            muro.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, peticionUsuario.getMensajeError(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    /**
     * Permite verificar el numero de telefono del usuario a logear
     * @param usuario usuario con numero a validar
     */
    public void verificarTelefono(Usuario usuario) {
        if (usuario.getTelefono() == null) {
            String telefono = "";
            do {
                telefono = JOptionPane.showInputDialog("Inserta tu telefono");
                if (!Validaciones.validarTelefono(telefono)) {
                    JOptionPane.showMessageDialog(this, "Formato de tel??fono erroneo");
                }
            } while (!Validaciones.validarTelefono(telefono));
            usuario.setTelefono(telefono);
            comunicadorVista.editarUsuario(usuario);
        }
    }

}
