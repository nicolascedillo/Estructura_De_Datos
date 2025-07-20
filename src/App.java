import java.util.Random;

import Unidad_1.Metodos_Ordenamiento.Burbuja;
import Unidad_1.Metodos_Ordenamiento.Insercion;
import Unidad_1.Metodos_Ordenamiento.Selection;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Random random = new Random();
        int[] arreglo = new int[100];
        for (int i =0; i<100;i++){
            int n = random.nextInt(1000);
            arreglo[i] =n;
        }

        for(int n:arreglo){
            System.out.print(n + " - ");
        }

        Burbuja burbuja = new Burbuja();
        burbuja.ordenarBurbujaMejorado(arreglo);

        System.out.println("\nordenados -----------------------");
        for(int n:arreglo){
            System.out.print(n + " - ");
        }
        
    }
}
