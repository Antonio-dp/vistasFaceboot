/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import interfaces.EventNotifier;
import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IRegistrarNotificacionObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionNotificacion;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de RegistrarNotificacion
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class RegistrarNotificacionEvent implements EventNotifier{
    /**
     * Lista de observadores
     */
    private List<IRegistrarNotificacionObserver> listeners;
    /**
     * Conversor de Json a Objeto concreto
     */
    private IJsonToObject conversor;
    /**
     * Objeto estatico de la clase
     */
    private static RegistrarNotificacionEvent notificacionEvent;
    /**
     * Constructor que inicializa el valor de los atributos
     */     
    private RegistrarNotificacionEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    /**
     * Constructor estatico que crea una instancia del objeto
     * @return instancia de la clase
     */     
    public static RegistrarNotificacionEvent getInstance(){
        if(notificacionEvent == null){
            notificacionEvent = new RegistrarNotificacionEvent();
        }
        return notificacionEvent;
    }
    /**
     * Permite enviar la peticion a todos los usuarios suscritos
     * en la lista de observadores de registrar notificacion
     * @param peticion peticion a enviar
     */    
    public void notificarUsuarios(PeticionNotificacion peticion){
        for(IRegistrarNotificacionObserver listener: listeners){
            listener.onRegistrarNotificacion(peticion);
        }
    }
    /**
     * Permite suscribirte a la lista de observadores de registrar notificacion
     * @param listener instancia a inscribir
     */     
    public void suscribirse(IRegistrarNotificacionObserver listener){
        listeners.add(listener);
    }
    /**
     * Permite desuscribirte de la lista de observadores de registrar notificacion
     * @param listener instancia a desuscribir
     */     
    public void desuscribirse(IRegistrarNotificacionObserver listener){
        listeners.remove(listener);
    }
    /**
     * Recibe una peticion en String y la convierte a la instancia de peticionNotificacion
     * y permite enviar la respuesta de la peticion a los observadores de la lista de
     * registrar notificacion suscritos
     * @param peticion peticion a convertir y notificar
     */
    @Override
    public void notificar(String peticion) {
        PeticionNotificacion peticionNotificacion = conversor.convertirNotificacion(peticion);
        notificacionEvent.notificarUsuarios(peticionNotificacion);
    }
    
}
