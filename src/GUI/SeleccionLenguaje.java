/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
/**
 *
 * @author Manue
 */
public class SeleccionLenguaje extends javax.swing.JFrame {

    /**
     * Creates new form Ventana2
     */
    public SeleccionLenguaje() {
        initComponents();
        setLocationRelativeTo(null);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        c_checkbox = new javax.swing.JCheckBox();
        cplus_check = new javax.swing.JCheckBox();
        java_check = new javax.swing.JCheckBox();
        python_check = new javax.swing.JCheckBox();
        cnumeral_check = new javax.swing.JCheckBox();
        irbtton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 0, 255));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Q&A GENERATOR");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Captura de pantalla 2023-05-17 223335.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Berton Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Only a few clicks");

        jLabel8.setFont(new java.awt.Font("Berton Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("to get your exam");

        jLabel9.setFont(new java.awt.Font("Berton Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("model done !");

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("All rights reserved, 2023");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel5)))
                        .addGap(3, 3, 3))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6)))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(58, 58, 58))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(99, 99, 99)
                .addComponent(jLabel10)
                .addGap(372, 372, 372)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 480));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel2.setText("Please choose a ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 230, 70));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel4.setText("the subject of the exam");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel3.setText("programming language as ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        c_checkbox.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        c_checkbox.setText("C");
        c_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_checkboxActionPerformed(evt);
            }
        });
        jPanel1.add(c_checkbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, -1, -1));

        cplus_check.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        cplus_check.setText("C++");
        cplus_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cplus_checkActionPerformed(evt);
            }
        });
        jPanel1.add(cplus_check, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, -1));

        java_check.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        java_check.setText("Java");
        java_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                java_checkActionPerformed(evt);
            }
        });
        jPanel1.add(java_check, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, -1, -1));

        python_check.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        python_check.setText("Python");
        python_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                python_checkActionPerformed(evt);
            }
        });
        jPanel1.add(python_check, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, -1, -1));

        cnumeral_check.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        cnumeral_check.setText("C#");
        jPanel1.add(cnumeral_check, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, -1, -1));

        irbtton.setText("IR");
        irbtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irbttonActionPerformed(evt);
            }
        });
        jPanel1.add(irbtton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_checkboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_checkboxActionPerformed

    private void cplus_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cplus_checkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cplus_checkActionPerformed

    private void python_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_python_checkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_python_checkActionPerformed

    private void java_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_java_checkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_java_checkActionPerformed

    private void irbttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irbttonActionPerformed
 Confirmacion b = new Confirmacion();
    b.setVisible(true);

    // Obtener la selección
    String seleccion = "c"; // Lenguaje por defecto
    if(c_checkbox.isSelected()) {
        seleccion = "c";
    } else if(cplus_check.isSelected()) {
        seleccion = "c++";
    } else if(java_check.isSelected()) {
        seleccion = "java";
    } else if(python_check.isSelected()) {
        seleccion = "python";
    } else if(cnumeral_check.isSelected()) {
        seleccion = "csharp";
    }

    // Guardar la selección en un archivo temporal
    File archivoTemporal = new File("seleccion.txt");
    try {
        PrintWriter escritor = new PrintWriter(archivoTemporal);
        escritor.print(seleccion);
        escritor.close();
    } catch (FileNotFoundException e) {
        // Manejar una posible excepción
        e.printStackTrace();
    }

    this.setVisible(false);
    }//GEN-LAST:event_irbttonActionPerformed

   
    
    
    
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
            java.util.logging.Logger.getLogger(SeleccionLenguaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionLenguaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionLenguaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionLenguaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeleccionLenguaje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox c_checkbox;
    private javax.swing.JCheckBox cnumeral_check;
    private javax.swing.JCheckBox cplus_check;
    private javax.swing.JButton irbtton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JCheckBox java_check;
    private javax.swing.JCheckBox python_check;
    // End of variables declaration//GEN-END:variables
}