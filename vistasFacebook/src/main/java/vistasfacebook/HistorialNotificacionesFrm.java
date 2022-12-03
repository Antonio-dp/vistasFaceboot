/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistasfacebook;

import comVista.IComunicadorVista;
import entidades.Notificacion;
import entidades.Usuario;
import events.ConsultarNotificacionesPorRemitenteEvent;
import events.ConsultarUsuarioEvent;
import interfaces.IConsultarNotificacionesPorRemitenteObserver;
import interfaces.IConsultarUsuarioObserver;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JOptionPane;
import peticiones.PeticionNotificaciones;
import peticiones.PeticionUsuario;

/**
 *
 * @author jegav
 */
public class HistorialNotificacionesFrm extends javax.swing.JFrame implements IConsultarNotificacionesPorRemitenteObserver{

    private Usuario usuario;
    private IComunicadorVista comunicadorVista;
    /**
     * Creates new form HistorialNotificacionesFrm
     */
    public HistorialNotificacionesFrm(Usuario usuario, IComunicadorVista comunicadorVista) {
        initComponents();
        //this.jPanel1.setPreferredSize(new Dimension(0, 20));
        this.usuario = usuario;
        this.comunicadorVista = comunicadorVista;
        ConsultarNotificacionesPorRemitenteEvent.getInstance().suscribirse(this);
        comunicadorVista.consultarNotificacionesPorRemitente(usuario);
        //comunicadorVista.cosultarUsuarioPorId(usuario.getId());
    }
    
    public void llenarNotificaciones(List<Notificacion> notificaciones){
        this.notificacionesContainer.removeAll();
        for (Notificacion notificacion: notificaciones) {
            //this.comentariosTextPane.insertComponent(new NotificacionPanel(notificacion));
            NotificacionPanel notificacionPanel = new NotificacionPanel(notificacion);
            //notificacionPanel.setPreferredSize(new Dimension(0, 50));
            this.notificacionesContainer.add(notificacionPanel, 0);
            this.notificacionesContainer.repaint();
            this.notificacionesContainer.revalidate();
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

        principalPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notificacionesContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Historial de Notificaciones");
        setResizable(false);
        setSize(new java.awt.Dimension(378, 540));

        principalPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(37, 161, 142));
        jPanel1.setPreferredSize(new java.awt.Dimension(360, 0));

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Historial del Notificaciones");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        notificacionesContainer.setBackground(new java.awt.Color(255, 255, 255));
        notificacionesContainer.setLayout(new javax.swing.BoxLayout(notificacionesContainer, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(notificacionesContainer);

        javax.swing.GroupLayout principalPanelLayout = new javax.swing.GroupLayout(principalPanel);
        principalPanel.setLayout(principalPanelLayout);
        principalPanelLayout.setHorizontalGroup(
            principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        principalPanelLayout.setVerticalGroup(
            principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cerrarFrame();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void cerrarFrame(){
        ConsultarNotificacionesPorRemitenteEvent.getInstance().desuscribirse(this);
        MuroFrm muro = new MuroFrm(comunicadorVista, usuario);
        this.dispose();
        muro.setVisible(true);
    }
    
    /**
////     * @param args the command line arguments
////     */
////    public static void main(String args[]) {
////        /* Set the Nimbus look and feel */
////        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
////        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
////         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
////         */
////        try {
////            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
////                if ("Nimbus".equals(info.getName())) {
////                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
////                    break;
////                }
////            }
////        } catch (ClassNotFoundException ex) {
////            java.util.logging.Logger.getLogger(HistorialNotificacionesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (InstantiationException ex) {
////            java.util.logging.Logger.getLogger(HistorialNotificacionesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (IllegalAccessException ex) {
////            java.util.logging.Logger.getLogger(HistorialNotificacionesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
////            java.util.logging.Logger.getLogger(HistorialNotificacionesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        }
////        //</editor-fold>
////
////        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new HistorialNotificacionesFrm().setVisible(true);
////            }
////        });
////    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel notificacionesContainer;
    private javax.swing.JPanel principalPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onConsultarNotificacionesPorRemitente(PeticionNotificaciones peticionNotificaciones) {
        System.out.println("Consulta las Notificaciones y Notifica");
        if(peticionNotificaciones.getStatus() >= 400){
            JOptionPane.showMessageDialog(this, peticionNotificaciones.getMensajeError(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
            cerrarFrame();
        } else{
            this.llenarNotificaciones(peticionNotificaciones.getNotificaciones());
        }
    }

}
