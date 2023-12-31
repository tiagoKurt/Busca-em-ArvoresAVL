package arvores.buscarBinaria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static arvores.buscarBinaria.buscaBinaria.insertWordInSortedArray;
import static arvores.buscarBinaria.buscaBinaria.updateFrequencyTable;

public class buscaBinaria_main {

    public static void main(String[] args) throws Exception {
        ArrayList<String> words = new ArrayList<>();
        ArrayList<WordFrequency> frequencyTable = new ArrayList<>();
        int comparisons = 0;
        long startTime, endTime;

        try {

            BufferedReader br = new BufferedReader(new FileReader("./src/arvores/arquivos/listWords.txt"));
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

            String line;

            while ((line = br.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                for (String word : lineWords) {
                    word = word.replaceAll("[^a-zA-Z]", "");
                    if (!word.isEmpty()) {
                        if (!stopWords.contains(word.toLowerCase())) {
                        words.add(word);
                        System.out.println("Parou");
                        }
                    }
                }
            }
            startTime = System.nanoTime();
            System.out.println("saiu");
            buscaBinaria.mergeSort(words);
            br.close();

            for (String word : words) {
                int position = buscaBinaria.binarySearch(words, word);
                if (position >= 0) {
                    updateFrequencyTable(frequencyTable, word);
                }
                comparisons++;
            }

            endTime = System.nanoTime();
            double executionTime = (endTime - startTime) / 1e9;

            System.out.println("Busca Binaria");
            System.out.println("Tempo de pesquisa(segundos): " + executionTime + " segundos");
            System.out.println("Comparacoes: " + comparisons);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resumoGeral(String arquivo) {
        ArrayList<String> words = new ArrayList<>();
        ArrayList<WordFrequency> frequencyTable = new ArrayList<>();
        int comparisons = 0;
        
        long startTime = System.nanoTime();

        try {

            BufferedReader br = new BufferedReader(new FileReader(arquivo));
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

            String line;

            while ((line = br.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                for (String word : lineWords) {

                    word = word.replaceAll("[^a-zA-Z]", "");

                    if (!word.isEmpty()) {
                        if (!stopWords.contains(word.toLowerCase())) {
                            words.add(word);

                        }
                    }
                }
            }
            startTime = System.nanoTime();
            buscaBinaria.mergeSort(words);
            br.close();

            for (String word : words) {
                int position = buscaBinaria.binarySearch(words, word);
                if (position >= 0) {
                    updateFrequencyTable(frequencyTable, word);
                }
                comparisons++;
            }

            long endTime = System.nanoTime();
            double executionTime = (endTime - startTime) / 1e9;

            System.out.println("Busca Binaria");
            System.out.println("Tempo de pesquisa(segundos): " + executionTime + " segundos");
            System.out.println("Comparacoes: " + comparisons);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
