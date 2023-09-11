package Arvores.avl_binaria;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FreqPalavras {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        String nomeArquivo = "./src/arvores/arquivos/teste.txt"; 
        Map<String, Integer> mapaPalavras = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.toLowerCase().replaceAll("[^a-zA-ZÀ-ÿ\\s]", " ");
                String[] palavras = linha.split("\\s+");

                for (String palavra : palavras) {
                    if (!palavra.isEmpty()) {
                        mapaPalavras.put(palavra, mapaPalavras.getOrDefault(palavra, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Integer> mapaOrdenado = new TreeMap<>(Collator.getInstance());
        mapaOrdenado.putAll(mapaPalavras);

        for (Map.Entry<String, Integer> entry : mapaOrdenado.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Tempo de execução: " + executionTime + " milissegundos");
    }
    
    public void frequenciaPalavras(String nomeArquivo){
        long startTime = System.currentTimeMillis();

        nomeArquivo = "./src/dicTXT/teste.txt"; 
        Map<String, Integer> mapaPalavras = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.toLowerCase().replaceAll("[^a-zA-ZÀ-ÿ\\s]", " ");
                String[] palavras = linha.split("\\s+");

                for (String palavra : palavras) {
                    if (!palavra.isEmpty()) {
                        mapaPalavras.put(palavra, mapaPalavras.getOrDefault(palavra, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Integer> mapaOrdenado = new TreeMap<>(Collator.getInstance());
        mapaOrdenado.putAll(mapaPalavras);

        for (Map.Entry<String, Integer> entry : mapaOrdenado.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Tempo de execução: " + executionTime + " milissegundos");
    }
}
