/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IConsultarNotificacionesPorRemitenteObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionNotificaciones;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de ConsultarNotificacionesPorRemitente
 * @author jegav
 */
public class ConsultarNotificacionesPorRemitenteEvent implements EventNotifier {
    private List<IConsultarNotificacionesPorRemitenteObserver> listeners;
    private IJsonToObject conversor;
    private static ConsultarNotificacionesPorRemitenteEvent notificacionesEvent;
    
    private ConsultarNotificacionesPorRemitenteEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    
    public static ConsultarNotificacionesPorRemitenteEvent getInstance(){
        if(notificacionesEvent == null){
            notificacionesEvent = new ConsultarNotificacionesPorRemitenteEvent();
        }
        return notificacionesEvent;
    }
    
    public void notificarUsuarios(PeticionNotificaciones peticion){
        for(IConsultarNotificacionesPorRemitenteObserver listener: listeners){
            listener.onConsultarNotificacionesPorRemitente(peticion);
        }
    }
    
    public void suscribirse(IConsultarNotificacionesPorRemitenteObserver listener){
        listeners.add(listener);
    }
    
    public void desuscribirse(IConsultarNotificacionesPorRemitenteObserver listener){
        listeners.remove(listener);
    }

    @Override
    public void notificar(String peticion) {
        PeticionNotificaciones peticionNotificaciones = conversor.convertirPeticionNotificaciones(peticion);
        notificacionesEvent.notificarUsuarios(peticionNotificaciones);
    }
}
