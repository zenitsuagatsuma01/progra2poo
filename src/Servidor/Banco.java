/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Cliente.ThreadCliente;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author aleja
 */
public class Banco implements Serializable{
    
    private ArrayList<ThreadCliente> enQuiebra;
    // El banco tiene dinero ilimitado

    public Banco() {
        this.enQuiebra = new ArrayList<ThreadCliente>();
    }
    
    
    
    public void darDinero(ThreadCliente jugador, int dineroDado){           // Se agrega la cantidad pedida al dinero del jugador solicitado
        
        int dineroViejo = jugador.getDinero();
        int dineroNuevo = dineroViejo + dineroDado;
        jugador.setDinero(dineroNuevo);
        
    }
    
    public void retirarDinero(ThreadCliente jugador, int dineroRetirado){       // Se retira la cantidad pedida de dinero al jugador solicitado
        
        int dineroViejo = jugador.getDinero();
        int dineroNuevo = dineroViejo - dineroRetirado;
        jugador.setDinero(dineroViejo - dineroRetirado);
        
        if (dineroNuevo <= 0){
            enQuiebra.add(jugador);
        }
        
    }
    
    
    public int consultarDinero(ThreadCliente jugador){              // Se retorna la cantidad de dinero del jugador solicitado
        
        int dineroJugador = jugador.getDinero();
        
        return dineroJugador;
        
    }
    
}
