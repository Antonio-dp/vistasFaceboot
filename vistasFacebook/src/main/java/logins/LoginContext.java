/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logins;

import entidades.Usuario;

/**
 *
 * @author jegav
 */
public class LoginContext {
    ILoginStrategy loginStrategy;
    
    public void setLoginStrategy(ILoginStrategy loginStrategy){
        this.loginStrategy = loginStrategy;
    }
    
    public void realizarLogin(Usuario usuario){
        if(loginStrategy != null){
            loginStrategy.login(usuario);
        }
    }
    
}
