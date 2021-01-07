/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author aleja
 */
public class Ficha {
    String nombre;
    String imagen;
    JLabel labelFicha;
    String nombreJugador;

    public Ficha(String nombre, String imagen, String nombreJugador) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.nombreJugador = nombreJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public JLabel getLabelFicha() {
        return labelFicha;
    }

    public void setLabelFicha(JLabel labelFicha) {
        this.labelFicha = labelFicha;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
    
    
    
}
