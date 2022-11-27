package juego;

import tatetiTDA.tatetiTDA;

public class funcionesJuego {

    private static boolean posibleJugada3Seguidas(int[][] tablero, int nroFila, int nroCol, int jugada) {
        boolean posible = true; //Borrar
        boolean ok = true;
        if (jugada == 1) { //Jugada en horizontal
            for (int i = 0; i < 2; i++) {
                if (tablero[nroFila][i] == 2) {
                    ok = false;
                }
            }
        } else if (jugada == 2) { //Jugada en vertical
            for (int i = 0; i < 2; i++) {
                if (tablero[i][nroCol] == 2) {
                    ok = false;
                }
            }
        } else if (jugada == 3) { //Jugada en diagonal
            if (nroCol == 0) {
                for (int i = 0; i < 2; i++) {
                    if (tablero[i][i] == 2) {
                        ok = false;
                    }
                }
            } else if (nroCol == 2) {
                for (int i = 0; i < 2; i++) {
                    if (tablero[i][nroCol] == 2) {
                        ok = false;
                    }
                    nroCol--;
                }
            }
        }
        return ok;
    }

    public static boolean validar3Seguidos(int[][] tablero, int nro, int col, int fila) {
        boolean tresSeguidos= false;
        int cont= 1;
        if(col==0 && fila==0) {
            while(!tresSeguidos && cont < 3) {

            }
        }
    }
    public static boolean validarFinJuego(tatetiTDA tablero) {
        boolean finalEncontrado= false;
        int col=0; int fila= 0;
        int[][] matriz= tablero.getTablero();
        while(!finalEncontrado) {
            if(matriz[fila][col] != 0) {

            }
        }
    }
}
