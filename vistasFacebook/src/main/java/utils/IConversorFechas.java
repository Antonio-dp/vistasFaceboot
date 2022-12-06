/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package utils;

import java.time.LocalDate;
import java.util.Calendar;

/**
 * Interfaz que permite convertir las fechas de Calendar a LocalDate y viceversa
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public interface IConversorFechas {
    /**
     * Permite convertir la fecha dada por su parametro a una de tipo Calendar
     * @param date fecha a convertir
     * @return fecha en Calendar
     */
    public Calendar toCalendar(LocalDate date);
    /**
     * Permite convertir la fecha dada por su parametro a una de tipo LocalDate
     * @param date fecha a convertir
     * @return fecha en LocalDate
     */
    public LocalDate toLocalDate(Calendar date);
}

