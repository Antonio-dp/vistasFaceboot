/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import peticiones.PeticionPublicaciones;

/**
 * Interfaz para notificar cuando haya ocurrido el evento de ConsultarPublicaciones
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface IConsultarPublicacionesObserver {
    /**
     * Recibe la peticionPublicaciones con la accion realizada
     * @param peticionPublicaciones 
     */
    public void onConsultarPublicaciones(PeticionPublicaciones peticionPublicaciones);
}
