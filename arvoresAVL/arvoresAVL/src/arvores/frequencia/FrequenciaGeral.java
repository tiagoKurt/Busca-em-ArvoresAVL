package arvores.frequencia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrequenciaGeral {

    public void resumoGeral(String nomeArquivo) throws IOException {
        try {
            
            long startTime = System.currentTimeMillis();
            Map<String, Integer> mapaPalavras = new HashMap<>();
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

            try ( BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    linha = linha.toLowerCase().replaceAll("[^a-zA-ZÀ-ÿ\\s]", " ");
                    String[] palavras = linha.split("\\s+");

                    for (String palavra : palavras) {
                        if (!palavra.isEmpty()) {
                            if (!stopWords.contains(palavra.toLowerCase())) {
                                mapaPalavras.put(palavra, mapaPalavras.getOrDefault(palavra, 0) + 1);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Frequencia das palavras:");
            Map<String, Integer> mapaOrdenado = new TreeMap<>(Collator.getInstance());
            mapaOrdenado.putAll(mapaPalavras);
            for (Map.Entry<String, Integer> entry : mapaOrdenado.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrequenciaGeral.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
