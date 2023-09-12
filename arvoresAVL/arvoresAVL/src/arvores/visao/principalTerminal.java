package arvores.visao;

import java.util.ArrayList;
import java.util.Scanner;

import arvores.avl_binaria.ArvoresAVL;

public class principalTerminal {
    public static void main(String[] args) {
        String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
        "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };


        
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> buscador = new ArrayList<>();
        ArvoresAVL arvore = new ArvoresAVL();
        for (int i = 0; i < letras.length; i++) {
            arvore.insert(letras[i]);
        }
        arvore.printAVLTree();
        
        String text = "Esta e uma implementação de exemplo em Java para contar a frequência de palavras em uma estrutura de dados.";

        // Dividir o texto em palavras
        String[] words = text.split("\\s+");

        for(int i = 0;i < words.length;i++){
            buscador.add(words[i].toUpperCase());
            arvore.addPalavra(words[i].toUpperCase());
        }

    
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
            buscador.add(words[i].toUpperCase());
            arvore.addPalavra(words[i].toUpperCase());
        }
        
        for (int i = 0; i < buscador.size(); i++) {

            if (arvore.acharPalavras(buscador.get(i)) == true) {
                System.out.println(
                        "A palavra foi achada na posição: " + arvore.binarySearch(buscador.get(i)));
                System.out.println("Movimentos: " + arvore.getContadorDeMovimentos());     
            } else {
                System.out.println("A palavra: " + buscador.get(i) + ", não foi encontrada!");
            }

        }
        buscador.clear();

    }
}
