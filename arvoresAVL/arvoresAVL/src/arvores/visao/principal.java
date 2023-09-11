package arvores.visao;

import Arvores.avl_binaria.FreqPalavras;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class principal extends javax.swing.JFrame {

    public principal() {
        initComponents();

        setLocationRelativeTo(null);
        jTextField1_nomeDoArquivo.setVisible(false);
        jButton1_frequencia.setVisible(false);
        jTextField1_aux.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1_limparCampos = new javax.swing.JButton();
        jButton1_frequencia = new javax.swing.JButton();
        jButton1_BuscarTexto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1_nomeDoArquivo = new javax.swing.JTextField();
        jButton1_BuscarTexto1 = new javax.swing.JButton();
        jTextField1_aux = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1110, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1_limparCampos.setFont(new java.awt.Font("Serif", 3, 16)); // NOI18N
        jButton1_limparCampos.setText("LIMPAR CAMPOS");
        jButton1_limparCampos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1_limparCampos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_limparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_limparCamposActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_limparCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, 160, 40));

        jButton1_frequencia.setFont(new java.awt.Font("Serif", 3, 16)); // NOI18N
        jButton1_frequencia.setText("FREQUÊNCIA");
        jButton1_frequencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1_frequencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_frequencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_frequenciaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_frequencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 270, 160, 40));

        jButton1_BuscarTexto.setFont(new java.awt.Font("Serif", 3, 16)); // NOI18N
        jButton1_BuscarTexto.setText("BUSCAR TEXTO");
        jButton1_BuscarTexto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1_BuscarTexto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_BuscarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_BuscarTextoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_BuscarTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, 160, 40));

        jLabel2.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel2.setText("BUSCA EM ÁRVORES");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arvores/icons/floresta.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 90, 70));

        jTextField1_nomeDoArquivo.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jTextField1_nomeDoArquivo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "ARQUIVO SELECIONADO", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 15))); // NOI18N
        getContentPane().add(jTextField1_nomeDoArquivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 480, 50));

        jButton1_BuscarTexto1.setFont(new java.awt.Font("Serif", 3, 16)); // NOI18N
        jButton1_BuscarTexto1.setText("SAIR");
        jButton1_BuscarTexto1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1_BuscarTexto1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_BuscarTexto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_BuscarTexto1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_BuscarTexto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 570, 160, 40));
        getContentPane().add(jTextField1_aux, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 110, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arvores/icons/5479107.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1_BuscarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_BuscarTextoActionPerformed
        try {
            jTextField1_aux.setText("");
            JFileChooser fc = new JFileChooser("./src/arvores/arquivos");
            File buscar = new File(".src/arvores/arquivos");
            fc.setCurrentDirectory(buscar);
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.showOpenDialog(this);
            File arquivo = fc.getSelectedFile();
            String nomeDoArquivo = arquivo.getPath();
            jTextField1_aux.setText(nomeDoArquivo);
            jTextField1_nomeDoArquivo.setVisible(true);
            jButton1_frequencia.setVisible(true);

            String caminhoCortado = "";
            String caminhoCompleto = jTextField1_aux.getText(); // Substitua pelo seu caminho completo
            String caminhoDesejado = "src";

            Path path = Paths.get(caminhoCompleto);

            int startIndex = caminhoCompleto.indexOf(caminhoDesejado);

            if (startIndex != -1) {
                caminhoCortado = caminhoCompleto.substring(startIndex);
            }
            jTextField1_nomeDoArquivo.setText("./"+caminhoCortado.toUpperCase());

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Arquivo não selecionado!");
        }
    }//GEN-LAST:event_jButton1_BuscarTextoActionPerformed

    private void jButton1_BuscarTexto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_BuscarTexto1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1_BuscarTexto1ActionPerformed

    private void jButton1_frequenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_frequenciaActionPerformed
        FreqPalavras pog = new FreqPalavras();

        String caminhoCortado = "";
        String caminhoCompleto = jTextField1_aux.getText(); // Substitua pelo seu caminho completo
        String caminhoDesejado = "src";

        Path path = Paths.get(caminhoCompleto);

        int startIndex = caminhoCompleto.indexOf(caminhoDesejado);

        if (startIndex != -1) {
            caminhoCortado = caminhoCompleto.substring(startIndex);
        }
        pog.frequenciaPalavras("./" + caminhoCortado);

    }//GEN-LAST:event_jButton1_frequenciaActionPerformed

    private void jButton1_limparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_limparCamposActionPerformed
        jTextField1_nomeDoArquivo.setText("");
        jTextField1_aux.setText("");
        jButton1_frequencia.setVisible(false);
        jTextField1_nomeDoArquivo.setVisible(false);
    }//GEN-LAST:event_jButton1_limparCamposActionPerformed

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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_BuscarTexto;
    private javax.swing.JButton jButton1_BuscarTexto1;
    private javax.swing.JButton jButton1_frequencia;
    private javax.swing.JButton jButton1_limparCampos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1_aux;
    private javax.swing.JTextField jTextField1_nomeDoArquivo;
    // End of variables declaration//GEN-END:variables
}
