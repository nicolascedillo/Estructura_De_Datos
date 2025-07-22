package Unidad_2.Estructuras_No_Lineales;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Unidad_2.Estructuras_No_Lineales.ArbolAVL.Node;

public class Ejercicios_No_Lineales {

    
    public Node invertTree(Node root) {
        if(root == null){
            return null;
        }

        Node temp = root.getLeft();

        root.setLeft(invertTree(root.getRight()));
        root.setRight(invertTree(temp));

        return root;
    }

    public List<List<Node>> listLevels(Node root) {
        List<List<Node>> listaDeListas = new ArrayList<>();

        LinkedList<Node> listaAux = new LinkedList<>();
        listaAux.add(root);
    
        while (!listaAux.isEmpty()) {  

            List<Node> niveles = new LinkedList<>();
            int size = listaAux.size();

            for (int i = 0; i<size ; i++){
                Node current = listaAux.poll();
                niveles.add(current);

                if (current.getLeft() != null) {
                    listaAux.add(current.getLeft());
                }

                if (current.getRight() != null) {
                    listaAux.add(current.getRight());
                }
            }
            
            listaDeListas.add(niveles);
        }

        return listaDeListas;
    }

    public int maxDepth(Node root) {
        if (root == null){
            return 0;
        }
        return 1+ Math.max(maxDepth(root.getLeft()),maxDepth(root.getRight()));
    }
}
