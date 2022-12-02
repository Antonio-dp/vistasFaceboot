/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IConsultarHashtagPorTemaObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionHashtag;

/**
 *
 * @author jegav
 */
public class ConsultarHashtagPorTemaEvent implements EventNotifier {
    private List<IConsultarHashtagPorTemaObserver> listeners;
    private IJsonToObject conversor;
    private static ConsultarHashtagPorTemaEvent consultarEvent;
    
    public ConsultarHashtagPorTemaEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    
    public static ConsultarHashtagPorTemaEvent getInstance(){
        if(consultarEvent == null){
            consultarEvent = new ConsultarHashtagPorTemaEvent();
        }
        return consultarEvent;
    }

    public void notificarUsuarios(PeticionHashtag peticion){
        List<IConsultarHashtagPorTemaObserver> copiaListeners = new ArrayList(listeners);
        for(IConsultarHashtagPorTemaObserver listener: copiaListeners){
            listener.onConsultarHashtagPorTema(peticion);
        }
    }
    
    public void suscribirse(IConsultarHashtagPorTemaObserver listener){
        listeners.add(listener);
    }
    
    public void desuscribir(IConsultarHashtagPorTemaObserver listener){
        listeners.remove(listener);
    }

    @Override
    public void notificar(String peticion) {
        PeticionHashtag peticionUsuario = conversor.convertirPeticionHashtag(peticion);
        consultarEvent.notificarUsuarios(peticionUsuario);
    }
}
