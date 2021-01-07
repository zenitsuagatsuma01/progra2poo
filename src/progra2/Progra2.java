/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra2;

import Cliente.Ficha;
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
        
        ArrayList<Ficha> fichasPartida = new ArrayList<Ficha>();
        FileManager.writeObject(fichasPartida, "src/Partida/listafichas.dat");
        MenuPrincipal menu = new MenuPrincipal();
        menu.pack();
        menu.setVisible(true);
        menu.setTitle("Menu Principal Pokenopoly");
    }
    
}
