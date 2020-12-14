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
    private int limiteMax;
    private boolean partidaIniciada = false;
    private Banco banco;
    private boolean maximoAlcanzado = false;

    public Servidor(PantallaServidor refPantalla) {
        this.refPantalla = refPantalla;
        conexiones = new ArrayList<ThreadServidor>();
        this.refPantalla.setSrv(this);
    }

    public void iniciarPartida() {
        this.partidaIniciada = true;
        refPantalla.addMessage("-Partida iniciada.");
        refPantalla.addMessage("-Cada jugador debe lanzar los dados para determinar el orden de los turnos.");
    }
    
    public void guardarPartida() {
        
    }
    
    public void cargarPartida(){
        
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
           
            stringCantidad = JOptionPane.showInputDialog("Escriba la cantidad de jugadores de la partida (Mínimo 2 y máximo 6): ");
        
        try{
            cantidadJugadores = Integer.parseInt(stringCantidad);
            
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "La cantidad debe ser un entero.");
        }
        
        if (cantidadJugadores < 2)
            JOptionPane.showMessageDialog(null, "La cantidad mínima de jugadores es 2.");
        
        else if (cantidadJugadores > 6)
            JOptionPane.showMessageDialog(null, "La cantidad máxima de jugadores es 6.");
            
        } while (cantidadJugadores < 2 || cantidadJugadores > 6);

        this.setLimiteMax(cantidadJugadores);   
        
        try{
            srv = new ServerSocket(35577);
            while (running){
                if (contadorDeConexiones <= this.getLimiteMax() && this.isMaximoAlcanzado() == false){
                    refPantalla.addMessage("-Esperando más jugadores...");
                    refPantalla.addMessage("-El límite máximo de jugadores para esta partida es " + cantidadJugadores + ". Cantidad actual de jugadores: " + contadorDeConexiones);
                    
                }
                    
                Socket nuevaConexion = srv.accept();
                if (!partidaIniciada){
                    contadorDeConexiones++;

                    if (contadorDeConexiones > this.getLimiteMax()){
                        refPantalla.addMessage("-Conexión denegada: Límite máximo de jugadores alcanzado.");
                        
                        
                    }
                    
                    else if (contadorDeConexiones <= this.getLimiteMax()){
                        
                        refPantalla.addMessage("-Conexión " + contadorDeConexiones + " aceptada.");
                        
                        // nuevo thread
                        ThreadServidor newThread = new ThreadServidor(nuevaConexion, this);
                        conexiones.add(newThread);
                        newThread.start();

                    }
                        
                        if (contadorDeConexiones == this.getLimiteMax()){
                            
                            refPantalla.addMessage("-El límite máximo de jugadores para esta partida es " + limiteMax + ". Cantidad actual de jugadores: " + contadorDeConexiones);
                            refPantalla.addMessage("-Cantidad máxima de jugadores alcanzada. No se permitirán más conexiones.");
                            refPantalla.addMessage("-Iniciando partida...");
                            this.setMaximoAlcanzado(true);
                            srv.close();
                            
                            for (int i = 0; i < conexiones.size(); i++) {
                            ThreadServidor current = conexiones.get(i);
                            current.writer.writeInt(4);
                            }
                            
                        }
                    
                }
                else{
                    // OutputStream socket para poder hacer un writer
                    refPantalla.addMessage("-Conexión denegada: partida iniciada");
                    
                }
                
                while (partidaIniciada){
                    
                }
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public int getLimiteMax() {
        return limiteMax;
    }

    public void setLimiteMax(int limiteMax) {
        this.limiteMax = limiteMax;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public boolean isMaximoAlcanzado() {
        return maximoAlcanzado;
    }

    public void setMaximoAlcanzado(boolean maximoAlcanzado) {
        this.maximoAlcanzado = maximoAlcanzado;
    }

    public boolean isPartidaIniciada() {
        return partidaIniciada;
    }

    public void setPartidaIniciada(boolean partidaIniciada) {
        this.partidaIniciada = partidaIniciada;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
}
