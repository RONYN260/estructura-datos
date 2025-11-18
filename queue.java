import java.util.Scanner;

public class queue{
    
    // Clase Nodo para nuestra cola
    static class Nodo {
        String dato;         // El dato que guardamos (puede ser cualquier tipo)
        Nodo siguiente;      // Referencia al siguiente nodo
        
        // Constructor
        public Nodo(String dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    
    // Clase Queue (Cola) implementada con nodos
    static class Queue {
        private Nodo frente;    // El primer nodo (frente de la cola)
        private Nodo fin;       // El último nodo (final de la cola)
        private int tamaño;     // Cantidad de elementos
        
        // Constructor
        public Queue() {
            this.frente = null;
            this.fin = null;
            this.tamaño = 0;
        }
        
        // ENQUEUE: Agregar un elemento al final de la cola
        public void enqueue(String dato) {
            Nodo nuevoNodo = new Nodo(dato);
            
            // Si la cola está vacía
            if (estaVacia()) {
                frente = nuevoNodo;
                fin = nuevoNodo;
            } else {
                // El último nodo apunta al nuevo nodo
                fin.siguiente = nuevoNodo;
                // El nuevo nodo se convierte en el último
                fin = nuevoNodo;
            }
            
            tamaño++;
            System.out.println("   ✓ ENQUEUE: '" + dato + "' agregado al final");
        }
        
        // DEQUEUE: Sacar el elemento del frente de la cola
        public String dequeue() {
            if (estaVacia()) {
                System.out.println("   ✗ ERROR: La cola está vacía");
                return null;
            }
            
            String dato = frente.dato;
            frente = frente.siguiente;  // El frente ahora es el siguiente nodo
            
            // Si la cola quedó vacía, actualizar el fin
            if (frente == null) {
                fin = null;
            }
            
            tamaño--;
            System.out.println("   ✓ DEQUEUE: '" + dato + "' sacado del frente");
            return dato;
        }
        
        // PEEK: Ver el elemento del frente sin sacarlo
        public String peek() {
            if (estaVacia()) {
                return null;
            }
            return frente.dato;
        }
        
        // Verificar si la cola está vacía
        public boolean estaVacia() {
            return frente == null;
        }
        
        // Obtener el tamaño de la cola
        public int getTamaño() {
            return tamaño;
        }
        
        // Mostrar el contenido de la cola (para visualización)
        public void mostrar() {
            if (estaVacia()) {
                System.out.println("   Cola: [vacía]");
                return;
            }
            
            System.out.print("   Cola (frente→fin): [");
            Nodo actual = frente;
            while (actual != null) {
                System.out.print(actual.dato);
                if (actual.siguiente != null) {
                    System.out.print(" → ");
                }
                actual = actual.siguiente;
            }
            System.out.println("]");
        }
    }
    
    // Ejemplo 1: Sistema de atención de clientes
    public static void ejemploAtencionClientes() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║     EJEMPLO 1: ATENCIÓN DE CLIENTES        ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        Queue colaClientes = new Queue();
        
        System.out.println("📋 Llegada de clientes:");
        colaClientes.enqueue("Ana");
        colaClientes.mostrar();
        System.out.println();
        
        colaClientes.enqueue("Bruno");
        colaClientes.mostrar();
        System.out.println();
        
        colaClientes.enqueue("Carlos");
        colaClientes.mostrar();
        System.out.println();
        
        colaClientes.enqueue("Diana");
        colaClientes.mostrar();
        System.out.println();
        
        System.out.println("\n👤 Atendiendo clientes (FIFO - First In, First Out):");
        System.out.println("   Próximo cliente: " + colaClientes.peek());
        colaClientes.dequeue();
        colaClientes.mostrar();
        System.out.println();
        
        colaClientes.dequeue();
        colaClientes.mostrar();
        System.out.println();
        
        System.out.println("📋 Llega un nuevo cliente:");
        colaClientes.enqueue("Elena");
        colaClientes.mostrar();
        System.out.println();
        
        System.out.println("👤 Continuar atendiendo:");
        colaClientes.dequeue();
        colaClientes.mostrar();
        System.out.println();
        
        colaClientes.dequeue();
        colaClientes.mostrar();
        System.out.println();
        
        colaClientes.dequeue();
        colaClientes.mostrar();
    }
    
