
import java.util.Scanner;

public class balance {
    
    // Clase Nodo para nuestra pila
    static class Nodo {
        char dato;           // El carácter que guardamos
        Nodo siguiente;      // Referencia al siguiente nodo
        
        // Constructor
        public Nodo(char dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    
    // Clase Pila implementada con nodos
    static class Pila {
        private Nodo tope;   // El nodo superior de la pila
        
        // Constructor
        public Pila() {
            this.tope = null;
        }
        
        // PUSH: Agregar un elemento al tope de la pila
        public void push(char dato) {
            Nodo nuevoNodo = new Nodo(dato);
            nuevoNodo.siguiente = tope;  // El nuevo nodo apunta al anterior tope
            tope = nuevoNodo;            // El nuevo nodo se convierte en el tope
            System.out.println("   ✓ PUSH: '" + dato + "' agregado a la pila");
        }
        
        // POP: Sacar el elemento del tope de la pila
        public char pop() {
            if (estaVacia()) {
                return '\0';  // Retorna carácter nulo si está vacía
            }
            char dato = tope.dato;
            tope = tope.siguiente;  // El tope ahora es el siguiente nodo
            System.out.println("   ✓ POP: '" + dato + "' sacado de la pila");
            return dato;
        }
        
        // Verificar si la pila está vacía
        public boolean estaVacia() {
            return tope == null;
        }
        
        // Mostrar el contenido de la pila (para visualización)
        public void mostrar() {
            if (estaVacia()) {
                System.out.println("   Pila: [vacía]");
                return;
            }
            
            System.out.print("   Pila (tope→base): [");
            Nodo actual = tope;
            while (actual != null) {
                System.out.print(actual.dato);
                if (actual.siguiente != null) {
                    System.out.print(", ");
                }
                actual = actual.siguiente;
            }
            System.out.println("]");
        }
    }
    
    // Verifica si un carácter es un signo de apertura
    public static boolean esApertura(char c) {
        return c == '(' || c == '[' || c == '{';
    }
    
    // Verifica si un carácter es un signo de cierre
    public static boolean esCierre(char c) {
        return c == ')' || c == ']' || c == '}';
    }
    
    // Verifica si los signos hacen pareja
    public static boolean hacenPareja(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
               (apertura == '[' && cierre == ']') ||
               (apertura == '{' && cierre == '}');
    }
    
    // Función principal que verifica el balance
    public static boolean verificarBalance(String expresion) {
        Pila pila = new Pila();
        
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║  VERIFICANDO: " + expresion);
        System.out.println("╚══════════════════════════════════════════╝\n");
        
        // Recorrer cada carácter de la expresión
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            
            System.out.println("Paso " + (i+1) + ": Leyendo '" + c + "'");
            
            // Si es un signo de apertura: PUSH a la pila
            if (esApertura(c)) {
                System.out.println("   → Es un signo de APERTURA");
                pila.push(c);
                pila.mostrar();
            }
            // Si es un signo de cierre
            else if (esCierre(c)) {
                System.out.println("   → Es un signo de CIERRE");
                
                // ¿La pila está vacía? ¡ERROR!
                if (pila.estaVacia()) {
                    System.out.println("   ✗ ERROR: No hay apertura para este cierre");
                    System.out.println("   La pila está vacía!");
                    return false;
                }
                
                // Sacar el tope de la pila
                char apertura = pila.pop();
                
                // ¿Hacen pareja?
                if (!hacenPareja(apertura, c)) {
                    System.out.println("   ✗ ERROR: '" + apertura + "' NO hace pareja con '" + c + "'");
                    return false;
                }
                
                System.out.println("   ✓ '" + apertura + "' y '" + c + "' hacen pareja correcta!");
                pila.mostrar();
            }
            // Si no es ni apertura ni cierre (letras, números, etc.)
            else {
                System.out.println("   → No es un signo (se ignora)");
            }
            
            System.out.println();
        }
        
        // Al final, ¿quedó algo en la pila?
        System.out.println("═══════════════════════════════════════════");
        System.out.println("Fin del recorrido. Verificando pila final...");
        pila.mostrar();
        
        if (!pila.estaVacia()) {
            System.out.println("✗ ERROR: Quedan aperturas sin cerrar");
            return false;
        }
        
        System.out.println("✓ ¡ÉXITO! La expresión está BALANCEADA");
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
                                           
        System.out.println("║   VERIFICADOR DE BALANCE DE SIGNOS         ║");
        System.out.println("║   (Implementación con Nodos y Pila)        ║");
       
        // Ejemplos de prueba
        String[] ejemplos = {
            "{[()]}",       // ✓ Balanceado
            "((a+b))",      // ✓ Balanceado
            "{[(])}",       // ✗ No balanceado (cruzados)
            "((a+b",        // ✗ No balanceado (sin cerrar)
            "))",           // ✗ No balanceado (solo cierres)
        };
        
        System.out.println("\n>>> EJEMPLOS AUTOMÁTICOS <<<\n");
        
        for (String ejemplo : ejemplos) {
            boolean resultado = verificarBalance(ejemplo);
            System.out.println("\n★ RESULTADO: " + (resultado ? "✓ BALANCEADO" : "✗ NO BALANCEADO"));
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        }
        
        // Modo interactivo
        System.out.println("\n>>> MODO INTERACTIVO <<<");
        System.out.println("Escribe tu propia expresión para verificar");
        System.out.println("(o escribe 'salir' para terminar)\n");
        
        boolean continuar = true;
        while (continuar) {
            System.out.print("Expresión: ");
            String expresion = scanner.nextLine().trim();
            
            if (expresion.equalsIgnoreCase("salir")) {
                System.out.println("\n¡Hasta luego! 👋");
                continuar = false;
            } else if (!expresion.isEmpty()) {
                verificarBalance(expresion);
            }
        }
        
        scanner.close();
    }
}