/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Partida.FileManager;
import Servidor.Banco;
import Servidor.ThreadServidor;
import cartas.ArcaComunal;
import cartas.Calles;
import cartas.Cartas;
import cartas.Ferrocarriles;
import cartas.Fortuna;
import cartas.Propiedades;
import cartas.Servicios;
import java.awt.Color;
import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private ArrayList<Propiedades> propiedades;
    protected boolean quebrado = false;
    private boolean running = true;
    transient public InterfazCliente refPantalla;
    private int numOrden = 1;
    private int totalRoll = 0;
    private int numJugador = 0;
    private boolean turnoConseguido = false;
    private Tablero tablero;
    private boolean vueltaDada = false;
    private String nombreConsultar;
    private int contadorConsultar = 0;
    private int cantidadFerrocarriles = 0;
    private int cantidadServicios = 0;
    private int contadorVerde = 0;
    private int contadorRojo = 0;
    private int contadorRojoOscuro = 0;
    private int contadorAzul = 0;
    private int contadorCeleste = 0;
    private int contadorRosado = 0;
    private int contadorNaranja = 0;
    private int contadorAmarillo = 0;
    private boolean getOutOfJailFree = false;
    private int contadorCasas = 0;
    private int contadorHoteles = 0;
    private int contadorArcaComunal = 0;
    private int contadorFortuna = 0;

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
        tablero = new Tablero();
        propiedades = new ArrayList<Propiedades>();
        nombreConsultar = "";
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
    
    public void moverFicha(int casillaDestino, int arcaJail) throws IOException{
            // TODO add your handling code here:
            String nombreFicha = this.getFicha().getNombre();
            int posFicha = this.getFicha().getPosicionActual();
            
            this.getWriter().writeInt(11);
            this.getWriter().writeInt(casillaDestino);
            this.getWriter().writeUTF(nombreFicha);
            this.getWriter().writeInt(posFicha);
            this.getWriter().writeInt(arcaJail);

    }
    
    public void mandarMensaje(String msg){
        try {
            // TODO add your handling code here:
            this.writer.writeInt(7);
            this.writer.writeUTF(msg);
        } catch (IOException ex) {
            Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isGetOutOfJailFree() {
        return getOutOfJailFree;
    }

    public void setGetOutOfJailFree(boolean getOutOfJailFree) {
        this.getOutOfJailFree = getOutOfJailFree;
    }
    
    

    public int getContadorConsultar() {
        return contadorConsultar;
    }

    public void setContadorConsultar(int contadorConsultar) {
        this.contadorConsultar = contadorConsultar;
    }

    public int getCantidadFerrocarriles() {
        return cantidadFerrocarriles;
    }

    public void setCantidadFerrocarriles(int cantidadFerrocarriles) {
        this.cantidadFerrocarriles = cantidadFerrocarriles;
    }

    public int getCantidadServicios() {
        return cantidadServicios;
    }

    public void setCantidadServicios(int cantidadServicios) {
        this.cantidadServicios = cantidadServicios;
    }

    public int getContadorVerde() {
        return contadorVerde;
    }

    public void setContadorVerde(int contadorVerde) {
        this.contadorVerde = contadorVerde;
    }

    public int getContadorRojo() {
        return contadorRojo;
    }

    public void setContadorRojo(int contadorRojo) {
        this.contadorRojo = contadorRojo;
    }

    public int getContadorRojoOscuro() {
        return contadorRojoOscuro;
    }

    public void setContadorRojoOscuro(int contadorRojoOscuro) {
        this.contadorRojoOscuro = contadorRojoOscuro;
    }

    public int getContadorAzul() {
        return contadorAzul;
    }

    public void setContadorAzul(int contadorAzul) {
        this.contadorAzul = contadorAzul;
    }

    public int getContadorCeleste() {
        return contadorCeleste;
    }

    public void setContadorCeleste(int contadorCeleste) {
        this.contadorCeleste = contadorCeleste;
    }

    public int getContadorRosado() {
        return contadorRosado;
    }

    public void setContadorRosado(int contadorRosado) {
        this.contadorRosado = contadorRosado;
    }

    public int getContadorNaranja() {
        return contadorNaranja;
    }

    public void setContadorNaranja(int contadorNaranja) {
        this.contadorNaranja = contadorNaranja;
    }

    public int getContadorAmarillo() {
        return contadorAmarillo;
    }

    public void setContadorAmarillo(int contadorAmarillo) {
        this.contadorAmarillo = contadorAmarillo;
    }
    
    

    public int getTotalRoll() {
        return totalRoll;
    }

    public void setTotalRoll(int totalRoll) {
        this.totalRoll = totalRoll;
    }

    public String getNombreConsultar() {
        return nombreConsultar;
    }

    public void setNombreConsultar(String nombreConsultar) {
        this.nombreConsultar = nombreConsultar;
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

    public int getContadorCasas() {
        return contadorCasas;
    }

    public void setContadorCasas(int contadorCasas) {
        this.contadorCasas = contadorCasas;
    }

    public int getContadorHoteles() {
        return contadorHoteles;
    }

    public void setContadorHoteles(int contadorHoteles) {
        this.contadorHoteles = contadorHoteles;
    }

    public int getContadorArcaComunal() {
        return contadorArcaComunal;
    }

    public void setContadorArcaComunal(int contadorArcaComunal) {
        this.contadorArcaComunal = contadorArcaComunal;
    }

    public int getContadorFortuna() {
        return contadorFortuna;
    }

    public void setContadorFortuna(int contadorFortuna) {
        this.contadorFortuna = contadorFortuna;
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
                        
                        Calles casilla1 = new Calles("Go", this.getRefPantalla().getLblCasilla1() ,"Go",0,0,"Ninguno",0,0,0,0,0,0,0,0, this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing());
                        Calles casilla40 = new Calles("El Muelle", this.getRefPantalla().getLblCasilla2(), "El Muelle", 400, 200, "Azul", 200, 200, 50, 200, 600 ,1400,1700,2000, this.getRefPantalla().getLblLibreCasilla39(), this.getRefPantalla().getLblAlquilerCasilla39(), this.getRefPantalla().getLblCasasCasilla39(), this.getRefPantalla().getLblHotelCasillas39());
                        Calles casilla39 = new Calles("Impuestos 1", this.getRefPantalla().getLblCasilla3(), "Impuestos 1", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0, this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing());
                        Calles casilla38 = new Calles("Plaza Park", this.getRefPantalla().getLblCasilla4(), "Plaza Park", 350, 175, "Azul", 200, 200, 35, 175, 500 ,1100,1300,1500, this.getRefPantalla().getLblLibreCasilla37(), this.getRefPantalla().getLblAlquilerCasilla37(), this.getRefPantalla().getLblCasasCasilla37(), this.getRefPantalla().getLblHotelCasillas37());
                        Calles casilla37 = new Calles("Fortuna 1", this.getRefPantalla().getLblCasilla5(), "Fortuna 1", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0, this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing());
                        Ferrocarriles casilla36 = new Ferrocarriles("Ferrocarril Vía Rápida", this.getRefPantalla().getLblCasilla6(), "Ferrocarril Vía Rápida", 200, 100, this.getRefPantalla().getLblLibreCasilla35(), this.getRefPantalla().getLblAlquilerCasilla35(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing());
                        Calles casilla35 = new Calles("Avenida Pensilvania", this.getRefPantalla().getLblCasilla7(), "Avenida Pensilvania", 320, 160, "Verde", 200, 200, 28,150, 450 ,1000,1200,1400, this.getRefPantalla().getLblLibreCasilla34(), this.getRefPantalla().getLblAlquilerCasilla34(), this.getRefPantalla().getLblCasasCasilla34(), this.getRefPantalla().getLblHotelCasillas34());
                        Calles casilla34 = new Calles("Arca Comunal 1", this.getRefPantalla().getLblCasilla8(), "Arca Comunal 1", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0, this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing());
                        Calles casilla33 = new Calles("Avenida Carolina del Norte", this.getRefPantalla().getLblCasilla9(), "Avenida Carolina del Norte", 300, 150, "Verde", 200, 200, 26, 130, 390 ,900,1100,1275, this.getRefPantalla().getLblLibreCasilla32(), this.getRefPantalla().getLblAlquilerCasilla32(), this.getRefPantalla().getLblCasasCasilla32(), this.getRefPantalla().getLblHotelCasillas32());
                        Calles casilla32 = new Calles("Avenida Pacífico", this.getRefPantalla().getLblCasilla10(), "Avenida Pacífico", 300, 150, "Verde", 200, 200, 26, 130, 390 ,900,1100,1275, this.getRefPantalla().getLblLibreCasilla31(), this.getRefPantalla().getLblAlquilerCasilla31(), this.getRefPantalla().getLblCasasCasilla31(), this.getRefPantalla().getLblHotelCasillas31());
                        Calles casilla31 = new Calles("Vaya a la cárcel", this.getRefPantalla().getLblCasilla11(), "Vaya a la cárcel", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0, this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing());

                        Calles casilla30 = new Calles("Jardines Marvin", this.getRefPantalla().getLblCasilla12(), "Jardines Marvin", 280, 140, "Amarillo", 150, 150, 24, 120, 360 ,850,1025,1200, this.getRefPantalla().getLblLibreCasilla29(), this.getRefPantalla().getLblAlquilerCasilla29(), this.getRefPantalla().getLblCasasCasilla29(), this.getRefPantalla().getLblHotelCasillas29());
                        Servicios casilla29 = new Servicios("Servicios agua", this.getRefPantalla().getLblCasilla13(), "Servicios agua", 150, 75, this.getRefPantalla().getLblLibreCasilla28(), this.getRefPantalla().getLblAlquilerCasilla28(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing());
                        Calles casilla28 = new Calles("Avenida Ventnor", this.getRefPantalla().getLblCasilla14(), "Avenida Ventnor", 260, 130, "Amarillo", 150, 150, 22, 110, 330 ,800,975,1150, this.getRefPantalla().getLblLibreCasilla27(), this.getRefPantalla().getLblAlquilerCasilla27(), this.getRefPantalla().getLblCasasCasilla27(), this.getRefPantalla().getLblHotelCasillas27());
                        Calles casilla27 = new Calles("Avenida Atlántico", this.getRefPantalla().getLblCasilla15(), "Avenida Atlántico", 260, 130, "Amarillo", 150, 150, 22, 110, 330 ,800,975,1150, this.getRefPantalla().getLblLibreCasilla26(), this.getRefPantalla().getLblAlquilerCasilla26(), this.getRefPantalla().getLblCasasCasilla26(), this.getRefPantalla().getLblHotelCasillas26());
                        Ferrocarriles casilla26 = new Ferrocarriles("Ferrocarril B&O", this.getRefPantalla().getLblCasilla16(), "Ferrocarril B&O", 200, 100, this.getRefPantalla().getLblLibreCasilla25(), this.getRefPantalla().getLblAlquilerCasilla25(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing());
                        Calles casilla25 = new Calles("Avenida Illinois", this.getRefPantalla().getLblCasilla17(), "Avenida Illinóis", 240, 120, "Rojo", 150, 150, 20, 100, 300 ,750,925,1100, this.getRefPantalla().getLblLibreCasilla24(), this.getRefPantalla().getLblAlquilerCasilla24(), this.getRefPantalla().getLblCasasCasilla24(), this.getRefPantalla().getLblHotelCasillas24());
                        Calles casilla24 = new Calles("Avenida Indiana", this.getRefPantalla().getLblCasilla18(), "Avenida Indiana", 220, 110, "Rojo", 150, 150, 18, 90, 250 ,700,875,1050, this.getRefPantalla().getLblLibreCasilla23(), this.getRefPantalla().getLblAlquilerCasilla23(), this.getRefPantalla().getLblCasasCasilla23(), this.getRefPantalla().getLblHotelCasillas23());
                        Calles casilla23 = new Calles("Fortuna 2", this.getRefPantalla().getLblCasilla19(), "Fortuna 2", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0, this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing());
                        Calles casilla22 = new Calles("Avenida Kentucky", this.getRefPantalla().getLblCasilla20(), "Avenida Kentucky", 220, 110, "Rojo", 150, 150, 18, 90, 250 ,700,875,1050, this.getRefPantalla().getLblLibreCasilla21(), this.getRefPantalla().getLblAlquilerCasilla21(), this.getRefPantalla().getLblCasasCasilla21(), this.getRefPantalla().getLblHotelCasillas21());
                        Calles casilla21 = new Calles("Parqueo Libre", this.getRefPantalla().getLblCasilla21(), "Parqueo Libre", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0, this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing());
                        
                        Calles casilla20 = new Calles("Avenida New York", this.getRefPantalla().getLblCasilla22(), "Avenida New York", 200, 100, "Naranja", 100, 100, 16, 80, 220 ,600,800,1000, this.getRefPantalla().getLblLibreCasilla19(), this.getRefPantalla().getLblAlquilerCasilla19(), this.getRefPantalla().getLblCasasCasilla19(), this.getRefPantalla().getLblHotelCasillas19());
                        Calles casilla19 = new Calles("Avenida Tennessee", this.getRefPantalla().getLblCasilla23(), "Avenida Tennessee", 180, 90, "Naranja", 100, 100, 14, 70, 200 ,550,750,950, this.getRefPantalla().getLblLibreCasilla18(), this.getRefPantalla().getLblAlquilerCasilla18(), this.getRefPantalla().getLblCasasCasilla18(), this.getRefPantalla().getLblHotelCasillas18());
                        Calles casilla18 = new Calles("Arca Comunal 2", this.getRefPantalla().getLblCasilla24(), "Arca Comunal 2", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0, this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing());
                        Calles casilla17 = new Calles("Plaza St James", this.getRefPantalla().getLblCasilla25(), "Plaza St James", 180, 90, "Naranja", 100, 100, 14, 70, 200 ,550,750,950, this.getRefPantalla().getLblLibreCasilla16(), this.getRefPantalla().getLblAlquilerCasilla16(), this.getRefPantalla().getLblCasasCasilla16(), this.getRefPantalla().getLblHotelCasillas16());
                        Ferrocarriles casilla16 = new Ferrocarriles("Ferrocarril Pensilvania", this.getRefPantalla().getLblCasilla26(), "Ferrocarril Pensilvania", 200, 100, this.getRefPantalla().getLblLibreCasilla15(), this.getRefPantalla().getLblAlquilerCasilla15(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing());
                        Calles casilla15 = new Calles("Avenida Virginia", this.getRefPantalla().getLblCasilla27(), "Avenida Virginia", 160, 80, "Rosado", 100, 100, 12, 60, 180 ,500,700,900, this.getRefPantalla().getLblLibreCasilla14(), this.getRefPantalla().getLblAlquilerCasilla14(), this.getRefPantalla().getLblCasasCasilla14(), this.getRefPantalla().getLblHotelCasillas14());
                        Calles casilla14 = new Calles("Avenida Status", this.getRefPantalla().getLblCasilla28(), "Avenida Status", 140, 70, "Rosado", 100, 100, 10, 50, 150 ,450,625,750, this.getRefPantalla().getLblLibreCasilla13(), this.getRefPantalla().getLblAlquilerCasilla13(), this.getRefPantalla().getLblCasasCasilla13(), this.getRefPantalla().getLblHotelCasillas13());
                        Servicios casilla13 = new Servicios("Servicios electricidad", this.getRefPantalla().getLblCasilla29(), "Servicios electricidad", 150, 75, this.getRefPantalla().getLblLibreCasilla12(), this.getRefPantalla().getLblAlquilerCasilla12(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing());
                        Calles casilla12 = new Calles("Plaza San Carlos", this.getRefPantalla().getLblCasilla30(), "Plaza San Carlos", 140, 70, "Rosado", 100, 100, 10, 50, 150 ,450,625,750, this.getRefPantalla().getLblLibreCasilla11(), this.getRefPantalla().getLblAlquilerCasilla11(), this.getRefPantalla().getLblCasasCasilla11(), this.getRefPantalla().getLblHotelCasillas11());
                        Calles casilla11 = new Calles("La cárcel", this.getRefPantalla().getLblCasilla31(), "La cárcel", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0, this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing());
                        
                        Calles casilla10 = new Calles("Avenida Connecticut", this.getRefPantalla().getLblCasilla32(), "Avenida Connecticut", 120, 60, "Celeste", 50, 50, 8, 40, 100 ,300,450,600, this.getRefPantalla().getLblLibreCasilla9(), this.getRefPantalla().getLblAlquilerCasilla9(), this.getRefPantalla().getLblCasasCasilla9(), this.getRefPantalla().getLblHotelCasillas9());
                        Calles casilla9 = new Calles("Avenida Vermont", this.getRefPantalla().getLblCasilla33(), "Avenida Vermont", 100, 50, "Celeste", 50, 50, 6, 30, 90 ,270,400,550, this.getRefPantalla().getLblLibreCasilla8(), this.getRefPantalla().getLblAlquilerCasilla8(), this.getRefPantalla().getLblCasasCasilla8(), this.getRefPantalla().getLblHotelCasillas8());
                        Calles casilla8 = new Calles("Fortuna 3", this.getRefPantalla().getLblCasilla34(), "Fortuna 3", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0, this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing());
                        Calles casilla7 = new Calles("Avenida Oriental", this.getRefPantalla().getLblCasilla35(), "Avenida Oriental", 100, 50, "Celeste", 50, 50, 6, 30, 90 ,270,400,550, this.getRefPantalla().getLblLibreCasilla6(), this.getRefPantalla().getLblAlquilerCasilla6(), this.getRefPantalla().getLblCasasCasilla6(), this.getRefPantalla().getLblHotelCasillas6());
                        Ferrocarriles casilla6 = new Ferrocarriles("Ferrocarril Reading", this.getRefPantalla().getLblCasilla36(), "Ferrocarril Reading", 200, 100, this.getRefPantalla().getLblLibreCasilla5(), this.getRefPantalla().getLblAlquilerCasilla5(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing());
                        Calles casilla5 = new Calles("Impuestos 2", this.getRefPantalla().getLblCasilla37(), "Impuestos 2", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0, this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing());
                        Calles casilla4 = new Calles("Avenida Báltica", this.getRefPantalla().getLblCasilla38(), "Avenida Báltica", 60, 30, "Rojo oscuro", 50, 50, 4, 20, 60 ,180,320,450, this.getRefPantalla().getLblLibreCasilla3(), this.getRefPantalla().getLblAlquilerCasilla3(), this.getRefPantalla().getLblCasasCasilla3(), this.getRefPantalla().getLblHotelCasillas3());
                        Calles casilla3 = new Calles("Arca Comunal 3", this.getRefPantalla().getLblCasilla39(), "Arca Comunal 3", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0, this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing(), this.getRefPantalla().getLblNothing());
                        Calles casilla2 = new Calles("Avenida Mediterránea", this.getRefPantalla().getLblCasilla40(), "Avenida Mediterránea", 60, 30, "Rojo oscuro", 50, 50, 2, 10, 30 ,90,160,250, this.getRefPantalla().getLblLibreCasilla1(), this.getRefPantalla().getLblAlquilerCasilla1(), this.getRefPantalla().getLblCasasCasilla1(), this.getRefPantalla().getLblHotelCasillas1());
                        
                        ArrayList<Cartas> casillas = new ArrayList<Cartas>();
                        casillas.add(casilla1);
                        casillas.add(casilla2);
                        casillas.add(casilla3);
                        casillas.add(casilla4);
                        casillas.add(casilla5);
                        casillas.add(casilla6);
                        casillas.add(casilla7);
                        casillas.add(casilla8);
                        casillas.add(casilla9);
                        casillas.add(casilla10);
                        casillas.add(casilla11);
                        casillas.add(casilla12);
                        casillas.add(casilla13);
                        casillas.add(casilla14);
                        casillas.add(casilla15);
                        casillas.add(casilla16);
                        casillas.add(casilla17);
                        casillas.add(casilla18);
                        casillas.add(casilla19);
                        casillas.add(casilla20);
                        casillas.add(casilla21);
                        casillas.add(casilla22);
                        casillas.add(casilla23);
                        casillas.add(casilla24);
                        casillas.add(casilla25);
                        casillas.add(casilla26);
                        casillas.add(casilla27);
                        casillas.add(casilla28);
                        casillas.add(casilla29);
                        casillas.add(casilla30);
                        casillas.add(casilla31);
                        casillas.add(casilla32);
                        casillas.add(casilla33);
                        casillas.add(casilla34);
                        casillas.add(casilla35);
                        casillas.add(casilla36);
                        casillas.add(casilla37);
                        casillas.add(casilla38);
                        casillas.add(casilla39);
                        casillas.add(casilla40);
                        
                        ArrayList<Integer> numeroJugadoresFile = (ArrayList<Integer>)FileManager.readObject("src/Partida/numerojugadores.dat");
                        int numeroJugadores = numeroJugadoresFile.get(0);
                        
                        ArrayList<Cartas> cartasFortuna = new ArrayList<Cartas>();
                        Fortuna fortuna1 = new Fortuna("Fortuna 1",this.getRefPantalla().getPnlFortuna(),"Fortuna 1",4,200,5,"Carta de fortuna activada. Efecto: Avance a Go y páguese $200.");
                        Fortuna fortuna2 = new Fortuna("Fortuna 2",this.getRefPantalla().getPnlFortuna(),"Fortuna 2",4,200,5,"Carta de fortuna activada. Efecto: Avance a Avenida Illinois y si pasa por Go páguese 200.");
                        Fortuna fortuna3 = new Fortuna("Fortuna 3",this.getRefPantalla().getPnlFortuna(),"Fortuna 3",4,200,5,"Carta de fortuna activada. Efecto: Avance a Plaza San Carlos y si pasa por Go páguese 200.");
                        Fortuna fortuna4 = new Fortuna("Fortuna 4",this.getRefPantalla().getPnlFortuna(),"Fortuna 4",4,200,5,"Carta de fortuna activada. Efecto: Avance al servicio más cercano. Si no tiene dueno puede comprarlo.");
                        Fortuna fortuna5 = new Fortuna("Fortuna 5",this.getRefPantalla().getPnlFortuna(),"Fortuna 5",7,200,5,"Carta de fortuna activada. Efecto: Avance al servicio más cercano. Si no tiene dueno puede comprarlo.");
                        Fortuna fortuna6 = new Fortuna("Fortuna 6",this.getRefPantalla().getPnlFortuna(),"Fortuna 6",1,50,5,"Carta de fortuna activada. Efecto: El banco le pagó 50 dólares en dividendos bancarios. Páguese 50 dólares.");
                        Fortuna fortuna7 = new Fortuna("Fortuna 7",this.getRefPantalla().getPnlFortuna(),"Fortuna 7",5,50,5,"Carta de fortuna activada. Efecto: Ha sacado una carta de salir de la cárcel gratis.");
                        Fortuna fortuna8 = new Fortuna("Fortuna 8",this.getRefPantalla().getPnlFortuna(),"Fortuna 8",6,50,5,"Carta de fortuna activada. Efecto: Devuélvase tres espacios.");
                        Fortuna fortuna9 = new Fortuna("Fortuna 9",this.getRefPantalla().getPnlFortuna(),"Fortuna 9",3,50,5,"Carta de fortuna activada. Efecto: Vaya directo a la cárcel. Si pasa por Go, no se pague los 200 dólares.");
                        Fortuna fortuna10 = new Fortuna("Fortuna 10",this.getRefPantalla().getPnlFortuna(),"Fortuna 10",2,50,5,"Carta de fortuna activada. Efecto: Hizo reparaciones en todas sus propiedades. Pague $25 por cada casa y $100 por cada hotel.");
                        Fortuna fortuna11 = new Fortuna("Fortuna 11",this.getRefPantalla().getPnlFortuna(),"Fortuna 11",2,15,5,"Carta de fortuna activada. Efecto: Debe pagar impuestos. Pague 15 dólares.");
                        Fortuna fortuna12 = new Fortuna("Fortuna 12",this.getRefPantalla().getPnlFortuna(),"Fortuna 12",4,15,5,"Carta de fortuna activada. Efecto: Viaje hacia el ferrocarril Reading. Si pasa Go páguese 200 dólares.");
                        Fortuna fortuna13 = new Fortuna("Fortuna 13",this.getRefPantalla().getPnlFortuna(),"Fortuna 13",4,15,5,"Carta de fortuna activada. Efecto: Viaje al muelle. Vaya hacia el muelle.");
                        Fortuna fortuna14 = new Fortuna("Fortuna 14",this.getRefPantalla().getPnlFortuna(),"Fortuna 14",2,15,5,"Carta de fortuna activada. Efecto: Ha sido elegido presidente del Comité. Pague $50 por cada jugador.");
                        Fortuna fortuna15 = new Fortuna("Fortuna 15",this.getRefPantalla().getPnlFortuna(),"Fortuna 15",1,150,5,"Carta de fortuna activada. Efecto: Su préstamo ha vencido. Páguese 150 dólares.");
                        Fortuna fortuna16 = new Fortuna("Fortuna 16",this.getRefPantalla().getPnlFortuna(),"Fortuna 16",1,100,5,"Carta de fortuna activada. Efecto: Ha ganado una competencia de crucigramas. Páguese 100 dólares.");
                        
                        cartasFortuna.add(fortuna1);
                        cartasFortuna.add(fortuna2);
                        cartasFortuna.add(fortuna3);
                        cartasFortuna.add(fortuna4);
                        cartasFortuna.add(fortuna5);
                        cartasFortuna.add(fortuna6);
                        cartasFortuna.add(fortuna7);
                        cartasFortuna.add(fortuna8);
                        cartasFortuna.add(fortuna9);
                        cartasFortuna.add(fortuna10);
                        cartasFortuna.add(fortuna11);
                        cartasFortuna.add(fortuna12);
                        cartasFortuna.add(fortuna13);
                        cartasFortuna.add(fortuna14);
                        cartasFortuna.add(fortuna15);
                        cartasFortuna.add(fortuna16);
                        
                        ArrayList<Cartas> cartasArcaComunal = new ArrayList<Cartas>();
                        ArcaComunal arcaComunal1 = new ArcaComunal("Arca comunal 1",this.getRefPantalla().getPnlArcaComunal(),"Arca comunal 1",4,200,5,"Carta de arca comunal activada. Efecto: Avance a Go y páguese $200.");
                        ArcaComunal arcaComunal2 = new ArcaComunal("Arca comunal 2",this.getRefPantalla().getPnlArcaComunal(),"Arca comunal 2",1,200,0,"Carta de arca comunal activada. Efecto: Error del banco a su favor. Páguese $200.");
                        ArcaComunal arcaComunal3 = new ArcaComunal("Arca comunal 3",this.getRefPantalla().getPnlArcaComunal(),"Arca comunal 3",2,50,0,"Carta de arca comunal activada. Efecto: Fue a una cita médica y pagó los honorarios médicos. Pague $50.");
                        ArcaComunal arcaComunal4 = new ArcaComunal("Arca comunal 4",this.getRefPantalla().getPnlArcaComunal(),"Arca comunal 4",1,50,0,"Carta de arca comunal activada. Efecto: Logró vender unas acciones que tenía, páguese $50.");
                        ArcaComunal arcaComunal5 = new ArcaComunal("Arca comunal 5",this.getRefPantalla().getPnlArcaComunal(),"Arca comunal 5",5,50,0,"Carta de arca comunal activada. Efecto: Ha conseguido una tarjeta de salir de la cárcel gratis.");
                        ArcaComunal arcaComunal6 = new ArcaComunal("Arca comunal 6",this.getRefPantalla().getPnlArcaComunal(),"Arca comunal 6",3,50,10,"Carta de arca comunal activada. Efecto: Vaya directo a la cárcel. No se pague nada aunque pase por Go.");
                        ArcaComunal arcaComunal7 = new ArcaComunal("Arca comunal 7",this.getRefPantalla().getPnlArcaComunal(),"Arca comunal 7",1,(50*numeroJugadores),10,"Carta de arca comunal activada. Efecto: Páguese 50 dólares por cada jugador que hay.");
                        ArcaComunal arcaComunal8 = new ArcaComunal("Arca comunal 8",this.getRefPantalla().getPnlArcaComunal(),"Arca comunal 8",1,100,10,"Carta de arca comunal activada. Efecto: Recibió el aguinaldo. Páguese 100 dólares.");
                        ArcaComunal arcaComunal9 = new ArcaComunal("Arca comunal 9",this.getRefPantalla().getPnlArcaComunal(),"Arca comunal 9",1,20,10,"Carta de arca comunal activada. Efecto: Devolución de impuestos. Páguese 20 dólares.");
                        ArcaComunal arcaComunal10 = new ArcaComunal("Arca comunal 10",this.getRefPantalla().getPnlArcaComunal(),"Arca comunal 10",1,10,10,"Carta de arca comunal activada. Efecto: Es su cumpleanos. Páguese 10 dólares por cada jugador que hay.");
                        ArcaComunal arcaComunal11 = new ArcaComunal("Arca comunal 11",this.getRefPantalla().getPnlArcaComunal(),"Arca comunal 11",1,100,10,"Carta de arca comunal activada. Efecto: Devoluciónes de seguro de vida. Páguese 100 dólares.");
                        ArcaComunal arcaComunal12 = new ArcaComunal("Arca comunal 12",this.getRefPantalla().getPnlArcaComunal(),"Arca comunal 12",2,50,10,"Carta de arca comunal activada. Efecto: Tuvo que ir al hospital tras un accidente. Pague 50 dólares.");
                        ArcaComunal arcaComunal13 = new ArcaComunal("Arca comunal 13",this.getRefPantalla().getPnlArcaComunal(),"Arca comunal 13",2,50,10,"Carta de arca comunal activada. Efecto: Debe pagar el costo del semestre universitario. Pague 50 dólares.");
                        ArcaComunal arcaComunal14 = new ArcaComunal("Arca comunal 14",this.getRefPantalla().getPnlArcaComunal(),"Arca comunal 14",1,25,10,"Carta de arca comunal activada. Efecto: Recibió una cuota de consultoría. Páguese 25 dólares.");
                        ArcaComunal arcaComunal15 = new ArcaComunal("Arca comunal 15",this.getRefPantalla().getPnlArcaComunal(),"Arca comunal 15",2,10,10,"Carta de arca comunal activada. Efecto: Decidió hacer reparaciones de sus propiedades. Pague $45 por cada casa y $115 por cada hotel que tenga.");
                        ArcaComunal arcaComunal16 = new ArcaComunal("Arca comunal 16",this.getRefPantalla().getPnlArcaComunal(),"Arca comunal 16",1,100,10,"Carta de arca comunal activada. Efecto: Ha heredado 100 dólares. Páguese 100 dólares.");
                        
                        cartasArcaComunal.add(arcaComunal1);
                        cartasArcaComunal.add(arcaComunal2);
                        cartasArcaComunal.add(arcaComunal3);
                        cartasArcaComunal.add(arcaComunal4);
                        cartasArcaComunal.add(arcaComunal5);
                        cartasArcaComunal.add(arcaComunal6);
                        cartasArcaComunal.add(arcaComunal7);
                        cartasArcaComunal.add(arcaComunal8);
                        cartasArcaComunal.add(arcaComunal9);
                        cartasArcaComunal.add(arcaComunal10);
                        cartasArcaComunal.add(arcaComunal11);
                        cartasArcaComunal.add(arcaComunal12);
                        cartasArcaComunal.add(arcaComunal13);
                        cartasArcaComunal.add(arcaComunal14);
                        cartasArcaComunal.add(arcaComunal15);
                        cartasArcaComunal.add(arcaComunal16);
                        
                        Tablero newTablero = new Tablero(casillas,cartasFortuna,cartasArcaComunal);
                        System.out.println(newTablero);
                        this.setTablero(newTablero);
                        
                        for (int i = 0; i < listaFichas.size(); i++){
                            
                            Ficha newFicha = listaFichas.get(i);
                            System.out.println(newFicha.getLabelFicha());
                            System.out.println(newFicha.getLabelFicha().getIcon());
                            this.getTablero().getCasillas().get(0).getPanel().add(newFicha.getLabelFicha());
                            this.getTablero().getCasillas().get(0).getPanel().revalidate();
                            this.getTablero().getCasillas().get(0).getPanel().repaint();
                            System.out.println(this.getTablero().getCasillas().get(0).getPanel());

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
                            this.refPantalla.getLblTurno().setText(nombresOrden.get(0));
                            int contPos = 1;
                            for (int i = 0; i < nombresOrden.size(); i++){
                                this.refPantalla.getTxaHistorial().append(contPos + ". " + nombresOrden.get(i) + "\n");
                                this.refPantalla.getCbConsultarPropiedades().addItem(nombresOrden.get(i));
                                ArrayList<Calles> propiedadesJugador = new ArrayList<Calles>();
                                FileManager.writeObject(propiedadesJugador, "src/Partida/propiedades" + nombresOrden.get(i) + ".dat");
                                contPos = contPos + 1;
                            }
                            refPantalla.setNombreTurno(nombresOrden.get(0));
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
                    case 12:
                        int numMoverse = reader.readInt();
                        String nombreFicha = reader.readUTF();
                        int posFicha = reader.readInt();
                        int arcaJail = reader.readInt();
                        
                        listaFichas = (ArrayList<Ficha>)FileManager.readObject("src/Partida/listafichas.dat");
                        Ficha fichaMover = null;
                        int posicionActual = posFicha;
                        int fichaQuitar = 0;
                        int indicePnl = 0;
                        
                        for (int i = 0; i < listaFichas.size(); i++){
                            if (listaFichas.get(i).getNombre().equals(nombreFicha)){
                                fichaMover = listaFichas.get(i);
                                fichaQuitar = i;
                                System.out.println("i es: " + i);
                                //posicionActual = listaFichas.get(i).getPosicionActual();
                            }
                                    
                        }
                        
                        System.out.println(listaFichas);
                        
                        if (fichaQuitar == 0)
                            indicePnl = 2;
                        if (fichaQuitar == 1)
                            indicePnl = 3;
                        if (fichaQuitar == 2)
                            indicePnl = 4;
                        if (fichaQuitar == 3)
                            indicePnl = 5;
                        if (fichaQuitar == 4)
                            indicePnl = 6;
                        if (fichaQuitar == 5)
                            indicePnl = 7;
                        
                        System.out.println("indicePnl es :" + indicePnl);
                        System.out.println("ComponentCount es: " + this.getTablero().getCasillas().get(posicionActual).getPanel().getComponentCount());
                        if (this.getTablero().getCasillas().get(posicionActual).getPanel().getComponentCount()-1 < indicePnl)
                            indicePnl = indicePnl - 1;

                        this.getTablero().getCasillas().get(posicionActual).getPanel().remove(indicePnl);
                        this.getTablero().getCasillas().get(posicionActual).getPanel().revalidate();
                        this.getTablero().getCasillas().get(posicionActual).getPanel().repaint();
                        
                        if (posicionActual + 1 > this.getTablero().getCasillas().size()-1){
                            posicionActual = 0;
                        }
                        
                        int contMovido = 0;
                        int casillaFinal = posicionActual;
                        for (int i = posicionActual+1; contMovido < numMoverse ; i++){
                            
                            System.out.println("Ficha originalmente estaba en: " + this.getTablero().getCasillas().get(i).getPanel().getComponents());
                            System.out.println("Componentes: " + this.getTablero().getCasillas().get(i).getPanel().getComponents());
                            System.out.println("Cantidad de componentes: " + this.getTablero().getCasillas().get(i).getPanel().getComponentCount());
                            
                            this.getTablero().getCasillas().get(i-1).getPanel().remove(fichaMover.getLabelFicha());
                            this.getTablero().getCasillas().get(i-1).getPanel().revalidate();
                            this.getTablero().getCasillas().get(i-1).getPanel().repaint();
                            
                            this.getTablero().getCasillas().get(i).getPanel().add(fichaMover.getLabelFicha());
                            this.getTablero().getCasillas().get(i).getPanel().revalidate();
                            this.getTablero().getCasillas().get(i).getPanel().repaint();
                            
                            if (i + 1 > 39){
                                i = 0;
                                casillaFinal = 0;
                            }
                            
                            if (this.getFicha().getNombre().equals(fichaMover.getNombre())){
                                this.getFicha().setPosicionActual(i);
                            }
                            contMovido = contMovido + 1;
                            casillaFinal = casillaFinal + 1;
                            TimeUnit.SECONDS.sleep(1);
                            
                            if (i == 0){
                                System.out.println("Vuelta al tablero");
                                this.getTablero().getCasillas().get(39).getPanel().remove(fichaMover.getLabelFicha());
                                this.getTablero().getCasillas().get(39).getPanel().revalidate();
                                this.getTablero().getCasillas().get(39).getPanel().repaint();
                                
                                if (this.getFicha().getNombre().equals(nombreFicha)){
                                    
                                    if (arcaJail != 1)
                                        this.getBanco().darDinero(this, 200);
                                    this.getRefPantalla().getLblNumDinero().setText(this.getDinero() + " $");
                                    
                                    this.setVueltaDada(true);
                                    System.out.println("vueltaDada del jugador es: " + this.isVueltaDada());
                                    System.out.println("Mi nombre es: " + this.getNombre());
                                }
                                
                                
                                this.getTablero().getCasillas().get(0).getPanel().add(fichaMover.getLabelFicha());
                                this.getTablero().getCasillas().get(0).getPanel().revalidate();
                                this.getTablero().getCasillas().get(0).getPanel().repaint();
                                TimeUnit.SECONDS.sleep(1);
                                contMovido = contMovido + 1;
                            }
                            
                            System.out.println("Casilla actual de ficha es " + casillaFinal);
                        }
                        
                        if (casillaFinal == 2 || casillaFinal == 17 || casillaFinal == 33){ // si cae en una casilla de arca comunal saca la carta necesaria
                                if (this.getContadorArcaComunal() > 15){
                                    this.setContadorArcaComunal(0);
                                }
                                ArcaComunal cartaSacada = (ArcaComunal)this.getTablero().getCartasArcaComunal().get(this.getContadorArcaComunal());
                                
                                if (this.getContadorArcaComunal() == 0){
                                    cartaSacada.setIndiceCasillaDestino(39-casillaFinal);
                                }
                                if (this.getContadorArcaComunal() == 5){
                                    
                                    int cantidadMoverse = 0;
                                    for (int i = casillaFinal; i != 10; i++){
                                        
                                        if (i+1 > 39){
                                            i = 0;
                                        }
                                        
                                        cantidadMoverse = cantidadMoverse + 1;
                                        System.out.println(cantidadMoverse);
                                    }
                                    cantidadMoverse = cantidadMoverse + 1; // falta 1 para llegar a la carcel
                                    System.out.println(cantidadMoverse);
                                    cartaSacada.setIndiceCasillaDestino(cantidadMoverse);
                                }
                                if (this.getContadorArcaComunal() == 14){
                                    int montoCasas = 45*this.getContadorCasas();
                                    int montoHoteles = 115*this.getContadorHoteles();
                                    int montoTotal = montoCasas + montoHoteles;
                                    cartaSacada.setMonto( montoTotal );
                                    System.out.println("Casas: " + this.getContadorCasas() + " y hoteles: " + this.getContadorHoteles());
                                    System.out.println("Pagó " + montoCasas + " por las casas y " + montoHoteles + " por los hoteles. En total pagó " + montoTotal);
                                }
                                
                                if (this.getNombre().equalsIgnoreCase(fichaMover.getNombreJugador())){
                                    System.out.println(fichaMover.getNombreJugador());
                                    cartaSacada.funcionArca(banco, this);
                                }
                                
                                this.getRefPantalla().getLblNumDinero().setText(this.getDinero() + " $");
                                this.getRefPantalla().getLblNumDinero().revalidate();
                                this.getRefPantalla().getLblNumDinero().repaint();
                                
                                int numArca = this.getContadorArcaComunal();
                                numArca = numArca + 1;
                                this.setContadorArcaComunal(numArca);
                        }
                        
                        break;
                    case 13:
                        int casillaMoverse = reader.readInt();
                        nombreFicha = reader.readUTF();
                        posFicha = reader.readInt();
                        
                        listaFichas = (ArrayList<Ficha>)FileManager.readObject("src/Partida/listafichas.dat");
                        fichaMover = null;
                        posicionActual = posFicha;
                        fichaQuitar = 0;
                        indicePnl = 0;
                        
                        for (int i = 0; i < listaFichas.size(); i++){
                            if (listaFichas.get(i).getNombre().equals(nombreFicha)){
                                fichaMover = listaFichas.get(i);
                                fichaQuitar = i;
                                System.out.println("i es: " + i);
                                //posicionActual = listaFichas.get(i).getPosicionActual();
                            }
                                    
                        }
                        
                        System.out.println(listaFichas);
                        
                        if (fichaQuitar == 0)
                            indicePnl = 2;
                        if (fichaQuitar == 1)
                            indicePnl = 3;
                        if (fichaQuitar == 2)
                            indicePnl = 4;
                        if (fichaQuitar == 3)
                            indicePnl = 5;
                        if (fichaQuitar == 4)
                            indicePnl = 6;
                        if (fichaQuitar == 5)
                            indicePnl = 7;
                        
                        System.out.println("indicePnl es :" + indicePnl);
                        System.out.println("ComponentCount es: " + this.getTablero().getCasillas().get(posicionActual).getPanel().getComponentCount());
                        if (this.getTablero().getCasillas().get(posicionActual).getPanel().getComponentCount()-1 < indicePnl)
                            indicePnl = indicePnl - 1;

                        this.getTablero().getCasillas().get(posicionActual).getPanel().remove(indicePnl);
                        this.getTablero().getCasillas().get(posicionActual).getPanel().revalidate();
                        this.getTablero().getCasillas().get(posicionActual).getPanel().repaint();
                        
                        if (posicionActual + 1 > this.getTablero().getCasillas().size()-1){
                            posicionActual = 0;
                        }
                        
                        this.getTablero().getCasillas().get(casillaMoverse).getPanel().add(fichaMover.getLabelFicha());
                        this.getTablero().getCasillas().get(casillaMoverse).getPanel().revalidate();
                        this.getTablero().getCasillas().get(casillaMoverse).getPanel().repaint();
                        
                        break;
                    case 14:
                        int numDadoCobrar = reader.readInt();
                        String nombreComprador = reader.readUTF();
                        cantidadDinero = reader.readInt();
                        int casillaTablero = reader.readInt();
                        
                        Propiedades propiedadComprar = (Propiedades) this.getTablero().getCasillas().get(casillaTablero);
                        int precioPropiedad = propiedadComprar.getPrecioCompra();
                        
                        if (this.getNombre().equals(nombreComprador)){
                                
                                System.out.println("Dinero del jugador antes de la compra: " + cantidadDinero);
                                this.getBanco().retirarDinero(this, precioPropiedad);
                                this.getRefPantalla().getLblNumDinero().setText(this.getDinero() + " $");
                                System.out.println("Dinero luego de compra: " + this.getDinero());
                            
                                this.getPropiedades().add(propiedadComprar);
                                System.out.println("Propiedad comprada: " + propiedadComprar);
                                this.getRefPantalla().getCbPropiedades().addItem(propiedadComprar.getNombre());
                                System.out.println(this.getRefPantalla().getLblNombreJugador().getText());
                                ArrayList<Propiedades> propiedadesLeidas = (ArrayList<Propiedades>)FileManager.readObject("src/Partida/propiedades" + this.getRefPantalla().getLblNombreJugador().getText() + ".dat");
                                propiedadesLeidas.add(propiedadComprar);
                                FileManager.writeObject(propiedadesLeidas, "src/Partida/propiedades" + this.getRefPantalla().getLblNombreJugador().getText() + ".dat");
                                System.out.println(propiedadesLeidas);
                            
                            
                        }
                        
                        propiedadComprar.setComprada(true);
                        propiedadComprar.setDueno(nombreComprador);
                        propiedadComprar.getLblLibre().setText("Dueno: " + propiedadComprar.getDueno());
                        propiedadComprar.getLblAlquiler().setText("Alquiler: ");
                        if (!propiedadComprar.getNombre().contains("Ferrocarril") && !propiedadComprar.getNombre().contains("Servicios")){
                            Calles propiedadCalle = (Calles)propiedadComprar;
                            propiedadCalle.getLblAlquiler().setText("Alquiler: " + propiedadCalle.cobrar() + " $");
                            propiedadCalle.getLblCasas().setText(""+propiedadCalle.getCantidadCasas());
                            propiedadCalle.getLblHotel().setText("Hotel: " + propiedadCalle.getCantidadHoteles());
                            
                            if (propiedadCalle.getColor().equalsIgnoreCase("Verde")){
                                int contColor = this.getContadorVerde();
                                contColor = contColor + 1;
                                this.setContadorVerde(contColor);
                                System.out.println("Contador verde luego de comprar: " + this.getContadorVerde());
                            }
                            else if (propiedadCalle.getColor().equalsIgnoreCase("Rojo")){
                                int contColor = this.getContadorRojo();
                                contColor = contColor + 1;
                                this.setContadorRojo(contColor);
                                System.out.println("Contador rojo luego de comprar: " + this.getContadorRojo());
                            }
                            else if (propiedadCalle.getColor().equalsIgnoreCase("Rojo oscuro")){
                                int contColor = this.getContadorRojoOscuro();
                                contColor = contColor + 1;
                                this.setContadorRojoOscuro(contColor);
                                System.out.println("Contador rojo oscuro luego de comprar: " + this.getContadorRojoOscuro());
                            }
                            else if (propiedadCalle.getColor().equalsIgnoreCase("Amarillo")){
                                int contColor = this.getContadorAmarillo();
                                contColor = contColor + 1;
                                this.setContadorAmarillo(contColor);
                                System.out.println("Contador amarillo luego de comprar: " + this.getContadorAmarillo());
                            }
                            else if (propiedadCalle.getColor().equalsIgnoreCase("Naranja")){
                                int contColor = this.getContadorNaranja();
                                contColor = contColor + 1;
                                this.setContadorNaranja(contColor);
                                System.out.println("Contador naranja luego de comprar: " + this.getContadorNaranja());
                            }
                            else if (propiedadCalle.getColor().equalsIgnoreCase("Azul")){
                                int contColor = this.getContadorAzul();
                                contColor = contColor + 1;
                                this.setContadorAzul(contColor);
                                System.out.println("Contador azul luego de comprar: " + this.getContadorAzul());
                            }
                            else if (propiedadCalle.getColor().equalsIgnoreCase("Celeste")){
                                int contColor = this.getContadorCeleste();
                                contColor = contColor + 1;
                                this.setContadorCeleste(contColor);
                                System.out.println("Contador celeste luego de comprar: " + this.getContadorCeleste());
                            }
                            else if (propiedadCalle.getColor().equalsIgnoreCase("Rosado")){
                                int contColor = this.getContadorRosado();
                                contColor = contColor + 1;
                                this.setContadorRosado(contColor);
                                System.out.println("Contador rosado luego de comprar: " + this.getContadorRosado());
                            }
                            
                        }
                        else if (propiedadComprar.getNombre().contains("Ferrocarril")){
                            Ferrocarriles propiedadFerrocarril = (Ferrocarriles)propiedadComprar;
                            propiedadFerrocarril.getLblAlquiler().setText("Alquiler: " + propiedadFerrocarril.cobrar() + " $");
                        }
                        else if (propiedadComprar.getNombre().contains("Servicios")){
                            Servicios propiedadServicios = (Servicios)propiedadComprar;
                            propiedadServicios.getLblAlquiler().setText("Alquiler: " + propiedadServicios.cobrar(numDadoCobrar) + " $");
                        }
                        
                        break;
                    case 15:
                        String nombrePersona = reader.readUTF();
                        String nombrePropiedad = reader.readUTF();
                        int casasAcabadas = reader.readInt();
                        int quedanCasas = reader.readInt();
                        
                        Calles propiedadComprarCasa;
                        
                        if (casasAcabadas == 1){
                            this.getRefPantalla().getTxaHistorial().append("Se han acabado las 32 casas y por ende no se podrán construir más.");
                        }
                        
                        else if (casasAcabadas == 0){
                            
                            for (int i = 0; i < this.getTablero().getCasillas().size(); i++){
                                Propiedades propiedadActual = (Propiedades)this.getTablero().getCasillas().get(i);
                                
                                if (propiedadActual.getNombre().equalsIgnoreCase(nombrePropiedad)){
                                    propiedadComprarCasa = (Calles)propiedadActual;
                                    
                                    int numCasasPropiedad = propiedadComprarCasa.getCantidadCasas();
                                    numCasasPropiedad = numCasasPropiedad + 1;
                                    propiedadComprarCasa.setCantidadCasas(numCasasPropiedad);
                                    
                                    int numEdificios = propiedadComprarCasa.getCantidadEdificios();
                                    numEdificios = numEdificios + 1;
                                    propiedadComprarCasa.setCantidadEdificios(numEdificios);
                                    
                                    propiedadComprarCasa.getLblCasas().setText("" + propiedadComprarCasa.getCantidadCasas());
                                    propiedadComprarCasa.getLblCasas().revalidate();
                                    propiedadComprarCasa.getLblCasas().repaint();
                                    propiedadComprarCasa.getLblAlquiler().setText("Alquiler: " + propiedadComprarCasa.cobrar() + " $");
                                    this.getRefPantalla().getLblQuedanCasas().setText("Quedan " + quedanCasas + " casas");
                                    this.getRefPantalla().getLblQuedanCasas().revalidate();
                                    this.getRefPantalla().getLblQuedanCasas().repaint();
                                    System.out.println("Ha comprado una casa en " + propiedadActual.getNombre() + " y ahora esta tiene " + propiedadActual.getCantidadCasas());
                                    
                                    if (this.getNombre().equals(nombrePersona)){
                            
                                        this.getBanco().retirarDinero(this, propiedadComprarCasa.getPrecioCasa());
                                        this.getRefPantalla().getLblNumDinero().setText(this.getDinero() + " $");
                                        this.getRefPantalla().getLblNumDinero().revalidate();
                                        this.getRefPantalla().getLblNumDinero().repaint();
                                        int numCasasJugador = this.getContadorCasas();
                                        numCasasJugador = numCasasJugador + 1;
                                        this.setContadorCasas(numCasasJugador);
                            
                                    }
                                }
                                
                            }
                            
                            
                            
                        }
                        
                        break;
                    case 16:
                        nombrePropiedad = reader.readUTF();
                        nombreJugador = reader.readUTF();
                        Propiedades propiedadVender;
                        
                        for (int i = 0; i < this.getTablero().getCasillas().size(); i++){
                            Propiedades propiedadActual = (Propiedades)this.getTablero().getCasillas().get(i);
                            
                            if (propiedadActual.getNombre().equalsIgnoreCase(nombrePropiedad)){
                                propiedadVender = propiedadActual;
                                propiedadVender.setComprada(false);
                                propiedadVender.setDueno("");
                                
                                if (this.getNombre().equalsIgnoreCase(nombreJugador)){
                            
                            
                                    ArrayList<Propiedades> propiedadesLeidas = (ArrayList<Propiedades>)FileManager.readObject("src/Partida/propiedades" + this.getRefPantalla().getLblNombreJugador().getText() + ".dat");
                                    System.out.println(propiedadesLeidas);
                                    
                                    for (int j = 0; j < propiedadesLeidas.size(); j++){
                                        
                                        if (propiedadesLeidas.get(j).getNombre().equalsIgnoreCase(nombrePropiedad)){
                                            propiedadesLeidas.remove(propiedadesLeidas.get(j));
                                            System.out.println("Propiedad vendida");
                                        }
                                        
                                    }
                                    
                                    
                                    System.out.println(propiedadesLeidas);
                                    FileManager.writeObject(propiedadesLeidas, "src/Partida/propiedades" + this.getRefPantalla().getLblNombreJugador().getText() + ".dat");
                                    this.getBanco().darDinero(this, (propiedadVender.getPrecioCompra()/2) );
                                    this.getRefPantalla().getLblNumDinero().setText(this.getDinero() + " $");
                                    
                                    if (propiedadVender.getColor().equalsIgnoreCase("Rojo")){
                                        int contadorColor = this.getContadorRojo();
                                        contadorColor = contadorColor - 1;
                                        this.setContadorRojo(contadorColor);
                                    }
                                    if (propiedadVender.getColor().equalsIgnoreCase("Amarillo")){
                                        int contadorColor = this.getContadorAmarillo();
                                        contadorColor = contadorColor - 1;
                                        this.setContadorAmarillo(contadorColor);
                                    }
                                    if (propiedadVender.getColor().equalsIgnoreCase("Celeste")){
                                        int contadorColor = this.getContadorCeleste();
                                        contadorColor = contadorColor - 1;
                                        this.setContadorCeleste(contadorColor);
                                    }
                                    if (propiedadVender.getColor().equalsIgnoreCase("Azul")){
                                        int contadorColor = this.getContadorAzul();
                                        contadorColor = contadorColor - 1;
                                        this.setContadorAzul(contadorColor);
                                    }
                                    if (propiedadVender.getColor().equalsIgnoreCase("Naranja")){
                                        int contadorColor = this.getContadorNaranja();
                                        contadorColor = contadorColor - 1;
                                        this.setContadorNaranja(contadorColor);
                                    }
                                    if (propiedadVender.getColor().equalsIgnoreCase("Rojo oscuro")){
                                        int contadorColor = this.getContadorRojoOscuro();
                                        contadorColor = contadorColor - 1;
                                        this.setContadorRojoOscuro(contadorColor);
                                    }
                                    if (propiedadVender.getColor().equalsIgnoreCase("Verde")){
                                        int contadorColor = this.getContadorVerde();
                                        contadorColor = contadorColor - 1;
                                        this.setContadorVerde(contadorColor);
                                    }
                                    if (propiedadVender.getColor().equalsIgnoreCase("Rosado")){
                                        int contadorColor = this.getContadorRosado();
                                        contadorColor = contadorColor - 1;
                                        this.setContadorRosado(contadorColor);
                                    }
                            
                                }
                                propiedadVender.getLblLibre().setText("Dueno: " + propiedadVender.getDueno());
                                propiedadVender.getLblAlquiler().setText("Alquiler: ");
                                
                                if (!propiedadVender.getNombre().contains("Ferrocarril") && !propiedadVender.getNombre().contains("Servicios")){
                                    Calles propiedadCalle = (Calles)propiedadVender;
                                    propiedadCalle.getLblAlquiler().setText("Alquiler: 0 $");
                                    propiedadCalle.getLblCasas().setText("0");
                                    propiedadCalle.getLblHotel().setText("Hotel: 0");
                                }
                                else if (propiedadVender.getNombre().contains("Ferrocarril")){
                                    Ferrocarriles propiedadFerrocarril = (Ferrocarriles)propiedadVender;
                                    propiedadFerrocarril.getLblAlquiler().setText("Alquiler: 0 $");
                                }
                                else if (propiedadVender.getNombre().contains("Servicios")){
                                    Servicios propiedadServicios = (Servicios)propiedadVender;
                                    propiedadServicios.getLblAlquiler().setText("Alquiler: 0 $");
                                }
                                
                            }
                            
                        }
                        
                        
                        break;
                    case 17:
                        String nombreCasaVender = reader.readUTF();
                        String nombreVendedorCasa = reader.readUTF();
                        
                        for (int i = 0; i < this.getTablero().getCasillas().size(); i++){
                            Propiedades propiedadActual = (Propiedades)this.getTablero().getCasillas().get(i);
                            
                            if (propiedadActual.getNombre().equalsIgnoreCase(nombreCasaVender)){
                                int numCasasVender = propiedadActual.getCantidadCasas();
                                numCasasVender = numCasasVender - 1;
                                propiedadActual.setCantidadCasas(numCasasVender);
                                
                                int numEdificiosVender = propiedadActual.getCantidadEdificios();
                                numEdificiosVender = numEdificiosVender - 1;
                                propiedadActual.setCantidadEdificios(numEdificiosVender);
                                
                                propiedadActual.getLblCasas().setText("" + propiedadActual.getCantidadCasas());
                                propiedadActual.getLblCasas().revalidate();
                                propiedadActual.getLblCasas().repaint();

                                System.out.println("Ha vendido una casa en " + propiedadActual.getNombre() + " y ahora esta tiene " + propiedadActual.getCantidadCasas());
                                    
                                if (this.getNombre().equals(nombreVendedorCasa)){
                                    Calles calleActual = (Calles)propiedadActual;
                                    this.getBanco().darDinero( this, (calleActual.getPrecioCasa()/2) );
                                    this.getRefPantalla().getLblNumDinero().setText(this.getDinero() + " $");
                                    this.getRefPantalla().getLblNumDinero().revalidate();
                                    this.getRefPantalla().getLblNumDinero().repaint();
                            
                                }
                            }
                            
                        }
                        
                        break;
                    case 18:
                        String nombreHotelComprar = reader.readUTF();
                        String nombreCompradorHotel = reader.readUTF();
                        int hotelesAcabados = reader.readInt();
                        int numQuedanHoteles = reader.readInt();
                        
                        if (hotelesAcabados == 1){
                            this.getRefPantalla().getTxaHistorial().append("No se pueden comprar más hoteles ya que se acabaron.\n");
                        }
                        else if (hotelesAcabados == 0){
                            
                            for (int i = 0; i < this.getTablero().getCasillas().size(); i++){
                            Propiedades propiedadActual = (Propiedades)this.getTablero().getCasillas().get(i);
                            
                            if (propiedadActual.getNombre().equalsIgnoreCase(nombreHotelComprar)){
                                
                                propiedadActual.setCantidadHoteles(1);
                                propiedadActual.setCantidadEdificios(5);
                                propiedadActual.getLblHotel().setText("Hotel: 1");
                                propiedadActual.getLblHotel().revalidate();
                                propiedadActual.getLblHotel().repaint();
                                propiedadActual.getLblAlquiler().setText("Alquiler: " + propiedadActual.cobrar() + " $");
                                propiedadActual.getLblAlquiler().revalidate();
                                propiedadActual.getLblAlquiler().repaint();
                                this.getRefPantalla().getLblQuedanHoteles().setText("Quedan " + numQuedanHoteles + " hoteles");
                                this.getRefPantalla().getLblQuedanHoteles().revalidate();
                                this.getRefPantalla().getLblQuedanHoteles().repaint();
                                
                                if (this.getNombre().equalsIgnoreCase(nombreCompradorHotel)){
                                    
                                    Calles calleActual = (Calles)propiedadActual;
                                    this.getBanco().retirarDinero(this, calleActual.getPrecioHotel());
                                    this.getRefPantalla().getLblNumDinero().setText(this.getDinero() + " $");
                                    this.getRefPantalla().getLblNumDinero().revalidate();
                                    this.getRefPantalla().getLblNumDinero().repaint();
                                    int numHotelesJugador = this.getContadorHoteles();
                                    numHotelesJugador = numHotelesJugador + 1;
                                    this.setContadorHoteles(numHotelesJugador);
                                    
                                }
                                
                            }
                            
                        }
                            
                    }
                        
                        break;
                    case 19:
                        String nombreHotelVender = reader.readUTF();
                        String nombreVendedorHotel = reader.readUTF();
                        
                        for (int i = 0; i < this.getTablero().getCasillas().size(); i++){
                            Propiedades propiedadActual = (Propiedades)this.getTablero().getCasillas().get(i);
                            
                            if (propiedadActual.getNombre().equalsIgnoreCase(nombreHotelVender)){
                                
                                propiedadActual.setCantidadHoteles(0);
                                propiedadActual.setCantidadEdificios(4);
                                propiedadActual.getLblHotel().setText("Hotel: 0");
                                propiedadActual.getLblHotel().revalidate();
                                propiedadActual.getLblHotel().repaint();
                                propiedadActual.getLblAlquiler().setText("Alquiler: " + propiedadActual.cobrar() + " $");
                                propiedadActual.getLblAlquiler().revalidate();
                                propiedadActual.getLblAlquiler().repaint();
                                
                                System.out.println("El jugador " + nombreVendedorHotel + " vendió un hotel en la propiedad " + propiedadActual + " y ahora no tiene hoteles en esa propiedad.");
                                
                                if (this.getNombre().equals(nombreVendedorHotel)){
                                    Calles calleActual = (Calles)propiedadActual;
                                    this.getBanco().darDinero( this, (calleActual.getPrecioHotel()/2) );
                                    this.getRefPantalla().getLblNumDinero().setText(this.getDinero() + " $");
                                    this.getRefPantalla().getLblNumDinero().revalidate();
                                    this.getRefPantalla().getLblNumDinero().repaint();
                            
                                }
                                
                            }
                            
                        }
                        
                        break;
                    case 20:
                        String nombrePropiedadHipotecada = reader.readUTF();
                        String nombreHipotecador = reader.readUTF();
                        
                        for (int i = 0; i < this.getTablero().getCasillas().size(); i++){
                            Propiedades propiedadActual = (Propiedades)this.getTablero().getCasillas().get(i);
                            
                            if (propiedadActual.getNombre().contains(nombrePropiedadHipotecada)){
                                
                                if (propiedadActual.isHipotecada()){
                                    System.out.println("Alo???");
                                    propiedadActual.setHipotecada(false);
                                    propiedadActual.getLblAlquiler().setText("Alquiler: " + propiedadActual.cobrar());
                                    propiedadActual.getLblAlquiler().revalidate();
                                    propiedadActual.getLblAlquiler().repaint();
                                    
                                    if (this.getNombre().equalsIgnoreCase(nombreHipotecador)){
                                        double valorDeshipotecar = propiedadActual.getValorHipoteca() + (double)(propiedadActual.getValorHipoteca()/10);
                                        System.out.println("El valor total para deshipotecar la propiedad es: " + valorDeshipotecar);
                                        this.getBanco().retirarDinero(this, (int)valorDeshipotecar);
                                        this.getRefPantalla().getLblNumDinero().setText(this.getDinero() + " $");
                                        this.getRefPantalla().getLblNumDinero().revalidate();
                                        this.getRefPantalla().getLblNumDinero().repaint();
                                    }
                                }
                                else if (!propiedadActual.isHipotecada()){
                                    
                                    for (int z = 0; z < this.getTablero().getCasillas().size(); z++){
                                        Propiedades currentProperty = (Propiedades)this.getTablero().getCasillas().get(z);
                                        
                                        if (currentProperty.getColor().equalsIgnoreCase(propiedadActual.getColor()) && currentProperty.getDueno().equalsIgnoreCase(propiedadActual.getDueno())){
                                            
                                            currentProperty.setCantidadCasas(0);
                                            currentProperty.setCantidadEdificios(0);
                                            currentProperty.setCantidadHoteles(0);
                                            
                                            currentProperty.getLblAlquiler().setText("Alquiler: " + currentProperty.cobrar() + " $");
                                            currentProperty.getLblAlquiler().revalidate();
                                            currentProperty.getLblAlquiler().repaint();
                                            
                                            currentProperty.getLblCasas().setText(""+currentProperty.getCantidadCasas());
                                            currentProperty.getLblHotel().setText(""+currentProperty.getCantidadHoteles());
                                            
                                        }
                                        
                                    }
                                    
                                    propiedadActual.setHipotecada(true);
                                    
                                    propiedadActual.getLblAlquiler().setText("Hipotecada");
                                    propiedadActual.getLblAlquiler().revalidate();
                                    propiedadActual.getLblAlquiler().repaint();
                                    
                                    if (this.getNombre().equalsIgnoreCase(nombreHipotecador)){
                                        System.out.println("El valor total que se le pagó por hipotecar es: " + propiedadActual.getValorHipoteca());
                                        this.getBanco().darDinero(this, propiedadActual.getValorHipoteca());
                                        this.getRefPantalla().getLblNumDinero().setText(this.getDinero() + " $");
                                        this.getRefPantalla().getLblNumDinero().revalidate();
                                        this.getRefPantalla().getLblNumDinero().repaint();
                                    }
                                    
                                    System.out.println(propiedadActual.isHipotecada());
                                }
                            }
                            
                        }
                        
                        break;
                }
            } catch (IOException ex) {
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
   

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public ArrayList<Propiedades> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(ArrayList<Propiedades> propiedades) {
        this.propiedades = propiedades;
    }

    

    public boolean isVueltaDada() {
        return vueltaDada;
    }

    public void setVueltaDada(boolean vueltaDada) {
        this.vueltaDada = vueltaDada;
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
