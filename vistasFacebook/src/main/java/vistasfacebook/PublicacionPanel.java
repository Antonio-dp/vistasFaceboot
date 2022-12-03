/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistasfacebook;

import comVista.IComunicadorVista;
import entidades.Comentario;
import entidades.Publicacion;
import entidades.Usuario;
import events.ConsultarComentariosEvent;
import events.EliminarComentarioEvent;
import events.RegistrarComentarioEvent;
import interfaces.IConsultarComentariosObserver;
import interfaces.IEliminarComentarioObserver;
import interfaces.IRegistrarComentarioObserver;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import peticiones.PeticionComentario;
import peticiones.PeticionComentarios;
import utils.BorderRadius;
import utils.CustomScrollbar;

/**
 *
 * @author jegav
 */
public class PublicacionPanel extends javax.swing.JPanel implements IRegistrarComentarioObserver,
                                                                    IConsultarComentariosObserver,
                                                                    IEliminarComentarioObserver{

    private Publicacion publicacion;
    private Usuario usuario;
    private IComunicadorVista comunicadorVista;
    private Integer comentarioEliminado;
    
    /**
     * Creates new form PublicacionPanel
     * @param publicacion
     * @param usuario
     * @param comunicadorVista
     */
    public PublicacionPanel(Publicacion publicacion, Usuario usuario, IComunicadorVista comunicadorVista) {
        initComponents();
        RegistrarComentarioEvent.getInstance().suscribirse(this);
        ConsultarComentariosEvent.getInstance().suscribirse(this);
        EliminarComentarioEvent.getInstance().suscribirse(this);
        this.scrollComentarios.setVerticalScrollBar(new CustomScrollbar(new Color(231,240,228), new Color(187, 255, 164)));
        this.scrollComentarios.getVerticalScrollBar().setUnitIncrement(19);
        this.setPreferredSize(new Dimension(584, 645));
        this.jPanel1.setBorder(new BorderRadius(13));
        deleteBtn.setIcon(new javax.swing.ImageIcon("src\\main\\java\\imagenes\\trashIcon.png"));
        this.comunicadorVista = comunicadorVista;
        this.publicacion = publicacion;
        this.usuario = usuario;
        if (publicacion.getUsuario().getId() != usuario.getId()) {
            this.deleteBtn.setVisible(false);
        }
        llenarPanel();
        comunicadorVista.consultarComentariosPorId(publicacion.getId());
    }

    public PublicacionPanel() {
        initComponents();

    }

    private void llenarPanel() {
        this.nombreLbl.setText(publicacion.getUsuario().getNombre());
        this.descripcionLbl.setText(publicacion.getTexto());
        SimpleDateFormat fechaFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = fechaFormat.format(publicacion.getFecha().getTime());
        this.fechaLbl.setText(fecha);

        if (publicacion.getImagen() != null) {
            Image imagenPublicacion = new ImageIcon(publicacion.getImagen()).getImage();
            Image imagenEscalada = imagenPublicacion.getScaledInstance(534, 239, Image.SCALE_SMOOTH);
            this.imageLbl.setIcon(new ImageIcon(imagenEscalada));
            
            this.revalidate();
            this.repaint();
          
            this.jPanel1.revalidate();
            this.jPanel1.repaint();
        }
    }

    public Integer getComentarioEliminado() {
        return comentarioEliminado;
    }

    public void setComentarioEliminado(Integer comentarioEliminado) {
        this.comentarioEliminado = comentarioEliminado;
    }

    private void llenarComentarios(List<Comentario> comentarios) {
//        if(publicacion.getComentarios() == null) {System.out.println("??????"); return;}
//        if(publicacion.getComentarios().isEmpty()){
//            this.comentariosPane.removeAll();
//            System.out.println("AA NMMS");
//            this.comentariosPane.repaint();
//            this.comentariosPane.revalidate();
//        
        if(comentarios == null) return;
        this.comentariosPane.removeAll();
        this.comentariosPane.repaint();
        this.comentariosPane.revalidate();
        
        for (Comentario comentario : comentarios) {
            this.comentariosPane.add(new ComentarioPanel(comentario, usuario, comunicadorVista), 0);
            this.comentariosPane.repaint();
            this.comentariosPane.revalidate();
            this.jPanel1.repaint();
            this.jPanel1.revalidate();
        }
    }

    private void llenarComentario(Comentario comentario) {
        
        this.comentariosPane.add(new ComentarioPanel(comentario, usuario, comunicadorVista),0);
        this.comentariosPane.repaint();
        this.comentariosPane.revalidate();
        this.jPanel1.repaint();
        this.jPanel1.revalidate();
//        System.out.println("Lleno el comentario: "+comentario.getContenido());
//        this.comentarioPane.insertComponent(new ComentarioPanel(comentario));
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
        nombreLbl = new javax.swing.JLabel();
        descripcionLbl = new javax.swing.JLabel();
        fechaLbl = new javax.swing.JLabel();
        txtComentario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnRegistrarComentario = new javax.swing.JButton();
        imageLbl = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        scrollComentarios = new javax.swing.JScrollPane();
        comentariosPane = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 8, 27, 8));
        setPreferredSize(new java.awt.Dimension(574, 526));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(241, 250, 238));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nombreLbl.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        nombreLbl.setText("Nombre Usuario");

        descripcionLbl.setText("Hola Soy Una Publicacion");

        fechaLbl.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        fechaLbl.setText("19/11/2022");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Comentarios");

        btnRegistrarComentario.setText("Enviar");
        btnRegistrarComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarComentarioActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(37, 161, 142));
        deleteBtn.setBorder(null);
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        scrollComentarios.setBorder(null);
        scrollComentarios.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        comentariosPane.setBackground(new java.awt.Color(241, 250, 238));
        comentariosPane.setLayout(new javax.swing.BoxLayout(comentariosPane, javax.swing.BoxLayout.Y_AXIS));
        scrollComentarios.setViewportView(comentariosPane);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(descripcionLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(fechaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(nombreLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteBtn))))
                    .addComponent(imageLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRegistrarComentario))
                    .addComponent(scrollComentarios))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nombreLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(descripcionLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(imageLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtComentario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarComentario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int verificador = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar esta publicacion?");
        if (verificador == 0) {
            comunicadorVista.eliminarPublicacion(publicacion);
            File fotoEliminada = new File(publicacion.getImagen());
            fotoEliminada.delete();
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void btnRegistrarComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarComentarioActionPerformed
        Comentario comentario = new Comentario(usuario,publicacion,Calendar.getInstance(),this.txtComentario.getText());
        comunicadorVista.RegistrarComentario(comentario);
    }//GEN-LAST:event_btnRegistrarComentarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarComentario;
    private javax.swing.JPanel comentariosPane;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel descripcionLbl;
    private javax.swing.JLabel fechaLbl;
    private javax.swing.JLabel imageLbl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nombreLbl;
    private javax.swing.JScrollPane scrollComentarios;
    private javax.swing.JTextField txtComentario;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onRegistrarComentario(PeticionComentario respuesta) {
        System.out.println("Hola PUM");
        
        if (publicacion.getId() == respuesta.getComentario().getPublicacion().getId()) {
            System.out.println("Soy Homelo Chino");
            llenarComentario(respuesta.getComentario());
        }
    }

    @Override
    public void onConsultarComentarios(PeticionComentarios peticionComentarios) {
        if(comentarioEliminado == publicacion.getId()){
            this.llenarComentarios(peticionComentarios.getComentarios());
            return;
        }
        if(peticionComentarios.getComentarios() == null) return;
        if(peticionComentarios.getComentarios().isEmpty()){
            return;
        }
 
        if(peticionComentarios.getComentarios().get(0).getPublicacion().getId() == publicacion.getId()){
            this.llenarComentarios(peticionComentarios.getComentarios());
        }
        
    }

    @Override
    public void onEliminarComentario(PeticionComentario respuesta) {
        this.comentarioEliminado= respuesta.getComentario().getPublicacion().getId();
        System.out.println("Se eliminar");
        if(respuesta.getComentario().getPublicacion().getId() == publicacion.getId()){
            System.out.println("AAAAAAAAAA");
            this.comunicadorVista.consultarComentariosPorId(publicacion.getId());
        }
    }

    public void eliminarComentario(Comentario comentario){
        this.comentariosPane.remove(new ComentarioPanel(comentario, usuario, comunicadorVista));
        this.comentariosPane.repaint();
        this.comentariosPane.revalidate();
    }
    
}