    // Ejemplo 2: Cola de impresión
    public static void ejemploColaImpresion() {
        System.out.println("\n\n╔════════════════════════════════════════════╗");
        System.out.println("║      EJEMPLO 2: COLA DE IMPRESIÓN          ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        Queue colaImpresion = new Queue();
        
        System.out.println("🖨️ Documentos enviados a imprimir:");
        colaImpresion.enqueue("Documento1.pdf");
        colaImpresion.mostrar();
        System.out.println();
        
        colaImpresion.enqueue("Foto.jpg");
        colaImpresion.mostrar();
        System.out.println();
        
        colaImpresion.enqueue("Reporte.docx");
        colaImpresion.mostrar();
        System.out.println();
        
        System.out.println("📄 Imprimiendo documentos:");
        while (!colaImpresion.estaVacia()) {
            System.out.println("   Imprimiendo: " + colaImpresion.peek());
            colaImpresion.dequeue();
            colaImpresion.mostrar();
            System.out.println();
        }
        
        System.out.println("✓ Todos los documentos han sido impresos");
    }
    
    // Modo interactivo
    public static void modoInteractivo() {
        Scanner scanner = new Scanner(System.in);
        Queue miCola = new Queue();
        
        System.out.println("\n\n╔════════════════════════════════════════════╗");
        System.out.println("║         MODO INTERACTIVO - QUEUE           ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        System.out.println("Comandos disponibles:");
        System.out.println("  1 - ENQUEUE (agregar elemento)");
        System.out.println("  2 - DEQUEUE (sacar elemento)");
        System.out.println("  3 - PEEK (ver el frente)");
        System.out.println("  4 - MOSTRAR cola");
        System.out.println("  5 - TAMAÑO");
        System.out.println("  0 - SALIR\n");
        
        boolean continuar = true;
        while (continuar) {
            System.out.print("\nComando: ");
            String comando = scanner.nextLine().trim();
            
            switch (comando) {
                case "1":
                    System.out.print("   Elemento a agregar: ");
                    String elemento = scanner.nextLine().trim();
                    if (!elemento.isEmpty()) {
                        miCola.enqueue(elemento);
                        miCola.mostrar();
                    }
                    break;
                    
                case "2":
                    String sacado = miCola.dequeue();
                    if (sacado != null) {
                        miCola.mostrar();
                    }
                    break;
                    
                case "3":
                    String frente = miCola.peek();
                    if (frente != null) {
                        System.out.println("   Frente: '" + frente + "'");
                    } else {
                        System.out.println("   La cola está vacía");
                    }
                    break;
                    
                case "4":
                    miCola.mostrar();
                    break;
                    
                case "5":
                    System.out.println("   Tamaño: " + miCola.getTamaño() + " elementos");
                    break;
                    
                case "0":
                    System.out.println("\n¡Hasta luego! 👋");
                    continuar = false;
                    break;
                    
                default:
                    System.out.println("   Comando no válido");
            }
        }
        
        scanner.close();
    }
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║                                            ║");
        System.out.println("║         ESTRUCTURA DE DATOS: QUEUE         ║");
        System.out.println("║       (Cola - Implementación con Nodos)    ║");
        System.out.println("║                                            ║");
        System.out.println("║   FIFO: First In, First Out                ║");
        System.out.println("║   (Primero en entrar, primero en salir)    ║");
        System.out.println("║                                            ║");
        System.out.println("╚════════════════════════════════════════════╝");
        
        // Ejecutar ejemplos
        ejemploAtencionClientes();
        ejemploColaImpresion();
        
        // Modo interactivo
        modoInteractivo();
    }
}