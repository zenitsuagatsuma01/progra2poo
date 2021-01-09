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
public class Servicios extends Propiedades{
    public int cantidadDeServicios;

    public Servicios(String imagen, JPanel panel, String nombre, int precioCompra, int valorHipoteca) {
        super(imagen, panel, nombre, precioCompra, valorHipoteca);
        this.cantidadDeServicios = 0;
    }
    
    public int cobrar(int dados){
        if(cantidadDeServicios == 1){
            return dados * 4;
        }
        else{
            return dados * 10;
        }
        
    }

    @Override
    public int cobrar() {
        return 0;
     }
    
    
    
}
