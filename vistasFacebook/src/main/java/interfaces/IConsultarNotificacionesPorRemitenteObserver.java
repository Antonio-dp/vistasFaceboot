/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import peticiones.PeticionNotificaciones;

/**
 * Interfaz para notificar cuando haya ocurrido el evento de ConsultarNotificacionesPorRemitente
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface IConsultarNotificacionesPorRemitenteObserver {
    /**
     * Recibe la peticionNotificaciones con la accion realizada
     * @param peticionNotificaciones 
     */
    public void onConsultarNotificacionesPorRemitente(PeticionNotificaciones peticionNotificaciones);
}
