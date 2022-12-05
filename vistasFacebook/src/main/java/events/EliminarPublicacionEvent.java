/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IEliminarPublicacionObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionPublicaciones;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de EliminarPublicacion
 * @author tonyd
 */
public class EliminarPublicacionEvent implements EventNotifier{
    private List<IEliminarPublicacionObserver> listeners;
    private static EliminarPublicacionEvent publicacionEvent;
    private IJsonToObject conversor;
    
    private EliminarPublicacionEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    
    public static EliminarPublicacionEvent getInstance(){
        if(publicacionEvent == null){
            publicacionEvent = new EliminarPublicacionEvent();
        }
        return publicacionEvent;
    }
    
    public void notificarUsuarios(PeticionPublicaciones peticion){
        for(IEliminarPublicacionObserver listener: listeners){
            listener.onEliminarPublicacion(peticion);
        }
        
    }
    
    public void suscribirse(IEliminarPublicacionObserver listener){
        listeners.add(listener);
    }
    
    public void desuscribirse(IEliminarPublicacionObserver listener){
        listeners.remove(listener);
    }

    @Override
    public void notificar(String mensaje) {
        PeticionPublicaciones peticion = conversor.convertirPeticionPublicaciones(mensaje);
        publicacionEvent.notificarUsuarios(peticion);
    }
    
}
