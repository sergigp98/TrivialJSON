/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trivialjson;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

/**
 *
 * @author sergi
 */
public class Ventana extends JFrame implements ActionListener {

    Container container;
    JLabel trivial, pCorrectas, pFalladas, totalPreguntas, pregunta;
    JTextField nombreJugador;
    JButton iniciar, res1, res2, res3, res4;
    JProgressBar barra;
    JPanel panelSuperior, panelCentral, panelInferior, panelCentralUno, panelCentralDos, panelCentralTres;
    CardLayout cardLayout;
    FondoPanel fondoPanel;

    Font font = new Font("SANS_SERIF", 1, 50);

    public void initGUI() {
        instancias();
        acciones();
        configurarContainer();
        this.setSize(new Dimension(900, 500));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private void instancias() {
        container = this.getContentPane();

        trivial = new JLabel("SPORTS TRIVIAL");
        trivial.setFont(font);
        pCorrectas = new JLabel("Preguntas Correctas: ");
        pFalladas = new JLabel("Preguntas Incorrectas: ");
        totalPreguntas = new JLabel("Total Preguntas: 10 ");
        pregunta = new JLabel("Que hora es??");

        panelSuperior = new JPanel();
        panelCentral = new JPanel();
        panelCentralUno = new JPanel();
        panelCentralDos = new JPanel();
        panelCentralTres = new JPanel();
        panelInferior = new JPanel();
        cardLayout = new CardLayout();

        barra = new JProgressBar();

        iniciar = new JButton("INICIAR");
        res1 = new JButton();
        res2 = new JButton();
        res3 = new JButton();
        res4 = new JButton();

        nombreJugador = new JTextField();

        fondoPanel = new FondoPanel();

    }

    private void configurarContainer() {

        container.setLayout(new BorderLayout());
        container.add(configurarSuperior(), BorderLayout.NORTH);
        container.add(configurarCentral(), BorderLayout.CENTER);
        container.add(configurarInferior(), BorderLayout.SOUTH);
        container.setBackground(Color.BLUE);
    }

    private JPanel configurarSuperior() {
        panelSuperior.setLayout(new FlowLayout());
        panelSuperior.add(trivial);
        return panelSuperior;
    }

    private JPanel configurarCentral() {
        panelCentral.setLayout(cardLayout);
        panelCentral.add(panelCentralUno, "panelUno");
        panelCentral.add(panelCentralDos, "panelDos");
        panelCentral.add(panelCentralTres, "panelTres");

        configurarCentralUno();
        cardLayout.show(panelCentral, "panelUno");
        return panelCentral;
    }

    private JPanel configurarCentralUno() {
        panelCentralUno.setLayout(new BorderLayout());
        panelCentralUno.add(nombreJugador, BorderLayout.NORTH);
        panelCentralUno.add(fondoPanel, BorderLayout.CENTER);
        panelCentralUno.add(iniciar, BorderLayout.SOUTH);
        return panelCentralUno;
    }

    private JPanel configurarCentralDos() {
        panelCentralDos.setLayout(new GridLayout(5, 1));
        panelCentralDos.add(pregunta);
        panelCentralDos.add(res1);
        panelCentralDos.add(res2);
        panelCentralDos.add(res3);
        panelCentralDos.add(res4);

        return panelCentralDos;
    }
    private JPanel configurarCentralTres() {
        panelCentralTres.setLayout(new GridLayout(3, 1));
        panelCentralTres.add(pCorrectas);
        panelCentralTres.add(pFalladas);
        panelCentralTres.add(totalPreguntas);
        

        return panelCentralTres;
    }

    private JPanel configurarInferior() {
        panelInferior.setLayout(new FlowLayout());
        panelInferior.add(barra);
        return panelInferior;
    }

    private void acciones() {
        iniciar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == iniciar) {
            configurarCentralDos();
            cardLayout.show(panelCentral, "panelDos");
        }
    }

    class FondoPanel extends JPanel {

        Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("../Imagen/trivial_1.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

}
