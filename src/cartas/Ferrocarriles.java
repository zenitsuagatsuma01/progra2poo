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

    public Ferrocarriles(String imagen, JPanel panel, String nombre, int precioCompra, int valorHipoteca) {
        super(imagen, panel, nombre, precioCompra, valorHipoteca);
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
            default:
                return 200;
        }
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
    
    
}
