// Clase que representa un nodo del árbol
class Nodo {
    int valor;
    Nodo izquierdo;
    Nodo derecho;
    
    // Constructor
    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}

// Clase que representa el árbol binario
class ArbolBinario {
    Nodo raiz;
    
    // Constructor
    public ArbolBinario() {
        this.raiz = null;
    }
    
    // Método para insertar un valor en el árbol
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }
    
    // Método recursivo para insertar
    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        // Si el nodo es null, crear un nuevo nodo
        if (nodo == null) {
            return new Nodo(valor);
        }
        
        // Si el valor es menor, ir a la izquierda
        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        }
        // Si el valor es mayor, ir a la derecha
        else if (valor > nodo.valor) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }
        
        return nodo;
    }
    
    // Recorrido INORDEN (Izquierda - Raíz - Derecha)
    public void inorden() {
        System.out.print("Inorden: ");
        inordenRecursivo(raiz);
        System.out.println();
    }
    
    private void inordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inordenRecursivo(nodo.derecho);
        }
    }
    
    // Recorrido PREORDEN (Raíz - Izquierda - Derecha)
    public void preorden() {
        System.out.print("Preorden: ");
        preordenRecursivo(raiz);
        System.out.println();
    }
    
    private void preordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preordenRecursivo(nodo.izquierdo);
            preordenRecursivo(nodo.derecho);
        }
    }
    
    // Recorrido POSTORDEN (Izquierda - Derecha - Raíz)
    public void postorden() {
        System.out.print("Postorden: ");
        postordenRecursivo(raiz);
        System.out.println();
    }
    
    private void postordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            postordenRecursivo(nodo.izquierdo);
            postordenRecursivo(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }
    
    // Buscar un valor en el árbol
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }
    
    private boolean buscarRecursivo(Nodo nodo, int valor) {
        // Caso base: nodo vacío
        if (nodo == null) {
            return false;
        }
        
        // Si encontramos el valor
        if (nodo.valor == valor) {
            return true;
        }
        
        // Buscar en el subárbol correspondiente
        if (valor < nodo.valor) {
            return buscarRecursivo(nodo.izquierdo, valor);
        } else {
            return buscarRecursivo(nodo.derecho, valor);
        }
    }
    
    // Calcular la altura del árbol
    public int altura() {
        return alturaRecursiva(raiz);
    }
    
    private int alturaRecursiva(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        
        int alturaIzq = alturaRecursiva(nodo.izquierdo);
        int alturaDer = alturaRecursiva(nodo.derecho);
        
        return Math.max(alturaIzq, alturaDer) + 1;
    }
}

// Clase principal para probar el árbol
public class arbolbinario {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        
        System.out.println("=== CREANDO ÁRBOL BINARIO DE BÚSQUEDA ===\n");
        
        // Insertar valores
        System.out.println("Insertando: 50, 30, 70, 20, 40, 60, 80");
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);
        
        System.out.println("\nEstructura del árbol:");
        System.out.println("        50");
        System.out.println("       /  \\");
        System.out.println("      30   70");
        System.out.println("     / \\   / \\");
        System.out.println("    20 40 60 80");
        
        // Recorridos
        System.out.println("\n=== RECORRIDOS DEL ÁRBOL ===\n");
        arbol.inorden();     // 20 30 40 50 60 70 80 (orden ascendente)
        arbol.preorden();    // 50 30 20 40 70 60 80
        arbol.postorden();   // 20 40 30 60 80 70 50
        
        // Búsquedas
        System.out.println("\n=== BÚSQUEDAS ===\n");
        System.out.println("¿Existe 40? " + arbol.buscar(40));  // true
        System.out.println("¿Existe 100? " + arbol.buscar(100)); // false
        
        // Altura
        System.out.println("\n=== INFORMACIÓN DEL ÁRBOL ===\n");
        System.out.println("Altura del árbol: " + arbol.altura()); // 3
    }
}