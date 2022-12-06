/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logins;

import entidades.Usuario;

/**
 * Interfaz que indica que la clase es una estrategia para realizar un login
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface ILoginStrategy {
    public void login(Usuario usuario);
}
