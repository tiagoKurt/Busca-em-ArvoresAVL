package arvores.visao;

import java.util.ArrayList;
import java.util.List;

class BTreeNode {
    List<String> Chave;
    List<BTreeNode> Filho;
    boolean Folha;

    public BTreeNode(boolean Folha) {
        this.Folha = Folha;
        Chave = new ArrayList<>();
        Filho = new ArrayList<>();
    }
}

public class ArvoreB {
    private BTreeNode root;
    private int t; // Ordem da árvore

    public ArvoreB(int t) {
        root = new BTreeNode(true);
        this.t = t;
    }

    // Função para inserir uma chave na árvore
    public void insert(String key) {
        BTreeNode rootNode = root;

        if (rootNode.Chave.size() == (2 * t - 1)) {
            BTreeNode newNode = new BTreeNode(false);
            newNode.Filho.add(rootNode);
            splitChild(newNode, 0);
            root = newNode;
            insertNonFull(newNode, key);
        } else {
            insertNonFull(rootNode, key);
        }
    }

    // Função para inserir em um nó não cheio
    private void insertNonFull(BTreeNode node, String key) {
        int i = node.Chave.size() - 1;

        if (node.Folha) {
            node.Chave.add("");
            while (i >= 0 && key.compareTo(node.Chave.get(i)) < 0) {
                node.Chave.set(i + 1, node.Chave.get(i));
                i--;
            }
            node.Chave.set(i + 1, key);
        } else {
            while (i >= 0 && key.compareTo(node.Chave.get(i)) < 0) {
                i--;
            }
            i++;
            BTreeNode child = node.Filho.get(i);
            if (child.Chave.size() == (2 * t - 1)) {
                splitChild(node, i);
                if (key.compareTo(node.Chave.get(i)) > 0) {
                    i++;
                }
            }
            insertNonFull(node.Filho.get(i), key);
        }
    }

    // Função para dividir um filho de um nó
    private void splitChild(BTreeNode parentNode, int index) {
        BTreeNode nodeToSplit = parentNode.Filho.get(index);
        BTreeNode newNode = new BTreeNode(nodeToSplit.Folha);
        parentNode.Chave.add(index, nodeToSplit.Chave.get(t - 1));

        for (int j = 0; j < t - 1; j++) {
            newNode.Chave.add(nodeToSplit.Chave.get(t));
            nodeToSplit.Chave.remove(t);
        }

        if (!nodeToSplit.Folha) {
            for (int j = 0; j < t; j++) {
                newNode.Filho.add(nodeToSplit.Filho.get(t));
                nodeToSplit.Filho.remove(t);
            }
        }
        parentNode.Filho.add(index + 1, newNode);
        nodeToSplit.Chave.remove(t - 1);
    }

    // Função para procurar uma chave na árvore
    public boolean search(String key) {
        return search(root, key);
    }

    private boolean search(BTreeNode node, String key) {
        int i = 0;
        while (i < node.Chave.size() && key.compareTo(node.Chave.get(i)) > 0) {
            i++;
        }
        if (i < node.Chave.size() && key.equals(node.Chave.get(i))) {
            return true;
        }
        if (node.Folha) {
            return false;
        }
        return search(node.Filho.get(i), key);
    }

    // Método de impressão em ordem
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(BTreeNode node) {
        if (node != null) {
            int i;
            for (i = 0; i < node.Chave.size(); i++) {
                if (!node.Folha) {
                    inOrderTraversal(node.Filho.get(i));
                }
                System.out.print(node.Chave.get(i) + " ");
            }
            if (!node.Folha) {
                inOrderTraversal(node.Filho.get(i));
            }
        }
    }

    public static void main(String[] args) {
        ArvoreB bTree = new ArvoreB(3);

        // Inserindo algumas chaves na árvore
        bTree.insert("apple");
        bTree.insert("banana");
        bTree.insert("cherry");
        bTree.insert("date");
        bTree.insert("fig");
        bTree.insert("grape");
        bTree.insert("kiwi");
        bTree.insert("lemon");
        bTree.insert("melon");
        bTree.insert("orange");
        bTree.insert("pear");
        bTree.insert("quince");

        System.out.println("Chaves na árvore (em ordem):");
        bTree.inOrderTraversal();

        // Procurando por uma chave
        String searchKey = "kiwi";
        boolean found = bTree.search(searchKey);
        if (found) {
            System.out.println("\n" + searchKey + " foi encontrado na árvore.");
        } else {
            System.out.println("\n" + searchKey + " não foi encontrado na árvore.");
        }
    }
}
