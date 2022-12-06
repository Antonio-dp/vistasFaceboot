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
import interfaces.IRegistrarComentarioObserver;
import peticiones.PeticionComentario;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de RegistrarComentario
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class RegistrarComentarioEvent implements EventNotifier{
    /**
     * Lista de observadores
     */
    private List<IRegistrarComentarioObserver> listeners;
    /**
     * Objeto estatico de la clase
     */
    private static RegistrarComentarioEvent comentarioEvent;
    /**
     * Conversor de Json a Objeto concreto
     */
    private IJsonToObject conversor;
    /**
     * Constructor que inicializa el valor de los atributos
     */      
    private RegistrarComentarioEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    /**
     * Constructor estatico que crea una instancia del objeto
     * @return instancia de la clase
     */      
    public static RegistrarComentarioEvent getInstance(){
        if(comentarioEvent == null){
            comentarioEvent = new RegistrarComentarioEvent();
        }
        return comentarioEvent;
    }
    /**
     * Permite enviar la peticion a todos los usuarios suscritos
     * en la lista de observadores de registrar comentario
     * @param peticion peticion a enviar
     */     
    public void notificarUsuarios(PeticionComentario peticion){
        for(IRegistrarComentarioObserver listener: listeners){
            listener.onRegistrarComentario(peticion);
        }  
    }
    /**
     * Permite suscribirte a la lista de observadores de registrar comentario
     * @param listener instancia a inscribir
     */ 
    public void suscribirse(IRegistrarComentarioObserver listener){
        listeners.add(listener);
    }
    /**
     * Permite desuscribirte de la lista de observadores de registrar comentario
     * @param listener instancia a desuscribir
     */     
    public void desuscribirse(IRegistrarComentarioObserver listener){
        listeners.remove(listener);
    }
    /**
     * Recibe una peticion en String y la convierte a la instancia de peticionComentario
     * y permite enviar la respuesta de la peticion a los observadores de la lista de
     * registrar comentario suscritos
     * @param peticion peticion a convertir y notificar
     */
    @Override
    public void notificar(String mensaje) {
        PeticionComentario peticion = conversor.convertirPeticionComentario(mensaje);
        comentarioEvent.notificarUsuarios(peticion);
    }

}
