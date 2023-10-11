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

public class RubroNegra {

    private Node root;
    private Node TNULL;
    private int comparisons;

    public RubroNegra() {
        TNULL = new Node();
        TNULL.color = Color.BLACK;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
        comparisons = 0;
    }

    // Métodos de árvore rubro-negra
    // Inserção
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
            comparisons++;
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

        if (node.parent == null) {
            node.color = Color.BLACK;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        fixInsert(node);
    }

    // Rotação à esquerda
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

    // Rotação à direita
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

    // Balanceamento
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
        comparisons++;
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    // Outros métodos da árvore rubro-negra
    // Método para contar comparações
    public int getComparisonCount() {
        return comparisons;
    }

    public static RubroNegra MakeArvoreArquivo(String arquivo) throws IOException {
        String line;
        RubroNegra rbt = new RubroNegra();
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
        BufferedReader br = new BufferedReader(new FileReader(arquivo));

        while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (!stopWords.contains(word.toLowerCase())) {
                    rbt.insert(line);
                }
            }
        }
        br.close();
        return rbt;

    }

    public static void main(String[] args) {
        try {
            long startTime = System.nanoTime();
            RubroNegra rbt = MakeArvoreArquivo("./src/arvores/arquivos/Pequeno Principe.txt");
            long endTime = System.nanoTime();
            int comparisons = rbt.getComparisonCount();

            double tempoConvertido = (endTime - startTime) / 1e9;

            System.out.println("Arvore Rubro Negra: ");
            System.out.println("Tempo de pesquisa: " + tempoConvertido + " segundos");
            System.out.println("Comparações: " + comparisons);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo.");
        }
    }

    public void resumoGeralRubroNegra(String arquivo) {
        try {
            long startTime = System.nanoTime();

            RubroNegra rbt = MakeArvoreArquivo(arquivo);
            long endTime = System.nanoTime();
            double tempoConvertido = (endTime - startTime) / 1e9;

            System.out.println("Arvore Rubro Negra: ");
            System.out.println("Tempo de pesquisa: " + tempoConvertido + " segundos");
            System.out.println("Comparacoes: " + comparisons);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo.");
        }
    }
}
