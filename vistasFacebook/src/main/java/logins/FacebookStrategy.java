/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logins;

import comVista.IComunicadorVista;
import entidades.Usuario;
import utils.FbConexion;

/**
 * Estrategia de login que permite realizar un login con facebook
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class FacebookStrategy implements ILoginStrategy {

    /**
     * Permite comunicarse con el servidor
     */
    private IComunicadorVista comunicadorVista;

    /**
     * Inicializa el comunicadorVista
     * @param comunicadorVista instancia de comunicadorvista que se desea setear
     */
    public FacebookStrategy(IComunicadorVista comunicadorVista) {
        this.comunicadorVista = comunicadorVista;
    }
    
    /**
     * Realiza el login con facebook y le envia una petición al servidor
     * @param usuario usuario que se desea logear
     */
    @Override
    public void login(Usuario usuario) {
        try {
            FbConexion fbCon = new FbConexion();
            Usuario usuarioFb = fbCon.authUser();
            comunicadorVista.iniciarSesionFacebook(usuarioFb);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
