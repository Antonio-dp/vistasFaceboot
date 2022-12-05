/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IConsultarUsuarioPorNombreObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionUsuario;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de ConsultarUsuarioPorNombre
 * @author jegav
 */
public class ConsultarUsuarioPorNombreEvent implements EventNotifier {
    private List<IConsultarUsuarioPorNombreObserver> listeners;
    private IJsonToObject conversor;
    private static ConsultarUsuarioPorNombreEvent consultarEvent;
    public ConsultarUsuarioPorNombreEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    
    public static ConsultarUsuarioPorNombreEvent getInstance(){
        if(consultarEvent == null){
            consultarEvent = new ConsultarUsuarioPorNombreEvent();
        }
        return consultarEvent;
    }

    public void notificarUsuarios(PeticionUsuario peticion){
        List<IConsultarUsuarioPorNombreObserver> copiaListeners = new ArrayList(listeners);
        for(IConsultarUsuarioPorNombreObserver listener: copiaListeners){
            
            listener.onConsultarUsuarioPorNombre(peticion);
        }
    }
    
    public void suscribirse(IConsultarUsuarioPorNombreObserver listener){
        System.out.println("Hola");
        listeners.add(listener);
    }
    
    public void desuscribir(IConsultarUsuarioPorNombreObserver listener){
        listeners.remove(listener);
    }

    @Override
    public void notificar(String peticion) {
        PeticionUsuario peticionUsuario = conversor.convertirPeticionUsuario(peticion);
        System.out.println("AAAAAAAAAA");
        consultarEvent.notificarUsuarios(peticionUsuario);
    }
}
