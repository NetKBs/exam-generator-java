package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;

import java.util.Timer;
import java.util.TimerTask;

import exam.ExamModel;
import exam.Question;
import GUI.Resultados;
import java.awt.Color;
import java.awt.Font;

public class PreguntasGUI extends JFrame implements ActionListener {

    String seleccion = "java";
    int radioSeleccionados = 0; // Variable contadora
    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private ArrayList<Question> preguntas;
    private int preguntaActual;
    private ArrayList<Integer> notas = new ArrayList<>();

    public PreguntasGUI() {
        super("Preguntas");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        File archivoTemporal = new File("seleccion.txt");
        try {
            Scanner scanner = new Scanner(archivoTemporal);
            if (scanner.hasNext()) {
                seleccion = scanner.next();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            // Manejar una posible excepción
            e.printStackTrace();
        }

        ExamModel exam = new ExamModel(seleccion);
        this.preguntas = exam.getQuestions();
        this.preguntaActual = 0;

        crearComponentes();
        setSize(750, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        // Crear un Timer y un TimerTask para mostrar un aviso después de 45 minutos
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Mostrar el aviso y cambiar de ventana
                JOptionPane.showMessageDialog(null, "Tiempo agotado", "Aviso", JOptionPane.WARNING_MESSAGE);
                dispose(); // Cerrar la ventana actual
                Resultados resultados = new Resultados();
                resultados.setVisible(true);
            }
        };

        // Programar la tarea para que se ejecute después de 45 minutos
        timer.schedule(task, 45 * 60 * 1000);

    }

    private void crearComponentes() {
        // Crear panel principal con CardLayout
        panelPrincipal = new JPanel();
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);

        // Agregar un panel con componentes para cada pregunta
        for (int i = 0; i < preguntas.size(); i++) {
            Question pregunta = preguntas.get(i); // elemento pregunta actual
            JPanel panelPregunta = crearPanelPregunta(pregunta, i);
            panelPrincipal.add(panelPregunta, Integer.toString(i));
        }

