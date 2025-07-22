package Unidad_2.Estructuras_No_Lineales.Grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Grafo {
     // Conjunto de nodos del grafo
    private Set<NodeGrafo> nodes;

    public Grafo() {
        this.nodes = new HashSet<>();
    }

    /**
     * Añade un nodo al grafo con el valor dado.
     * @param value Valor del nodo
     * @return El nodo creado
     */
    public NodeGrafo addNode(int value) {
        NodeGrafo node = new NodeGrafo(value);
        nodes.add(node);
        return node;
    }

    /**
     * Añade una arista bidireccional (no dirigida) entre dos nodos.
     * @param src Nodo origen
     * @param dest Nodo destino
     */
    public void addEdge(NodeGrafo src, NodeGrafo dest) {
        src.addNeighbor(dest);
        dest.addNeighbor(src);
    }

    /**
     * Añade una arista unidireccional (dirigida) del nodo src al nodo dest.
     * @param src Nodo origen
     * @param dest Nodo destino
     */
    public void addEdgeUni(NodeGrafo src, NodeGrafo dest) {
        src.addNeighbor(dest);
    }

    /**
     * Imprime el grafo mostrando los vecinos de cada nodo.
     */
    public void printGraph() {
        for (NodeGrafo node : nodes) {
            System.out.println("Vertice " + node.getValor() + ": ");
            System.out.print("\t");
            for (NodeGrafo vecino : node.getNeighbors()) {
                System.out.print(" => " + vecino.getValor());
            }
            System.out.println("");
        }
    }

    /**
     * Realiza un recorrido en profundidad (DFS) desde el nodo dado.
     * Imprime el orden de visita de los nodos.
     * @param startNode Nodo inicial
     */
    public void getDFS(NodeGrafo startNode) {
        // Mapeo de nodo a índice para el arreglo visited
        HashMap<NodeGrafo, Integer> nodeToIndex = getNodeToIndexMap();
        boolean[] visited = new boolean[nodes.size()];
        System.out.print("DFS: ");
        getDFSUtil(startNode, visited, nodeToIndex);
        System.out.println();
    }

    /**
     * Función auxiliar recursiva para DFS.
     * @param node Nodo actual
     * @param visited Arreglo de nodos visitados
     * @param nodeToIndex Mapeo de nodo a índice
     */
    private void getDFSUtil(NodeGrafo node, boolean[] visited, HashMap<NodeGrafo, Integer> nodeToIndex) {
        int idx = nodeToIndex.get(node);
        if (visited[idx]) return;
        visited[idx] = true;
        System.out.print(node.getValor() + " ");
        for (NodeGrafo neighbor : node.getNeighbors()) {
            getDFSUtil(neighbor, visited, nodeToIndex);
        }
    }

    /**
     * Realiza un recorrido en anchura (BFS) desde el nodo dado.
     * Imprime el orden de visita de los nodos.
     * @param startNode Nodo inicial
     */
    public void getBFS(NodeGrafo startNode) {
        HashMap<NodeGrafo, Integer> nodeToIndex = getNodeToIndexMap();
        boolean[] visited = new boolean[nodes.size()];
        Queue<NodeGrafo> queue = new LinkedList<>();
        System.out.print("BFS: ");
        queue.add(startNode);
        visited[nodeToIndex.get(startNode)] = true;
        while (!queue.isEmpty()) {
            NodeGrafo current = queue.poll();
            System.out.print(current.getValor() + " ");
            for (NodeGrafo neighbor : current.getNeighbors()) {
                int idx = nodeToIndex.get(neighbor);
                if (!visited[idx]) {
                    visited[idx] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    /**
     * Devuelve la matriz de adyacencia del grafo.
     * Cada fila i y columna j es 1 si hay arista de i a j, 0 si no.
     * @return matriz de adyacencia
     */
    public int[][] getAdjacencyMatrix() {
        List<NodeGrafo> nodeList = new ArrayList<>(nodes);
        int n = nodeList.size();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            NodeGrafo node = nodeList.get(i);
            for (NodeGrafo neighbor : node.getNeighbors()) {
                int j = nodeList.indexOf(neighbor);
                if (j != -1) {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }

    /**
     * Imprime la matriz de adyacencia del grafo.
     */
    public void printAdjacencyMatrix() {
        int[][] matrix = getAdjacencyMatrix();
        List<NodeGrafo> nodeList = new ArrayList<>(nodes);
        System.out.print("   ");
        for (NodeGrafo node : nodeList) {
            System.out.print(node.getValor() + " ");
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(nodeList.get(i).getValor() + ": ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Crea un mapeo de cada nodo a un índice único.
     * Útil para recorridos y matrices de adyacencia.
     */
    private HashMap<NodeGrafo, Integer> getNodeToIndexMap() {
        HashMap< NodeGrafo, Integer> map = new HashMap<>();
        int idx = 0;
        for (NodeGrafo node : nodes) {
            map.put(node, idx++);
        }
        return map;
    }
}
