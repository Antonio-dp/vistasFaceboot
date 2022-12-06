/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import peticiones.PeticionComentarios;

/**
 * Interfaz para notificar cuando haya ocurrido el evento de ConsultarComentarios
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface IConsultarComentariosObserver {
    /**
     * Recibe la peticionComentarios con la accion realizada
     * @param peticionComentarios 
     */
    public void onConsultarComentarios(PeticionComentarios peticionComentarios);
}
