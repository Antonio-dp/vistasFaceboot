/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package utils;

import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author jegav
 */
public interface IConversorFechas {
    public Calendar toCalendar(LocalDate date);
    public LocalDate toLocalDate(Calendar date);
}

