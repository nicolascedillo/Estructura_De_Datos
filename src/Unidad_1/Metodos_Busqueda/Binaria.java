package Unidad_1.Metodos_Busqueda;

public class Binaria {

    public int busquedaBinaria(int[] arreglo, int k) {
        // El arreglo que recibe como parametro DEBE estar ordenado

        int alto = arreglo.length - 1; // El alto es la longitud del arreglo menos 1
        int bajo = 0; // El bajo es 0

        while (bajo <= alto) {
            // Mientras el bajo tenga valores menores o iguales al alto

            int central = bajo + (alto - bajo) / 2; // Valor central

            if (arreglo[central] == k) {
                return arreglo[central]; // Si es el valor del centro, lo retorna
            }

            if (arreglo[central] < k) { 
                // Si el valor es mayor que el central:

                bajo = central + 1; // El bajo pasa a ser el central +1

            } else {

                alto = central - 1; // Si no, el alto es el central -1
            }

        }

        return -1; // Retorna -1 si no lo cuentra, tambien puede ser null
    }
}
