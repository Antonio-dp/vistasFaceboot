/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import peticiones.PeticionComentario;

/**
 * Interfaz para notificar cuando haya ocurrido el evento de RegistrarComentario
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface IRegistrarComentarioObserver {
    /**
     * Recibe la peticionComentario con la accion realizada
     * @param respuesta 
     */
    public void onRegistrarComentario(PeticionComentario respuesta);
}
