
static class Node {
    int data;
    Node left, right;

    public Node(int item) {
        this.data = item;
        left = right = null;
    }
}

public static Node insertNode(Node root, int data) {
    if (root == null) {
        return new Node(data); // Si el arbol esta vacio, se crea un nuevo nodo
    }
    if (data < root.data) {
        root.left = insertNode(root.left, data); // Si el dato es menor que el nodo actual, se inserta en la
                                                 // izquierda del nodo
    } else {
        root.right = insertNode(root.right, data); // Si el dato es mayor que el nodo actual, se inserta en la
                                                   // derecha del nodo
    }
    return root;
}

// Metodo para recorrer el arbol en orden
public static void inOrder(Node root) {
    if (root != null) {
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
}

// Metodo para recorrer los nodos con dos hijos

public static void inOrderTwoChildren(Node root) {
  if (root != null) {
    inOrderTwoChildren(root.left);
    if (root.left != null && root.right != null) {
        System.out.print(root.data + " ");
    }
    inOrderTwoChildren(root.right);
  }
}

// Metodo para recorrer los nodos con un hijo par
static void preOrderOneChild(Node root){
    if(root!= null){
        if(root.left != null  && root.left.data % 2 == 0){
            System.out.print(root.data + " ");
        }
        if( root.right != null && root.right.data % 2 == 0){
            System.out.print(root.data + " ");
        }
        preOrderOneChild(root.left);
        preOrderOneChild(root.right);
    }
}

//Metodo en pre orden para calcular la suma de los hijos de cada nodo
public static void preOrderSum(Node root){
    if(root != null){
        int sum = 0;
        if(root.left != null){
            sum += root.left.data;
        }
        if(root.right != null){
            sum += root.right.data;
        }
        System.out.print(sum + " ");
        preOrderSum(root.left);
        preOrderSum(root.right);
    }
   
}

// constante para la distancia entre nodos
public static final int COUNT = 10;

// Metodo para imprimir el arbol
public static void print2DUtil(Node root, int space) {
    if (root == null)
        return;
    space += COUNT;
    print2DUtil(root.right, space);
    System.out.print("\n");
    for (int i = COUNT; i < space; i++)
        System.out.print(" ");
    System.out.print(root.data + "\n");
    print2DUtil(root.left, space);
}

public static void main(String[] args) {
    Node root = null;
    root = insertNode(root, 18);
    insertNode(root, 5);
    insertNode(root, 3);
    insertNode(root, 4);
    insertNode(root, 1);
    insertNode(root, 8);
    insertNode(root, 20);
    insertNode(root, 19);
    insertNode(root, 21);
    insertNode(root, 22);



    System.out.println("InOrder: ");
    inOrder(root);
    System.out.println("\nInOrder Two Children: ");
    inOrderTwoChildren(root);

    System.out.println("\n\n Los nodos con un hijo par son: ");
    preOrderOneChild(root);

    System.out.println("\n\nLa suma de los hijos de cada nodo es: ");
    preOrderSum(root);
    System.out.println("\n\nArbol: ");
    print2DUtil(root, 0);
};
