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
        
        try{
            srv = new ServerSocket(35577);
            while (running){
                refPantalla.addMessage("::Esperando conexión ...");
                refPantalla.addMessage("El límite máximo de jugadores es 6. Cantidad actual de jugadores: " + contadorDeConexiones);
                Socket nuevaConexion = srv.accept();
                if (!partidaIniciada){
                    contadorDeConexiones++;
                    
                    if (contadorDeConexiones > limiteMax){
                        refPantalla.addMessage("Conexión denegada: Límite máximo de jugadores alcanzado.");
                        srv.close();
                    }
                    else{
                        refPantalla.addMessage(":Conexión " + contadorDeConexiones + "aceptada");

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
