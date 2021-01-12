/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartas;

import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Calles extends Propiedades implements Serializable{
    public String color;
    public int cantidadCasas;
    public int cantidadHoteles;
    public int cantidadEdificios;
    public int precioCasa;
    public int precioHotel;
    public int precio0;
    public int precio1;
    public int precio2;
    public int precio3;
    public int precio4;
    public int precio5;

    public Calles(String imagen, JPanel panel, String nombre, int precioCompra, int valorHipoteca, String color, int precioCasas, int precioHoteles, int precio0, int precio1, int precio2, int precio3, int precio4, int precio5) {
        super(imagen, panel, nombre, precioCompra, valorHipoteca);
        this.color = color;
        this.cantidadCasas = 0;
        this.cantidadHoteles = 0;
        this.cantidadEdificios = 0;
        this.precioCasa = precioCasas;
        this.precioHotel = precioHoteles;
        this.precio0 = precio0;
        this.precio1 = precio1;
        this.precio2 = precio2;
        this.precio3 = precio3;
        this.precio4 = precio4;
        this.precio5 = precio5;
        
    }
    
    @Override
    public int cobrar(){
        switch (cantidadEdificios) {
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

    public int getCantidadCasas() {
        return cantidadCasas;
    }

    public void setCantidadCasas(int cantidadCasas) {
        this.cantidadCasas = cantidadCasas;
    }

    public int getCantidadHoteles() {
        return cantidadHoteles;
    }

    public void setCantidadHoteles(int cantidadHoteles) {
        this.cantidadHoteles = cantidadHoteles;
    }

    public int getCantidadEdificios() {
        return cantidadEdificios;
    }

    public void setCantidadEdificios(int cantidadEdificios) {
        this.cantidadEdificios = cantidadEdificios;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrecioCasa() {
        return precioCasa;
    }

    public void setPrecioCasa(int precioCasa) {
        this.precioCasa = precioCasa;
    }

    public int getPrecioHotel() {
        return precioHotel;
    }

    public void setPrecioHotel(int precioHotel) {
        this.precioHotel = precioHotel;
    }

    public int getPrecio0() {
        return precio0;
    }

    public void setPrecio0(int precio0) {
        this.precio0 = precio0;
    }

    public int getPrecio1() {
        return precio1;
    }

    public void setPrecio1(int precio1) {
        this.precio1 = precio1;
    }

    public int getPrecio2() {
        return precio2;
    }

    public void setPrecio2(int precio2) {
        this.precio2 = precio2;
    }

    public int getPrecio3() {
        return precio3;
    }

    public void setPrecio3(int precio3) {
        this.precio3 = precio3;
    }

    public int getPrecio4() {
        return precio4;
    }

    public void setPrecio4(int precio4) {
        this.precio4 = precio4;
    }

    public int getPrecio5() {
        return precio5;
    }

    public void setPrecio5(int precio5) {
        this.precio5 = precio5;
    }
    
    
    
}
