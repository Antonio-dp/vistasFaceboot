/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import interfaces.EventNotifier;
import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IConsultarPublicacionesObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionPublicaciones;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de ConsultarPublicaciones
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class ConsultarPublicacionesEvent implements EventNotifier {
    /**
     * Lista de observadores
     */
    private List<IConsultarPublicacionesObserver> listeners;
    /**
     * Conversor de Json a Objeto concreto
     */
    private IJsonToObject conversor;
    /**
     * Objeto estatico de la clase
     */
    private static ConsultarPublicacionesEvent publicacionesEvent;
    /**
     * Constructor que inicializa el valor de los atributos
     */
    private ConsultarPublicacionesEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    /**
     * Constructor estatico que crea una instancia del objeto
     * @return instancia de la clase
     */
    public static ConsultarPublicacionesEvent getInstance(){
        if(publicacionesEvent == null){
            publicacionesEvent = new ConsultarPublicacionesEvent();
        }
        return publicacionesEvent;
    }
    /**
     * Permite enviar la peticion a todos los usuarios suscritos
     * en la lista de observadores de la consulta de publicaciones
     * @param peticion peticion a enviar
     */
    public void notificarUsuarios(PeticionPublicaciones peticion){
        for(IConsultarPublicacionesObserver listener: listeners){
            listener.onConsultarPublicaciones(peticion);
        }
    }
    /**
     * Permite suscribirte a la lista de observadores de consultar publicaciones
     * @param listener instancia a inscribir
     */
    public void suscribirse(IConsultarPublicacionesObserver listener){
        listeners.add(listener);
    }
    /**
     * Permite desuscribirte de la lista de observadores de consultar
     * publicaciones
     * @param listener instancia a desuscribir
     */ 
    public void desuscribirse(IConsultarPublicacionesObserver listener){
        listeners.remove(listener);
    }
    /**
     * Recibe una peticion en String y la convierte a la instancia de peticionPublicaciones
     * y permite enviar la respuesta de la peticion a los observadores de la lista de
     * consultar publicaciones suscritos
     * @param peticion peticion a convertir y notificar
     */
    @Override
    public void notificar(String peticion) {
        PeticionPublicaciones peticionPublicaciones = conversor.convertirPeticionPublicaciones(peticion);
        publicacionesEvent.notificarUsuarios(peticionPublicaciones);
    }
}
