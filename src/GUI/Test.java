/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.*;
import java.awt.*;
import exam.ExamModel;
import exam.Question;

/**
 *
 * @author Net
 */
public class Test extends javax.swing.JFrame {

    /**
     * Creates new form Test
     */
    public Test() {
        initComponents();
        DataPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        DataPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        ExamModel exam = new ExamModel("python");
        actualizarTexto(exam);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollPanel = new javax.swing.JScrollPane();
        DataPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        ScrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        DataPanel.setLayout(new javax.swing.BoxLayout(DataPanel, javax.swing.BoxLayout.Y_AXIS));
        ScrollPanel.setViewportView(DataPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(ScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarTexto(ExamModel exam) {
        int counter = 0;
        boolean vf_t = false, sm_t = false, cd_t = false;

        for (Question q : exam.getQuestions()) {
            
            // Type Questions Tittle
            if (counter == 0 && vf_t == false) {
                JLabel titleLabel = new JLabel("VERDADERO O FALSO");
                titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                titleLabel.setPreferredSize(new Dimension(800, 30)); // ajusta la altura del JLabel
                DataPanel.add(titleLabel);
                vf_t = true;

            } else if (counter >= 5 && counter <= 20 && sm_t == false) {
                JLabel titleLabel = new JLabel("SELECCIÓN MULTIPLE");
                titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                titleLabel.setPreferredSize(new Dimension(800, 30)); // ajusta la altura del JLabel
                DataPanel.add(titleLabel);
                sm_t = true;

            } else if (counter >= 20 && cd_t == false) {
                JLabel titleLabel = new JLabel("CODIFICACIÓN");
                titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
                titleLabel.setPreferredSize(new Dimension(800, 30)); // ajusta la altura del JLabel
                DataPanel.add(titleLabel);
                cd_t = true;
            }

            DataPanel.add(Box.createVerticalStrut(20)); // separation
            
            JLabel questionLabel = new JLabel(q.getQuestion()); // Question tittle
            questionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            questionLabel.setPreferredSize(new Dimension(800, 40)); // ajusta la altura del JLabel
            DataPanel.add(questionLabel);

            DataPanel.add(Box.createVerticalStrut(10)); // separation

            if ("VF".equals(q.getType())) {
                JRadioButton vRadioButton = new JRadioButton("Verdadero");
                vRadioButton.setActionCommand("Verdadero");

                JRadioButton fRadioButton = new JRadioButton("Falso");
                fRadioButton.setActionCommand("Falso");

                ButtonGroup group = new ButtonGroup();
                group.add(vRadioButton);
                group.add(fRadioButton);

                // Agregamos los Radio Button al DataPanel
                DataPanel.add(vRadioButton);
                DataPanel.add(fRadioButton);

                
            } else if ("S1".equals(q.getType()) || "S2".equals(q.getType()) || "S3".equals(q.getType())) {
                // Agregamos las opciones correctas e incorrectas
                for (String correct_q : q.getAnswers()) {
                    DataPanel.add(new JRadioButton(correct_q));
                }

                for (String another_q : q.getWrongAnswers()) {
                    DataPanel.add(new JRadioButton(another_q));
                }

            } else {
                // En caso de las preguntas de codificación

                // Se crea el JScrollPane
                JScrollPane scrollPane = new JScrollPane(new JTextArea(10, 20));
                scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
                DataPanel.add(scrollPane);
            }

            DataPanel.add(Box.createVerticalStrut(20)); // separation
            counter++;
        }
    }

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
            java.util.logging.Logger.getLogger(Test.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DataPanel;
    private javax.swing.JScrollPane ScrollPanel;
    // End of variables declaration//GEN-END:variables
}
