package arvores.visao;

import java.util.ArrayList;
import java.util.Scanner;

import arvores.avl_binaria.ArvoresAVL;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class principalTerminal {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        Scanner entrada = new Scanner(System.in);
        ArrayList<String> buscador = new ArrayList<>();
        ArvoresAVL arvore = new ArvoresAVL();
        for (int i = 0; i < letras.length; i++) {
            arvore.insert(letras[i]);
        }

        arvore.printAVLTree();
        String nomeArquivo = "./src/arvores/arquivos/ExTexto.txt";


        try ( BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.toLowerCase().replaceAll("[^a-zA-ZÀ-ÿ\\s]", " ");
                String[] palavras = linha.split("\\s+");
                for (int i = 0; i < palavras.length; i++) {
                    buscador.add(palavras[i].toUpperCase());
                    arvore.addPalavra(palavras[i].toUpperCase());
                }
            }
            for (int i = 0; i < buscador.size(); i++) {
                System.out.println(buscador.get(i));
            }

            for (int i = 0; i < buscador.size(); i++) {
                if (arvore.binarySearch(buscador.get(i)) != -1) {
                    System.out.println(buscador.get(i));
                    System.out.println(
                            "A palavra foi achada na posição: " + i);

                } else {
                    System.out.println("A palavra: " + buscador.get(i) + ", não foi encontrada!");

                }
            }
            System.out.println("Movimentos: " + arvore.getContadorDeMovimentos());
            buscador.clear();

        }
    }

    public void AdiconarArvoreAVL(String arquivo) throws FileNotFoundException, IOException {
         long startTime = System.nanoTime();
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "Poste", "p", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        Scanner entrada = new Scanner(System.in);
        ArrayList<String> buscador = new ArrayList<>();
        ArvoresAVL arvore = new ArvoresAVL();
        for (int i = 0; i < letras.length; i++) {
            arvore.insert(letras[i]);
        }

        arvore.printAVLTree();
        Map<String, Integer> mapaPalavras = new HashMap<>();
        ArrayList<String> skr = new ArrayList<>();

        try ( BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.toLowerCase().replaceAll("[^a-zA-ZÀ-ÿ\\s]", " ");
                String[] palavras = linha.split("\\s+");
                for (int i = 0; i < palavras.length; i++) {
                    buscador.add(palavras[i].toUpperCase());
                    arvore.addPalavra(palavras[i].toUpperCase());
                }
            }
            for (int i = 0; i < buscador.size(); i++) {
                System.out.println(buscador.get(i));
            }

            for (int i = 0; i < buscador.size(); i++) {
                if (arvore.binarySearch(buscador.get(i)) != -1) {
                    System.out.println(buscador.get(i));
                    System.out.println(
                            "A palavra foi achada na posicao: " + i);

                } else {
                    System.out.println("A palavra: " + buscador.get(i) + ", não foi encontrada!");

                }
            }
            System.out.println("Movimentos: " + arvore.getContadorDeMovimentos());
            buscador.clear();
            long endTime = System.nanoTime();
            double elapsedTimeInSeconds = (endTime - startTime) / 1e9;
            System.out.println("Tempo de pesquisa (segundos): " + elapsedTimeInSeconds);
        }
    }
}
