package Unidad_2.Estructuras_No_Lineales.ArbolAVL;

import java.util.Stack;

public class ArbolAVL {
    private Node root;

    public ArbolAVL() {
        this.root = null;
    }

    /**
     * Obtener altura de un nodo
     * 
     * @param node
     * @return altura del arbol
     */
    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    /**
     * Balance de un nodo
     * 
     * @param node
     * @return Diferencia altura del subarbol izquierdo y derecho
     */
    public int balance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    /**
     * Inserta un valor al arbol
     * 
     * @param value
     */
    public void insert(int value) {
        root = insertRec(root, value);
    }

    /**
     * Insert recursivo que mide el balanceo y rota
     * 
     * @param node
     * @param value
     * @return nueva raiz
     */
    private Node insertRec(Node node, int value) {

        // Se crea el nuevo nodo
        if (node == null) {

            Node nuevo = new Node(value);
            nuevo.setHeight(1);
            return nuevo;
        }

        if (node.getValue() < value) {
            // Si el valor del nodo es menor al de insertar,
            // inserta a la derecha
            insertRec(node.getRight(), value);

        } else if (node.getValue() > value) {
            // Si el valor del nodo es mayor al de insertar,
            // inserta a la izquierda
            insertRec(node.getLeft(), value);

        } else {
            // No permite numeros iguales
            return node;
        }

        // Se establece la altura al nodo actual
        int newHeight = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        node.setHeight(newHeight);

        // Se obtiene el factor de balance
        int factorBalance = balance(node);

        // Si tiene mas ramas a la izquierda y el nodo se debe insertar en la izquierda
        if (factorBalance > 1 && node.getLeft().getValue() > value) {
            return rotacionDerecha(node);
        }

        // Si tiene mas ramas a la derecha y el nodo se debe insertar a la derecha
        if (factorBalance < -1 && node.getRight().getValue() < value) {
            return rotacionIzquierda(node);
        }

        // Si tiene mas ramas a la izquierda pero debe insertarse a la derecha
        if (factorBalance > 1 && node.getLeft().getValue() < value) {
            node.setLeft(rotacionIzquierda(node.getLeft()));
            return rotacionDerecha(node);
        }

        // Si tiene mas ramas a la derecha pero debe insertarse a la izquierda
        if (factorBalance < -1 && node.getRight().getValue() > value) {
            node.setRight(rotacionDerecha(node.getRight()));
            return rotacionIzquierda(node);
        }

        return node;
    }

    /**
     * Rotacion A la Derecha
     * 
     * @param nodoDesbalanceado
     * @return Hijo izquierdo (nueva raiz)
     */
    private Node rotacionDerecha(Node nodoDesbalanceado) {
        // Hijo izquierdo (nueva raiz)
        Node hijoLeft = nodoDesbalanceado.getLeft();
        // Subarbol derecho del hijo izquierdo
        Node subArbolDerecha = hijoLeft.getRight();

        // La nueva raiz tiene a la derecha la antigua raiz
        hijoLeft.setRight(nodoDesbalanceado);
        // La antigua raiz tiene de hijo izquierdo el subarbol derecho de la nueva raiz
        nodoDesbalanceado.setLeft(subArbolDerecha);

        // Se actualizan alturas
        // Primero de la antigua raiz porque esta es necesaria para la de la nueva raiz
        nodoDesbalanceado
                .setHeight(1 + Math.max(height(nodoDesbalanceado.getLeft()), height(nodoDesbalanceado.getRight())));
        hijoLeft.setHeight(1 + Math.max(height(hijoLeft.getLeft()), height(hijoLeft.getRight())));

        return hijoLeft;
    }

    /**
     * Rotacion a la Izquierda
     * 
     * @param nodoDesbalanceado
     * @return Hijo derecho (nueva raiz)
     */
    private Node rotacionIzquierda(Node nodoDesbalanceado) {
        // Hijo derecha (nueva raiz)
        Node hijoRight = nodoDesbalanceado.getRight();
        // Subarbol izquierdo del hijo derecha
        Node subarbolizquierdo = hijoRight.getLeft();

        // La nueva raiz tiene de izquierda la antigua raiz
        hijoRight.setLeft(nodoDesbalanceado);
        // La antigua raiz tiene de subarbol derecho el subarbol izquierdo de la nueva
        // raiz
        nodoDesbalanceado.setRight(subarbolizquierdo);

        // Se actualiza las alturas
        nodoDesbalanceado
                .setHeight(1 + Math.max(height(nodoDesbalanceado.getLeft()), height(nodoDesbalanceado.getRight())));
        hijoRight.setHeight(1 + Math.max(height(hijoRight.getLeft()), height(hijoRight.getRight())));

        return hijoRight;
    }

    // Impresion del arbol

    public void inOrder() {
        inOrderHelper(root);
    }

    private void inOrderHelper(Node node) {
        if (node != null) {
            inOrderHelper(node.getLeft());
            System.out.println(node);
            inOrderHelper(node.getRight());
        }
    }

    public void preOrder() {
        preOrderHelper(root);
    }

    private void preOrderHelper(Node node) {
        if (node != null) {
            System.out.println(node);
            preOrderHelper(node.getLeft());
            preOrderHelper(node.getRight());
        }
    }

    public void postOrder() {
        postOrderHelper(root);
    }

    private void postOrderHelper(Node node) {
        if (node != null) {
            postOrderHelper(node.getLeft());
            postOrderHelper(node.getRight());
            System.out.println(node);
        }
    }

    public void preOrderIterative(Node root) {
        // Verifica si el nodo raíz es nulo, en cuyo caso no hay nada que recorrer
        if (root == null) {
            return;
        }

        // Crea una pila para manejar los nodos del árbol durante el recorrido
        Stack<Node> stack = new Stack<>();

        // Empuja (push) el nodo raíz en la pila para iniciar el recorrido
        stack.push(root);

        // Continúa el recorrido mientras la pila no esté vacía
        while (!stack.isEmpty()) {
            // Saca (pop) el nodo del tope de la pila
            Node node = stack.pop();

            // Imprime el valor del nodo actual
            System.out.print(node.getValue() + ", ");

            // Empuja el hijo derecho primero para que el hijo izquierdo se procese primero
            // Esto se debe a que una pila es LIFO (Last In, First Out)
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }

            // Empuja el hijo izquierdo
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }

    public void postOrderIterative(Node root) {
        // Verifica si el nodo raíz es nulo, en cuyo caso no hay nada que recorrer
        if (root == null) {
            return;
        }

        // Crea dos pilas para manejar los nodos del árbol durante el recorrido
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        // Empuja el nodo raíz en la primera pila
        stack1.push(root);

        // Continua el recorrido mientras la primera pila no esté vacía
        while (!stack1.isEmpty()) {
            // Saca el nodo del tope de la primera pila y lo empuja en la segunda pila
            Node node = stack1.pop();
            stack2.push(node);

            // Empuja los hijos izquierdo y derecho del nodo en la primera pila
            if (node.getLeft() != null) {
                stack1.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack1.push(node.getRight());
            }
        }

        // Imprime los nodos de la segunda pila, que están en orden post-order
        while (!stack2.isEmpty()) {
            Node node = stack2.pop();
            System.out.print(node.getValue() + ", ");
        }
    }
}
