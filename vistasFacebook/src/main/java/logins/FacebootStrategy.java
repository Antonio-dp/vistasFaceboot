/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logins;

import comVista.IComunicadorVista;
import entidades.Usuario;

/**
 * Estrategia de login que permite realizar un login normal Faceboot
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class FacebootStrategy implements ILoginStrategy{

    /**
     * Permite comunicarse con el servidor
     */
    private IComunicadorVista comunicadorVista;

    /**
     * Inicializa el comunicadorVista
     * @param comunicadorVista instancia de comunicadorvista que se desea setear
     */
    public FacebootStrategy(IComunicadorVista comunicadorVista) {
        this.comunicadorVista = comunicadorVista;
    }
    
    /**
     * Realiza el login con facebook y le envia una petición al servidor
     * @param usuario usuario que se desea logear
     */
    @Override
    public void login(Usuario usuario) {
        comunicadorVista.iniciarSesion(usuario);
    }
    
}
