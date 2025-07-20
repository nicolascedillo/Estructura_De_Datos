package Unidad_1.Metodos_Ordenamiento;

public class Insercion {

    public void ordenarInsercion(int[] numeros) {
        // Orden ascendente

        int n = numeros.length; // Longitud

        for (int i = 1; i < n; i++) { // Recorre desde el 2do elemento hasta el final

            int aux = numeros[i]; // Actual como auxiliar
            int j = i - 1; // Indice para comprar elementos anteriores

            while (j >= 0 && numeros[j] > aux) {
                // Mientras j este en el arreglo Y numeros[j] (primero) sea mayor a aux(segundo) 

                numeros[j + 1] = numeros[j]; // Lo desplaza a la izquierda
                j--; // Resta el indice para comparar con anteriores
            }

            numeros[j+1] = aux; // Inserta el numero en la posicion correcta

        }
    }
}
