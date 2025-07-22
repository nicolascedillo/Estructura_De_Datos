package Unidad_2.Estructuras_No_Lineales.Grafos;

import java.util.HashSet;
import java.util.Set;

public class NodeGrafo {
        private int valor;
    private Set<NodeGrafo> neighbors;

    public NodeGrafo(int valor) {
        this.valor = valor;
        this.neighbors = new HashSet<>();
    }

    public int getValor() {
        return valor;
    }

    public Set<NodeGrafo> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(NodeGrafo neighbor) {
        neighbors.add(neighbor);
    }
}
