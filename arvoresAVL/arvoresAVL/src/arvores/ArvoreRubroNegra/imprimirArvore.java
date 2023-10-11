package arvores.ArvoreRubroNegra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

enum Color {
    RED, BLACK
}

class Node {
    String data;
    Node parent;
    Node left;
    Node right;
    Color color;
}

public class imprimirArvore {
    private Node root;
    private Node TNULL;

    public imprimirArvore() {
        TNULL = new Node();
        TNULL.color = Color.BLACK;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }

    // Métodos de árvore rubro-negra

    public void insert(String key) {
        Node node = new Node();
        node.parent = null;
        node.data = key;
        node.left = TNULL;
        node.right = TNULL;
        node.color = Color.RED;

        Node y = null;
        Node x = this.root;

        while (x != TNULL) {
            y = x;
            int cmp = key.compareTo(x.data);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else {
            int cmp = key.compareTo(y.data);
            if (cmp < 0) {
                y.left = node;
            } else {
                y.right = node;
            }
        }

        if (node.parent == null){
            node.color = Color.BLACK;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        fixInsert(node);
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    private void fixInsert(Node k) {
        Node u;
        while (k.parent.color == Color.RED) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left;
                if (u.color == Color.RED) {
                    u.color = Color.BLACK;
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right;
                if (u.color == Color.RED) {
                    u.color = Color.BLACK;
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = Color.BLACK;
    }

    // Busca
    public boolean search(String key) {
        return search(root, key);
    }

    private boolean search(Node node, String key) {
        if (node == TNULL) {
            return false;
        }
        int cmp = key.compareTo(node.data);
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    // Impressão da árvore com cores
    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(Node node, int level) {
        if (node == TNULL) {
            return;
        }

        printTree(node.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println(node.data + " (" + node.color + ")");
        printTree(node.left, level + 1);
    }

    public static imprimirArvore buildTreeFromFile(String filename) throws IOException {
        imprimirArvore rbt = new imprimirArvore();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            rbt.insert(line);
        }
        br.close();
        return rbt;
    }

    public static void main(String[] args) {
        try {
            long startTime = System.nanoTime();
            imprimirArvore rbt = buildTreeFromFile("./src/arvores/arquivos/Pequeno Principe.txt");
            long endTime = System.nanoTime();
            long executionTime = (endTime - startTime) / 1000000; // Em milissegundos
            
            System.out.println("Árvore Rubro-Negra:");
            rbt.printTree();
            
            System.out.println("\nTempo de execução: " + executionTime + " ms");
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo.");
        }
    }
}

