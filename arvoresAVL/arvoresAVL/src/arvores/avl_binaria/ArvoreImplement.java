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

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    private int getBalance(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    private TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        x.right = y;
        y.left = T2;

        return x;
    }

    private TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        y.left = x;
        x.right = T2;

        return y;
    }

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

    public void insert(String word) {
        root = insert(root, word);
    }

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
        String text = "Esta é uma implementação de exemplo em Java para contar a frequência de palavras em uma estrutura de dados.";

        String[] words = text.split("\\s+");

        List<String> binarySearchList = new ArrayList<>();

        TreeNode bstRoot = null;

        AVLTree avlTree = new AVLTree();

        int binarySearchComparisons = 0;
        int bstComparisons = 0;
        int avlComparisons = 0;

        long startTime, endTime;

        startTime = System.nanoTime();

        for (String word : words) {
            int index = Collections.binarySearch(binarySearchList, word);
            if (index >= 0) {
                binarySearchComparisons++;
            } else {
                int insertionPoint = -(index + 1);
                binarySearchList.add(insertionPoint, word);
                binarySearchComparisons += insertionPoint + 1;
            }
        }

        endTime = System.nanoTime();
        long binarySearchTime = endTime - startTime;

        startTime = System.nanoTime();

        for (String word : words) {
            bstRoot = insertIntoBST(bstRoot, word);
        }

        endTime = System.nanoTime();
        long bstTime = endTime - startTime;
        
        startTime = System.nanoTime();

        for (String word : words) {
            avlTree.insert(word);
        }

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

    private static void printBST(TreeNode root) {
        if (root != null) {
            printBST(root.left);
            System.out.println(root.word + ": " + root.count);
            printBST(root.right);
        }
    }

    private static void printAVL(TreeNode root) {
        if (root != null) {
            printAVL(root.left);
            System.out.println(root.word + ": " + root.count);
            printAVL(root.right);
        }
    }
}
