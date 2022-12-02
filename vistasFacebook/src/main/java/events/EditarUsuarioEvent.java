/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import conversors.IJsonToObject;
import conversors.JsonToObject;
import interfaces.IEditarUsuarioObserver;
import java.util.ArrayList;
import java.util.List;
import peticiones.PeticionUsuario;

/**
 *
 * @author tonyd
 */
public class EditarUsuarioEvent implements EventNotifier{
    private List<IEditarUsuarioObserver> listeners;
    private IJsonToObject conversor;
    private static EditarUsuarioEvent usuarioEvent;

    private EditarUsuarioEvent() {
        this.listeners = new ArrayList();
        conversor = new JsonToObject();
    }

    public static EditarUsuarioEvent getInstance() {
        if (usuarioEvent == null) {
            usuarioEvent = new EditarUsuarioEvent();
        }
        return usuarioEvent;
    }

    public void notificarUsuarios(PeticionUsuario peticion) {
        for (IEditarUsuarioObserver listener : listeners) {
            listener.onEditarUsuario(peticion);
        }
    }

    public void suscribirse(IEditarUsuarioObserver listener) {
        listeners.add(listener);
    }

    public void desuscribirse(IEditarUsuarioObserver listener) {
        listeners.remove(listener);
    }

    @Override
    public void notificar(String peticion) {
        PeticionUsuario peticionUsuario = conversor.convertirPeticionUsuario(peticion);
        usuarioEvent.notificarUsuarios(peticionUsuario);
    }
}
