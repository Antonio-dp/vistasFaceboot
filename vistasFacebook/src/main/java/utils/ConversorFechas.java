/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Clase que permite convertir las fechas de Calendar a LocalDate y viceversa
 * @author Jesus Valencia, Antonio del Pardo, Marco Irineo, Giovanni Garrido
 */
public class ConversorFechas implements IConversorFechas {
    /**
     * Permite convertir la fecha dada por su parametro a una de tipo Calendar
     * @param date fecha a convertir
     * @return fecha en Calendar
     */
    public Calendar toCalendar(LocalDate date) {
        Date fechaDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaDate);
        return calendar;
    }
    /**
     * Permite convertir la fecha dada por su parametro a una de tipo LocalDate
     * @param date fecha a convertir
     * @return fecha en LocalDate
     */
    public LocalDate toLocalDate(Calendar date) {
        TimeZone tz = date.getTimeZone();
        ZoneId zid = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
        LocalDate localDate = LocalDateTime.ofInstant(date.toInstant(), zid).toLocalDate();
        return localDate;
    }
}
