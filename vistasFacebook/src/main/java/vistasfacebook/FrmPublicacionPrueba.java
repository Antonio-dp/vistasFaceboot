/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistasfacebook;

import comVista.IComunicadorVista;
import entidades.EtiquetaUsuario;
import entidades.Hashtag;
import entidades.Publicacion;
import entidades.Usuario;
import events.RegistrarHashtagsEvent;
import events.RegistrarPublicacionEvent;
import interfaces.IConsultarUsuarioPorNombreObserver;
import interfaces.IRegistrarHashtagsObserver;
import interfaces.IRegistrarPublicacionObserver;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import peticiones.PeticionHashtags;
import peticiones.PeticionPublicacion;
import peticiones.PeticionUsuario;

/**
 *
 * @author tonyd
 */
public class FrmPublicacionPrueba extends javax.swing.JFrame implements IRegistrarPublicacionObserver{

    private IComunicadorVista comunicadorVista;
    private Usuario usuario;
    private String path;
    List<EtiquetaUsuario> etiquetados;
    List<Hashtag> hashtags;

    /**
     * Creates new form FrmPublicacionPrueba
     *
     * @param comunicadorVista
     */
    public FrmPublicacionPrueba(IComunicadorVista comunicadorVista) {
        initComponents();
        this.comunicadorVista = comunicadorVista;
        RegistrarPublicacionEvent.getInstance().suscribirse(this);
        txtContenido.setLineWrap(true);
    }

    public FrmPublicacionPrueba(Usuario usuario, IComunicadorVista comunicadorVista) {
        initComponents();
        this.usuario = usuario;
        this.hashtags = new ArrayList<Hashtag>();
        this.etiquetados = new ArrayList<EtiquetaUsuario>();
        this.comunicadorVista = comunicadorVista;
        RegistrarPublicacionEvent.getInstance().suscribirse(this);
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
        lbltitulo = new javax.swing.JLabel();
        barra1 = new javax.swing.JLabel();
        barra2 = new javax.swing.JLabel();
        lblContenido = new javax.swing.JLabel();
        lblNombreImagen = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtContenido = new javax.swing.JTextArea();
        btnImagen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Publicación");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(241, 250, 238));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbltitulo.setBackground(new java.awt.Color(255, 255, 255));
        lbltitulo.setFont(new java.awt.Font("Amarillo", 2, 24)); // NOI18N
        lbltitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbltitulo.setText("Registrar Publicación");
        jPanel1.add(lbltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 350, 70));

        barra1.setBackground(new java.awt.Color(37, 161, 142));
        barra1.setOpaque(true);
        jPanel1.add(barra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 910, 60));

        barra2.setBackground(new java.awt.Color(37, 161, 142));
        barra2.setOpaque(true);
        jPanel1.add(barra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 60));

        lblContenido.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblContenido.setText("Contenido:");
        jPanel1.add(lblContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        lblNombreImagen.setBackground(new java.awt.Color(255, 255, 255));
        lblNombreImagen.setOpaque(true);
        jPanel1.add(lblNombreImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 620, 35));

        btnGuardar.setBackground(new java.awt.Color(37, 161, 142));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Publicar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 470, 180, 35));

        btnCancelar.setBackground(new java.awt.Color(37, 161, 142));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, 180, 35));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        txtContenido.setColumns(20);
        txtContenido.setRows(5);
        txtContenido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContenidoKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtContenido);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 830, 220));

        btnImagen.setBackground(new java.awt.Color(37, 161, 142));
        btnImagen.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnImagen.setForeground(new java.awt.Color(255, 255, 255));
        btnImagen.setText("Adjuntar Imagen");
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });
        jPanel1.add(btnImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 180, 35));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        Calendar fecha = Calendar.getInstance();
        guardarHashtags(txtContenido.getText());
        guardarEtiquetas(txtContenido.getText());
        Publicacion nuevaPublicacion = new Publicacion(usuario, fecha, txtContenido.getText(), path);
        if(!hashtags.isEmpty()){
            nuevaPublicacion.setHashtagPublicacion(hashtags);
        }
        if (!etiquetados.isEmpty()) {
            nuevaPublicacion.setEtiquetasPublicacion(etiquetados);
        }
        comunicadorVista.registrarPublicacion(nuevaPublicacion);
    }//GEN-LAST:event_btnGuardarActionPerformed

    public void guardarHashtags(String contenido) {
        String[] palabrasContenido = contenido.split(" ");
        for (String palabra: palabrasContenido) {
            if(palabra.startsWith("#")){
                hashtags.add(new Hashtag(palabra));
            }
        }
    }

    public void guardarEtiquetas(String contenido) {
        String[] palabrasContenido = contenido.split(" ");
        for (String palabra : palabrasContenido) {
            if (palabra.startsWith("@")) {
                String etiqueta = palabra.replace("@", "");
                System.out.println(etiqueta);
                EtiquetaUsuario e = new EtiquetaUsuario(palabra.replace("@", ""));
                etiquetados.add(e);
            }
        }
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        //ManejadorEventos.getInstance().desuscribirseRegistrarPublicacion(this);
        RegistrarPublicacionEvent.getInstance().desuscribirse(this);
        MuroFrm m = new MuroFrm(comunicadorVista, usuario);
        m.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
        fileChooser.setFileFilter(imgFilter);

        int result = fileChooser.showOpenDialog(this);

        if (result != JFileChooser.CANCEL_OPTION) {

            String archivo = fileChooser.getSelectedFile().getAbsolutePath();
            File file = new File(archivo);

            ImageIcon icon = new ImageIcon(new ImageIcon(archivo).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

            String newPath = "src\\imagenes";
            File directorio = new File(newPath);
            if (!directorio.exists()) {
                directorio.mkdirs();
            }

            File sourceFile = null;
            File destinoFile = null;
            path = newPath + "\\" + Math.random() + fileChooser.getSelectedFile().getName();
            String extension = archivo.substring(archivo.lastIndexOf('.') + 1);
            sourceFile = new File(archivo);
            destinoFile = new File(path);
            try {
                Files.copy(sourceFile.toPath(), destinoFile.toPath());

                this.lblNombreImagen.setText(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnImagenActionPerformed

    private void txtContenidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContenidoKeyTyped
        if (txtContenido.getText().length() == 255) {
            evt.consume();
        }
    }//GEN-LAST:event_txtContenidoKeyTyped

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
//            java.util.logging.Logger.getLogger(FrmPublicacionPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmPublicacionPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmPublicacionPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmPublicacionPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmPublicacionPrueba().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barra1;
    private javax.swing.JLabel barra2;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblContenido;
    private javax.swing.JLabel lblNombreImagen;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JTextArea txtContenido;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onRegistrarPublicacion(PeticionPublicacion peticionPublicacion) {
        if (peticionPublicacion.getStatus() < 400) {
            JOptionPane.showMessageDialog(this, "Se registro la publicación correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            this.hashtags.clear();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo registrar la publicacion", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
