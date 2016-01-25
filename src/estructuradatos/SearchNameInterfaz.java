/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuradatos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Jovani
 */
public class SearchNameInterfaz extends JFrame {

    JTextField pantalla;
    JLabel reloj;
    double resultado;
    String operacion;
    JPanel panelNumeros, panelOperaciones;
    boolean nuevaOperacion = true;

    Calendar calendario = Calendar.getInstance();
    int hora, minutos, segundos;

    SearchName sn;

    public SearchNameInterfaz() {
        super();
        setSize(650, 350);
        setTitle("Circular Queue");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = (JPanel) this.getContentPane();
        panel.setLayout(new BorderLayout());

        pantalla = new JTextField("", 60);
        pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
        pantalla.setFont(new Font("Arial", Font.BOLD, 25));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setBackground(Color.WHITE);
        panel.add("North", pantalla);

        panelOperaciones = new JPanel();
        panelOperaciones.setLayout(new GridLayout(6, 1));
        panelOperaciones.setBorder(new EmptyBorder(4, 4, 4, 4));

        nuevoBotonOperacion("Buscar");

        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);

        reloj = new JLabel(hora + ":" + minutos + ":" + segundos);
        panel.add("South", reloj);

        panel.add("East", panelOperaciones);

        sn = new SearchName();
        validate();
    }

    private void nuevoBotonOperacion(String operacion) {
        JButton btn = new JButton(operacion);
        btn.setForeground(Color.RED);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                operacionPulsado(btn.getText());
            }
        });
        panelOperaciones.add(btn);
    }

    private void operacionPulsado(String tecla) {
        if (tecla.equals("Buscar")) {
            int random = (int) (Math.random()*10);
            pantalla.setText(String.valueOf(random));
        }
    }

    public static void main(String[] args) {
        SearchNameInterfaz interfaz = new SearchNameInterfaz();
        interfaz.setVisible(true);
    }
}

