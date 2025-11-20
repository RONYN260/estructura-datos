//import java.util.ArrayList;
//import java.util.List;
public class resoluciones {
    public static void main(String[] args) {

    }
    
}
class ArbolHijoHermano {
    private NodoGenerico raiz;
    
    public ArbolHijoHermano(String datoRaiz) {
        this.raiz = new NodoGenerico(datoRaiz);
    }  
    
    // Agregar hijo a un nodo
    public void agregarHijo(NodoGenerico padre, String datoHijo) {
        NodoGenerico nuevoHijo = new NodoGenerico(datoHijo);
        
        // Si no tiene hijos, este será el primero
        if (padre.getHijo() == null) {
            padre.setHijo(nuevoHijo);
        } 
        // Si ya tiene hijos, agregarlo como hermano del último
        else {
            NodoGenerico actual = padre.getHijo();
            // Ir hasta el último hermano
            while (actual.getHermano() != null) {
                actual = actual.getHermano();
            }
            actual.setHermano(nuevoHijo);
        }
    }
    
    // Recorrido preorden
    public void recorridoPreorden() {
        System.out.print("Recorrido Preorden: ");
        recorridoPreordenRecursivo(raiz);
        System.out.println();
    }
    
    private void recorridoPreordenRecursivo(NodoGenerico nodo) {
        if (nodo == null) return;
        
        // Visitar el nodo actual
        System.out.print(nodo.getDato() + " ");
        
        // Visitar los hijos (bajando)
        recorridoPreordenRecursivo(nodo.getHijo());
        
        // Visitar los hermanos (horizontal)
        recorridoPreordenRecursivo(nodo.getHermano());
    }
    
    // Buscar un dato
    public boolean buscar(String dato) {
        return buscarRecursivo(raiz, dato);
    }
    
    private boolean buscarRecursivo(NodoGenerico nodo, String dato) {
        if (nodo == null) return false;
        
        if (nodo.getDato().equals(dato)) return true;
        
        // Buscar en hijos y hermanos
        return buscarRecursivo(nodo.getHijo(), dato) || 
               buscarRecursivo(nodo.getHermano(), dato);
    }
    
    // Mostrar estructura del árbol
    public void mostrarArbol() {
        System.out.println("\n=== ESTRUCTURA DEL ÁRBOL ===");
        mostrarArbolRecursivo(raiz, "", true);
    }
    
    private void mostrarArbolRecursivo(NodoGenerico nodo, String prefijo, boolean esUltimo) {
        if (nodo == null) return;
        
        System.out.println(prefijo + (esUltimo ? "└── " : "├── ") + nodo.getDato());
        
        // Mostrar hijos
        NodoGenerico hijo = nodo.getHijo();
        while (hijo != null) {
            boolean ultimo = (hijo.getHermano() == null);
            mostrarArbolRecursivo(
                hijo,
                prefijo + (esUltimo ? "    " : "│   "),
                ultimo
            );
            hijo = hijo.getHermano();
        }
    }
    
    public NodoGenerico getRaiz() {
        return raiz;
    }
}
// Nodo con representación Hijo-Hermano
class NodoGenerico {
    private String dato;
    private NodoGenerico hijo;       // Apunta al primer hijo
    private NodoGenerico hermano;    // Apunta al siguiente hermano
    
    // Constructor
    public NodoGenerico(String dato) {
        this.dato = dato;
        this.hijo = null;
        this.hermano = null;
    }
    
    // Getters y Setters
    public String getDato() {
        return dato;
    }
    
    public void setDato(String dato) {
        this.dato = dato;
    }
    
    public NodoGenerico getHijo() {
        return hijo;
    }
    
    public void setHijo(NodoGenerico hijo) {
        this.hijo = hijo;
    }
    
    public NodoGenerico getHermano() {
        return hermano;
    }
    
    public void setHermano(NodoGenerico hermano) {
        this.hermano = hermano;
    }
}