/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import com.sun.webkit.ThemeClient;
import java.io.DataOutput;
import static java.lang.Thread.sleep;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import Cliente.ThreadCliente;
import javax.swing.JOptionPane;
import java.lang.*;


public class Servidor{
    
    PantallaServidor refPantalla;
    public ArrayList<ThreadServidor> conexiones;
    private boolean running = true;
    private ServerSocket srv;
    private int turno = 0;
    private int limiteMin = 2;
    private int limiteMax = 6;
    private boolean partidaIniciada = false;
    private Banco banco;
    private ArrayList<ThreadCliente> jugadores;
    private boolean maximoAlcanzado = false;

    public Servidor(PantallaServidor refPantalla) {
        this.refPantalla = refPantalla;
        conexiones = new ArrayList<ThreadServidor>();
        this.refPantalla.setSrv(this);
    }

    public void iniciarPartida() {
        this.partidaIniciada = true;
    }
    
    public void stopserver(){
        running = false;
    }
    
    public String getNextTurno(){
        if ( ++turno >= conexiones.size())
            turno = 0;
        
        return conexiones.get(turno).nombre;
    }
    
    public String getTurno(){
        return conexiones.get(turno).nombre;
    }
    
    
    public void runServer(){
        int contadorDeConexiones = 0;
        String stringCantidad;
        int cantidadJugadores = 0;
        
        do{
           
            stringCantidad = JOptionPane.showInputDialog("Escriba la cantidad de jugadores que jugarán (Mínimo 2 y máximo 6): ");
        
        try{
            cantidadJugadores = Integer.parseInt(stringCantidad);
            
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "La cantidad debe ser un entero.");
        }
            
        } while (cantidadJugadores < 2 || cantidadJugadores > 6);

        limiteMax = cantidadJugadores;        
        
        try{
            srv = new ServerSocket(35577);
            while (running){
                if (contadorDeConexiones <= limiteMax && !maximoAlcanzado){
                    refPantalla.addMessage(":Esperando más jugadores...");
                    refPantalla.addMessage("El límite máximo de jugadores para esta partida es " + cantidadJugadores + ". Cantidad actual de jugadores: " + contadorDeConexiones);
                    
                }
                    
                Socket nuevaConexion = srv.accept();
                if (!partidaIniciada){
                    contadorDeConexiones++;

                    if (contadorDeConexiones > limiteMax){
                        refPantalla.addMessage("Conexión denegada: Límite máximo de jugadores alcanzado.");
                        //srv.close();
                        
                    }
                    
                    else if (contadorDeConexiones <= limiteMax){
                        
                        refPantalla.addMessage(":Conexión " + contadorDeConexiones + "aceptada");
                        
                        if (contadorDeConexiones == limiteMax){
                            
                            refPantalla.addMessage("El límite máximo de jugadores para esta partida es " + limiteMax + ". Cantidad actual de jugadores: " + contadorDeConexiones);
                            refPantalla.addMessage("Cantidad máxima de jugadores alcanzada. No se permitirán más conexiones.");
                            refPantalla.addMessage("Iniciando partida...");
                            maximoAlcanzado = true;
                            srv.close();
                        }
                            
                    

                    // nuevo thread
                        ThreadServidor newThread = new ThreadServidor(nuevaConexion, this);
                        conexiones.add(newThread);
                        newThread.start();
                    }
                    
                }
                else{
                    // OutputStream socket para poder hacer un writer
                    refPantalla.addMessage(":Conexión denegada: partida iniciada");
                }
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
}
