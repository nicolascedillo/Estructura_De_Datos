package Unidad_1.Metodos_Busqueda;

public class Lineal {

    public int busquedaLineal(int[] numeros, int k) {

        for (int n : numeros) { // for each de todos los elementos
            if (n == k) { 
                return n; // Si el arreglo contiene el valor de la clave 'k', lo retorna
            }
        }

        return -1; // Si no encuentra, retorna -1
    }
}
