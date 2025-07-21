# Estructuras No Lineales: Árboles y Grafos

Las **estructuras no lineales** permiten organizar los datos de forma más flexible que las lineales, facilitando la representación de relaciones complejas. Las principales son los **árboles** y los **grafos**.

---

## 1. Árboles

### ¿Qué es un árbol?

Un **árbol** es una estructura jerárquica compuesta por nodos conectados por aristas, donde:

- Hay un nodo raíz (root) y cada nodo puede tener cero o más hijos.
- No existen ciclos (no se puede volver al mismo nodo por diferentes caminos).
- Cada nodo (excepto la raíz) tiene un único padre.

### Características de los árboles

- **Nodos:** Elementos del árbol.
- **Raíz:** Primer nodo.
- **Padre/Hijo:** Relación jerárquica entre nodos.
- **Hojas:** Nodos sin hijos.
- **Nivel:** Distancia de un nodo hasta la raíz.
- **Altura:** Mayor nivel de cualquier nodo.
- **Subárbol:** Cualquier nodo con todos sus descendientes.

#### Tipos de árboles más comunes

- **Árbol binario:** Cada nodo tiene como máximo 2 hijos.
- **Árbol binario de búsqueda (BST):** Ordenados para facilitar búsquedas.
- **Árbol AVL:** Árbol binario de búsqueda auto-balanceado.
- **Árbol B:** Usado en bases de datos (más de dos hijos).
- **Árbol Trie:** Para búsquedas de cadenas/prefijos.

---

### Árboles AVL

Un **árbol AVL** es un árbol binario de búsqueda **auto-balanceado**, donde para cada nodo la diferencia de altura entre sus dos subárboles (factor de balanceo) nunca supera 1.

#### Características

- **Balanceo automático:** Mantiene el árbol equilibrado tras inserciones/eliminaciones.
- **Factor de balanceo:** |altura hijo izquierdo - altura hijo derecho| ≤ 1 en todos los nodos.
- **Eficiencia:** Operaciones de búsqueda, inserción y eliminación en O(log n).

#### Rotaciones en árboles AVL

Para mantener el balance, se usan **rotaciones**:

- **Rotación simple a la derecha (Right Rotation):**
  - Se aplica cuando el subárbol izquierdo está más alto.
- **Rotación simple a la izquierda (Left Rotation):**
  - Se aplica cuando el subárbol derecho está más alto.
- **Rotación doble a la izquierda-derecha (Left-Right):**
  - Se aplica cuando el hijo izquierdo del subárbol derecho está desbalanceado.
- **Rotación doble a la derecha-izquierda (Right-Left):**
  - Se aplica cuando el hijo derecho del subárbol izquierdo está desbalanceado.

#### ¿Cómo se hacen las rotaciones?

- Se reacomodan los nodos para que el árbol quede equilibrado.
- Ejemplo:  
  - Si se inserta un nodo y el factor de balanceo supera 1, se identifica el caso (izquierda/izquierda, izquierda/derecha, etc.) y se aplica la rotación adecuada.
- Después de cada inserción o eliminación, se actualizan las alturas y se aplican rotaciones si es necesario.

#### Métodos principales de AVL

| Operación    | Tiempo | Espacio |
|--------------|--------|---------|
| Búsqueda     | O(log n) | O(n) |
| Inserción    | O(log n) | O(n) |
| Eliminación  | O(log n) | O(n) |

---

### Tipos de recorrido de árboles

- **Preorden (Root - Left - Right):**  
  Visita primero la raíz, luego el subárbol izquierdo, después el derecho.
- **Inorden (Left - Root - Right):**  
  Visita primero el subárbol izquierdo, luego la raíz, después el derecho.  
  (En BST, devuelve los elementos ordenados)
- **Postorden (Left - Right - Root):**  
  Visita primero ambos subárboles y luego la raíz.
