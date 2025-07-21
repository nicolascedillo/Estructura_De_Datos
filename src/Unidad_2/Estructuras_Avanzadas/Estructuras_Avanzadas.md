# Sets y Maps en Java

Las **colecciones Sets y Maps** son fundamentales para manejar datos únicos y relaciones clave-valor en Java. Se implementan de diferentes formas (hash, árbol y enlazadas), cada una con sus características y complejidades.

---

## 1. Sets (Conjuntos)

Un **Set** almacena elementos **únicos** (sin duplicados). No garantiza orden salvo que se especifique.

### Tipos de Set en Java

#### a) HashSet

- **Implementación:** Usa una tabla hash.
- **Orden:** No garantiza orden.
- **Complejidad:**
  - **add, remove, contains:** O(1) promedio, O(n) peor caso.
- **Uso típico:** Cuando solo importa unicidad, no el orden.

```java
Set<String> hashSet = new HashSet<>();
hashSet.add("A");
hashSet.add("B");
hashSet.contains("A"); // true
```

#### b) LinkedHashSet

- **Implementación:** Hash + lista doblemente enlazada.
- **Orden:** Mantiene el orden de inserción.
- **Complejidad:**
  - **add, remove, contains:** O(1) promedio.
  - **Iteración:** O(n).
- **Uso típico:** Unicidad y orden de inserción.

```java
Set<String> linkedSet = new LinkedHashSet<>();
linkedSet.add("A");
linkedSet.add("B");
for (String s : linkedSet) { /* Orden: A, B */ }
```

#### c) TreeSet

- **Implementación:** Árbol rojo-negro (balanced tree).
- **Orden:** Orden natural o por Comparator.
- **Complejidad:**
  - **add, remove, contains:** O(log n).
  - **Iteración ordenada:** O(n).
- **Uso típico:** Unicidad y ordenación automática.

```java
Set<Integer> treeSet = new TreeSet<>();
treeSet.add(5);
treeSet.add(1);
treeSet.add(10);
// Itera en orden: 1, 5, 10
```

---

## 2. Maps (Diccionarios)

Un **Map** almacena pares **clave-valor**. Las claves son únicas; los valores pueden repetirse.

### Tipos de Map en Java

#### a) HashMap

- **Implementación:** Tabla hash.
- **Orden:** No garantiza orden.
- **Complejidad:**
  - **put, get, remove:** O(1) promedio, O(n) peor caso.
- **Uso típico:** Acceso rápido y sin orden.

```java
Map<String, Integer> hashMap = new HashMap<>();
hashMap.put("A", 1);
hashMap.get("A"); // 1
```

#### b) LinkedHashMap

- **Implementación:** Hash + lista enlazada.
- **Orden:** Mantiene orden de inserción.
- **Complejidad:**
  - **put, get, remove:** O(1) promedio.
  - **Iteración:** O(n).
- **Uso típico:** Relación clave-valor con orden de inserción.

```java
Map<String, Integer> linkedMap = new LinkedHashMap<>();
linkedMap.put("A", 1);
linkedMap.put("B", 2);
// Itera: A, B
```

#### c) TreeMap

- **Implementación:** Árbol rojo-negro.
- **Orden:** Orden natural o por Comparator.
- **Complejidad:**
  - **put, get, remove:** O(log n).
  - **Iteración ordenada:** O(n).
- **Uso típico:** Clave-valor con orden automático.

```java
Map<Integer, String> treeMap = new TreeMap<>();
treeMap.put(3, "A");
treeMap.put(1, "B");
// Itera por clave: 1, 3
```

---

## 3. Uso de Comparator y Comparable

### Comparable

- **Interfaz:** Implementa `compareTo()` en la clase.
- **Uso:** Define orden natural. Necesario para TreeSet/TreeMap si no se usa Comparator.
- **Ejemplo:**

```java
class Persona implements Comparable<Persona> {
    String nombre;
    public int compareTo(Persona otra) {
        return this.nombre.compareTo(otra.nombre);
    }
}
```

### Comparator

- **Interfaz:** Implementa `compare(a, b)` externamente.
- **Uso:** Define orden personalizado. Se pasa al constructor de TreeSet/TreeMap.
- **Ejemplo:**

```java
Comparator<Persona> porEdad = (a, b) -> Integer.compare(a.edad, b.edad);
Set<Persona> treeSet = new TreeSet<>(porEdad);
```

---

## 4. Comparativo de complejidades

| Tipo           | add/put | remove | contains/get | Iteración | Orden                 |
|----------------|---------|--------|--------------|-----------|-----------------------|
| HashSet        | O(1)    | O(1)   | O(1)         | O(n)      | No                    |
| LinkedHashSet  | O(1)    | O(1)   | O(1)         | O(n)      | Inserción             |
| TreeSet        | O(log n)| O(log n)| O(log n)     | O(n)      | Natural/Comparator    |
| HashMap        | O(1)    | O(1)   | O(1)         | O(n)      | No                    |
| LinkedHashMap  | O(1)    | O(1)   | O(1)         | O(n)      | Inserción             |
| TreeMap        | O(log n)| O(log n)| O(log n)     | O(n)      | Natural/Comparator    |

---

## 5. Usos y aplicaciones típicas

- **HashSet/HashMap:** Filtrar duplicados, conteo rápido, cachés.
- **LinkedHashSet/LinkedHashMap:** Mantener historial de inserción, como en navegadores.
- **TreeSet/TreeMap:** Listas ordenadas, rankings, estructuras que necesitan acceso ordenado.

---

## 6. Ejemplo práctico

### HashSet para filtrar duplicados

```java
List<String> lista = Arrays.asList("A", "B", "A", "C");
Set<String> sinDuplicados = new HashSet<>(lista); // ["A", "B", "C"]
```

### TreeMap con Comparator

```java
TreeMap<Persona, Integer> mapa = new TreeMap<>(porEdad); // Ordena por edad
```

---

## 7. Nota sobre espacio y colisiones

- **HashSet/HashMap:** Espacio extra por tablas hash y posibles colisiones.
- **TreeSet/TreeMap:** Espacio extra por nodos del árbol.
- **LinkedHashSet/LinkedHashMap:** Espacio extra por enlaces dobles.

---

## 8. Consejos para el examen

- Elige **Hash** para rapidez y sin interés en el orden.
- Elige **Tree** para orden automático y búsquedas por rango.
- Elige **Linked** para mantener el orden de inserción.
- Implementa **Comparable** para orden natural y **Comparator** para orden personalizado.
- Recuerda que los elementos de TreeSet/TreeMap deben ser comparables (tener orden definido).

---

## 9. Conclusión

Sets y Maps son herramientas versátiles para gestión de datos únicos y relaciones clave-valor. Entender sus variantes, complejidades y aplicaciones te permitirá elegir la estructura adecuada para cada problema en tus programas.