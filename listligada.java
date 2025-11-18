
import java.util.Scanner;

public class listligada  {
    
    // Clase Nodo para nuestra lista ligada
    static class Nodo {
        int dato;            // El dato que guardamos
        Nodo siguiente;      // Referencia al siguiente nodo
        
        // Constructor
        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    
    // Clase Lista Ligada Simple
    static class Lista {
        private Nodo cabeza;     // El primer nodo de la lista
        private int tamaño;      // Cantidad de elementos
        
        // Constructor
        public Lista() {
            this.cabeza = null;
            this.tamaño = 0;
        }
        
        // INSERTAR AL INICIO
        public void insertarAlInicio(int dato) {
            Nodo nuevoNodo = new Nodo(dato);
            nuevoNodo.siguiente = cabeza;  // El nuevo nodo apunta a la antigua cabeza
            cabeza = nuevoNodo;            // El nuevo nodo se convierte en la cabeza
            tamaño++;
            System.out.println("   ✓ Insertado " + dato + " al inicio");
        }
        
        // INSERTAR AL FINAL
        public void insertarAlFinal(int dato) {
            Nodo nuevoNodo = new Nodo(dato);
            
            // Si la lista está vacía
            if (estaVacia()) {
                cabeza = nuevoNodo;
            } else {
                // Recorrer hasta el último nodo
                Nodo actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevoNodo;  // Enlazar el último nodo con el nuevo
            }
            
            tamaño++;
            System.out.println("   ✓ Insertado " + dato + " al final");
        }
        
        // INSERTAR EN POSICIÓN ESPECÍFICA
        public void insertarEnPosicion(int dato, int posicion) {
            // Validar posición
            if (posicion < 0 || posicion > tamaño) {
                System.out.println("   ✗ Posición inválida (0-" + tamaño + ")");
                return;
            }
            
            // Si es la posición 0, insertar al inicio
            if (posicion == 0) {
                insertarAlInicio(dato);
                return;
            }
            
            Nodo nuevoNodo = new Nodo(dato);
            Nodo actual = cabeza;
            
            // Avanzar hasta la posición anterior
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.siguiente;
            }
            
            // Insertar el nuevo nodo
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
            tamaño++;
            System.out.println("   ✓ Insertado " + dato + " en posición " + posicion);
        }
        
        // ELIMINAR DEL INICIO
        public Integer eliminarDelInicio() {
            if (estaVacia()) {
                System.out.println("   ✗ La lista está vacía");
                return null;
            }
            
            int dato = cabeza.dato;
            cabeza = cabeza.siguiente;  // La cabeza ahora es el siguiente nodo
            tamaño--;
            System.out.println("   ✓ Eliminado " + dato + " del inicio");
            return dato;
        }
        
        // ELIMINAR DEL FINAL
        public Integer eliminarDelFinal() {
            if (estaVacia()) {
                System.out.println("   ✗ La lista está vacía");
                return null;
            }
            
            // Si solo hay un elemento
            if (cabeza.siguiente == null) {
                int dato = cabeza.dato;
                cabeza = null;
                tamaño--;
                System.out.println("   ✓ Eliminado " + dato + " del final");
                return dato;
            }
            
            // Recorrer hasta el penúltimo nodo
            Nodo actual = cabeza;
            while (actual.siguiente.siguiente != null) {
                actual = actual.siguiente;
            }
            
            int dato = actual.siguiente.dato;
            actual.siguiente = null;  // Eliminar el último nodo
            tamaño--;
            System.out.println("   ✓ Eliminado " + dato + " del final");
            return dato;
        }
        
        // ELIMINAR EN POSICIÓN ESPECÍFICA
        public Integer eliminarEnPosicion(int posicion) {
            if (posicion < 0 || posicion >= tamaño) {
                System.out.println("   ✗ Posición inválida (0-" + (tamaño-1) + ")");
                return null;
            }
            
            if (posicion == 0) {
                return eliminarDelInicio();
            }
            
            Nodo actual = cabeza;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.siguiente;
            }
            
            int dato = actual.siguiente.dato;
            actual.siguiente = actual.siguiente.siguiente;
            tamaño--;
            System.out.println("   ✓ Eliminado " + dato + " de posición " + posicion);
            return dato;
        }
        
