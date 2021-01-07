/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
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
                        int dado1 = (new Random()).nextInt(6)+1;                // Codigo placeholder para los dados, en realidad deberian tener su propia clase y estar al iniciar la partida
                        int dado2 = (new Random()).nextInt(6)+1;
                        String next = server.getNextTurno();
                        
                        for (int i = 0; i < server.conexiones.size(); i++) {
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(3);
                            current.writer.writeUTF(nombre);
                            current.writer.writeInt(dado1);
                            current.writer.writeInt(dado2);
                            current.writer.writeUTF(next);
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
                }
            } catch (IOException ex) {
                
            }
        }
    }
}
