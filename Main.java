import java.util.ArrayList;
import java.util.List;

class Grafo {
    private List<List<Integer>> listaAdyacencia;

    // Constructor: crea un grafo con 'n' vértices
    public Grafo(int n) {
        listaAdyacencia = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    // Método para agregar una arista (conexión)
    public void agregarArista(int origen, int destino) {
        listaAdyacencia.get(origen).add(destino);
        listaAdyacencia.get(destino).add(origen); // Para grafo no dirigido
    }

    // Mostrar el grafo
    public void mostrarGrafo() {
        for (int i = 0; i < listaAdyacencia.size(); i++) {
            System.out.print("Nodo " + i + ": ");
            for (int nodo : listaAdyacencia.get(i)) {
                System.out.print(nodo + " ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(4); // Creamos un grafo con 4 nodos

        grafo.agregarArista(0, 1);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(0, 3);

        grafo.mostrarGrafo();
    }
}
