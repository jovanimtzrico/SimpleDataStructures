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
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
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
public class CircularQueueInterfaz extends JFrame {

    JTextField pantalla;
    JLabel reloj;
    double resultado;
    String operacion;
    JPanel panelNumeros, panelOperaciones;
    boolean nuevaOperacion = true;

    Calendar calendario = Calendar.getInstance();
    int hora, minutos, segundos;

    CircularQueue theQueue = new CircularQueue(10);

    public CircularQueueInterfaz() {
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
        pantalla.setEditable(false);
        pantalla.setBackground(Color.WHITE);
        panel.add("North", pantalla);

        panelNumeros = new JPanel();
        panelNumeros.setLayout(new GridLayout(4, 3));
        panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));

        for (int n = 9; n >= 0; n--) {
            nuevoBotonNumerico("" + n);
        }
        panel.add("Center", panelNumeros);

        panelOperaciones = new JPanel();
        panelOperaciones.setLayout(new GridLayout(6, 1));
        panelOperaciones.setBorder(new EmptyBorder(4, 4, 4, 4));

        nuevoBotonOperacion("Agregar");
        nuevoBotonOperacion("Borrar Primero");
        nuevoBotonOperacion("Vacio");
        nuevoBotonOperacion("Mostrar Primero");
        nuevoBotonOperacion("Mostrar Todo");
        nuevoBotonOperacion("CE");

        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);

        reloj = new JLabel(hora + ":" + minutos + ":" + segundos);
        panel.add("South", reloj);

        panel.add("East", panelOperaciones);

        validate();
    }

    private void nuevoBotonNumerico(String digito) {
        JButton btn = new JButton();
        btn.setForeground(Color.BLUE);
        btn.setText(digito);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                numeroPulsado(btn.getText());
            }
        });
        panelNumeros.add(btn);
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

    private void numeroPulsado(String digito) {
        if (pantalla.getText().equals("0") || nuevaOperacion) {
            pantalla.setText(digito);
        } else {
            pantalla.setText(pantalla.getText() + digito);
        }
        nuevaOperacion = false;
    }

    private void operacionPulsado(String tecla) {
        if (tecla.equals("Vacio")) {
            pantalla.setText(String.valueOf(theQueue.isEmpty()));
        } else if (tecla.equals("Agregar")) {
            theQueue.insert(Integer.valueOf(pantalla.getText()));
        } else if (tecla.equals("Mostrar Todo")) {
            int[] arrayQueue = theQueue.getQueArray();
            String str1 = "";
            for (int i = theQueue.getFront(); i < arrayQueue.length; i++) {
                str1 = str1.concat(String.valueOf(arrayQueue[i]) + " ");
            }
            pantalla.setText(str1);
        } else if (tecla.equals("Mostrar Primero")) {
            pantalla.setText(String.valueOf(theQueue.peekFront()));
        } else if (tecla.equals("Borrar Primero")) {
            pantalla.setText("Borrado " + String.valueOf(theQueue.remove()));
        } else if (tecla.equals("CE")) {
            pantalla.setText("");
        }
        nuevaOperacion = true;
    }

    public static void main(String[] args) {
        CircularQueueInterfaz interfaz = new CircularQueueInterfaz();
        interfaz.setVisible(true);
    }
}
