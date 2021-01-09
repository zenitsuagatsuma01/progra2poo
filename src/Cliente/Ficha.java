/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author aleja
 */
public class Ficha implements Serializable{
    String nombre;
    String imagen;
    JLabel labelFicha;
    JPanel ultimoPanel;
    String nombreJugador;
    int posicionActual;

    public Ficha(String nombre, String imagen, String nombreJugador) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.nombreJugador = nombreJugador;
        this.posicionActual = 0;
        this.ultimoPanel = new JPanel();
    }

    public JPanel getUltimoPanel() {
        return ultimoPanel;
    }

    public void setUltimoPanel(JPanel ultimoPanel) {
        this.ultimoPanel = ultimoPanel;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
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
