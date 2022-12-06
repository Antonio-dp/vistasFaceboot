/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comVista;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import entidades.Comentario;
import entidades.Notificacion;
import entidades.Publicacion;
import peticiones.Peticion;
import entidades.Usuario;
import eventos.Eventos;
import peticiones.PeticionComentario;
import peticiones.PeticionId;
import peticiones.PeticionNotificacion;
import peticiones.PeticionPublicacion;
import peticiones.PeticionString;
import peticiones.PeticionUsuario;

/**
 * Fachada para Comunicar la vista con el server, Manejo de peticiones de vista
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class ComunicadorVista implements IComunicadorVista {

    /**
     * Conversor para serializar objetos para su envio al servidor
     */
    private IJsonToObject conversor;

    public ComunicadorVista() {
        this.conversor = new JsonToObject();
    }

    /**
     * Manda una petición al para el inicio de sesión
     * @param usuario el usuario que se va a loguear
     */
    @Override
    public void iniciarSesion(Usuario usuario) {
        PeticionUsuario peticionIniciarSesion = new PeticionUsuario(Eventos.Login, usuario);
        String peticion = conversor.convertirObjetoString(peticionIniciarSesion);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    /**
     * Manda una petición al para el inicio de sesión con facebook
     * @param usuario el usuario que se va a loguear
     */
    @Override
    public void iniciarSesionFacebook(Usuario usuario) {
        PeticionUsuario peticionIniciarSesionFB = new PeticionUsuario(Eventos.iniciarSesionFacebook, usuario);
        String peticion = conversor.convertirObjetoString(peticionIniciarSesionFB);
        EventListener.getInstance().enviarMensaje(peticion);
    }
    
    /**
     * Manda una petición al servidor para el registro del usuario
     * @param usuario el usuario que se va a registrar
     */
    @Override
    public void registrarUsuario(Usuario usuario) {
        PeticionUsuario peticionRegistroUsuario = new PeticionUsuario(Eventos.registrarUsuario, usuario);
        String peticion = conversor.convertirObjetoString(peticionRegistroUsuario);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    /**
     * Manda una petición al servidor para el registro de
     * @param publicacion la publicación que se desea registrar
     */
    @Override
    public void registrarPublicacion(Publicacion publicacion) {
        Peticion peticionRegistroPublicacion = new PeticionPublicacion(Eventos.registrarPublicacion, publicacion);
        String peticion = conversor.convertirObjetoString(peticionRegistroPublicacion);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    /**
     * Realiza una petición al servidor para que mande todas las peticiones
     */
    @Override
    public void consultarPublicaciones() {
        Peticion peticionConsultarPublicacion = new Peticion(Eventos.consultarPublicaciones);
        String peticion = conversor.convertirObjetoString(peticionConsultarPublicacion);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    /**
     * Realiza una petición al servidor para eliminar una publicación
     * @param publicacion publicación que se desea eliminar
     */
    @Override
    public void eliminarPublicacion(Publicacion publicacion) {
        PeticionPublicacion peticionEliminarPublicacion = new PeticionPublicacion(Eventos.eliminarPublicacion, publicacion);
        String peticion = conversor.convertirObjetoString(peticionEliminarPublicacion);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    /**
     * Realiza una petición al servidor para eliminar un comentario
     * @param comentario comentario para eliminar
     */
    @Override
    public void eliminarComentario(Comentario comentario) {
        PeticionComentario peticionComentario = new PeticionComentario(Eventos.eliminarComentario, comentario);
        String peticion = conversor.convertirObjetoString(peticionComentario);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    /**
     * Realiza una petición al servidor para editar un usuario
     * @param usuario usuario que se desea editar
     */
    @Override
    public void editarUsuario(Usuario usuario) {
        PeticionUsuario peticionEditarUsuario = new PeticionUsuario(Eventos.editarPerfil, usuario);
        String peticion = conversor.convertirObjetoString(peticionEditarUsuario);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    /**
     * Realiza una petición al servidor para registrar un comentario
     * @param comentario comentario que se desea registrar
     */
    @Override
    public void registrarComentario(Comentario comentario) {
        PeticionComentario peticionRegistrarComentario = new PeticionComentario(Eventos.registrarComentario, comentario);
        String peticion = conversor.convertirObjetoString(peticionRegistrarComentario);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    /**
     * Realiza una petición al servidor para consultar todos los comentarios de una publicación
     * @param idPublicacion id de la publicación dela que quieren los comentarios
     */
    @Override
    public void consultarComentariosPorId(Integer idPublicacion) {
        PeticionId peticionConsultarComentario = new PeticionId(Eventos.consultarComentarios, idPublicacion);
        String peticion = conversor.convertirObjetoString(peticionConsultarComentario);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    /**
     * Realiza una petición al servidor para registrar una notificación
     * @param notificacion notificación que se desea registrar
     */
    @Override
    public void registrarNotificacion(Notificacion notificacion) {
        PeticionNotificacion peticionRegistrarNotificacion = new PeticionNotificacion(Eventos.registrarNotificacion, notificacion);
        String peticion = conversor.convertirObjetoString(peticionRegistrarNotificacion);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    /**
     * Realiza una petición al servidor para consultar un usuario por su nombre
     * @param nombre nombre del usuario que se desea consultar
     */
    @Override
    public void consultarUsuarioPorNombre(String nombre) {
        PeticionString peticionString = new PeticionString(Eventos.consultarUsuarioPorNombre, nombre);
        String peticion = conversor.convertirObjetoString(peticionString);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    /**
     * Realiza una petición al servidor para consultar una etiqueta por su tema
     * @param tema Tema de la etiqueta que se desea consultar
     */
    @Override
    public void consultarEtiquetaPorTema(String tema) {
        PeticionString peticionString = new PeticionString(Eventos.consultarHashtagPorTema, tema);
        String peticion = conversor.convertirObjetoString(peticionString);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    /**
     * Realiza una petición al servidor para consultar todas las publicaciones que contienen una etiqueta especifica
     * @param tema Tema de la etiqueta
     */
    @Override
    public void consultarPublicacionesPorEtiqueta(String tema) {
        PeticionString peticionString = new PeticionString(Eventos.consultarPublicacionesPorHashtag, tema);
        String peticion = conversor.convertirObjetoString(peticionString);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    /**
     * Realiza una petición al servidor para consultar todas las notificaciones por su remitente
     * @param usuario usuario remitente de la notificación
     */
    @Override
    public void consultarNotificacionesPorRemitente(Usuario usuario) {
        PeticionUsuario peticion = new PeticionUsuario(Eventos.consultarNotificacionesPorRemitente, usuario);
        String peticionEnviar = conversor.convertirObjetoString(peticion);
        EventListener.getInstance().enviarMensaje(peticionEnviar);
    }

}
