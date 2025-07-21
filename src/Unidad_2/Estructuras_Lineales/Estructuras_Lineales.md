# Estructuras Lineales: LinkedList, Colas y Pilas

Las **estructuras lineales** organizan los datos de forma secuencial. Son esenciales en la informática y tienen aplicaciones muy variadas. Las más comunes son **LinkedList (listas enlazadas)**, **Colas (Queues)** y **Pilas (Stacks)**.

---

## 1. LinkedList (Lista Enlazada)

### ¿Qué es?
Una LinkedList almacena elementos en **nodos**, donde cada nodo apunta al siguiente. No se requiere que los elementos estén en ubicaciones contiguas de memoria.

### Funcionamiento

- Cada nodo tiene dos partes: el dato y la referencia al siguiente nodo.
- Permite insertar y eliminar elementos en cualquier posición sin reordenar el resto.

#### Tipos de listas enlazadas

- **Simple:** Cada nodo apunta solo al siguiente.
- **Doble:** Cada nodo apunta al siguiente y al anterior.
- **Circular:** El último nodo apunta al primero.

### Métodos principales y sus complejidades

| Operación                   | Tiempo (LinkedList) | Espacio |
|-----------------------------|---------------------|---------|
| Acceso por índice           | O(n)                | O(n)    |
| Inserción/eliminación inicio| O(1)                | O(n)    |
| Inserción/eliminación final | O(1) (si se tiene referencia al último nodo) | O(n) |
| Inserción/eliminación medio | O(n)                | O(n)    |
| Búsqueda                    | O(n)                | O(n)    |

### Ejemplo de uso en Java

```java
LinkedList<Integer> lista = new LinkedList<>();
lista.add(1); // Añadir al final
lista.addFirst(0); // Añadir al inicio
lista.removeLast(); // Eliminar el último
lista.get(0); // Acceso al primer elemento (O(1))
```

### Casos de uso

- Cuando necesitas muchas inserciones/eliminaciones en cualquier posición.
- Cuando no requieres acceso rápido por índice.

---

### Comparación: LinkedList vs. ArrayList

| Aspecto                   | LinkedList           | ArrayList           |
|---------------------------|----------------------|---------------------|
| Memoria                   | Más (nodos y referencias) | Menos (solo datos) aunque reserva anticipadamente espacio que no se ocupa|
| Acceso por índice         | Lento (O(n))         | Rápido (O(1))       |
| Inserción/eliminación     | Rápido al inicio/fin | Lento (O(n) por desplazamiento) |
| Redimensionamiento        | No requiere          | Requiere (copia de datos) |
| Iteración                 | Lenta                | Rápida              |
| Uso                       | Listas dinámicas con muchas operaciones de inserción/eliminación | Listas estáticas o con acceso rápido por índice |

#### Ejemplo cotidiano:
- **LinkedList:** Lista de canciones donde puedes insertar/eliminar fácilmente en cualquier posición.
- **ArrayList:** Lista de alumnos donde el acceso rápido por posición es más importante.

---

## 2. Colas (Queues)

### ¿Qué es?
Estructura donde los elementos se procesan en el orden en que llegan (**FIFO: First-In, First-Out**).

### Funcionamiento

- Se insertan elementos al final (enqueue).
- Se eliminan elementos al inicio (dequeue).

### Métodos principales y sus complejidades

| Operación        | Tiempo | Espacio |
|------------------|--------|---------|
| Enqueue (añadir) | O(1)   | O(n)    |
| Dequeue (eliminar)| O(1)  | O(n)    |
| Peek (ver primero)| O(1)  | O(n)    |

### Ejemplo en Java

```java
Queue<Integer> cola = new LinkedList<>();
cola.add(1);    // enqueue
cola.poll();    // dequeue
cola.peek();    // ver primero
```

### Casos de uso

- Gestión de procesos en sistemas operativos.
- Simulación de filas o turnos en bancos y supermercados.
- Estructuras de control en algoritmos de recorrido (BFS en grafos).

#### Ejemplo cotidiano:
- Fila de personas esperando para comprar boletos.

---

## 3. Pilas (Stacks)

### ¿Qué es?
Estructura donde el último elemento añadido es el primero en salir (**LIFO: Last-In, First-Out**).

### Funcionamiento

- Se insertan elementos al tope (push).
- Se eliminan elementos del tope (pop).

### Métodos principales y sus complejidades

| Operación        | Tiempo | Espacio |
|------------------|--------|---------|
| Push (añadir)    | O(1)   | O(n)    |
| Pop (eliminar)   | O(1)   | O(n)    |
| Peek (ver tope)  | O(1)   | O(n)    |

### Ejemplo en Java

```java
Stack<Integer> pila = new Stack<>();
pila.push(1);   // añadir
pila.pop();     // eliminar
pila.peek();    // ver tope
```

### Casos de uso

- Evaluación de expresiones matemáticas.
- Control de llamadas a funciones (call stack).
- Deshacer/rehacer operaciones en editores.

#### Ejemplo cotidiano:
- Pila de platos: el último en apilarse es el primero en tomarse.

---

## 4. Resumen Visual y Comparativo

| Estructura   | Inserción | Eliminación | Acceso | Orden de procesamiento | Uso típico                       |
|--------------|-----------|-------------|--------|-----------------------|----------------------------------|
| LinkedList   | O(1) (inicio/fin) | O(1) (inicio/fin) | O(n)   | Secuencial           | Listas con muchas modificaciones |
| ArrayList    | O(1) (final), O(n) (inicio/medio) | O(n) | O(1)   | Secuencial           | Listas con acceso rápido         |
| Cola         | O(1)      | O(1)        | O(1)   | FIFO                  | Filas, procesamiento por turnos  |
| Pila         | O(1)      | O(1)        | O(1)   | LIFO                  | Deshacer, procesamiento reverso  |

---

## 5. Consejos para el examen

- **LinkedList:** Útil para muchas inserciones/eliminaciones en cualquier parte; acceso lento por índice.
- **ArrayList:** Útil para acceso rápido por índice y pocas modificaciones.
- **Cola:** Útil para procesar elementos en orden de llegada.
- **Pila:** Útil para procesamiento reverso y control de flujo (funciones, deshacer/rehacer).

---

## 6. Ejemplos de código y aplicaciones

### LinkedList: Insertar y eliminar al inicio

```java
LinkedList<String> lista = new LinkedList<>();
lista.addFirst("A");
lista.addFirst("B"); // ["B", "A"]
lista.removeFirst(); // ["A"]
```

### Cola: Simulación de turnos

```java
Queue<String> cola = new LinkedList<>();
cola.add("Ana");
cola.add("Luis");
System.out.println(cola.poll()); // Ana sale primero
```

### Pila: Deshacer acciones

```java
Stack<String> pila = new Stack<>();
pila.push("Accion1");
pila.push("Accion2");
System.out.println(pila.pop()); // Accion2 se deshace primero
```

---

## 7. Conclusión

Las estructuras lineales son fundamentales en la programación. Elige la adecuada según tus necesidades de acceso, inserción, eliminación y procesamiento de datos. Comprender sus métodos y complejidades te permitirá diseñar algoritmos más eficientes y adecuados para cada situación.