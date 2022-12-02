/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistasfacebook;

import comVista.IComunicadorVista;
import entidades.Usuario;
import enumeradores.Sexo;
import events.ManejadorEventos;
import events.RegistrarUsuarioEvent;
import interfaces.ILoginFacebookObserver;
import interfaces.IRegistrarUsuarioObserver;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import peticiones.PeticionUsuario;
import utils.ConversorFechas;
import utils.FbConexion;
import utils.IConversorFechas;
import utils.Validaciones;

/**
 *
 * @author tonyd
 */
public class RegistroUsuario extends javax.swing.JFrame implements IRegistrarUsuarioObserver {

    private IComunicadorVista comunicadorVista;

    /**
     * Creates new form Registro
     */
    public RegistroUsuario(IComunicadorVista comunicadorVista) {
        initComponents();
        this.btnAgregar.setIcon(new javax.swing.ImageIcon("src\\main\\java\\imagenes\\registrarBtn.png"));
        llenarComboBoxSexo();
        this.comunicadorVista = comunicadorVista;
        
        RegistrarUsuarioEvent.getInstance().suscribirse(this);
        //suscribeRegistrarComentario(this);
        //suscribeRegistrarPublicacion(this);
    }

    public void llenarComboBoxSexo(){
        cbSexo.setModel(new DefaultComboBoxModel(Sexo.values()));
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
        facebookBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblNoCelular = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblRegistraCon = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        lblYaTienesCuenta = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtNoCelular = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtFechaNacimiento = new com.github.lgooddatepicker.components.DatePicker();
        cbSexo = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnIniciarSesion = new javax.swing.JButton();
        barra2 = new javax.swing.JLabel();
        rectangulo1 = new javax.swing.JLabel();
        rectangulo2 = new javax.swing.JLabel();
        rectangulo3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Usuario");

        jPanel1.setBackground(new java.awt.Color(241, 250, 238));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.setMinimumSize(new java.awt.Dimension(910, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        facebookBtn.setBackground(new java.awt.Color(212, 237, 231));
        facebookBtn.setBorder(null);
        jPanel1.add(facebookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 330, 120, 130));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registro");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        lblNoCelular.setText("No. Celular");
        lblNoCelular.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel1.add(lblNoCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 270, -1, -1));

        lblPassword.setText("Contraseña");
        lblPassword.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel1.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 220, -1, -1));

        lblFechaNacimiento.setText("Fecha de nacimiento");
        lblFechaNacimiento.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel1.add(lblFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 370, -1, -1));

        lblSexo.setText("Sexo");
        lblSexo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel1.add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 320, -1, -1));

        lblEmail.setText("E-mail");
        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        lblRegistraCon.setText("Registra con...");
        lblRegistraCon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jPanel1.add(lblRegistraCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, -1, -1));

        lblNombre1.setText("Nombre");
        lblNombre1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel1.add(lblNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 120, -1, -1));

        lblYaTienesCuenta.setText("¿Ya tienes una cuenta?");
        lblYaTienesCuenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(lblYaTienesCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 140, -1, -1));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 240, -1));

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 240, -1));

        txtNoCelular.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtNoCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoCelularKeyTyped(evt);
            }
        });
        jPanel1.add(txtNoCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 240, -1));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 240, -1));
        jPanel1.add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 250, -1));

        cbSexo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbSexo.setToolTipText("");
        jPanel1.add(cbSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 130, -1));

        btnAgregar.setText("Registrar");
        btnAgregar.setBackground(new java.awt.Color(37, 161, 142));
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 180, 35));

        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.setBackground(new java.awt.Color(37, 161, 142));
        btnIniciarSesion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 180, 35));

        barra2.setBackground(new java.awt.Color(37, 161, 142));
        barra2.setOpaque(true);
        jPanel1.add(barra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 60));

        rectangulo1.setBackground(new java.awt.Color(212, 237, 231));
        rectangulo1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rectangulo1.setOpaque(true);
        jPanel1.add(rectangulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 500, 400));

        rectangulo2.setBackground(new java.awt.Color(212, 237, 231));
        rectangulo2.setOpaque(true);
        jPanel1.add(rectangulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 275, 320, 220));

        rectangulo3.setBackground(new java.awt.Color(212, 237, 231));
        rectangulo3.setOpaque(true);
        jPanel1.add(rectangulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 320, 150));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
<<<<<<< HEAD:vistasFacebook/src/main/java/vistasfacebook/Registro.java
        IConversorFechas conversorFechas = new ConversorFechas();
