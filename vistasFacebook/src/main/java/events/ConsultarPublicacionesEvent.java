/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IConsultarPublicacionesObserver;
import interfaces.IConsultarUsuarioObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionPublicaciones;
import peticiones.PeticionUsuario;

/**
 *
 * @author jegav
 */
public class ConsultarPublicacionesEvent implements EventNotifier {
    private List<IConsultarPublicacionesObserver> listeners;
    private IJsonToObject conversor;
    private static ConsultarPublicacionesEvent publicacionesEvent;
    
    private ConsultarPublicacionesEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    
    public static ConsultarPublicacionesEvent getInstance(){
        if(publicacionesEvent == null){
            publicacionesEvent = new ConsultarPublicacionesEvent();
        }
        return publicacionesEvent;
    }
    
    public void notificarUsuarios(PeticionPublicaciones peticion){
        for(IConsultarPublicacionesObserver listener: listeners){
            listener.onConsultarPublicaciones(peticion);
        }
    }
    
    public void suscribirse(IConsultarPublicacionesObserver listener){
        listeners.add(listener);
    }
    
    public void desuscribirse(IConsultarPublicacionesObserver listener){
        listeners.remove(listener);
    }

    @Override
    public void notificar(String peticion) {
        PeticionPublicaciones peticionPublicaciones = conversor.convertirPeticionPublicaciones(peticion);
        publicacionesEvent.notificarUsuarios(peticionPublicaciones);
    }
}
