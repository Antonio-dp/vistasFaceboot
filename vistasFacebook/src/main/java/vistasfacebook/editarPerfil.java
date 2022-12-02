/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistasfacebook;

import comVista.IComunicadorVista;
import entidades.Usuario;
import enumeradores.Sexo;
import events.EditarUsuarioEvent;
import interfaces.IEditarUsuarioObserver;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import peticiones.PeticionUsuario;
import utils.ConversorFechas;
import utils.IConversorFechas;



/**
 *
 * @author tonyd
 */
public class EditarPerfil extends javax.swing.JFrame implements IEditarUsuarioObserver {

    private IComunicadorVista comunicadorVista;
    private Usuario usuario;

    /**
     * Creates new form Registro
     */
    public EditarPerfil(IComunicadorVista comunicadorVista, Usuario usuario) {
        initComponents();
        llenarComboBoxSexo();
        this.usuario = usuario;
        this.comunicadorVista = comunicadorVista;
        this.txtEmail.setEditable(false);
        this.txtNoCelular.setEditable(false);
        llenarCampos(usuario);
        EditarUsuarioEvent.getInstance().suscribirse(this);
    }
    
    public void llenarCampos(Usuario usuario){
        IConversorFechas conversorFechas = new ConversorFechas();
        this.txtNombre.setText(usuario.getNombre());
        this.txtEmail.setText(usuario.getEmail());
        this.txtNoCelular.setText(usuario.getTelefono());
        if(usuario.getFechaNacimiento()!=null){
            this.txtFechaNacimiento.setDate(conversorFechas.toLocalDate(usuario.getFechaNacimiento()));
        }
        this.cbSexo.setSelectedItem(usuario.getSexo());
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
        lblNoCelular = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        lblIcoFacebbok = new javax.swing.JLabel();
        lblIcoGoogle = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtNoCelular = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtFechaNacimiento = new com.github.lgooddatepicker.components.DatePicker();
        cbSexo = new javax.swing.JComboBox<>();
        btnCancel = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        barra1 = new javax.swing.JLabel();
        barra2 = new javax.swing.JLabel();
        rectangulo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editar Perfil");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.setMinimumSize(new java.awt.Dimension(910, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNoCelular.setText("No. Celular");
        lblNoCelular.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel1.add(lblNoCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        lblFechaNacimiento.setText("Fecha de nacimiento");
        lblFechaNacimiento.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel1.add(lblFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        lblSexo.setText("Sexo");
        lblSexo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel1.add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, -1, -1));

        lblEmail.setText("E-mail");
        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        lblNombre1.setText("Nombre");
        lblNombre1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jPanel1.add(lblNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, -1, -1));
        jPanel1.add(lblIcoFacebbok, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 353, -1, -1));
        jPanel1.add(lblIcoGoogle, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 424, -1, -1));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 530, -1));

        txtNoCelular.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtNoCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoCelularKeyTyped(evt);
            }
        });
        jPanel1.add(txtNoCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 260, -1));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 530, -1));
        jPanel1.add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 260, -1));

        cbSexo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbSexo.setToolTipText("");
        jPanel1.add(cbSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 260, -1));

        btnCancel.setBackground(new java.awt.Color(37, 161, 142));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 180, 35));

        btnActualizar.setText("Guardar Cambios");
        btnActualizar.setBackground(new java.awt.Color(37, 161, 142));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 180, 35));

        barra1.setBackground(new java.awt.Color(37, 161, 142));
        barra1.setOpaque(true);
        jPanel1.add(barra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 910, 60));

        barra2.setBackground(new java.awt.Color(37, 161, 142));
        barra2.setOpaque(true);
        jPanel1.add(barra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 60));

        rectangulo1.setBackground(new java.awt.Color(204, 255, 204));
        rectangulo1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rectangulo1.setOpaque(true);
        jPanel1.add(rectangulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 910, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        IConversorFechas conversorFechas = new ConversorFechas();
        if(validarVacios()){
            JOptionPane.showMessageDialog(this, "Algún campo se encuentra vacio", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String nombre = this.txtNombre.getText();
        Sexo sexo = (Sexo) cbSexo.getSelectedItem();
        Calendar fechaNacimiento = conversorFechas.toCalendar(this.txtFechaNacimiento.getDate());
        usuario.setNombre(nombre);
        usuario.setSexo(sexo);
        usuario.setFechaNacimiento(fechaNacimiento);
        comunicadorVista.EditarUsuario(usuario);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtNoCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoCelularKeyTyped
        if (txtNoCelular.getText().length() >= 10) {
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

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
        EditarUsuarioEvent.getInstance().desuscribirse(this);
        MuroFrm muro = new MuroFrm(comunicadorVista, usuario);
        muro.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

  
    private boolean validarVacios(){
        if(txtNombre.getText().isEmpty()){
            return false;
        }
        if(txtFechaNacimiento.getText().isEmpty()){
            return false;
        }
        return true;
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
    private javax.swing.JLabel barra1;
    private javax.swing.JLabel barra2;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblIcoFacebbok;
    private javax.swing.JLabel lblIcoGoogle;
    private javax.swing.JLabel lblNoCelular;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel rectangulo1;
    private javax.swing.JTextField txtEmail;
    private com.github.lgooddatepicker.components.DatePicker txtFechaNacimiento;
    private javax.swing.JTextField txtNoCelular;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onEditarUsuario(PeticionUsuario respuesta) {
        if (respuesta.getStatus() >= 400){
            JOptionPane.showMessageDialog(this, respuesta.getMensajeError(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(this, "El usuario se actualizó correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
