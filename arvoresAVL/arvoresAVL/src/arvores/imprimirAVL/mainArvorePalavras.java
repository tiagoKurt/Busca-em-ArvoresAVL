package arvores.imprimirAVL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mainArvorePalavras {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String arquivo = "./src/arvores/arquivos/teste.txt";
        String stopWord = "./src/arvores/suporte/stopwords.txt";

        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> stopWords = new ArrayList<>();
        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
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
        
        while ((linhaPrincipal = leitor.readLine()) != null) {
            String[] palavrasLinha = linhaPrincipal.split("\\s+");
            for (String palavra : palavrasLinha) {

                palavra = palavra.replaceAll("[^a-zA-Z]", "");

                if (!palavra.isEmpty()) {
                    if (!stopWords.contains(palavra.toLowerCase())) {
                        words.add(palavra.toLowerCase());
                    }

                }
            }
        }
        
        leitor.close();
        
        
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> buscador = new ArrayList<>();
        ImprimirArvorePalavras arvore = new ImprimirArvorePalavras();
        for (int i = 0; i < words.size(); i++) {
            arvore.insert(words.get(i));
        }
        arvore.printAVLTree();
    }
    
    public void ImprimirArvoreTela(String arquivosSelecionado) throws FileNotFoundException, IOException{

        String stopWord = "./src/arvores/suporte/stopwords.txt";

        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> stopWords = new ArrayList<>();
        BufferedReader leitor = new BufferedReader(new FileReader(arquivosSelecionado));
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
        
        while ((linhaPrincipal = leitor.readLine()) != null) {
            String[] palavrasLinha = linhaPrincipal.split("\\s+");
            for (String palavra : palavrasLinha) {

                palavra = palavra.replaceAll("[^a-zA-Z]", "");

                if (!palavra.isEmpty()) {
                    if (!stopWords.contains(palavra.toLowerCase())) {
                        words.add(palavra.toLowerCase());
                    }

                }
            }
        }
        leitor.close();
        
        
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> buscador = new ArrayList<>();
        ImprimirArvorePalavras arvore = new ImprimirArvorePalavras();
        for (int i = 0; i < words.size(); i++) {
            arvore.insert(words.get(i));
        }
        arvore.printAVLTree();
    }
}
