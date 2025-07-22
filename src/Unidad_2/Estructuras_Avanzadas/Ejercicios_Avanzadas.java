package Unidad_2.Estructuras_Avanzadas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Ejercicios_Avanzadas {

    /**
     * Determina si dos cadenas de caracteres son anagramas.
     * Dos cadenas son anagramas si tienen los mismos caracteres en la misma
     * cantidad,
     * sin importar el orden.
     *
     * Ejemplo 1:
     * Input: str1 = "listen", str2 = "silent"
     * Output: true
     * Explicación: Ambas cadenas tienen los mismos caracteres con la mismaP
     * frecuencia.
     *
     * Ejemplo 2:
     * Input: str1 = "hello", str2 = "bello"
     * Output: false
     * Explicación: Las cadenas tienen diferentes caracteres.
     *
     * Ejemplo 3:
     * Input: str1 = "triangle", str2 = "integral"
     * Output: true
     * Explicación: Ambas cadenas tienen los mismos caracteres con la misma
     * frecuencia.
     */
    public boolean areAnagrams(String str1, String str2) {

        Map<Character, Integer> string1 = new HashMap<>();
        Map<Character, Integer> string2 = new HashMap<>();

        for (char c : str1.toLowerCase().toCharArray()) {
            string1.put(c, string1.getOrDefault(c, 0) + 1);
        }
        for (char c : str2.toLowerCase().toCharArray()) {
            string2.put(c, string2.getOrDefault(c, 0) + 1);
        }

        return string1.equals(string2);
    }

    /**
     * Dado un array de números enteros y un objetivo, retorna los índices de dos
     * números para los que la suma de ambos sea igual al objetivo.
     *
     * Se asume que hay una sola solución
     *
     * Ejemplo A:
     * Input: nums = [9,2,3,6], objetivo = 5
     * Output: [1,2]
     * Explicación: nums[1] + nums[2] == 5, devolvemos [1, 2].
     *
     * Ejemplo B:
     * Input: nums = [9,2,3,6], objetivo = 10
     * Output: null
     */
    public int[] sumatoriaDeDos(int[] nums, int objetivo) {

        Map<Integer, Integer> numeros = new HashMap<>();
        int[] indices = new int[2];

        for (int i = 0; i < nums.length; i++) {

            // Calcula el elemento faltante
            int comp = objetivo - nums[i];

            if (numeros.containsKey(comp)) {
                
                // Guarda el indice del primer elemento y del 2do
                indices[0] = numeros.get(comp);
                indices[1] = i;
                return indices;
            }

            // Lo pone en el diccionario
            numeros.put(nums[i], i);
        }
        return null;
    }

    /**
     * Cuenta la frecuencia de cada caracter en la cadena recibida y
     * muestra el resultado por consola.
     *
     * Ejemplo:
     * Input: "hola"
     * Output: {h=1, o=1, l=1, a=1}
     */
    public void contarCaracteres(String texto) {

        Map<Character,Integer> mapa = new LinkedHashMap<>();

        for(char c: texto.toCharArray()){
            mapa.put(c,mapa.getOrDefault(c, 0)+1);
        }

        for(Map.Entry<Character,Integer> entry: mapa.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue() + " |");
        }
    }

    public boolean tieneDuplicados(int[] numeros) {
        Set<Integer> set = new HashSet<>();
        for(int num:numeros){
            if(!set.add(num)) return true;
        }
        return false;
    }

    public boolean esIsograma(String palabra) {
        Set<Character> set = new HashSet<>();
        for(char c: palabra.toCharArray()){
            if(!set.add(c)) return false;
        }
        return true;

    }

    public int contarPalabrasUnicas(String frase) {
        Set<String> set = new HashSet<>();
        int cont =0;
        String[] separadas = frase.split(" ");
        for(String s:separadas){
            if(set.add(s)) cont++;
        }
        return cont;
    }
}
