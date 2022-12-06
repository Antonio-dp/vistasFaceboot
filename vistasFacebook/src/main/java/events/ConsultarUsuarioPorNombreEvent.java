/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import interfaces.EventNotifier;
import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IConsultarUsuarioPorNombreObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionUsuario;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de ConsultarUsuarioPorNombre
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class ConsultarUsuarioPorNombreEvent implements EventNotifier {
    /**
     * Lista de observadores
     */
    private List<IConsultarUsuarioPorNombreObserver> listeners;
    /**
     * Conversor de Json a Objeto concreto
     */
    private IJsonToObject conversor;
    /**
     * Objeto estatico de la clase
     */
    private static ConsultarUsuarioPorNombreEvent consultarEvent;
    /**
     * Constructor que inicializa el valor de los atributos
     */
    public ConsultarUsuarioPorNombreEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    /**
     * Constructor estatico que crea una instancia del objeto
     * @return instancia de la clase
     */  
    public static ConsultarUsuarioPorNombreEvent getInstance(){
        if(consultarEvent == null){
            consultarEvent = new ConsultarUsuarioPorNombreEvent();
        }
        return consultarEvent;
    }
    /**
     * Permite enviar la peticion a todos los usuarios suscritos
     * en la lista de observadores de la consulta de usuario por nombre
     * @param peticion peticion a enviar
     */ 
    public void notificarUsuarios(PeticionUsuario peticion){
        List<IConsultarUsuarioPorNombreObserver> copiaListeners = new ArrayList(listeners);
        for(IConsultarUsuarioPorNombreObserver listener: copiaListeners){
            
            listener.onConsultarUsuarioPorNombre(peticion);
        }
    }
    /**
     * Permite suscribirte a la lista de observadores de consultar usuario 
     * por nombre
     * @param listener instancia a inscribir
     */
    public void suscribirse(IConsultarUsuarioPorNombreObserver listener){
        listeners.add(listener);
    }
    /**
     * Permite desuscribirte de la lista de observadores de consultar
     * usuario por nombre
     * @param listener instancia a desuscribir
     */   
    public void desuscribir(IConsultarUsuarioPorNombreObserver listener){
        listeners.remove(listener);
    }
    /**
     * Recibe una peticion en String y la convierte a la instancia de peticionUsuario
     * y permite enviar la respuesta de la peticion a los observadores de la lista de
     * consultar usuario por nombre suscritos
     * @param peticion peticion a convertir y notificar
     */
    @Override
    public void notificar(String peticion) {
        PeticionUsuario peticionUsuario = conversor.convertirPeticionUsuario(peticion);
        consultarEvent.notificarUsuarios(peticionUsuario);
    }
}
