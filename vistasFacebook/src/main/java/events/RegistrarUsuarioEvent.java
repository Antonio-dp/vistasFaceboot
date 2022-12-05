/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IRegistrarUsuarioObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionUsuario;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de RegistarUsuario
 * @author jegav
 */
public class RegistrarUsuarioEvent implements EventNotifier {
    private List<IRegistrarUsuarioObserver> listeners;
    private IJsonToObject conversor;
    private static RegistrarUsuarioEvent usuarioEvent;
    
    private RegistrarUsuarioEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    
    public static RegistrarUsuarioEvent getInstance(){
        if(usuarioEvent == null){
            usuarioEvent = new RegistrarUsuarioEvent();
        }
        return usuarioEvent;
    }
    
    public void notificarUsuarios(PeticionUsuario peticion){
        for(IRegistrarUsuarioObserver listener: listeners){
            listener.onRegistrarUsuario(peticion);
        }
    }
    
    public void suscribirse(IRegistrarUsuarioObserver listener){
        listeners.add(listener);
    }
    
    public void desuscribirse(IRegistrarUsuarioObserver listener){
        listeners.remove(listener);
    }

    @Override
    public void notificar(String peticion) {
        PeticionUsuario peticionUsuario = conversor.convertirPeticionUsuario(peticion);
        usuarioEvent.notificarUsuarios(peticionUsuario);
    }
}
