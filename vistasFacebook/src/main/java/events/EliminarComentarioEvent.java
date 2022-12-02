/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IEliminarComentarioObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionComentario;

/**
 *
 * @author tonyd
 */
public class EliminarComentarioEvent implements EventNotifier {
    private List<IEliminarComentarioObserver> listeners;
    private IJsonToObject conversor;
    private static EliminarComentarioEvent eliminarComentarioEvent;
    
    public EliminarComentarioEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }

    public static EliminarComentarioEvent getInstance(){
        if(eliminarComentarioEvent == null){
            eliminarComentarioEvent = new EliminarComentarioEvent();
        }
        return eliminarComentarioEvent;
    }
    
    public void notificarUsuarios(PeticionComentario peticionComentario) {
        for(IEliminarComentarioObserver listener: listeners){
            listener.onEliminarComentario(peticionComentario);
        }
    }

    public void suscribirse(IEliminarComentarioObserver listener) {
        listeners.add(listener);
    }

    public void desuscribir(IEliminarComentarioObserver listener) {
        listeners.remove(listener);
    }

    @Override
    public void notificar(String peticion) {
        PeticionComentario peticionComentario = conversor.convertirPeticionComentario(peticion);
        eliminarComentarioEvent.notificarUsuarios(peticionComentario);
    }
}
