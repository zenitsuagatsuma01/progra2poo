/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ThreadCliente extends Thread{
    
    private Socket socketRef;
    public DataInputStream reader;
    public DataOutputStream writer;
    private String nombre;
    private boolean running = true;
    private ChatCliente refPantalla;

    public ThreadCliente(Socket socketRef, ChatCliente refPantalla) throws IOException {
        this.socketRef = socketRef;
        reader = new DataInputStream(socketRef.getInputStream());
        writer = new DataOutputStream(socketRef.getOutputStream());
        this.refPantalla = refPantalla;
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
                        refPantalla.addMensaje(usuario+">   " + mensaje);
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
                    case 4: // pinta que inicio partida
                        refPantalla.setInicioPartida();
                    break;
                    
                    
                }
            } catch (IOException ex) {
                
            }
        }
    }
}
