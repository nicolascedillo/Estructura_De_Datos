package Unidad_2.Estructuras_Lineales;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Ejercicios_Lineales {

    /**
     * Suma los elementos de una pila
     * 
     * @param pila
     * @return int
     */
    public int sumarElementosPila(Stack<Integer> pila) {
        int resultado = 0;

        while (!pila.isEmpty()) {
            resultado = resultado + pila.pop(); // Suma todos los elementos de la lista
        }

        return resultado;
    }

    // ------------------------------------------------------------------------------------------

    /**
     * Cuenta la cantidad de vocales con una pila
     * 
     * @param texto
     * @return int
     */
    public int contarVocalesConPila(String texto) {

        Stack<Character> vocales = new Stack<>();
        int cont = 0;

        for (Character c : texto.toCharArray()) {

            if (c == 'a' || c == 'e' ||
                    c == 'i' || c == 'o' || c == 'u') {

                vocales.push(c); // Si es vocal, la anade a la pila
            }
        }

        while (!vocales.isEmpty()) {
            vocales.pop();
            cont++;
        } // Cuenta los elemntos de la pila

        return cont;
    }

    // ------------------------------------------------------------------------------------------

    /**
     * Invierte un texto
     * 
     * @param texto
     * @return String
     */
    public String invertirTexto(String texto) {

        Stack<Character> aux = new Stack<>();
        StringBuilder constructor = new StringBuilder();

        for (Character c : texto.toCharArray()) {
            aux.push(c); // Anade todos los caracteres al aux
        }

        while (!aux.isEmpty()) {
            constructor.append(aux.pop());
            // Agrega todos los elementos al reves al StringBuilder
        }

        return constructor.toString();
    }

    // ------------------------------------------------------------------------------------------

    /**
     * Elimina duplicados de una lista de enteros manteniendo el orden de aparición.
     *
     * @param lista Lista original con posibles duplicados.
     * @return Nueva lista sin elementos repetidos.
     *
     *         Ejemplo:
     *         Entrada: [4, 1, 2, 1, 4, 3]
     *         Salida: [4, 1, 2, 3]
     */
    public List<Integer> eliminarDuplicados(List<Integer> lista) {

        List<Integer> sinRepetidos = new LinkedList<>();

        for (Integer num : lista) {

            if (!sinRepetidos.contains(num)) {

                sinRepetidos.add(num); // Si no lo contiene, lo anade a la lista
            }
        }

        return sinRepetidos;
    }

    // ------------------------------------------------------------------------------------------

    /**
     * Verifica si una cadena es un palíndromo usando una pila.
     *
     * @param texto Cadena a evaluar.
     * @return true si es palíndromo, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "Anita lava la tina"
     *         Salida: true
     */
    public boolean esPalindromo(String texto) {

        Stack<Character> invertido = new Stack<>();
        char[] arreglo = texto.toLowerCase().toCharArray();

        for (char c : arreglo) {

            if (c != ' ') {

                invertido.push(c); // Si no es espacio, lo anade a la pila
            }
        }

        for (char c : arreglo) {

            if (c != ' ') {

                char c2 = invertido.pop();
                if (c != c2) { // Compara el primero con el ultimo en un bucle

                    return false;
                }
            }
        }

        return true;
    }

    // ------------------------------------------------------------------------------------------

    /**
     * Cuenta cuántos elementos están repetidos en una cola.
     *
     * @param numeros Lista de enteros.
     * @return Número de elementos que aparecen más de una vez.
     *
     *         Ejemplo:
     *         Entrada: [2, 4, 2, 5, 4, 6]
     *         Salida: 2
     */
    public int contarRepetidos(List<Integer> numeros) {

        Map<Integer, Integer> datos = new HashMap<>();

        for (int num : numeros) {

            datos.put(num, datos.getOrDefault(num, 0) + 1);
            // Crea un mapa con todos los numeros y cuantas veces aparecen
        }

        int repetidos = 0;
        for (int n : datos.values()) {

            if (n > 1) {

                repetidos++;
                // Si el valor es mas de 1, es repetido
            }
        }

        return repetidos;
    }

    // ------------------------------------------------------------------------------------------

    /**
     * Invierte el contenido de una cola utilizando una pila.
     *
     * @param elementos Lista original.
     * @return Lista invertida.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4]
     *         Salida: [4, 3, 2, 1]
     */
    public List<Integer> invertirCola(List<Integer> elementos) {

        Stack<Integer> aux = new Stack<>();
        List<Integer> invertidos = new LinkedList<>();

        for (int num : elementos) {

            aux.push(num); // Se agrega cada elemento a la cola
        }

        while (!aux.isEmpty()) {

            invertidos.add(aux.pop()); // Se agrega en orden inverso los elementos a la lista
        }

        return invertidos;
    }

    // ------------------------------------------------------------------------------------------

    /**
     * Separa vocales y consonantes de una lista de caracteres.
     *
     * @param caracteres Lista de letras.
     * @return Mapa con dos listas: una de vocales y una de consonantes.
     *
     *         Ejemplo:
     *         Entrada: ['a', 'b', 'e', 'l', 'i', 's']
     *         Salida: {vocales=[a, e, i], consonantes=[b, l, s]}
     */
    public Map<String, List<Character>> separarVocalesConsonantes(List<Character> caracteres) {

        Map<String, List<Character>> datos = new HashMap<>();

        List<Character> vocales = new LinkedList<>();
        List<Character> consonantes = new LinkedList<>();

        for (char c : caracteres) {
            if (c == 'a' || c == 'e' ||
                    c == 'i' || c == 'o' || c == 'u') {
                vocales.add(c);
            } else {
                consonantes.add(c);
            }
        }

        datos.put("Vocales", vocales);
        datos.put("Consonantes", consonantes);

        return datos;
    }

    // ------------------------------------------------------------------------------------------

    /**
     * Verifica si un texto tiene los parentesis validos
     * 
     * @param texto
     * @return boolean
     * 
     *         Ejemplo:
     *         Entrada: "(){}"\n
     *         Salida: true
     *         Entrada: "}"
     *         Salida: false
     */
    public boolean isValidParenthesis(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {

                stack.push(c); // Si es signo de apertura, va al stack

            } else {

                if (stack.isEmpty()) {
                    return false; // Si esta vacia, comenzo por uno de cierre
                }

                char ultimo = stack.pop(); // Saca el signo de apertura

                if ((ultimo == '(' && c != ')') ||
                        (ultimo == '{' && c != '}') ||
                        (ultimo == '[' && c != ']')) {
                    // Comprueba si es de la misma categoria, si no lo es, retorna falso

                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // ------------------------------------------------------------------------------------------

    /**
     * Ordena una pila
     * 
     * @param stack
     */
    public void sortStack(Stack<Integer> stack) {

        // Creamos una pila auxiliar para ayudar en la ordenación
        Stack<Integer> aux = new Stack<>();

        // Procesamos todos los elementos de la pila original
        while (!stack.isEmpty()) {

            // Extraemos el elemento superior de la pila original
            int temp = stack.pop();

            // Mientras la pila auxiliar no esté vacía y el elemento en la cima de aux sea
            // mayor que temp,
            // devolvemos elementos de aux a la pila original
            while (!aux.isEmpty() && aux.peek() > temp) {
                stack.push(aux.pop());
            }

            // Insertamos temp en la posición correcta en la pila auxiliar
            aux.push(temp);
        }

        // Finalmente, transferimos los elementos ordenados de la pila auxiliar de
        // vuelta a la pila original
        while (!aux.isEmpty()) {
            stack.push(aux.pop());
        }
    }

    // ------------------------------------------------------------------------------------------

    /**
     * Suma recursiva de elementos en una pila
     * 
     * Implementa una función que reciba una pila de enteros y retorne la suma de
     * todos sus elementos usando recursividad.
     * 
     * Ejemplo:
     * Entrada: [5, 3, 8, 2]
     * Salida: 18
     */
    public int sumaConRecursividad(Stack<Integer> pila) {
        if (pila.isEmpty()) {

            return 0;
        }
        int ultimo = pila.pop();

        return ultimo + sumaConRecursividad(pila);
    }

    // ------------------------------------------------------------------------------------------

    /**
     * 
     * 2. Verificar si una lista es simétrica
     * Enunciado:
     * Dada una lista de enteros, determina si es simétrica (igual de izquierda a
     * derecha y derecha a izquierda).
     * 
     * Ejemplo:
     * Entrada: [1, 2, 3, 2, 1]
     * Salida: true
     * Entrada: [1, 2, 3, 4, 1]
     * Salida: false
     */
    public boolean esSimetrica(List<Integer> enteros) {
        Queue<Integer> cola = new LinkedList<>();
        Stack<Integer> pila = new Stack<>();
        for (int num : enteros) {
            cola.add(num);
            pila.push(num);
        }

        while (!cola.isEmpty()) {
            if (cola.poll() != pila.pop()) {
                return false;
            }
        }
        return true;
    }

    // ------------------------------------------------------------------------------------------

    /**
     * 3. Eliminar los elementos repetidos de una cola
     * Enunciado:
     * Dada una cola de enteros, elimina todos los elementos repetidos y retorna la
     * cola sin duplicados, conservando el orden original.
     * Ejemplo:
     * Entrada: [4, 2, 2, 1, 4, 3]
     * Salida: [4, 2, 1, 3]
     */
    public Queue<Integer> eliminarDuplicados(Queue<Integer> cola) {
        Queue<Integer> sinDuplicados = new LinkedList<>();
        for (int num : cola) {
            if (!sinDuplicados.contains(num)) {
                sinDuplicados.add(num);
            }
        }
        return sinDuplicados;
    }

    // ------------------------------------------------------------------------------------------

    /**
     * 4. Separar pares e impares en una lista
     * Enunciado:
     * Implementa una función que reciba una lista de enteros y retorne dos listas:
     * una con los pares y otra con los impares.
     * Ejemplo:
     * Entrada: [3, 4, 7, 10, 5]
     * Salida: {pares: [4, 10], impares: [3, 7, 5]}
     */
    public Map<String, List<Integer>> separarPatidad(List<Integer> lista) {

        List<Integer> pares = new LinkedList<>();
        List<Integer> impares = new LinkedList<>();

        for (int num : lista) {
            if (num % 2 == 0) {
                pares.add(num);
            } else {
                impares.add(num);
            }
        }

        Map<String, List<Integer>> mapa = new HashMap<>();
        mapa.put("pares", pares);
        mapa.put("impares", impares);
        return mapa;
    }

    // ------------------------------------------------------------------------------------------

    /**
     * 5. Contar la frecuencia de cada elemento usando un mapa
     * Enunciado:
     * Recibe una lista de enteros y retorna un mapa donde la clave sea el número y
     * el valor cuántas veces aparece.
     * Ejemplo:
     * Entrada: [2, 3, 2, 4, 3, 2]
     * Salida: {2: 3, 3: 2, 4: 1}
     */
    public Map<Integer, Integer> contarFrecuencia(List<Integer> lista) {
        Map<Integer, Integer> mapa = new HashMap<>();
        for (int num : lista) {
            mapa.put(num, mapa.getOrDefault(num, 0) + 1);
        }
        return mapa;
    }

    // ------------------------------------------------------------------------------------------

    /**
     * 5. Contar el número de sublistas que son palíndromos
     * Enunciado:
     * Dada una lista de enteros, cuenta cuántas sublistas (segmentos consecutivos)
     * son palíndromos.
     * (Una sublista es cualquier segmento, por ejemplo [2,3,2] dentro de
     * [1,2,3,2,1])
     * 
     * Ejemplo:
     * Entrada: [1,2,3,2,1]
     * Salida: 7
     * (Las sublistas palíndromas son: [1], [2], [3], [2], [1], [2,3,2],
     * [1,2,3,2,1])
     */
    public int contarSublistas(List<Integer> listaMayor) {

        int cont = 0;
        int n = listaMayor.size();

        // Recorre el inicio de la lista
        for (int i = 0; i < n; i++) {

            // Recorre el final de una lista
            for (int j = i; j < n; j++) {

                // Manda al helper a ver si la lista mandada es palindromo
                if (sublistaPalindromo(listaMayor, i, j)) {

                    cont++; // Si lo es, lo cuenta
                }
            }
        }
        return cont;
    }

    private boolean sublistaPalindromo(List<Integer> sublista, int inicio, int fin) {

        while (inicio < fin) {

            // Compara cada elemento con el que le toca
            if (!sublista.get(inicio).equals(sublista.get(fin))) {

                return false;
            }

            // Para irse moviendo en la lista y comprobar todos lo elementos
            inicio++;
            fin--;
        }
        return true;
    }
}
