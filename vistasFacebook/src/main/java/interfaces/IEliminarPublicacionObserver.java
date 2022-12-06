/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import peticiones.PeticionPublicaciones;

/**
 * Interfaz para notificar cuando haya ocurrido el evento de EliminarPublicacion
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface IEliminarPublicacionObserver {
    /**
     * Recibe la peticionPublicaciones con la accion realizada
     * @param respuesta 
     */
    public void onEliminarPublicacion(PeticionPublicaciones respuesta);
}
