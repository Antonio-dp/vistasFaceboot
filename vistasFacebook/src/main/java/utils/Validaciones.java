/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que permite realizar validaciones
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class Validaciones {
    /**
     * Objeto conversor de fechas
     */
    static IConversorFechas conversor = new ConversorFechas();
    /**
     * Permite validar el formato del correo
     * @param correo correo a validar
     * @return true si el formato es correcto
     */
    public static boolean validarCorreo(String correo) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        String email = correo;
        Matcher matcher = pattern.matcher(email);

        return matcher.find();
    }
    /**
     * Permite validar el formato del número de teléfono
     * @param numero numero a validar
     * @return true si el formato es correcto
     */
    public static boolean validarTelefono(String numero) {
        String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numero);
        return matcher.find();
    }
}
