/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import peticiones.PeticionPublicacion;

/**
 *
 * @author jegav
 */
public interface IRegistrarPublicacionObserver {
    public void onRegistrarPublicacion(PeticionPublicacion respuesta);
}
