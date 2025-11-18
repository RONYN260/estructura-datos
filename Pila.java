public class Pila {
    
    // El nodo es como una caja que guarda un número y apunta al siguiente
    class Nodo {
        int dato;           // El número que guardamos
        Nodo siguiente;     // Apunta al nodo de abajo
        
        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    
    private Nodo tope;  // Apunta al nodo de arriba
    
    // Constructor - crea una pila vacía
    public Pila() {
        tope = null;
    }   
    
    // PUSH - Poner un elemento arriba
    public void push(int dato) {
        Nodo nuevo = new Nodo(dato);  // Creamos un nuevo nodo
        nuevo.siguiente = tope;        // El nuevo apunta al que estaba arriba
        tope = nuevo;                  // Ahora el nuevo es el tope
        System.out.println("Pusiste: " + dato);
    }
    
    // POP - Sacar el elemento de arriba
    public int pop() {
        if (tope == null) {
            System.out.println("¡Pila vacía!");
            return -1;
        }
        int dato = tope.dato;      // Guardamos el dato del tope
        tope = tope.siguiente;     // El tope ahora es el siguiente
        System.out.println("Sacaste: " + dato);
        return dato;
    }
    
    // PEEK - Ver qué hay arriba (sin sacar)
    public int peek() {
        if (tope == null) {
            System.out.println("¡Pila vacía!");
            return -1;
        }
        return tope.dato;
    }
    
    // Verificar si está vacía
    public boolean estaVacia() {
        return tope == null;
    }
    
    // Mostrar toda la pila
    public void mostrar() {
        if (tope == null) {
            System.out.println("Pila vacía");
            return;
        }
        
        System.out.print("Pila (de arriba a abajo): ");
        Nodo actual = tope;
        while (actual != null) {
            System.out.print("[" + actual.dato + "]");
            if (actual.siguiente != null) {
                System.out.print(" -> ");
            }
            actual = actual.siguiente;
        }
        System.out.println();
    }
    
    // MAIN - Ejemplo de uso
    public static void main(String[] args) {
        Pila pila = new Pila();
        
        System.out.println("=== AGREGANDO ELEMENTOS ===");
        pila.push(10);
        pila.push(20);
        pila.push(30);
        pila.mostrar();
        
        System.out.println("\n=== VIENDO EL TOPE ===");
        System.out.println("El tope es: " + pila.peek());
        
        System.out.println("\n=== SACANDO ELEMENTOS ===");
        pila.pop();
        pila.mostrar();
        
        pila.pop();
        pila.mostrar();
        
        System.out.println("\n=== VERIFICANDO SI ESTÁ VACÍA ===");
        System.out.println("¿Está vacía? " + pila.estaVacia());
        
        pila.pop();
        System.out.println("¿Está vacía? " + pila.estaVacia());
    }
}//   dame esto en python