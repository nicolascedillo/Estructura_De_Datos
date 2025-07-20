package Unidad_1.Metodos_Ordenamiento;

public class Shell {

    public void ordenarShell(int[] numeros) {

        int n = numeros.length; // Longitud del arreglo

        for (int gap = (n / 2); gap > 0; gap /= 2) { // Crea los gaps

            for (int i = gap; i < n; i++) { // Recorre desde el gap hasta el final del arreglo

                int aux = numeros[i]; // Valor a insertar
                int j = i; // Declara desde donde se comienza a comparar hacia atras

                while (j >= gap && numeros[j - gap] > aux) { // Compara valor anterior al salto con el aux

                    numeros[j] = numeros[j - gap]; // Recorre hascia adelante
                    j -= gap; // J se reduce

                }

                numeros[j] = aux; // Se inserta el auxiliar en la poscicion correcta

            }
        }
    }
}
