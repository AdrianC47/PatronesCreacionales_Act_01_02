/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package est.ups.edu.ec.view;

import est.ups.edu.ec.controller.ControladorArchivoSistema;
import est.ups.edu.ec.model.ArchivoSistema;
import est.ups.edu.ec.model.Carpeta;
import java.util.List;

/**
 *
 * @author ue0100065z
 */
public class VistaArchivo extends javax.swing.JFrame {

    private ControladorArchivoSistema controlador;
    /**
     * Creates new form VistaArchivo
     */
    public VistaArchivo() {
        this.controlador = new ControladorArchivoSistema(this);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        addFolder = new javax.swing.JButton();
        addFile = new javax.swing.JButton();
        listStructure = new javax.swing.JButton();
        textArea = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Sistema de Archivos");

        addFolder.setText("Agregar Carpeta");
        addFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFolderActionPerformed(evt);
            }
        });

        addFile.setText("Agregar Archivo");
        addFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFileActionPerformed(evt);
            }
        });

        listStructure.setText("Listar Estrucutra");
        listStructure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listStructureActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        textArea.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textArea)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addFolder)
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addFile)
                                .addGap(81, 81, 81)
                                .addComponent(listStructure)))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addFolder)
                    .addComponent(addFile)
                    .addComponent(listStructure))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textArea, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFolderActionPerformed
        agregarCarpeta();
    }//GEN-LAST:event_addFolderActionPerformed

    private void addFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFileActionPerformed
        agregarArchivo();
    }//GEN-LAST:event_addFileActionPerformed

    private void listStructureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listStructureActionPerformed
        controlador.mostrarEstructura();
    }//GEN-LAST:event_listStructureActionPerformed

    private void agregarCarpeta(){
        String name = javax.swing.JOptionPane.showInputDialog("Ingrese nombre de la carpeta");
        String parent = javax.swing.JOptionPane.showInputDialog("Ingrese nombre de la carpeta padre (dejar vacío si es raíz)");
        controlador.agregarCarpeta(name, parent.isEmpty() ? null : parent);
    }
    
    private void agregarArchivo(){
        String name = javax.swing.JOptionPane.showInputDialog("Ingrese nombre del archivo");
        String size = javax.swing.JOptionPane.showInputDialog("Ingrese el tamaño del archivo (en KB)");
        if(size.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(null, "No se ha ingresado el tamaño del archivo", "Tamaño de Archivo", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        String parent = javax.swing.JOptionPane.showInputDialog("Ingrese nombre de la carpeta padre (dejar vacío si es raíz)");
        controlador.agregarArchivo(name, Integer.parseInt(size), parent.isEmpty() ? null : parent);
    }
    
    public void mostrarElemento(ArchivoSistema elemento, int nivel) {
        String indentacion = "    ".repeat(nivel * 2);
        System.out.println(indentacion + elemento.getNombre() + " (" + elemento.getTamano() + " KB)");
        jTextArea1.append(indentacion + elemento.getNombre() + " (" + elemento.getTamano() + " KB)" + (elemento instanceof Carpeta ? "" : "(Archivo)") + "\n");

        if (elemento instanceof Carpeta) {
            for (ArchivoSistema subElemento : ((Carpeta) elemento).getElementos()) {
                mostrarElemento(subElemento, nivel + 1);
            }
        }
    }
       
    public void mostrarJerarquia(List<ArchivoSistema> elementos) {
        jTextArea1.setText("");
        for (ArchivoSistema elemento : elementos) {
            mostrarElemento(elemento, 0);
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
            java.util.logging.Logger.getLogger(VistaArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaArchivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFile;
    private javax.swing.JButton addFolder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton listStructure;
    private javax.swing.JScrollPane textArea;
    // End of variables declaration//GEN-END:variables
}
