# Recursividad en Programación

La **recursividad** es una técnica de programación donde una función se llama a sí misma para resolver un problema. Es muy poderosa para problemas que pueden dividirse en subproblemas similares al original.

---

## ¿Qué es la recursividad?

Una función recursiva es aquella que se llama a sí misma dentro de su propio cuerpo. El proceso continúa hasta que se cumple una **condición de parada** (caso base), que evita llamadas infinitas.

### Estructura Básica

```java
void funcionRecursiva(tipo parametro) {
    if (condicionDeParada) {
        // Caso base: detener la recursión
        return;
    }
    // Llamada recursiva
    funcionRecursiva(nuevoParametro);
    
}
```

---

## Ejemplo Clásico: Factorial

El factorial de un número n (n!) se define como:

- n! = n × (n-1)!
- 0! = 1 (caso base)

**Código en Java:**

```java
public static int factorial(int n) {
    if (n == 0) {
        return 1; // Caso base
    } 
    return n * factorial(n - 1); // Llamada recursiva
}
```

---

## Componentes de una función recursiva

1. **Caso base:** Condición en la que la función deja de llamarse a sí misma.
2. **Llamada recursiva:** La función se llama a sí misma con parámetros modificados.
3. **Progreso hacia el caso base:** Cada llamada debe acercarse al caso base para evitar recursión infinita.

---

## Ejemplo: Imprimir números descendentes

```java
public void imprimirDescendente(int n) {
    if (n < 1) {
        return;
    }
    System.out.print(n + " ");
    imprimirDescendente(n - 1);
}
```

---

## Complejidad de la recursividad

### Complejidad temporal

- Depende del número de llamadas recursivas y de la lógica interna.
- **Ejemplo:** Factorial → O(n), ya que realiza n llamadas antes de alcanzar el caso base.

### Complejidad espacial (memoria)

- Cada llamada recursiva se guarda en la pila de ejecución.
- **Espacio:** O(n) si se hacen n llamadas antes de alcanzar el caso base.

**Nota:** Si las llamadas recursivas son muy profundas, puede producirse un **StackOverflowError**.

---

## Recursividad vs. Iteración

| Característica | Recursividad | Iteración |
|----------------|--------------|-----------|
| Legibilidad    | Alta en problemas auto-similares | Alta en problemas secuenciales |
| Eficiencia     | Puede ser menos eficiente por uso de pila | Usualmente más eficiente en memoria |
| Casos ideales  | Problemas dividibles en subproblemas | Procesos repetitivos simples |

---

## Ejemplo avanzado: Fibonacci

```java
public static int fibonacci(int n) {
    if (n <= 1) {
        return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
    
}
```
- **Complejidad temporal:** O(2ⁿ), por llamadas repetidas.
- **Complejidad espacial:** O(n), por profundidad de la pila.

---

## Ventajas y desventajas

**Ventajas:**
- Solución elegante para problemas recursivos.
- Fácil de implementar para problemas como árboles, listas y dividir y conquistar.

**Desventajas:**
- Puede consumir mucha memoria por la pila.
- Menor eficiencia en algunos casos.
- Riesgo de StackOverflow si no se programa el caso base correctamente.

---

## Buenas prácticas

- Siempre definir un caso base claro.
- Asegurarse de acercarse al caso base en cada llamada.
- Considerar alternativas iterativas si la profundidad es muy grande.

---

## Conclusión

La recursividad es una herramienta poderosa en programación, especialmente útil para dividir problemas en subproblemas del mismo tipo. Si se utiliza correctamente, puede simplificar mucho el código y la lógica de tus programas.
