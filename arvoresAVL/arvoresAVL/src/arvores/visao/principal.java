package arvores.visao;

import arvores.Arvore_semAVL.main_TreeBinaria;
import arvores.avl_binaria.ArvoresAVL;
import arvores.avl_binaria.FreqPalavras;
import arvores.avl_binaria.FrequenciaGeral;
import arvores.avl_binaria.InsercaoBinaria;
import arvores.buscarBinaria.buscaBinaria;
import arvores.imprimirAVL.mainArvorePalavras;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class principal extends javax.swing.JFrame {

    public principal() {
        initComponents();

        setLocationRelativeTo(null);
        jTextField1_nomeDoArquivo.setVisible(false);
        jButton1_avancar.setVisible(false);
        jTextField1_aux.setVisible(false);
        jTextArea1_saidaArvores.setEnabled(false);
        jButton1_limparCampos.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1_avancar = new javax.swing.JFrame();
        jButton1_BuscarTexto2 = new javax.swing.JButton();
        jButton1_frequencia1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1_binaria = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1_saidaArvores = new javax.swing.JTextArea();
        jButton1_avl = new javax.swing.JButton();
        jButton1_BuscarTexto3 = new javax.swing.JButton();
        jButton1_avl1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1_limparCampos = new javax.swing.JButton();
        jButton1_avancar = new javax.swing.JButton();
        jButton1_BuscarTexto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1_nomeDoArquivo = new javax.swing.JTextField();
        jButton1_BuscarTexto1 = new javax.swing.JButton();
        jTextField1_aux = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jFrame1_avancar.setUndecorated(true);
        jFrame1_avancar.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1_BuscarTexto2.setFont(new java.awt.Font("Serif", 3, 16)); // NOI18N
        jButton1_BuscarTexto2.setText("VOLTAR");
        jButton1_BuscarTexto2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1_BuscarTexto2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_BuscarTexto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_BuscarTexto2ActionPerformed(evt);
            }
        });
        jFrame1_avancar.getContentPane().add(jButton1_BuscarTexto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 570, 160, 40));

        jButton1_frequencia1.setFont(new java.awt.Font("Serif", 3, 16)); // NOI18N
        jButton1_frequencia1.setText("FREQUÊNCIA");
        jButton1_frequencia1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1_frequencia1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_frequencia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_frequencia1ActionPerformed(evt);
            }
        });
        jFrame1_avancar.getContentPane().add(jButton1_frequencia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 440, 160, 40));

        jLabel5.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel5.setText("BUSCA EM ÁRVORES");
        jFrame1_avancar.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arvores/icons/floresta.png"))); // NOI18N
        jFrame1_avancar.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 90, 70));

        jButton1_binaria.setFont(new java.awt.Font("Serif", 3, 16)); // NOI18N
        jButton1_binaria.setText("BUSCA BINÁRIA");
        jButton1_binaria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1_binaria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_binaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_binariaActionPerformed(evt);
            }
        });
        jFrame1_avancar.getContentPane().add(jButton1_binaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, 160, 40));

        jTextArea1_saidaArvores.setColumns(20);
        jTextArea1_saidaArvores.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jTextArea1_saidaArvores.setRows(5);
        jTextArea1_saidaArvores.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "SAÍDA", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 24))); // NOI18N
        jScrollPane1.setViewportView(jTextArea1_saidaArvores);

        jFrame1_avancar.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 670, 370));

        jButton1_avl.setFont(new java.awt.Font("Serif", 3, 16)); // NOI18N
        jButton1_avl.setText("ÁRVORE AVL");
        jButton1_avl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1_avl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_avl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_avlActionPerformed(evt);
            }
        });
        jFrame1_avancar.getContentPane().add(jButton1_avl, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 290, 160, 40));

        jButton1_BuscarTexto3.setFont(new java.awt.Font("Serif", 3, 16)); // NOI18N
        jButton1_BuscarTexto3.setText("RESUMO GERAL");
        jButton1_BuscarTexto3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1_BuscarTexto3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_BuscarTexto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_BuscarTexto3ActionPerformed(evt);
            }
        });
        jFrame1_avancar.getContentPane().add(jButton1_BuscarTexto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 390, 160, 40));

        jButton1_avl1.setFont(new java.awt.Font("Serif", 3, 16)); // NOI18N
        jButton1_avl1.setText("ÁRVORE BINÁRIA");
        jButton1_avl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1_avl1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_avl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_avl1ActionPerformed(evt);
            }
        });
        jFrame1_avancar.getContentPane().add(jButton1_avl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 340, 160, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arvores/icons/5479107.jpg"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jFrame1_avancar.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 750));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
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
        getContentPane().add(jButton1_limparCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 510, 160, 40));

        jButton1_avancar.setFont(new java.awt.Font("Serif", 3, 16)); // NOI18N
        jButton1_avancar.setText("AVANÇAR");
        jButton1_avancar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1_avancar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_avancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_avancarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_avancar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 270, 160, 40));

        jButton1_BuscarTexto.setFont(new java.awt.Font("Serif", 3, 16)); // NOI18N
        jButton1_BuscarTexto.setText("BUSCAR TEXTO");
        jButton1_BuscarTexto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1_BuscarTexto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_BuscarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_BuscarTextoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_BuscarTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, 160, 40));

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
        getContentPane().add(jButton1_BuscarTexto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 570, 160, 40));
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
            jButton1_avancar.setVisible(true);

            String caminhoCortado = "";
            String caminhoCompleto = jTextField1_aux.getText(); // Substitua pelo seu caminho completo
            String caminhoDesejado = "src";

            Path path = Paths.get(caminhoCompleto);

            int startIndex = caminhoCompleto.indexOf(caminhoDesejado);

            if (startIndex != -1) {
                caminhoCortado = caminhoCompleto.substring(startIndex);
            }
            jTextField1_nomeDoArquivo.setText("./" + caminhoCortado.toUpperCase());
            jButton1_limparCampos.setVisible(true);

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Arquivo não selecionado!");
        }
    }//GEN-LAST:event_jButton1_BuscarTextoActionPerformed

    private void jButton1_BuscarTexto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_BuscarTexto1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1_BuscarTexto1ActionPerformed

    private void jButton1_avancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_avancarActionPerformed
        jFrame1_avancar.setBounds(0, 0, 1110, 750);
        jFrame1_avancar.setVisible(true);
        jFrame1_avancar.setLocationRelativeTo(null);
        this.setVisible(false);

    }//GEN-LAST:event_jButton1_avancarActionPerformed

    private void jButton1_limparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_limparCamposActionPerformed
        jTextField1_nomeDoArquivo.setText("");
        jTextField1_aux.setText("");
        jButton1_avancar.setVisible(false);
        jTextField1_nomeDoArquivo.setVisible(false);
        jButton1_limparCampos.setVisible(false);
    }//GEN-LAST:event_jButton1_limparCamposActionPerformed

    private void jButton1_BuscarTexto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_BuscarTexto2ActionPerformed
        this.setVisible(true);
        jFrame1_avancar.dispose();
        jTextArea1_saidaArvores.setText("");
    }//GEN-LAST:event_jButton1_BuscarTexto2ActionPerformed

    private void jButton1_frequencia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_frequencia1ActionPerformed
        try {
            jTextArea1_saidaArvores.setText("");
            FrequenciaGeral pog = new FrequenciaGeral();

            String caminhoCortado = "";
            String caminhoCompleto = jTextField1_aux.getText();
            String caminhoDesejado = "src";

            int startIndex = caminhoCompleto.indexOf(caminhoDesejado);

            if (startIndex != -1) {
                caminhoCortado = caminhoCompleto.substring(startIndex);
            }

            PrintStream printStream = new PrintStream(new TextAreaOutputStream(jTextArea1_saidaArvores));
            System.setOut(printStream);
            pog.frequenciaPalavras(caminhoCortado);
        } catch (IOException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1_frequencia1ActionPerformed

    private void jButton1_binariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_binariaActionPerformed
        jTextArea1_saidaArvores.setText("");
        String caminhoCompleto = jTextField1_aux.getText();
        String caminhoDesejado = "src";
        String caminhoCortado = "";
        int startIndex = caminhoCompleto.indexOf(caminhoDesejado);

        if (startIndex != -1) {
            caminhoCortado = caminhoCompleto.substring(startIndex);
        }
        PrintStream printStream = new PrintStream(new TextAreaOutputStream(jTextArea1_saidaArvores));
        System.setOut(printStream);
        
        buscaBinaria binaria = new buscaBinaria();
        binaria.resumoGeral(caminhoCortado);
    }//GEN-LAST:event_jButton1_binariaActionPerformed

    private void jButton1_avlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_avlActionPerformed
        try {
            jTextArea1_saidaArvores.setText("");
            mainArvorePalavras arvoreAVL = new mainArvorePalavras();

            String caminhoCompleto = jTextField1_aux.getText();
            String caminhoDesejado = "src";
            String caminhoCortado = "";
            int startIndex = caminhoCompleto.indexOf(caminhoDesejado);

            if (startIndex != -1) {
                caminhoCortado = caminhoCompleto.substring(startIndex);
            }
            PrintStream printStream = new PrintStream(new TextAreaOutputStream(jTextArea1_saidaArvores));
            System.setOut(printStream);
            arvoreAVL.ImprimirArvoreTela(caminhoCortado);

            principalTerminal procuraArvoreAvl = new principalTerminal();

            procuraArvoreAvl.AdiconarArvoreAVL(caminhoCortado);

        } catch (IOException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1_avlActionPerformed

    private void jButton1_BuscarTexto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_BuscarTexto3ActionPerformed

        try {
            jTextArea1_saidaArvores.setText("");
            InsercaoBinaria oMeuDeus = new InsercaoBinaria();
            String caminhoCompleto = jTextField1_aux.getText();
            String caminhoDesejado = "src";
            String caminhoCortado = "";
            int startIndex = caminhoCompleto.indexOf(caminhoDesejado);

            if (startIndex != -1) {
                caminhoCortado = caminhoCompleto.substring(startIndex);
            }
            PrintStream printStream = new PrintStream(new TextAreaOutputStream(jTextArea1_saidaArvores));
//            System.setOut(printStream);
//            oMeuDeus.insercaoBinaria(caminhoCortado);
            buscaBinaria binaria = new buscaBinaria();
            binaria.resumoGeral(caminhoCortado);

            System.out.println("------------------------------------------------------------------------------------------------------------");
//            principalTerminal resumoArvoreAVL = new principalTerminal();
//            resumoArvoreAVL.resumoGeral(caminhoCortado);
            System.out.println("------------------------------------------------------------------------------------------------------------");

            main_TreeBinaria arvoreBinaria = new main_TreeBinaria();
            arvoreBinaria.resumoGeral(caminhoCortado);

            System.out.println("------------------------------------------------------------------------------------------------------------");
            FrequenciaGeral frequenciaResumo = new FrequenciaGeral();
            frequenciaResumo.resumoGeral(caminhoCortado);

        } catch (IOException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1_BuscarTexto3ActionPerformed

    private void jButton1_avl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_avl1ActionPerformed
        jTextArea1_saidaArvores.setText("");
        main_TreeBinaria arvoreBinaria = new main_TreeBinaria();

        String caminhoCompleto = jTextField1_aux.getText();
        String caminhoDesejado = "src";
        String caminhoCortado = "";
        int startIndex = caminhoCompleto.indexOf(caminhoDesejado);

        if (startIndex != -1) {
            caminhoCortado = caminhoCompleto.substring(startIndex);
        }
        PrintStream printStream = new PrintStream(new TextAreaOutputStream(jTextArea1_saidaArvores));
        System.setOut(printStream);
        arvoreBinaria.relacaoArvore(caminhoCortado);


    }//GEN-LAST:event_jButton1_avl1ActionPerformed

    public class TextAreaOutputStream extends OutputStream {

        private final JTextArea textArea;
        private final StringBuilder buffer = new StringBuilder();

        public TextAreaOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) throws IOException {

            buffer.append((char) b);

            if (b == '\n') {
                SwingUtilities.invokeLater(this::updateTextArea);
            }
        }

        @Override
        public void flush() {
            updateTextArea();
        }

        private void updateTextArea() {

            SwingUtilities.invokeLater(() -> {
                textArea.append(buffer.toString());
                buffer.setLength(0);
            });
        }
    }

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
    private javax.swing.JButton jButton1_BuscarTexto2;
    private javax.swing.JButton jButton1_BuscarTexto3;
    private javax.swing.JButton jButton1_avancar;
    private javax.swing.JButton jButton1_avl;
    private javax.swing.JButton jButton1_avl1;
    private javax.swing.JButton jButton1_binaria;
    private javax.swing.JButton jButton1_frequencia1;
    private javax.swing.JButton jButton1_limparCampos;
    private javax.swing.JFrame jFrame1_avancar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1_saidaArvores;
    private javax.swing.JTextField jTextField1_aux;
    private javax.swing.JTextField jTextField1_nomeDoArquivo;
    // End of variables declaration//GEN-END:variables
}
