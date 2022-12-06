/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import peticiones.PeticionUsuario;

/**
 * Interfaz para notificar cuando haya ocurrido el evento de RegistarUsuario
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface IRegistrarUsuarioObserver {
    /**
     * Recibe la peticionUsuario con la accion realizada
     * @param respuesta 
     */
    public void onRegistrarUsuario(PeticionUsuario respuesta);
}
