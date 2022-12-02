/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IRegistrarHashtagsObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionHashtags;

/**
 *
 * @author tonyd
 */
public class RegistrarHashtagsEvent implements EventNotifier{

    private List<IRegistrarHashtagsObserver> listeners;
    private IJsonToObject conversor;
    private static RegistrarHashtagsEvent hashtagsEvent;

    private RegistrarHashtagsEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }

    public static RegistrarHashtagsEvent getInstance() {
        if (hashtagsEvent == null) {
            hashtagsEvent = new RegistrarHashtagsEvent();
        }
        return hashtagsEvent;
    }

    public void notificarUsuarios(PeticionHashtags peticion) {
        for (IRegistrarHashtagsObserver listener : listeners) {
            listener.onRegistrarHashtags(peticion);
        }
    }

    public void suscribirse(IRegistrarHashtagsObserver listener) {
        listeners.add(listener);
    }

    public void desuscribirse(IRegistrarHashtagsObserver listener) {
        listeners.remove(listener);
    }

    @Override
    public void notificar(String peticion) {
        PeticionHashtags peticionHashtags = conversor.convertirPeticionHashtags(peticion);
        hashtagsEvent.notificarUsuarios(peticionHashtags);
    }
}
