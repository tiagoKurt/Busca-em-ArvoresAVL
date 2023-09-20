package arvores.Arvore_semAVL;

import java.util.ArrayList;


class Node {

    String data;
    ArrayList<Integer> listaDePosicoes;
    Node left, right;

    public Node(String data, int position) {
        this.data = data;
        this.listaDePosicoes = new ArrayList<>();
        this.listaDePosicoes.add(position);
        left = right = null;
    }
}

class BinaryTree {

    Node root;
    int comparisons;

    public BinaryTree() {
        root = null;
        comparisons = 0;
    }

    void insert(String data, int position) {
        root = insertRec(root, data, position);
    }

    Node insertRec(Node root, String data, int position) {
        comparisons++;
        if (root == null) {
            return new Node(data, position);
        }

        int compareResult = data.compareTo(root.data);

        if (compareResult < 0) {
            root.left = insertRec(root.left, data, position);
        } else if (compareResult > 0) {
            root.right = insertRec(root.right, data, position);
        } else {
            root.listaDePosicoes.add(position);
        }

        return root;
    }

    void inOrder() {
        inOrderRec(root);
    }

    void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print("A palavra: '" + root.data + "' foi encontrada nas posicoes: ");
            for (int position : root.listaDePosicoes) {
                System.out.print(position + " ");
            }
            System.out.println();
            inOrderRec(root.right);
        }
    }

    int getComparisons() {
        return comparisons;
    }
    
    void printTree() {
        printTree(root, "");
    }

    void printTree(Node node, String indent) {
        if (node != null) {
            printTree(node.right, indent + "   ");
            System.out.println(indent + "+-- " + node.data 
//                    + " (Posições: " + node.listaDePosicoes.toString() + ")"
            );
            printTree(node.left, indent + "   ");
        }
    } 
}

