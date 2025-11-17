
import java.util.Stack;
import java.util.Scanner;

public class balance {

    
    // Verifica si un carácter es un signo de apertura
    public static boolean esApertura(char c) {
        return c == '(' || c == '[' || c == '{';
    }
    
    // Verifica si un carácter es un signo de cierre
    public static boolean esCierre(char c) {
        return c == ')' || c == ']' || c == '}';
    }
    
    // Verifica si los signos coinciden
    public static boolean coinciden(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
               (apertura == '[' && cierre == ']') ||
               (apertura == '{' && cierre == '}');
    }
    
    // Función principal que verifica el balance
    public static boolean verificarBalance(String expresion) {
        Stack<Character> pila = new Stack<>();
        
        System.out.println("\n=== VERIFICANDO: " + expresion + " ===\n");
        System.out.println("Inicio - Pila vacía");
        
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            
            // Si es un signo de apertura
            if (esApertura(c)) {
                pila.push(c);
                System.out.println("Posición " + i + ": '" + c + "' → PUSH a la pila");
                System.out.println("   Pila: " + pila);
            }
            // Si es un signo de cierre
            else if (esCierre(c)) {
                System.out.print("Posición " + i + ": '" + c + "' → ");
                
                // Error: pila vacía
                if (pila.isEmpty()) {
                    System.out.println("ERROR - Cierre sin apertura");
                    System.out.println("   La pila está vacía!");
                    return false;
                }
                
                char tope = pila.pop();
                
                // Error: no coinciden
                if (!coinciden(tope, c)) {
                    System.out.println("ERROR - No coinciden");
                    System.out.println("   '" + c + "' no coincide con '" + tope + "'");
                    return false;
                }
                
                // Coinciden correctamente
                System.out.println("POP (coincide con '" + tope + "')");
                System.out.println("   Pila: " + (pila.isEmpty() ? "vacía" : pila.toString()));
            }
        }
        
        // Verificar si quedaron elementos sin cerrar
        System.out.println("\nFin del recorrido");
        if (!pila.isEmpty()) {
            System.out.println("ERROR - Quedan " + pila.size() + " apertura(s) sin cerrar: " + pila);
            return false;
        }
        
        System.out.println("Pila vacía - ¡BALANCEADO! ✓");
        return true;
    }
    
    // Método alternativo sin mostrar pasos (más simple)
    public static boolean verificarBalanceSimple(String expresion) {
        Stack<Character> pila = new Stack<>();
        
        for (char c : expresion.toCharArray()) {
            if (esApertura(c)) {
                pila.push(c);
            } else if (esCierre(c)) {
                if (pila.isEmpty() || !coinciden(pila.pop(), c)) {
                    return false;
                }
            }
        }
        
        return pila.isEmpty();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Casos de prueba
        String[] ejemplos = {
            "{[()]}",      // Balanceado
            "((a+b))",     // Balanceado
            "{a + [b * (c - d)]}", // Balanceado
            "{[(])}",      // No balanceado
            "([)]",        // No balanceado
            "((a+b)",      // No balanceado
            "{[}]"         // No balanceado
        };
        
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   VERIFICADOR DE BALANCE DE SIGNOS    ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        // Probar ejemplos automáticos
        System.out.println("\n>>> PROBANDO EJEMPLOS AUTOMÁTICOS <<<");
        for (String expresion : ejemplos) {
            boolean balanceado = verificarBalance(expresion);
            System.out.println("\nResultado: " + (balanceado ? "✓ BALANCEADO" : "✗ NO BALANCEADO"));
            System.out.println("─────────────────────────────────────────\n");
        }
        
        // Modo interactivo
        System.out.println("\n>>> MODO INTERACTIVO <<<");
        System.out.println("Ingresa expresiones para verificar (escribe 'salir' para terminar)");
        
        while (true) {
            System.out.print("\nExpresión: ");
            String expresion = scanner.nextLine().trim();
            
            if (expresion.equalsIgnoreCase("salir")) {
                System.out.println("¡Hasta luego!");
                break;
            }
            
            if (expresion.isEmpty()) {
                continue;
            }
            
            boolean balanceado = verificarBalance(expresion);
            System.out.println("\n" + (balanceado ? "✓ BALANCEADO" : "✗ NO BALANCEADO"));
        }
        
        scanner.close();
    }
}
