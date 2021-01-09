/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import cartas.Cartas;
import java.util.ArrayList;

/**
 *
 * @author aleja
 */
public class Tablero {
    private ArrayList<Cartas> casillas;

    public Tablero(ArrayList<Cartas> casillas) {
        this.casillas = casillas;
    }

    public Tablero() {
    }
    
    

    public ArrayList<Cartas> getCasillas() {
        return casillas;
    }

    public void setCasillas(ArrayList<Cartas> casillas) {
        this.casillas = casillas;
    }
    
    
}
