/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import interfaces.EventNotifier;
import conversors.IJsonToObject;
import conversors.JsonToObject;
import java.util.ArrayList;
import java.util.List;
import interfaces.IRegistrarPublicacionObserver;
import peticiones.PeticionPublicacion;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de RegistrarPublicación
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class RegistrarPublicacionEvent implements EventNotifier{
    /**
     * Lista de observadores
     */
    private List<IRegistrarPublicacionObserver> listeners;
    /**
     * Objeto estatico de la clase
     */
    private static RegistrarPublicacionEvent publicacionEvent;
    /**
     * Conversor de Json a Objeto concreto
     */
    private IJsonToObject conversor;
    /**
     * Constructor que inicializa el valor de los atributos
     */    
    private RegistrarPublicacionEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    /**
     * Constructor estatico que crea una instancia del objeto
     * @return instancia de la clase
     */    
    public static RegistrarPublicacionEvent getInstance(){
        if(publicacionEvent == null){
            publicacionEvent = new RegistrarPublicacionEvent();
        }
        return publicacionEvent;
    }
     /**
     * Permite enviar la peticion a todos los usuarios suscritos
     * en la lista de observadores de registrar publicacion
     * @param peticion peticion a enviar
     */    
    public void notificarUsuarios(PeticionPublicacion peticion){
        for(IRegistrarPublicacionObserver listener: listeners){
            listener.onRegistrarPublicacion(peticion);
        }   
    }
    /**
     * Permite suscribirte a la lista de observadores de registrar publicacion
     * @param listener instancia a inscribir
     */ 
    public void suscribirse(IRegistrarPublicacionObserver listener){
        listeners.add(listener);
    }
    /**
     * Permite desuscribirte de la lista de observadores de registrar publicacion
     * @param listener instancia a desuscribir
     */      
    public void desuscribirse(IRegistrarPublicacionObserver listener){
        listeners.remove(listener);
    }
    /**
     * Recibe una peticion en String y la convierte a la instancia de peticionPublicacion
     * y permite enviar la respuesta de la peticion a los observadores de la lista de
     * registrar publicacion suscritos
     * @param peticion peticion a convertir y notificar
     */
    @Override
    public void notificar(String mensaje) {
        PeticionPublicacion peticion = conversor.convertirPeticionPublicacion(mensaje);
        publicacionEvent.notificarUsuarios(peticion);
    }

}
