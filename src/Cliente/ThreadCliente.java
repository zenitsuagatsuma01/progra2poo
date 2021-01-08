/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Partida.FileManager;
import Servidor.Banco;
import Servidor.ThreadServidor;
import java.awt.Color;
import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.OverlayLayout;


public class ThreadCliente extends Thread implements Serializable{
    
    transient private Socket socketRef;
    transient public DataInputStream reader;
    transient public DataOutputStream writer;
    transient public ObjectOutputStream objWriter;
    private String nombre;
    private int dinero;
    private int numCasas;
    private int numHoteles;
    private int numPropiedades;
    private Ficha ficha;
    private Banco banco;
    //private ArrayList<Propiedad> propiedades;
    //private ArrayList<Casas> casas;
    //private ArrayList<Hotel> hoteles;
    protected boolean quebrado = false;
    private boolean running = true;
    transient public InterfazCliente refPantalla;
    private int numOrden = 1;
    private int totalRoll = 0;
    private int numJugador = 0;
    private boolean turnoConseguido = false;

    public ThreadCliente(Socket socketRef, InterfazCliente refPantalla) throws IOException {
        this.socketRef = socketRef;
        reader = new DataInputStream(socketRef.getInputStream());
        writer = new DataOutputStream(socketRef.getOutputStream());
        objWriter = new ObjectOutputStream(socketRef.getOutputStream());
        this.refPantalla = refPantalla;
        numCasas = 0;
        numHoteles = 0;
        numPropiedades = 0;
        banco = new Banco();
    }
    
    public ThreadCliente(Socket socketRef, InterfazCliente refPantalla, String nombreCargado, int dineroCargado, int numCasasCargado, int numHotelesCargado, int numPropiedadesCargado, boolean quebradoCargado) throws IOException {
        this.socketRef = socketRef;
        reader = new DataInputStream(socketRef.getInputStream());
        writer = new DataOutputStream(socketRef.getOutputStream());
        objWriter = new ObjectOutputStream(socketRef.getOutputStream());
        this.refPantalla = refPantalla;
        nombre = nombreCargado;
        dinero = dineroCargado;
        numCasas = numCasasCargado;
        numHoteles = numHotelesCargado;
        numPropiedades = numPropiedadesCargado;
        quebrado = quebradoCargado;
    }

    public int getTotalRoll() {
        return totalRoll;
    }

    public void setTotalRoll(int totalRoll) {
        this.totalRoll = totalRoll;
    }

    public int getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(int numOrden) {
        this.numOrden = numOrden;
    }

    public Banco getBanco() {
        return banco;
    }

    public boolean isTurnoConseguido() {
        return turnoConseguido;
    }

    public void setTurnoConseguido(boolean turnoConseguido) {
        this.turnoConseguido = turnoConseguido;
    }
    
    

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public int getNumJugador() {
        return numJugador;
    }

    public void setNumJugador(int numJugador) {
        this.numJugador = numJugador;
    }
    
    
    
    public void solicitarPropiedad(){ // Parametro debería en realidad ser un objeto tipo Propiedad pero la clase no existe todavía
        
    }
    
    public void solicitarCasa(){ // Parametro debería ser un objeto tipo Casa
        
    }
    
    public void solicitarHotel(){ // Parametro debería ser un objeto tipo Hotel
        
    }
    
