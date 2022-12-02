/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logins;

import comVista.IComunicadorVista;
import entidades.Usuario;
import utils.FbConexion;

/**
 *
 * @author jegav
 */
public class FacebookStrategy implements ILoginStrategy {

    private IComunicadorVista comunicadorVista;

    public FacebookStrategy(IComunicadorVista comunicadorVista) {
        this.comunicadorVista = comunicadorVista;
    }
    
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
