/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartas;

import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public abstract class Cartas {
    public String imagen;
    public String nombre;
    public JPanel panel;
    
    public Cartas(String imagen, JPanel panel, String nombre){
        this.imagen = imagen;
        this.panel = panel;
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    
    
    
}
