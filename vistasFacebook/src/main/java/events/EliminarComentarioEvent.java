/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import interfaces.EventNotifier;
import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IEliminarComentarioObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionComentario;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de EliminarComentario
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class EliminarComentarioEvent implements EventNotifier {
    /**
     * Lista de observadores
     */
    private List<IEliminarComentarioObserver> listeners;
    /**
     * Conversor de Json a Objeto concreto
     */
    private IJsonToObject conversor;
    /**
     * Objeto estatico de la clase
     */
    private static EliminarComentarioEvent eliminarComentarioEvent;
    /**
     * Constructor que inicializa el valor de los atributos
     */
    public EliminarComentarioEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    /**
     * Constructor estatico que crea una instancia del objeto
     * @return instancia de la clase
     */ 
    public static EliminarComentarioEvent getInstance(){
        if(eliminarComentarioEvent == null){
            eliminarComentarioEvent = new EliminarComentarioEvent();
        }
        return eliminarComentarioEvent;
    }
    /**
     * Permite enviar la peticion a todos los usuarios suscritos
     * en la lista de observadores de eliminar comentario
     * @param peticion peticion a enviar
     */   
    public void notificarUsuarios(PeticionComentario peticionComentario) {
        for(IEliminarComentarioObserver listener: listeners){
            listener.onEliminarComentario(peticionComentario);
        }
    }
    /**
     * Permite suscribirte a la lista de observadores de eliminar comentario
     * @param listener instancia a inscribir
     */
    public void suscribirse(IEliminarComentarioObserver listener) {
        listeners.add(listener);
    }
    /**
     * Permite desuscribirte de la lista de observadores de eliminar comentario
     * @param listener instancia a desuscribir
     */ 
    public void desuscribir(IEliminarComentarioObserver listener) {
        listeners.remove(listener);
    }
    /**
     * Recibe una peticion en String y la convierte a la instancia de peticionComentario
     * y permite enviar la respuesta de la peticion a los observadores de la lista de
     * eliminar comentario suscritos
     * @param peticion peticion a convertir y notificar
     */
    @Override
    public void notificar(String peticion) {
        PeticionComentario peticionComentario = conversor.convertirPeticionComentario(peticion);
        eliminarComentarioEvent.notificarUsuarios(peticionComentario);
    }
}
