/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package comVista;

import entidades.Comentario;
import entidades.Hashtag;
import entidades.Notificacion;
import entidades.Publicacion;
import entidades.Usuario;
import java.util.List;

/**
 *
 * @author jegav
 */
public interface IComunicadorVista {
    public void iniciarSesion(Usuario usuario);
    public void iniciarSesionFacebook(Usuario usuario);
    public void registrarUsuario(Usuario usuario);
    public void EditarUsuario(Usuario usuario);
    public void RegistrarComentario(Comentario comentario);
    public void registrarPublicacion(Publicacion publicacion);
    public void consultarPublicaciones();
    public void consultarComentariosPorId(Integer idPublicacion);
    public void cosultarUsuarioPorId(Integer id);
    public void eliminarUsuario(Usuario usuario);
    public void eliminarPublicacion(Publicacion publicacion);
    public void eliminarComentario(Comentario comentario);
    public void registrarNotificacion(Notificacion notificacion);
    public void registrarHashtags(List<Hashtag> hashtags);
    public void consultarUsuarioPorNombre(String nombre);
    public void consultarEtiquetaPorTema(String tema);
    public void consultarPublicacionesPorEtiqueta(String tema);
    public void consultarNotificacionesPorRemitente(Usuario usuario);
}
