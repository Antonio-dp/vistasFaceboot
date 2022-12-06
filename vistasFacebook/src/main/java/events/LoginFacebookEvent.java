/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import interfaces.EventNotifier;
import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.ILoginFacebookObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionUsuario;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de Login con Facebook
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class LoginFacebookEvent implements EventNotifier{
    /**
     * Lista de observadores
     */
    private List<ILoginFacebookObserver> listeners;
    /**
     * Conversor de Json a Objeto concreto
     */
    private IJsonToObject conversor;
    /**
     * Objeto estatico de la clase
     */
    private static LoginFacebookEvent loginFacebookEvent;
    /**
     * Constructor que inicializa el valor de los atributos
     */ 
    public LoginFacebookEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    /**
     * Constructor estatico que crea una instancia del objeto
     * @return instancia de la clase
     */    
    public static LoginFacebookEvent getInstance(){
        if(loginFacebookEvent == null){
            loginFacebookEvent = new LoginFacebookEvent();
        }
        return loginFacebookEvent;
    }
    /**
     * Permite enviar la peticion a todos los usuarios suscritos
     * en la lista de observadores de login facebook
     * @param peticion peticion a enviar
     */ 
    public void notificarUsuarios(PeticionUsuario peticion){
        List<ILoginFacebookObserver> copiaListeners = new ArrayList(listeners);
        for(ILoginFacebookObserver listener: copiaListeners){
            listener.onLoginFacebook(peticion);
        }
    }
    /**
     * Permite suscribirte a la lista de observadores de login facebook
     * @param listener instancia a inscribir
     */      
    public void suscribirse(ILoginFacebookObserver listener){
        listeners.add(listener);
    }
    /**
     * Permite desuscribirte de la lista de observadores de login facebook
     * @param listener instancia a desuscribir
     */      
    public void desuscribir(ILoginFacebookObserver listener){
        listeners.remove(listener);
    }
    /**
     * Recibe una peticion en String y la convierte a la instancia de peticionUsuario
     * y permite enviar la respuesta de la peticion a los observadores de la lista de
     * login facebook suscritos
     * @param peticion peticion a convertir y notificar
     */
    @Override
    public void notificar(String peticion) {
        PeticionUsuario peticionUsuario = conversor.convertirPeticionUsuario(peticion);
        loginFacebookEvent.notificarUsuarios(peticionUsuario);
    }
}
