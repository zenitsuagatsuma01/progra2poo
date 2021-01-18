package Cliente;

import Partida.FileManager;
import static Partida.MenuPrincipal.infoBox;
import Servidor.PantallaServidor;
import Servidor.Servidor;
import cartas.Calles;
import cartas.Propiedades;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

// Interfaz grafica que le aparece a cada jugador, el diseno es un placeholder porque ocupamos poner el tablero y el historial (yo hago el historial)

public class InterfazCliente extends javax.swing.JFrame implements Serializable{

    public Cliente refCliente;
    private String nombreTurno = "";            // Nombre del jugador cuyo turno es actualmente
    private String nombreJugador = "";          // Nombre del jugador
    /**
     * Creates new form ChatCliente
     */
    public InterfazCliente() {
        initComponents();
       // lblDado1.setOpaque(true);
       // lblDado2.setOpaque(true);
    }

    public Cliente getRefCliente() {
        return refCliente;
    }

    public JPanel getPnlTablero() {
        return pnlTablero;
    }

    public void setPnlTablero(JPanel pnlTablero) {
        this.pnlTablero = pnlTablero;
    }

    public JLabel getLblNombreJugador() {
        return lblNombreJugador;
    }

    public JPanel getLblGo() {
        return lblCasilla3;
    }

    public void setLblGo(JPanel lblGo) {
        this.lblCasilla3 = lblGo;
    }

    public JPanel getLblElMuelle4() {
        return lblCasilla7;
    }

    public void setLblElMuelle4(JPanel lblElMuelle4) {
        this.lblCasilla7 = lblElMuelle4;
    }

    public JLabel getLblAlquilerCasilla1() {
        return lblAlquilerCasilla1;
    }

    public void setLblAlquilerCasilla1(JLabel lblAlquilerCasilla1) {
        this.lblAlquilerCasilla1 = lblAlquilerCasilla1;
    }

    public JLabel getLblAlquilerCasilla11() {
        return lblAlquilerCasilla11;
    }

    public void setLblAlquilerCasilla11(JLabel lblAlquilerCasilla11) {
        this.lblAlquilerCasilla11 = lblAlquilerCasilla11;
    }

    public JLabel getLblAlquilerCasilla12() {
        return lblAlquilerCasilla12;
    }

    public void setLblAlquilerCasilla12(JLabel lblAlquilerCasilla12) {
        this.lblAlquilerCasilla12 = lblAlquilerCasilla12;
    }

    public JLabel getLblAlquilerCasilla13() {
        return lblAlquilerCasilla13;
    }

    public void setLblAlquilerCasilla13(JLabel lblAlquilerCasilla13) {
        this.lblAlquilerCasilla13 = lblAlquilerCasilla13;
    }

    public JLabel getLblAlquilerCasilla14() {
        return lblAlquilerCasilla14;
    }

    public void setLblAlquilerCasilla14(JLabel lblAlquilerCasilla14) {
        this.lblAlquilerCasilla14 = lblAlquilerCasilla14;
    }

    public JLabel getLblAlquilerCasilla15() {
        return lblAlquilerCasilla15;
    }

    public void setLblAlquilerCasilla15(JLabel lblAlquilerCasilla15) {
        this.lblAlquilerCasilla15 = lblAlquilerCasilla15;
    }

    public JLabel getLblAlquilerCasilla16() {
        return lblAlquilerCasilla16;
    }

    public void setLblAlquilerCasilla16(JLabel lblAlquilerCasilla16) {
        this.lblAlquilerCasilla16 = lblAlquilerCasilla16;
    }

    public JLabel getLblAlquilerCasilla18() {
        return lblAlquilerCasilla18;
    }

    public void setLblAlquilerCasilla18(JLabel lblAlquilerCasilla18) {
        this.lblAlquilerCasilla18 = lblAlquilerCasilla18;
    }

    public JLabel getLblAlquilerCasilla19() {
        return lblAlquilerCasilla19;
    }

    public void setLblAlquilerCasilla19(JLabel lblAlquilerCasilla19) {
        this.lblAlquilerCasilla19 = lblAlquilerCasilla19;
    }

    public JLabel getLblAlquilerCasilla21() {
        return lblAlquilerCasilla21;
    }

    public void setLblAlquilerCasilla21(JLabel lblAlquilerCasilla21) {
        this.lblAlquilerCasilla21 = lblAlquilerCasilla21;
    }

    public JLabel getLblAlquilerCasilla23() {
        return lblAlquilerCasilla23;
    }

    public void setLblAlquilerCasilla23(JLabel lblAlquilerCasilla23) {
        this.lblAlquilerCasilla23 = lblAlquilerCasilla23;
    }

    public JLabel getLblAlquilerCasilla24() {
        return lblAlquilerCasilla24;
    }

    public void setLblAlquilerCasilla24(JLabel lblAlquilerCasilla24) {
        this.lblAlquilerCasilla24 = lblAlquilerCasilla24;
    }

    public JLabel getLblAlquilerCasilla25() {
        return lblAlquilerCasilla25;
    }

    public void setLblAlquilerCasilla25(JLabel lblAlquilerCasilla25) {
        this.lblAlquilerCasilla25 = lblAlquilerCasilla25;
    }

    public JLabel getLblAlquilerCasilla26() {
        return lblAlquilerCasilla26;
    }

    public void setLblAlquilerCasilla26(JLabel lblAlquilerCasilla26) {
        this.lblAlquilerCasilla26 = lblAlquilerCasilla26;
    }

    public JLabel getLblAlquilerCasilla27() {
        return lblAlquilerCasilla27;
    }

    public void setLblAlquilerCasilla27(JLabel lblAlquilerCasilla27) {
        this.lblAlquilerCasilla27 = lblAlquilerCasilla27;
    }

    public JLabel getLblAlquilerCasilla28() {
        return lblAlquilerCasilla28;
    }

    public void setLblAlquilerCasilla28(JLabel lblAlquilerCasilla28) {
        this.lblAlquilerCasilla28 = lblAlquilerCasilla28;
    }

    public JLabel getLblAlquilerCasilla29() {
        return lblAlquilerCasilla29;
    }

    public void setLblAlquilerCasilla29(JLabel lblAlquilerCasilla29) {
        this.lblAlquilerCasilla29 = lblAlquilerCasilla29;
    }

    public JLabel getLblAlquilerCasilla3() {
        return lblAlquilerCasilla3;
    }

    public void setLblAlquilerCasilla3(JLabel lblAlquilerCasilla3) {
        this.lblAlquilerCasilla3 = lblAlquilerCasilla3;
    }

    public JLabel getLblAlquilerCasilla31() {
        return lblAlquilerCasilla31;
    }

    public void setLblAlquilerCasilla31(JLabel lblAlquilerCasilla31) {
        this.lblAlquilerCasilla31 = lblAlquilerCasilla31;
    }

    public JLabel getLblAlquilerCasilla32() {
        return lblAlquilerCasilla32;
    }

    public void setLblAlquilerCasilla32(JLabel lblAlquilerCasilla32) {
        this.lblAlquilerCasilla32 = lblAlquilerCasilla32;
    }

    public JLabel getLblAlquilerCasilla34() {
        return lblAlquilerCasilla34;
    }

    public void setLblAlquilerCasilla34(JLabel lblAlquilerCasilla34) {
        this.lblAlquilerCasilla34 = lblAlquilerCasilla34;
    }

    public JLabel getLblAlquilerCasilla35() {
        return lblAlquilerCasilla35;
    }

    public void setLblAlquilerCasilla35(JLabel lblAlquilerCasilla35) {
        this.lblAlquilerCasilla35 = lblAlquilerCasilla35;
    }

    public JLabel getLblAlquilerCasilla37() {
        return lblAlquilerCasilla37;
    }

    public void setLblAlquilerCasilla37(JLabel lblAlquilerCasilla37) {
        this.lblAlquilerCasilla37 = lblAlquilerCasilla37;
    }

    public JLabel getLblAlquilerCasilla39() {
        return lblAlquilerCasilla39;
    }

    public void setLblAlquilerCasilla39(JLabel lblAlquilerCasilla39) {
        this.lblAlquilerCasilla39 = lblAlquilerCasilla39;
    }

    public JLabel getLblAlquilerCasilla5() {
        return lblAlquilerCasilla5;
    }

    public void setLblAlquilerCasilla5(JLabel lblAlquilerCasilla5) {
        this.lblAlquilerCasilla5 = lblAlquilerCasilla5;
    }

    public JLabel getLblAlquilerCasilla6() {
        return lblAlquilerCasilla6;
    }

    public void setLblAlquilerCasilla6(JLabel lblAlquilerCasilla6) {
        this.lblAlquilerCasilla6 = lblAlquilerCasilla6;
    }

    public JLabel getLblAlquilerCasilla8() {
        return lblAlquilerCasilla8;
    }

    public void setLblAlquilerCasilla8(JLabel lblAlquilerCasilla8) {
        this.lblAlquilerCasilla8 = lblAlquilerCasilla8;
    }

    public JLabel getLblAlquilerCasilla9() {
        return lblAlquilerCasilla9;
    }

    public void setLblAlquilerCasilla9(JLabel lblAlquilerCasilla9) {
        this.lblAlquilerCasilla9 = lblAlquilerCasilla9;
    }

    public JLabel getLblArcaComunal() {
        return lblArcaComunal;
    }

    public void setLblArcaComunal(JLabel lblArcaComunal) {
        this.lblArcaComunal = lblArcaComunal;
    }

    public JLabel getLblCasasCasilla1() {
        return lblCasasCasilla1;
    }

    public void setLblCasasCasilla1(JLabel lblCasasCasilla1) {
        this.lblCasasCasilla1 = lblCasasCasilla1;
    }

    public JLabel getLblCasasCasilla11() {
        return lblCasasCasilla11;
    }

    public void setLblCasasCasilla11(JLabel lblCasasCasilla11) {
        this.lblCasasCasilla11 = lblCasasCasilla11;
    }

    public JLabel getLblCasasCasilla13() {
        return lblCasasCasilla13;
    }

    public void setLblCasasCasilla13(JLabel lblCasasCasilla13) {
        this.lblCasasCasilla13 = lblCasasCasilla13;
    }

    public JLabel getLblCasasCasilla14() {
        return lblCasasCasilla14;
    }

    public void setLblCasasCasilla14(JLabel lblCasasCasilla14) {
        this.lblCasasCasilla14 = lblCasasCasilla14;
    }

    public JLabel getLblCasasCasilla16() {
        return lblCasasCasilla16;
    }

    public void setLblCasasCasilla16(JLabel lblCasasCasilla16) {
        this.lblCasasCasilla16 = lblCasasCasilla16;
    }

    public JLabel getLblCasasCasilla18() {
        return lblCasasCasilla18;
    }

    public void setLblCasasCasilla18(JLabel lblCasasCasilla18) {
        this.lblCasasCasilla18 = lblCasasCasilla18;
    }

    public JLabel getLblCasasCasilla19() {
        return lblCasasCasilla19;
    }

    public void setLblCasasCasilla19(JLabel lblCasasCasilla19) {
        this.lblCasasCasilla19 = lblCasasCasilla19;
    }

    public JLabel getLblCasasCasilla21() {
        return lblCasasCasilla21;
    }

    public void setLblCasasCasilla21(JLabel lblCasasCasilla21) {
        this.lblCasasCasilla21 = lblCasasCasilla21;
    }

    public JLabel getLblCasasCasilla23() {
        return lblCasasCasilla23;
    }

    public void setLblCasasCasilla23(JLabel lblCasasCasilla23) {
        this.lblCasasCasilla23 = lblCasasCasilla23;
    }

    public JLabel getLblCasasCasilla24() {
        return lblCasasCasilla24;
    }

    public void setLblCasasCasilla24(JLabel lblCasasCasilla24) {
        this.lblCasasCasilla24 = lblCasasCasilla24;
    }

    public JLabel getLblCasasCasilla26() {
        return lblCasasCasilla26;
    }

    public void setLblCasasCasilla26(JLabel lblCasasCasilla26) {
        this.lblCasasCasilla26 = lblCasasCasilla26;
    }

    public JLabel getLblCasasCasilla27() {
        return lblCasasCasilla27;
    }

    public void setLblCasasCasilla27(JLabel lblCasasCasilla27) {
        this.lblCasasCasilla27 = lblCasasCasilla27;
    }

    public JLabel getLblCasasCasilla29() {
        return lblCasasCasilla29;
    }

    public void setLblCasasCasilla29(JLabel lblCasasCasilla29) {
        this.lblCasasCasilla29 = lblCasasCasilla29;
    }

    public JLabel getLblCasasCasilla3() {
        return lblCasasCasilla3;
    }

    public void setLblCasasCasilla3(JLabel lblCasasCasilla3) {
        this.lblCasasCasilla3 = lblCasasCasilla3;
    }

    public JLabel getLblCasasCasilla31() {
        return lblCasasCasilla31;
    }

    public void setLblCasasCasilla31(JLabel lblCasasCasilla31) {
        this.lblCasasCasilla31 = lblCasasCasilla31;
    }

    public JLabel getLblCasasCasilla32() {
        return lblCasasCasilla32;
    }

    public void setLblCasasCasilla32(JLabel lblCasasCasilla32) {
        this.lblCasasCasilla32 = lblCasasCasilla32;
    }

    public JLabel getLblCasasCasilla34() {
        return lblCasasCasilla34;
    }

    public void setLblCasasCasilla34(JLabel lblCasasCasilla34) {
        this.lblCasasCasilla34 = lblCasasCasilla34;
    }

    public JLabel getLblCasasCasilla37() {
        return lblCasasCasilla37;
    }

    public void setLblCasasCasilla37(JLabel lblCasasCasilla37) {
        this.lblCasasCasilla37 = lblCasasCasilla37;
    }

    public JLabel getLblCasasCasilla39() {
        return lblCasasCasilla39;
    }

    public void setLblCasasCasilla39(JLabel lblCasasCasilla39) {
        this.lblCasasCasilla39 = lblCasasCasilla39;
    }

    public JLabel getLblCasasCasilla6() {
        return lblCasasCasilla6;
    }

    public void setLblCasasCasilla6(JLabel lblCasasCasilla6) {
        this.lblCasasCasilla6 = lblCasasCasilla6;
    }

    public JLabel getLblCasasCasilla8() {
        return lblCasasCasilla8;
    }

    public void setLblCasasCasilla8(JLabel lblCasasCasilla8) {
        this.lblCasasCasilla8 = lblCasasCasilla8;
    }

    public JLabel getLblCasasCasilla9() {
        return lblCasasCasilla9;
    }

    public void setLblCasasCasilla9(JLabel lblCasasCasilla9) {
        this.lblCasasCasilla9 = lblCasasCasilla9;
    }

    public JLabel getLblChat() {
        return lblChat;
    }

    public void setLblChat(JLabel lblChat) {
        this.lblChat = lblChat;
    }

    public JLabel getLblConsultarJugador() {
        return lblConsultarJugador;
    }

    public void setLblConsultarJugador(JLabel lblConsultarJugador) {
        this.lblConsultarJugador = lblConsultarJugador;
    }

    public JLabel getLblConsultarPropiedades() {
        return lblConsultarPropiedades;
    }

    public void setLblConsultarPropiedades(JLabel lblConsultarPropiedades) {
        this.lblConsultarPropiedades = lblConsultarPropiedades;
    }

    public JLabel getLblDado2() {
        return lblDado2;
    }

    public void setLblDado2(JLabel lblDado2) {
        this.lblDado2 = lblDado2;
    }

    public JLabel getLblDinero() {
        return lblDinero;
    }

    public void setLblDinero(JLabel lblDinero) {
        this.lblDinero = lblDinero;
    }

    public JLabel getLblFicha() {
        return lblFicha;
    }

    public void setLblFicha(JLabel lblFicha) {
        this.lblFicha = lblFicha;
    }

    public JLabel getLblFortuna() {
        return lblFortuna;
    }

    public void setLblFortuna(JLabel lblFortuna) {
        this.lblFortuna = lblFortuna;
    }

    public JLabel getLblHistorial() {
        return lblHistorial;
    }

    public void setLblHistorial(JLabel lblHistorial) {
        this.lblHistorial = lblHistorial;
    }

    public JLabel getLblHotelCasillas1() {
        return lblHotelCasillas1;
    }

    public void setLblHotelCasillas1(JLabel lblHotelCasillas1) {
        this.lblHotelCasillas1 = lblHotelCasillas1;
    }

    public JLabel getLblHotelCasillas11() {
        return lblHotelCasillas11;
    }

    public void setLblHotelCasillas11(JLabel lblHotelCasillas11) {
        this.lblHotelCasillas11 = lblHotelCasillas11;
    }

    public JLabel getLblHotelCasillas13() {
        return lblHotelCasillas13;
    }

    public void setLblHotelCasillas13(JLabel lblHotelCasillas13) {
        this.lblHotelCasillas13 = lblHotelCasillas13;
    }

    public JLabel getLblHotelCasillas14() {
        return lblHotelCasillas14;
    }

    public void setLblHotelCasillas14(JLabel lblHotelCasillas14) {
        this.lblHotelCasillas14 = lblHotelCasillas14;
    }

    public JLabel getLblHotelCasillas16() {
        return lblHotelCasillas16;
    }

    public void setLblHotelCasillas16(JLabel lblHotelCasillas16) {
        this.lblHotelCasillas16 = lblHotelCasillas16;
    }

    public JLabel getLblHotelCasillas18() {
        return lblHotelCasillas18;
    }

    public void setLblHotelCasillas18(JLabel lblHotelCasillas18) {
        this.lblHotelCasillas18 = lblHotelCasillas18;
    }

    public JLabel getLblHotelCasillas19() {
        return lblHotelCasillas19;
    }

    public void setLblHotelCasillas19(JLabel lblHotelCasillas19) {
        this.lblHotelCasillas19 = lblHotelCasillas19;
    }

    public JLabel getLblHotelCasillas21() {
        return lblHotelCasillas21;
    }

    public void setLblHotelCasillas21(JLabel lblHotelCasillas21) {
        this.lblHotelCasillas21 = lblHotelCasillas21;
    }

    public JLabel getLblHotelCasillas23() {
        return lblHotelCasillas23;
    }

    public void setLblHotelCasillas23(JLabel lblHotelCasillas23) {
        this.lblHotelCasillas23 = lblHotelCasillas23;
    }

    public JLabel getLblHotelCasillas24() {
        return lblHotelCasillas24;
    }

    public void setLblHotelCasillas24(JLabel lblHotelCasillas24) {
        this.lblHotelCasillas24 = lblHotelCasillas24;
    }

    public JLabel getLblHotelCasillas26() {
        return lblHotelCasillas26;
    }

    public void setLblHotelCasillas26(JLabel lblHotelCasillas26) {
        this.lblHotelCasillas26 = lblHotelCasillas26;
    }

    public JLabel getLblHotelCasillas27() {
        return lblHotelCasillas27;
    }

    public void setLblHotelCasillas27(JLabel lblHotelCasillas27) {
        this.lblHotelCasillas27 = lblHotelCasillas27;
    }

    public JLabel getLblHotelCasillas29() {
        return lblHotelCasillas29;
    }

    public void setLblHotelCasillas29(JLabel lblHotelCasillas29) {
        this.lblHotelCasillas29 = lblHotelCasillas29;
    }

    public JLabel getLblHotelCasillas3() {
        return lblHotelCasillas3;
    }

    public void setLblHotelCasillas3(JLabel lblHotelCasillas3) {
        this.lblHotelCasillas3 = lblHotelCasillas3;
    }

    public JLabel getLblHotelCasillas31() {
        return lblHotelCasillas31;
    }

    public void setLblHotelCasillas31(JLabel lblHotelCasillas31) {
        this.lblHotelCasillas31 = lblHotelCasillas31;
    }

    public JLabel getLblHotelCasillas32() {
        return lblHotelCasillas32;
    }

    public void setLblHotelCasillas32(JLabel lblHotelCasillas32) {
        this.lblHotelCasillas32 = lblHotelCasillas32;
    }

    public JLabel getLblHotelCasillas34() {
        return lblHotelCasillas34;
    }

    public void setLblHotelCasillas34(JLabel lblHotelCasillas34) {
        this.lblHotelCasillas34 = lblHotelCasillas34;
    }

    public JLabel getLblHotelCasillas37() {
        return lblHotelCasillas37;
    }

    public void setLblHotelCasillas37(JLabel lblHotelCasillas37) {
        this.lblHotelCasillas37 = lblHotelCasillas37;
    }

    public JLabel getLblHotelCasillas39() {
        return lblHotelCasillas39;
    }

    public void setLblHotelCasillas39(JLabel lblHotelCasillas39) {
        this.lblHotelCasillas39 = lblHotelCasillas39;
    }

    public JLabel getLblHotelCasillas6() {
        return lblHotelCasillas6;
    }

    public void setLblHotelCasillas6(JLabel lblHotelCasillas6) {
        this.lblHotelCasillas6 = lblHotelCasillas6;
    }

    public JLabel getLblHotelCasillas8() {
        return lblHotelCasillas8;
    }

    public void setLblHotelCasillas8(JLabel lblHotelCasillas8) {
        this.lblHotelCasillas8 = lblHotelCasillas8;
    }

    public JLabel getLblHotelCasillas9() {
        return lblHotelCasillas9;
    }

    public void setLblHotelCasillas9(JLabel lblHotelCasillas9) {
        this.lblHotelCasillas9 = lblHotelCasillas9;
    }

    public JLabel getLblLibreCasilla1() {
        return lblLibreCasilla1;
    }

    public void setLblLibreCasilla1(JLabel lblLibreCasilla1) {
        this.lblLibreCasilla1 = lblLibreCasilla1;
    }

    public JLabel getLblLibreCasilla11() {
        return lblLibreCasilla11;
    }

    public void setLblLibreCasilla11(JLabel lblLibreCasilla11) {
        this.lblLibreCasilla11 = lblLibreCasilla11;
    }

    public JLabel getLblLibreCasilla12() {
        return lblLibreCasilla12;
    }

    public void setLblLibreCasilla12(JLabel lblLibreCasilla12) {
        this.lblLibreCasilla12 = lblLibreCasilla12;
    }

    public JLabel getLblLibreCasilla13() {
        return lblLibreCasilla13;
    }

    public void setLblLibreCasilla13(JLabel lblLibreCasilla13) {
        this.lblLibreCasilla13 = lblLibreCasilla13;
    }

    public JLabel getLblLibreCasilla14() {
        return lblLibreCasilla14;
    }

