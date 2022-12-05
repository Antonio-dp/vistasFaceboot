/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package comVista;

import entidades.Comentario;
import entidades.Notificacion;
import entidades.Publicacion;
import entidades.Usuario;

/**
 * Permite comunicarse con un mecanismo de comunicación para obtener información
 * @author jegav
 */
public interface IComunicadorVista {
    public void iniciarSesion(Usuario usuario);
    public void iniciarSesionFacebook(Usuario usuario);
    public void registrarUsuario(Usuario usuario);
    public void editarUsuario(Usuario usuario);
    public void registrarComentario(Comentario comentario);
    public void registrarPublicacion(Publicacion publicacion);
    public void consultarPublicaciones();
    public void consultarComentariosPorId(Integer idPublicacion);
    public void eliminarPublicacion(Publicacion publicacion);
    public void eliminarComentario(Comentario comentario);
    public void registrarNotificacion(Notificacion notificacion);
    public void consultarUsuarioPorNombre(String nombre);
    public void consultarEtiquetaPorTema(String tema);
    public void consultarPublicacionesPorEtiqueta(String tema);
    public void consultarNotificacionesPorRemitente(Usuario usuario);
}
