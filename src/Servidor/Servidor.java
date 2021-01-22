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
import Partida.FileManager;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.JOptionPane;
import java.lang.*;


public class Servidor extends Thread implements Serializable{
    
    PantallaServidor refPantalla;
    public ArrayList<ThreadServidor> conexiones;            // Las conexiones de los jugadores de la partida al servidor
    private boolean running = true;
    transient private ServerSocket srv;
    private int turno = 0;                                  // Numero de turno de la partida
    private int limiteMax;                                  // Limite maximo de jugadores
    private boolean partidaIniciada = false;
    private Banco banco;
    private boolean maximoAlcanzado = false;                // Si se ha o no alcanzado el limite maximo de jugadores de la partida
    public boolean flagCargado = false;
    public Servidor partidaGuardada;
    private int contFichas = 0;
    private boolean turnosDecididos = false;
    private int numTirado = 0;
    private ArrayList<String> nombreOrder;
    private ArrayList<String> listaPerdedores;
    private int totalCasas = 32;
    private int totalHoteles = 12;
    private int contadorPerdedor = 0;

    public Servidor(PantallaServidor refPantalla) {
        this.refPantalla = refPantalla;
        conexiones = new ArrayList<ThreadServidor>();
        this.refPantalla.setSrv(this);
        this.nombreOrder = new ArrayList<String>();
        this.listaPerdedores = new ArrayList<String>();
    }
    
    public Servidor(PantallaServidor refPantalla, int turnoCargado, int limiteMaxCargado, Banco bancoCargado, Servidor servidorCargado) {
        this.refPantalla = refPantalla;
        conexiones = new ArrayList<ThreadServidor>();
        this.refPantalla.setSrv(this);
        turno = turnoCargado;
        limiteMax = limiteMaxCargado;
        banco = bancoCargado;
        flagCargado = true;
        partidaGuardada = servidorCargado;
    }

    public int getContadorPerdedor() {
        return contadorPerdedor;
    }

    public void setContadorPerdedor(int contadorPerdedor) {
        this.contadorPerdedor = contadorPerdedor;
    }
    
    

    public ArrayList<String> getListaPerdedores() {
        return listaPerdedores;
    }

    public void setListaPerdedores(ArrayList<String> listaPerdedores) {
        this.listaPerdedores = listaPerdedores;
    }
    
    

    public int getContFichas() {
        return contFichas;
    }

    public void setContFichas(int contFichas) {
        this.contFichas = contFichas;
    }

    public boolean isTurnosDecididos() {
        return turnosDecididos;
    }

    public void setTurnosDecididos(boolean turnosDecididos) {
        this.turnosDecididos = turnosDecididos;
    }

    public int getNumTirado() {
        return numTirado;
    }

    public void setNumTirado(int numTirado) {
        this.numTirado = numTirado;
    }

    public ArrayList<String> getNombreOrder() {
        return nombreOrder;
    }

    public void setNombreOrder(ArrayList<String> nombreOrder) {
        this.nombreOrder = nombreOrder;
    }

    public int getTotalCasas() {
        return totalCasas;
    }

    public void setTotalCasas(int cantCasas) {
        this.totalCasas = cantCasas;
    }
    
    public int getTotalHoteles() {
        return totalHoteles;
    }

    public void setTotalHoteles(int cantHoteles) {
        this.totalHoteles = cantHoteles;
    }
    
    
    public void iniciarPartida() {          // Se empieza la partida
        this.partidaIniciada = true;
        refPantalla.addMessage("-Partida iniciada.");
        refPantalla.addMessage("-Cada jugador debe lanzar los dados para determinar el orden de los turnos.");
    }
    
    public void guardarPartida() throws IOException {          // Para guardar la partida actual con serializable
        
        for (int i = 0; i < conexiones.size(); i++) {
            ThreadServidor current = conexiones.get(i);
            current.writer.writeInt(5);
        }
    }
    
    public void signalIniciarPartida() throws IOException{
        this.partidaIniciada = true;
        refPantalla.addMessage("-Partida iniciada.");
        refPantalla.addMessage("-Cada jugador debe seleccionar una ficha y luego lanzar los dados para decidir el orden.");
        
        for (int i = 0; i < conexiones.size(); i++) {
            ThreadServidor current = conexiones.get(i);
            current.writer.writeInt(4);
        }
        
        for (int i = 0; i < conexiones.size(); i++) {
            ThreadServidor current = conexiones.get(i);
            current.writer.writeInt(7);
            current.writer.writeUTF("Por favor, seleccione una ficha.");
        }
        
        for (int i = 0; i < conexiones.size(); i++) {
            ThreadServidor current = conexiones.get(i);
            current.writer.writeInt(8);
            current.writer.writeInt(1500);
        }
    }
    
    public void cargarPartida(){            // Carga la partida con serializable
        FileManager.readObject("src/Partida/partida.dat");
        refPantalla.addMessage("-Partida cargada correctamente.");
    }
    
    public void signalTerminarPartida() throws IOException{
        for (int i = 0; i < conexiones.size(); i++) {
            ThreadServidor current = conexiones.get(i);
            current.writer.writeInt(23);
        }
    }
    
    public void enviarTurnoInicial() throws IOException{            // Manda el turno inicial

        for (int i = 0; i < conexiones.size(); i++){
            ThreadServidor current = conexiones.get(i);
            current.writer.writeInt(11);
            current.writer.writeUTF(nombreOrder.get(0));
        }
        
        return;
    }
    
