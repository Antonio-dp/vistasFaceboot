/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import interfaces.EventNotifier;
import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IConsultarNotificacionesPorRemitenteObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionNotificaciones;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de ConsultarNotificacionesPorRemitente
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class ConsultarNotificacionesPorRemitenteEvent implements EventNotifier {
    /**
     * Lista de observadores
     */
    private List<IConsultarNotificacionesPorRemitenteObserver> listeners;
    /**
     * Conversor de Json a Objeto concreto
     */
    private IJsonToObject conversor;
    /**
     * Objeto estatico de la clase
     */
    private static ConsultarNotificacionesPorRemitenteEvent notificacionesEvent;
    /**
     * Constructor que inicializa el valor de los atributos
     */
    private ConsultarNotificacionesPorRemitenteEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    /**
     * Constructor estatico que crea una instancia del objeto
     * @return instancia de la clase
     */
    public static ConsultarNotificacionesPorRemitenteEvent getInstance(){
        if(notificacionesEvent == null){
            notificacionesEvent = new ConsultarNotificacionesPorRemitenteEvent();
        }
        return notificacionesEvent;
    }
    /**
     * Permite enviar la peticion a todos los usuarios suscritos
     * en la lista de observadores de la consulta de notificaciones por 
     * remitente
     * @param peticion peticion a enviar
     */
    public void notificarUsuarios(PeticionNotificaciones peticion){
        for(IConsultarNotificacionesPorRemitenteObserver listener: listeners){
            listener.onConsultarNotificacionesPorRemitente(peticion);
        }
    }
    /**
     * Permite suscribirte a la lista de observadores de consulta de 
     * notificaciones por remitente
     * @param listener instancia a inscribir
     */
    public void suscribirse(IConsultarNotificacionesPorRemitenteObserver listener){
        listeners.add(listener);
    }
    /**
     * Permite desuscribirte de la lista de observadores de consulta de
     * notificaciones por remitente
     * @param listener instancia a desuscribir
     */  
    public void desuscribirse(IConsultarNotificacionesPorRemitenteObserver listener){
        listeners.remove(listener);
    }
    /**
     * Recibe una peticion en String y la convierte a la instancia de peticionNotificaciones
     * y permite enviar la respuesta de la peticion a los observadores de la lista de
     * consulta de notificaciones por remitente suscritos
     * @param peticion peticion a convertir y notificar
     */
    @Override
    public void notificar(String peticion) {
        PeticionNotificaciones peticionNotificaciones = conversor.convertirPeticionNotificaciones(peticion);
        notificacionesEvent.notificarUsuarios(peticionNotificaciones);
    }
}
