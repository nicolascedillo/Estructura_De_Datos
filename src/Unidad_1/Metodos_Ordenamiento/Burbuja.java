package Unidad_1.Metodos_Ordenamiento;

public class Burbuja {

    public void ordenarBurbuja(int[] numeros) {
        // Orden ascendente

        int n = numeros.length; // Longitud del arreglo

        for (int i = 0; i < n; i++) { // Recorre el arreglo

            for (int j = i + 1; j < n; j++) { // Recorre una posicion adelante

                if (numeros[i] > numeros[j]) { // Compara 2 numeros simultaneos
                    // '<' para descendente

                    int temp = numeros[i]; // temporal
                    numeros[i] = numeros[j]; // Primer intercambio
                    numeros[j] = temp; // Segundo intercambio
                }
            }
        }
    }

    public void ordenarBurbujaMejorado(int[] numeros) {
        // Orden ascendente

        int n = numeros.length; // Longitud del arreglo
        boolean cambio; // Booleano para optimizar

        for (int i = 0; i < n - 1; i++) { // Recorre el arreglo

            cambio = false;

            for (int j = 0; j < n - 1 - i; j++) { // Recorre una posicion adelante

                if (numeros[j] > numeros[j+1]) { // Compara 2 numeros simultaneos
                    // '<' para descendente

                    int temp = numeros[j+1]; // temporal
                    numeros[j+1] = numeros[j]; // Primer intercambio
                    numeros[j] = temp; // Segundo intercambio
                    cambio = true;
                }
            }

            if (!cambio) { // Si no hubo cambios en la 1ra pasada, ya esta ordenado
                break;
            }
        }
    }
}
