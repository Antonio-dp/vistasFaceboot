/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import interfaces.EventNotifier;
import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IConsultarPublicacionesPorHashtagObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionPublicaciones;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de ConsultarPublicacionesPorHashtag
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class ConsultarPublicacionesPorHashtagEvent implements EventNotifier{
    /**
     * Lista de observadores
     */
    private List<IConsultarPublicacionesPorHashtagObserver> listeners;
    /**
     * Conversor de Json a Objeto concreto
     */
    private IJsonToObject conversor;
    /**
     * Objeto estatico de la clase
     */
    private static ConsultarPublicacionesPorHashtagEvent publicacionesEvent;
    /**
     * Constructor que inicializa el valor de los atributos
     */
    private ConsultarPublicacionesPorHashtagEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    /**
     * Constructor estatico que crea una instancia del objeto
     * @return instancia de la clase
     */   
    public static ConsultarPublicacionesPorHashtagEvent getInstance(){
        if(publicacionesEvent == null){
            publicacionesEvent = new ConsultarPublicacionesPorHashtagEvent();
        }
        return publicacionesEvent;
    }
    /**
     * Permite enviar la peticion a todos los usuarios suscritos
     * en la lista de observadores de la consulta de publicaciones por hashtag
     * @param peticion peticion a enviar
     */ 
    public void notificarUsuarios(PeticionPublicaciones peticion){
        for(IConsultarPublicacionesPorHashtagObserver listener: listeners){
            listener.onConsultarPublicacionesPorHashtag(peticion);
        }
    }
    /**
     * Permite suscribirte a la lista de observadores de consultar publicaciones
     * por hashtag
     * @param listener instancia a inscribir
     */
    public void suscribirse(IConsultarPublicacionesPorHashtagObserver listener){
        listeners.add(listener);
    }
    /**
     * Permite desuscribirte de la lista de observadores de consultar
     * publicaciones por hashtag
     * @param listener instancia a desuscribir
     */ 
    public void desuscribirse(IConsultarPublicacionesPorHashtagObserver listener){
        listeners.remove(listener);
    }
    /**
     * Recibe una peticion en String y la convierte a la instancia de peticionPublicaciones
     * y permite enviar la respuesta de la peticion a los observadores de la lista de
     * consultar publicaciones por hashtag suscritos
     * @param peticion peticion a convertir y notificar
     */
    @Override
    public void notificar(String peticion) {
        PeticionPublicaciones peticionPublicaciones = conversor.convertirPeticionPublicaciones(peticion);
        publicacionesEvent.notificarUsuarios(peticionPublicaciones);
    }
}
