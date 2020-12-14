package Cliente;

import java.awt.Color;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

// Interfaz grafica que le aparece a cada jugador, el diseno es un placeholder porque ocupamos poner el tablero y el historial (yo hago el historial)

public class InterfazCliente extends javax.swing.JFrame {

    public Cliente refCliente;
    private String nombreTurno = "";
    private String nombreJugador = "";
    /**
     * Creates new form ChatCliente
     */
    public InterfazCliente() {
        initComponents();
        lblDado1.setOpaque(true);
        lblDado2.setOpaque(true);
    }

    public void setRefCliente(Cliente refCliente) {
        this.refCliente = refCliente;
    }

    public void setNombreTurno(String nombreTurno) {
        this.nombreTurno = nombreTurno;
        lblTurno.setText("Es turno de: " + nombreTurno);
    }

    public void setNombreJugador(String nombreJugador){
        this.nombreJugador = nombreJugador;
        lblNombreJugador.setText(nombreJugador);
    }
    
    public void addMensaje(String msj)
    {
        txaMensajes.append(msj + "\n");
    }    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblDado2 = new javax.swing.JLabel();
        lblDado1 = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        btnLanzarDados = new javax.swing.JButton();
        lblUsuarioLanzamiento = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaMensajes = new javax.swing.JTextArea();
        txfMensaje = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        lblChat = new javax.swing.JLabel();
        lblHistorial = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaHistorial = new javax.swing.JTextArea();
        btnComprar = new javax.swing.JButton();
        btnEndTurn = new javax.swing.JButton();
        lblDinero = new javax.swing.JLabel();
        lblNombreJugador = new javax.swing.JLabel();
        lblNumHoteles = new javax.swing.JLabel();
        lblFicha = new javax.swing.JLabel();
        lblNumCasas = new javax.swing.JLabel();
        lblNumPropiedades = new javax.swing.JLabel();
        btnIntercambiar = new javax.swing.JButton();
        btnVender = new javax.swing.JButton();
        btnHipotecar = new javax.swing.JButton();
        lblStatusPartida = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblDado2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblDado2.setForeground(new java.awt.Color(255, 255, 255));
        lblDado2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblDado1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblDado1.setForeground(new java.awt.Color(255, 255, 255));
        lblDado1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTurno.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTurno.setText("Es turno de: ");

        btnLanzarDados.setText("Lanzar Dados");
        btnLanzarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLanzarDadosActionPerformed(evt);
            }
        });

        txaMensajes.setColumns(20);
        txaMensajes.setRows(5);
        jScrollPane1.setViewportView(txaMensajes);

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        lblChat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblChat.setText("Chat comunal");

        lblHistorial.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHistorial.setText("Historial");

        txaHistorial.setColumns(20);
        txaHistorial.setRows(5);
        jScrollPane2.setViewportView(txaHistorial);

        btnComprar.setText("Comprar propiedad/casa/hotel");

        btnEndTurn.setText("Terminar turno");

        lblDinero.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDinero.setText("Dinero:");

        lblNombreJugador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNombreJugador.setText("Su nombre es:");

        lblNumHoteles.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNumHoteles.setText("Numero de hoteles:");

        lblFicha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblFicha.setText("Ficha:");

        lblNumCasas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNumCasas.setText("Numero de casas:");

        lblNumPropiedades.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNumPropiedades.setText("Numero de propiedades:");

        btnIntercambiar.setText("Intercambiar");

        btnVender.setText("Vender");

        btnHipotecar.setText("Hipotecar/deshipotecar");

        lblStatusPartida.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStatusPartida.setText("Estado de partida: Esperando jugadores");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txfMensaje)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEnviar))
                            .addComponent(jScrollPane2))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDinero, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblFicha))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnComprar)
                                .addGap(18, 18, 18)
                                .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(lblUsuarioLanzamiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHipotecar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNumCasas, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNumHoteles, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNumPropiedades, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnIntercambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEndTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblHistorial)
                                .addGap(345, 345, 345))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblChat)
                                .addGap(321, 321, 321))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(lblNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblStatusPartida, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDado1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(lblDado2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnLanzarDados)
                        .addGap(120, 120, 120))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDado2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDado1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(lblStatusPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLanzarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)))
                .addComponent(lblChat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(lblHistorial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsuarioLanzamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDinero, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFicha)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNumCasas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNumHoteles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNumPropiedades, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIntercambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEndTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHipotecar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(810, 810, 810)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        try {
            // TODO add your handling code here:
            refCliente.hiloCliente.writer.writeInt(2);
            refCliente.hiloCliente.writer.writeUTF(txfMensaje.getText());
        } catch (IOException ex) {

        }

    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnLanzarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLanzarDadosActionPerformed
        try {

            if (nombreTurno.equals(this.getTitle())){
                // TODO add your handling code here:
                refCliente.hiloCliente.writer.writeInt(3);

                if (btnLanzarDados.isEnabled())
                btnLanzarDados.setEnabled(false);
            }
            else
            JOptionPane.showMessageDialog(this, "NO ES SU TURNO");

        } catch (IOException ex) {

        }
    }//GEN-LAST:event_btnLanzarDadosActionPerformed

    public JLabel getLblStatusPartida() {
        return lblStatusPartida;
    }

    public void setLblStatusPartida(JLabel lblStatusPartida) {
        this.lblStatusPartida = lblStatusPartida;
    }

    
    public void setInicioPartida(){
        lblStatusPartida.setText("Estado de partida: Iniciada");
        lblDinero.setText("Dinero: $" + refCliente.getHiloCliente().getDinero());
        lblNumCasas.setText("Numero de casas: " + 0);
        lblNumHoteles.setText("Numero de hoteles: " + 0);
        lblNumPropiedades.setText("Numero de propiedades: " + 0);
    }
    
    public void pintarLanzamientoDados (int valor1, int valor2, String usuario){        
        
        lblDado1.setText(valor1 + "");
        lblDado2.setText(valor2 + "");
        lblDado1.setBackground(Color.red);
        lblDado2.setBackground(Color.red);
        
        if (!btnLanzarDados.isEnabled())
            btnLanzarDados.setEnabled(true);
        
        lblUsuarioLanzamiento.setText(usuario);
    }
    
    
    public void pintarTurno(String turno){
        this.nombreTurno = turno;
        lblTurno.setText("Es turno de " + turno);
    }
    
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnEndTurn;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnHipotecar;
    private javax.swing.JButton btnIntercambiar;
    private javax.swing.JButton btnLanzarDados;
    private javax.swing.JButton btnVender;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblChat;
    private javax.swing.JLabel lblDado1;
    private javax.swing.JLabel lblDado2;
    private javax.swing.JLabel lblDinero;
    private javax.swing.JLabel lblFicha;
    private javax.swing.JLabel lblHistorial;
    private javax.swing.JLabel lblNombreJugador;
    private javax.swing.JLabel lblNumCasas;
    private javax.swing.JLabel lblNumHoteles;
    private javax.swing.JLabel lblNumPropiedades;
    private javax.swing.JLabel lblStatusPartida;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JLabel lblUsuarioLanzamiento;
    private javax.swing.JTextArea txaHistorial;
    private javax.swing.JTextArea txaMensajes;
    private javax.swing.JTextField txfMensaje;
    // End of variables declaration//GEN-END:variables
}
