public class quicksort {

    public class QuickSort {
    
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Encuentra el índice de partición
            int pi = partition(arr, low, high);
            
            // Ordena recursivamente los elementos antes y después de la partición
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        // Elegimos el último elemento como pivote
        int pivot = arr[high];
        int i = low - 1; // Índice del elemento más pequeño
        
        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arr[j] <= pivot) {
                i++;
                // Intercambiamos arr[i] y arr[j]
                swap(arr, i, j);
            }
        } 
        
        // Intercambiamos arr[i+1] y arr[high] (el pivote)
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // Método auxiliar para imprimir el array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    // Ejemplo de uso
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Array original:");
        printArray(arr);
        
        quickSort(arr, 0, arr.length - 1);
        
        System.out.println("Array ordenado:");
        printArray(arr);
    }
}
}