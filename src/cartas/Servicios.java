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

    public Servicios(String imagen, JPanel panel, String nombre, int precioCompra, int valorHipoteca, JLabel lblLibre, JLabel lblAlquiler, JLabel lblCasas, JLabel lblHoteles) {
        super(imagen, panel, nombre, precioCompra, valorHipoteca, lblLibre, lblAlquiler, lblCasas, lblHoteles, "Servicios", 0,0 ,0);
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

    public int getCantidadDeServicios() {
        return cantidadDeServicios;
    }

    public void setCantidadDeServicios(int cantidadDeServicios) {
        this.cantidadDeServicios = cantidadDeServicios;
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
