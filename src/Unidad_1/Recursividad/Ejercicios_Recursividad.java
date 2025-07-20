package Unidad_1.Recursividad;

public class Ejercicios_Recursividad {

    /**
     * Suma de números enteros consecutivos:
     * 
     * Escribe una función recursiva que calcule la
     * suma de todos los númerosenteros consecutivos desde 1 hasta un número dado n.
     * Por
     * ejemplo, si n es igual a 5, la función debe devolver 1 + 2 + 3 + 4 + 5 = 15.
     * 
     * @param n
     * @return n + sumaEnterosConsecutivos(n-1)
     */
    public int sumaEnterosConsecutivos(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return n + sumaEnterosConsecutivos(n - 1);
    }

    /**
     * Potencia de un número:
     * 
     * Escribe una función recursiva que calcule la potencia de un
     * número base elevado a un exponente entero exponente. Por ejemplo, si base es
     * 2 y
     * exponente es 3, la función debe devolver 2^3 = 8.
     * 
     * @param base
     * @param exponente
     * @return base * pontencia(base, exponente-1);
     */
    public int pontencia(int base, int exponente) {
        if (base == 0 || base == 1 || exponente == 1) {
            return base;
        }
        return base * pontencia(base, exponente - 1);
    }

    /**
     * Suma de digitos de un numero:
     * 
     * Si el número es menor que 10, lo cual significa que
     * solo tiene un dígito, se devuelve el número mismo. En caso contrario, se
     * extrae el
     * último dígito utilizando el operador módulo % y se calcula el los dígitos
     * menos el
     * ultimo utilizando la división entera /10. Luego, se realiza una llamada
     * recursiva a
     * sumaDigitos con el resto y sesuma el último dígito.
     * 
     * @param numero
     * @return ultimoDigito + sumaDigitos(numero / 10)
     */
    public int sumaDigitos(int numero) {
        if (numero < 10) {
            return numero;
        }

        int ultimoDigito = numero % 10;
        // Es el residuo al dividir para 10

        return ultimoDigito + sumaDigitos(numero / 10);

    }

    /**
     * Impresion Recursiva Descendente
     * 
     * Escribe un método recursivo que imprima los números desde n hasta 1
     * de forma descendente, separados por espacios.
     * 
     * @param numero
     */
    public void impresionDescendente(int numero) {
        if (numero < 1) {
            return;
        }

        System.out.print((numero) + " ");
        impresionDescendente(numero - 1);
    }
    

    /**
     * Reverso de un numero
     * 
     * Crea una función recursiva llamada reverso que reciba un número entero
     * n y devuelva su número inverso
     * Por ejemplo, si se recibe 1234, la función debe devolver 4321.
     * 
     * @param numero
     * @return
     */
    public int reverso(int numero) {
        return reversoHelper(numero, 0);
    }

    private int reversoHelper(int numero, int resultado) {
        if (numero == 0) {
            return resultado;
        }
        return reversoHelper(numero / 10, resultado * 10 + numero % 10);
        // El numero para 10, sin el ultimo digito
        // resultado por diez para vovler decena, mas el ultimo digito

    }
}
