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
public class Ferrocarriles extends Propiedades{
    public int cantidadDeFerrocarriles;
    public boolean dobleAlquiler = false;

    public Ferrocarriles(String imagen, JPanel panel, String nombre, int precioCompra, int valorHipoteca, JLabel lblLibre, JLabel lblAlquiler, JLabel lblCasas, JLabel lblHotel) {
        super(imagen, panel, nombre, precioCompra, valorHipoteca, lblLibre, lblAlquiler, lblCasas, lblHotel, "Ferrocarril", 0, 0, 0);
        this.cantidadDeFerrocarriles = 0;
    }
    
    @Override
    public int cobrar(){
        switch (cantidadDeFerrocarriles) {
            case 1:
                return 25;
            case 2:
                return 50;
            case 3:
                return 100;
            case 4:
                return 200;
            default:
                return 25;
        }
    }

    public boolean isDobleAlquiler() {
        return dobleAlquiler;
    }

    public void setDobleAlquiler(boolean dobleAlquiler) {
        this.dobleAlquiler = dobleAlquiler;
    }
    
    

    public int getCantidadDeFerrocarriles() {
        return cantidadDeFerrocarriles;
    }

    public void setCantidadDeFerrocarriles(int cantidadDeFerrocarriles) {
        this.cantidadDeFerrocarriles = cantidadDeFerrocarriles;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JLabel getLblLibre() {
        return lblLibre;
    }

    public void setLblLibre(JLabel lblLibre) {
        this.lblLibre = lblLibre;
    }

    public JLabel getLblAlquiler() {
        return lblAlquiler;
    }

    public void setLblAlquiler(JLabel lblAlquiler) {
        this.lblAlquiler = lblAlquiler;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
