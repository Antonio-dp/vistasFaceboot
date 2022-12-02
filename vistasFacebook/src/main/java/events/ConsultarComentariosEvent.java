/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IConsultarComentariosObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionComentarios;

/**
 *
 * @author tonyd
 */
public class ConsultarComentariosEvent implements EventNotifier{
    private List<IConsultarComentariosObserver> listeners;
    private IJsonToObject conversor;
    private static ConsultarComentariosEvent comentariosEvent;
    
    private ConsultarComentariosEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    
    public static ConsultarComentariosEvent getInstance(){
        if(comentariosEvent == null){
            comentariosEvent = new ConsultarComentariosEvent();
        }
        return comentariosEvent;
    }
    
    public void notificarUsuarios(PeticionComentarios peticion){
        for(IConsultarComentariosObserver listener: listeners){
            listener.onConsultarComentarios(peticion);
        }
    }
    
    public void suscribirse(IConsultarComentariosObserver listener){
        listeners.add(listener);
    }
    
    public void desuscribirse(IConsultarComentariosObserver listener){
        listeners.remove(listener);
    }

    @Override
    public void notificar(String peticion) {
        PeticionComentarios peticionComentarios = conversor.convertirPeticionComentarios(peticion);
        comentariosEvent.notificarUsuarios(peticionComentarios);
    }   
}
