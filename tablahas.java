import java.util.HashMap;

class tablahashas {
    public static void main(String[] args) {
        // Crear un HashMap
        HashMap<String, Integer> edades = new HashMap<>();
        
        // Agregar elementos (clave, valor)
        edades.put("Juan", 25);
        edades.put("María", 30);
        edades.put("Pedro", 28);
        
        // Obtener un valor por clave
        System.out.println("Edad de Juan: " + edades.get("Juan")); // 25
        
        // Verificar si existe una clave
        if (edades.containsKey("María")) {
            System.out.println("María está en la lista");
        }
        
        // Recorrer todo el HashMap
        for (String nombre : edades.keySet()) {
            System.out.println(nombre + " tiene " + edades.get(nombre) + " años");
        }
        
        // Eliminar un elemento
        edades.remove("Pedro");
        
        // Tamaño
        System.out.println("Total de personas: " + edades.size());
    }
}