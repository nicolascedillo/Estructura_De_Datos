# Métodos de Búsqueda: Lineal y Binaria

En programación y estructuras de datos, **buscar** significa encontrar la posición de un elemento dentro de una colección (como un arreglo). Dos de los métodos de búsqueda más comunes son la **búsqueda lineal** y la **búsqueda binaria**.

---

## 1. Búsqueda Lineal

### ¿Qué es?
La búsqueda lineal es el método más sencillo de búsqueda. Consiste en revisar cada elemento del arreglo uno por uno hasta encontrar el elemento deseado o hasta que se acaben los elementos.

### Funcionamiento

1. Empieza en el primer elemento del arreglo.
2. Compara el elemento actual con el valor buscado.
3. Si son iguales, devuelve la posición.
4. Si no, pasa al siguiente elemento.
5. Si llega al final sin encontrar el elemento, indica que no existe.

### Ejemplo en Java

```java
public static int busquedaLineal(int[] arreglo, int valor) {
    for (int i = 0; i < arreglo.length; i++) {
        if (arreglo[i] == valor) {
            return i; // Índice donde se encontró el valor
        }
    }
    return -1; // Valor no encontrado
}
```

### Complejidad
- **Tiempo peor caso:** O(n) (n = número de elementos)
- **Espacio:** O(1)

### Ventajas y Desventajas
**Ventajas:**
- Funciona en arreglos desordenados.
- Fácil de implementar.

**Desventajas:**
- Ineficiente para arreglos grandes.

---

## 2. Búsqueda Binaria

### ¿Qué es?
La búsqueda binaria es un método eficiente, **solo funciona en arreglos ordenados**. Divide el arreglo en mitades para localizar el elemento buscado.

### Funcionamiento

1. Compara el elemento del medio con el valor buscado.
2. Si son iguales, devuelve la posición.
3. Si el valor buscado es menor, repite la búsqueda en la mitad izquierda.
4. Si es mayor, repite la búsqueda en la mitad derecha.
5. Si el rango se reduce a cero, indica que no existe.

### Ejemplo en Java

```java
public static int busquedaBinaria(int[] arreglo, int valor) {
    int izquierda = 0, derecha = arreglo.length - 1;
    while (izquierda <= derecha) {
        int medio = izquierda + (derecha - izquierda) / 2;
        if (arreglo[medio] == valor) {
            return medio; // Índice donde se encontró el valor
        }
        if (arreglo[medio] < valor) {
            izquierda = medio + 1;
        } else {
            derecha = medio - 1;
        }
    }
    return -1; // Valor no encontrado
}
```

### Complejidad
- **Tiempo peor caso:** O(log n) (n = número de elementos)
- **Espacio:** O(1)

### Ventajas y Desventajas
**Ventajas:**
- Muy eficiente para arreglos grandes ordenados.
- Rápido para buscar repetidas veces.

**Desventajas:**
- Solo funciona en arreglos ordenados.
- Implementación un poco más compleja.

---

## Resumen de Complejidades

| Método           | Tiempo Peor Caso | Espacio |
|------------------|------------------|---------|
| Búsqueda Lineal  | O(n)             | O(1)    |
| Búsqueda Binaria | O(log n)         | O(1)    |

---

## ¿Cuándo usar cada método?

- Usa **búsqueda lineal** si el arreglo está desordenado o es pequeño.
- Usa **búsqueda binaria** si el arreglo está ordenado y es grande.

---

## Conclusión

Ambos métodos tienen su lugar en la programación. Elige el método adecuado según el tamaño y el orden de tus datos.
