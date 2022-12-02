/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import peticiones.PeticionNotificacion;

/**
 *
 * @author tonyd
 */
public interface IRegistrarNotificacionObserver {
    public void onRegistrarNotificacion(PeticionNotificacion respuesta);
}
