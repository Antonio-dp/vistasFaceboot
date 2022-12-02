/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IEliminarUsuarioObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionUsuario;

/**
 *
 * @author tonyd
 */
public class EliminarUsuarioEvent implements EventNotifier{
    private List<IEliminarUsuarioObserver> listeners;
    private IJsonToObject conversor;
    private static EliminarUsuarioEvent usuarioEvent;
    
    private EliminarUsuarioEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    
    public static EliminarUsuarioEvent getInstance(){
        if(usuarioEvent == null){
            usuarioEvent = new EliminarUsuarioEvent();
        }
        return usuarioEvent;
    }
    
    public void notificarUsuarios(PeticionUsuario peticion){
        for(IEliminarUsuarioObserver listener: listeners){
            listener.onEliminarUsuario(peticion);
        }
    }
    
    public void suscribirse(IEliminarUsuarioObserver listener){
        listeners.add(listener);
    }
    
    public void desuscribirse(IEliminarUsuarioObserver listener){
        listeners.remove(listener);
    }

    @Override
    public void notificar(String peticion) {
        PeticionUsuario peticionUsuario = conversor.convertirPeticionUsuario(peticion);
        usuarioEvent.notificarUsuarios(peticionUsuario);
    }
}
