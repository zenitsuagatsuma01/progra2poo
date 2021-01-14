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
public abstract class Propiedades extends Cartas implements Serializable{
    public int precioCompra;
    public int valorHipoteca;
    public JPanel panel;
    public JLabel lblLibre;
    public JLabel lblAlquiler;
    public JLabel lblCasas;
    public JLabel lblHotel;
    public String dueno = "";
    public boolean comprada = false;
    public boolean hipotecada = false;
    public String color;
    public int cantidadCasas = 0;
    public int cantidadHoteles = 0;
    public int cantidadEdificios = 0;

    public Propiedades(String imagen, JPanel panel, String nombre, int precioCompra, int valorHipoteca, JLabel lblLibre, JLabel lblAlquiler, JLabel lblCasas, JLabel lblHotel, String color, int cantidadCasas, int cantidadHoteles, int cantidadEdificios) {
        super(imagen, panel, nombre);
        this.precioCompra = precioCompra;
        this.valorHipoteca = valorHipoteca;
        this.panel = panel;
        this.lblLibre = lblLibre;
        this.lblAlquiler = lblAlquiler;
        this.lblCasas = lblCasas;
        this.lblHotel = lblHotel;
        this.color = color;
        this.cantidadCasas = cantidadCasas;
        this.cantidadHoteles = cantidadHoteles;
        this.cantidadEdificios = cantidadEdificios;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
    
    

    public JLabel getLblCasas() {
        return lblCasas;
    }

    public void setLblCasas(JLabel lblCasas) {
        this.lblCasas = lblCasas;
    }

    public JLabel getLblHotel() {
        return lblHotel;
    }

    public void setLblHotel(JLabel lblHotel) {
        this.lblHotel = lblHotel;
    }

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public boolean isComprada() {
        return comprada;
    }

    public void setComprada(boolean comprada) {
        this.comprada = comprada;
    }

    public boolean isHipotecada() {
        return hipotecada;
    }

    public void setHipotecada(boolean hipotecada) {
        this.hipotecada = hipotecada;
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

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    
    
    public abstract int cobrar();
}