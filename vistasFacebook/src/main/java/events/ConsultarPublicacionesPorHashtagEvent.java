/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IConsultarPublicacionesPorHashtagObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionPublicaciones;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de ConsultarPublicacionesPorHashtag
 * @author jegav
 */
public class ConsultarPublicacionesPorHashtagEvent implements EventNotifier{
    private List<IConsultarPublicacionesPorHashtagObserver> listeners;
    private IJsonToObject conversor;
    private static ConsultarPublicacionesPorHashtagEvent publicacionesEvent;
    
    private ConsultarPublicacionesPorHashtagEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    
    public static ConsultarPublicacionesPorHashtagEvent getInstance(){
        if(publicacionesEvent == null){
            publicacionesEvent = new ConsultarPublicacionesPorHashtagEvent();
        }
        return publicacionesEvent;
    }
    
    public void notificarUsuarios(PeticionPublicaciones peticion){
        for(IConsultarPublicacionesPorHashtagObserver listener: listeners){
            listener.onConsultarPublicacionesPorHashtag(peticion);
        }
    }
    
    public void suscribirse(IConsultarPublicacionesPorHashtagObserver listener){
        listeners.add(listener);
    }
    
    public void desuscribirse(IConsultarPublicacionesPorHashtagObserver listener){
        listeners.remove(listener);
    }

    @Override
    public void notificar(String peticion) {
        PeticionPublicaciones peticionPublicaciones = conversor.convertirPeticionPublicaciones(peticion);
        publicacionesEvent.notificarUsuarios(peticionPublicaciones);
    }
}
