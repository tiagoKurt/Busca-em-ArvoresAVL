package arvores.arrayDinamico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class InsercaoBinaria {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int comparisons = 0;
        String stopWord = "./src/arvores/suporte/stopwords.txt";
        String arquivo = "./src/arvores/arquivos/newDic.txt";
        ArrayList<String> stopWords = new ArrayList<>();
        try {

            BufferedReader br = new BufferedReader(new FileReader(arquivo));
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

            DynamicArray words = new DynamicArray();

            String line;
            while ((line = br.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                for (String word : lineWords) {
                    String cleanedWord = word.toLowerCase().replaceAll("[^a-zA-ZÀ-ÿ\\s]", " ").toLowerCase();
                    if (!cleanedWord.isEmpty()) {
                        int index = words.binarySearch(cleanedWord);

                        if (index < 0) {
                            comparisons++;
                            if (!stopWords.contains(cleanedWord.toLowerCase())) {
                                words.insert(-index - 1, cleanedWord);
                            }
                        }
                    }
                }
            }

            br.close();

            long endTime = System.nanoTime();
            double elapsedTimeInSeconds = (endTime - startTime) / 1e9; 

            System.out.println("Pesquisa Binaria:");
            System.out.println("Total de palavras distintas no arquivo: " + words.size());
            System.out.println("Tempo de pesquisa (segundos): " + elapsedTimeInSeconds);
            System.out.println("Numero de comparacoes: " + comparisons);

//            bagulho para mostrar a frequência das palavras está com defeito
//            for (String word : words.getWords()) {
//                System.out.println(word + ": " + words.getFrequency(word));
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insercaoBinaria(String pog) {
        long startTime = System.nanoTime();
        int comparisons = 0;
        String stopWord = "./src/arvores/suporte/stopwords.txt";
        ArrayList<String> stopWords = new ArrayList<>();
        try {

            BufferedReader br = new BufferedReader(new FileReader(pog));
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

            DynamicArray words = new DynamicArray();

            String line;
            while ((line = br.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                for (String word : lineWords) {
                    String cleanedWord = word.toLowerCase().replaceAll("[^a-zA-ZÀ-ÿ\\s]", " ").toLowerCase();
                    if (!cleanedWord.isEmpty()) {
                        int index = words.binarySearch(cleanedWord);

                        if (index < 0) {
                            comparisons++;
                            if (!stopWords.contains(cleanedWord.toLowerCase())) {
                                words.insert(-index - 1, cleanedWord);
                            }

                        }
                    }
                }
            }

            br.close();

            long endTime = System.nanoTime();
            double elapsedTimeInSeconds = (endTime - startTime) / 1e9;

            System.out.println("Array Dinamico:");
            System.out.println("Tempo de pesquisa (segundos): " + elapsedTimeInSeconds);
            System.out.println("Numero de comparacoes: " + comparisons);

//            bagulho para mostrar a frequência das palavras está com defeito
//            for (String word : words.getWords()) {
//                System.out.println(word + ": " + words.getFrequency(word));
//            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}

class DynamicArray {

    private String[] data;
    private int size;

    public DynamicArray() {
        data = new String[10];
        size = 0;
    }

    public void insert(int index, String word) {
        if (size == data.length) {
            resize();
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = word;
        size++;
    }

    private void resize() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    public int size() {
        return size;
    }

    public int uniqueWords() {
        return size;
    }

    public String mostFrequentWord() {
        if (size == 0) {
            return null;
        }

        String mostFrequent = data[0];
        int maxFrequency = getFrequency(mostFrequent);

        for (int i = 1; i < size; i++) {
            String word = data[i];
            int frequency = getFrequency(word);
            if (frequency > maxFrequency) {
                mostFrequent = word;
                maxFrequency = frequency;
            }
        }

        return mostFrequent;
    }

    public int getFrequency(String word) {
        int frequency = 0;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(word)) {
                frequency++;
            }
        }
        return frequency;
    }

    public String[] getWords() {
        return data;
    }
    
    public int binarySearch(String word) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = data[mid].compareTo(word);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }
}
