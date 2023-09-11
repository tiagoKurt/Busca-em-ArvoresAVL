package arvores.avl_binaria;

import java.util.*;
import java.util.concurrent.TimeUnit;

class TreeNode {

    String word;
    int count;
    TreeNode left, right;

    public TreeNode(String word) {
        this.word = word;
        this.count = 1;
        this.left = null;
        this.right = null;
    }
}

class AVLTree {

    TreeNode root;

    // Função auxiliar para obter a altura de um nó
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    // Função auxiliar para calcular o fator de balanceamento de um nó
    private int getBalance(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Rotação à direita em torno de um nó
    private TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        x.right = y;
        y.left = T2;

        return x;
    }

    // Rotação à esquerda em torno de um nó
    private TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        y.left = x;
        x.right = T2;

        return y;
    }

    // Inserir uma palavra na árvore AVL
    public TreeNode insert(TreeNode node, String word) {
        if (node == null) {
            return new TreeNode(word);
        }

        int compareResult = word.compareTo(node.word);

        if (compareResult < 0) {
            node.left = insert(node.left, word);
        } else if (compareResult > 0) {
            node.right = insert(node.right, word);
        } else {
            node.count++;
        }

        int balance = getBalance(node);

        // Rotações para balancear a árvore
        if (balance > 1 && word.compareTo(node.left.word) < 0) {
            return rightRotate(node);
        }
        if (balance < -1 && word.compareTo(node.right.word) > 0) {
            return leftRotate(node);
        }
        if (balance > 1 && word.compareTo(node.left.word) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && word.compareTo(node.right.word) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Função para inserir uma palavra na árvore AVL
    public void insert(String word) {
        root = insert(root, word);
    }

    // Função para buscar uma palavra na árvore AVL
    public TreeNode search(String word) {
        return search(root, word);
    }

    private TreeNode search(TreeNode node, String word) {
        if (node == null) {
            return null;
        }

        int compareResult = word.compareTo(node.word);

        if (compareResult == 0) {
            return node;
        } else if (compareResult < 0) {
            return search(node.left, word);
        } else {
            return search(node.right, word);
        }
    }
}

public class ArvoreImplement {

    public static void main(String[] args) {
        // Exemplo de texto
        String text = "Esta é uma implementação de exemplo em Java para contar a frequência de palavras em uma estrutura de dados.";

        // Dividir o texto em palavras
        String[] words = text.split("\\s+");

        // Usar uma lista para a Busca Binária
        List<String> binarySearchList = new ArrayList<>();

        // Usar uma árvore binária de pesquisa sem balanceamento
        TreeNode bstRoot = null;

        // Usar uma árvore AVL para balanceamento
        AVLTree avlTree = new AVLTree();

        // Contadores para comparações e atribuições
        int binarySearchComparisons = 0;
        int bstComparisons = 0;
        int avlComparisons = 0;

        long startTime, endTime;

        // Iniciar contagem de tempo para a Busca Binária
        startTime = System.nanoTime();

        for (String word : words) {
            int index = Collections.binarySearch(binarySearchList, word);
            if (index >= 0) {
                // A palavra já existe na lista, incrementar o contador
                binarySearchComparisons++;
            } else {
                // A palavra não existe na lista, inserir na posição correta
                int insertionPoint = -(index + 1);
                binarySearchList.add(insertionPoint, word);
                binarySearchComparisons += insertionPoint + 1;
            }
        }

        // Encerrar contagem de tempo para a Busca Binária
        endTime = System.nanoTime();
        long binarySearchTime = endTime - startTime;

        // Iniciar contagem de tempo para a Árvore Binária de Pesquisa sem balanceamento
        startTime = System.nanoTime();

        for (String word : words) {
            bstRoot = insertIntoBST(bstRoot, word);
        }

        // Encerrar contagem de tempo para a Árvore Binária de Pesquisa sem balanceamento
        endTime = System.nanoTime();
        long bstTime = endTime - startTime;
        
        // Iniciar contagem de tempo para a Árvore AVL
        startTime = System.nanoTime();

        for (String word : words) {
            avlTree.insert(word);
        }

        // Encerrar contagem de tempo para a Árvore AVL
        endTime = System.nanoTime();
        long avlTime = endTime - startTime;
        double segundos = TimeUnit.SECONDS.convert(binarySearchTime, TimeUnit.NANOSECONDS);
        double segundos2 = TimeUnit.SECONDS.convert(bstTime, TimeUnit.NANOSECONDS);
        double segundos3 = TimeUnit.SECONDS.convert(avlTime, TimeUnit.NANOSECONDS);

        System.out.println("\nComparações (Busca Binária): " + binarySearchComparisons);
        System.out.println("Tempo (Busca Binária balanceada): " + segundos + " seg");

        System.out.println("\nComparações (Árvore Binária de Pesquisa sem balanceamento): " + bstComparisons);
        System.out.println("Tempo (Árvore Binária sem balanceamento): " + segundos2 + " seg");

        System.out.println("\nComparações (Árvore AVL): " + avlComparisons);
        System.out.println("Tempo (Árvore AVL): " + avlTime + " seg");
        printAVL(bstRoot);
    }

    // Função para inserir uma palavra na Árvore Binária de Pesquisa sem balanceamento
    private static TreeNode insertIntoBST(TreeNode root, String word) {
        if (root == null) {
            return new TreeNode(word);
        }

        int compareResult = word.compareTo(root.word);

        if (compareResult < 0) {
            root.left = insertIntoBST(root.left, word);
        } else if (compareResult > 0) {
            root.right = insertIntoBST(root.right, word);
        } else {
            root.count++;
        }

        return root;
    }

    // Função para imprimir a tabela de frequências da Árvore Binária de Pesquisa sem balanceamento
    private static void printBST(TreeNode root) {
        if (root != null) {
            printBST(root.left);
            System.out.println(root.word + ": " + root.count);
            printBST(root.right);
        }
    }

    // Função para imprimir a tabela de frequências da Árvore AVL
    private static void printAVL(TreeNode root) {
        if (root != null) {
            printAVL(root.left);
            System.out.println(root.word + ": " + root.count);
            printAVL(root.right);
        }
    }
}
