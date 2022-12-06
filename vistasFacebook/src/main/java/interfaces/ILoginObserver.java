/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import peticiones.PeticionUsuario;

/**
 * Interfaz para notificar cuando haya ocurrido el evento de Login
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface ILoginObserver {
    /**
     * Recibe la peticionUsuario con la accion realizada
     * @param usuario 
     */
    public void onLogin(PeticionUsuario usuario);
}
