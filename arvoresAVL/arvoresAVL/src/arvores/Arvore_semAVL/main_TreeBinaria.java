package arvores.Arvore_semAVL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class main_TreeBinaria {

    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();

            BinaryTree tree = new BinaryTree();
            BufferedReader br = new BufferedReader(new FileReader("./src/arvores/arquivos/ExTexto.txt"));
            String line;
            int position = 1;

            String stopWord = "./src/arvores/suporte/stopwords.txt";
            ArrayList<String> stopWords = new ArrayList<>();
            BufferedReader leitor2 = new BufferedReader(new FileReader(stopWord));
            String linhaPrincipal;
            while ((linhaPrincipal = leitor2.readLine()) != null) {
                String[] palavrasLinha = linhaPrincipal.split("\\s+");
                for (String palavra : palavrasLinha) {
                    palavra = palavra.replaceAll("[^a-zA-Z]", "");
                    if (!palavra.isEmpty()) {
                        stopWords.add(palavra.toLowerCase());
                    }
                }
            }

            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (!stopWords.contains(word.toLowerCase())) {
                        tree.insert(word, position);
                        position++;
                    }
                }
            }

            br.close();
            tree.inOrder();

            long endTime = System.currentTimeMillis();
            double executionTime = (endTime - startTime) / 1000.0;

            System.out.println("Tempo de pesquisa (segundos): " + executionTime);
            System.out.println("Comparações: " + tree.getComparisons());
            
            tree.printTree();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void relacaoArvore(String arquivo){
        try {
            BinaryTree tree = new BinaryTree();
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String line;
            int position = 1;

            String stopWord = "./src/arvores/suporte/stopwords.txt";
            ArrayList<String> stopWords = new ArrayList<>();
            BufferedReader leitor2 = new BufferedReader(new FileReader(stopWord));
            String linhaPrincipal;
            while ((linhaPrincipal = leitor2.readLine()) != null) {
                String[] palavrasLinha = linhaPrincipal.split("\\s+");
                for (String palavra : palavrasLinha) {
                    palavra = palavra.replaceAll("[^a-zA-Z]", "");
                    if (!palavra.isEmpty()) {
                        stopWords.add(palavra.toLowerCase());
                    }
                }
            }

            
            
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (!stopWords.contains(word.toLowerCase())) {
                        tree.insert(word.toUpperCase(), position);
                        position++;
                    }
                }
            }
            br.close();
            
            tree.printTree();
            tree.inOrder();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void resumoGeral(String arquivo){
        try {
            long startTime = System.nanoTime();

            BinaryTree tree = new BinaryTree();
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String line;
            int position = 1;

            String stopWord = "./src/arvores/suporte/stopwords.txt";
            ArrayList<String> stopWords = new ArrayList<>();
            BufferedReader leitor2 = new BufferedReader(new FileReader(stopWord));
            String linhaPrincipal;
            while ((linhaPrincipal = leitor2.readLine()) != null) {
                String[] palavrasLinha = linhaPrincipal.split("\\s+");
                for (String palavra : palavrasLinha) {
                    palavra = palavra.replaceAll("[^a-zA-Z]", "");
                    if (!palavra.isEmpty()) {
                        stopWords.add(palavra.toLowerCase());
                    }
                }
            }

            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (!stopWords.contains(word.toLowerCase())) {
                        tree.insert(word, position);
                        position++;
                    }
                }
            }
            br.close();

            long endTime = System.nanoTime();
            double tempoConvertido = (endTime - startTime) / 1e9; 
            
            System.out.println("Arvore Binaria");
            System.out.println("Tempo de pesquisa (segundos): " + tempoConvertido);
            System.out.println("Comparacoes: " + tree.getComparisons());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