        add(panelPrincipal);
    }

    private JPanel crearPanelPregunta(Question pregunta, int index) {
        JPanel panelPregunta = new JPanel(new BorderLayout());

        // Cargamos respuestas correctas y posibles
        ArrayList<String> respuestas = new ArrayList<>();

        respuestas.addAll(Arrays.asList(pregunta.getAnswers()));
        if (!pregunta.getType().equals("CD")) {
            respuestas.addAll(Arrays.asList(pregunta.getWrongAnswers()));
        }

        JPanel panelRespuestas = new JPanel(new GridLayout(respuestas.size(), 1));

        // Title
        JTextArea textAreaPregunta = new JTextArea(pregunta.getQuestion());
        textAreaPregunta.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        textAreaPregunta.setFont(new Font("Arial", Font.BOLD, 16)); // Font
        textAreaPregunta.setLineWrap(true); // Establece la posibilidad de envoltura de contenido automáticamente
        textAreaPregunta.setWrapStyleWord(true); // Establece la posibilidad de envoltura de contenido por palabras completas
        textAreaPregunta.setEditable(false); // Desactiva la posibilidad de editar el texto
        panelPregunta.add(textAreaPregunta, BorderLayout.NORTH);

        // Agregamos los RadioButtons de cada pregunta
        for (int i = 0; i < respuestas.size(); i++) {
            String respuesta = respuestas.get(i);
            Set<String> tipos_seleccion = new HashSet<>(Arrays.asList("VF", "S1", "S2", "S3"));

            // Preguntas que usan RadioButtons
            if (tipos_seleccion.contains(pregunta.getType())) {
                
                //respuesta = "<html><p style='white-space: pre-wrap'>" + respuesta + "</p></html>";
                JRadioButton radio = new JRadioButton(respuesta);

                radio.setFont(new Font("Arial", Font.BOLD, 16));
                radio.setActionCommand(index + "-" + i);  // Nombre que identifica la opcion

                // ActionListener para el ItemEvent de los JRadioButton
                radio.addItemListener((ItemEvent e) -> {
                    // Obtiene el JRadioButton que disparó el evento
                    JRadioButton radioSeleccionado = (JRadioButton) e.getSource();

                    // Obtiene el JPanel que contiene todos los JRadioButton
                    Container container = radioSeleccionado.getParent();
                    JPanel panelRadioButtons = null;
                    // Buscamos hasta encontrar el panel padre que se instancia JPanel
                    while (container != null) {
                        if (container instanceof JPanel) {
                            panelRadioButtons = (JPanel) container;
                            break;
                        }
                        container = container.getParent();
                    }

                    // Habilita o deshabilita los JRadioButton
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        radioSeleccionados++;

                        if (("VF".equals(pregunta.getType()) || "S1".equals(pregunta.getType())) && radioSeleccionados == 1) {
                            for (Component c : panelRadioButtons.getComponents()) {
                                if (c instanceof JRadioButton && c != radioSeleccionado) {
                                    c.setEnabled(false);
                                }
                            }

                        } else if ("S2".equals(pregunta.getType()) && radioSeleccionados == 2) {
                            for (Component c : panelRadioButtons.getComponents()) {

                                if (c instanceof JRadioButton && c != radioSeleccionado) {
                                    JRadioButton radioButton = (JRadioButton) c; //Convert to JRadioButton to access isSelected() method
                                    if (!radioButton.isSelected()) { //Check if the radio button is not selected
                                        radioButton.setEnabled(false);
                                    }
                                }
                            }

                        } else if ("S3".equals(pregunta.getType()) && radioSeleccionados == 3) {
                            for (Component c : panelRadioButtons.getComponents()) {

                                if (c instanceof JRadioButton && c != radioSeleccionado) {
                                    JRadioButton radioButton = (JRadioButton) c; //Convert to JRadioButton to access isSelected() method
                                    if (!radioButton.isSelected()) { //Check if the radio button is not selected
                                        radioButton.setEnabled(false);
                                    }
                                }
                            }
                        }

                    } else { // Deselección
                        radioSeleccionados--;

                        for (Component c : panelRadioButtons.getComponents()) {
                            if (c instanceof JRadioButton) {
                                c.setEnabled(true);
                            }
                        }
                    }
                });

                panelRespuestas.add(radio);

            } else { // TextArea
                JPanel subPanel = new JPanel(new GridBagLayout());
                // crea el JTextArea con el tamaño deseado
                JTextArea text_field = new JTextArea();
                text_field.setPreferredSize(new Dimension(300, 100));

                // agrega el JTextArea al subpanel
                subPanel.add(text_field, new GridBagConstraints());
                // agrega el subpanel al contenedor principal, centrado
                panelRespuestas.add(subPanel, new GridBagConstraints());
            }
        }

        panelPregunta.add(panelRespuestas, BorderLayout.CENTER);

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setFont(new Font("Arial", Font.BOLD, 14));
        btnContinuar.setBackground(new Color(153, 0, 255)); // Background Color
        btnContinuar.setForeground(Color.WHITE); // Foreground color
        btnContinuar.setActionCommand(Integer.toString(index));
        btnContinuar.addActionListener(this);
        panelPregunta.add(btnContinuar, BorderLayout.SOUTH);

        return panelPregunta;

    }

    // Manejamos el envio de preguntas y la continuación con la siguiente
    @Override
    public void actionPerformed(ActionEvent e) {

        JTextArea textArea = null;

        // Obtiene la respuesta seleccionada por el usuario
        JPanel panelPreguntaActual = (JPanel) panelPrincipal.getComponent(preguntaActual);
        ArrayList<JRadioButton> radioSeleccionado = new ArrayList<>();

        // Busca el radio button seleccionado en el panel actual
        for (Component componente : panelPreguntaActual.getComponents()) {
            if (componente instanceof JPanel) {
                JPanel panelRespuestas = (JPanel) componente;

                for (Component componentePanel : panelRespuestas.getComponents()) {
                    if (componentePanel instanceof JRadioButton) {
                        JRadioButton radio = (JRadioButton) componentePanel;
                        if (radio.isSelected()) {
                            radioSeleccionado.add(radio);
                        }
                    } else if (componentePanel instanceof JPanel) {
                        JPanel subPanel = (JPanel) componentePanel;
                        textArea = (JTextArea) subPanel.getComponent(0);

                    }
                }
            }
        }

        Question objeto_pregunta_actual = preguntas.get(preguntaActual);

        if (!objeto_pregunta_actual.getType().equals("CD")) {
            ArrayList<String> respuestas_radio = new ArrayList<>();
            // Mostramos las respuestas seleccionadas

            for (JRadioButton radio : radioSeleccionado) {
                String respuesta = radio != null ? radio.getText() : ""; // Comprobación null
                respuestas_radio.add(respuesta);
            }

            notas.add(objeto_pregunta_actual.verifyAnswer(respuestas_radio.toArray(new String[respuestas_radio.size()])));

        } else {
            if (textArea != null) {
                String respuesta_textfield = textArea.getText();

                if (respuesta_textfield == null || respuesta_textfield.isEmpty()) {
                    respuesta_textfield = "";
                }

                String[] text_parm = {respuesta_textfield};
                notas.add(objeto_pregunta_actual.verifyAnswer(text_parm));

            }

        }

        // Avanza a la siguiente pregunta
        preguntaActual++;

        if (preguntaActual >= preguntas.size()) {
            // Ya se han contestado todas las preguntas
            dispose(); // Cerramos la ventana actual
            saveGrades();
            // Creamos una instancia de la otra ventana y la hacemos visible
            Resultados resultados = new Resultados(preguntas);
            resultados.setVisible(true);
        }

        // Obtiene la ID de la siguiente pregunta
        String idPregunta = Integer.toString(preguntaActual);

        // Muestra la siguiente pregunta
        this.radioSeleccionados = 0;
        cardLayout.show(panelPrincipal, idPregunta);
    }

    public void saveGrades() {
        
        String slice = File.separator;
        String file_path = System.getProperty("user.dir") + slice + "src" + slice + "GUI" + slice + "temps" + slice + "notas.txt";
        File archivo = new File(file_path);

        try {
            PrintWriter pw = new PrintWriter(archivo);
            for (int i = 0; i < notas.size(); i++) {
                pw.print(notas.get(i));
                if (i != notas.size() - 1) {
                    pw.print(",");
                }
            }

            pw.close();

        } catch (FileNotFoundException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Borrar el archivo de selección temporal
            File archivoTemporal = new File("seleccion.txt");
            archivoTemporal.delete();

            PreguntasGUI preguntasGUI = new PreguntasGUI();
        });
    }
}
