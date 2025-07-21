package Unidad_3;

import java.util.HashMap;
import java.util.Map;

public class FibonacciPD {
    private Map<Integer,Long> visitados;

    public FibonacciPD(){
        visitados = new HashMap<>();
    }

    public long getFibonacci(int n){
        if(n ==0 || n==1){
            return n; // Caso base
        }

        if(visitados.containsKey(n)){
            // Si ya se calculo, no realiza de nuevo el calculo
            return visitados.get(n);
        }

        // Obtiene el resultado con recursividad
        long resultado = getFibonacci(n-1) + getFibonacci(n-2);

        // Lo pone en el mapa para ahorrar futuros calculos
        visitados.put(n,resultado);

        return resultado;
    }
}