    public void proximoTurno(String turnoActual) throws IOException{
        String nombreTurno = "";
        System.out.println("El turnoActual de proximoTurno al comienzo es " + turnoActual);
        for (int i = 0; i < nombreOrder.size(); i++) {
            if (turnoActual.contains(nombreOrder.get(i))){
                if (i + 1 >= nombreOrder.size()){
                    nombreTurno = nombreOrder.get(0);
                    break;
                }
                else
                    nombreTurno = nombreOrder.get(i+1);
            }
            if (this.getListaPerdedores().contains(turnoActual)){
                
                for (int x = 0; x < this.getNombreOrder().size(); x++){
                    if (this.getNombreOrder().get(x).equalsIgnoreCase(turnoActual)){
                        this.getNombreOrder().remove(this.getNombreOrder().get(x));
                        try {
                            nombreTurno = this.getNombreOrder().get(x);
                        }
                        catch(IndexOutOfBoundsException e){
                            
                        }
                        
                    }
                }
                
            }
        }
        
        if (this.nombreOrder.size() == 1){
            //ArrayList<String> logLeida = (ArrayList<String>)FileManager.readObject("src/Archivos/log.dat");
            this.enviarMensaje("El jugador " + nombreOrder.get(0) + " ha ganado la partida!");
            this.signalTerminarPartida();
            //logLeida.add("El jugador " + nombreOrder.get(0) + " ha ganado la partida!\n");
            //FileManager.writeObject(logLeida, "src/Archivos/log.dat");
            return;
        }
        
        if (nombreTurno.equalsIgnoreCase("")){
            nombreTurno = nombreOrder.get(0);
            System.out.println("Turno estaba vacio");
        }
        
        System.out.println("El nuevo turno de proximoTurno es " + nombreTurno);
        System.out.println("La lista de perdedores del servidor es " + this.getListaPerdedores());
        if (this.getListaPerdedores().contains(nombreTurno)){
            for (int i = 0; i < nombreOrder.size(); i++) {
            if (nombreTurno.equals(nombreOrder.get(i))){
                nombreOrder.remove(nombreOrder.get(i));
                if (i + 1 >= nombreOrder.size()){
                    nombreTurno = nombreOrder.get(0);
                    break;
                }
                else
                    nombreTurno = nombreOrder.get(i+1);
            }
        }
            System.out.println(nombreTurno);
        }
        
        for (int i = 0; i < conexiones.size(); i++) {
            ThreadServidor current = conexiones.get(i);
            current.writer.writeInt(11);
            current.writer.writeUTF(nombreTurno);
        }
    }
    
    public void stopserver(){
        running = false;
    }
    
    public String getNextTurno(){               // Retorna el nombre del jugador que va siguiente
        if ( ++turno >= conexiones.size())
            turno = 0;
        
        return conexiones.get(turno).nombre;
    }
    
    public String getTurno(){                   // Retorna el nombre del jugador cuyo turno es actualmente
        return conexiones.get(turno).nombre;
    }
    
    public void enviarMensaje(String msg) throws IOException{
        for (int i = 0; i < conexiones.size(); i++) {
            ThreadServidor current = conexiones.get(i);
            current.writer.writeInt(7);
            current.writer.writeUTF(msg);
        }
    }
    
    public void run(){
        int contadorDeConexiones = 0;
        String stringCantidad;
        int cantidadJugadores = 0;                      // Primero se pide la cantidad maxima de jugadores que van a participar, de 2 minimo a 6 maximo
        
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

        this.setLimiteMax(cantidadJugadores);               // Este será el limite maximo de la cantidad de jugadores de la partida
        
        try{
            srv = new ServerSocket(35577);
            while (running){
                if (contadorDeConexiones <= this.getLimiteMax() && this.isMaximoAlcanzado() == false){          // Mientras no se ha llegado al límmite maximo, se aceptan conexiones nuevas
                    refPantalla.addMessage("-Esperando más jugadores...");
                    refPantalla.addMessage("-El límite máximo de jugadores para esta partida es " + cantidadJugadores + ". Cantidad actual de jugadores: " + contadorDeConexiones);
                    
                }
                    
                Socket nuevaConexion = srv.accept();
                if (!partidaIniciada){              // Mientras no se empezado la partida, se aceptan conexiones nuevas
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
                        
                        if (contadorDeConexiones == this.getLimiteMax()){           // Al llegar al límite máximo de jugadores, se para de aceptar nuevas conexiones y se empiza la partida
                            
                            refPantalla.addMessage("-El límite máximo de jugadores para esta partida es " + limiteMax + ". Cantidad actual de jugadores: " + contadorDeConexiones);
                            refPantalla.addMessage("-Cantidad máxima de jugadores alcanzada. No se permitirán más conexiones.");
                            refPantalla.addMessage("-Iniciando partida...");
                            ArrayList<Integer> numeroJugadores = new ArrayList<Integer>();
                            numeroJugadores.add(limiteMax);
                            FileManager.writeObject(numeroJugadores, "src/Partida/numerojugadores.dat");
                            System.out.println(numeroJugadores.get(0));
                            this.setMaximoAlcanzado(true);
                            srv.close();
                            this.signalIniciarPartida();

                        }
                    
                }
                else{
                    // OutputStream socket para poder hacer un writer
                    refPantalla.addMessage("-Conexión denegada: partida iniciada");
                    
                }
                
                if (partidaIniciada){
                    
                }
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public PantallaServidor getRefPantalla() {
        return refPantalla;
    }

    public void setRefPantalla(PantallaServidor refPantalla) {
        this.refPantalla = refPantalla;
    }

    public boolean isFlagCargado() {
        return flagCargado;
    }

    public void setFlagCargado(boolean flagCargado) {
        this.flagCargado = flagCargado;
    }

    public ArrayList<ThreadServidor> getConexiones() {
        return conexiones;
    }

    public void setConexiones(ArrayList<ThreadServidor> conexiones) {
        this.conexiones = conexiones;
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
    
    public int getNumTurno(){
        return turno;
    }
    
}
