# Teoría de la Complejidad Algorítmica

La **teoría de la complejidad** estudia el coste (recursos necesarios) de ejecutar algoritmos. Sus dos aspectos principales son el **coste temporal** (tiempo de ejecución) y **coste espacial** (memoria usada).

---

## 1. Coste Temporal y Espacial

### Coste Temporal

Es el **tiempo** que tarda un algoritmo en ejecutarse, generalmente medido en función del tamaño de la entrada (*n*).

- **Ejemplo:** Buscar un nombre en una lista de *n* personas.

### Coste Espacial

Es la **memoria** que requiere el algoritmo para ejecutarse.

- **Ejemplo:** Un arreglo auxiliar para almacenar datos temporales.

---

## 2. Factores Propios y Circunstanciales

- **Factores propios:** Dependen del algoritmo en sí (estructura, lógica).
    - Ejemplo: El método de ordenamiento utilizado.
- **Factores circunstanciales:** Dependen del contexto (hardware, compilador, datos de entrada).
    - Ejemplo: Un ordenador más rápido, datos ya ordenados.

---

## 3. Análisis Teórico y Experimental

### Análisis Teórico

Se estudia la eficiencia del algoritmo **matemáticamente**, considerando el peor, mejor y caso promedio.

- **Ventaja:** Generaliza sin depender del hardware.
- **Ejemplo:** Demostrar que el algoritmo de búsqueda binaria tiene complejidad O(log n).

### Análisis Experimental

Consiste en **medir** el tiempo/memoria usados en la práctica, ejecutando el algoritmo con diferentes entradas y midiendo los resultados.

- **Ventaja:** Refleja la realidad del entorno específico.
- **Ejemplo:** Ejecutar un algoritmo de ordenamiento y medir el tiempo con un cronómetro.

---

## 4. Notaciones Asintóticas

Las **notaciones asintóticas** describen el comportamiento de la complejidad para entradas grandes.

### Big O (O grande)

- **Definición:** Indica el **límite superior** del crecimiento del coste: “Como máximo, el algoritmo tarda esto”.
- **Ejemplo:** O(n) significa que, como máximo, el tiempo de ejecución crece linealmente con *n*.

### Omega (Ω)

- **Definición:** Indica el **límite inferior**: “Como mínimo, el algoritmo tarda esto”.
- **Ejemplo:** Ω(n) significa que, al menos, el algoritmo necesita tiempo lineal.

### Theta (Θ)

- **Definición:** Indica el **ajuste exacto**: “El algoritmo tarda esto, ni más ni menos, para entradas grandes”.
- **Ejemplo:** Θ(n) significa que el algoritmo siempre tarda tiempo lineal.

---

## 5. Ejemplos Cotidianos de Complejidad

| Complejidad   | Ejemplo cotidiano                         | Explicación breve                   |
|---------------|-------------------------------------------|-------------------------------------|
| O(1)          | Buscar un libro en una biblioteca ordenada por código | Acceso directo, siempre el mismo tiempo |
| O(n)          | Buscar un nombre en una lista desordenada | Revisas uno por uno                |
| O(log n)      | Buscar una palabra en un diccionario      | Cada búsqueda reduce el espacio a la mitad |
| O(n^2)        | Comparar todos los pares de personas en una fiesta | Cada persona se compara con todas las demás |
| O(2^n)        | Probar todas las combinaciones de ingredientes para una receta | El número de combinaciones crece exponencialmente |

---

## 6. Ejemplos de Cálculo de Complejidad

### Ejemplo 1: Sumar los elementos de un arreglo

```java
for (int i = 0; i < n; i++) {
    suma += arreglo[i];
}
```
- Realiza *n* operaciones ⇒ **O(n)**

### Ejemplo 2: Doble ciclo anidado

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        // operación constante
    }
}
```
- Realiza *n × n* = *n²* operaciones ⇒ **O(n²)**

### Ejemplo 3: Búsqueda binaria

```java
int izquierda = 0, derecha = n - 1;
while (izquierda <= derecha) {
    int medio = (izquierda + derecha) / 2;
    if (arreglo[medio] == valor) { /* ... */ }
    else if (arreglo[medio] < valor) izquierda = medio + 1;
    else derecha = medio - 1;
}
```
- Divide el problema a la mitad cada vez ⇒ **O(log n)**

---

## 7. Resumen Visual

| Notación | Definición                 | Ejemplo Algorítmico      |
|----------|----------------------------|--------------------------|
| O(f(n))  | Límite superior (peor caso)| Ordenamiento burbuja     |
| Ω(f(n))  | Límite inferior (mejor caso)| Búsqueda en arreglo ordenado |
| Θ(f(n))  | Ajuste exacto (caso promedio)| Suma de arreglo         |

---

## 8. Consejos Prácticos

- Analiza la **estructura de bucles** y llamadas recursivas.
- Considera siempre el **peor caso** salvo que se especifique lo contrario.
- La eficiencia importa más en entradas grandes.
- Elige algoritmos con menor complejidad para problemas críticos.

---

## Conclusión

Entender la complejidad algorítmica permite elegir soluciones más eficientes y prever el comportamiento de los programas en diferentes situaciones. Es una herramienta fundamental para todo programador y analista de datos.
