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
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface IComunicadorVista {
    /**
     * Manda una petición al para el inicio de sesión
     * @param usuario el usuario que se va a loguear
     */
    public void iniciarSesion(Usuario usuario);
    /**
     * Manda una petición al para el inicio de sesión con facebook
     * @param usuario el usuario que se va a loguear
     */
    public void iniciarSesionFacebook(Usuario usuario);
    /**
     * Manda una petición al servidor para el registro del usuario
     * @param usuario el usuario que se va a registrar
     */
    public void registrarUsuario(Usuario usuario);
    /**
     * Realiza una petición al servidor para editar un usuario
     * @param usuario usuario que se desea editar
     */
    public void editarUsuario(Usuario usuario);
   /**
     * Realiza una petición al servidor para registrar un comentario
     * @param comentario comentario que se desea registrar
     */
    public void registrarComentario(Comentario comentario);
    /**
     * Manda una petición al servidor para el registro de una publicacion
     * @param publicacion la publicación que se desea registrar
     */
    public void registrarPublicacion(Publicacion publicacion);
    /**
     * Realiza una petición al servidor para que mande todas las peticiones
     */
    public void consultarPublicaciones();
    /**
     * Realiza una petición al servidor para consultar todos los comentarios de una publicación
     * @param idPublicacion id de la publicación dela que quieren los comentarios
     */
    public void consultarComentariosPorId(Integer idPublicacion);
    /**
     * Realiza una petición al servidor para eliminar una publicación
     * @param publicacion publicación que se desea eliminar
     */
    public void eliminarPublicacion(Publicacion publicacion);
    /**
     * Realiza una petición al servidor para eliminar un comentario
     * @param comentario comentario para eliminar
     */
    public void eliminarComentario(Comentario comentario);
    /**
     * Realiza una petición al servidor para registrar una notificación
     * @param notificacion notificación que se desea registrar
     */
    public void registrarNotificacion(Notificacion notificacion);
    /**
     * Realiza una petición al servidor para consultar un usuario por su nombre
     * @param nombre nombre del usuario que se desea consultar
     */
    public void consultarUsuarioPorNombre(String nombre);
    /**
     * Realiza una petición al servidor para consultar una etiqueta por su tema
     * @param tema Tema de la etiqueta que se desea consultar
     */
    public void consultarEtiquetaPorTema(String tema);
    /**
     * Realiza una petición al servidor para consultar todas las publicaciones que contienen una etiqueta especifica
     * @param tema Tema de la etiqueta
     */
    public void consultarPublicacionesPorEtiqueta(String tema);
    /**
     * Realiza una petición al servidor para consultar todas las notificaciones por su remitente
     * @param usuario usuario remitente de la notificación
     */
    public void consultarNotificacionesPorRemitente(Usuario usuario);
}
