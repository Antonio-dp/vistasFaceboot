/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logins;

import comVista.IComunicadorVista;
import entidades.Usuario;

/**
 *
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class FacebootStrategy implements ILoginStrategy{

    private IComunicadorVista comunicadorVista;

    public FacebootStrategy(IComunicadorVista comunicadorVista) {
        this.comunicadorVista = comunicadorVista;
    }
    
    @Override
    public void login(Usuario usuario) {
        comunicadorVista.iniciarSesion(usuario);
    }
    
}
