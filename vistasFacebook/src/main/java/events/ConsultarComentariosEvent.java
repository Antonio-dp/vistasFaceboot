/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import interfaces.EventNotifier;
import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IConsultarComentariosObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionComentarios;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de ConsultarComentarios
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class ConsultarComentariosEvent implements EventNotifier{
    /**
     * Lista de observadores
     */
    private List<IConsultarComentariosObserver> listeners;
    /**
     * Conversor de Json a Objeto concreto
     */
    private IJsonToObject conversor;
    /**
     * Objeto estatico de la clase
     */
    private static ConsultarComentariosEvent comentariosEvent;
    /**
     * Constructor que inicializa el valor de los atributos
     */
    private ConsultarComentariosEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    /**
     * Constructor estatico que crea una instancia del objeto
     * @return instancia de la clase
     */
    public static ConsultarComentariosEvent getInstance(){
        if(comentariosEvent == null){
            comentariosEvent = new ConsultarComentariosEvent();
        }
        return comentariosEvent;
    }
    /**
     * Permite enviar la peticion a todos los usuarios suscritos
     * en la lista de observadores de comentarios
     * @param peticion peticion a enviar
     */
    public void notificarUsuarios(PeticionComentarios peticion){
        for(IConsultarComentariosObserver listener: listeners){
            listener.onConsultarComentarios(peticion);
        }
    }
    /**
     * Permite suscribirte a la lista de observadores de comentarios
     * @param listener instancia a inscribir
     */
    public void suscribirse(IConsultarComentariosObserver listener){
        listeners.add(listener);
    }
    /**
     * Permite desuscribirte de la lista de observadores de comentarios
     * @param listener instancia a desuscribir
     */
    public void desuscribirse(IConsultarComentariosObserver listener){
        listeners.remove(listener);
    }
    /**
     * Recibe una peticion en String y la convierte a la instancia de peticion comentarios
     * y permite enviar la respuesta de la peticion a los observadores de los comentarios suscritos
     * @param peticion peticion a convertir y notificar
     */
    @Override
    public void notificar(String peticion) {
        PeticionComentarios peticionComentarios = conversor.convertirPeticionComentarios(peticion);
        comentariosEvent.notificarUsuarios(peticionComentarios);
    }   
}