    public void actuarCarta(){      // Para reaccionar ante las diferentes cartas del juego
        
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
    
    
    
    public void run (){
        
        int instruccionId = 1;
        while (running){
            try {
                String usuario = "";
                instruccionId = reader.readInt(); // esperar hasta que reciba un entero
                
                switch (instruccionId){
                    case 1: // recibe el turno del jufador 1
                        refPantalla.setNombreTurno(reader.readUTF());
                    break;
                    case 2: // pasan un mensaje por el chat
                        usuario = reader.readUTF();
                        String mensaje = reader.readUTF();
                        //System.out.println("CLIENTE Recibido mensaje: " + mensaje);
                        refPantalla.addMensaje(usuario+ ":   " + mensaje);
                    break;
                    case 3: // pasan un mensaje por el chat
                        usuario = reader.readUTF();
                        int dado1 = reader.readInt();
                        int dado2 = reader.readInt();
                        String turno = reader.readUTF();
                        
                        refPantalla.pintarLanzamientoDados(dado1, dado2, usuario);
                        refPantalla.addMensaje(usuario+">  Lanzamiento de dados (" + dado1 + ", " + dado2 + ")");
                        refPantalla.pintarTurno(turno);
                    break;                    
                    case 4: // Se inicia la partida
                        refPantalla.setInicioPartida();
                        
                        //refPantalla.seleccionFicha();
                    break;
                    case 5: // se guardan los datos de cada jugador
                        String nombreJugador = this.getRefPantalla().getNombreJugador();
                        FileManager.writeObject(this,"src/Partida/partida" + nombreJugador + ".dat");
                    break;
                    case 6:
                        ArrayList<Ficha> listaFichas = (ArrayList<Ficha>)FileManager.readObject("src/Partida/listafichas.dat");
                        
                        for (int i = 0; i < listaFichas.size(); i++){
                            
                            Ficha newFicha = listaFichas.get(i);
                            System.out.println(newFicha.getLabelFicha());
                            System.out.println(newFicha.getLabelFicha().getIcon());
                            this.getRefPantalla().getLblGo1().add(newFicha.getLabelFicha());
                            refPantalla.getLblGo1().revalidate();
                            refPantalla.getLblGo1().repaint();

                        }
                        
                        
                        break;
                    case 7:
                        mensaje = reader.readUTF();
                        refPantalla.getTxaHistorial().append(mensaje + '\n');
                        break;
                    case 8:
                        int cantidadDinero = reader.readInt();
                        this.banco.darDinero(this, cantidadDinero);
                        this.refPantalla.getLblNumDinero().setText(this.getDinero() + " $");
                        break;
                    case 9:
                        int decidido = reader.readInt();
                        
                        if (decidido == 1){
                            System.out.println(decidido);
                            ArrayList<Integer> listaOrden = (ArrayList<Integer>)FileManager.readObject("src/Partida/listadados2.dat");
                            ArrayList<String> nombresOrden = (ArrayList<String>)FileManager.readObject("src/Partida/nombresorden.dat");
                            ArrayList<String> listaNombres = (ArrayList<String>)FileManager.readObject("src/Partida/listanombres.dat");
                            System.out.println(this.getTotalRoll());
                            System.out.println(this.getNombre());

                            
                            nombresOrden = (ArrayList<String>)FileManager.readObject("src/Partida/nombresorden.dat");
                            System.out.println(nombresOrden);
                            this.refPantalla.getTxaHistorial().append("El orden ha sido decidido. El orden será:\n");
                            int contPos = 1;
                            for (int i = 0; i < nombresOrden.size(); i++){
                                this.refPantalla.getTxaHistorial().append(contPos + ". " + nombresOrden.get(i) + "\n");
                                contPos = contPos + 1;
                            }
                            this.writer.writeInt(10);
                        }
                        else if (decidido == 0){
                            this.refPantalla.getTxaHistorial().append("Por favor vuelva a lanzar los dados.\n");
                        }
                        
                        
                        
                        break;
                    case 10:
                        refPantalla.setFinalPartida();
                        break;
                    case 11:
                        refPantalla.setNombreTurno(reader.readUTF());
                    break;
                }
            } catch (IOException ex) {
                
            }
        }
    }

    public int getNumCasas() {
        return numCasas;
    }

    public void setNumCasas(int numCasas) {
        this.numCasas = numCasas;
    }

    public int getNumHoteles() {
        return numHoteles;
    }

    public void setNumHoteles(int numHoteles) {
        this.numHoteles = numHoteles;
    }

    public int getNumPropiedades() {
        return numPropiedades;
    }

    public void setNumPropiedades(int numPropiedades) {
        this.numPropiedades = numPropiedades;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public boolean isQuebrado() {
        return quebrado;
    }

    public void setQuebrado(boolean quebrado) {
        this.quebrado = quebrado;
    }

    public DataInputStream getReader() {
        return reader;
    }

    public void setReader(DataInputStream reader) {
        this.reader = reader;
    }

    public DataOutputStream getWriter() {
        return writer;
    }

    public void setWriter(DataOutputStream writer) {
        this.writer = writer;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public InterfazCliente getRefPantalla() {
        return refPantalla;
    }

    public void setRefPantalla(InterfazCliente refPantalla) {
        this.refPantalla = refPantalla;
    }
    
    
}
