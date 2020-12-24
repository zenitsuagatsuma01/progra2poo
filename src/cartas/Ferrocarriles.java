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
public class Ferrocarriles extends Propiedades{
    public int cantidadDeFerrocarriles;

    public Ferrocarriles(String imagen, String nombre, int precioCompra, int valorHipoteca, int cantidadDeFerrocarriles) {
        super(imagen, nombre, precioCompra, valorHipoteca);
        this.cantidadDeFerrocarriles = cantidadDeFerrocarriles;
        
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
}
