package arvores.arvore_avl;

import arvores.arvore_avl.ArvoreAvl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Visao {
    public static void main(String[] args) throws IOException {
        
    }
    public void mostrarArvore(String arquivo) throws FileNotFoundException, IOException{
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
        ArrayList<String> buscador = new ArrayList<>();
        ArvoreAvl arvore = new ArvoreAvl();
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.toLowerCase().replaceAll("[^a-zA-ZÀ-ÿ\\s]", " ");
                String[] palavras = linha.split("\\s+");
                for (int i = 0; i < palavras.length; i++) {
                    if (!stopWords.contains(palavras[i].toLowerCase())) {
                        arvore.insert(palavras[i].toLowerCase());
                        buscador.add(palavras[i].toLowerCase());
                    }
                }
            }
        arvore.printAVLTree();
    }
    
        
    public void resumoArvoreAvl(String arquivo) throws FileNotFoundException, IOException{
        long startTime = System.nanoTime();
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
        ArrayList<String> buscador = new ArrayList<>();
        ArvoreAvl arvore = new ArvoreAvl();
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.toLowerCase().replaceAll("[^a-zA-ZÀ-ÿ\\s]", " ");
                String[] palavras = linha.split("\\s+");
                for (int i = 0; i < palavras.length; i++) {
                    if (!stopWords.contains(palavras[i].toLowerCase())) {
                        arvore.insert(palavras[i].toLowerCase());
                        buscador.add(palavras[i].toLowerCase());
                    }
                }
            }
        for(int j = 0; j < buscador.size();j++){
            arvore.find(buscador.get(j));
        }
        long endTime = System.nanoTime();
        double tempoConvertido = (endTime - startTime) / 1e9; 
        System.out.println("Tempo de pesquisa: "+ tempoConvertido + " segundos");
        System.out.println("Comparacoes: " + arvore.getContadorDeMovimentos());
        
    }

 }

