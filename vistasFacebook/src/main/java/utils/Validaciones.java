/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import entidades.Usuario;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Usuario
 */
public class Validaciones {

    static IConversorFechas conversor = new ConversorFechas();
    
    public static boolean validarCorreo(String correo) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        String email = correo;
        Matcher matcher = pattern.matcher(email);

        return matcher.find();
    }

    public static boolean validarTelefono(String numero) {
        String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numero);
        return matcher.find();
    }

    public static boolean validarFechaNac(Calendar fecha) {
        LocalDate fechaNac = conversor.toLocalDate(fecha);
        LocalDate hoy = LocalDate.now();
        long edad = ChronoUnit.YEARS.between(fechaNac, hoy);
        if (edad < 18) {
            return true;
        }
        return false;
    }
}
