/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Net
 */
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import exam.ExamModel;
import exam.Question;

public class PreguntasGUI extends JFrame implements ActionListener {

    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private ArrayList<Question> preguntas;
    private int preguntaActual;

    public PreguntasGUI(ArrayList<Question> preguntas) {
        super("Preguntas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.preguntas = preguntas;
        this.preguntaActual = 0;
        crearComponentes();
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void crearComponentes() {
        // Crear panel principal con CardLayout
        panelPrincipal = new JPanel();
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);

        // Agregar un panel con componentes para cada pregunta
        for (int i = 0; i < preguntas.size(); i++) {
            Question pregunta = preguntas.get(i); // elemento pregunta actual
            JPanel panelPregunta = new JPanel(new BorderLayout());

            ArrayList<String> respuestas = new ArrayList<>();
            
            respuestas.addAll(Arrays.asList(pregunta.getAnswers()));
            if (!pregunta.getType().equals("CD")) {
                respuestas.addAll(Arrays.asList(pregunta.getWrongAnswers()));
            } 
            
            JPanel panelRespuestas = new JPanel(new GridLayout(respuestas.size(), 1));

            ButtonGroup grupoOpciones = new ButtonGroup();
            JLabel labelPregunta = new JLabel(pregunta.getQuestion());
            panelPregunta.add(labelPregunta, BorderLayout.NORTH);

            // Agregamos los RadioButtons de cada pregunta
            for (String respuesta : respuestas) {
                JRadioButton radio = new JRadioButton(respuesta);
                grupoOpciones.add(radio);
                panelRespuestas.add(radio);
            }

            panelPregunta.add(panelRespuestas, BorderLayout.CENTER);

            JButton btnContinuar = new JButton("Continuar");
            btnContinuar.setActionCommand(Integer.toString(i));
            btnContinuar.addActionListener(this);
            panelPregunta.add(btnContinuar, BorderLayout.SOUTH);

            panelPrincipal.add(panelPregunta, Integer.toString(i));
        }

        add(panelPrincipal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtiene la respuesta seleccionada por el usuario
        JPanel panelPreguntaActual = (JPanel) panelPrincipal.getComponent(preguntaActual);
        JRadioButton radioSeleccionado = null;

        for (int i = 0; i < panelPreguntaActual.getComponentCount(); i++) {
            if (panelPreguntaActual.getComponent(i) instanceof JPanel) {
                JPanel panelRespuestas = (JPanel) panelPreguntaActual.getComponent(i);
                for (int j = 0; j < panelRespuestas.getComponentCount(); j++) {
                    JRadioButton radio = (JRadioButton) panelRespuestas.getComponent(j);
                    if (radio.isSelected()) {
                        radioSeleccionado = radio;
                        break;
                    }
                }
            }
        }

        String respuesta = radioSeleccionado != null ? radioSeleccionado.getText() : "No se seleccionó respuesta";
        System.out.println("Respuesta: " + respuesta);

        // Avanza a la siguiente pregunta
        preguntaActual++;
        if (preguntaActual >= preguntas.size()) {
            // Ya se han contestado todas las preguntas
            System.out.println("Ha respondido todas las preguntas");
            return;
        }

        // Obtiene la ID de la siguiente pregunta
        String idPregunta = Integer.toString(preguntaActual + 1);

        // Muestra la siguiente pregunta
        cardLayout.show(panelPrincipal, idPregunta);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ExamModel exam = new ExamModel("python");
                PreguntasGUI preguntasGUI = new PreguntasGUI(exam.getQuestions());
            }
        });
    }
}
