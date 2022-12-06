/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import peticiones.PeticionNotificacion;

/**
 * Interfaz para notificar cuando haya ocurrido el evento de RegistrarNotificacion
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface IRegistrarNotificacionObserver {
    /**
     * Recibe la peticionNotificacion con la accion realizada
     * @param respuesta 
     */
    public void onRegistrarNotificacion(PeticionNotificacion respuesta);
}
