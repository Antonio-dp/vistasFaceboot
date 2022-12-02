/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logins;

import entidades.Usuario;

/**
 *
 * @author jegav
 */
public interface ILoginStrategy {
    public void login(Usuario usuario);
}
