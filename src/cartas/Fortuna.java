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
public class Fortuna extends Cartas{
    public int funcion;
    public int monto;
    public int indiceCasillaDestino;
    public String efecto;
    public Banco banco;
    
    public Fortuna(String imagen, JPanel panel, String nombre ,int funcion, int monto, int indiceCasillaDestino, String efecto) {
        super(imagen, panel, nombre);
        this.funcion = funcion;
        this.monto = monto;
        this.indiceCasillaDestino = indiceCasillaDestino;
        this.efecto = efecto;
        this.banco = new Banco();
    }
    
    public void funcionFortuna(Banco banco, ThreadCliente jugador) throws IOException{
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
                jugador.mandarMensaje(efecto);
                jugador.moverFicha(indiceCasillaDestino,1); // solo moverse
                
                break;
            case 4:
                jugador.mandarMensaje(efecto);
                jugador.moverFicha(indiceCasillaDestino,0); // moverse y recibir dinero
                
                break;
            case 5:
                jugador.setGetOutOfJailFree(true); // get out of jail free
                jugador.getRefPantalla().getLblGetOutOfJailFree().setText("Si tiene");
                jugador.mandarMensaje(efecto);
                break;
            case 6:
                jugador.mandarMensaje(efecto); // moverse 3 para atras (flag es 2)
                jugador.moverFicha(indiceCasillaDestino,2);
                break;
            case 7:
                jugador.mandarMensaje(efecto);
                jugador.moverFicha(indiceCasillaDestino,3); // moverse y recibir dinero y pagar el doble de alquiler en el ferrocarril mas cercano (flag es 3)
                
                break;
            default:
                break;
        }
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

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
    
    
}