        // BUSCAR un elemento
        public int buscar(int dato) {
            Nodo actual = cabeza;
            int posicion = 0;
            
            while (actual != null) {
                if (actual.dato == dato) {
                    System.out.println("   ✓ Elemento " + dato + " encontrado en posición " + posicion);
                    return posicion;
                }
                actual = actual.siguiente;
                posicion++;
            }
            
            System.out.println("   ✗ Elemento " + dato + " no encontrado");
            return -1;
        }
        
        // OBTENER elemento en posición
        public Integer obtener(int posicion) {
            if (posicion < 0 || posicion >= tamaño) {
                System.out.println("   ✗ Posición inválida");
                return null;
            }
            
            Nodo actual = cabeza;
            for (int i = 0; i < posicion; i++) {
                actual = actual.siguiente;
            }
            
            return actual.dato;
        }
        
        // Verificar si está vacía
        public boolean estaVacia() {
            return cabeza == null;
        }
        
        // Obtener tamaño
        public int getTamaño() {
            return tamaño;
        }
        
        // MOSTRAR la lista
        public void mostrar() {
            if (estaVacia()) {
                System.out.println("   Lista: [vacía]");
                return;
            }
            
            System.out.print("   Lista: [");
            Nodo actual = cabeza;
            while (actual != null) {
                System.out.print(actual.dato);
                if (actual.siguiente != null) {
                    System.out.print(" → ");
                }
                actual = actual.siguiente;
            }
            System.out.println("]");
        }
        
