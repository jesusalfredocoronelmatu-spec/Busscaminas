import java.util.Random;

public class buscaminas {
    void main() {
        int filas = 8;
        int columnas = 8;
        int minas = 10;
        int[][] tablero = new int[8][8];
        int seleccion = 0;

        
        do {
            IO.println("---------------------------------");
            IO.println("           BUSCAMINAS            ");
            IO.println("---------------------------------");
            IO.println(" 1. Fácil   (8x8   - 10 minas)");
            IO.println(" 2. Medio   (16x30 - 50 minas)");
            IO.println(" 3. Difícil (16x30 - 99 minas)");
            IO.println("---------------------------------");

            String entrada = IO.readln("Elige una opción: ");
            if (entrada != null) {
                try {
                    seleccion = Integer.parseInt(entrada.trim());
                } catch (NumberFormatException e) {
                    seleccion = 0;
                }
            }

            switch (seleccion) {
                case 1 -> {
                    filas = 8;
                    columnas = 8;
                    minas = 10;
                }
                case 2 -> {
                    filas = 16;
                    columnas = 30;
                    minas = 50;
                }
                case 3 -> {
                    filas = 16;
                    columnas = 30;
                    minas = 99;
                }
                default -> IO.println("Opción no válida, elige otra.");
            }
        } while (seleccion < 1 || seleccion > 3);

        
        tablero = new int[filas][columnas];
        Random random = new Random();
        int minasColocadas = 0;

        while (minasColocadas < minas) {
            int fila = random.nextInt(filas);
            int columna = random.nextInt(columnas);

            if (tablero[fila][columna] != -1) {
                tablero[fila][columna] = -1;
                minasColocadas++;
            }
        }

       
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j] != -1) {
                    int contador = 0;
                    for (int di = i - 1; di <= i + 1; di++) {
                        for (int dj = j - 1; dj <= j + 1; dj++) {
                            if (di >= 0 && di < filas && dj >= 0 && dj < columnas && tablero[di][dj] == -1) {
                                contador++;
                            }
                        }
                    }
                    tablero[i][j] = contador;
                }
            }
        }

        
        IO.println();
        IO.println("=================================");
        IO.println("        TABLERO GENERADO         ");
        IO.println("=================================");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                IO.print("%3d ".formatted(tablero[i][j]));
            }
            IO.println();
        }
        IO.println("=================================");
    }
}