/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import peticiones.PeticionComentario;

/**
 * Se encarga de notificar cuando haya ocurrido el evento de EliminarComentario
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface IEliminarComentarioObserver {
    /**
     * Recibe la peticionComentario con la accion realizada
     * @param respuesta 
     */
    public void onEliminarComentario(PeticionComentario respuesta);
}
