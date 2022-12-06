/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import interfaces.EventNotifier;
import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IEditarUsuarioObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionUsuario;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de EditarUsuario
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class EditarUsuarioEvent implements EventNotifier{
    /**
     * Lista de observadores
     */
    private List<IEditarUsuarioObserver> listeners;
    /**
     * Conversor de Json a Objeto concreto
     */
    private IJsonToObject conversor;
    /**
     * Objeto estatico de la clase
     */
    private static EditarUsuarioEvent usuarioEvent;
    /**
     * Constructor que inicializa el valor de los atributos
     */
    private EditarUsuarioEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }
    /**
     * Constructor estatico que crea una instancia del objeto
     * @return instancia de la clase
     */ 
    public static EditarUsuarioEvent getInstance() {
        if (usuarioEvent == null) {
            usuarioEvent = new EditarUsuarioEvent();
        }
        return usuarioEvent;
    }
    /**
     * Permite enviar la peticion a todos los usuarios suscritos
     * en la lista de observadores de editar usuario
     * @param peticion peticion a enviar
     */ 
    public void notificarUsuarios(PeticionUsuario peticion) {
        for (IEditarUsuarioObserver listener : listeners) {
            listener.onEditarUsuario(peticion);
        }
    }
    /**
     * Permite suscribirte a la lista de observadores de editar usuario
     * @param listener instancia a inscribir
     */
    public void suscribirse(IEditarUsuarioObserver listener) {
        listeners.add(listener);
    }
    /**
     * Permite desuscribirte de la lista de observadores de editar usuario
     * @param listener instancia a desuscribir
     */  
    public void desuscribirse(IEditarUsuarioObserver listener) {
        listeners.remove(listener);
    }
    /**
     * Recibe una peticion en String y la convierte a la instancia de peticionUsuario
     * y permite enviar la respuesta de la peticion a los observadores de la lista de
     * editar usuario suscritos
     * @param peticion peticion a convertir y notificar
     */
    @Override
    public void notificar(String peticion) {
        PeticionUsuario peticionUsuario = conversor.convertirPeticionUsuario(peticion);
        usuarioEvent.notificarUsuarios(peticionUsuario);
    }
}
