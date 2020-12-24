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
public abstract class Cartas {
    public String imagen;
    public String nombre;
    
    public Cartas(String imagen, String nombre){
        this.imagen = imagen;
        this.nombre = nombre;
    }
}
