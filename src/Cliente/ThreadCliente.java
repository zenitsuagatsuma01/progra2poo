/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Partida.FileManager;
import Servidor.Banco;
import Servidor.ThreadServidor;
import cartas.Calles;
import cartas.Cartas;
import cartas.Ferrocarriles;
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
    private Tablero tablero;

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
                        
                        Calles casilla1 = new Calles("Go", this.getRefPantalla().getLblCasilla1() ,"Go",0,0,"Ninguno",0,0,0,0,0,0,0,0);
                        Calles casilla2 = new Calles("El Muelle", this.getRefPantalla().getLblCasilla2(), "El Muelle", 400, 200, "Azul", 200, 200, 50, 200, 600 ,1400,1700,2000);
                        Calles casilla3 = new Calles("Impuestos 1", this.getRefPantalla().getLblCasilla3(), "Impuestos 1", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0);
                        Calles casilla4 = new Calles("Plaza Park", this.getRefPantalla().getLblCasilla4(), "Plaza Park", 350, 175, "Azul", 200, 200, 35, 175, 500 ,1100,1300,1500);
                        Calles casilla5 = new Calles("Fortuna 1", this.getRefPantalla().getLblCasilla5(), "Fortuna 1", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0);
                        Ferrocarriles casilla6 = new Ferrocarriles("Ferrocarril Vía Rápida", this.getRefPantalla().getLblCasilla6(), "Ferrocarril Vía Rápida", 200, 100);
                        Calles casilla7 = new Calles("Avenida Pensilvania", this.getRefPantalla().getLblCasilla7(), "Avenida Pensilvania", 320, 160, "Verde", 200, 200, 28,150, 450 ,1000,1200,1400);
                        Calles casilla8 = new Calles("Arca Comunal 1", this.getRefPantalla().getLblCasilla8(), "Arca Comunal 1", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0);
                        Calles casilla9 = new Calles("Avenida Carolina del Norte", this.getRefPantalla().getLblCasilla9(), "Avenida Carolina del Norte", 300, 150, "Verde", 200, 200, 26, 130, 390 ,900,1100,1275);
                        Calles casilla10 = new Calles("Avenida Pacífico", this.getRefPantalla().getLblCasilla10(), "Avenida Pacífico", 300, 150, "Verde", 200, 200, 26, 130, 390 ,900,1100,1275);
                        Calles casilla11 = new Calles("Vaya a la cárcel", this.getRefPantalla().getLblCasilla11(), "Vaya a la cárcel", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0);
                        
                        Calles casilla12 = new Calles("Jardines Marvin", this.getRefPantalla().getLblCasilla12(), "Jardines Marvin", 280, 140, "Amarillo", 150, 150, 24, 120, 360 ,850,1025,1200);
                        Servicios casilla13 = new Servicios("Servicios agua", this.getRefPantalla().getLblCasilla13(), "Servicios agua", 150, 75);
                        Calles casilla14 = new Calles("Avenida Ventnor", this.getRefPantalla().getLblCasilla14(), "Avenida Ventnor", 260, 130, "Amarillo", 150, 150, 22, 110, 330 ,800,975,1150);
                        Calles casilla15 = new Calles("Avenida Atlántico", this.getRefPantalla().getLblCasilla15(), "Avenida Atlántico", 260, 130, "Amarillo", 150, 150, 22, 110, 330 ,800,975,1150);
                        Ferrocarriles casilla16 = new Ferrocarriles("Ferrocarril B&O", this.getRefPantalla().getLblCasilla16(), "Ferrocarril B&O", 200, 100);
                        Calles casilla17 = new Calles("Avenida Illinois", this.getRefPantalla().getLblCasilla17(), "Avenida Illinóis", 240, 120, "Rojo", 150, 150, 20, 100, 300 ,750,925,1100);
                        Calles casilla18 = new Calles("Avenida Indiana", this.getRefPantalla().getLblCasilla18(), "Avenida Indiana", 220, 110, "Rojo", 150, 150, 18, 90, 250 ,700,875,1050);
                        Calles casilla19 = new Calles("Fortuna 2", this.getRefPantalla().getLblCasilla19(), "Fortuna 2", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0);
                        Calles casilla20 = new Calles("Avenida Kentucky", this.getRefPantalla().getLblCasilla20(), "Avenida Kentucky", 220, 110, "Rojo", 150, 150, 18, 90, 250 ,700,875,1050);
                        Calles casilla21 = new Calles("Parqueo Libre", this.getRefPantalla().getLblCasilla21(), "Parqueo Libre", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0);
                        
                        Calles casilla22 = new Calles("Avenida New York", this.getRefPantalla().getLblCasilla22(), "Avenida New York", 200, 100, "Naranja", 100, 100, 16, 80, 220 ,600,800,1000);
                        Calles casilla23 = new Calles("Avenida Tennessee", this.getRefPantalla().getLblCasilla23(), "Avenida Tennessee", 180, 90, "Naranja", 100, 100, 14, 70, 200 ,550,750,950);
                        Calles casilla24 = new Calles("Arca Comunal 2", this.getRefPantalla().getLblCasilla24(), "Arca Comunal 2", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0);
                        Calles casilla25 = new Calles("Plaza St James", this.getRefPantalla().getLblCasilla25(), "Plaza St James", 180, 90, "Naranja", 100, 100, 14, 70, 200 ,550,750,950);
                        Ferrocarriles casilla26 = new Ferrocarriles("Ferrocarril Pensilvania", this.getRefPantalla().getLblCasilla26(), "Ferrocarril Pensilvania", 200, 100);
                        Calles casilla27 = new Calles("Avenida Virginia", this.getRefPantalla().getLblCasilla27(), "Avenida Virginia", 160, 80, "Rosado", 100, 100, 12, 60, 180 ,500,700,900);
                        Calles casilla28 = new Calles("Avenida Status", this.getRefPantalla().getLblCasilla28(), "Avenida Status", 140, 70, "Rosado", 100, 100, 10, 50, 150 ,450,625,750);
                        Servicios casilla29 = new Servicios("Servicios electricidad", this.getRefPantalla().getLblCasilla29(), "Servicios electricidad", 150, 75);
                        Calles casilla30 = new Calles("Plaza San Carlos", this.getRefPantalla().getLblCasilla30(), "Plaza San Carlos", 140, 70, "Rosado", 100, 100, 10, 50, 150 ,450,625,750);
                        Calles casilla31 = new Calles("La cárcel", this.getRefPantalla().getLblCasilla31(), "La cárcel", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0);
                        
                        Calles casilla32 = new Calles("Avenida Connecticut", this.getRefPantalla().getLblCasilla32(), "Avenida Connecticut", 120, 60, "Celeste", 50, 50, 8, 40, 100 ,300,450,600);
                        Calles casilla33 = new Calles("Avenida Vermont", this.getRefPantalla().getLblCasilla33(), "Avenida Vermont", 100, 50, "Celeste", 50, 50, 6, 30, 90 ,270,400,550);
                        Calles casilla34 = new Calles("Fortuna 3", this.getRefPantalla().getLblCasilla34(), "Fortuna 3", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0);
                        Calles casilla35 = new Calles("Avenida Oriental", this.getRefPantalla().getLblCasilla35(), "Avenida Oriental", 100, 50, "Celeste", 50, 50, 6, 30, 90 ,270,400,550);
                        Ferrocarriles casilla36 = new Ferrocarriles("Ferrocarril Reading", this.getRefPantalla().getLblCasilla36(), "Ferrocarril Reading", 200, 100);
                        Calles casilla37 = new Calles("Impuestos 2", this.getRefPantalla().getLblCasilla37(), "Impuestos 2", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0);
                        Calles casilla38 = new Calles("Avenida Báltica", this.getRefPantalla().getLblCasilla38(), "Avenida Báltica", 60, 30, "Morado", 50, 50, 4, 20, 60 ,180,320,450);
                        Calles casilla39 = new Calles("Arca Comunal 3", this.getRefPantalla().getLblCasilla39(), "Arca Comunal 3", 0, 0, "Ninguno", 0, 0, 0, 0, 0 ,0,0,0);
                        Calles casilla40 = new Calles("Avenida Mediterránea", this.getRefPantalla().getLblCasilla40(), "Avenida Mediterránea", 60, 30, "Morado", 50, 50, 2, 10, 30 ,90,160,250);
                        
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
                        
                        Tablero newTablero = new Tablero(casillas);
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
                            }
                            
                            if (this.getFicha().getNombre().equals(fichaMover.getNombre())){
                                this.getFicha().setPosicionActual(i);
                            }
                            contMovido = contMovido + 1;
                            TimeUnit.SECONDS.sleep(1);
                            
                            if (i == 0){
                                System.out.println("Vuelta al tablero");
                                this.getTablero().getCasillas().get(39).getPanel().remove(fichaMover.getLabelFicha());
                                this.getTablero().getCasillas().get(39).getPanel().revalidate();
                                this.getTablero().getCasillas().get(39).getPanel().repaint();
                                
                                this.getTablero().getCasillas().get(0).getPanel().add(fichaMover.getLabelFicha());
                                this.getTablero().getCasillas().get(0).getPanel().revalidate();
                                this.getTablero().getCasillas().get(0).getPanel().repaint();
                                TimeUnit.SECONDS.sleep(1);
                                contMovido = contMovido + 1;
                            }
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
                        String nombreComprador = reader.readUTF();
                        
                        if (this.getNombre().equals(nombreComprador)){
                            
                            
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
