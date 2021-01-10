/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartas;

import Cliente.ThreadCliente;
import Servidor.Banco;
import javax.swing.JPanel;

/**
 *
 * @author aleja
 */
public class ArcaComunal extends Cartas{
    public int funcion;
    public int monto;
    
    public ArcaComunal(String imagen, JPanel panel, String nombre, int funcion, int monto) {
        super(imagen, panel, nombre);
        this.funcion = funcion;
        this.monto = monto;
    }
    
    void funcionArca(Banco banco, ThreadCliente jugador){
        switch (funcion) {
            case 1:
                banco.darDinero(jugador, monto);
                break;
            case 2:
                banco.retirarDinero(jugador, monto);
                break;
            case 3:
                // Mover
                break;
            case 4:
                // Mover
                break;
            default:
                break;
        }
    }
    
}
