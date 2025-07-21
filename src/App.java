import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Unidad_2.Estructuras_Lineales.Ejercicios_Lineales;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        Ejercicios_Lineales eL = new Ejercicios_Lineales();

        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(8);
        stack.push(2);
        System.out.println(eL.sumaConRecursividad(stack));

        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(2);
        numeros.add(1);
        System.out.println(eL.contarSublistas(numeros));


    }
}
