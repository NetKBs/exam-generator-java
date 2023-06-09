/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import exam.Question;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 *
 * @author Net
 */
public class Resultados extends javax.swing.JFrame {

    private ArrayList<Integer> notas = new ArrayList<>();
    private int total_grades = 0;
    private int total_corrects = 0;
    private int total_incorrects = 0;
    private String[] name;
    ArrayList<Question> preguntas = new ArrayList<>();

    /**
     * Creates new form Resultados
     *
     * @param
     */
    public Resultados() {
        super("Q&A GENERATOR");
        setLocationRelativeTo(null);
        initComponents();
        loadGrades();
        loadPersonData();
        showData();
    }

    public Resultados(ArrayList<Question> preguntas) {
        setLocationRelativeTo(null);
        initComponents();
        loadGrades();
        loadPersonData();
        showData();
        this.preguntas = preguntas;
    }

    private void loadGrades() {
        String slice = File.separator;
        String file_path = System.getProperty("user.dir") + slice + "src" + slice + "GUI" + slice + "temps" + slice + "notas.txt";
        File archivo = new File(file_path);

        try {
            Scanner scanner = new Scanner(archivo);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                int numero = scanner.nextInt();
                notas.add(numero);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.err.println("Error al cargar el archivo: " + e.getMessage());
        }
    }

    private void loadPersonData() {
        String slice = File.separator;
        String file_path = System.getProperty("user.dir") + slice + "src" + slice + "GUI" + slice + "temps" + slice + "datos_usr.txt";
        File archivo = new File(file_path);

        try {
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                this.name = line.split(",");
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.err.println("Error al cargar el archivo: " + e.getMessage());
        }
    }

    private void showData() {

        for (int n : notas) {
            this.total_grades += n;

            if (n == 0) {
                this.total_incorrects++;
            } else {
                this.total_corrects++;
            }
        }

        LabelPonderation.setText(total_grades + " / 25"); // Show grades
        LabelCorrects.setText("Corrects: " + total_corrects); // Show corrects
        LabelIncorrects.setText("Incorrects: " + total_incorrects); // Show incorrects
        LabelName.setText(name[0] + name[1]); // Show complete name
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
        LabelPonderation = new javax.swing.JTextField();
        LabelIncorrects = new javax.swing.JTextField();
        LabelName = new javax.swing.JTextField();
        LabelCorrects = new javax.swing.JTextField();
        ButtonListed = new javax.swing.JButton();
        ButtonHome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        LabelPonderation.setEditable(false);
        LabelPonderation.setBackground(new java.awt.Color(255, 255, 255));
        LabelPonderation.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 48)); // NOI18N
        LabelPonderation.setForeground(new java.awt.Color(153, 0, 255));
        LabelPonderation.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LabelPonderation.setText("0 / 25");
        LabelPonderation.setBorder(null);
        LabelPonderation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LabelPonderationActionPerformed(evt);
            }
        });
        jPanel1.add(LabelPonderation);
        LabelPonderation.setBounds(110, 70, 180, 60);

        LabelIncorrects.setEditable(false);
        LabelIncorrects.setBackground(new java.awt.Color(255, 255, 255));
        LabelIncorrects.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        LabelIncorrects.setForeground(new java.awt.Color(0, 0, 0));
        LabelIncorrects.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LabelIncorrects.setText("Incorrects: 0");
        LabelIncorrects.setBorder(null);
        LabelIncorrects.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.add(LabelIncorrects);
        LabelIncorrects.setBounds(210, 150, 180, 40);

        LabelName.setEditable(false);
        LabelName.setBackground(new java.awt.Color(255, 255, 255));
        LabelName.setFont(new java.awt.Font("Liberation Mono", 1, 24)); // NOI18N
        LabelName.setForeground(new java.awt.Color(0, 0, 0));
        LabelName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LabelName.setText("Unknown");
        LabelName.setBorder(null);
        LabelName.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        LabelName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LabelNameActionPerformed(evt);
            }
        });
        jPanel1.add(LabelName);
        LabelName.setBounds(0, 0, 390, 70);

        LabelCorrects.setEditable(false);
        LabelCorrects.setBackground(new java.awt.Color(255, 255, 255));
        LabelCorrects.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        LabelCorrects.setForeground(new java.awt.Color(0, 0, 0));
        LabelCorrects.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LabelCorrects.setText("Corrects: 0");
        LabelCorrects.setBorder(null);
        LabelCorrects.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        LabelCorrects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LabelCorrectsActionPerformed(evt);
            }
        });
        jPanel1.add(LabelCorrects);
        LabelCorrects.setBounds(0, 150, 180, 40);

        ButtonListed.setBackground(new java.awt.Color(153, 0, 255));
        ButtonListed.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        ButtonListed.setForeground(new java.awt.Color(255, 255, 255));
        ButtonListed.setText("Show Questions");
        ButtonListed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonListedActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonListed);
        ButtonListed.setBounds(80, 250, 220, 60);

        ButtonHome.setBackground(new java.awt.Color(153, 0, 255));
        ButtonHome.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        ButtonHome.setForeground(new java.awt.Color(255, 255, 255));
        ButtonHome.setText("Home");
        ButtonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonHomeActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonHome);
        ButtonHome.setBounds(120, 320, 130, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LabelPonderationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LabelPonderationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LabelPonderationActionPerformed

    private void LabelNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LabelNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LabelNameActionPerformed

    private void LabelCorrectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LabelCorrectsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LabelCorrectsActionPerformed

    private void ButtonListedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonListedActionPerformed
        VentanaPreguntas ventanaPreguntas = new VentanaPreguntas(preguntas);
        ventanaPreguntas.setVisible(true);
    }//GEN-LAST:event_ButtonListedActionPerformed

    private void ButtonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonHomeActionPerformed
        // TODO add your handling code here:
        MenuInicio menu = new MenuInicio();
        dispose();
        menu.setVisible(true);
    }//GEN-LAST:event_ButtonHomeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Resultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Resultados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonHome;
    private javax.swing.JButton ButtonListed;
    private javax.swing.JTextField LabelCorrects;
    private javax.swing.JTextField LabelIncorrects;
    private javax.swing.JTextField LabelName;
    private javax.swing.JTextField LabelPonderation;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

// Listado de pregutnas que fueron mostradas en el exámen
class VentanaPreguntas extends JDialog {

    private ArrayList<Question> preguntas = new ArrayList<>();

    public VentanaPreguntas(ArrayList<Question> preguntas) {
        this.preguntas = preguntas;

        JList<String> list = new JList<>(
                preguntas.stream() // Crear un Stream de la lista de preguntas
                        .map(Question::getQuestion) // Obtener el texto de cada pregunta
                        .toArray(String[]::new) // Convertir a un arreglo de Strings
        );
        add(new JScrollPane(list));

        JButton cerrar = new JButton("Cerrar");
        cerrar.setFont(new Font("Arial", Font.BOLD, 14));
        cerrar.setBackground(new Color(153, 0, 255)); // Background Color
        cerrar.setForeground(Color.WHITE); // Foreground color
        cerrar.addActionListener((ActionEvent e) -> {
            dispose();
        });
        add(cerrar, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

}
