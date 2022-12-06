/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logins;

import entidades.Usuario;

/**
 * Permite elegir entre diferentes estrategias de login
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class LoginContext {
    /**
     * Estrategia de login concreta
     */
    ILoginStrategy loginStrategy;
    
    /**
     * Este método permite settear una estrategia de login
     * @param loginStrategy Estrategia de login que se desea utilizar
     */
    public void setLoginStrategy(ILoginStrategy loginStrategy){
        this.loginStrategy = loginStrategy;
    }
    
    /**
     * Realiza el login de la estrategia seteada
     * @param usuario usuario que desea logearse
     */
    public void realizarLogin(Usuario usuario){
        if(loginStrategy != null){
            loginStrategy.login(usuario);
        }
    }
    
}
