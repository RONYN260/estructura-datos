def factorial(n):
    """
    Calcula el factorial de n de forma recursiva.
    
    Ejemplo: factorial(5) = 5 * 4 * 3 * 2 * 1 = 120
    """
    # CASO BASE: detiene la recursión
    if n == 0 or n == 1:
        return 1
    
    # CASO RECURSIVO: se llama a sí misma
    return n * factorial(n - 1)


# Ejemplos de uso
print("Factorial de 5:", factorial(5))  # 120
print("Factorial de 3:", factorial(3))  # 6
print("Factorial de 0:", factorial(0))  # 1
print("Factorial de 7:", factorial(7))  # 5040


# Visualización del proceso para factorial(4):
print("\n--- Visualización de factorial(4) ---")
print("factorial(4) = 4 * factorial(3)")
print("             = 4 * (3 * factorial(2))")
print("             = 4 * (3 * (2 * factorial(1)))")
print("             = 4 * (3 * (2 * 1))")
print("             = 4 * (3 * 2)")
print("             = 4 * 6")
print("             = 24")


# Otro ejemplo: Suma de números del 1 al n
def suma_hasta_n(n):
    """Suma todos los números desde 1 hasta n"""
    if n == 1:
        return 1
    return n + suma_hasta_n(n - 1)

print("\n--- Suma de 1 hasta 5 ---")
print("Resultado:", suma_hasta_n(5))  # 15 (5+4+3+2+1)


# Ejemplo: Fibonacci
def fibonacci(n):
    """Calcula el n-ésimo número de Fibonacci"""
    if n <= 1:
        return n
    return fibonacci(n - 1) + fibonacci(n - 2)

print("\n--- Secuencia de Fibonacci ---")
print("Primeros 8 números de Fibonacci:")
for i in range(8):
    print(f"F({i}) = {fibonacci(i)}")