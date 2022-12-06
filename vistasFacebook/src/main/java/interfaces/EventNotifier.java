/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 * Se encarga de notificar cuando haya ocurrido un evento
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface EventNotifier {
    /**
     * Recibe una peticion en String y la convierte a la instancia de la peticion
     * del evento y permite enviar la respuesta de la peticion a los observadores
     * suscritos
     * @param peticion peticion a convertir y notificar
     */
    public void notificar(String peticion);
}
