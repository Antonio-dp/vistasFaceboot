/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IRegistrarNotificacionObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionNotificacion;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de RegistrarNotificacion
 * @author tonyd
 */
public class RegistrarNotificacionEvent implements EventNotifier{

    private List<IRegistrarNotificacionObserver> listeners;
    private IJsonToObject conversor;
    private static RegistrarNotificacionEvent notificacionEvent;
    
    private RegistrarNotificacionEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    
    public static RegistrarNotificacionEvent getInstance(){
        if(notificacionEvent == null){
            notificacionEvent = new RegistrarNotificacionEvent();
        }
        return notificacionEvent;
    }
    
    public void notificarUsuarios(PeticionNotificacion peticion){
        for(IRegistrarNotificacionObserver listener: listeners){
            listener.onRegistrarNotificacion(peticion);
        }
    }
    
    public void suscribirse(IRegistrarNotificacionObserver listener){
        listeners.add(listener);
    }
    
    public void desuscribirse(IRegistrarNotificacionObserver listener){
        listeners.remove(listener);
    }
    @Override
    public void notificar(String peticion) {
        PeticionNotificacion peticionNotificacion = conversor.convertirNotificacion(peticion);
        notificacionEvent.notificarUsuarios(peticionNotificacion);
    }
    
}
