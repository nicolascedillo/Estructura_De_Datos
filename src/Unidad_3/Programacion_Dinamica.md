# Programación Dinámica

La **programación dinámica** (PD) es una técnica de optimización usada para resolver problemas complejos dividiéndolos en subproblemas más simples y almacenando los resultados de estos subproblemas para evitar cálculos repetidos. Es especialmente útil cuando un problema tiene **subproblemas solapados** y **una estructura óptima**.

---

## ¿Qué es la programación dinámica?

La PD utiliza una tabla (arreglo) para **memorizar** soluciones a subproblemas ya resueltos. Así, cuando se necesita el resultado de un subproblema, se toma directamente de la tabla, mejorando la eficiencia.

### Características:
- **Subproblemas solapados**: El mismo subproblema aparece varias veces.
- **Optimalidad de subestructura**: La solución óptima se construye a partir de soluciones óptimas de los subproblemas.

---

## Tipos de programación dinámica

1. **Top-Down (Memoización):**
   - Resuelve el problema de forma recursiva y guarda los resultados de subproblemas en una estructura (array, mapa, etc.).
   - Si el subproblema ya fue calculado, usa el resultado almacenado.

2. **Bottom-Up (Tabulación):**
   - Resuelve los subproblemas más pequeños primero y los combina para resolver subproblemas más grandes.
   - Utiliza ciclos en vez de recursión.

---

## Ejemplo 1: Fibonacci con programación dinámica

### Fibonacci clásico (recursivo)

```java
public static int fibonacciRecursivo(int n) {
    if (n <= 1) return n;
    return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
}
// Complejidad: O(2^n)
```

### Fibonacci con Memoización (Top-Down)

```java
public static int fibonacciPD(int n, int[] memo) {
    if (n <= 1) return n;
    if (memo[n] != 0) return memo[n];
    memo[n] = fibonacciPD(n - 1, memo) + fibonacciPD(n - 2, memo);
    return memo[n];
}
// Uso: int[] memo = new int[n + 1]; fibonacciPD(n, memo);
// Complejidad: O(n)
```

### Fibonacci con Tabulación (Bottom-Up)

```java
public static int fibonacciTabulacion(int n) {
    if (n <= 1) return n;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}
// Complejidad: O(n)
```

---

## Complejidad de programación dinámica

- **Temporal:** Depende del problema, pero suele ser **O(n)** o **O(n^2)**.
- **Espacial:** Puede requerir memoria adicional para la tabla de resultados (**O(n)**, **O(n^2)**).

---

## Ventajas y desventajas

**Ventajas:**
- Resuelve problemas complejos de manera eficiente.
- Evita cálculos repetidos.

**Desventajas:**
- Puede consumir mucha memoria si la tabla es grande.
- No todos los problemas pueden ser resueltos con PD.

---

## ¿Cuándo usar programación dinámica?

- Cuando el problema tiene **subproblemas solapados**.
- Cuando la solución óptima se puede construir a partir de subsoluciones óptimas (optimalidad de subestructura).

---

## Conclusión

La programación dinámica es una técnica esencial para todo programador que quiera resolver problemas de optimización y eficiencia. Su dominio permite enfrentar desafíos que serían imposibles con métodos clásicos recursivos o iterativos.
