/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


class ThreadServidor extends Thread{
    
    private Socket socketRef;
    private DataInputStream reader;
    private DataOutputStream writer;
    public String nombre;
    private boolean running = true;
    Servidor server;

    public ThreadServidor(Socket socketRef, Servidor server) throws IOException {
        this.socketRef = socketRef;
        reader = new DataInputStream(socketRef.getInputStream());
        writer = new DataOutputStream(socketRef.getOutputStream());
        this.server = server;
    }
    
    public void enviarTurnoInicial() throws IOException{
        writer.writeInt(1);
        writer.writeUTF(server.getTurno());
    }
    
    public void run (){
        
        int instruccionId = 1;
        while (running){
            try {
                instruccionId = reader.readInt(); // esperar hasta que reciba un entero
                
                switch (instruccionId){
                    case 1: // pasan el nombre del usuario
                        nombre = reader.readUTF();
                        enviarTurnoInicial();                  
                        
                        
                    break;
                    case 2: // pasan un mensaje por el chat
                        String mensaje = reader.readUTF();
                        
                        for (int i = 0; i < server.conexiones.size(); i++) {
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(2);
                            current.writer.writeUTF(nombre);
                            current.writer.writeUTF(mensaje);
                        }
                    break;
                    case 3:
                        int dado1 = (new Random()).nextInt(6)+1;
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
                        server.iniciarPartida();
                        
                        for (int i = 0; i < server.conexiones.size(); i++) {
                            ThreadServidor current = server.conexiones.get(i);
                            current.writer.writeInt(4);
                            
                        }
                    break;
                }
            } catch (IOException ex) {
                
            }
        }
    }
}
