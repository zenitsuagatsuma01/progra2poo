/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartas;

/**
 *
 * @author Usuario
 */
public abstract class Propiedades extends Cartas{
    public int precioCompra;
    public int valorHipoteca;

    public Propiedades(String imagen, String nombre, int precioCompra, int valorHipoteca) {
        super(imagen, nombre);
        this.precioCompra = precioCompra;
        this.valorHipoteca = valorHipoteca;
                
    }

    
    
    public abstract int cobrar();
}