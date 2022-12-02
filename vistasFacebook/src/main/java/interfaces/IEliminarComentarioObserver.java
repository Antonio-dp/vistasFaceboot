/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Comentario;
import java.util.List;
import peticiones.PeticionComentario;

/**
 *
 * @author tonyd
 */
public interface IEliminarComentarioObserver {
    public void onEliminarComentario(PeticionComentario respuesta);
}