    public void setLblLibreCasilla14(JLabel lblLibreCasilla14) {
        this.lblLibreCasilla14 = lblLibreCasilla14;
    }

    public JLabel getLblLibreCasilla15() {
        return lblLibreCasilla15;
    }

    public void setLblLibreCasilla15(JLabel lblLibreCasilla15) {
        this.lblLibreCasilla15 = lblLibreCasilla15;
    }

    public JLabel getLblLibreCasilla16() {
        return lblLibreCasilla16;
    }

    public void setLblLibreCasilla16(JLabel lblLibreCasilla16) {
        this.lblLibreCasilla16 = lblLibreCasilla16;
    }

    public JLabel getLblLibreCasilla18() {
        return lblLibreCasilla18;
    }

    public void setLblLibreCasilla18(JLabel lblLibreCasilla18) {
        this.lblLibreCasilla18 = lblLibreCasilla18;
    }

    public JLabel getLblLibreCasilla19() {
        return lblLibreCasilla19;
    }

    public void setLblLibreCasilla19(JLabel lblLibreCasilla19) {
        this.lblLibreCasilla19 = lblLibreCasilla19;
    }

    public JLabel getLblLibreCasilla21() {
        return lblLibreCasilla21;
    }

    public void setLblLibreCasilla21(JLabel lblLibreCasilla21) {
        this.lblLibreCasilla21 = lblLibreCasilla21;
    }

    public JLabel getLblLibreCasilla23() {
        return lblLibreCasilla23;
    }

    public void setLblLibreCasilla23(JLabel lblLibreCasilla23) {
        this.lblLibreCasilla23 = lblLibreCasilla23;
    }

    public JLabel getLblLibreCasilla24() {
        return lblLibreCasilla24;
    }

    public void setLblLibreCasilla24(JLabel lblLibreCasilla24) {
        this.lblLibreCasilla24 = lblLibreCasilla24;
    }

    public JLabel getLblLibreCasilla25() {
        return lblLibreCasilla25;
    }

    public void setLblLibreCasilla25(JLabel lblLibreCasilla25) {
        this.lblLibreCasilla25 = lblLibreCasilla25;
    }

    public JLabel getLblLibreCasilla26() {
        return lblLibreCasilla26;
    }

    public void setLblLibreCasilla26(JLabel lblLibreCasilla26) {
        this.lblLibreCasilla26 = lblLibreCasilla26;
    }

    public JLabel getLblLibreCasilla27() {
        return lblLibreCasilla27;
    }

    public void setLblLibreCasilla27(JLabel lblLibreCasilla27) {
        this.lblLibreCasilla27 = lblLibreCasilla27;
    }

    public JLabel getLblLibreCasilla28() {
        return lblLibreCasilla28;
    }

    public void setLblLibreCasilla28(JLabel lblLibreCasilla28) {
        this.lblLibreCasilla28 = lblLibreCasilla28;
    }

    public JLabel getLblLibreCasilla29() {
        return lblLibreCasilla29;
    }

    public void setLblLibreCasilla29(JLabel lblLibreCasilla29) {
        this.lblLibreCasilla29 = lblLibreCasilla29;
    }

    public JLabel getLblLibreCasilla3() {
        return lblLibreCasilla3;
    }

    public void setLblLibreCasilla3(JLabel lblLibreCasilla3) {
        this.lblLibreCasilla3 = lblLibreCasilla3;
    }

    public JLabel getLblLibreCasilla31() {
        return lblLibreCasilla31;
    }

    public void setLblLibreCasilla31(JLabel lblLibreCasilla31) {
        this.lblLibreCasilla31 = lblLibreCasilla31;
    }

    public JLabel getLblLibreCasilla32() {
        return lblLibreCasilla32;
    }

    public void setLblLibreCasilla32(JLabel lblLibreCasilla32) {
        this.lblLibreCasilla32 = lblLibreCasilla32;
    }

    public JLabel getLblLibreCasilla34() {
        return lblLibreCasilla34;
    }

    public void setLblLibreCasilla34(JLabel lblLibreCasilla34) {
        this.lblLibreCasilla34 = lblLibreCasilla34;
    }

    public JLabel getLblLibreCasilla35() {
        return lblLibreCasilla35;
    }

    public void setLblLibreCasilla35(JLabel lblLibreCasilla35) {
        this.lblLibreCasilla35 = lblLibreCasilla35;
    }

    public JLabel getLblLibreCasilla37() {
        return lblLibreCasilla37;
    }

    public void setLblLibreCasilla37(JLabel lblLibreCasilla37) {
        this.lblLibreCasilla37 = lblLibreCasilla37;
    }

    public JLabel getLblLibreCasilla39() {
        return lblLibreCasilla39;
    }

    public void setLblLibreCasilla39(JLabel lblLibreCasilla39) {
        this.lblLibreCasilla39 = lblLibreCasilla39;
    }

    public JLabel getLblLibreCasilla5() {
        return lblLibreCasilla5;
    }

    public void setLblLibreCasilla5(JLabel lblLibreCasilla5) {
        this.lblLibreCasilla5 = lblLibreCasilla5;
    }

    public JLabel getLblLibreCasilla6() {
        return lblLibreCasilla6;
    }

    public void setLblLibreCasilla6(JLabel lblLibreCasilla6) {
        this.lblLibreCasilla6 = lblLibreCasilla6;
    }

    public JLabel getLblLibreCasilla8() {
        return lblLibreCasilla8;
    }

    public void setLblLibreCasilla8(JLabel lblLibreCasilla8) {
        this.lblLibreCasilla8 = lblLibreCasilla8;
    }

    public JLabel getLblLibreCasilla9() {
        return lblLibreCasilla9;
    }

    public void setLblLibreCasilla9(JLabel lblLibreCasilla9) {
        this.lblLibreCasilla9 = lblLibreCasilla9;
    }

    public JLabel getLblNothing() {
        return lblNothing;
    }

    public void setLblNothing(JLabel lblNothing) {
        this.lblNothing = lblNothing;
    }

    
    
    public JPanel getLblElMuelle() {
        return lblCasilla24;
    }

    public void setLblElMuelle(JPanel lblElMuelle) {
        this.lblCasilla24 = lblElMuelle;
    }
    
   
    
    public JPanel getPnlToolbar() {
        return pnlToolbar;
    }

    public void setPnlToolbar(JPanel pnlToolbar) {
        this.pnlToolbar = pnlToolbar;
    }

    
    
    public void setLblNombreJugador(JLabel lblNombreJugador) {
        this.lblNombreJugador = lblNombreJugador;
    }

    

    public void setRefCliente(Cliente refCliente) {
        this.refCliente = refCliente;
    }

    public void setNombreTurno(String nombreTurno) {
        this.nombreTurno = nombreTurno;
        lblTurno.setText(nombreTurno);
    }

    public void setNombreJugador(String nombreJugador){
        this.nombreJugador = nombreJugador;
        lblNombreJugador.setText(nombreJugador);
    }

    public String getNombreJugador() {
        return nombreJugador;
    }
    
    
    
