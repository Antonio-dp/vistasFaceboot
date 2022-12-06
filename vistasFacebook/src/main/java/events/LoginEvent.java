/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import interfaces.EventNotifier;
import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.ILoginObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionUsuario;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de Login
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class LoginEvent implements EventNotifier {
    /**
     * Lista de observadores
     */
    private List<ILoginObserver> listeners;
    /**
     * Conversor de Json a Objeto concreto
     */
    private IJsonToObject conversor;
    /**
     * Objeto estatico de la clase
     */
    private static LoginEvent loginEvent;
    /**
     * Constructor que inicializa el valor de los atributos
     */ 
    public LoginEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    /**
     * Constructor estatico que crea una instancia del objeto
     * @return instancia de la clase
     */       
    public static LoginEvent getInstance(){
        if(loginEvent == null){
            loginEvent = new LoginEvent();
        }
        return loginEvent;
    }
    /**
     * Permite enviar la peticion a todos los usuarios suscritos
     * en la lista de observadores de login
     * @param peticion peticion a enviar
     */   
    public void notificarUsuarios(PeticionUsuario peticion){

        List<ILoginObserver> copiaListeners = new ArrayList(listeners);
        for(ILoginObserver listener: copiaListeners){
            listener.onLogin(peticion);
        }
    }
    /**
     * Permite suscribirte a la lista de observadores de login
     * @param listener instancia a inscribir
     */  
    public void suscribirse(ILoginObserver listener){
        listeners.add(listener);
    }
    /**
     * Permite desuscribirte de la lista de observadores de login
     * @param listener instancia a desuscribir
     */      
    public void desuscribir(ILoginObserver listener){
        listeners.remove(listener);
    }
    /**
     * Recibe una peticion en String y la convierte a la instancia de peticionUsuario
     * y permite enviar la respuesta de la peticion a los observadores de la lista de
     * login suscritos
     * @param peticion peticion a convertir y notificar
     */
    @Override
    public void notificar(String peticion) {
        PeticionUsuario peticionUsuario = conversor.convertirPeticionUsuario(peticion);
        loginEvent.notificarUsuarios(peticionUsuario);
    }

}