        // VACIAR la lista
        public void vaciar() {
            cabeza = null;
            tamaño = 0;
            System.out.println("   ✓ Lista vaciada");
        }
    }
    
    // Ejemplo 1: Operaciones básicas
    public static void ejemploOperacionesBasicas() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║    EJEMPLO 1: OPERACIONES BÁSICAS          ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        Lista lista = new Lista();
        
        System.out.println("📌 Insertando al final:");
        lista.insertarAlFinal(10);
        lista.mostrar();
        System.out.println();
        
        lista.insertarAlFinal(20);
        lista.mostrar();
        System.out.println();
        
        lista.insertarAlFinal(30);
        lista.mostrar();
        System.out.println();
        
        System.out.println("📌 Insertando al inicio:");
        lista.insertarAlInicio(5);
        lista.mostrar();
        System.out.println();
        
        System.out.println("📌 Insertando en posición 2:");
        lista.insertarEnPosicion(15, 2);
        lista.mostrar();
        System.out.println();
        
        System.out.println("📌 Tamaño de la lista: " + lista.getTamaño());
    }
    
    // Ejemplo 2: Eliminaciones
    public static void ejemploEliminaciones() {
        System.out.println("\n\n╔════════════════════════════════════════════╗");
        System.out.println("║       EJEMPLO 2: ELIMINACIONES             ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        Lista lista = new Lista();
        
        // Crear lista: 10 → 20 → 30 → 40 → 50
        for (int i = 10; i <= 50; i += 10) {
            lista.insertarAlFinal(i);
        }
        
        System.out.println("Lista inicial:");
        lista.mostrar();
        System.out.println();
        
        System.out.println("🗑️ Eliminando del inicio:");
        lista.eliminarDelInicio();
        lista.mostrar();
        System.out.println();
        
        System.out.println("🗑️ Eliminando del final:");
        lista.eliminarDelFinal();
        lista.mostrar();
        System.out.println();
        
        System.out.println("🗑️ Eliminando posición 1:");
        lista.eliminarEnPosicion(1);
        lista.mostrar();
        System.out.println();
    }
    
    // Ejemplo 3: Búsquedas
    public static void ejemploBusquedas() {
        System.out.println("\n\n╔════════════════════════════════════════════╗");
        System.out.println("║         EJEMPLO 3: BÚSQUEDAS               ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        Lista lista = new Lista();
        
        // Crear lista: 100 → 200 → 300 → 400 → 500
        for (int i = 100; i <= 500; i += 100) {
            lista.insertarAlFinal(i);
        }
        
        System.out.println("Lista:");
        lista.mostrar();
        System.out.println();
        
        System.out.println("🔍 Buscando elementos:");
        lista.buscar(300);
        lista.buscar(500);
        lista.buscar(999);
        System.out.println();
        
        System.out.println("📋 Obteniendo elementos por posición:");
        System.out.println("   Posición 0: " + lista.obtener(0));
        System.out.println("   Posición 2: " + lista.obtener(2));
        System.out.println("   Posición 4: " + lista.obtener(4));
    }
    
    // Modo interactivo
    public static void modoInteractivo() {
        Scanner scanner = new Scanner(System.in);
        Lista miLista = new Lista();
        
        System.out.println("\n\n╔════════════════════════════════════════════╗");
        System.out.println("║      MODO INTERACTIVO - LISTA LIGADA       ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        System.out.println("Comandos disponibles:");
        System.out.println("  1 - Insertar al inicio");
        System.out.println("  2 - Insertar al final");
        System.out.println("  3 - Insertar en posición");
        System.out.println("  4 - Eliminar del inicio");
        System.out.println("  5 - Eliminar del final");
        System.out.println("  6 - Eliminar en posición");
        System.out.println("  7 - Buscar elemento");
        System.out.println("  8 - Mostrar lista");
        System.out.println("  9 - Tamaño");
        System.out.println("  10 - Vaciar lista");
        System.out.println("  0 - Salir\n");
        
        boolean continuar = true;
        while (continuar) {
            System.out.print("\nComando: ");
            String comando = scanner.nextLine().trim();
            
            try {
                switch (comando) {
                    case "1":
                        System.out.print("   Valor a insertar: ");
                        int valor1 = Integer.parseInt(scanner.nextLine().trim());
                        miLista.insertarAlInicio(valor1);
                        miLista.mostrar();
                        break;
                        
                    case "2":
                        System.out.print("   Valor a insertar: ");
                        int valor2 = Integer.parseInt(scanner.nextLine().trim());
                        miLista.insertarAlFinal(valor2);
                        miLista.mostrar();
                        break;
                        
                    case "3":
                        System.out.print("   Valor a insertar: ");
                        int valor3 = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("   Posición (0-" + miLista.getTamaño() + "): ");
                        int pos3 = Integer.parseInt(scanner.nextLine().trim());
                        miLista.insertarEnPosicion(valor3, pos3);
                        miLista.mostrar();
                        break;
                        
                    case "4":
                        miLista.eliminarDelInicio();
                        miLista.mostrar();
                        break;
                        
                    case "5":
                        miLista.eliminarDelFinal();
                        miLista.mostrar();
                        break;
                        
                    case "6":
                        System.out.print("   Posición a eliminar (0-" + (miLista.getTamaño()-1) + "): ");
                        int pos6 = Integer.parseInt(scanner.nextLine().trim());
                        miLista.eliminarEnPosicion(pos6);
                        miLista.mostrar();
                        break;
                        
                    case "7":
                        System.out.print("   Valor a buscar: ");
                        int valor7 = Integer.parseInt(scanner.nextLine().trim());
                        miLista.buscar(valor7);
                        break;
                        
                    case "8":
                        miLista.mostrar();
                        break;
                        
                    case "9":
                        System.out.println("   Tamaño: " + miLista.getTamaño() + " elementos");
                        break;
                        
                    case "10":
                        miLista.vaciar();
                        miLista.mostrar();
                        break;
                        
                    case "0":
                        System.out.println("\n¡Hasta luego! 👋");
                        continuar = false;
                        break;
                        
                    default:
                        System.out.println("   Comando no válido");
                }
            } catch (NumberFormatException e) {
                System.out.println("   ✗ Error: Ingresa un número válido");
            }
        }
        
        scanner.close();
    }
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║                                            ║");
        System.out.println("║      ESTRUCTURA DE DATOS: LISTA LIGADA     ║");
        System.out.println("║      (Linked List - Implementación)        ║");
        System.out.println("║                                            ║");
        System.out.println("║   Colección de nodos enlazados             ║");
        System.out.println("║   Cada nodo apunta al siguiente            ║");
        System.out.println("║                                            ║");
        System.out.println("╚════════════════════════════════════════════╝");
        
        // Ejecutar ejemplos
        ejemploOperacionesBasicas();
        ejemploEliminaciones();
        ejemploBusquedas();
        
        // Modo interactivo
        modoInteractivo();
    }
}