- **Por niveles (Breadth-First / Level Order):**  
  Visita los nodos nivel por nivel (usando una cola).

#### Ejemplo de recorridos en Java (árbol binario):

```java
void inOrder(Node node) {
    if (node == null) return;
    inOrder(node.left);
    System.out.print(node.value + " ");
    inOrder(node.right);
}
```

---

### Aplicaciones de los árboles

- Representación jerárquica (directorios, genealogía).
- Búsqueda y ordenación rápida (BST, AVL).
- Autocompletado de texto (Trie).
- Bases de datos y sistemas de archivos (árbol B, B+).

---

## 2. Grafos

### ¿Qué es un grafo?

Un **grafo** es una estructura formada por **nodos (vértices)** y **aristas (edges)**, donde las conexiones pueden ser arbitrarias (no jerárquicas).

#### Tipos de grafos

- **Dirigido:** Las aristas tienen dirección (A → B).
- **No dirigido:** Las aristas no tienen dirección (A — B).
- **Ponderado:** Las aristas tienen un valor (peso).
- **No ponderado:** Todas las aristas valen lo mismo.
- **Cíclico/acíclico:** Permite/no permite ciclos.

#### Representaciones

- **Matriz de adyacencia:** Matríz NxN donde cada celda indica si hay conexión entre dos nodos.
- **Lista de adyacencia:** Cada nodo guarda una lista con sus vecinos.

---

### Métodos principales y complejidades

| Operación           | Tiempo (Lista de adyacencia) |
|---------------------|------------------------------|
| Verificar conexión  | O(n)                         |
| Recorrer grafo      | O(n + m) (n=vértices, m=aristas) |
| Añadir nodo/arista  | O(1)                         |

---

### Recorridos en grafos

#### BFS (Breadth-First Search) – Recorrido en anchura

- Usa una cola.
- Recorre primero todos los vecinos de un nodo antes de pasar a los vecinos de sus vecinos.
- Útil para encontrar la ruta más corta en grafos no ponderados.

#### DFS (Depth-First Search) – Recorrido en profundidad

- Usa una pila (recursión o estructura).
- Recorre tan profundo como sea posible antes de retroceder.
- Útil para detectar ciclos, componentes conexos.

#### Ejemplo en Java (DFS básico):

```java
void dfs(int v, boolean[] visitado, List<List<Integer>> grafo) {
    visitado[v] = true;
    for (int u : grafo.get(v)) {
        if (!visitado[u]) dfs(u, visitado, grafo);
    }
}
```

---

### Aplicaciones de grafos

- Redes de computadoras y sociales.
- Mapas y rutas (GPS).
- Problemas de flujo, planificación y dependencias.
- Resolución de puzzles y juegos.

---

## 3. Resumen Visual y Comparativo

| Estructura | Funcionamiento | Recorridos principales | Aplicaciones           | Complejidad básica (recorrido) |
|------------|----------------|-----------------------|------------------------|-------------------------------|
| Árbol      | Jerárquico, sin ciclos | Preorden, Inorden, Postorden, Por niveles | Búsqueda, jerarquía, autocompletar | O(n)                         |
| Grafo      | Relacional, ciclos permitidos/dirigidos | BFS, DFS              | Redes, mapas, dependencias     | O(n + m)                     |

---

## 4. Consejos clave para el examen

- **Árboles:** Distingue tipos, recorridos y balanceo (especialmente AVL y sus rotaciones).
- **Grafos:** Conoce tipos, formas de representación y recorridos (BFS/DFS).
- **AVL:** Recuerda cuándo y cómo aplicar rotaciones para balancear.
- **Recorridos:** Identifica cuál es adecuado según el problema (por ejemplo, BFS para la ruta más corta).

---

## 5. Conclusión

Dominar las estructuras no lineales te permite resolver problemas complejos de relaciones, búsquedas y optimización. Son herramientas esenciales en la informática y algoritmos avanzados.