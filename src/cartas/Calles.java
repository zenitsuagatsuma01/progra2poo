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
public class Calles extends Propiedades{
    public String color;
    public int cantidadCasas;
    public int precioCasa;
    public int precio0;
    public int precio1;
    public int precio2;
    public int precio3;
    public int precio4;
    public int precio5;

    public Calles(String imagen, String nombre, int precioCompra, int valorHipoteca, String color, int cantidadCasas, int precioCasas, int precio0, int precio1, int precio2, int precio3, int precio4, int precio5) {
        super(imagen, nombre, precioCompra, valorHipoteca);
        this.color = color;
        this.cantidadCasas = cantidadCasas;
        this.precioCasa = precioCasas;
        this.precio0 = precio0;
        this.precio1 = precio1;
        this.precio2 = precio2;
        this.precio3 = precio3;
        this.precio4 = precio4;
        this.precio5 = precio5;
                
    }
    
    @Override
    public int cobrar(){
        switch (cantidadCasas) {
            case 0:
                return precio0;
            case 1:
                return precio1;
            case 2:
                return precio2;
            case 3:
                return precio3;
            case 4:
                return precio4;
            default:
                return precio5;
        }
        

    }
    
    
}
