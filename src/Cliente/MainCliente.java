/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Servidor.PantallaServidor;
import Servidor.Servidor;
import java.io.IOException;
import javax.swing.JOptionPane;


public class MainCliente {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {            // Para inicializar el cliente
        String nombre = JOptionPane.showInputDialog("Escriba su nombre:");
        try{
        InterfazCliente pantalla = new InterfazCliente();
        Cliente c = new Cliente(pantalla);
        pantalla.setVisible(true); 
        c.conectar(nombre);
               
        }
        catch(Exception e){
            
        }
    }
    
}
