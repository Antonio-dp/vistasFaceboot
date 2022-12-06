/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import peticiones.PeticionPublicacion;

/**
 * Interfaz notificar cuando haya ocurrido el evento de RegistrarPublicación
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface IRegistrarPublicacionObserver {
    /**
     * Recibe la peticionPublicacion con la accion realizada
     * @param respuesta 
     */
    public void onRegistrarPublicacion(PeticionPublicacion respuesta);
}
