/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comVista;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import entidades.Comentario;
import entidades.Hashtag;
import entidades.Notificacion;
import entidades.Publicacion;
import peticiones.Peticion;
import entidades.Usuario;
import eventos.Eventos;
import java.util.List;
import peticiones.PeticionComentario;
import peticiones.PeticionHashtags;
import peticiones.PeticionId;
import peticiones.PeticionNotificacion;
import peticiones.PeticionPublicacion;
import peticiones.PeticionString;
import peticiones.PeticionUsuario;

/**
 * Fachada para Comunicar la vista con el server, Manejo de peticiones de vista
 *
 * @author jegav
 */
public class ComunicadorVista implements IComunicadorVista {

    private IJsonToObject conversor;

    public ComunicadorVista() {
        this.conversor = new JsonToObject();
    }

    @Override
    public void iniciarSesion(Usuario usuario) {
        PeticionUsuario peticionIniciarSesion = new PeticionUsuario(Eventos.Login, usuario);
        String peticion = conversor.convertirObjetoString(peticionIniciarSesion);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    @Override
    public void iniciarSesionFacebook(Usuario usuario) {
        PeticionUsuario peticionIniciarSesionFB = new PeticionUsuario(Eventos.iniciarSesionFacebook, usuario);
        String peticion = conversor.convertirObjetoString(peticionIniciarSesionFB);
        EventListener.getInstance().enviarMensaje(peticion);
    }
    
    @Override
    public void registrarUsuario(Usuario usuario) {
        PeticionUsuario peticionRegistroUsuario = new PeticionUsuario(Eventos.registrarUsuario, usuario);
        String peticion = conversor.convertirObjetoString(peticionRegistroUsuario);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    @Override
    public void registrarPublicacion(Publicacion publicacion) {
        Peticion peticionRegistroPublicacion = new PeticionPublicacion(Eventos.registrarPublicacion, publicacion);
        String peticion = conversor.convertirObjetoString(peticionRegistroPublicacion);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    @Override
    public void consultarPublicaciones() {
        Peticion peticionConsultarPublicacion = new Peticion(Eventos.consultarPublicaciones);
        String peticion = conversor.convertirObjetoString(peticionConsultarPublicacion);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    @Override
    public void cosultarUsuarioPorId(Integer id) {
        PeticionId peticionId = new PeticionId(Eventos.consultarUsuarioPorId, id);
        String peticion = conversor.convertirObjetoString(peticionId);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        PeticionUsuario peticionEliminarUsuario = new PeticionUsuario(Eventos.eliminarUsuario, usuario);
        String peticion = conversor.convertirObjetoString(peticionEliminarUsuario);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    @Override
    public void eliminarPublicacion(Publicacion publicacion) {
        PeticionPublicacion peticionEliminarPublicacion = new PeticionPublicacion(Eventos.eliminarPublicacion, publicacion);
        String peticion = conversor.convertirObjetoString(peticionEliminarPublicacion);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    @Override
    public void eliminarComentario(Comentario comentario) {
        PeticionComentario peticionComentario = new PeticionComentario(Eventos.eliminarComentario, comentario);
        String peticion = conversor.convertirObjetoString(peticionComentario);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    @Override
    public void EditarUsuario(Usuario usuario) {
        PeticionUsuario peticionEditarUsuario = new PeticionUsuario(Eventos.editarPerfil, usuario);
        String peticion = conversor.convertirObjetoString(peticionEditarUsuario);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    @Override
    public void RegistrarComentario(Comentario comentario) {
        PeticionComentario peticionRegistrarComentario = new PeticionComentario(Eventos.registrarComentario, comentario);
        String peticion = conversor.convertirObjetoString(peticionRegistrarComentario);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    @Override
    public void consultarComentariosPorId(Integer idPublicacion) {
        PeticionId peticionConsultarComentario = new PeticionId(Eventos.consultarComentarios, idPublicacion);
        String peticion = conversor.convertirObjetoString(peticionConsultarComentario);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    @Override
    public void registrarNotificacion(Notificacion notificacion) {
        PeticionNotificacion peticionRegistrarNotificacion = new PeticionNotificacion(Eventos.registrarNotificacion, notificacion);
        String peticion = conversor.convertirObjetoString(peticionRegistrarNotificacion);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    @Override
    public void registrarHashtags(List<Hashtag> hashtags) {
        PeticionHashtags peticionRegistrarHashtags = new PeticionHashtags(Eventos.registrarHashtags, hashtags);
        String peticion = conversor.convertirObjetoString(peticionRegistrarHashtags);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    @Override
    public void consultarUsuarioPorNombre(String nombre) {
        PeticionString peticionString = new PeticionString(Eventos.consultarUsuarioPorNombre, nombre);
        String peticion = conversor.convertirObjetoString(peticionString);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    @Override
    public void consultarEtiquetaPorTema(String tema) {
        PeticionString peticionString = new PeticionString(Eventos.consultarHashtagPorTema, tema);
        String peticion = conversor.convertirObjetoString(peticionString);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    @Override
    public void consultarPublicacionesPorEtiqueta(String tema) {
        PeticionString peticionString = new PeticionString(Eventos.consultarPublicacionesPorHashtag, tema);
        String peticion = conversor.convertirObjetoString(peticionString);
        EventListener.getInstance().enviarMensaje(peticion);
    }

    @Override
    public void consultarNotificacionesPorRemitente(Usuario usuario) {
        PeticionUsuario peticion = new PeticionUsuario(Eventos.consultarNotificacionesPorRemitente, usuario);
        String peticionEnviar = conversor.convertirObjetoString(peticion);
        EventListener.getInstance().enviarMensaje(peticionEnviar);
    }

}
