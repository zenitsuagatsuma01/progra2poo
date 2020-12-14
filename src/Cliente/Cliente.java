/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;


public class Cliente {
    
    Socket socketRef;
    InterfazCliente refPantalla;
    public ThreadCliente hiloCliente;

    public Cliente(InterfazCliente refPantalla) {
        this.refPantalla = refPantalla;
        refPantalla.setRefCliente(this);
    }
    
    public void conectar(){
 
        try{
        
            socketRef = new Socket("localhost", 35577);
            hiloCliente = new ThreadCliente(socketRef, refPantalla);
            hiloCliente.start();
            String nombre = JOptionPane.showInputDialog("Escriba su nombre:");
            refPantalla.setTitle("Monopoly - Nombre del jugador: " + nombre);
            refPantalla.setNombreJugador("Su nombre es: " + nombre);
            hiloCliente.writer.writeInt(1); //instruccion para el switch del thraed servidor
            hiloCliente.writer.writeUTF(nombre); //instruccion para el switch del thraed servidor
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
        
    }

    public InterfazCliente getRefPantalla() {
        return refPantalla;
    }

    public void setRefPantalla(InterfazCliente refPantalla) {
        this.refPantalla = refPantalla;
    }

    public ThreadCliente getHiloCliente() {
        return hiloCliente;
    }

    public void setHiloCliente(ThreadCliente hiloCliente) {
        this.hiloCliente = hiloCliente;
    }
    
    
}
