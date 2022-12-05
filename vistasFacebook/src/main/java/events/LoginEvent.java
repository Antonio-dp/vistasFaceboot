/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import eventos.Eventos;
import interfaces.ILoginObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionUsuario;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de Login
 * @author jegav
 */
public class LoginEvent implements EventNotifier {
    private List<ILoginObserver> listeners;
    private IJsonToObject conversor;
    private static LoginEvent loginEvent;
    
    public LoginEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    
    public static LoginEvent getInstance(){
        if(loginEvent == null){
            loginEvent = new LoginEvent();
        }
        return loginEvent;
    }

    public void notificarUsuarios(PeticionUsuario peticion){

        List<ILoginObserver> copiaListeners = new ArrayList(listeners);
        for(ILoginObserver listener: copiaListeners){
            listener.onLogin(peticion);
        }
    }
    
    public void suscribirse(ILoginObserver listener){
        listeners.add(listener);
    }
    
    public void desuscribir(ILoginObserver listener){
        listeners.remove(listener);
    }

    @Override
    public void notificar(String peticion) {
        PeticionUsuario peticionUsuario = conversor.convertirPeticionUsuario(peticion);
        loginEvent.notificarUsuarios(peticionUsuario);
    }

}
