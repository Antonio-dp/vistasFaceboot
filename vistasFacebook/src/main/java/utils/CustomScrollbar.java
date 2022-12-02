/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

/**
 *
 * @author jegav
 */
public class CustomScrollbar extends JScrollBar{
    public CustomScrollbar() {
        setUI(new CustomScrollbarUI());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(218, 218, 218));
        setBackground(Color.WHITE);
    }
    
    public CustomScrollbar(Color colorBackground, Color colorForeground) {
        setUI(new CustomScrollbarUI());
        setPreferredSize(new Dimension(8, 8));
        setForeground(colorForeground);
        setBackground(colorBackground);
    }
}
