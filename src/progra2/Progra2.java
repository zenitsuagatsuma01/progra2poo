/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra2;

import Cliente.Cliente;
import Cliente.Ficha;
import Cliente.InterfazCliente;
import Partida.FileManager;
import Partida.MenuPrincipal;
import Servidor.PantallaServidor;
import Servidor.Servidor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author aleja
 */
public class Progra2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Progra2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Progra2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Progra2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Progra2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean turnosDecididos = false;
        FileManager.writeObject(turnosDecididos, "src/Partida/turnosdecididos.dat");
                
        ArrayList<Ficha> fichasPartida = new ArrayList<Ficha>();
        FileManager.writeObject(fichasPartida, "src/Partida/listafichas.dat");
        ArrayList<String> nombreOrden = new ArrayList<String>();
        FileManager.writeObject(nombreOrden, "src/Partida/nombresorden.dat");
        ArrayList<Integer> listaDados = new ArrayList<Integer>();
        FileManager.writeObject(listaDados, "src/Partida/listadados.dat");
        ArrayList<Integer> listaDados2 = new ArrayList<Integer>();
        FileManager.writeObject(listaDados2, "src/Partida/listadados2.dat");
        Integer numJugador = 0;
        FileManager.writeObject(numJugador, "src/Partida/numjugador.dat");
        ArrayList<String> nombresOrden = new ArrayList<String>();
        FileManager.writeObject(nombresOrden, "src/Partida/nombresorden.dat");
        ArrayList<String> listaNombres = new ArrayList<String>();
        FileManager.writeObject(listaNombres, "src/Partida/listanombres.dat");
        
        try{
        InterfazCliente pantalla = new InterfazCliente();
        Cliente c = new Cliente(pantalla);
        pantalla.pack();
        pantalla.setVisible(true); 
               
        }
        catch(Exception e){
            
        }
    }
    
}
