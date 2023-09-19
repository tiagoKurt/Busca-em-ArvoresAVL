package arvores.buscarBinaria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class buscaBinaria {

    public static void main(String[] args) {
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

            startTime = System.nanoTime();
            while ((line = br.readLine()) != null) {
                String[] lineWords = line.split("\\s+"); // Dividir a linha em palavras
                for (String word : lineWords) {

                    word = word.replaceAll("[^a-zA-Z]", "");

                    if (!word.isEmpty()) {
                        if (!stopWords.contains(word.toLowerCase())) {
                            insertWordInSortedArray(words, word);
                        }
                    }
                }
            }

            br.close();

            for (String word : words) {
                int position = binarySearch(words, word);
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
                String[] lineWords = line.split("\\s+"); // Dividir a linha em palavras
                for (String word : lineWords) {

                    word = word.replaceAll("[^a-zA-Z]", "");

                    if (!word.isEmpty()) {
                        if (!stopWords.contains(word.toLowerCase())) {
                            insertWordInSortedArray(words, word);
                        }
                    }
                }
            }

            br.close();

            for (String word : words) {
                int position = binarySearch(words, word);
                if (position >= 0) {
                    updateFrequencyTable(frequencyTable, word);
                }
                comparisons++;
            }

            long endTime = System.nanoTime();
            double tempoConvertido = (endTime - startTime) / 1e9; 

            System.out.println("Busca Binaria");
            System.out.println("Tempo de pesquisa(segundos): " + tempoConvertido + " segundos");
            System.out.println("Comparacoes: " + comparisons);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Busca binária em um ArrayList ordenado
    public static int binarySearch(ArrayList<String> list, String word) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = word.compareTo(list.get(mid));

            if (cmp == 0) {
                return mid; // A palavra foi encontrada na posição 'mid'
            } else if (cmp < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1; // A palavra não foi encontrada
    }

    // Inserir palavra em um ArrayList ordenado
    public static void insertWordInSortedArray(ArrayList<String> list, String word) {
        int index = 0;
        while (index < list.size() && word.compareTo(list.get(index)) > 0) {
            index++;
        }
        list.add(index, word);
    }

    // Atualizar a tabela de frequências
    public static void updateFrequencyTable(ArrayList<WordFrequency> table, String word) {
        for (WordFrequency wf : table) {
            if (wf.word.equals(word)) {
                wf.frequency++;
                return;
            }
        }
        // Se a palavra não existir na tabela, adicione-a
        table.add(new WordFrequency(word, 1));
    }
}

// Classe para representar a tabela de frequências
class WordFrequency {

    String word;
    int frequency;

    public WordFrequency(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }
}