    public void addMensaje(String msj)              // Para agregar un mensaje en la interfaz del cliente
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
        lblTurno = new javax.swing.JLabel();
        lblUsuarioLanzamiento = new javax.swing.JLabel();
        lblHistorial = new javax.swing.JLabel();
        lblChat = new javax.swing.JLabel();
        txfMensaje = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        lblTurnoDe = new javax.swing.JLabel();
        lblNombreJugador = new javax.swing.JLabel();
        lblFicha = new javax.swing.JLabel();
        lblNumDinero = new javax.swing.JLabel();
        lblStatusPartida = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaHistorial = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaMensajes = new javax.swing.JTextArea();
        lblDinero = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pnlFicha = new javax.swing.JPanel();
        lblFichaJugador = new javax.swing.JLabel();
        lblQuedanCasas = new javax.swing.JLabel();
        lblQuedanHoteles = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnlTablero = new javax.swing.JPanel();
        jPanel70 = new javax.swing.JPanel();
        lblCasilla1 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblCasilla3 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCasilla4 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        lblCasilla5 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCasilla6 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        lblCasilla7 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jPanel77 = new javax.swing.JPanel();
        lblCasilla24 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblCasilla11 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        lblCasilla12 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        lblCasilla10 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        lblCasilla2 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCasilla19 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        lblCasilla9 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        lblCasilla13 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblCasilla14 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        lblCasilla15 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        lblCasilla16 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        lblCasilla17 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        lblCasilla21 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblCasilla18 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        lblCasilla36 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        lblCasilla20 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        lblCasilla22 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        lblCasilla23 = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jPanel116 = new javax.swing.JPanel();
        lblCasilla29 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        lblCasilla25 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jPanel113 = new javax.swing.JPanel();
        lblCasilla34 = new javax.swing.JPanel();
        jLabel105 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel118 = new javax.swing.JPanel();
        jPanel109 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblCasilla32 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        lblCasilla28 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        lblCasilla30 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        lblCasilla31 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        lblCasilla27 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        lblCasilla33 = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        lblCasilla39 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        lblCasilla26 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        lblCasilla38 = new javax.swing.JPanel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        lblCasilla35 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblCasilla37 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        lblCasilla40 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lblCasilla8 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlArcaComunal = new javax.swing.JPanel();
        lblArcaComunal = new javax.swing.JLabel();
        pnlLogoMonopoly = new javax.swing.JPanel();
        lblLogoMonopoly = new javax.swing.JLabel();
        pnlFortuna = new javax.swing.JPanel();
        lblFortuna = new javax.swing.JLabel();
        lblLibreCasilla1 = new javax.swing.JLabel();
        lblAlquilerCasilla1 = new javax.swing.JLabel();
        lblCasasCasilla1 = new javax.swing.JLabel();
        lblHotelCasillas1 = new javax.swing.JLabel();
        lblLibreCasilla3 = new javax.swing.JLabel();
        lblAlquilerCasilla3 = new javax.swing.JLabel();
        lblCasasCasilla3 = new javax.swing.JLabel();
        lblHotelCasillas3 = new javax.swing.JLabel();
        lblLibreCasilla6 = new javax.swing.JLabel();
        lblAlquilerCasilla6 = new javax.swing.JLabel();
        lblCasasCasilla6 = new javax.swing.JLabel();
        lblHotelCasillas6 = new javax.swing.JLabel();
        lblLibreCasilla5 = new javax.swing.JLabel();
        lblAlquilerCasilla5 = new javax.swing.JLabel();
        lblLibreCasilla37 = new javax.swing.JLabel();
        lblAlquilerCasilla37 = new javax.swing.JLabel();
        lblCasasCasilla37 = new javax.swing.JLabel();
        lblHotelCasillas37 = new javax.swing.JLabel();
        lblLibreCasilla39 = new javax.swing.JLabel();
        lblAlquilerCasilla39 = new javax.swing.JLabel();
        lblCasasCasilla39 = new javax.swing.JLabel();
        lblHotelCasillas39 = new javax.swing.JLabel();
        lblLibreCasilla8 = new javax.swing.JLabel();
        lblAlquilerCasilla8 = new javax.swing.JLabel();
        lblCasasCasilla8 = new javax.swing.JLabel();
        lblHotelCasillas8 = new javax.swing.JLabel();
        lblLibreCasilla9 = new javax.swing.JLabel();
        lblAlquilerCasilla9 = new javax.swing.JLabel();
        lblCasasCasilla9 = new javax.swing.JLabel();
        lblHotelCasillas9 = new javax.swing.JLabel();
        lblLibreCasilla11 = new javax.swing.JLabel();
        lblAlquilerCasilla11 = new javax.swing.JLabel();
        lblCasasCasilla11 = new javax.swing.JLabel();
        lblHotelCasillas11 = new javax.swing.JLabel();
        lblLibreCasilla12 = new javax.swing.JLabel();
        lblAlquilerCasilla12 = new javax.swing.JLabel();
        lblLibreCasilla13 = new javax.swing.JLabel();
        lblCasasCasilla13 = new javax.swing.JLabel();
        lblAlquilerCasilla13 = new javax.swing.JLabel();
        lblHotelCasillas13 = new javax.swing.JLabel();
        lblLibreCasilla14 = new javax.swing.JLabel();
        lblAlquilerCasilla14 = new javax.swing.JLabel();
        lblHotelCasillas14 = new javax.swing.JLabel();
        lblLibreCasilla15 = new javax.swing.JLabel();
        lblAlquilerCasilla15 = new javax.swing.JLabel();
        lblLibreCasilla16 = new javax.swing.JLabel();
        lblCasasCasilla16 = new javax.swing.JLabel();
        lblAlquilerCasilla16 = new javax.swing.JLabel();
        lblHotelCasillas16 = new javax.swing.JLabel();
        lblLibreCasilla18 = new javax.swing.JLabel();
        lblCasasCasilla18 = new javax.swing.JLabel();
        lblAlquilerCasilla18 = new javax.swing.JLabel();
        lblHotelCasillas18 = new javax.swing.JLabel();
        lblLibreCasilla19 = new javax.swing.JLabel();
        lblCasasCasilla19 = new javax.swing.JLabel();
        lblAlquilerCasilla19 = new javax.swing.JLabel();
        lblHotelCasillas19 = new javax.swing.JLabel();
        lblLibreCasilla21 = new javax.swing.JLabel();
        lblCasasCasilla21 = new javax.swing.JLabel();
        lblAlquilerCasilla21 = new javax.swing.JLabel();
        lblHotelCasillas21 = new javax.swing.JLabel();
        lblLibreCasilla23 = new javax.swing.JLabel();
        lblCasasCasilla23 = new javax.swing.JLabel();
        lblAlquilerCasilla23 = new javax.swing.JLabel();
        lblHotelCasillas23 = new javax.swing.JLabel();
        lblLibreCasilla24 = new javax.swing.JLabel();
        lblCasasCasilla24 = new javax.swing.JLabel();
        lblAlquilerCasilla24 = new javax.swing.JLabel();
        lblHotelCasillas24 = new javax.swing.JLabel();
        lblLibreCasilla25 = new javax.swing.JLabel();
        lblAlquilerCasilla25 = new javax.swing.JLabel();
        lblLibreCasilla35 = new javax.swing.JLabel();
        lblAlquilerCasilla35 = new javax.swing.JLabel();
        lblLibreCasilla34 = new javax.swing.JLabel();
        lblAlquilerCasilla34 = new javax.swing.JLabel();
        lblCasasCasilla34 = new javax.swing.JLabel();
        lblHotelCasillas34 = new javax.swing.JLabel();
        lblLibreCasilla32 = new javax.swing.JLabel();
        lblAlquilerCasilla32 = new javax.swing.JLabel();
        lblCasasCasilla32 = new javax.swing.JLabel();
        lblHotelCasillas32 = new javax.swing.JLabel();
        lblLibreCasilla26 = new javax.swing.JLabel();
        lblAlquilerCasilla26 = new javax.swing.JLabel();
        lblCasasCasilla26 = new javax.swing.JLabel();
        lblHotelCasillas26 = new javax.swing.JLabel();
        lblLibreCasilla27 = new javax.swing.JLabel();
        lblAlquilerCasilla27 = new javax.swing.JLabel();
        lblCasasCasilla27 = new javax.swing.JLabel();
        lblHotelCasillas27 = new javax.swing.JLabel();
        lblLibreCasilla28 = new javax.swing.JLabel();
        lblAlquilerCasilla28 = new javax.swing.JLabel();
        lblLibreCasilla29 = new javax.swing.JLabel();
        lblAlquilerCasilla29 = new javax.swing.JLabel();
        lblCasasCasilla29 = new javax.swing.JLabel();
        lblHotelCasillas29 = new javax.swing.JLabel();
        lblLibreCasilla31 = new javax.swing.JLabel();
        lblAlquilerCasilla31 = new javax.swing.JLabel();
        lblCasasCasilla31 = new javax.swing.JLabel();
        lblHotelCasillas31 = new javax.swing.JLabel();
        lblNothing = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblCasasCasilla14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        pnlToolbar = new javax.swing.JPanel();
        btnVenderProp = new javax.swing.JButton();
        btnComprarPropActual = new javax.swing.JButton();
        btnLanzarDados = new javax.swing.JButton();
        btnHipotecar = new javax.swing.JButton();
        btnEndTurn = new javax.swing.JButton();
        lblSeleccionFicha = new javax.swing.JLabel();
        cbSeleccion = new javax.swing.JComboBox<>();
        btnSeleccionFicha = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        lblDado2 = new javax.swing.JLabel();
        cbPropiedades = new javax.swing.JComboBox<>();
        lblAdministrar = new javax.swing.JLabel();
        btnCompraCasa = new javax.swing.JButton();
        btnVenderCasa = new javax.swing.JButton();
        btnCompraHotel = new javax.swing.JButton();
        pnlTituloPropiedad = new javax.swing.JPanel();
        lblCadaHotelCuesta = new javax.swing.JLabel();
        lblCadaCasaCuesta = new javax.swing.JLabel();
        lblHipotecaTitulo = new javax.swing.JLabel();
        lblConHotel = new javax.swing.JLabel();
        lblCon4Casas = new javax.swing.JLabel();
        lblCon3Casas = new javax.swing.JLabel();
        lblCon2Casas = new javax.swing.JLabel();
        lblCon1Casa = new javax.swing.JLabel();
        lblAlquileresTitulo = new javax.swing.JLabel();
        btnConsultarDerecha = new javax.swing.JButton();
        btnConsultarIzquierda = new javax.swing.JButton();
        cbConsultarPropiedades = new javax.swing.JComboBox<>();
        lblConsultarPropiedades = new javax.swing.JLabel();
        lblConsultarJugador = new javax.swing.JLabel();
        btnConsultarPropiedad = new javax.swing.JButton();
        pnlColorTituloPropiedad = new javax.swing.JPanel();
        lblTituloDePropiedad = new javax.swing.JLabel();
        lblNombreTituloPropiedad = new javax.swing.JLabel();
        btnAbrirServer = new javax.swing.JButton();
        btnConectarse = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblNumDado2 = new javax.swing.JLabel();
        btnVenderHotel = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lblConexion = new javax.swing.JLabel();
        lblNumDado1 = new javax.swing.JLabel();
        lblCarcel = new javax.swing.JLabel();
        btnLiberadoCarcel = new javax.swing.JButton();
        getOutOfJailFree = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        lblGetOutOfJailFree = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTurno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTurno.setText("nadie");
        jPanel1.add(lblTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 90, 40));
        jPanel1.add(lblUsuarioLanzamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 735, -1, 68));

        lblHistorial.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHistorial.setText("Historial");
        jPanel1.add(lblHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, -1, -1));

        lblChat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblChat.setText("Chat comunal");
        jPanel1.add(lblChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 690, -1, -1));

        txfMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfMensajeActionPerformed(evt);
            }
        });
        jPanel1.add(txfMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 890, 310, 70));

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 890, 70, 70));

        lblTurnoDe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTurnoDe.setText("Es turno de:");
        jPanel1.add(lblTurnoDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        lblNombreJugador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombreJugador.setText("Sin nombre...");
        jPanel1.add(lblNombreJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 100, 30));

        lblFicha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFicha.setText("Ficha:");
        jPanel1.add(lblFicha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 70, -1));

        lblNumDinero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNumDinero.setText("0 $");
        jPanel1.add(lblNumDinero, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 120, 40));

        lblStatusPartida.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStatusPartida.setText("Esperando para iniciar...");
        jPanel1.add(lblStatusPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 160, 30));

        txaHistorial.setColumns(20);
        txaHistorial.setRows(5);
        jScrollPane2.setViewportView(txaHistorial);

        jScrollPane3.setViewportView(jScrollPane2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 380, 230));

        txaMensajes.setColumns(20);
        txaMensajes.setRows(5);
        jScrollPane1.setViewportView(txaMensajes);

        jScrollPane4.setViewportView(jScrollPane1);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 710, 380, 180));

        lblDinero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDinero.setText("Dinero:");
        jPanel1.add(lblDinero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, 20));

        ImageIcon logoImage = new ImageIcon("src/Imagenes/logosmall.png");
        lblLogo.setIcon(logoImage);
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 350, 130));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Nombre:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 209, -1, 30));

        javax.swing.GroupLayout pnlFichaLayout = new javax.swing.GroupLayout(pnlFicha);
        pnlFicha.setLayout(pnlFichaLayout);
        pnlFichaLayout.setHorizontalGroup(
            pnlFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFichaJugador, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        pnlFichaLayout.setVerticalGroup(
            pnlFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFichaJugador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        jPanel1.add(pnlFicha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 110, 120));

        lblQuedanCasas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblQuedanCasas.setText("Quedan 32 casas");
        jPanel1.add(lblQuedanCasas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 170, -1));

        lblQuedanHoteles.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblQuedanHoteles.setText("Quedan 12 hoteles");
        jPanel1.add(lblQuedanHoteles, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 170, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 0, 400, 1000));

        jPanel2.setLayout(new javax.swing.OverlayLayout(jPanel2));

        pnlTablero.setBackground(new java.awt.Color(255, 255, 255));
        pnlTablero.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        pnlTablero.setLayout(null);

        jPanel70.setBackground(new java.awt.Color(0, 0, 153));
        jPanel70.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel70);
        jPanel70.setBounds(1230, 530, 20, 60);

        lblCasilla1.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla1.setLayout(new javax.swing.OverlayLayout(lblCasilla1));

        jLabel59.setText("<== GO");
        jLabel59.setAlignmentY(1.0F);
        lblCasilla1.add(jLabel59);

        jLabel1.setText("COBRE $200");
        jLabel1.setAlignmentY(0.0F);
        lblCasilla1.add(jLabel1);

        pnlTablero.add(lblCasilla1);
        lblCasilla1.setBounds(1230, 590, 140, 70);

        lblCasilla3.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla3.setLayout(new javax.swing.OverlayLayout(lblCasilla3));

        jLabel47.setText("IMPUESTOS");
        jLabel47.setAlignmentX(0.5F);
        jLabel47.setAlignmentY(1.0F);
        lblCasilla3.add(jLabel47);

        jLabel3.setText("$100");
        jLabel3.setAlignmentX(0.5F);
        jLabel3.setAlignmentY(0.0F);
        lblCasilla3.add(jLabel3);

        pnlTablero.add(lblCasilla3);
        lblCasilla3.setBounds(1228, 470, 140, 60);

        lblCasilla4.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla4.setLayout(new javax.swing.OverlayLayout(lblCasilla4));

        jLabel60.setText("PLAZA PARK");
        jLabel60.setAlignmentY(1.0F);
        lblCasilla4.add(jLabel60);

        jLabel4.setText("$350");
        jLabel4.setAlignmentY(0.0F);
        lblCasilla4.add(jLabel4);

        pnlTablero.add(lblCasilla4);
        lblCasilla4.setBounds(1250, 400, 118, 70);

        jPanel72.setBackground(new java.awt.Color(0, 0, 153));
        jPanel72.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel72);
        jPanel72.setBounds(1230, 400, 20, 70);

        lblCasilla5.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla5.setLayout(new javax.swing.OverlayLayout(lblCasilla5));

        jLabel61.setText("FORTUNA");
        jLabel61.setAlignmentX(1.0F);
        jLabel61.setAlignmentY(1.0F);
        lblCasilla5.add(jLabel61);

        jLabel5.setText("(SACAR CARTA)");
        jLabel5.setAlignmentX(1.0F);
        jLabel5.setAlignmentY(0.0F);
        lblCasilla5.add(jLabel5);

        pnlTablero.add(lblCasilla5);
        lblCasilla5.setBounds(1228, 340, 140, 60);

        lblCasilla6.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla6.setLayout(new javax.swing.OverlayLayout(lblCasilla6));

        jLabel62.setText("FERROCARRIL");
        jLabel62.setAlignmentY(1.0F);
        lblCasilla6.add(jLabel62);

        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("$200");
        jLabel82.setAlignmentX(0.1F);
        jLabel82.setAlignmentY(0.1F);
        lblCasilla6.add(jLabel82);

        pnlTablero.add(lblCasilla6);
        lblCasilla6.setBounds(1228, 280, 140, 60);

        lblCasilla7.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla7.setLayout(new javax.swing.OverlayLayout(lblCasilla7));

        jLabel63.setText("AV. PENSILVANIA");
        jLabel63.setAlignmentY(1.0F);
        lblCasilla7.add(jLabel63);

        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("$320");
        jLabel83.setAlignmentX(0.1F);
        jLabel83.setAlignmentY(0.1F);
        lblCasilla7.add(jLabel83);

        pnlTablero.add(lblCasilla7);
        lblCasilla7.setBounds(1250, 220, 118, 60);

        jPanel77.setBackground(new java.awt.Color(0, 153, 0));
        jPanel77.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel77);
        jPanel77.setBounds(1230, 220, 20, 60);

        lblCasilla24.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla24.setLayout(new javax.swing.OverlayLayout(lblCasilla24));

        jLabel58.setText("ARCA");
        jLabel58.setAlignmentY(1.0F);
        lblCasilla24.add(jLabel58);

        jLabel10.setText("COMUNAL");
        jLabel10.setAlignmentY(0.0F);
        lblCasilla24.add(jLabel10);

        pnlTablero.add(lblCasilla24);
        lblCasilla24.setBounds(10, 180, 170, 50);

        lblCasilla11.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla11.setLayout(new javax.swing.OverlayLayout(lblCasilla11));

        jLabel64.setText("VAYA A");
        jLabel64.setAlignmentY(1.0F);
        lblCasilla11.add(jLabel64);

        jLabel7.setText("LA CÁRCEL");
        jLabel7.setAlignmentY(0.0F);
        lblCasilla11.add(jLabel7);

        pnlTablero.add(lblCasilla11);
        lblCasilla11.setBounds(1248, 0, 120, 60);

        jPanel38.setBackground(new java.awt.Color(0, 153, 0));
        jPanel38.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel38);
        jPanel38.setBounds(1230, 110, 20, 60);

        jPanel36.setBackground(new java.awt.Color(0, 153, 0));
        jPanel36.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel36);
        jPanel36.setBounds(1230, 60, 20, 50);

        lblCasilla12.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla12.setLayout(new javax.swing.OverlayLayout(lblCasilla12));

        jLabel70.setText("JARDINES MARVIN");
        jLabel70.setAlignmentY(1.0F);
        lblCasilla12.add(jLabel70);

        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("$280");
        jLabel84.setAlignmentX(0.1F);
        jLabel84.setAlignmentY(0.1F);
        lblCasilla12.add(jLabel84);

        pnlTablero.add(lblCasilla12);
        lblCasilla12.setBounds(1130, 0, 118, 50);

        lblCasilla10.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla10.setLayout(new javax.swing.OverlayLayout(lblCasilla10));

        jLabel71.setText("AV. PACÍFICO");
        jLabel71.setAlignmentY(1.0F);
        lblCasilla10.add(jLabel71);

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("$300");
        jLabel85.setAlignmentX(0.1F);
        jLabel85.setAlignmentY(0.1F);
        lblCasilla10.add(jLabel85);

        pnlTablero.add(lblCasilla10);
        lblCasilla10.setBounds(1250, 60, 118, 60);

        lblCasilla2.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla2.setLayout(new javax.swing.OverlayLayout(lblCasilla2));

        jLabel72.setText("EL MUELLE");
        jLabel72.setAlignmentX(0.2F);
        jLabel72.setAlignmentY(1.0F);
        lblCasilla2.add(jLabel72);

        jLabel2.setText("$400");
        jLabel2.setAlignmentY(0.0F);
        lblCasilla2.add(jLabel2);

        pnlTablero.add(lblCasilla2);
        lblCasilla2.setBounds(1248, 530, 120, 60);

        lblCasilla19.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla19.setLayout(new javax.swing.OverlayLayout(lblCasilla19));

        jLabel73.setText("FORTUNA");
        jLabel73.setAlignmentX(0.5F);
        jLabel73.setAlignmentY(1.0F);
        lblCasilla19.add(jLabel73);

        jLabel8.setText("(SACAR CARTA)");
        jLabel8.setAlignmentY(0.0F);
        lblCasilla19.add(jLabel8);

        pnlTablero.add(lblCasilla19);
        lblCasilla19.setBounds(290, 0, 120, 60);

        jPanel53.setBackground(new java.awt.Color(255, 255, 0));
        jPanel53.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel53);
        jPanel53.setBounds(1130, 50, 120, 10);

        lblCasilla9.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla9.setLayout(new javax.swing.OverlayLayout(lblCasilla9));

        jLabel74.setText("AV. N. CAROLINA");
        jLabel74.setAlignmentY(1.0F);
        lblCasilla9.add(jLabel74);

        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setText("$320");
        jLabel87.setAlignmentX(0.1F);
        jLabel87.setAlignmentY(0.1F);
        lblCasilla9.add(jLabel87);

        pnlTablero.add(lblCasilla9);
        lblCasilla9.setBounds(1250, 110, 118, 60);

        lblCasilla13.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla13.setLayout(new javax.swing.OverlayLayout(lblCasilla13));

        jLabel75.setText("AGUA");
        jLabel75.setAlignmentY(1.0F);
        lblCasilla13.add(jLabel75);

        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("$150");
        jLabel88.setAlignmentX(0.1F);
        jLabel88.setAlignmentY(0.1F);
        lblCasilla13.add(jLabel88);

        pnlTablero.add(lblCasilla13);
        lblCasilla13.setBounds(1028, 0, 110, 60);

        jPanel5.setBackground(new java.awt.Color(255, 255, 0));
        jPanel5.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel5);
        jPanel5.setBounds(910, 50, 120, 10);

        lblCasilla14.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla14.setLayout(new javax.swing.OverlayLayout(lblCasilla14));

        jLabel76.setText("AVENIDA VENTNOR");
        jLabel76.setAlignmentY(1.0F);
        lblCasilla14.add(jLabel76);

        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("$260");
        jLabel89.setAlignmentX(0.1F);
        jLabel89.setAlignmentY(0.1F);
        lblCasilla14.add(jLabel89);

        pnlTablero.add(lblCasilla14);
        lblCasilla14.setBounds(910, 0, 120, 50);

        jPanel46.setBackground(new java.awt.Color(255, 255, 0));
        jPanel46.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel46);
        jPanel46.setBounds(780, 50, 130, 10);

        lblCasilla15.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla15.setLayout(new javax.swing.OverlayLayout(lblCasilla15));

        jLabel77.setText("AV. ATLÁNTICO");
        jLabel77.setAlignmentY(1.0F);
        lblCasilla15.add(jLabel77);

        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("$260");
        jLabel90.setAlignmentX(0.1F);
        jLabel90.setAlignmentY(0.1F);
        lblCasilla15.add(jLabel90);

        pnlTablero.add(lblCasilla15);
        lblCasilla15.setBounds(780, 0, 130, 50);

        jPanel28.setBackground(new java.awt.Color(255, 0, 0));
        jPanel28.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel28);
        jPanel28.setBounds(410, 50, 120, 10);

        lblCasilla16.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla16.setLayout(new javax.swing.OverlayLayout(lblCasilla16));

        jLabel78.setText("FERROCARRIL B&O");
        jLabel78.setAlignmentY(1.0F);
        lblCasilla16.add(jLabel78);

        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("$200");
        jLabel91.setAlignmentX(0.1F);
        jLabel91.setAlignmentY(0.1F);
        lblCasilla16.add(jLabel91);

        pnlTablero.add(lblCasilla16);
        lblCasilla16.setBounds(650, 0, 130, 60);

        lblCasilla17.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla17.setLayout(new javax.swing.OverlayLayout(lblCasilla17));

        jLabel79.setText("AVENIDA  ILLINOIS");
        jLabel79.setAlignmentY(1.0F);
        lblCasilla17.add(jLabel79);

        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("$240");
        jLabel92.setAlignmentX(0.1F);
        jLabel92.setAlignmentY(0.1F);
        lblCasilla17.add(jLabel92);

        pnlTablero.add(lblCasilla17);
        lblCasilla17.setBounds(530, 0, 120, 50);

        jPanel31.setBackground(new java.awt.Color(255, 0, 0));
        jPanel31.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel31);
        jPanel31.setBounds(530, 40, 120, 20);

        lblCasilla21.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla21.setLayout(new javax.swing.OverlayLayout(lblCasilla21));

        jLabel80.setText("LIBRE");
        jLabel80.setAlignmentX(0.5F);
        jLabel80.setAlignmentY(0.0F);
        lblCasilla21.add(jLabel80);

        jLabel9.setText("PARQUEO");
        jLabel9.setAlignmentY(1.0F);
        lblCasilla21.add(jLabel9);

        pnlTablero.add(lblCasilla21);
        lblCasilla21.setBounds(10, 0, 150, 60);

        lblCasilla18.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla18.setLayout(new javax.swing.OverlayLayout(lblCasilla18));

        jLabel81.setText("AVENIDA INDIANA");
        jLabel81.setAlignmentY(1.0F);
        lblCasilla18.add(jLabel81);

        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setText("$220");
        jLabel94.setAlignmentX(0.1F);
        jLabel94.setAlignmentY(0.1F);
        lblCasilla18.add(jLabel94);

        pnlTablero.add(lblCasilla18);
        lblCasilla18.setBounds(410, 0, 120, 50);

        jPanel18.setBackground(new java.awt.Color(255, 0, 0));
        jPanel18.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel18);
        jPanel18.setBounds(160, 50, 130, 10);

        lblCasilla36.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla36.setLayout(new javax.swing.OverlayLayout(lblCasilla36));

        jLabel86.setText("FERROCARRIL $200");
        jLabel86.setAlignmentX(1.0F);
        jLabel86.setAlignmentY(1.0F);
        lblCasilla36.add(jLabel86);

        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("READING");
        jLabel95.setAlignmentX(1.0F);
        jLabel95.setAlignmentY(0.0F);
        lblCasilla36.add(jLabel95);

        pnlTablero.add(lblCasilla36);
        lblCasilla36.setBounds(680, 590, 140, 70);

        lblCasilla20.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla20.setLayout(new javax.swing.OverlayLayout(lblCasilla20));

        jLabel96.setText("AVENIDA KENTUCKY");
        jLabel96.setAlignmentY(1.0F);
        lblCasilla20.add(jLabel96);

        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setText("$220");
        jLabel97.setAlignmentX(0.1F);
        jLabel97.setAlignmentY(0.1F);
        lblCasilla20.add(jLabel97);

        pnlTablero.add(lblCasilla20);
        lblCasilla20.setBounds(160, 0, 130, 50);

        jPanel54.setBackground(new java.awt.Color(255, 102, 0));
        jPanel54.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel54);
        jPanel54.setBounds(160, 60, 20, 60);

        lblCasilla22.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla22.setLayout(new javax.swing.OverlayLayout(lblCasilla22));

        jLabel93.setText("AV. NUEVA YORK");
        jLabel93.setAlignmentY(1.0F);
        lblCasilla22.add(jLabel93);

        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("$200");
        jLabel98.setAlignmentX(0.1F);
        jLabel98.setAlignmentY(0.1F);
        lblCasilla22.add(jLabel98);

        pnlTablero.add(lblCasilla22);
        lblCasilla22.setBounds(10, 60, 150, 60);

        jPanel57.setBackground(new java.awt.Color(255, 102, 0));
        jPanel57.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel57);
        jPanel57.setBounds(160, 120, 20, 60);

        lblCasilla23.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla23.setLayout(new javax.swing.OverlayLayout(lblCasilla23));

        jLabel99.setText("AVENIDA TENNESSEE");
        jLabel99.setAlignmentY(1.0F);
        lblCasilla23.add(jLabel99);

        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("$180");
        jLabel100.setAlignmentX(0.1F);
        jLabel100.setAlignmentY(0.1F);
        lblCasilla23.add(jLabel100);

        pnlTablero.add(lblCasilla23);
        lblCasilla23.setBounds(10, 120, 150, 60);

        jPanel116.setBackground(new java.awt.Color(255, 102, 0));
        jPanel116.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel116Layout = new javax.swing.GroupLayout(jPanel116);
        jPanel116.setLayout(jPanel116Layout);
        jPanel116Layout.setHorizontalGroup(
            jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel116Layout.setVerticalGroup(
            jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel116);
        jPanel116.setBounds(160, 230, 20, 60);

        lblCasilla29.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla29.setLayout(new javax.swing.OverlayLayout(lblCasilla29));

        jLabel101.setText("ELECTRICIDAD");
        jLabel101.setAlignmentY(1.0F);
        lblCasilla29.add(jLabel101);

        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel102.setText("$150");
        jLabel102.setAlignmentX(0.1F);
        jLabel102.setAlignmentY(0.1F);
        lblCasilla29.add(jLabel102);

        pnlTablero.add(lblCasilla29);
        lblCasilla29.setBounds(10, 460, 170, 60);

        lblCasilla25.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla25.setLayout(new javax.swing.OverlayLayout(lblCasilla25));

        jLabel103.setText("AVENIDA ST. JAMES");
        jLabel103.setAlignmentY(1.0F);
        lblCasilla25.add(jLabel103);

        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel104.setText("$180");
        jLabel104.setAlignmentX(0.1F);
        jLabel104.setAlignmentY(0.1F);
        lblCasilla25.add(jLabel104);

        pnlTablero.add(lblCasilla25);
        lblCasilla25.setBounds(10, 230, 150, 60);

        jPanel113.setBackground(new java.awt.Color(255, 0, 153));
        jPanel113.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel113Layout = new javax.swing.GroupLayout(jPanel113);
        jPanel113.setLayout(jPanel113Layout);
        jPanel113Layout.setHorizontalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel113Layout.setVerticalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel113);
        jPanel113.setBounds(160, 340, 20, 60);

        lblCasilla34.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla34.setLayout(new javax.swing.OverlayLayout(lblCasilla34));

        jLabel105.setText("(SACAR CARTA)");
        jLabel105.setAlignmentX(0.5F);
        jLabel105.setAlignmentY(0.0F);
        lblCasilla34.add(jLabel105);

        jLabel11.setText("FORTUNA");
        jLabel11.setAlignmentY(1.0F);
        lblCasilla34.add(jLabel11);

        pnlTablero.add(lblCasilla34);
        lblCasilla34.setBounds(440, 590, 120, 70);

        jPanel118.setBackground(new java.awt.Color(255, 0, 153));
        jPanel118.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel118Layout = new javax.swing.GroupLayout(jPanel118);
        jPanel118.setLayout(jPanel118Layout);
        jPanel118Layout.setHorizontalGroup(
            jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel118Layout.setVerticalGroup(
            jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel118);
        jPanel118.setBounds(160, 400, 20, 60);

        jPanel109.setBackground(new java.awt.Color(255, 0, 153));
        jPanel109.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel109Layout = new javax.swing.GroupLayout(jPanel109);
        jPanel109.setLayout(jPanel109Layout);
        jPanel109Layout.setHorizontalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel109Layout.setVerticalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel109);
        jPanel109.setBounds(160, 520, 20, 70);

        jPanel24.setBackground(new java.awt.Color(0, 153, 153));
        jPanel24.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel24);
        jPanel24.setBounds(160, 590, 150, 10);

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));
        jPanel7.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel7);
        jPanel7.setBounds(310, 590, 140, 10);

        lblCasilla32.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla32.setLayout(new javax.swing.OverlayLayout(lblCasilla32));

        jLabel107.setText("AVENIDA CONNECTICUT");
        jLabel107.setAlignmentY(1.0F);
        lblCasilla32.add(jLabel107);

        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel108.setText("$120");
        jLabel108.setAlignmentX(0.1F);
        jLabel108.setAlignmentY(0.1F);
        lblCasilla32.add(jLabel108);

        pnlTablero.add(lblCasilla32);
        lblCasilla32.setBounds(160, 600, 150, 60);

        lblCasilla28.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla28.setLayout(new javax.swing.OverlayLayout(lblCasilla28));

        jLabel109.setText("AVENIDA STATUS");
        jLabel109.setAlignmentY(1.0F);
        lblCasilla28.add(jLabel109);

        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel110.setText("$140");
        jLabel110.setAlignmentX(0.1F);
        jLabel110.setAlignmentY(0.1F);
        lblCasilla28.add(jLabel110);

        pnlTablero.add(lblCasilla28);
        lblCasilla28.setBounds(10, 400, 150, 60);

        lblCasilla30.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla30.setLayout(new javax.swing.OverlayLayout(lblCasilla30));

        jLabel111.setText("PLAZA SAN CARLOS");
        jLabel111.setAlignmentY(1.0F);
        lblCasilla30.add(jLabel111);

        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel112.setText("$140");
        jLabel112.setAlignmentX(0.1F);
        jLabel112.setAlignmentY(0.1F);
        lblCasilla30.add(jLabel112);

        pnlTablero.add(lblCasilla30);
        lblCasilla30.setBounds(10, 520, 150, 70);

        lblCasilla31.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla31.setLayout(new javax.swing.OverlayLayout(lblCasilla31));

        jLabel113.setText("LA");
        jLabel113.setAlignmentY(1.0F);
        lblCasilla31.add(jLabel113);

        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel114.setText("CÁRCEL");
        jLabel114.setAlignmentX(0.1F);
        jLabel114.setAlignmentY(0.1F);
        lblCasilla31.add(jLabel114);

        pnlTablero.add(lblCasilla31);
        lblCasilla31.setBounds(10, 590, 150, 70);

        lblCasilla27.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla27.setLayout(new javax.swing.OverlayLayout(lblCasilla27));

        jLabel115.setText("AVENIDA VIRGINIA");
        jLabel115.setAlignmentY(1.0F);
        lblCasilla27.add(jLabel115);

        jLabel116.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel116.setText("$160");
        jLabel116.setAlignmentX(0.1F);
        jLabel116.setAlignmentY(0.1F);
        lblCasilla27.add(jLabel116);

        pnlTablero.add(lblCasilla27);
        lblCasilla27.setBounds(10, 340, 150, 60);

        lblCasilla33.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla33.setLayout(new javax.swing.OverlayLayout(lblCasilla33));

        jLabel119.setText("AVENIDA VERMONT");
        jLabel119.setAlignmentY(1.0F);
        lblCasilla33.add(jLabel119);

        jLabel120.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel120.setText("$100");
        jLabel120.setAlignmentX(0.1F);
        jLabel120.setAlignmentY(0.1F);
        lblCasilla33.add(jLabel120);

        pnlTablero.add(lblCasilla33);
        lblCasilla33.setBounds(310, 600, 130, 60);

        jPanel34.setBackground(new java.awt.Color(0, 153, 153));
        jPanel34.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel34);
        jPanel34.setBounds(560, 590, 120, 10);

        lblCasilla39.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla39.setLayout(new javax.swing.OverlayLayout(lblCasilla39));

        jLabel121.setText("ARCA");
        jLabel121.setAlignmentY(1.0F);
        lblCasilla39.add(jLabel121);

        jLabel122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel122.setText("COMUNAL");
        jLabel122.setAlignmentX(0.1F);
        jLabel122.setAlignmentY(0.1F);
        lblCasilla39.add(jLabel122);

        pnlTablero.add(lblCasilla39);
        lblCasilla39.setBounds(1010, 590, 90, 70);

        lblCasilla26.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla26.setLayout(new javax.swing.OverlayLayout(lblCasilla26));

        jLabel106.setText("FERROCARRIL PENSILVANIA");
        jLabel106.setAlignmentY(1.0F);
        lblCasilla26.add(jLabel106);

        jLabel123.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel123.setText("$200");
        jLabel123.setAlignmentY(0.0F);
        lblCasilla26.add(jLabel123);

        pnlTablero.add(lblCasilla26);
        lblCasilla26.setBounds(10, 290, 170, 50);

        lblCasilla38.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla38.setLayout(new javax.swing.OverlayLayout(lblCasilla38));

        jLabel124.setText("AVENIDA BÁLTICA");
        jLabel124.setAlignmentY(1.0F);
        lblCasilla38.add(jLabel124);

        jLabel125.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel125.setText("$60");
        jLabel125.setAlignmentX(0.1F);
        jLabel125.setAlignmentY(0.1F);
        lblCasilla38.add(jLabel125);

        pnlTablero.add(lblCasilla38);
        lblCasilla38.setBounds(900, 600, 110, 60);

        lblCasilla35.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla35.setLayout(new javax.swing.OverlayLayout(lblCasilla35));

        jLabel126.setText("AV. ORIENTAL");
        jLabel126.setAlignmentY(1.0F);
        lblCasilla35.add(jLabel126);

        jLabel127.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel127.setText("$100");
        jLabel127.setAlignmentX(0.1F);
        jLabel127.setAlignmentY(0.1F);
        lblCasilla35.add(jLabel127);

        pnlTablero.add(lblCasilla35);
        lblCasilla35.setBounds(560, 600, 120, 60);

        jPanel9.setBackground(new java.awt.Color(102, 0, 0));
        jPanel9.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel9);
        jPanel9.setBounds(900, 590, 108, 10);

        lblCasilla37.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla37.setLayout(new javax.swing.OverlayLayout(lblCasilla37));

        jLabel128.setText("IMPUESTOS");
        jLabel128.setAlignmentY(1.0F);
        lblCasilla37.add(jLabel128);

        jLabel129.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel129.setText("$200");
        jLabel129.setAlignmentX(0.1F);
        jLabel129.setAlignmentY(0.1F);
        lblCasilla37.add(jLabel129);

        pnlTablero.add(lblCasilla37);
        lblCasilla37.setBounds(820, 590, 80, 70);

        lblCasilla40.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla40.setLayout(new javax.swing.OverlayLayout(lblCasilla40));

        jLabel130.setText("AV. MEDITERRÁNEO");
        jLabel130.setAlignmentY(1.0F);
        lblCasilla40.add(jLabel130);

        jLabel133.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel133.setText("$60");
        jLabel133.setAlignmentX(0.1F);
        jLabel133.setAlignmentY(0.1F);
        lblCasilla40.add(jLabel133);

        pnlTablero.add(lblCasilla40);
        lblCasilla40.setBounds(1100, 600, 130, 60);

        jPanel11.setBackground(new java.awt.Color(102, 0, 0));
        jPanel11.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        pnlTablero.add(jPanel11);
        jPanel11.setBounds(1100, 590, 130, 10);

        lblCasilla8.setBackground(new java.awt.Color(255, 255, 255));
        lblCasilla8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCasilla8.setLayout(new javax.swing.OverlayLayout(lblCasilla8));

        jLabel65.setText("ARCA");
        jLabel65.setAlignmentY(1.0F);
        lblCasilla8.add(jLabel65);

        jLabel6.setText("COMUNAL");
        jLabel6.setAlignmentY(0.0F);
        lblCasilla8.add(jLabel6);

        pnlTablero.add(lblCasilla8);
        lblCasilla8.setBounds(1228, 170, 140, 50);

        pnlArcaComunal.setBackground(new java.awt.Color(255, 255, 255));
        pnlArcaComunal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ImageIcon arcaImage = new ImageIcon("src/Imagenes/arcacomunal.png");
        lblArcaComunal.setIcon(arcaImage);

        javax.swing.GroupLayout pnlArcaComunalLayout = new javax.swing.GroupLayout(pnlArcaComunal);
        pnlArcaComunal.setLayout(pnlArcaComunalLayout);
        pnlArcaComunalLayout.setHorizontalGroup(
            pnlArcaComunalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlArcaComunalLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(lblArcaComunal, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        pnlArcaComunalLayout.setVerticalGroup(
            pnlArcaComunalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlArcaComunalLayout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(lblArcaComunal, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlTablero.add(pnlArcaComunal);
        pnlArcaComunal.setBounds(580, 120, 240, 100);

        pnlLogoMonopoly.setBackground(new java.awt.Color(255, 255, 255));

        ImageIcon logoMonopolyImage = new ImageIcon("src/Imagenes/logotablero.png");
        lblLogoMonopoly.setIcon(logoMonopolyImage);

        javax.swing.GroupLayout pnlLogoMonopolyLayout = new javax.swing.GroupLayout(pnlLogoMonopoly);
        pnlLogoMonopoly.setLayout(pnlLogoMonopolyLayout);
        pnlLogoMonopolyLayout.setHorizontalGroup(
            pnlLogoMonopolyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogoMonopolyLayout.createSequentialGroup()
                .addGap(0, 115, Short.MAX_VALUE)
                .addComponent(lblLogoMonopoly, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlLogoMonopolyLayout.setVerticalGroup(
            pnlLogoMonopolyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoMonopolyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogoMonopoly, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlTablero.add(pnlLogoMonopoly);
        pnlLogoMonopoly.setBounds(340, 230, 750, 190);

        pnlFortuna.setBackground(new java.awt.Color(255, 255, 255));
        pnlFortuna.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ImageIcon fortunaImage = new ImageIcon("src/Imagenes/fortuna.png");
        lblFortuna.setIcon(fortunaImage);

        javax.swing.GroupLayout pnlFortunaLayout = new javax.swing.GroupLayout(pnlFortuna);
        pnlFortuna.setLayout(pnlFortunaLayout);
        pnlFortunaLayout.setHorizontalGroup(
            pnlFortunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFortunaLayout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(lblFortuna, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlFortunaLayout.setVerticalGroup(
            pnlFortunaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFortuna, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        );

        pnlTablero.add(pnlFortuna);
        pnlFortuna.setBounds(570, 430, 250, 100);

        lblLibreCasilla1.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla1);
        lblLibreCasilla1.setBounds(1060, 520, 70, 20);

        lblAlquilerCasilla1.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla1);
        lblAlquilerCasilla1.setBounds(1060, 540, 90, 20);

        lblCasasCasilla1.setText("0");
        pnlTablero.add(lblCasasCasilla1);
        lblCasasCasilla1.setBounds(1110, 560, 40, 16);

        lblHotelCasillas1.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas1);
        lblHotelCasillas1.setBounds(1060, 580, 80, 10);

        lblLibreCasilla3.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla3);
        lblLibreCasilla3.setBounds(900, 520, 100, 20);

        lblAlquilerCasilla3.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla3);
        lblAlquilerCasilla3.setBounds(900, 540, 110, 20);

        lblCasasCasilla3.setText("0");
        pnlTablero.add(lblCasasCasilla3);
        lblCasasCasilla3.setBounds(950, 560, 40, 16);

        lblHotelCasillas3.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas3);
        lblHotelCasillas3.setBounds(900, 570, 110, 20);

        lblLibreCasilla6.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla6);
        lblLibreCasilla6.setBounds(560, 530, 120, 20);

        lblAlquilerCasilla6.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla6);
        lblAlquilerCasilla6.setBounds(560, 550, 120, 10);

        lblCasasCasilla6.setText("0");
        pnlTablero.add(lblCasasCasilla6);
        lblCasasCasilla6.setBounds(610, 560, 50, 20);

        lblHotelCasillas6.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas6);
        lblHotelCasillas6.setBounds(560, 570, 120, 20);

        lblLibreCasilla5.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla5);
        lblLibreCasilla5.setBounds(680, 540, 140, 20);

        lblAlquilerCasilla5.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla5);
        lblAlquilerCasilla5.setBounds(680, 560, 140, 30);

        lblLibreCasilla37.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla37);
        lblLibreCasilla37.setBounds(1120, 400, 110, 20);

        lblAlquilerCasilla37.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla37);
        lblAlquilerCasilla37.setBounds(1120, 420, 110, 20);

        lblCasasCasilla37.setText("0");
        pnlTablero.add(lblCasasCasilla37);
        lblCasasCasilla37.setBounds(1170, 440, 50, 20);

        lblHotelCasillas37.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas37);
        lblHotelCasillas37.setBounds(1120, 460, 110, 20);

        lblLibreCasilla39.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla39);
        lblLibreCasilla39.setBounds(1150, 520, 90, 20);

        lblAlquilerCasilla39.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla39);
        lblAlquilerCasilla39.setBounds(1150, 540, 90, 10);

        lblCasasCasilla39.setText("0");
        pnlTablero.add(lblCasasCasilla39);
        lblCasasCasilla39.setBounds(1190, 550, 40, 20);

        lblHotelCasillas39.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas39);
        lblHotelCasillas39.setBounds(1150, 570, 80, 20);

        lblLibreCasilla8.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla8);
        lblLibreCasilla8.setBounds(410, 520, 120, 20);

        lblAlquilerCasilla8.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla8);
        lblAlquilerCasilla8.setBounds(410, 540, 120, 20);

        lblCasasCasilla8.setText("0");
        pnlTablero.add(lblCasasCasilla8);
        lblCasasCasilla8.setBounds(470, 560, 60, 10);

        lblHotelCasillas8.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas8);
        lblHotelCasillas8.setBounds(410, 570, 130, 20);

        lblLibreCasilla9.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla9);
        lblLibreCasilla9.setBounds(290, 520, 110, 20);

        lblAlquilerCasilla9.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla9);
        lblAlquilerCasilla9.setBounds(290, 540, 110, 20);

        lblCasasCasilla9.setText("0");
        pnlTablero.add(lblCasasCasilla9);
        lblCasasCasilla9.setBounds(340, 560, 40, 20);

        lblHotelCasillas9.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas9);
        lblHotelCasillas9.setBounds(290, 570, 110, 20);

        lblLibreCasilla11.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla11);
        lblLibreCasilla11.setBounds(180, 530, 100, 20);

        lblAlquilerCasilla11.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla11);
        lblAlquilerCasilla11.setBounds(180, 550, 80, 10);

        lblCasasCasilla11.setText("0");
        pnlTablero.add(lblCasasCasilla11);
        lblCasasCasilla11.setBounds(230, 560, 30, 20);

        lblHotelCasillas11.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas11);
        lblHotelCasillas11.setBounds(180, 580, 90, 10);

        lblLibreCasilla12.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla12);
        lblLibreCasilla12.setBounds(180, 470, 100, 20);

        lblAlquilerCasilla12.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla12);
        lblAlquilerCasilla12.setBounds(180, 490, 100, 20);

        lblLibreCasilla13.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla13);
        lblLibreCasilla13.setBounds(180, 400, 100, 20);

        lblCasasCasilla13.setText("0");
        pnlTablero.add(lblCasasCasilla13);
        lblCasasCasilla13.setBounds(220, 430, 90, 20);

        lblAlquilerCasilla13.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla13);
        lblAlquilerCasilla13.setBounds(180, 420, 100, 10);

        lblHotelCasillas13.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas13);
        lblHotelCasillas13.setBounds(180, 440, 100, 20);

        lblLibreCasilla14.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla14);
        lblLibreCasilla14.setBounds(180, 340, 120, 20);

        lblAlquilerCasilla14.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla14);
        lblAlquilerCasilla14.setBounds(180, 360, 130, 10);

        lblHotelCasillas14.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas14);
        lblHotelCasillas14.setBounds(180, 380, 140, 20);

        lblLibreCasilla15.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla15);
        lblLibreCasilla15.setBounds(180, 300, 130, 10);

        lblAlquilerCasilla15.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla15);
        lblAlquilerCasilla15.setBounds(180, 310, 120, 20);

        lblLibreCasilla16.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla16);
        lblLibreCasilla16.setBounds(180, 230, 100, 20);

        lblCasasCasilla16.setText("0");
        pnlTablero.add(lblCasasCasilla16);
        lblCasasCasilla16.setBounds(220, 260, 70, 20);

        lblAlquilerCasilla16.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla16);
        lblAlquilerCasilla16.setBounds(180, 250, 110, 10);

        lblHotelCasillas16.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas16);
        lblHotelCasillas16.setBounds(180, 270, 90, 20);

        lblLibreCasilla18.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla18);
        lblLibreCasilla18.setBounds(180, 130, 90, 20);

        lblCasasCasilla18.setText("0");
        pnlTablero.add(lblCasasCasilla18);
        lblCasasCasilla18.setBounds(220, 160, 80, 20);

        lblAlquilerCasilla18.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla18);
        lblAlquilerCasilla18.setBounds(180, 150, 90, 10);

        lblHotelCasillas18.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas18);
        lblHotelCasillas18.setBounds(180, 170, 80, 20);

        lblLibreCasilla19.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla19);
        lblLibreCasilla19.setBounds(180, 60, 100, 20);

        lblCasasCasilla19.setText("0");
        pnlTablero.add(lblCasasCasilla19);
        lblCasasCasilla19.setBounds(220, 90, 40, 16);

        lblAlquilerCasilla19.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla19);
        lblAlquilerCasilla19.setBounds(180, 80, 100, 10);

        lblHotelCasillas19.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas19);
        lblHotelCasillas19.setBounds(180, 104, 90, 16);

        lblLibreCasilla21.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla21);
        lblLibreCasilla21.setBounds(280, 60, 110, 20);

        lblCasasCasilla21.setText("0");
        pnlTablero.add(lblCasasCasilla21);
        lblCasasCasilla21.setBounds(330, 90, 40, 16);

        lblAlquilerCasilla21.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla21);
        lblAlquilerCasilla21.setBounds(280, 80, 110, 10);

        lblHotelCasillas21.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas21);
        lblHotelCasillas21.setBounds(280, 110, 100, 10);

        lblLibreCasilla23.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla23);
        lblLibreCasilla23.setBounds(420, 60, 110, 20);

        lblCasasCasilla23.setText("0");
        pnlTablero.add(lblCasasCasilla23);
        lblCasasCasilla23.setBounds(470, 100, 40, 10);

        lblAlquilerCasilla23.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla23);
        lblAlquilerCasilla23.setBounds(420, 80, 110, 20);

        lblHotelCasillas23.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas23);
        lblHotelCasillas23.setBounds(420, 110, 110, 20);

        lblLibreCasilla24.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla24);
        lblLibreCasilla24.setBounds(530, 60, 120, 20);

        lblCasasCasilla24.setText("0");
        pnlTablero.add(lblCasasCasilla24);
        lblCasasCasilla24.setBounds(580, 90, 50, 10);

        lblAlquilerCasilla24.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla24);
        lblAlquilerCasilla24.setBounds(530, 80, 120, 10);

        lblHotelCasillas24.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas24);
        lblHotelCasillas24.setBounds(530, 100, 120, 20);

        lblLibreCasilla25.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla25);
        lblLibreCasilla25.setBounds(650, 60, 130, 20);

        lblAlquilerCasilla25.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla25);
        lblAlquilerCasilla25.setBounds(650, 90, 130, 20);

        lblLibreCasilla35.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla35);
        lblLibreCasilla35.setBounds(1120, 310, 110, 20);

        lblAlquilerCasilla35.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla35);
        lblAlquilerCasilla35.setBounds(1120, 330, 110, 20);

        lblLibreCasilla34.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla34);
        lblLibreCasilla34.setBounds(1120, 230, 100, 20);

        lblAlquilerCasilla34.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla34);
        lblAlquilerCasilla34.setBounds(1120, 250, 100, 10);

        lblCasasCasilla34.setText("0");
        pnlTablero.add(lblCasasCasilla34);
        lblCasasCasilla34.setBounds(1160, 260, 40, 20);

        lblHotelCasillas34.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas34);
        lblHotelCasillas34.setBounds(1120, 280, 100, 10);

        lblLibreCasilla32.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla32);
        lblLibreCasilla32.setBounds(1120, 130, 110, 20);

        lblAlquilerCasilla32.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla32);
        lblAlquilerCasilla32.setBounds(1120, 150, 110, 10);

        lblCasasCasilla32.setText("0");
        pnlTablero.add(lblCasasCasilla32);
        lblCasasCasilla32.setBounds(1170, 160, 30, 20);

        lblHotelCasillas32.setText("Hotel 0");
        pnlTablero.add(lblHotelCasillas32);
        lblHotelCasillas32.setBounds(1120, 170, 110, 20);

        lblLibreCasilla26.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla26);
        lblLibreCasilla26.setBounds(780, 60, 130, 20);

        lblAlquilerCasilla26.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla26);
        lblAlquilerCasilla26.setBounds(780, 80, 130, 10);

        lblCasasCasilla26.setText("0");
        pnlTablero.add(lblCasasCasilla26);
        lblCasasCasilla26.setBounds(830, 90, 50, 10);

        lblHotelCasillas26.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas26);
        lblHotelCasillas26.setBounds(780, 100, 130, 20);

        lblLibreCasilla27.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla27);
        lblLibreCasilla27.setBounds(900, 60, 100, 20);

        lblAlquilerCasilla27.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla27);
        lblAlquilerCasilla27.setBounds(900, 80, 100, 20);

        lblCasasCasilla27.setText("0");
        pnlTablero.add(lblCasasCasilla27);
        lblCasasCasilla27.setBounds(950, 100, 50, 20);

        lblHotelCasillas27.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas27);
        lblHotelCasillas27.setBounds(900, 120, 120, 20);

        lblLibreCasilla28.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla28);
        lblLibreCasilla28.setBounds(1000, 60, 70, 20);

        lblAlquilerCasilla28.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla28);
        lblAlquilerCasilla28.setBounds(1000, 90, 80, 20);

        lblLibreCasilla29.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla29);
        lblLibreCasilla29.setBounds(1070, 60, 80, 10);

        lblAlquilerCasilla29.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla29);
        lblAlquilerCasilla29.setBounds(1070, 74, 80, 16);

        lblCasasCasilla29.setText("0");
        pnlTablero.add(lblCasasCasilla29);
        lblCasasCasilla29.setBounds(1120, 90, 30, 16);

        lblHotelCasillas29.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas29);
        lblHotelCasillas29.setBounds(1070, 110, 80, 10);

        lblLibreCasilla31.setText("Dueno:");
        pnlTablero.add(lblLibreCasilla31);
        lblLibreCasilla31.setBounds(1150, 60, 80, 10);

        lblAlquilerCasilla31.setText("Alquiler: $0");
        pnlTablero.add(lblAlquilerCasilla31);
        lblAlquilerCasilla31.setBounds(1150, 74, 80, 16);

        lblCasasCasilla31.setText("0");
        pnlTablero.add(lblCasasCasilla31);
        lblCasasCasilla31.setBounds(1200, 90, 30, 10);

        lblHotelCasillas31.setText("Hotel: 0");
        pnlTablero.add(lblHotelCasillas31);
        lblHotelCasillas31.setBounds(1150, 110, 80, 10);
        pnlTablero.add(lblNothing);
        lblNothing.setBounds(970, 450, 70, 30);

        jLabel12.setText("Casas:");
        pnlTablero.add(jLabel12);
        jLabel12.setBounds(900, 560, 50, 16);

        jLabel13.setText("Casas:");
        pnlTablero.add(jLabel13);
        jLabel13.setBounds(1060, 560, 50, 16);

        jLabel15.setText("Casas:");
        pnlTablero.add(jLabel15);
        jLabel15.setBounds(1150, 550, 40, 20);

        jLabel16.setText("Casas:");
        pnlTablero.add(jLabel16);
        jLabel16.setBounds(560, 560, 48, 16);

        jLabel17.setText("Casas:");
        pnlTablero.add(jLabel17);
        jLabel17.setBounds(290, 560, 48, 16);

        jLabel18.setText("Casas:");
        pnlTablero.add(jLabel18);
        jLabel18.setBounds(180, 560, 48, 16);

        jLabel19.setText("Casas:");
        pnlTablero.add(jLabel19);
        jLabel19.setBounds(180, 430, 48, 16);

        lblCasasCasilla14.setText("0");
        pnlTablero.add(lblCasasCasilla14);
        lblCasasCasilla14.setBounds(230, 370, 140, 16);

        jLabel20.setText("Casas:");
        pnlTablero.add(jLabel20);
        jLabel20.setBounds(180, 370, 48, 16);

        jLabel21.setText("Casas:");
        pnlTablero.add(jLabel21);
        jLabel21.setBounds(180, 260, 48, 16);

        jLabel22.setText("Casas:");
        pnlTablero.add(jLabel22);
        jLabel22.setBounds(180, 160, 48, 16);

        jLabel23.setText("Casas:");
        pnlTablero.add(jLabel23);
        jLabel23.setBounds(180, 90, 48, 16);

        jLabel24.setText("Casas:");
        pnlTablero.add(jLabel24);
        jLabel24.setBounds(280, 90, 48, 16);

        jLabel25.setText("Casas:");
        pnlTablero.add(jLabel25);
        jLabel25.setBounds(420, 96, 48, 20);

        jLabel26.setText("Casas:");
        pnlTablero.add(jLabel26);
        jLabel26.setBounds(530, 90, 50, 16);

        jLabel27.setText("Casas:");
        pnlTablero.add(jLabel27);
        jLabel27.setBounds(780, 90, 48, 16);

        jLabel28.setText("Casas:");
        pnlTablero.add(jLabel28);
        jLabel28.setBounds(900, 100, 48, 16);

        jLabel29.setText("Casas:");
        pnlTablero.add(jLabel29);
        jLabel29.setBounds(1070, 90, 48, 16);

        jLabel30.setText("Casas:");
        pnlTablero.add(jLabel30);
        jLabel30.setBounds(1150, 90, 50, 16);

        jLabel31.setText("Casas:");
        pnlTablero.add(jLabel31);
        jLabel31.setBounds(1120, 160, 48, 16);

        jLabel32.setText("Casas:");
        pnlTablero.add(jLabel32);
        jLabel32.setBounds(1120, 260, 48, 16);

        jLabel33.setText("Casas:");
        pnlTablero.add(jLabel33);
        jLabel33.setBounds(1120, 440, 48, 16);

        jLabel36.setText("Casas");
        pnlTablero.add(jLabel36);
        jLabel36.setBounds(410, 560, 48, 16);

        jPanel2.add(pnlTablero);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1380, 660));

        pnlToolbar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVenderProp.setText("Vender");
        btnVenderProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderPropActionPerformed(evt);
            }
        });
        pnlToolbar.add(btnVenderProp, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 90, 60));

        btnComprarPropActual.setText("Comprar propiedad actual");
        btnComprarPropActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarPropActualActionPerformed(evt);
            }
        });
        pnlToolbar.add(btnComprarPropActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 180, 70));

        btnLanzarDados.setText("Lanzar Dados");
        btnLanzarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLanzarDadosActionPerformed(evt);
            }
        });
        pnlToolbar.add(btnLanzarDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 120, 90));

        btnHipotecar.setText("Hipotecar/deshipotecar");
        btnHipotecar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHipotecarActionPerformed(evt);
            }
        });
        pnlToolbar.add(btnHipotecar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 170, 60));

        btnEndTurn.setText("Terminar turno");
        btnEndTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndTurnActionPerformed(evt);
            }
        });
        pnlToolbar.add(btnEndTurn, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 140, 130, 90));

        lblSeleccionFicha.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblSeleccionFicha.setText("Seleccionar ficha:");
        pnlToolbar.add(lblSeleccionFicha, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 170, -1));

        cbSeleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chikorita", "Slowbro", "Charizard", "Pikachu", "Yamper", "Rayquaza", "Suicune", "Entei", "Raikou", "Mewtwo", "Espeon", "Ditto", "Cyndaquil", "Totodile" }));
        pnlToolbar.add(cbSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 260, 30));

        btnSeleccionFicha.setText("Ficha seleccionada");
        btnSeleccionFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionFichaActionPerformed(evt);
            }
        });
        pnlToolbar.add(btnSeleccionFicha, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 160, 70));

        lblDado2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblDado2.setForeground(new java.awt.Color(255, 0, 0));
        lblDado2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDado2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDado2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        pnlToolbar.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));

        pnlToolbar.add(cbPropiedades, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 690, 30));

        lblAdministrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblAdministrar.setText("Administrar propiedades:");
        pnlToolbar.add(lblAdministrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 240, -1));

        btnCompraCasa.setText("Comprar casa");
        btnCompraCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraCasaActionPerformed(evt);
            }
        });
        pnlToolbar.add(btnCompraCasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, -1, 60));

        btnVenderCasa.setText("Vender casa");
        btnVenderCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderCasaActionPerformed(evt);
            }
        });
        pnlToolbar.add(btnVenderCasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 110, 60));

        btnCompraHotel.setText("Comprar hotel");
        btnCompraHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraHotelActionPerformed(evt);
            }
        });
        pnlToolbar.add(btnCompraHotel, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, 120, 60));

        pnlTituloPropiedad.setBackground(new java.awt.Color(255, 255, 255));
        pnlTituloPropiedad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblCadaHotelCuesta.setForeground(new java.awt.Color(0, 0, 0));
        lblCadaHotelCuesta.setText("Cada hotel cuesta:");

        lblCadaCasaCuesta.setForeground(new java.awt.Color(0, 0, 0));
        lblCadaCasaCuesta.setText("Cada casa cuesta:");

        lblHipotecaTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblHipotecaTitulo.setText("Valor de hipoteca:");

        lblConHotel.setForeground(new java.awt.Color(0, 0, 0));
        lblConHotel.setText("Con hotel:");

        lblCon4Casas.setForeground(new java.awt.Color(0, 0, 0));
        lblCon4Casas.setText("Con 4 casas:");

        lblCon3Casas.setForeground(new java.awt.Color(0, 0, 0));
        lblCon3Casas.setText("Con 3 casas:");

        lblCon2Casas.setForeground(new java.awt.Color(0, 0, 0));
        lblCon2Casas.setText("Con 2 casas:");

        lblCon1Casa.setForeground(new java.awt.Color(0, 0, 0));
        lblCon1Casa.setText("Con 1 casa: ");

        lblAlquileresTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblAlquileresTitulo.setText("Alquileres: ");

        javax.swing.GroupLayout pnlTituloPropiedadLayout = new javax.swing.GroupLayout(pnlTituloPropiedad);
        pnlTituloPropiedad.setLayout(pnlTituloPropiedadLayout);
        pnlTituloPropiedadLayout.setHorizontalGroup(
            pnlTituloPropiedadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloPropiedadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTituloPropiedadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAlquileresTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCon1Casa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCon2Casas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCon3Casas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCon4Casas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblConHotel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHipotecaTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCadaCasaCuesta, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(lblCadaHotelCuesta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTituloPropiedadLayout.setVerticalGroup(
            pnlTituloPropiedadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTituloPropiedadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAlquileresTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCon1Casa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCon2Casas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCon3Casas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCon4Casas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblConHotel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHipotecaTitulo)
                .addGap(8, 8, 8)
                .addComponent(lblCadaCasaCuesta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCadaHotelCuesta)
                .addGap(12, 12, 12))
        );

        pnlToolbar.add(pnlTituloPropiedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 60, 230, 210));

        btnConsultarDerecha.setText("=>");
        btnConsultarDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarDerechaActionPerformed(evt);
            }
        });
        pnlToolbar.add(btnConsultarDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 270, -1, -1));

        btnConsultarIzquierda.setText("<=");
        btnConsultarIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarIzquierdaActionPerformed(evt);
            }
        });
        pnlToolbar.add(btnConsultarIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 270, -1, -1));

        pnlToolbar.add(cbConsultarPropiedades, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 50, 160, 30));

        lblConsultarPropiedades.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblConsultarPropiedades.setText("Consultar propiedades:");
        pnlToolbar.add(lblConsultarPropiedades, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, 210, -1));

        lblConsultarJugador.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblConsultarJugador.setText("Jugador:");
        pnlToolbar.add(lblConsultarJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 50, -1, 30));

        btnConsultarPropiedad.setText("Consultar");
        btnConsultarPropiedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarPropiedadActionPerformed(evt);
            }
        });
        pnlToolbar.add(btnConsultarPropiedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, -1, 50));

        pnlColorTituloPropiedad.setBackground(new java.awt.Color(255, 255, 255));
        pnlColorTituloPropiedad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTituloDePropiedad.setForeground(new java.awt.Color(0, 0, 0));
        lblTituloDePropiedad.setText("Titulo de propiedad");

        lblNombreTituloPropiedad.setForeground(new java.awt.Color(0, 0, 0));
        lblNombreTituloPropiedad.setText("Nombre:");

        javax.swing.GroupLayout pnlColorTituloPropiedadLayout = new javax.swing.GroupLayout(pnlColorTituloPropiedad);
        pnlColorTituloPropiedad.setLayout(pnlColorTituloPropiedadLayout);
        pnlColorTituloPropiedadLayout.setHorizontalGroup(
            pnlColorTituloPropiedadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlColorTituloPropiedadLayout.createSequentialGroup()
                .addGroup(pnlColorTituloPropiedadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlColorTituloPropiedadLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNombreTituloPropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlColorTituloPropiedadLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lblTituloDePropiedad)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlColorTituloPropiedadLayout.setVerticalGroup(
            pnlColorTituloPropiedadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlColorTituloPropiedadLayout.createSequentialGroup()
                .addComponent(lblTituloDePropiedad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreTituloPropiedad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlToolbar.add(pnlColorTituloPropiedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, 230, 50));

        btnAbrirServer.setText("Abrir server");
        btnAbrirServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirServerActionPerformed(evt);
            }
        });
        pnlToolbar.add(btnAbrirServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 110, 50));

        btnConectarse.setText("Conectarse");
        btnConectarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarseActionPerformed(evt);
            }
        });
        pnlToolbar.add(btnConectarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, 110, 50));

        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        pnlToolbar.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 240, 80, 60));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlToolbar.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlToolbar.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 110, -1));

        lblNumDado2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblNumDado2.setForeground(new java.awt.Color(255, 0, 0));
        pnlToolbar.add(lblNumDado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 20, 100, 100));

        btnVenderHotel.setText("Vender hotel");
        btnVenderHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderHotelActionPerformed(evt);
            }
        });
        pnlToolbar.add(btnVenderHotel, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 240, -1, 60));

        jLabel34.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel34.setText("Dado 1");
        pnlToolbar.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel35.setText("Dado 2");
        pnlToolbar.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        lblConexion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblConexion.setText("Conexión al server:");
        pnlToolbar.add(lblConexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, -1, -1));

        lblNumDado1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblNumDado1.setForeground(new java.awt.Color(255, 0, 0));
        pnlToolbar.add(lblNumDado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 100, 100));

        lblCarcel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCarcel.setText("Cárcel:");
        pnlToolbar.add(lblCarcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, -1, -1));

        btnLiberadoCarcel.setText("Ser liberado ($50)");
        btnLiberadoCarcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiberadoCarcelActionPerformed(evt);
            }
        });
        pnlToolbar.add(btnLiberadoCarcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 140, 50));

        getOutOfJailFree.setText("Get out of jail free");
        getOutOfJailFree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getOutOfJailFreeActionPerformed(evt);
            }
        });
        pnlToolbar.add(getOutOfJailFree, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, 130, 50));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setText("Get out of jail free:");
        pnlToolbar.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, -1, -1));

        lblGetOutOfJailFree.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblGetOutOfJailFree.setText("No tiene");
        pnlToolbar.add(lblGetOutOfJailFree, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, 100, -1));

        getContentPane().add(pnlToolbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 1380, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JPanel getPnlFicha() {
        return pnlFicha;
    }

    public JLabel getLblNumDado1() {
        return lblNumDado1;
    }

    public void setLblNumDado1(JLabel lblNumDado1) {
        this.lblNumDado1 = lblNumDado1;
    }

    public JLabel getLblNumDado2() {
        return lblNumDado2;
    }

    public void setLblNumDado2(JLabel lblNumDado2) {
        this.lblNumDado2 = lblNumDado2;
    }
    
    

    public void setPnlFicha(JPanel pnlFicha) {
        this.pnlFicha = pnlFicha;
    }

    public JLabel getLblFichaJugador() {
        return lblFichaJugador;
    }

    public void setLblFichaJugador(JLabel lblFichaJugador) {
        this.lblFichaJugador = lblFichaJugador;
    }

    public JPanel getLblCasilla1() {
        return lblCasilla1;
    }

    public void setLblCasilla1(JPanel lblCasilla1) {
        this.lblCasilla1 = lblCasilla1;
    }

    public JPanel getLblCasilla10() {
        return lblCasilla10;
    }

    public void setLblCasilla10(JPanel lblCasilla10) {
        this.lblCasilla10 = lblCasilla10;
    }

    public JPanel getLblCasilla11() {
        return lblCasilla11;
    }

    public void setLblCasilla11(JPanel lblCasilla11) {
        this.lblCasilla11 = lblCasilla11;
    }

    public JPanel getLblCasilla12() {
        return lblCasilla12;
    }

    public void setLblCasilla12(JPanel lblCasilla12) {
        this.lblCasilla12 = lblCasilla12;
    }

    public JPanel getLblCasilla13() {
        return lblCasilla13;
    }

    public void setLblCasilla13(JPanel lblCasilla13) {
        this.lblCasilla13 = lblCasilla13;
    }

    public JPanel getLblCasilla14() {
        return lblCasilla14;
    }

    public void setLblCasilla14(JPanel lblCasilla14) {
        this.lblCasilla14 = lblCasilla14;
    }

    public JPanel getLblCasilla15() {
        return lblCasilla15;
    }

    public void setLblCasilla15(JPanel lblCasilla15) {
        this.lblCasilla15 = lblCasilla15;
    }

    public JPanel getLblCasilla16() {
        return lblCasilla16;
    }

    public void setLblCasilla16(JPanel lblCasilla16) {
        this.lblCasilla16 = lblCasilla16;
    }

    public JPanel getLblCasilla17() {
        return lblCasilla17;
    }

    public void setLblCasilla17(JPanel lblCasilla17) {
        this.lblCasilla17 = lblCasilla17;
    }

    public JPanel getLblCasilla18() {
        return lblCasilla18;
    }

    public void setLblCasilla18(JPanel lblCasilla18) {
        this.lblCasilla18 = lblCasilla18;
    }

    public JPanel getLblCasilla19() {
        return lblCasilla19;
    }

    public void setLblCasilla19(JPanel lblCasilla19) {
        this.lblCasilla19 = lblCasilla19;
    }

    public JPanel getLblCasilla2() {
        return lblCasilla2;
    }

    public void setLblCasilla2(JPanel lblCasilla2) {
        this.lblCasilla2 = lblCasilla2;
    }

    public JPanel getLblCasilla20() {
        return lblCasilla20;
    }

    public void setLblCasilla20(JPanel lblCasilla20) {
        this.lblCasilla20 = lblCasilla20;
    }

    public JPanel getLblCasilla21() {
        return lblCasilla21;
    }

    public void setLblCasilla21(JPanel lblCasilla21) {
        this.lblCasilla21 = lblCasilla21;
    }

    public JPanel getLblCasilla22() {
        return lblCasilla22;
    }

    public void setLblCasilla22(JPanel lblCasilla22) {
        this.lblCasilla22 = lblCasilla22;
    }

    public JPanel getLblCasilla23() {
        return lblCasilla23;
    }

    public void setLblCasilla23(JPanel lblCasilla23) {
        this.lblCasilla23 = lblCasilla23;
    }

    public JPanel getLblCasilla24() {
        return lblCasilla24;
    }

    public void setLblCasilla24(JPanel lblCasilla24) {
        this.lblCasilla24 = lblCasilla24;
    }

    public JPanel getLblCasilla25() {
        return lblCasilla25;
    }

    public void setLblCasilla25(JPanel lblCasilla25) {
        this.lblCasilla25 = lblCasilla25;
    }

    public JPanel getLblCasilla26() {
        return lblCasilla26;
    }

    public void setLblCasilla26(JPanel lblCasilla26) {
        this.lblCasilla26 = lblCasilla26;
    }

    public JPanel getLblCasilla27() {
        return lblCasilla27;
    }

    public void setLblCasilla27(JPanel lblCasilla27) {
        this.lblCasilla27 = lblCasilla27;
    }

    public JPanel getLblCasilla28() {
        return lblCasilla28;
    }

    public void setLblCasilla28(JPanel lblCasilla28) {
        this.lblCasilla28 = lblCasilla28;
    }

    public JPanel getLblCasilla29() {
        return lblCasilla29;
    }

    public void setLblCasilla29(JPanel lblCasilla29) {
        this.lblCasilla29 = lblCasilla29;
    }

    public JPanel getLblCasilla3() {
        return lblCasilla3;
    }

    public void setLblCasilla3(JPanel lblCasilla3) {
        this.lblCasilla3 = lblCasilla3;
    }

    public JPanel getLblCasilla30() {
        return lblCasilla30;
    }

    public void setLblCasilla30(JPanel lblCasilla30) {
        this.lblCasilla30 = lblCasilla30;
    }

    public JPanel getLblCasilla31() {
        return lblCasilla31;
    }

    public void setLblCasilla31(JPanel lblCasilla31) {
        this.lblCasilla31 = lblCasilla31;
    }

    public JPanel getLblCasilla32() {
        return lblCasilla32;
    }

    public void setLblCasilla32(JPanel lblCasilla32) {
        this.lblCasilla32 = lblCasilla32;
    }

    public JPanel getLblCasilla33() {
        return lblCasilla33;
    }

    public void setLblCasilla33(JPanel lblCasilla33) {
        this.lblCasilla33 = lblCasilla33;
    }

    public JPanel getLblCasilla34() {
        return lblCasilla34;
    }

    public void setLblCasilla34(JPanel lblCasilla34) {
        this.lblCasilla34 = lblCasilla34;
    }

    public JPanel getLblCasilla35() {
        return lblCasilla35;
    }

    public void setLblCasilla35(JPanel lblCasilla35) {
        this.lblCasilla35 = lblCasilla35;
    }

    public JPanel getLblCasilla36() {
        return lblCasilla36;
    }

    public void setLblCasilla36(JPanel lblCasilla36) {
        this.lblCasilla36 = lblCasilla36;
    }

    public JPanel getLblCasilla37() {
        return lblCasilla37;
    }

    public void setLblCasilla37(JPanel lblCasilla37) {
        this.lblCasilla37 = lblCasilla37;
    }

    public JPanel getLblCasilla38() {
        return lblCasilla38;
    }

    public void setLblCasilla38(JPanel lblCasilla38) {
        this.lblCasilla38 = lblCasilla38;
    }

    public JPanel getLblCasilla39() {
        return lblCasilla39;
    }

    public void setLblCasilla39(JPanel lblCasilla39) {
        this.lblCasilla39 = lblCasilla39;
    }

    public JPanel getLblCasilla4() {
        return lblCasilla4;
    }

    public void setLblCasilla4(JPanel lblCasilla4) {
        this.lblCasilla4 = lblCasilla4;
    }

    public JPanel getLblCasilla40() {
        return lblCasilla40;
    }

    public void setLblCasilla40(JPanel lblCasilla40) {
        this.lblCasilla40 = lblCasilla40;
    }

    public JPanel getLblCasilla5() {
        return lblCasilla5;
    }

    public void setLblCasilla5(JPanel lblCasilla5) {
        this.lblCasilla5 = lblCasilla5;
    }

    public JPanel getLblCasilla6() {
        return lblCasilla6;
    }

    public void setLblCasilla6(JPanel lblCasilla6) {
        this.lblCasilla6 = lblCasilla6;
    }

    public JPanel getLblCasilla7() {
        return lblCasilla7;
    }

    public void setLblCasilla7(JPanel lblCasilla7) {
        this.lblCasilla7 = lblCasilla7;
    }

    public JPanel getLblCasilla8() {
        return lblCasilla8;
    }

    public void setLblCasilla8(JPanel lblCasilla8) {
        this.lblCasilla8 = lblCasilla8;
    }

    public JPanel getLblCasilla9() {
        return lblCasilla9;
    }

    public void setLblCasilla9(JPanel lblCasilla9) {
        this.lblCasilla9 = lblCasilla9;
    }
    
    
    
    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        
        try {
            // TODO add your handling code here:
            refCliente.hiloCliente.writer.writeInt(2);      // Se envia al servidor la accion de enviar un mensaje por chat y se envia el mensaje
            refCliente.hiloCliente.writer.writeUTF(this.getLblNombreJugador().getText());
            refCliente.hiloCliente.writer.writeUTF(txfMensaje.getText());
        } catch (IOException ex) {

        }
        this.getTxfMensaje().setText("");
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnLanzarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLanzarDadosActionPerformed

        if (this.getRefCliente().getHiloCliente().isTurnoConseguido() && !this.getRefCliente().getHiloCliente().isDadosTirados()){
            if (!this.getLblNombreJugador().getText().equals(this.getLblTurno().getText())){
                
                this.getTxaHistorial().append("Error: No puede lanzar los dados porque no es su turno.\n");
                return;
            }
            
            Random random = new Random();
            int dado1 = random.nextInt(6); // se hace pasar de 0-5 a 1-6 sumandole 1 al resultado
            dado1 = dado1 + 1;
            
            this.getLblNumDado1().setText(""+dado1);
        
            int dado2 = random.nextInt(6); // se hace pasar de 0-5 a 1-6 sumandole 1 al resultado
            dado2 = dado2 + 1;
            this.getLblNumDado2().setText(""+dado2);
        
            int dadoTotal = dado1+dado2;
            String nombreFicha = this.getRefCliente().getHiloCliente().getFicha().getNombre();
            int posFicha = this.getRefCliente().getHiloCliente().getFicha().getPosicionActual();
            
            int arcaJail = 0;
            
            if (this.getRefCliente().getHiloCliente().isEnLaCarcel() && dado1 != 5 && dado2 != 5){
                int numFailsCarcel = this.getRefCliente().getHiloCliente().getNumFailsCarcel();
                numFailsCarcel = numFailsCarcel + 1;
                this.getRefCliente().getHiloCliente().setNumFailsCarcel(numFailsCarcel);
                
                if (numFailsCarcel == 3){
                    this.getRefCliente().getHiloCliente().setNumFailsCarcel(0);
                    this.getRefCliente().getHiloCliente().getBanco().retirarDinero(this.getRefCliente().getHiloCliente(), 50);
        
                    this.getLblNumDinero().setText(this.getRefCliente().getHiloCliente().getDinero() + " $");
                    this.getLblNumDinero().revalidate();
                    this.getLblNumDinero().repaint();
        
                    this.getRefCliente().getHiloCliente().setEnLaCarcel(false);
                    this.getRefCliente().getHiloCliente().setDadosTirados(true);
                    try {
                        this.getRefCliente().getHiloCliente().getWriter().writeInt(7);
                        this.getRefCliente().getHiloCliente().getWriter().writeUTF("El jugador " + this.getRefCliente().getHiloCliente().getNombre() + " pagó $50 para liberarse de la cárcel y puede moverse.");
                    } catch (IOException ex) {
                    Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    try {
                        this.getRefCliente().getHiloCliente().getWriter().writeInt(11);
                        this.getRefCliente().getHiloCliente().getWriter().writeInt(dadoTotal);
                        this.getRefCliente().getHiloCliente().getWriter().writeUTF(nombreFicha);
                        this.getRefCliente().getHiloCliente().getWriter().writeInt(posFicha);
                        this.getRefCliente().getHiloCliente().getWriter().writeInt(arcaJail);
                        
                        this.getRefCliente().getHiloCliente().getWriter().writeInt(7);
                        this.getRefCliente().getHiloCliente().getWriter().writeUTF("El jugador " + this.getRefCliente().getHiloCliente().getNombre() + " se movió " + dadoTotal + " espacios.");
                    } catch (IOException ex) {
                        Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    try {
                    // TODO add your handling code here:
                        this.getRefCliente().getHiloCliente().revisarPerder(this.getRefCliente().getHiloCliente().getPerdioPor());
                        this.getRefCliente().getHiloCliente().writer.writeInt(20);
                    } catch (IOException ex) {
                        Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    this.getRefCliente().getHiloCliente().setDadosTirados(true);
                    return;
                }
                else{
                    try {
                        this.getRefCliente().getHiloCliente().getWriter().writeInt(7);
                        this.getRefCliente().getHiloCliente().getWriter().writeUTF("El jugador " + this.getRefCliente().getHiloCliente().getNombre() + " no sacó doble cinco y ya no se puede mover por este turno.");
                        this.getRefCliente().getHiloCliente().setDadosTirados(true);
                        return;
                    } catch (IOException ex) {
                        Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
            else if (this.getRefCliente().getHiloCliente().isEnLaCarcel() && dado1 == 5 && dado2 == 5){
                this.getRefCliente().getHiloCliente().setNumFailsCarcel(0);
                try {
                        this.getRefCliente().getHiloCliente().getWriter().writeInt(7);
                        this.getRefCliente().getHiloCliente().getWriter().writeUTF("El jugador " + this.getRefCliente().getHiloCliente().getNombre() + " sacó doble cinco y puede moverse.");
                        this.getRefCliente().getHiloCliente().setDadosTirados(false);
                        this.getRefCliente().getHiloCliente().setEnLaCarcel(false);
                        this.getRefCliente().getHiloCliente().setVecesDobles(0);
                        return;
                    } catch (IOException ex) {
                        Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            
            try {
                this.getRefCliente().getHiloCliente().getWriter().writeInt(11);
                this.getRefCliente().getHiloCliente().getWriter().writeInt(dadoTotal);
                this.getRefCliente().getHiloCliente().getWriter().writeUTF(nombreFicha);
                this.getRefCliente().getHiloCliente().getWriter().writeInt(posFicha);
                this.getRefCliente().getHiloCliente().getWriter().writeInt(arcaJail);
                
                this.getRefCliente().getHiloCliente().getWriter().writeInt(7);
                this.getRefCliente().getHiloCliente().getWriter().writeUTF("El jugador " + this.getRefCliente().getHiloCliente().getNombre() + " se movió " + dadoTotal + " espacios.");
            } catch (IOException ex) {
                Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                    // TODO add your handling code here:
                this.getRefCliente().getHiloCliente().revisarPerder(this.getRefCliente().getHiloCliente().getPerdioPor());
                this.getRefCliente().getHiloCliente().writer.writeInt(20);
            } catch (IOException ex) {
                Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (this.getRefCliente().getHiloCliente().isPerdido()){
                if (this.getRefCliente().getHiloCliente().getDinero() <= 0)
                    this.getRefCliente().getHiloCliente().setDinero(0);
                this.getLblNumDinero().setText(this.getRefCliente().getHiloCliente().getDinero() + " $");
                this.getLblNumDinero().revalidate();
                this.getLblNumDinero().repaint();
                try {
                    this.getRefCliente().getHiloCliente().writer.writeInt(21);
                    this.getRefCliente().getHiloCliente().writer.writeUTF(this.getRefCliente().getHiloCliente().getNombre());
                    this.getRefCliente().getHiloCliente().writer.writeUTF(this.getRefCliente().getHiloCliente().getPerdioPor());
                    this.getRefCliente().getHiloCliente().writer.writeUTF("El jugador " + this.getRefCliente().getHiloCliente().getNombre() + " ha perdido. Estaba endeudado a " + this.getRefCliente().getHiloCliente().getPerdioPor() + ".");
                } catch (IOException ex) {
                    Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            if (dado1 != dado2){
                this.getRefCliente().getHiloCliente().setDadosTirados(true);
                this.getRefCliente().getHiloCliente().setVecesDobles(0);
            }
            
            else if (dado1 == dado2){
                int vecesDobles = this.getRefCliente().getHiloCliente().getVecesDobles();
                vecesDobles = vecesDobles + 1;
                this.getRefCliente().getHiloCliente().setVecesDobles(vecesDobles);
                
                if (vecesDobles == 3){
                    this.getRefCliente().getHiloCliente().setDadosTirados(true);
                    this.getRefCliente().getHiloCliente().setVecesDobles(0);
                    try {
                        this.getRefCliente().getHiloCliente().getWriter().writeInt(7);
                        this.getRefCliente().getHiloCliente().getWriter().writeUTF("El jugador " + this.getRefCliente().getHiloCliente().getNombre() + " sacó triples y fue a la cárcel.");
                        this.getRefCliente().getHiloCliente().setEnLaCarcel(true);
                        
                        int cantidadMoverse = 0;
                        for (int i = this.getRefCliente().getHiloCliente().getFicha().getCasillaFinal(); i != 10; i++){
                                        
                            if (i+1 > 39){
                                i = 0;
                            }
                                        
                            cantidadMoverse = cantidadMoverse + 1;
                            System.out.println(cantidadMoverse);
                        }
                        System.out.println(cantidadMoverse);
                        this.getRefCliente().getHiloCliente().moverFicha(cantidadMoverse, 1);
                    } catch (IOException ex) {
                        Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return;
                }
                else{
                    try {
                        this.getRefCliente().getHiloCliente().getWriter().writeInt(7);
                        this.getRefCliente().getHiloCliente().getWriter().writeUTF("El jugador " + this.getRefCliente().getHiloCliente().getNombre() + " sacó dobles y tirará otra vez.");
                    } catch (IOException ex) {
                    Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
            
            
        }
        else if (this.getRefCliente().getHiloCliente().isTurnoConseguido() && this.getRefCliente().getHiloCliente().isDadosTirados()){
            this.getTxaHistorial().append("Ya no puede volver a tirar los dados por este turno.\n");
            return;
        }
        
        else if (!this.getRefCliente().getHiloCliente().isTurnoConseguido()){
        Random random = new Random();
        int dado1 = random.nextInt(6); // se hace pasar de 0-5 a 1-6 sumandole 1 al resultado
        dado1 = dado1 + 1;
        this.getLblNumDado1().setText(""+dado1);
        
        int dado2 = random.nextInt(6); // se hace pasar de 0-5 a 1-6 sumandole 1 al resultado
        dado2 = dado2 + 1;
        this.getLblNumDado2().setText(""+dado2);
        
        int dadoTotal = dado1+dado2;
        
        System.out.println(dadoTotal);
        ArrayList<Integer> listaDados = (ArrayList<Integer>)FileManager.readObject("src/Partida/listadados.dat");
        if (listaDados.contains(dadoTotal)){
            this.getTxaHistorial().append(this.getLblNombreJugador().getText() + ", su resultado de dado es repetido. Por favor lance los dados de nuevo.\n");
            return;
        }
        this.getTxaHistorial().append(this.getLblNombreJugador().getText() + " obtuvo el resultado de dado " + dadoTotal + ".\n");
        this.getRefCliente().getHiloCliente().setTotalRoll(dadoTotal);
        listaDados.add(dadoTotal);
        System.out.println(listaDados);
        FileManager.writeObject(listaDados, "src/Partida/listadados.dat");
        ArrayList<String> listaNombres = (ArrayList<String>)FileManager.readObject("src/Partida/listanombres.dat");
        listaNombres.add(this.getRefCliente().getHiloCliente().getNombre());
        FileManager.writeObject(listaNombres, "src/Partida/listanombres.dat");
        this.getRefCliente().getHiloCliente().setTurnoConseguido(true);
        try {
            this.getRefCliente().getHiloCliente().getWriter().writeInt(3);
        } catch (IOException ex) {
            Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    }//GEN-LAST:event_btnLanzarDadosActionPerformed

    private void btnSeleccionFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionFichaActionPerformed
        // TODO add your handling code here:
        if (this.getRefCliente().getHiloCliente().getFicha() != null){
            
            this.getTxaHistorial().append("Error: No puede seleccionar una ficha porque ya seleccionó una.\n");
            return;
        }
        
        String seleccion = this.cbSeleccion.getSelectedItem().toString();
        System.out.println(seleccion);
        ArrayList<Ficha> listaFichas = (ArrayList<Ficha>)FileManager.readObject("src/Partida/listafichas.dat");
        
        if (seleccion.equals("Chikorita")){
            
            Ficha newFicha = new Ficha("Chikorita", "src/Imagenes/chikorita.png", this.getLblNombreJugador().getText());
            this.getRefCliente().getHiloCliente().setFicha(newFicha);
            JLabel newLabel = new JLabel("");
            newLabel.setVisible(true);
            //this.getLblGo().add(newLabel);
            newFicha.setLabelFicha(newLabel);
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(newFicha.getImagen()).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            newFicha.getLabelFicha().setIcon((imageIcon));
            System.out.println(newFicha.getLabelFicha().getIcon());
            newFicha.getLabelFicha().setVisible(true);
            listaFichas.add(newFicha);
            FileManager.writeObject(listaFichas, "src/Partida/listafichas.dat");
            try {
                this.getRefCliente().getHiloCliente().getWriter().writeInt(6);
            } catch (IOException ex) {
                Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.getLblFichaJugador().setIcon(imageIcon);
        }
        
        else if (seleccion.equals("Slowbro")){
            
            Ficha newFicha = new Ficha("Slowbro", "src/Imagenes/slowbro.png", this.getLblNombreJugador().getText());
            this.getRefCliente().getHiloCliente().setFicha(newFicha);
            JLabel newLabel = new JLabel("");
            newLabel.setVisible(true);
            //this.getLblGo().add(newLabel);
            newFicha.setLabelFicha(newLabel);
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(newFicha.getImagen()).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            newFicha.getLabelFicha().setIcon((imageIcon));
            System.out.println(newFicha.getLabelFicha().getIcon());
            newFicha.getLabelFicha().setVisible(true);
            listaFichas.add(newFicha);
            FileManager.writeObject(listaFichas, "src/Partida/listafichas.dat");
            try {
                this.getRefCliente().getHiloCliente().getWriter().writeInt(6);
            } catch (IOException ex) {
                Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.getLblFichaJugador().setIcon(imageIcon);
        }
        
        else if (seleccion.equals("Charizard")){
            
            Ficha newFicha = new Ficha("Charizard", "src/Imagenes/charizard.png", this.getLblNombreJugador().getText());
            this.getRefCliente().getHiloCliente().setFicha(newFicha);
            JLabel newLabel = new JLabel("");
            newLabel.setVisible(true);
            
            newFicha.setLabelFicha(newLabel);
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(newFicha.getImagen()).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            newFicha.getLabelFicha().setIcon((imageIcon));

            newFicha.getLabelFicha().setVisible(true);

            //this.getLblGo().add(newFicha.getLabelFicha());
            listaFichas.add(newFicha);
            FileManager.writeObject(listaFichas, "src/Partida/listafichas.dat");
            FileManager.writeObject(newFicha.getLabelFicha(), "src/Partida/prueba.dat");
            try {
                this.getRefCliente().getHiloCliente().getWriter().writeInt(6);
            } catch (IOException ex) {
                Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.getLblFichaJugador().setIcon(imageIcon);
        }
        
        else if (seleccion.equals("Pikachu")){
            
            Ficha newFicha = new Ficha("Pikachu", "src/Imagenes/pikachu.png", this.getLblNombreJugador().getText());
            this.getRefCliente().getHiloCliente().setFicha(newFicha);
            JLabel newLabel = new JLabel("");
            newLabel.setVisible(true);
            //this.getLblGo().add(newLabel);
            newFicha.setLabelFicha(newLabel);
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(newFicha.getImagen()).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            newFicha.getLabelFicha().setIcon((imageIcon));
            System.out.println(newFicha.getLabelFicha().getIcon());
            newFicha.getLabelFicha().setVisible(true);
            listaFichas.add(newFicha);
            FileManager.writeObject(listaFichas, "src/Partida/listafichas.dat");
            try {
                this.getRefCliente().getHiloCliente().getWriter().writeInt(6);
            } catch (IOException ex) {
                Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.getLblFichaJugador().setIcon(imageIcon);
        }
        
        else if (seleccion.equals("Yamper")){
            
            Ficha newFicha = new Ficha("Yamper", "src/Imagenes/yamper.png", this.getLblNombreJugador().getText());
            this.getRefCliente().getHiloCliente().setFicha(newFicha);
            JLabel newLabel = new JLabel("");
            newLabel.setVisible(true);
            //this.getLblGo().add(newLabel);
            newFicha.setLabelFicha(newLabel);
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(newFicha.getImagen()).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            newFicha.getLabelFicha().setIcon((imageIcon));
            System.out.println(newFicha.getLabelFicha().getIcon());
            newFicha.getLabelFicha().setVisible(true);
            listaFichas.add(newFicha);
            FileManager.writeObject(listaFichas, "src/Partida/listafichas.dat");
            try {
                this.getRefCliente().getHiloCliente().getWriter().writeInt(6);
            } catch (IOException ex) {
                Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.getLblFichaJugador().setIcon(imageIcon);
        }
        
        else if (seleccion.equals("Rayquaza")){
            
            Ficha newFicha = new Ficha("Rayquaza", "src/Imagenes/rayquaza.png", this.getLblNombreJugador().getText());
            this.getRefCliente().getHiloCliente().setFicha(newFicha);
            JLabel newLabel = new JLabel("");
            newLabel.setVisible(true);
            //this.getLblGo().add(newLabel);
            newFicha.setLabelFicha(newLabel);
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(newFicha.getImagen()).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            newFicha.getLabelFicha().setIcon((imageIcon));
            System.out.println(newFicha.getLabelFicha().getIcon());
            newFicha.getLabelFicha().setVisible(true);
            listaFichas.add(newFicha);
            FileManager.writeObject(listaFichas, "src/Partida/listafichas.dat");
            try {
                this.getRefCliente().getHiloCliente().getWriter().writeInt(6);
            } catch (IOException ex) {
                Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.getLblFichaJugador().setIcon(imageIcon);
        }
        
        else if (seleccion.equals("Suicune")){
            
            Ficha newFicha = new Ficha("Suicune", "src/Imagenes/suicune.png", this.getLblNombreJugador().getText());
            this.getRefCliente().getHiloCliente().setFicha(newFicha);
            JLabel newLabel = new JLabel("");
            newLabel.setVisible(true);
            //this.getLblGo().add(newLabel);
            newFicha.setLabelFicha(newLabel);
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(newFicha.getImagen()).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            newFicha.getLabelFicha().setIcon((imageIcon));
            System.out.println(newFicha.getLabelFicha().getIcon());
            newFicha.getLabelFicha().setVisible(true);
            listaFichas.add(newFicha);
            FileManager.writeObject(listaFichas, "src/Partida/listafichas.dat");
            try {
                this.getRefCliente().getHiloCliente().getWriter().writeInt(6);
            } catch (IOException ex) {
                Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.getLblFichaJugador().setIcon(imageIcon);
        }
        
        else if (seleccion.equals("Entei")){
            
            Ficha newFicha = new Ficha("Entei", "src/Imagenes/entei.png", this.getLblNombreJugador().getText());
            this.getRefCliente().getHiloCliente().setFicha(newFicha);
            JLabel newLabel = new JLabel("");
            newLabel.setVisible(true);
            newFicha.setLabelFicha(newLabel);
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(newFicha.getImagen()).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            newFicha.getLabelFicha().setIcon((imageIcon));
            newFicha.getLabelFicha().setVisible(true);
            listaFichas.add(newFicha);
            FileManager.writeObject(listaFichas, "src/Partida/listafichas.dat");
            try {
                this.getRefCliente().getHiloCliente().getWriter().writeInt(6);
            } catch (IOException ex) {
                Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.getLblFichaJugador().setIcon(imageIcon);
        }
        
        else if (seleccion.equals("Raikou")){
            
            Ficha newFicha = new Ficha("Raikou", "src/Imagenes/raikou.png", this.getLblNombreJugador().getText());
            this.getRefCliente().getHiloCliente().setFicha(newFicha);
            JLabel newLabel = new JLabel("");
            newLabel.setVisible(true);
            //this.getLblGo().add(newLabel);
            newFicha.setLabelFicha(newLabel);
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(newFicha.getImagen()).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            newFicha.getLabelFicha().setIcon((imageIcon));
            System.out.println(newFicha.getLabelFicha().getIcon());
            newFicha.getLabelFicha().setVisible(true);
            listaFichas.add(newFicha);
            FileManager.writeObject(listaFichas, "src/Partida/listafichas.dat");
            try {
                this.getRefCliente().getHiloCliente().getWriter().writeInt(6);
            } catch (IOException ex) {
                Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.getLblFichaJugador().setIcon(imageIcon);
        }
        
        else if (seleccion.equals("Mewtwo")){
            
            Ficha newFicha = new Ficha("Mewtwo", "src/Imagenes/mewtwo.png", this.getLblNombreJugador().getText());
            this.getRefCliente().getHiloCliente().setFicha(newFicha);
            JLabel newLabel = new JLabel("");
            newLabel.setVisible(true);
            //this.getLblGo().add(newLabel);
            newFicha.setLabelFicha(newLabel);
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(newFicha.getImagen()).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            newFicha.getLabelFicha().setIcon((imageIcon));
            System.out.println(newFicha.getLabelFicha().getIcon());
            newFicha.getLabelFicha().setVisible(true);
            listaFichas.add(newFicha);
            FileManager.writeObject(listaFichas, "src/Partida/listafichas.dat");
            try {
                this.getRefCliente().getHiloCliente().getWriter().writeInt(6);
            } catch (IOException ex) {
                Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.getLblFichaJugador().setIcon(imageIcon);
        }
        
        else if (seleccion.equals("Espeon")){
            
            Ficha newFicha = new Ficha("Espeon", "src/Imagenes/espeon.png", this.getLblNombreJugador().getText());
            this.getRefCliente().getHiloCliente().setFicha(newFicha);
            JLabel newLabel = new JLabel("");
            newLabel.setVisible(true);
            //this.getLblGo().add(newLabel);
            newFicha.setLabelFicha(newLabel);
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(newFicha.getImagen()).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            newFicha.getLabelFicha().setIcon((imageIcon));
            System.out.println(newFicha.getLabelFicha().getIcon());
            newFicha.getLabelFicha().setVisible(true);
            listaFichas.add(newFicha);
            FileManager.writeObject(listaFichas, "src/Partida/listafichas.dat");
            try {
                this.getRefCliente().getHiloCliente().getWriter().writeInt(6);
            } catch (IOException ex) {
                Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.getLblFichaJugador().setIcon(imageIcon);
        }
        
        else if (seleccion.equals("Ditto")){
            
            Ficha newFicha = new Ficha("Ditto", "src/Imagenes/ditto.png", this.getLblNombreJugador().getText());
            this.getRefCliente().getHiloCliente().setFicha(newFicha);
            JLabel newLabel = new JLabel("");
            newLabel.setVisible(true);
            //this.getLblGo().add(newLabel);
            newFicha.setLabelFicha(newLabel);
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(newFicha.getImagen()).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            newFicha.getLabelFicha().setIcon((imageIcon));
            System.out.println(newFicha.getLabelFicha().getIcon());
            newFicha.getLabelFicha().setVisible(true);
            listaFichas.add(newFicha);
            FileManager.writeObject(listaFichas, "src/Partida/listafichas.dat");
            try {
                this.getRefCliente().getHiloCliente().getWriter().writeInt(6);
            } catch (IOException ex) {
                Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.getLblFichaJugador().setIcon(imageIcon);
        }
        
        else if (seleccion.equals("Cyndaquil")){
            
            Ficha newFicha = new Ficha("Cyndaquil", "src/Imagenes/cyndaquil.png", this.getLblNombreJugador().getText());
            this.getRefCliente().getHiloCliente().setFicha(newFicha);
            JLabel newLabel = new JLabel("");
            newLabel.setVisible(true);
            //this.getLblGo().add(newLabel);
            newFicha.setLabelFicha(newLabel);
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(newFicha.getImagen()).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            newFicha.getLabelFicha().setIcon((imageIcon));
            System.out.println(newFicha.getLabelFicha().getIcon());
            newFicha.getLabelFicha().setVisible(true);
            listaFichas.add(newFicha);
            FileManager.writeObject(listaFichas, "src/Partida/listafichas.dat");
            try {
                this.getRefCliente().getHiloCliente().getWriter().writeInt(6);
            } catch (IOException ex) {
                Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.getLblFichaJugador().setIcon(imageIcon);
        }
        
        else if (seleccion.equals("Totodile")){
            
            Ficha newFicha = new Ficha("Totodile", "src/Imagenes/totodile.png", this.getLblNombreJugador().getText());
            this.getRefCliente().getHiloCliente().setFicha(newFicha);
            JLabel newLabel = new JLabel("");
            newLabel.setVisible(true);
            //this.getLblGo().add(newLabel);
            newFicha.setLabelFicha(newLabel);
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(newFicha.getImagen()).getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            newFicha.getLabelFicha().setIcon((imageIcon));
            System.out.println(newFicha.getLabelFicha().getIcon());
            newFicha.getLabelFicha().setVisible(true);
            listaFichas.add(newFicha);
            FileManager.writeObject(listaFichas, "src/Partida/listafichas.dat");
            try {
                this.getRefCliente().getHiloCliente().getWriter().writeInt(6);
            } catch (IOException ex) {
                Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.getLblFichaJugador().setIcon(imageIcon);
        }
        
        try {
            this.getRefCliente().getHiloCliente().getWriter().writeInt(7);
            this.getRefCliente().getHiloCliente().getWriter().writeUTF("El jugador " + this.getRefCliente().getHiloCliente().getNombre() + " seleccionó la ficha " + seleccion);
        } catch (IOException ex) {
            Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnSeleccionFichaActionPerformed

    private void btnEndTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndTurnActionPerformed
        // TODO add your handling code here:
        if (!this.getLblNombreJugador().getText().equals(this.getLblTurno().getText())){
            
            this.getTxaHistorial().append("Error: No puede terminar su turno porque no es su turno.\n");
            return;
        }
        
        this.getRefCliente().getHiloCliente().setDadosTirados(false);        
        try {
                this.getRefCliente().getHiloCliente().writer.writeInt(9);
                this.getRefCliente().getHiloCliente().writer.writeUTF(this.getLblNombreJugador().getText());
                this.getRefCliente().getHiloCliente().getWriter().writeInt(7);
                this.getRefCliente().getHiloCliente().getWriter().writeUTF("El jugador " + this.getRefCliente().getHiloCliente().getNombre() + " terminó su turno.");
            } catch (IOException ex) {
                Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnEndTurnActionPerformed

    private void btnComprarPropActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarPropActualActionPerformed
        if (!this.getLblTurno().getText().equalsIgnoreCase(this.getRefCliente().getHiloCliente().getNombre())){
            this.getTxaHistorial().append("Error: No puede comprar si no es su turno.\n");
            return;
        }
        
        if (!this.getRefCliente().getHiloCliente().isVueltaDada()){
            
            this.getTxaHistorial().append("Error: No puede comprar una propiedad todavia ya que no ha dado una vuelta.\n");
            return;
        }
        
        
        int casillaTablero = this.getRefCliente().getHiloCliente().getFicha().getPosicionActual();
        Propiedades propiedadComprar = (Propiedades) this.getRefCliente().getHiloCliente().getTablero().getCasillas().get(casillaTablero);
        int precioPropiedad = propiedadComprar.getPrecioCompra();
        
        if (propiedadComprar.getNombre().contains("Impuestos") || propiedadComprar.getNombre().contains("Arca") || propiedadComprar.getNombre().contains("Fortuna") || propiedadComprar.getNombre().contains("Go") || propiedadComprar.getNombre().contains("cárcel")){
            
            this.getTxaHistorial().append("Error: No puede comprar la casilla solicitada.\n");
            return;
            
        }
        
        if (this.getRefCliente().getHiloCliente().getDinero() <= precioPropiedad){
            
            this.getTxaHistorial().append("Error: No puede comprar esta propiedad ya que no tiene suficiente dinero para hacerlo.\n");
            return;
        }
        
        try {
            // TODO add your handling code here:
            this.getRefCliente().getHiloCliente().writer.writeInt(13);
            
            int numDado1 = Integer.parseInt(this.getLblNumDado1().getText());
            int numDado2 = Integer.parseInt(this.getLblNumDado2().getText());
            int numDadoTotal = numDado1 + numDado2;
            this.getRefCliente().getHiloCliente().writer.writeInt(numDadoTotal);
            
            String nombreComprador = this.getRefCliente().getHiloCliente().getNombre();
            this.getRefCliente().getHiloCliente().writer.writeUTF(nombreComprador);
            
            this.getRefCliente().getHiloCliente().writer.writeInt(this.getRefCliente().getHiloCliente().getDinero());
            this.getRefCliente().getHiloCliente().writer.writeInt(this.getRefCliente().getHiloCliente().getFicha().getPosicionActual());
            
            this.getRefCliente().getHiloCliente().getWriter().writeInt(7);
            this.getRefCliente().getHiloCliente().getWriter().writeUTF("El jugador " + this.getRefCliente().getHiloCliente().getNombre() + " compró la propiedad " + propiedadComprar.getNombre() + " por la cantidad " + propiedadComprar.getPrecioCompra() + ".");
        } catch (IOException ex) {
            Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnComprarPropActualActionPerformed

    private void btnCompraCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraCasaActionPerformed
        if (!this.getLblTurno().getText().equalsIgnoreCase(this.getRefCliente().getHiloCliente().getNombre())){
            this.getTxaHistorial().append("Error: No puede comprar si no es su turno.\n");
            return;
        }
        
        if (this.getCbPropiedades().getItemCount() == 0){
            this.getTxaHistorial().append("Error: Todavía no ha comprado ninguna propiedad.\n");
            return;
        }
        
        String nombrePropiedad = this.getCbPropiedades().getSelectedItem().toString();
        Propiedades propiedadComprarCasa;
        
        if (nombrePropiedad.contains("Ferrocarril") || nombrePropiedad.contains("Servicios")){
            this.getTxaHistorial().append("Error: No se pueden poner casas ni hoteles en esta propiedad.\n");
            return;
        }
        
        for (int i = 0; i < this.getRefCliente().getHiloCliente().getTablero().getCasillas().size(); i++){
           Propiedades propiedadActual = (Propiedades)this.getRefCliente().getHiloCliente().getTablero().getCasillas().get(i);
           
           if (propiedadActual.getNombre().equalsIgnoreCase(nombrePropiedad)){
               Calles calleActual = (Calles)propiedadActual;
               System.out.println(propiedadActual.getCantidadCasas());
               if (propiedadActual.getCantidadCasas() == 4){
                   this.getTxaHistorial().append("Error: No puede poner más casas en esta propiedad.\n");
                   return;
               }
               
               if (calleActual.getPrecioCasa() >= this.getRefCliente().getHiloCliente().getDinero()){
                   this.getTxaHistorial().append("No tiene suficiente dinero para comprar una casa en esta propiedad.\n");
                   return;
               }
               
               if (propiedadActual.getColor().equalsIgnoreCase("Azul") && this.getRefCliente().getHiloCliente().getContadorAzul() != 2){
                   this.getTxaHistorial().append("Error: Necesita todas las propiedades del grupo de color azul para poner edificios en esta propiedad.\n");
                   return;
               }
               
               if (propiedadActual.getColor().equalsIgnoreCase("Verde") && this.getRefCliente().getHiloCliente().getContadorVerde() != 3){
                   this.getTxaHistorial().append("Error: Necesita todas las propiedades del grupo de color verde para poner edificios.\n");
                   return;
               }
               
               if (propiedadActual.getColor().equalsIgnoreCase("Amarillo") && this.getRefCliente().getHiloCliente().getContadorAmarillo() != 3){
                   this.getTxaHistorial().append("Error: Necesita todas las propiedades del grupo de color amarillo para poner edificios.\n");
                   return;
               }
               
               if (propiedadActual.getColor().equalsIgnoreCase("Naranja") && this.getRefCliente().getHiloCliente().getContadorNaranja() != 3){
                   this.getTxaHistorial().append("Error: Necesita todas las propiedades del grupo de color naranja para poner edificios.\n");
                   return;
               }
               
               if (propiedadActual.getColor().equalsIgnoreCase("Rojo") && this.getRefCliente().getHiloCliente().getContadorRojo() != 3){
                   this.getTxaHistorial().append("Error: Necesita todas las propiedades del grupo de color rojo para poner edificios.\n");
                   return;
               }
               
               if (propiedadActual.getColor().equalsIgnoreCase("Rosado") && this.getRefCliente().getHiloCliente().getContadorRosado() != 3){
                   this.getTxaHistorial().append("Error: Necesita todas las propiedades del grupo de color rosado para poner edificios.\n");
                   return;
               }
               
               if (propiedadActual.getColor().equalsIgnoreCase("Celeste") && this.getRefCliente().getHiloCliente().getContadorCeleste() != 3){
                   this.getTxaHistorial().append("Error: Necesita todas las propiedades del grupo de color celeste para poner edificios.\n");
                   return;
               }
               
               if (propiedadActual.getColor().equalsIgnoreCase("Rojo oscuro") && this.getRefCliente().getHiloCliente().getContadorRojoOscuro() != 2){
                   this.getTxaHistorial().append("Error: Necesita todas las propiedades del grupo de color rojo oscuro para poner edificios.\n");
                   return;
               }
               
              ArrayList<Propiedades> propiedadesColor = new ArrayList<Propiedades>();
              for (int j = 0; j < this.getRefCliente().getHiloCliente().getTablero().getCasillas().size(); j++){
                  
                  Propiedades propiedadCurrent = (Propiedades)this.getRefCliente().getHiloCliente().getTablero().getCasillas().get(j);
                  if (propiedadCurrent.getColor().equalsIgnoreCase(propiedadActual.getColor())){
                      propiedadesColor.add(propiedadCurrent);
                      System.out.println(propiedadCurrent);
                  }
                  
              }
              System.out.println(propiedadesColor);
              
              for (int k = 0; k < propiedadesColor.size(); k++){
                  int numCasasActual = Integer.parseInt(propiedadActual.getLblCasas().getText());
                  int numCasasOtro = Integer.parseInt(propiedadesColor.get(k).getLblCasas().getText());
                  System.out.println(numCasasActual);
                  System.out.println(numCasasOtro);
                  
                  if (numCasasActual+1 != numCasasOtro && numCasasActual+1 != numCasasOtro+1){
                      this.getTxaHistorial().append("Todas sus propiedades de este color deben tener uniformidad en el numero de casas.\n");
                      return;
                  }
                  
              }
              
           }
            
        }
        
        System.out.println("Casa comprada succesfully");
        
        try {
            this.getRefCliente().getHiloCliente().writer.writeInt(14);
            this.getRefCliente().getHiloCliente().writer.writeUTF(this.getRefCliente().getHiloCliente().getNombre());
            this.getRefCliente().getHiloCliente().writer.writeUTF(nombrePropiedad);
                    
            //this.getRefCliente().getHiloCliente().getWriter().writeInt(7);
            //this.getRefCliente().getHiloCliente().getWriter().writeUTF("El jugador " + this.getRefCliente().getHiloCliente().getNombre() + " compró una casa en la propiedad " + nombrePropiedad + ".");
            
        } catch (IOException ex) {
            Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCompraCasaActionPerformed

    private void txfMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfMensajeActionPerformed
        try {
            // TODO add your handling code here:
            refCliente.hiloCliente.writer.writeInt(2);      // Se envia al servidor la accion de enviar un mensaje por chat y se envia el mensaje
            refCliente.hiloCliente.writer.writeUTF(this.getLblNombreJugador().getText());
            refCliente.hiloCliente.writer.writeUTF(txfMensaje.getText());
        } catch (IOException ex) {

        }
        this.getTxfMensaje().setText("");
    }//GEN-LAST:event_txfMensajeActionPerformed

    private void btnCompraHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraHotelActionPerformed
        // TODO add your handling code here:
        if (!this.getLblTurno().getText().equalsIgnoreCase(this.getRefCliente().getHiloCliente().getNombre())){
            this.getTxaHistorial().append("Error: No puede comprar si no es su turno.\n");
            return;
        }
        
        if (this.getCbPropiedades().getItemCount() == 0){
            this.getTxaHistorial().append("Error: Todavía no ha comprado ninguna propiedad.\n");
            return;
        }
        
        String nombrePropiedad = this.getCbPropiedades().getSelectedItem().toString();
        Propiedades propiedadComprarHotel;
        
        for (int i = 0; i < this.getRefCliente().getHiloCliente().getTablero().getCasillas().size(); i++){
            Propiedades propiedadActual = (Propiedades)this.getRefCliente().getHiloCliente().getTablero().getCasillas().get(i);
            
            if (propiedadActual.getNombre().equalsIgnoreCase(nombrePropiedad)){
                
                if (propiedadActual.getCantidadCasas() != 4){
                    this.getTxaHistorial().append("No puede comprar un hotel en esta propiedad ya que esta no tiene 4 casas todavía.\n");
                    return;
                }
                propiedadComprarHotel = propiedadActual;
                
            }
            
        }
        
        try {
            // TODO add your handling code here:
            refCliente.hiloCliente.writer.writeInt(17);      // Se envia al servidor la accion de enviar un mensaje por chat y se envia el mensaje
            refCliente.hiloCliente.writer.writeUTF(this.getRefCliente().getHiloCliente().getNombre());
            refCliente.hiloCliente.writer.writeUTF(nombrePropiedad);
            
            //this.getRefCliente().getHiloCliente().getWriter().writeInt(7);
            //this.getRefCliente().getHiloCliente().getWriter().writeUTF("El jugador " + this.getRefCliente().getHiloCliente().getNombre() + " compró un hotel en la propiedad " + nombrePropiedad + ".");
        } catch (IOException ex) {

        }
    }//GEN-LAST:event_btnCompraHotelActionPerformed

    private void btnVenderPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderPropActionPerformed
        // TODO add your handling code here:
        if (!this.getLblTurno().getText().equalsIgnoreCase(this.getRefCliente().getHiloCliente().getNombre())){
            this.getTxaHistorial().append("Error: No puede comprar si no es su turno.\n");
            return;
        }
        
        if (this.getCbPropiedades().getItemCount() == 0){
            this.getTxaHistorial().append("Error: No tiene propiedades que vender.\n");
            return;
        }
        int propiedadVenderInt = this.getCbPropiedades().getSelectedIndex();
        String propiedadVenderNombre = this.getCbPropiedades().getSelectedItem().toString();
        this.getCbPropiedades().removeItemAt(propiedadVenderInt);
        this.getCbPropiedades().repaint();
        this.getCbPropiedades().revalidate();
        
        System.out.println(propiedadVenderNombre);
        
        
        try {
            this.getRefCliente().getHiloCliente().getWriter().writeInt(15);
            this.getRefCliente().getHiloCliente().getWriter().writeUTF(propiedadVenderNombre);
            this.getRefCliente().getHiloCliente().getWriter().writeUTF(this.getRefCliente().getHiloCliente().getNombre());
            
            //this.getRefCliente().getHiloCliente().getWriter().writeInt(7);
            //this.getRefCliente().getHiloCliente().getWriter().writeUTF("El jugador " + this.getRefCliente().getHiloCliente().getNombre() + " vendió la propiedad " + propiedadVenderNombre);
        } catch (IOException ex) {
            Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnVenderPropActionPerformed

    private void btnConsultarDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarDerechaActionPerformed
        // TODO add your handling code here:
        String consultarJugador = this.getCbConsultarPropiedades().getSelectedItem().toString();
        
        try {
            this.getRefCliente().getHiloCliente().getWriter().writeInt(23);
            this.getRefCliente().getHiloCliente().getWriter().writeUTF(consultarJugador);
            this.getRefCliente().getHiloCliente().getWriter().writeUTF(this.getRefCliente().getHiloCliente().getNombre());
            this.getRefCliente().getHiloCliente().getWriter().writeInt(this.getRefCliente().getHiloCliente().getContadorConsultar());
        } catch (IOException ex) {
            Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnConsultarDerechaActionPerformed

    private void btnConsultarPropiedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarPropiedadActionPerformed
        // TODO add your handling code here:
        String consultarJugador = this.getCbConsultarPropiedades().getSelectedItem().toString();
        String nombreConsultador = this.getRefCliente().getHiloCliente().getNombre();
        
        try {
            this.getRefCliente().getHiloCliente().getWriter().writeInt(22);
            this.getRefCliente().getHiloCliente().getWriter().writeUTF(consultarJugador);
            this.getRefCliente().getHiloCliente().getWriter().writeUTF(nombreConsultador);
        } catch (IOException ex) {
            Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConsultarPropiedadActionPerformed

    private void btnConsultarIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarIzquierdaActionPerformed
        // TODO add your handling code here:
        String consultarJugador = this.getCbConsultarPropiedades().getSelectedItem().toString();
        
        try {
            this.getRefCliente().getHiloCliente().getWriter().writeInt(24);
            this.getRefCliente().getHiloCliente().getWriter().writeUTF(consultarJugador);
            this.getRefCliente().getHiloCliente().getWriter().writeUTF(this.getRefCliente().getHiloCliente().getNombre());
            this.getRefCliente().getHiloCliente().getWriter().writeInt(this.getRefCliente().getHiloCliente().getContadorConsultar());
        } catch (IOException ex) {
            Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConsultarIzquierdaActionPerformed

    private void btnAbrirServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirServerActionPerformed
        // TODO add your handling code here:
        PantallaServidor pantalla = new PantallaServidor();
        Servidor srv = new Servidor(pantalla);
        pantalla.setVisible(true);
        pantalla.setTitle("Servidor Pokenopoly");
        srv.start();
    }//GEN-LAST:event_btnAbrirServerActionPerformed

    private void btnConectarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarseActionPerformed
        // TODO add your handling code here:
        String nombre = JOptionPane.showInputDialog("Escriba su nombre:");
        this.getRefCliente().conectar(nombre);
    }//GEN-LAST:event_btnConectarseActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnVenderCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderCasaActionPerformed
        // TODO add your handling code here:
        if (!this.getLblTurno().getText().equalsIgnoreCase(this.getRefCliente().getHiloCliente().getNombre())){
            this.getTxaHistorial().append("Error: No puede comprar si no es su turno.\n");
            return;
        }
        
        if (this.getCbPropiedades().getItemCount() == 0){
            this.getTxaHistorial().append("Error: Todavía no ha comprado ninguna propiedad.\n");
            return;
        }
        
        String nombrePropiedad = this.getCbPropiedades().getSelectedItem().toString();
        Propiedades propiedadVenderCasa;
        
        if (nombrePropiedad.contains("Ferrocarril") || nombrePropiedad.contains("Servicios")){
            this.getTxaHistorial().append("Error: Los ferrocarriles y los servicios no pueden tener casas.\n");
            return;
        }
        
        for (int i = 0; i < this.getRefCliente().getHiloCliente().getTablero().getCasillas().size(); i++){
            Propiedades propiedadActual = (Propiedades)this.getRefCliente().getHiloCliente().getTablero().getCasillas().get(i);
            if (propiedadActual.getNombre().equalsIgnoreCase(nombrePropiedad)){
                
                if (propiedadActual.getCantidadCasas() == 0){
                    this.getTxaHistorial().append("No puede vender una casa en esta propiedad porque esta no tiene casas.\n");
                    return;
                }
                propiedadVenderCasa = propiedadActual;
                
            }
            
        }
        
        try {
            this.getRefCliente().getHiloCliente().getWriter().writeInt(16);
            this.getRefCliente().getHiloCliente().getWriter().writeUTF(nombrePropiedad);
            this.getRefCliente().getHiloCliente().getWriter().writeUTF(this.getRefCliente().getHiloCliente().getNombre());
            
            this.getRefCliente().getHiloCliente().getWriter().writeInt(7);
            this.getRefCliente().getHiloCliente().getWriter().writeUTF("El jugador " + this.getRefCliente().getHiloCliente().getNombre() + " vendió una casa en la propiedad " + nombrePropiedad + ".");
        } catch (IOException ex) {
            Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnVenderCasaActionPerformed

    private void btnVenderHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderHotelActionPerformed
        // TODO add your handling code here:
        if (!this.getLblTurno().getText().equalsIgnoreCase(this.getRefCliente().getHiloCliente().getNombre())){
            this.getTxaHistorial().append("Error: No puede comprar si no es su turno.\n");
            return;
        }
        
        if (this.getCbPropiedades().getItemCount() == 0){
            this.getTxaHistorial().append("Error: Todavía no ha comprado ninguna propiedad.\n");
            return;
        }
        
        String nombrePropiedad = this.getCbPropiedades().getSelectedItem().toString();
        Propiedades propiedadVenderHotel;
        
        if (nombrePropiedad.contains("Ferrocarril") || nombrePropiedad.contains("Servicios")){
            this.getTxaHistorial().append("Error: Los ferrocarriles y los servicios no pueden tener hoteles.\n");
            return;
        }
        
        for (int i = 0; i < this.getRefCliente().getHiloCliente().getTablero().getCasillas().size(); i++){
            Propiedades propiedadActual = (Propiedades)this.getRefCliente().getHiloCliente().getTablero().getCasillas().get(i);
            if (propiedadActual.getNombre().equalsIgnoreCase(nombrePropiedad)){
                
                if (propiedadActual.getCantidadHoteles() == 0){
                    this.getTxaHistorial().append("No puede vender un hotel en esta propiedad porque esta no tiene hoteles.\n");
                    return;
                }
                propiedadVenderHotel = propiedadActual;
                
            }
            
        }
        
        try {
            this.getRefCliente().getHiloCliente().getWriter().writeInt(18);
            this.getRefCliente().getHiloCliente().getWriter().writeUTF(nombrePropiedad);
            this.getRefCliente().getHiloCliente().getWriter().writeUTF(this.getRefCliente().getHiloCliente().getNombre());
            
            //this.getRefCliente().getHiloCliente().getWriter().writeInt(7);
            //this.getRefCliente().getHiloCliente().getWriter().writeUTF("El jugador " + this.getRefCliente().getHiloCliente().getNombre() + " vendió un hotel en la propiedad " + nombrePropiedad + ".");
        } catch (IOException ex) {
            Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnVenderHotelActionPerformed

    private void btnHipotecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHipotecarActionPerformed
        // TODO add your handling code here:
        if (!this.getLblTurno().getText().equalsIgnoreCase(this.getRefCliente().getHiloCliente().getNombre())){
            this.getTxaHistorial().append("Error: No puede comprar si no es su turno.\n");
            return;
        }
        
        if (this.getCbPropiedades().getItemCount() == 0){
            this.getTxaHistorial().append("Error: Todavía no ha comprado ninguna propiedad.\n");
            return;
        }
        
        String nombrePropiedad = this.getCbPropiedades().getSelectedItem().toString();
        
        for (int i = 0; i < this.getRefCliente().getHiloCliente().getTablero().getCasillas().size(); i++){
            Propiedades propiedadActual = (Propiedades)this.getRefCliente().getHiloCliente().getTablero().getCasillas().get(i);
            
            if (propiedadActual.getNombre().contains(nombrePropiedad)){
                if (propiedadActual.isHipotecada()){
                    double valorDeshipotecar = propiedadActual.getValorHipoteca() + (double)(propiedadActual.getValorHipoteca()/10);
                    System.out.println("El valor total para deshipotecar la propiedad es: " + valorDeshipotecar);
                    if (this.getRefCliente().getHiloCliente().getDinero() <= valorDeshipotecar){
                        this.getTxaHistorial().append("No puede deshipotecar esta propiedad ya que no tiene suficiente dinero para hacerlo.\n");
                        return;
                    }
                }
                
            }
            
        }
        
        try {
            this.getRefCliente().getHiloCliente().getWriter().writeInt(19);
            this.getRefCliente().getHiloCliente().getWriter().writeUTF(nombrePropiedad);
            this.getRefCliente().getHiloCliente().getWriter().writeUTF(this.getRefCliente().getHiloCliente().getNombre());
        } catch (IOException ex) {
            Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnHipotecarActionPerformed

    private void btnLiberadoCarcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLiberadoCarcelActionPerformed
        // TODO add your handling code here:
        if (!this.getLblTurno().getText().equalsIgnoreCase(this.getRefCliente().getHiloCliente().getNombre())){
            this.getTxaHistorial().append("Error: No puede liberarse de la carcel si no es su turno.\n");
            return;
        }
        
        if (!this.getRefCliente().getHiloCliente().isEnLaCarcel()){
            this.getTxaHistorial().append("No puede liberarse porque no está en la cárcel.\n");
            return;
        }
        
        if (this.getRefCliente().getHiloCliente().isEnLaCarcel() && !this.getLblTurno().getText().equalsIgnoreCase(this.getLblNombreJugador().getText())){
            this.getTxaHistorial().append("Solo se puede liberar de la cárcel cuando es su turno.\n");
            return;
        }
        
        this.getRefCliente().getHiloCliente().getBanco().retirarDinero(this.getRefCliente().getHiloCliente(), 50);
        
        this.getLblNumDinero().setText(this.getRefCliente().getHiloCliente().getDinero() + " $");
        this.getLblNumDinero().revalidate();
        this.getLblNumDinero().repaint();
        
        this.getRefCliente().getHiloCliente().setEnLaCarcel(false);
        this.getRefCliente().getHiloCliente().setDadosTirados(false);
        try {
            this.getRefCliente().getHiloCliente().getWriter().writeInt(7);
            this.getRefCliente().getHiloCliente().getWriter().writeUTF("El jugador " + this.getRefCliente().getHiloCliente().getNombre() + " pagó $50 para liberarse de la cárcel y puede moverse.");
        } catch (IOException ex) {
            Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLiberadoCarcelActionPerformed

    private void getOutOfJailFreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getOutOfJailFreeActionPerformed
        // TODO add your handling code here:
        if (!this.getLblTurno().getText().equalsIgnoreCase(this.getRefCliente().getHiloCliente().getNombre())){
            this.getTxaHistorial().append("Error: No puede liberarse de la carcel si no es su turno.\n");
            return;
        }
        
        if (this.getRefCliente().getHiloCliente().isGetOutOfJailFree()){
            
            this.getRefCliente().getHiloCliente().setGetOutOfJailFree(false);
            this.getRefCliente().getHiloCliente().setEnLaCarcel(false);
            this.getRefCliente().getHiloCliente().setDadosTirados(false);
            this.getLblGetOutOfJailFree().setText("No tiene");
            try {
                this.getRefCliente().getHiloCliente().getWriter().writeInt(7);
                this.getRefCliente().getHiloCliente().getWriter().writeUTF("El jugador " + this.getRefCliente().getHiloCliente().getNombre() + " usó su tarjeta de salir de la carcel gratis y puede moverse libremente.");
            } catch (IOException ex) {
                Logger.getLogger(InterfazCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else{
            this.getTxaHistorial().append("No puede usar una tarjeta de Get out of jail free porque no tiene una todavía.\n");
            return;
        }
        
    }//GEN-LAST:event_getOutOfJailFreeActionPerformed

    public JButton getBtnAbrirServer() {
        return btnAbrirServer;
    }

    public void setBtnAbrirServer(JButton btnAbrirServer) {
        this.btnAbrirServer = btnAbrirServer;
    }

    public JButton getBtnCompraCasa() {
        return btnCompraCasa;
    }

    public void setBtnCompraCasa(JButton btnCompraCasa) {
        this.btnCompraCasa = btnCompraCasa;
    }

    public JButton getBtnCompraHotel() {
        return btnCompraHotel;
    }

    public void setBtnCompraHotel(JButton btnCompraHotel) {
        this.btnCompraHotel = btnCompraHotel;
    }

    public JButton getBtnComprarPropActual() {
        return btnComprarPropActual;
    }

    public void setBtnComprarPropActual(JButton btnComprarPropActual) {
        this.btnComprarPropActual = btnComprarPropActual;
    }

    public JButton getBtnConectarse() {
        return btnConectarse;
    }

    public void setBtnConectarse(JButton btnConectarse) {
        this.btnConectarse = btnConectarse;
    }

    public JButton getBtnConsultarDerecha() {
        return btnConsultarDerecha;
    }

    public void setBtnConsultarDerecha(JButton btnConsultarDerecha) {
        this.btnConsultarDerecha = btnConsultarDerecha;
    }

    public JButton getBtnConsultarIzquierda() {
        return btnConsultarIzquierda;
    }

    public void setBtnConsultarIzquierda(JButton btnConsultarIzquierda) {
        this.btnConsultarIzquierda = btnConsultarIzquierda;
    }

    public JButton getBtnConsultarPropiedad() {
        return btnConsultarPropiedad;
    }

    public void setBtnConsultarPropiedad(JButton btnConsultarPropiedad) {
        this.btnConsultarPropiedad = btnConsultarPropiedad;
    }

    public JButton getBtnEndTurn() {
        return btnEndTurn;
    }

    public void setBtnEndTurn(JButton btnEndTurn) {
        this.btnEndTurn = btnEndTurn;
    }

    public JButton getBtnEnviar() {
        return btnEnviar;
    }

    public void setBtnEnviar(JButton btnEnviar) {
        this.btnEnviar = btnEnviar;
    }

    public JButton getBtnExit() {
        return btnExit;
    }

    public void setBtnExit(JButton btnExit) {
        this.btnExit = btnExit;
    }

    public JButton getBtnHipotecar() {
        return btnHipotecar;
    }

    public void setBtnHipotecar(JButton btnHipotecar) {
        this.btnHipotecar = btnHipotecar;
    }

    public JButton getBtnLanzarDados() {
        return btnLanzarDados;
    }

    public JLabel getLblQuedanCasas() {
        return lblQuedanCasas;
    }

    public void setLblQuedanCasas(JLabel lblQuedanCasas) {
        this.lblQuedanCasas = lblQuedanCasas;
    }

    public JLabel getLblQuedanHoteles() {
        return lblQuedanHoteles;
    }

    public void setLblQuedanHoteles(JLabel lblQuedanHoteles) {
        this.lblQuedanHoteles = lblQuedanHoteles;
    }

    
    
    public void setBtnLanzarDados(JButton btnLanzarDados) {
        this.btnLanzarDados = btnLanzarDados;
    }

    public JButton getBtnSeleccionFicha() {
        return btnSeleccionFicha;
    }

    public void setBtnSeleccionFicha(JButton btnSeleccionFicha) {
        this.btnSeleccionFicha = btnSeleccionFicha;
    }

    public JButton getBtnVenderEdificio() {
        return btnVenderCasa;
    }

    public void setBtnVenderEdificio(JButton btnVenderEdificio) {
        this.btnVenderCasa = btnVenderEdificio;
    }

    public JButton getBtnVenderProp() {
        return btnVenderProp;
    }

    public void setBtnVenderProp(JButton btnVenderProp) {
        this.btnVenderProp = btnVenderProp;
    }

    
    
    public JLabel getLblStatusPartida() {
        return lblStatusPartida;
    }

    public JComboBox<String> getCbConsultarPropiedades() {
        return cbConsultarPropiedades;
    }

    public void setCbConsultarPropiedades(JComboBox<String> cbConsultarPropiedades) {
        this.cbConsultarPropiedades = cbConsultarPropiedades;
    }

    public JPanel getPnlColorTituloPropiedad() {
        return pnlColorTituloPropiedad;
    }

    public void setPnlColorTituloPropiedad(JPanel pnlColorTituloPropiedad) {
        this.pnlColorTituloPropiedad = pnlColorTituloPropiedad;
    }

    public JPanel getPnlTituloPropiedad() {
        return pnlTituloPropiedad;
    }

    public void setPnlTituloPropiedad(JPanel pnlTituloPropiedad) {
        this.pnlTituloPropiedad = pnlTituloPropiedad;
    }

    public JLabel getLblAlquileresTitulo() {
        return lblAlquileresTitulo;
    }

    public void setLblAlquileresTitulo(JLabel lblAlquileresTitulo) {
        this.lblAlquileresTitulo = lblAlquileresTitulo;
    }

    public JLabel getLblCadaCasaCuesta() {
        return lblCadaCasaCuesta;
    }

    public void setLblCadaCasaCuesta(JLabel lblCadaCasaCuesta) {
        this.lblCadaCasaCuesta = lblCadaCasaCuesta;
    }

    public JLabel getLblCadaHotelCuesta() {
        return lblCadaHotelCuesta;
    }

    public void setLblCadaHotelCuesta(JLabel lblCadaHotelCuesta) {
        this.lblCadaHotelCuesta = lblCadaHotelCuesta;
    }

    public JLabel getLblCon1Casa() {
        return lblCon1Casa;
    }

    public void setLblCon1Casa(JLabel lblCon1Casa) {
        this.lblCon1Casa = lblCon1Casa;
    }

    public JPanel getPnlArcaComunal() {
        return pnlArcaComunal;
    }

    public void setPnlArcaComunal(JPanel pnlArcaComunal) {
        this.pnlArcaComunal = pnlArcaComunal;
    }

    public JPanel getPnlFortuna() {
        return pnlFortuna;
    }

    public void setPnlFortuna(JPanel pnlFortuna) {
        this.pnlFortuna = pnlFortuna;
    }
    
    

    public JLabel getLblCon2Casas() {
        return lblCon2Casas;
    }

    public void setLblCon2Casas(JLabel lblCon2Casas) {
        this.lblCon2Casas = lblCon2Casas;
    }

    public JLabel getLblCon3Casas() {
        return lblCon3Casas;
    }

    public void setLblCon3Casas(JLabel lblCon3Casas) {
        this.lblCon3Casas = lblCon3Casas;
    }

    public JLabel getLblCon4Casas() {
        return lblCon4Casas;
    }

    public void setLblCon4Casas(JLabel lblCon4Casas) {
        this.lblCon4Casas = lblCon4Casas;
    }

    public JLabel getLblConHotel() {
        return lblConHotel;
    }

    public void setLblConHotel(JLabel lblConHotel) {
        this.lblConHotel = lblConHotel;
    }

    public JLabel getLblHipotecaTitulo() {
        return lblHipotecaTitulo;
    }

    public void setLblHipotecaTitulo(JLabel lblHipotecaTitulo) {
        this.lblHipotecaTitulo = lblHipotecaTitulo;
    }

    public JLabel getLblNombreTituloPropiedad() {
        return lblNombreTituloPropiedad;
    }

    public void setLblNombreTituloPropiedad(JLabel lblNombreTituloPropiedad) {
        this.lblNombreTituloPropiedad = lblNombreTituloPropiedad;
    }

    public JLabel getLblTituloDePropiedad() {
        return lblTituloDePropiedad;
    }

    public void setLblTituloDePropiedad(JLabel lblTituloDePropiedad) {
        this.lblTituloDePropiedad = lblTituloDePropiedad;
    }
    
    

    public void setLblStatusPartida(JLabel lblStatusPartida) {
        this.lblStatusPartida = lblStatusPartida;
    }

    public JComboBox<String> getCbSeleccion() {
        return cbSeleccion;
    }

    public JComboBox<String> getCbPropiedades() {
        return cbPropiedades;
    }

    public void setCbPropiedades(JComboBox<String> cbPropiedades) {
        this.cbPropiedades = cbPropiedades;
    }
    
    public void setCbSeleccion(JComboBox<String> cbSeleccion) {
        this.cbSeleccion = cbSeleccion;
    }

    public JLabel getLblTurno() {
        return lblTurno;
    }

    public void setLblTurno(JLabel lblTurno) {
        this.lblTurno = lblTurno;
    }

    public JLabel getLblUsuarioLanzamiento() {
        return lblUsuarioLanzamiento;
    }

    public void setLblUsuarioLanzamiento(JLabel lblUsuarioLanzamiento) {
        this.lblUsuarioLanzamiento = lblUsuarioLanzamiento;
    }

    public JTextArea getTxaHistorial() {
        return txaHistorial;
    }

    public void setTxaHistorial(JTextArea txaHistorial) {
        this.txaHistorial = txaHistorial;
    }

    public JTextArea getTxaMensajes() {
        return txaMensajes;
    }

    public void setTxaMensajes(JTextArea txaMensajes) {
        this.txaMensajes = txaMensajes;
    }

    public JTextField getTxfMensaje() {
        return txfMensaje;
    }

    public void setTxfMensaje(JTextField txfMensaje) {
        this.txfMensaje = txfMensaje;
    }

    public JLabel getLblNumDinero() {
        return lblNumDinero;
    }

    public void setLblNumDinero(JLabel lblNumDinero) {
        this.lblNumDinero = lblNumDinero;
    }
    
    public void setFinalPartida(){
        this.lblStatusPartida.setText("Partida terminada");
        this.lblTurno.setText("Terminado");
    }

    public JLabel getLblGetOutOfJailFree() {
        return lblGetOutOfJailFree;
    }

    public void setLblGetOutOfJailFree(JLabel lblGetOutOfJailFree) {
        this.lblGetOutOfJailFree = lblGetOutOfJailFree;
    }
    
    

    
    public void setInicioPartida(){             // Configura la partida con los datos iniciales para empezarla
        lblStatusPartida.setText("Partida Iniciada");
        lblNumDinero.setText("Dinero: $" + refCliente.getHiloCliente().getDinero());
      //  lblNumCasas.setText("Numero de casas: " + refCliente.getHiloCliente().getNumCasas());
     //   lblNumHoteles.setText("Numero de hoteles: " + refCliente.getHiloCliente().getNumHoteles());
     //   lblNumPropiedades.setText("Numero de propiedades: " + refCliente.getHiloCliente().getNumPropiedades());
    }
    
    public void seleccionFicha(){
        
        //infoBox("Por favor escoja la ficha que desesa.","Selección de ficha");
        SeleccionFicha cbFicha = new SeleccionFicha(this);
        cbFicha.pack();
        cbFicha.setTitle("Por favor seleccione su ficha, " + nombreJugador);
        cbFicha.setVisible(true);
    }
    
    public void pintarLanzamientoDados (int valor1, int valor2, String usuario){    // Para escribir en la interfaz del cliente los valores de los dice rolls    
        
      //  lblDado1.setText(valor1 + "");
     //   lblDado2.setText(valor2 + "");
      //  lblDado1.setBackground(Color.red);
      //  lblDado2.setBackground(Color.red);
        
        if (!btnLanzarDados.isEnabled())
            btnLanzarDados.setEnabled(true);
        
        lblUsuarioLanzamiento.setText(usuario);
    }
    
    
    public void pintarTurno(String turno){              // Para escribir en la interfaz del cliente el jugador que está jugando actualmente
        this.nombreTurno = turno;
        lblTurno.setText(turno);
    }
    
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirServer;
    private javax.swing.JButton btnCompraCasa;
    private javax.swing.JButton btnCompraHotel;
    private javax.swing.JButton btnComprarPropActual;
    private javax.swing.JButton btnConectarse;
    private javax.swing.JButton btnConsultarDerecha;
    private javax.swing.JButton btnConsultarIzquierda;
    private javax.swing.JButton btnConsultarPropiedad;
    private javax.swing.JButton btnEndTurn;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHipotecar;
    private javax.swing.JButton btnLanzarDados;
    private javax.swing.JButton btnLiberadoCarcel;
    private javax.swing.JButton btnSeleccionFicha;
    private javax.swing.JButton btnVenderCasa;
    private javax.swing.JButton btnVenderHotel;
    private javax.swing.JButton btnVenderProp;
    private javax.swing.JComboBox<String> cbConsultarPropiedades;
    private javax.swing.JComboBox<String> cbPropiedades;
    private javax.swing.JComboBox<String> cbSeleccion;
    private javax.swing.JButton getOutOfJailFree;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel113;
    private javax.swing.JPanel jPanel116;
    private javax.swing.JPanel jPanel118;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblAdministrar;
    private javax.swing.JLabel lblAlquilerCasilla1;
    private javax.swing.JLabel lblAlquilerCasilla11;
    private javax.swing.JLabel lblAlquilerCasilla12;
    private javax.swing.JLabel lblAlquilerCasilla13;
    private javax.swing.JLabel lblAlquilerCasilla14;
    private javax.swing.JLabel lblAlquilerCasilla15;
    private javax.swing.JLabel lblAlquilerCasilla16;
    private javax.swing.JLabel lblAlquilerCasilla18;
    private javax.swing.JLabel lblAlquilerCasilla19;
    private javax.swing.JLabel lblAlquilerCasilla21;
    private javax.swing.JLabel lblAlquilerCasilla23;
    private javax.swing.JLabel lblAlquilerCasilla24;
    private javax.swing.JLabel lblAlquilerCasilla25;
    private javax.swing.JLabel lblAlquilerCasilla26;
    private javax.swing.JLabel lblAlquilerCasilla27;
    private javax.swing.JLabel lblAlquilerCasilla28;
    private javax.swing.JLabel lblAlquilerCasilla29;
    private javax.swing.JLabel lblAlquilerCasilla3;
    private javax.swing.JLabel lblAlquilerCasilla31;
    private javax.swing.JLabel lblAlquilerCasilla32;
    private javax.swing.JLabel lblAlquilerCasilla34;
    private javax.swing.JLabel lblAlquilerCasilla35;
    private javax.swing.JLabel lblAlquilerCasilla37;
    private javax.swing.JLabel lblAlquilerCasilla39;
    private javax.swing.JLabel lblAlquilerCasilla5;
    private javax.swing.JLabel lblAlquilerCasilla6;
    private javax.swing.JLabel lblAlquilerCasilla8;
    private javax.swing.JLabel lblAlquilerCasilla9;
    private javax.swing.JLabel lblAlquileresTitulo;
    private javax.swing.JLabel lblArcaComunal;
    private javax.swing.JLabel lblCadaCasaCuesta;
    private javax.swing.JLabel lblCadaHotelCuesta;
    private javax.swing.JLabel lblCarcel;
    private javax.swing.JLabel lblCasasCasilla1;
    private javax.swing.JLabel lblCasasCasilla11;
    private javax.swing.JLabel lblCasasCasilla13;
    private javax.swing.JLabel lblCasasCasilla14;
    private javax.swing.JLabel lblCasasCasilla16;
    private javax.swing.JLabel lblCasasCasilla18;
    private javax.swing.JLabel lblCasasCasilla19;
    private javax.swing.JLabel lblCasasCasilla21;
    private javax.swing.JLabel lblCasasCasilla23;
    private javax.swing.JLabel lblCasasCasilla24;
    private javax.swing.JLabel lblCasasCasilla26;
    private javax.swing.JLabel lblCasasCasilla27;
    private javax.swing.JLabel lblCasasCasilla29;
    private javax.swing.JLabel lblCasasCasilla3;
    private javax.swing.JLabel lblCasasCasilla31;
    private javax.swing.JLabel lblCasasCasilla32;
    private javax.swing.JLabel lblCasasCasilla34;
    private javax.swing.JLabel lblCasasCasilla37;
    private javax.swing.JLabel lblCasasCasilla39;
    private javax.swing.JLabel lblCasasCasilla6;
    private javax.swing.JLabel lblCasasCasilla8;
    private javax.swing.JLabel lblCasasCasilla9;
    private javax.swing.JPanel lblCasilla1;
    private javax.swing.JPanel lblCasilla10;
    private javax.swing.JPanel lblCasilla11;
    private javax.swing.JPanel lblCasilla12;
    private javax.swing.JPanel lblCasilla13;
    private javax.swing.JPanel lblCasilla14;
    private javax.swing.JPanel lblCasilla15;
    private javax.swing.JPanel lblCasilla16;
    private javax.swing.JPanel lblCasilla17;
    private javax.swing.JPanel lblCasilla18;
    private javax.swing.JPanel lblCasilla19;
    private javax.swing.JPanel lblCasilla2;
    private javax.swing.JPanel lblCasilla20;
    private javax.swing.JPanel lblCasilla21;
    private javax.swing.JPanel lblCasilla22;
    private javax.swing.JPanel lblCasilla23;
    private javax.swing.JPanel lblCasilla24;
    private javax.swing.JPanel lblCasilla25;
    private javax.swing.JPanel lblCasilla26;
    private javax.swing.JPanel lblCasilla27;
    private javax.swing.JPanel lblCasilla28;
    private javax.swing.JPanel lblCasilla29;
    private javax.swing.JPanel lblCasilla3;
    private javax.swing.JPanel lblCasilla30;
    private javax.swing.JPanel lblCasilla31;
    private javax.swing.JPanel lblCasilla32;
    private javax.swing.JPanel lblCasilla33;
    private javax.swing.JPanel lblCasilla34;
    private javax.swing.JPanel lblCasilla35;
    private javax.swing.JPanel lblCasilla36;
    private javax.swing.JPanel lblCasilla37;
    private javax.swing.JPanel lblCasilla38;
    private javax.swing.JPanel lblCasilla39;
    private javax.swing.JPanel lblCasilla4;
    private javax.swing.JPanel lblCasilla40;
    private javax.swing.JPanel lblCasilla5;
    private javax.swing.JPanel lblCasilla6;
    private javax.swing.JPanel lblCasilla7;
    private javax.swing.JPanel lblCasilla8;
    private javax.swing.JPanel lblCasilla9;
    private javax.swing.JLabel lblChat;
    private javax.swing.JLabel lblCon1Casa;
    private javax.swing.JLabel lblCon2Casas;
    private javax.swing.JLabel lblCon3Casas;
    private javax.swing.JLabel lblCon4Casas;
    private javax.swing.JLabel lblConHotel;
    private javax.swing.JLabel lblConexion;
    private javax.swing.JLabel lblConsultarJugador;
    private javax.swing.JLabel lblConsultarPropiedades;
    private javax.swing.JLabel lblDado2;
    private javax.swing.JLabel lblDinero;
    private javax.swing.JLabel lblFicha;
    private javax.swing.JLabel lblFichaJugador;
    private javax.swing.JLabel lblFortuna;
    private javax.swing.JLabel lblGetOutOfJailFree;
    private javax.swing.JLabel lblHipotecaTitulo;
    private javax.swing.JLabel lblHistorial;
    private javax.swing.JLabel lblHotelCasillas1;
    private javax.swing.JLabel lblHotelCasillas11;
    private javax.swing.JLabel lblHotelCasillas13;
    private javax.swing.JLabel lblHotelCasillas14;
    private javax.swing.JLabel lblHotelCasillas16;
    private javax.swing.JLabel lblHotelCasillas18;
    private javax.swing.JLabel lblHotelCasillas19;
    private javax.swing.JLabel lblHotelCasillas21;
    private javax.swing.JLabel lblHotelCasillas23;
    private javax.swing.JLabel lblHotelCasillas24;
    private javax.swing.JLabel lblHotelCasillas26;
    private javax.swing.JLabel lblHotelCasillas27;
    private javax.swing.JLabel lblHotelCasillas29;
    private javax.swing.JLabel lblHotelCasillas3;
    private javax.swing.JLabel lblHotelCasillas31;
    private javax.swing.JLabel lblHotelCasillas32;
    private javax.swing.JLabel lblHotelCasillas34;
    private javax.swing.JLabel lblHotelCasillas37;
    private javax.swing.JLabel lblHotelCasillas39;
    private javax.swing.JLabel lblHotelCasillas6;
    private javax.swing.JLabel lblHotelCasillas8;
    private javax.swing.JLabel lblHotelCasillas9;
    private javax.swing.JLabel lblLibreCasilla1;
    private javax.swing.JLabel lblLibreCasilla11;
    private javax.swing.JLabel lblLibreCasilla12;
    private javax.swing.JLabel lblLibreCasilla13;
    private javax.swing.JLabel lblLibreCasilla14;
    private javax.swing.JLabel lblLibreCasilla15;
    private javax.swing.JLabel lblLibreCasilla16;
    private javax.swing.JLabel lblLibreCasilla18;
    private javax.swing.JLabel lblLibreCasilla19;
    private javax.swing.JLabel lblLibreCasilla21;
    private javax.swing.JLabel lblLibreCasilla23;
    private javax.swing.JLabel lblLibreCasilla24;
    private javax.swing.JLabel lblLibreCasilla25;
    private javax.swing.JLabel lblLibreCasilla26;
    private javax.swing.JLabel lblLibreCasilla27;
    private javax.swing.JLabel lblLibreCasilla28;
    private javax.swing.JLabel lblLibreCasilla29;
    private javax.swing.JLabel lblLibreCasilla3;
    private javax.swing.JLabel lblLibreCasilla31;
    private javax.swing.JLabel lblLibreCasilla32;
    private javax.swing.JLabel lblLibreCasilla34;
    private javax.swing.JLabel lblLibreCasilla35;
    private javax.swing.JLabel lblLibreCasilla37;
    private javax.swing.JLabel lblLibreCasilla39;
    private javax.swing.JLabel lblLibreCasilla5;
    private javax.swing.JLabel lblLibreCasilla6;
    private javax.swing.JLabel lblLibreCasilla8;
    private javax.swing.JLabel lblLibreCasilla9;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogoMonopoly;
    private javax.swing.JLabel lblNombreJugador;
    private javax.swing.JLabel lblNombreTituloPropiedad;
    private javax.swing.JLabel lblNothing;
    private javax.swing.JLabel lblNumDado1;
    private javax.swing.JLabel lblNumDado2;
    private javax.swing.JLabel lblNumDinero;
    private javax.swing.JLabel lblQuedanCasas;
    private javax.swing.JLabel lblQuedanHoteles;
    private javax.swing.JLabel lblSeleccionFicha;
    private javax.swing.JLabel lblStatusPartida;
    private javax.swing.JLabel lblTituloDePropiedad;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JLabel lblTurnoDe;
    private javax.swing.JLabel lblUsuarioLanzamiento;
    private javax.swing.JPanel pnlArcaComunal;
    private javax.swing.JPanel pnlColorTituloPropiedad;
    private javax.swing.JPanel pnlFicha;
    private javax.swing.JPanel pnlFortuna;
    private javax.swing.JPanel pnlLogoMonopoly;
    private javax.swing.JPanel pnlTablero;
    private javax.swing.JPanel pnlTituloPropiedad;
    private javax.swing.JPanel pnlToolbar;
    private javax.swing.JTextArea txaHistorial;
    private javax.swing.JTextArea txaMensajes;
    private javax.swing.JTextField txfMensaje;
    // End of variables declaration//GEN-END:variables
}
