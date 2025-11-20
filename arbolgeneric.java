import java.util.ArrayList;
import java.util.List;

// Nodo del árbol genérico
class NodoGenerico {
    int valor;
    List<NodoGenerico> hijos;
    
    public NodoGenerico(int valor) {
        this.valor = valor;
        this.hijos = new ArrayList<>();
    }
    
    // Agregar un hijo al nodo
    public void agregarHijo(NodoGenerico hijo) {
        this.hijos.add(hijo);
    }
    
    // Obtener el número de hijos
    public int numeroDeHijos() {
        return this.hijos.size();
    }
}

// Clase del árbol genérico
class ArbolGenerico {
    NodoGenerico raiz;
    
    public ArbolGenerico(int valorRaiz) {
        this.raiz = new NodoGenerico(valorRaiz);
    }
    
    // Recorrido en preorden (raíz primero, luego hijos)
    public void recorridoPreorden() {
        System.out.print("Recorrido Preorden: ");
        recorridoPreordenRecursivo(raiz);
        System.out.println();
    }
    
    private void recorridoPreordenRecursivo(NodoGenerico nodo) {
        if (nodo == null) return;
        
        // Visitar el nodo actual
        System.out.print(nodo.valor + " ");
        
        // Visitar todos los hijos
        for (NodoGenerico hijo : nodo.hijos) {
            recorridoPreordenRecursivo(hijo);
        }
    }
    
    // Recorrido en postorden (hijos primero, luego raíz)
    public void recorridoPostorden() {
        System.out.print("Recorrido Postorden: ");
        recorridoPostordenRecursivo(raiz);
        System.out.println();
    }
    
    private void recorridoPostordenRecursivo(NodoGenerico nodo) {
        if (nodo == null) return;
        
        // Visitar todos los hijos primero
        for (NodoGenerico hijo : nodo.hijos) {
            recorridoPostordenRecursivo(hijo);
        }
        
        // Visitar el nodo actual al final
        System.out.print(nodo.valor + " ");
    }
    
    // Buscar un valor en el árbol
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }
    
    private boolean buscarRecursivo(NodoGenerico nodo, int valor) {
        if (nodo == null) return false;
        
        if (nodo.valor == valor) return true;
        
        // Buscar en todos los hijos
        for (NodoGenerico hijo : nodo.hijos) {
            if (buscarRecursivo(hijo, valor)) {
                return true;
            }
        }
        
        return false;
    }
    
    // Calcular la altura del árbol
    public int altura() {
        return alturaRecursiva(raiz);
    }
    
    private int alturaRecursiva(NodoGenerico nodo) {
        if (nodo == null) return 0;
        
        int alturaMaxima = 0;
        
        // Encontrar la altura máxima entre todos los hijos
        for (NodoGenerico hijo : nodo.hijos) {
            int alturaHijo = alturaRecursiva(hijo);
            alturaMaxima = Math.max(alturaMaxima, alturaHijo);
        }
        
        return alturaMaxima + 1;
    }
    
    // Contar el total de nodos
    public int contarNodos() {
        return contarNodosRecursivo(raiz);
    }
    
    private int contarNodosRecursivo(NodoGenerico nodo) {
        if (nodo == null) return 0;
        
        int contador = 1; // Contar el nodo actual
        
        // Sumar todos los nodos de los hijos
        for (NodoGenerico hijo : nodo.hijos) {
            contador += contarNodosRecursivo(hijo);
        }
        
        return contador;
    }
    
    // Mostrar el árbol con estructura visual
    public void mostrarArbol() {
        System.out.println("\n=== ESTRUCTURA DEL ÁRBOL ===");
        mostrarArbolRecursivo(raiz, "", true);
    }
    
    private void mostrarArbolRecursivo(NodoGenerico nodo, String prefijo, boolean esUltimo) {
        if (nodo == null) return;
        
        System.out.println(prefijo + (esUltimo ? "└── " : "├── ") + nodo.valor);
        
        for (int i = 0; i < nodo.hijos.size(); i++) {
            boolean ultimo = (i == nodo.hijos.size() - 1);
            mostrarArbolRecursivo(
                nodo.hijos.get(i),
                prefijo + (esUltimo ? "    " : "│   "),
                ultimo
            );
        }
    }
}

// Clase principal
public class arbolgeneric {
    public static void main(String[] args) {
        // Crear el árbol con raíz = 1
        ArbolGenerico arbol = new ArbolGenerico(1);
        
        // Crear nodos
        NodoGenerico nodo2 = new NodoGenerico(2);
        NodoGenerico nodo3 = new NodoGenerico(3);
        NodoGenerico nodo4 = new NodoGenerico(4);
        NodoGenerico nodo5 = new NodoGenerico(5);
        NodoGenerico nodo6 = new NodoGenerico(6);
        NodoGenerico nodo7 = new NodoGenerico(7);
        NodoGenerico nodo8 = new NodoGenerico(8);
        
        // Construir el árbol:
        //        1
        //     / | | \
        //    2  3 4  5
        //   /\     |
        //  6  7    8
        
        arbol.raiz.agregarHijo(nodo2);
        arbol.raiz.agregarHijo(nodo3);
        arbol.raiz.agregarHijo(nodo4);
        arbol.raiz.agregarHijo(nodo5);
        
        nodo2.agregarHijo(nodo6);
        nodo2.agregarHijo(nodo7);
        
        nodo4.agregarHijo(nodo8);
        
        // Mostrar la estructura
        arbol.mostrarArbol();
        
        // Recorridos
        System.out.println("\n=== RECORRIDOS ===");
        arbol.recorridoPreorden();   // 1 2 6 7 3 4 8 5
        arbol.recorridoPostorden();  // 6 7 2 3 8 4 5 1
        
        // Información del árbol
        System.out.println("\n=== INFORMACIÓN ===");
        System.out.println("Total de nodos: " + arbol.contarNodos());  // 8
        System.out.println("Altura del árbol: " + arbol.altura());      // 3
        System.out.println("La raíz tiene " + arbol.raiz.numeroDeHijos() + " hijos");  // 4
        
        // Búsquedas
        System.out.println("\n=== BÚSQUEDAS ===");
        System.out.println("¿Existe 7? " + arbol.buscar(7));   // true
        System.out.println("¿Existe 10? " + arbol.buscar(10)); // false
    }
}