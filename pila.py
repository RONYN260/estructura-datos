class Pila:
    
    # El nodo es como una caja que guarda un número y apunta al siguiente
    class Nodo:
        def __init__(self, dato):
            self.dato = dato           # El número que guardamos
            self.siguiente = None      # Apunta al nodo de abajo
    
    # Constructor - crea una pila vacía
    def __init__(self):
        self.tope = None  # Apunta al nodo de arriba
    
    # PUSH - Poner un elemento arriba
    def push(self, dato):
        nuevo = self.Nodo(dato)     # Creamos un nuevo nodo
        nuevo.siguiente = self.tope  # El nuevo apunta al que estaba arriba
        self.tope = nuevo            # Ahora el nuevo es el tope
        print(f"Pusiste: {dato}")
    
    # POP - Sacar el elemento de arriba
    def pop(self):
        if self.tope is None:
            print("¡Pila vacía!")
            return -1
        
        dato = self.tope.dato        # Guardamos el dato del tope
        self.tope = self.tope.siguiente  # El tope ahora es el siguiente
        print(f"Sacaste: {dato}")
        return dato
    
    # PEEK - Ver qué hay arriba (sin sacar)
    def peek(self):
        if self.tope is None:
            print("¡Pila vacía!")
            return -1
        return self.tope.dato
    
    # Verificar si está vacía
    def esta_vacia(self):
        return self.tope is None
    
    # Mostrar toda la pila
    def mostrar(self):
        if self.tope is None:
            print("Pila vacía")
            return
        
        print("Pila (de arriba a abajo): ", end="")
        actual = self.tope
        while actual is not None:
            print(f"[{actual.dato}]", end="")
            if actual.siguiente is not None:
                print(" -> ", end="")
            actual = actual.siguiente
        print()


# MAIN - Ejemplo de uso
if __name__ == "__main__":
    pila = Pila()
    
    print("=== AGREGANDO ELEMENTOS ===")
    pila.push(10)
    pila.push(20)
    pila.push(30)
    pila.mostrar()
    
    print("\n=== VIENDO EL TOPE ===")
    print(f"El tope es: {pila.peek()}")
    
    print("\n=== SACANDO ELEMENTOS ===")
    pila.pop()
    pila.mostrar()
    
    pila.pop()
    pila.mostrar()
    
    print("\n=== VERIFICANDO SI ESTÁ VACÍA ===")
    print(f"¿Está vacía? {pila.esta_vacia()}")
    
    pila.pop()
    print(f"¿Está vacía? {pila.esta_vacia()}")