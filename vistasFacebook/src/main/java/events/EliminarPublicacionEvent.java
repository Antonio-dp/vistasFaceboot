/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import interfaces.EventNotifier;
import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IEliminarPublicacionObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionPublicaciones;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de EliminarPublicacion
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class EliminarPublicacionEvent implements EventNotifier{
    /**
     * Lista de observadores
     */
    private List<IEliminarPublicacionObserver> listeners;
    /**
     * Objeto estatico de la clase
     */
    private static EliminarPublicacionEvent publicacionEvent;
    /**
     * Conversor de Json a Objeto concreto
     */
    private IJsonToObject conversor;
    /**
     * Constructor que inicializa el valor de los atributos
     */    
    private EliminarPublicacionEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    /**
     * Constructor estatico que crea una instancia del objeto
     * @return instancia de la clase
     */     
    public static EliminarPublicacionEvent getInstance(){
        if(publicacionEvent == null){
            publicacionEvent = new EliminarPublicacionEvent();
        }
        return publicacionEvent;
    }
    /**
     * Permite enviar la peticion a todos los usuarios suscritos
     * en la lista de observadores de eliminar publicacion
     * @param peticion peticion a enviar
     */     
    public void notificarUsuarios(PeticionPublicaciones peticion){
        for(IEliminarPublicacionObserver listener: listeners){
            listener.onEliminarPublicacion(peticion);
        }  
    }
    /**
     * Permite suscribirte a la lista de observadores de eliminar publicacion
     * @param listener instancia a inscribir
     */
    public void suscribirse(IEliminarPublicacionObserver listener){
        listeners.add(listener);
    }
    /**
     * Permite desuscribirte de la lista de observadores de eliminar publicacion
     * @param listener instancia a desuscribir
     */  
    public void desuscribirse(IEliminarPublicacionObserver listener){
        listeners.remove(listener);
    }
    /**
     * Recibe una peticion en String y la convierte a la instancia de peticionPublicaciones
     * y permite enviar la respuesta de la peticion a los observadores de la lista de
     * eliminar publicacion suscritos
     * @param peticion peticion a convertir y notificar
     */
    @Override
    public void notificar(String mensaje) {
        PeticionPublicaciones peticion = conversor.convertirPeticionPublicaciones(mensaje);
        publicacionEvent.notificarUsuarios(peticion);
    }
    
}
