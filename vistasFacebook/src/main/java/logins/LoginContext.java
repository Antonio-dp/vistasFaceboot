/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logins;

import entidades.Usuario;

/**
 *
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
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
