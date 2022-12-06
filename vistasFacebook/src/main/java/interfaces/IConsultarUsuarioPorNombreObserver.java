/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import peticiones.PeticionUsuario;

/**
 * Interfaz para notificar cuando haya ocurrido el evento de ConsultarUsuarioPorNombre
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface IConsultarUsuarioPorNombreObserver {
    /**
     * Recibe la peticionUsuario con la accion realizada
     * @param peticionConsultarUsuarioPorNombre 
     */
    public void onConsultarUsuarioPorNombre(PeticionUsuario peticionConsultarUsuarioPorNombre);
}
