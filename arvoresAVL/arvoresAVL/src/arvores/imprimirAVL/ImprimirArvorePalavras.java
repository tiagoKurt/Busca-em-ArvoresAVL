package arvores.imprimirAVL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ImprimirArvorePalavras {
    private int contadorDeMovimentos;
    
    private class Node {
        String word;
        Node left, right;
        int height;
        ArrayList<String> listaDePalavras = new ArrayList<>();

        Node(String word) {
            this.word = word;
            height = 1;
        }
    }

    private Node root;

    public void insert(String word) {
        root = insert(root, word);
    }

    public ArrayList<String> getListaPelaPalavra(String palavra) {
        Node no = find(root, String.valueOf(palavra.charAt(0)));
        return no.listaDePalavras;
    }

    public void removerPalavra(String palavra) {
        Node no = find(root, String.valueOf(palavra.charAt(0)));

        no.listaDePalavras.remove(palavra);

    }

    public int binarySearch(String palavra) {
        Node no = find(root, String.valueOf(palavra.charAt(0)));
        Collections.sort(no.listaDePalavras);
        int contadorDeMovimentos = 0;
        int comeco = 0;
        int fim = no.listaDePalavras.size() - 1;
        while (comeco <= fim) {
            int meio = (comeco + fim) / 2;
            int cmp = palavra.compareTo(no.listaDePalavras.get(meio));
            setContadorDeMovimentos((getContadorDeMovimentos() + contadorDeMovimentos++));
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
        for (int i = 0; i < no.listaDePalavras.size(); i++) {
            if (no.listaDePalavras.get(i).equals(palavra)) {
                return true;
            }
        }
        return false;
    }

    public void addPalavra(String palavra) {
        Node no = find(root, String.valueOf(palavra.charAt(0)));
        no.listaDePalavras.add(palavra);

    }

    public ArrayList<String> getLista(String letra) {

        return find(root, letra).listaDePalavras;
    }

    public Node find(String value) {
        return find(root, value);
    }

    private Node find(Node node, String value) {
        if (node == null) {
            return null;
        }
        if (node.word.equals(value)) {
            return node;
        }
        if (value.compareTo(node.word) < 0) {
            return find(node.left, value);
        } else {
            return find(node.right, value);
        }
    }

    private Node insert(Node node, String word) {
        if (node == null) {
            Node newNode = new Node(word);
            newNode.listaDePalavras.add(word);
            return newNode;
        }

        if (word.compareTo(node.word) < 0) {
            node.left = insert(node.left, word);
        } else if (word.compareTo(node.word) > 0) {
            node.right = insert(node.right, word);
        } else {
        
            node.listaDePalavras.add(word);
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

    private Node delete(Node node, String value) {
        if (node == null) {
            return null;
        }

        
        int cmp = value.compareTo(node.word);
        if (cmp < 0) {
            node.left = delete(node.left, value);
        } else if (cmp > 0) {
            node.right = delete(node.right, value);
        } else { 
            if (node.left == null && node.right == null) {
                node = null;
            }
           
            else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            }
           
            else {
               
                Node successor = node.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                
                node.word = successor.word;
               
                node.right = delete(node.right, successor.word);
            }
        }

       
        return balance(node);
    }

    private int balanceFactor(Node node) {
        return height(node.left) - height(node.right);
    }

    private Node balance(Node node) {
        if (node == null) {
            return null;
        }

        
        int balanceFactor = balanceFactor(node);

        
        if (balanceFactor > 1) {
           
            if (balanceFactor(node.left) < 0) {
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        }
       
        else if (balanceFactor < -1) {
           
            if (balanceFactor(node.right) > 0) {
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);
        }

        
        return node;
    }

    public boolean contains(String value) {
        Node current = root;

        while (current != null) {
            if (value.equals(current.word)) {
                return true;
            } else if (value.compareTo(current.word) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.word + " ");
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.word + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.word + " ");
        }
    }

    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.word + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
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

    public int getContadorDeMovimentos() {
        return contadorDeMovimentos;
    }

    public void setContadorDeMovimentos(int contadorDeMovimentos) {
        this.contadorDeMovimentos = contadorDeMovimentos;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

}