package arvores.arvore_avl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ArvoreAvl {
    private int contadorDeMovimentos = 0;

    private class Node {
        String word;
        Node left, right;
        int height;
        String listaDePalavras = "";

        Node(String word) {
            this.word = word;
            height = 1;
        }
    }
    private Node root;

    public void insert(String word) {
        root = insert(root, word);
    }

    public int getContadorDeMovimentos() {
        return contadorDeMovimentos;
    }

    public void setContadorDeMovimentos(int contadorDeMovimentos) {
        this.contadorDeMovimentos = contadorDeMovimentos;
    }

    public String getListaPelaPalavra(String palavra) {
        Node no = find(root, String.valueOf(palavra.charAt(0)));
        return no.listaDePalavras;
    }

    public void removerPalavra(String palavra) {
        Node no = find(root, String.valueOf(palavra.charAt(0)));
        no.listaDePalavras = removeWord(no.listaDePalavras, palavra);
    }

    public int binarySearch(String palavra) {
        Node no = find(root, String.valueOf(palavra.charAt(0)));
        String[] words = no.listaDePalavras.split(",");
        int contadorDeMovimentos = 0;
        int comeco = 0;
        int fim = words.length - 1;
        while (comeco <= fim) {
            int meio = (comeco + fim) / 2;
            int cmp = palavra.compareTo(words[meio]);
            if (cmp == 0) {
                return meio;
            } else if (cmp < 0) {
                fim = meio - 1;
            } else {
                comeco = meio + 1;
            }
        }
        return -1;
    }

    public boolean acharPalavras(String palavra) {
        Node no = find(root, String.valueOf(palavra.charAt(0)));
        String[] words = no.listaDePalavras.split(",");
        for (String word : words) {
            if (word.equals(palavra)) {
                return true;
            }
        }
        return false;
    }

    public void addPalavra(String palavra) {
        Node no = find(root, String.valueOf(palavra.charAt(0)));
        no.listaDePalavras = addWord(no.listaDePalavras, palavra);
    }

    public String getLista(String letra) {
        return find(root, letra).listaDePalavras;
    }

    public Node find(String value) {
        contadorDeMovimentos+=1;
        return find(root, value);
    }

    private Node find(Node node, String value) {
        if (node == null) {
            return null;
        }
        if (node.word.equals(value)) {
            contadorDeMovimentos  += 1;
            return node;
        }
        if (value.compareTo(node.word) < 0) {
            contadorDeMovimentos += 1;
            return find(node.left, value);
        } else {
            contadorDeMovimentos += 1;
            return find(node.right, value);
        }
    }

    private Node insert(Node node, String word) {
        if (node == null) {
            Node newNode = new Node(word);
            newNode.listaDePalavras = word;
            return newNode;
        }

        if (word.compareTo(node.word) < 0) {
            node.left = insert(node.left, word);
        } else if (word.compareTo(node.word) > 0) {
            node.right = insert(node.right, word);
        } else {
            node.listaDePalavras = addWord(node.listaDePalavras, word);
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

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

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    private Node rightRotate(Node node) {
        Node leftChild = node.left;
        Node rightGrandChild = leftChild.right;

        leftChild.right = node;
        node.left = rightGrandChild;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        leftChild.height = 1 + Math.max(height(leftChild.left), height(leftChild.right));

        return leftChild;
    }

    private Node leftRotate(Node node) {
        Node rightChild = node.right;
        Node leftGrandChild = rightChild.left;

        rightChild.left = node;
        node.right = leftGrandChild;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        rightChild.height = 1 + Math.max(height(rightChild.left), height(rightChild.right));

        return rightChild;
    }

    private String removeWord(String words, String wordToRemove) {
        String[] wordArray = words.split(",");
        StringBuilder result = new StringBuilder();
        for (String word : wordArray) {
            if (!word.equals(wordToRemove)) {
                if (result.length() > 0) {
                    result.append(",");
                }
                result.append(word);
            }
        }
        return result.toString();
    }

    private String addWord(String words, String wordToAdd) {
        if (words.isEmpty()) {
            return wordToAdd;
        }
        return words + "," + wordToAdd;
    }




    private void printAVLTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("'--");
                indent += "  ";
            } else {
                System.out.print("|--");
                indent += "| ";
            }
            System.out.println(node.word);

            printAVLTree(node.left, indent, false);
            printAVLTree(node.right, indent, true);
        }
    }

    public void printAVLTree() {
        printAVLTree(root, "", true);
    }


    // Resto do código permanece o mesmo
}