=======
        if(!validarVacios()){
            JOptionPane.showMessageDialog(this, "Cuenta con algun campo vacio", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
>>>>>>> d5fcf00d9ca46fa09bf3089c6904780d4ca31a99:vistasFacebook/src/main/java/vistasfacebook/RegistroUsuario.java
        String nombre = this.txtNombre.getText();
        String password = String.valueOf(this.txtPassword.getPassword());
        String email = this.txtEmail.getText();
        String telefono = this.txtNoCelular.getText();
        Sexo sexo = (Sexo) cbSexo.getSelectedItem();
        Calendar fechaNacimiento = conversorFechas.toCalendar(this.txtFechaNacimiento.getDate());
        
        if(!validarPassword(password)){
            JOptionPane.showMessageDialog(this, "La contraseña debe tener un minimo de 8 digitos", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(!Validaciones.validarCorreo(email)){
            JOptionPane.showMessageDialog(this, "El correo no cuenta con un formato correcto", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(!Validaciones.validarTelefono(telefono)){
            JOptionPane.showMessageDialog(this, "El Teléfono no cuenta con un formato correcto", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Usuario usuario = new Usuario(nombre, password, email, telefono, sexo, fechaNacimiento);
        comunicadorVista.registrarUsuario(usuario);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        this.dispose();
        RegistrarUsuarioEvent.getInstance().desuscribirse(this);
        Login login = new Login(comunicadorVista);
        login.setVisible(true);
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void txtNoCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoCelularKeyTyped
        if(txtNoCelular.getText().length() >= 10) {
            evt.consume();
        }

        char caracter = evt.getKeyChar();
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b')) {
            evt.consume(); 
        }
    }//GEN-LAST:event_txtNoCelularKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        if (!Character.isLetter(evt.getKeyChar()) && !(evt.getKeyChar() == KeyEvent.VK_SPACE)
                && !(evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        } 
    }//GEN-LAST:event_txtNombreKeyTyped

<<<<<<< HEAD:vistasFacebook/src/main/java/vistasfacebook/Registro.java
=======
    private void btnEntraFacebookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntraFacebookActionPerformed
        try {
            FbConexion fbCon = new FbConexion();
            Usuario usuario = fbCon.authUser();
            String telefono ="";
            do{
               telefono = JOptionPane.showInputDialog("Inserta tu telefono");
               if(!Validaciones.validarTelefono(telefono)){
                   JOptionPane.showMessageDialog(this, "Formato de teléfono erroneo");
               }
            }while(!Validaciones.validarTelefono(telefono));
            usuario.setTelefono(telefono);
            comunicadorVista.iniciarSesionFacebook(usuario);
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btnEntraFacebookActionPerformed

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        if(txtPassword.getText().length() >= 20) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "La contraseña debe tener 10 caracteres o menos");
        }
    }//GEN-LAST:event_txtPasswordKeyTyped

    private boolean validarPassword(String password){
        if(txtPassword.getText().length()<8){
            return false;
        }
        return true;
    }
    
    private boolean validarVacios(){
        if(txtNombre.getText().isEmpty()){
            return false;
        }
        if(txtEmail.getText().isEmpty()){
            return false;
        }
        if(txtFechaNacimiento.getText().isEmpty()){
            return false;
        }
        if(txtNoCelular.getText().isEmpty()){
            return false;
        }if(txtPassword.getText().isEmpty()){
            return false;
        }
        return true;
    
    }
    
>>>>>>> d5fcf00d9ca46fa09bf3089c6904780d4ca31a99:vistasFacebook/src/main/java/vistasfacebook/RegistroUsuario.java
    @Override
    public void onRegistrarUsuario(PeticionUsuario peticionUsuario) {
        if (peticionUsuario.getStatus() >= 400){
            JOptionPane.showMessageDialog(this, peticionUsuario.getMensajeError(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(this, "El usuario se registro correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
  
//    /**
//     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Registro().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barra2;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JButton facebookBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblNoCelular;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRegistraCon;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblYaTienesCuenta;
    private javax.swing.JLabel rectangulo1;
    private javax.swing.JLabel rectangulo2;
    private javax.swing.JLabel rectangulo3;
    private javax.swing.JTextField txtEmail;
    private com.github.lgooddatepicker.components.DatePicker txtFechaNacimiento;
    private javax.swing.JTextField txtNoCelular;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables

    
}
