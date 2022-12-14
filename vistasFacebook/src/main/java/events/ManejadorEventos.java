/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import interfaces.EventNotifier;
import eventos.Eventos;
import java.util.HashMap;
import java.util.Map;

/**
 * Se utiliza para delegar que se debe hacer cuando llega un evento al EventListener
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class ManejadorEventos {

    /**
     * Instancia unica del manejador de eventos
     */
    private static ManejadorEventos manejadorEventos;
    /**
     * Map con todos los eventos que pueden llegar al EventListener
     */
    private static Map<String, EventNotifier> eventsNotifier;

    /**
     * Constructor que introduce todos los datos necesarios para el manejo de eventos
     */
    private ManejadorEventos() {
        eventsNotifier = new HashMap();
        eventsNotifier.put(Eventos.registrarUsuario, RegistrarUsuarioEvent.getInstance());
        eventsNotifier.put(Eventos.registrarPublicacion, RegistrarPublicacionEvent.getInstance());
        eventsNotifier.put(Eventos.registrarComentario, RegistrarComentarioEvent.getInstance());
        eventsNotifier.put(Eventos.Login, LoginEvent.getInstance());
        eventsNotifier.put(Eventos.consultarPublicaciones, ConsultarPublicacionesEvent.getInstance());
        eventsNotifier.put(Eventos.consultarComentarios, ConsultarComentariosEvent.getInstance());
        eventsNotifier.put(Eventos.editarPerfil, EditarUsuarioEvent.getInstance());
        eventsNotifier.put(Eventos.eliminarPublicacion, EliminarPublicacionEvent.getInstance());
        eventsNotifier.put(Eventos.iniciarSesionFacebook, LoginFacebookEvent.getInstance());
        eventsNotifier.put(Eventos.registrarNotificacion, RegistrarNotificacionEvent.getInstance());
        eventsNotifier.put(Eventos.consultarUsuarioPorNombre, ConsultarUsuarioPorNombreEvent.getInstance());
        eventsNotifier.put(Eventos.consultarPublicacionesPorHashtag, ConsultarPublicacionesPorHashtagEvent.getInstance());
        eventsNotifier.put(Eventos.consultarNotificacionesPorRemitente, ConsultarNotificacionesPorRemitenteEvent.getInstance());
        eventsNotifier.put(Eventos.eliminarComentario, EliminarComentarioEvent.getInstance());
    }

    /**
     * Crea la instancia de Manejador de Eventos si no existe y la retorna
     * @return Retorna una instancia del Manejador de eventos
     */
    public static ManejadorEventos getInstance() {
        if (manejadorEventos == null) {
            manejadorEventos = new ManejadorEventos();
        }
        return manejadorEventos;
    }

    /**
     * Retorna un EventNotifier dependiendo de la key del map 
     * @param evento Key (evento que llega al EventListener)
     * @return Retorna un eventNotifier dependiendo del par??metro evento
     */
    public EventNotifier get(String evento) {
        return eventsNotifier.get(evento);
    }

}
