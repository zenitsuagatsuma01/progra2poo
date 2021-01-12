/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartas;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public abstract class Propiedades extends Cartas{
    public int precioCompra;
    public int valorHipoteca;
    public JPanel panel;

    public Propiedades(String imagen, JPanel panel, String nombre, int precioCompra, int valorHipoteca) {
        super(imagen, panel, nombre);
        this.precioCompra = precioCompra;
        this.valorHipoteca = valorHipoteca;
        this.panel = panel;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getValorHipoteca() {
        return valorHipoteca;
    }

    public void setValorHipoteca(int valorHipoteca) {
        this.valorHipoteca = valorHipoteca;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    
    
    public abstract int cobrar();
}