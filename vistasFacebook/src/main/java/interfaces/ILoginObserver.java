/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Usuario;
import peticiones.PeticionUsuario;

/**
 *
 * @author jegav
 */
public interface ILoginObserver {
    public void onLogin(PeticionUsuario usuario);
}
