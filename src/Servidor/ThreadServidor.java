/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Partida.FileManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ThreadServidor extends Thread implements Serializable{
    
    transient private Socket socketRef;
    protected DataInputStream reader;
    protected DataOutputStream writer;
    protected ObjectOutputStream objWriter;
    public String nombre;
    private boolean running = true;
    Servidor server;

    public ThreadServidor(Socket socketRef, Servidor server) throws IOException {
        this.socketRef = socketRef;
        reader = new DataInputStream(socketRef.getInputStream());
        writer = new DataOutputStream(socketRef.getOutputStream());
        objWriter = new ObjectOutputStream(socketRef.getOutputStream());
        this.server = server;
    }
    
    public void enviarTurnoInicial() throws IOException{            // Manda el turno inicial
        writer.writeInt(1);
        writer.writeUTF(server.getTurno());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Servidor getServer() {
        return server;
    }

    public void setServer(Servidor server) {
        this.server = server;
    }
    
    
    
    public void run (){
        
        int instruccionId = 1;
        while (running){
            try {
                instruccionId = reader.readInt(); // esperar hasta que reciba un entero
                
                switch (instruccionId){
                    case 1: // pasan el nombre del usuario
                        //nombre = reader.readUTF();
                        //enviarTurnoInicial();                  
                        
                        
                    break;
                    case 2: // pasan un mensaje por el chat
                        String usuario = reader.readUTF();
                        String mensaje = reader.readUTF();
                        
                        for (int i = 0; i < server.conexiones.size(); i++) {
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(2);
                            current.writer.writeUTF(usuario);
                            current.writer.writeUTF(mensaje);
                        }
                    break;
                    case 3:
                        int vecesTirado = this.server.getNumTirado();
                        vecesTirado = vecesTirado + 1;
                        this.server.setNumTirado(vecesTirado);
                        ArrayList<Integer> listaOrden = (ArrayList<Integer>)FileManager.readObject("src/Partida/listadados.dat");
                        System.out.println(listaOrden);
                        ArrayList<String> listaNombres = (ArrayList<String>)FileManager.readObject("src/Partida/listanombres.dat");
                        int jugador1Orden = 1;
                        int jugador2Orden = 1;
                        int jugador3Orden = 1;
                        int jugador4Orden = 1;
                        int jugador5Orden = 1;
                        int jugador6Orden = 1;
                        ArrayList<Integer> listaOrden2 = (ArrayList<Integer>)FileManager.readObject("src/Partida/listadados2.dat");
                        ArrayList<String> nombresOrden = (ArrayList<String>)FileManager.readObject("src/Partida/nombresorden.dat");
                        int decidido = 0;
                        
                        if (this.server.isTurnosDecididos() == false){
                             if (vecesTirado >= server.getLimiteMax()){
                            
                            if (server.getLimiteMax() == 2){
                                
                                if (listaOrden.get(0) < listaOrden.get(1)){
                                    
                                    nombresOrden.add(listaNombres.get(1));
                                    nombresOrden.add(listaNombres.get(0));
                                    FileManager.writeObject(nombresOrden, "src/Partida/nombresorden.dat");
                                    this.server.setNombreOrder(nombresOrden);
                                    System.out.println(this.server.getNombreOrder());
                                    System.out.println(" 1 menor que 2 " + nombresOrden);
                                    this.server.setTurnosDecididos(true);
                                    System.out.println(this.server.isTurnosDecididos());
                                    decidido = 1;
                                }
                                else if (listaOrden.get(0) > listaOrden.get(1)){

                                    nombresOrden.add(listaNombres.get(0));
                                    nombresOrden.add(listaNombres.get(1));
                                    FileManager.writeObject(nombresOrden, "src/Partida/nombresorden.dat");
                                    this.server.setNombreOrder(nombresOrden);
                                    System.out.println(this.server.getNombreOrder());
                                    System.out.println(" 1 menor que 2 " + nombresOrden);
                                    this.server.setTurnosDecididos(true);
                                    System.out.println(this.server.isTurnosDecididos());
                                    decidido = 1;
                                }
                                
                                else if (listaOrden.get(0) == listaOrden.get(1)){
                                    System.out.println("Los dos jugadores sacaron el mismo numero. Por favor tiren de nuevo.");
                                }
                                
                            }
                            
                            if (server.getLimiteMax() == 3){
                                
                                if (listaOrden.get(0) < listaOrden.get(1))
                                    jugador1Orden = jugador1Orden + 1;
                                
                                if (listaOrden.get(0) < listaOrden.get(2))
                                    jugador1Orden = jugador1Orden + 1;
                                
                                if (listaOrden.get(1) < listaOrden.get(0))
                                    jugador2Orden = jugador2Orden + 1;
                                
                                if (listaOrden.get(1) < listaOrden.get(2))
                                    jugador2Orden = jugador2Orden + 1;
                                
                                if (listaOrden.get(2) < listaOrden.get(0))
                                    jugador3Orden = jugador3Orden + 1;
                                
                                if (listaOrden.get(2) < listaOrden.get(1))
                                    jugador3Orden = jugador3Orden + 1;
                                
                                System.out.println(jugador1Orden);
                                System.out.println(jugador2Orden);
                                System.out.println(jugador3Orden);
                                
                                nombresOrden.add("placeholder");
                                nombresOrden.add("placeholder");
                                nombresOrden.add("placeholder");
                                
                                nombresOrden.set(jugador1Orden-1, listaNombres.get(0));
                                nombresOrden.set(jugador2Orden-1, listaNombres.get(1));
                                nombresOrden.set(jugador3Orden-1, listaNombres.get(2));
                                
                                System.out.println(nombresOrden);
                                
                                FileManager.writeObject(nombresOrden, "src/Partida/nombresorden.dat");
                                this.server.setNombreOrder(nombresOrden);
                                System.out.println(this.server.getNombreOrder());
                                this.server.setTurnosDecididos(true);
                                decidido = 1;
                                
                            }
                            
                            if (server.getLimiteMax() == 4){
                                
                                if (listaOrden.get(0) < listaOrden.get(1))
                                    jugador1Orden = jugador1Orden + 1;
                                
                                if (listaOrden.get(0) < listaOrden.get(2))
                                    jugador1Orden = jugador1Orden + 1;
                                
                                if (listaOrden.get(0) < listaOrden.get(3))
                                    jugador1Orden = jugador1Orden + 1;
                                
                                if (listaOrden.get(1) < listaOrden.get(0))
                                    jugador2Orden = jugador2Orden + 1;
                                
                                if (listaOrden.get(1) < listaOrden.get(2))
                                    jugador2Orden = jugador2Orden + 1;
                                
                                if (listaOrden.get(1) < listaOrden.get(3))
                                    jugador2Orden = jugador2Orden + 1;
                                
                                if (listaOrden.get(2) < listaOrden.get(0))
                                    jugador3Orden = jugador3Orden + 1;
                                
                                if (listaOrden.get(2) < listaOrden.get(1))
                                    jugador3Orden = jugador3Orden + 1;
                                
                                if (listaOrden.get(2) < listaOrden.get(3))
                                    jugador3Orden = jugador3Orden + 1;
                                
                                if (listaOrden.get(3) < listaOrden.get(0))
                                    jugador4Orden = jugador4Orden + 1;
                                
                                if (listaOrden.get(3) < listaOrden.get(1))
                                    jugador4Orden = jugador4Orden + 1;
                                
                                if (listaOrden.get(3) < listaOrden.get(2))
                                    jugador4Orden = jugador4Orden + 1;
                                
                                System.out.println(jugador1Orden);
                                System.out.println(jugador2Orden);
                                System.out.println(jugador3Orden);
                                System.out.println(jugador4Orden);
                                
                                nombresOrden.add("placeholder");
                                nombresOrden.add("placeholder");
                                nombresOrden.add("placeholder");
                                nombresOrden.add("placeholder");
                                
                                nombresOrden.set(jugador1Orden-1, listaNombres.get(0));
                                nombresOrden.set(jugador2Orden-1, listaNombres.get(1));
                                nombresOrden.set(jugador3Orden-1, listaNombres.get(2));
                                nombresOrden.set(jugador4Orden-1, listaNombres.get(3));
                                
                                System.out.println(nombresOrden);
                                
                                FileManager.writeObject(nombresOrden, "src/Partida/nombresorden.dat");
                                this.server.setNombreOrder(nombresOrden);
                                System.out.println(this.server.getNombreOrder());
                                this.server.setTurnosDecididos(true);
                                decidido = 1;
                                
                            }
                            
                            if (server.getLimiteMax() == 5){
                                
                                if (listaOrden.get(0) < listaOrden.get(1))
                                    jugador1Orden = jugador1Orden + 1;
                                
                                if (listaOrden.get(0) < listaOrden.get(2))
                                    jugador1Orden = jugador1Orden + 1;
                                
                                if (listaOrden.get(0) < listaOrden.get(3))
                                    jugador1Orden = jugador1Orden + 1;
                                
                                if (listaOrden.get(0) < listaOrden.get(4))
                                    jugador1Orden = jugador1Orden + 1;
                                
                                if (listaOrden.get(1) < listaOrden.get(0))
                                    jugador2Orden = jugador2Orden + 1;
                                
                                if (listaOrden.get(1) < listaOrden.get(2))
                                    jugador2Orden = jugador2Orden + 1;
                                
                                if (listaOrden.get(1) < listaOrden.get(3))
                                    jugador2Orden = jugador2Orden + 1;
                                
                                if (listaOrden.get(1) < listaOrden.get(4))
                                    jugador2Orden = jugador2Orden + 1;
                                
                                if (listaOrden.get(2) < listaOrden.get(0))
                                    jugador3Orden = jugador3Orden + 1;
                                
                                if (listaOrden.get(2) < listaOrden.get(1))
                                    jugador3Orden = jugador3Orden + 1;
                                
                                if (listaOrden.get(2) < listaOrden.get(3))
                                    jugador3Orden = jugador3Orden + 1;
                                
                                if (listaOrden.get(2) < listaOrden.get(4))
                                    jugador3Orden = jugador3Orden + 1;
                                
                                if (listaOrden.get(3) < listaOrden.get(0))
                                    jugador4Orden = jugador4Orden + 1;
                                
                                if (listaOrden.get(3) < listaOrden.get(1))
                                    jugador4Orden = jugador4Orden + 1;
                                
                                if (listaOrden.get(3) < listaOrden.get(2))
                                    jugador4Orden = jugador4Orden + 1;
                                
                                if (listaOrden.get(3) < listaOrden.get(4))
                                    jugador4Orden = jugador4Orden + 1;
                                
                                if (listaOrden.get(4) < listaOrden.get(0))
                                    jugador5Orden = jugador5Orden + 1;
                                
                                if (listaOrden.get(4) < listaOrden.get(1))
                                    jugador5Orden = jugador5Orden + 1;
                                
                                if (listaOrden.get(4) < listaOrden.get(2))
                                    jugador5Orden = jugador5Orden + 1;
                                
                                if (listaOrden.get(4) < listaOrden.get(3))
                                    jugador5Orden = jugador5Orden + 1;
                                
                                System.out.println(jugador1Orden);
                                System.out.println(jugador2Orden);
                                System.out.println(jugador3Orden);
                                System.out.println(jugador4Orden);
                                System.out.println(jugador5Orden);
                                
                                nombresOrden.add("placeholder");
                                nombresOrden.add("placeholder");
                                nombresOrden.add("placeholder");
                                nombresOrden.add("placeholder");
                                nombresOrden.add("placeholder");
                                
                                nombresOrden.set(jugador1Orden-1, listaNombres.get(0));
                                nombresOrden.set(jugador2Orden-1, listaNombres.get(1));
                                nombresOrden.set(jugador3Orden-1, listaNombres.get(2));
                                nombresOrden.set(jugador4Orden-1, listaNombres.get(3));
                                nombresOrden.set(jugador5Orden-1, listaNombres.get(4));
                                
                                System.out.println(nombresOrden);
                                
                                FileManager.writeObject(nombresOrden, "src/Partida/nombresorden.dat");
                                this.server.setNombreOrder(nombresOrden);
                                System.out.println(this.server.getNombreOrder());
                                this.server.setTurnosDecididos(true);
                                decidido = 1;
                                
                            }
                            
                            if (server.getLimiteMax() == 6){
                                
                                if (listaOrden.get(0) < listaOrden.get(1))
                                    jugador1Orden = jugador1Orden + 1;
                                
                                if (listaOrden.get(0) < listaOrden.get(2))
                                    jugador1Orden = jugador1Orden + 1;
                                
                                if (listaOrden.get(0) < listaOrden.get(3))
                                    jugador1Orden = jugador1Orden + 1;
                                
                                if (listaOrden.get(0) < listaOrden.get(4))
                                    jugador1Orden = jugador1Orden + 1;
                                
                                if (listaOrden.get(0) < listaOrden.get(5))
                                    jugador1Orden = jugador1Orden + 1;
                                
                                if (listaOrden.get(1) < listaOrden.get(0))
                                    jugador2Orden = jugador2Orden + 1;
                                
                                if (listaOrden.get(1) < listaOrden.get(2))
                                    jugador2Orden = jugador2Orden + 1;
                                
                                if (listaOrden.get(1) < listaOrden.get(3))
                                    jugador2Orden = jugador2Orden + 1;
                                
                                if (listaOrden.get(1) < listaOrden.get(4))
                                    jugador2Orden = jugador2Orden + 1;
                                
                                if (listaOrden.get(1) < listaOrden.get(5))
                                    jugador2Orden = jugador2Orden + 1;
                                
                                if (listaOrden.get(2) < listaOrden.get(0))
                                    jugador3Orden = jugador3Orden + 1;
                                
                                if (listaOrden.get(2) < listaOrden.get(1))
                                    jugador3Orden = jugador3Orden + 1;
                                
                                if (listaOrden.get(2) < listaOrden.get(3))
                                    jugador3Orden = jugador3Orden + 1;
                                
                                if (listaOrden.get(2) < listaOrden.get(4))
                                    jugador3Orden = jugador3Orden + 1;
                                
                                if (listaOrden.get(2) < listaOrden.get(5))
                                    jugador3Orden = jugador3Orden + 1;
                                
                                if (listaOrden.get(3) < listaOrden.get(0))
                                    jugador4Orden = jugador4Orden + 1;
                                
                                if (listaOrden.get(3) < listaOrden.get(1))
                                    jugador4Orden = jugador4Orden + 1;
                                
                                if (listaOrden.get(3) < listaOrden.get(2))
                                    jugador4Orden = jugador4Orden + 1;
                                
                                if (listaOrden.get(3) < listaOrden.get(4))
                                    jugador4Orden = jugador4Orden + 1;
                                
                                if (listaOrden.get(3) < listaOrden.get(5))
                                    jugador4Orden = jugador4Orden + 1;
                                
                                if (listaOrden.get(4) < listaOrden.get(0))
                                    jugador5Orden = jugador5Orden + 1;
                                
                                if (listaOrden.get(4) < listaOrden.get(1))
                                    jugador5Orden = jugador5Orden + 1;
                                
                                if (listaOrden.get(4) < listaOrden.get(2))
                                    jugador5Orden = jugador5Orden + 1;
                                
                                if (listaOrden.get(4) < listaOrden.get(3))
                                    jugador5Orden = jugador5Orden + 1;
                                
                                if (listaOrden.get(4) < listaOrden.get(5))
                                    jugador5Orden = jugador5Orden + 1;
                                
                                if (listaOrden.get(5) < listaOrden.get(0))
                                    jugador6Orden = jugador6Orden + 1;
                                
                                if (listaOrden.get(5) < listaOrden.get(1))
                                    jugador6Orden = jugador6Orden + 1;
                                
                                if (listaOrden.get(5) < listaOrden.get(2))
                                    jugador6Orden = jugador6Orden + 1;
                                
                                if (listaOrden.get(5) < listaOrden.get(3))
                                    jugador6Orden = jugador6Orden + 1;
                                
                                if (listaOrden.get(5) < listaOrden.get(4))
                                    jugador6Orden = jugador6Orden + 1;
                                
                                System.out.println(jugador1Orden);
                                System.out.println(jugador2Orden);
                                System.out.println(jugador3Orden);
                                System.out.println(jugador4Orden);
                                System.out.println(jugador5Orden);
                                System.out.println(jugador6Orden);
                                
                                nombresOrden.add("placeholder");
                                nombresOrden.add("placeholder");
                                nombresOrden.add("placeholder");
                                nombresOrden.add("placeholder");
                                nombresOrden.add("placeholder");
                                nombresOrden.add("placeholder");
                                
                                nombresOrden.set(jugador1Orden-1, listaNombres.get(0));
                                nombresOrden.set(jugador2Orden-1, listaNombres.get(1));
                                nombresOrden.set(jugador3Orden-1, listaNombres.get(2));
                                nombresOrden.set(jugador4Orden-1, listaNombres.get(3));
                                nombresOrden.set(jugador5Orden-1, listaNombres.get(4));
                                nombresOrden.set(jugador6Orden-1, listaNombres.get(5));
                                
                                System.out.println(nombresOrden);
                                
                                FileManager.writeObject(nombresOrden, "src/Partida/nombresorden.dat");
                                this.server.setNombreOrder(nombresOrden);
                                System.out.println(this.server.getNombreOrder());
                                this.server.setTurnosDecididos(true);
                                decidido = 1;
                                
                            }
                            
                            for (int i = 0; i < server.conexiones.size(); i++) {
                                ThreadServidor current = server.conexiones.get(i);
                                current.writer.writeInt(9);
                                current.writer.writeInt(decidido);
                            }
                            
                        }    
                    }
                        
                       
                    break;
                    case 4: // iniciar partida
                        // al iniciar la partida se deberían tirar los dados para determinar el orden
                        for (int i = 0; i < server.conexiones.size(); i++) {
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(4);
                        }
                        
                        
                    break;
                    case 5:
                        for (int i = 0; i < server.conexiones.size(); i++) {
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(5);
                        }
                        break;
                    case 6:
                        int numFichas = this.server.getContFichas();
                        numFichas = numFichas + 1;
                        System.out.println(this.server.getContFichas());
                        System.out.println(numFichas);
                        if (numFichas == server.getLimiteMax()){
                            System.out.println("hola");
                            this.server.setContFichas(numFichas);
                            
                            for (int i = 0; i < server.conexiones.size(); i++) {
                                ThreadServidor current = server.conexiones.get(i);
                                current.writer.writeInt(6);
                            }
                            
                            for (int i = 0; i < server.conexiones.size(); i++) {
                                ThreadServidor current = server.conexiones.get(i);
                                current.writer.writeInt(7);
                                current.writer.writeUTF("Por favor tire los dados para decidir el orden la partida.");
                            }
                            
                        }
                        
                        this.server.setContFichas(numFichas);
                        break;
                    case 7:
                        mensaje = reader.readUTF();
                        
                        for (int i = 0; i < server.conexiones.size(); i++) {
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(7);
                            current.writer.writeUTF(mensaje);
                        }
                        break;
                    case 8:
                        int cantidadDinero = reader.readInt();
                        for (int i = 0; i < server.conexiones.size(); i++) {
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(8);
                            current.writer.writeInt(cantidadDinero);
                        }
                        break;
                    case 9:
                        String turnoActual = reader.readUTF();  // Para cambiar de turno
                        this.server.proximoTurno(turnoActual);
                        break;
                    case 10:
                        this.server.enviarTurnoInicial();
                        break;
                    case 11:
                        int numMoverse = reader.readInt();
                        String nombreFicha = reader.readUTF();
                        int posFicha = reader.readInt();
                        
                        for (int i = 0; i < server.conexiones.size(); i++) {
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(12);
                            current.writer.writeInt(numMoverse);
                            current.writer.writeUTF(nombreFicha);
                            current.writer.writeInt(posFicha);
                        }
                        break;
                    case 12:
                        int casillaMoverse = reader.readInt();
                        nombreFicha = reader.readUTF();
                        posFicha = reader.readInt();
                        
                        for (int i = 0; i < server.conexiones.size(); i++) {
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(13);
                            current.writer.writeInt(casillaMoverse);
                            current.writer.writeUTF(nombreFicha);
                            current.writer.writeInt(posFicha);
                        }
                        
                        break;
                    case 13:
                        int numDadoTotal = reader.readInt();
                        String nombreComprador = reader.readUTF();
                        cantidadDinero = reader.readInt();
                        int casillaTablero = reader.readInt();
                        
                        for (int i = 0; i < server.conexiones.size(); i++) {
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(14);
                            current.writer.writeInt(numDadoTotal);
                            current.writer.writeUTF(nombreComprador);
                            current.writer.writeInt(cantidadDinero);
                            current.writer.writeInt(casillaTablero);
                        }
                            break;
                    case 14: //compra de casas
                        String nombrePersona = reader.readUTF();
                        String nombrePropiedad = reader.readUTF();
                        int casasAcabadas = 0;
                        int quedanCasas = server.getTotalCasas();
                        
                        if (quedanCasas <= 0){
                            casasAcabadas = 1;
                        }
                        
                        quedanCasas = quedanCasas - 1;
                        server.setTotalCasas(quedanCasas);
                        
                        if (quedanCasas == 0){
                            server.enviarMensaje("El jugador " + nombrePersona + " ha comprado la última casa.");
                        }
                            
                        for (int i = 0; i < server.conexiones.size(); i++) {
                           ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(15);
                            current.writer.writeUTF(nombrePersona);
                            current.writer.writeUTF(nombrePropiedad);
                            current.writer.writeInt(casasAcabadas);
                            current.writer.writeInt(quedanCasas);
                        }
                            
                        break;
                    case 15:
                        String propiedadVender = reader.readUTF();
                        String vendedorNombre = reader.readUTF();
                        
                        for (int i = 0; i < server.conexiones.size(); i++){
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(16);
                            current.writer.writeUTF(propiedadVender);
                            current.writer.writeUTF(vendedorNombre);
                        }
                        break;
                    case 16:
                        String nombreCasaVender = reader.readUTF();
                        String nombreVendedorCasa = reader.readUTF();
                        
                        for (int i = 0; i < server.conexiones.size(); i++){
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(17);
                            current.writer.writeUTF(nombreCasaVender);
                            current.writer.writeUTF(nombreVendedorCasa);
                        }
                        
                        break;
                    case 17:
                        String nombreCompradorHotel = reader.readUTF();
                        String nombreHotelComprar = reader.readUTF();
                        
                        int hotelesAcabados = 0;
                        int numQuedanHoteles = server.getTotalHoteles();
                        
                        if (numQuedanHoteles == 0)
                            hotelesAcabados = 1;
                        
                        numQuedanHoteles = numQuedanHoteles - 1;
                        server.setTotalHoteles(numQuedanHoteles);
                        
                        if (numQuedanHoteles == 0){
                            server.enviarMensaje("El jugador " + nombreCompradorHotel + "ha comprado el último hotel.");
                        }
                        
                        for (int i = 0; i < server.conexiones.size(); i++){
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(18);
                            current.writer.writeUTF(nombreHotelComprar);
                            current.writer.writeUTF(nombreCompradorHotel);
                            current.writer.writeInt(hotelesAcabados);
                            current.writer.writeInt(numQuedanHoteles);
                        }
                        
                        break;
                    case 18:
                        String nombreHotelVender = reader.readUTF();
                        String nombreVendedorHotel = reader.readUTF();
                        
                        for (int i = 0; i < server.conexiones.size(); i++){
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(19);
                            current.writer.writeUTF(nombreHotelVender);
                            current.writer.writeUTF(nombreVendedorHotel);
                        }
                        
                        break;
                }
            } catch (IOException ex) {
                
            }
        }
    }
}
