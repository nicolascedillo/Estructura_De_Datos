package Unidad_1.Metodos_Ordenamiento;

public class Selection {

    public void ordenarSelection(int[] numeros) {
        // Orden ascendente

        int n = numeros.length; // Longitud

        for (int i = 0; i < n; i++) { // Recorre el arreglo

            int indice = i; // Indice del maximo o minimo, depende

            for (int j = i + 1; j < n; j++) { // Recorre todos los demas

                if (numeros[indice] > numeros[j]) { // Compara si el actual es menor
                    // '<' para otro orden

                    indice = j; // Actualiza el indice al verdadero minimo
                }
            } // Al finalizar este bucle, indice tendra el indice del numero mas grande

            if (indice != i) { // Si el indice no es el miso, realiza intercambio
                int temp = numeros[i];
                numeros[i] = numeros[indice];
                numeros[indice] = temp;
            }

        }
    }
}
