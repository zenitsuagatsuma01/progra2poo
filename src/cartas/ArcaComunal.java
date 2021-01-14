/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartas;

import Cliente.ThreadCliente;
import Servidor.Banco;
import java.io.IOException;
import javax.swing.JPanel;

/**
 *
 * @author aleja
 */
public class ArcaComunal extends Cartas{
    public int funcion;
    public int monto;
    public int indiceCasillaDestino;
    public String efecto;
    public Banco banco;
    
    public ArcaComunal(String imagen, JPanel panel, String nombre, int funcion, int monto, int indiceCasillaDestino, String efecto) {
        super(imagen, panel, nombre);
        this.funcion = funcion;
        this.monto = monto;
        this.indiceCasillaDestino = indiceCasillaDestino;
        this.efecto = efecto;
        this.banco = new Banco();
    }

    public int getFuncion() {
        return funcion;
    }

    public void setFuncion(int funcion) {
        this.funcion = funcion;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getIndiceCasillaDestino() {
        return indiceCasillaDestino;
    }

    public void setIndiceCasillaDestino(int indiceCasillaDestino) {
        this.indiceCasillaDestino = indiceCasillaDestino;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }
    
    
    
    public void funcionArca(Banco banco, ThreadCliente jugador) throws IOException{
        switch (funcion) {
            case 1:
                banco.darDinero(jugador, monto); // solo recibir dinero
                jugador.mandarMensaje(efecto);
                break;
            case 2:
                banco.retirarDinero(jugador, monto); // solo pagar dinero
                jugador.mandarMensaje(efecto);
                break;
            case 3:
                jugador.moverFicha(indiceCasillaDestino); // solo moverse
                jugador.mandarMensaje(efecto);
                break;
            case 4:
                jugador.moverFicha(indiceCasillaDestino); // moverse y recibir dinero
                banco.darDinero(jugador, monto);
                jugador.mandarMensaje(efecto);
                break;
            case 5:
                jugador.setGetOutOfJailFree(true); // get out of jail free
                jugador.mandarMensaje(efecto);
                break;
            default:
                break;
        }
    }
    
}
