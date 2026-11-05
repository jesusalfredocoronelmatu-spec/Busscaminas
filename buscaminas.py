import random


def main():
    filas = 8
    columnas = 8
    minas = 10
    seleccion = 0

    
    while seleccion < 1 or seleccion > 3:
        print("---------------------------------")
        print("           BUSCAMINAS            ")
        print("---------------------------------")
        print(" 1. Fácil   (8x8   - 10 minas)")
        print(" 2. Medio   (16x30 - 50 minas)")
        print(" 3. Difícil (16x30 - 99 minas)")
        print("---------------------------------")

        entrada = input("Elige una opción: ").strip()

        if entrada.isdigit():
            seleccion = int(entrada)
        else:
            seleccion = 0

        match seleccion:
            case 1:
                filas = 8
                columnas = 8
                minas = 10
            case 2:
                filas = 16
                columnas = 30
                minas = 50
            case 3:
                filas = 16
                columnas = 30
                minas = 99
            case _:
                print("Opción no válida, elige otra.\n")

    
    tablero = [[0 for _ in range(columnas)] for _ in range(filas)]

    
    minas_colocadas = 0
    while minas_colocadas < minas:
        fila = random.randint(0, filas - 1)
        columna = random.randint(0, columnas - 1)

        if tablero[fila][columna] != -1:
            tablero[fila][columna] = -1
            minas_colocadas += 1

    
    for i in range(filas):
        for j in range(columnas):
            if tablero[i][j] != -1:
                contador = 0
                for di in range(i - 1, i + 2):
                    for dj in range(j - 1, j + 2):
                        # Verificamos los límites de la matriz
                        if 0 <= di < filas and 0 <= dj < columnas:
                            if tablero[di][dj] == -1:
                                contador += 1
                tablero[i][j] = contador

    
    print()
    print("=================================")
    print("        TABLERO GENERADO         ")
    print("=================================")
    for i in range(filas):
        for j in range(columnas):
            print(f"{tablero[i][j]:3d} ", end="")
        print()
    print("=================================")


if __name__ == "__main__":
    main()