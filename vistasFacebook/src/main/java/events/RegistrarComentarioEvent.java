/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import entidades.Comentario;
import eventos.Eventos;
import java.util.ArrayList;
import java.util.List;
import peticiones.Peticion;
import interfaces.IRegistrarComentarioObserver;
import peticiones.PeticionComentario;
import peticiones.PeticionUsuario;

/**
 *
 * @author jegav
 */
public class RegistrarComentarioEvent implements EventNotifier{
    private List<IRegistrarComentarioObserver> listeners;
    private static RegistrarComentarioEvent comentarioEvent;
    private IJsonToObject conversor;
    
    private RegistrarComentarioEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    
    public static RegistrarComentarioEvent getInstance(){
        if(comentarioEvent == null){
            comentarioEvent = new RegistrarComentarioEvent();
        }
        return comentarioEvent;
    }
    
    public void notificarUsuarios(PeticionComentario peticion){
        for(IRegistrarComentarioObserver listener: listeners){
            listener.onRegistrarComentario(peticion);
        }
        
    }
    
    public void suscribirse(IRegistrarComentarioObserver listener){
        listeners.add(listener);
    }
    
    public void desuscribirse(IRegistrarComentarioObserver listener){
        listeners.remove(listener);
    }

    @Override
    public void notificar(String mensaje) {
        PeticionComentario peticion = conversor.convertirPeticionComentario(mensaje);
        comentarioEvent.notificarUsuarios(peticion);
    }

}
