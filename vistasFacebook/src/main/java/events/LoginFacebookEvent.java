/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.ILoginFacebookObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionUsuario;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de Login con Facebook
 * @author Usuario
 */
public class LoginFacebookEvent implements EventNotifier{
    private List<ILoginFacebookObserver> listeners;
    private IJsonToObject conversor;
    private static LoginFacebookEvent loginFacebookEvent;
    
    public LoginFacebookEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    
    public static LoginFacebookEvent getInstance(){
        if(loginFacebookEvent == null){
            loginFacebookEvent = new LoginFacebookEvent();
        }
        return loginFacebookEvent;
    }

    public void notificarUsuarios(PeticionUsuario peticion){
        List<ILoginFacebookObserver> copiaListeners = new ArrayList(listeners);
        for(ILoginFacebookObserver listener: copiaListeners){
            listener.onLoginFacebook(peticion);
        }
    }
    
    public void suscribirse(ILoginFacebookObserver listener){
        listeners.add(listener);
    }
    
    public void desuscribir(ILoginFacebookObserver listener){
        listeners.remove(listener);
    }

    @Override
    public void notificar(String peticion) {
        PeticionUsuario peticionUsuario = conversor.convertirPeticionUsuario(peticion);
        loginFacebookEvent.notificarUsuarios(peticionUsuario);
    }
}
