/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Cliente.ThreadCliente;
import java.util.ArrayList;

/**
 *
 * @author aleja
 */
public class Banco {
    
    private ThreadCliente jugadorActual;
    private ArrayList<ThreadCliente> jugadores;
    private ArrayList<ThreadCliente> enQuiebra;
    // El banco tiene dinero ilimitado
    
    public void darDinero(ThreadCliente jugador, int dineroDado){
        
        int dineroViejo = jugador.getDinero();
        jugador.setDinero(dineroViejo + dineroDado);
        
    }
    
    public void retirarDinero(ThreadCliente jugador, int dineroRetirado){
        
        int dineroViejo = jugador.getDinero();
        jugador.setDinero(dineroViejo - dineroRetirado);
        
    }
    
    public void consultarDinero(ThreadCliente jugador){
        
        int dineroJugador = jugador.getDinero();
        
    }
    
}
