/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IConsultarUsuarioObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionUsuario;

/**
 *
 * @author jegav
 */
public class ConsultarUsuarioEvent implements EventNotifier {
    private List<IConsultarUsuarioObserver> listeners;
    private IJsonToObject conversor;
    private static ConsultarUsuarioEvent usuarioEvent;
    
    private ConsultarUsuarioEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    
    public static ConsultarUsuarioEvent getInstance(){
        if(usuarioEvent == null){
            usuarioEvent = new ConsultarUsuarioEvent();
        }
        return usuarioEvent;
    }
    
    public void notificarUsuarios(PeticionUsuario peticion){
        for(IConsultarUsuarioObserver listener: listeners){
            listener.onConsultarUsuario(peticion);
        }
    }
    
    public void suscribirse(IConsultarUsuarioObserver listener){
        listeners.add(listener);
    }
    
    public void desuscribirse(IConsultarUsuarioObserver listener){
        listeners.remove(listener);
    }

    @Override
    public void notificar(String peticion) {
        PeticionUsuario peticionUsuario = conversor.convertirPeticionUsuario(peticion);
        usuarioEvent.notificarUsuarios(peticionUsuario);
    }
}
