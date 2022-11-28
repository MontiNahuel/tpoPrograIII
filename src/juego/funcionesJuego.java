package juego;

import tatetiTDA.tatetiTDA;

public class funcionesJuego {

    private static boolean posibleJugada3Seguidas(int[][] tablero, int nroFila, int nroCol, int jugada, int nroJugador) {
        boolean posible = true; //Borrar
        boolean ok = false;
        if (jugada == 1) { //Jugada en horizontal
            int cont=0;
            for (int i = 0; i < 3; i++) {
                if (tablero[nroFila][i] == nroJugador) {
                    cont++;
                }
            }
            if(cont == 3) {
                ok=true;
            }
        } else if (jugada == 2) { //Jugada en vertical
            int cont= 0;
            for (int i = 0; i < 3; i++) {
                if (tablero[i][nroCol] == nroJugador) {
                    cont++;
                }
            }
            if(cont == 3) {
                ok=true;
            }
        } else if (jugada == 3) { //Jugada en diagonal
            int cont=0;
            if (nroCol == 0) {
                for (int i = 0; i < 3; i++) {
                    if (tablero[i][i] == nroJugador) {
                        cont++;
                    }
                }
                if(cont == 3) {
                    ok=true;
                }
            } else if (nroCol == 2) {
                for (int i = 0; i < 3; i++) {
                    if (tablero[i][nroCol] == nroJugador) {
                        cont++;
                    }
                    nroCol--;
                }
                if(cont == 3) {
                    ok=true;
                }
            }
        }
        return ok;
    }

    public static boolean validar3Seguidos(int[][] tablero, int nro, int col, int fila) {
        boolean tresSeguidos= false;
        int cont= 1;
        return false;
    }
    public static boolean validarFinJuego(tatetiTDA tablero) {
        boolean finalEncontrado= false;
        int col=0; int fila= 0;
        int cont= 0;
        int[][] matriz= tablero.getTablero();
        while(!finalEncontrado && cont < 8) {
            if(matriz[fila][col] != 0 && fila==0 && (col==0 || col==2)) {
                //FuncionBuscar3Seguidos -> Devuelve Booleano
                for(int i = 0; i <= 3; i++) {
                    finalEncontrado = posibleJugada3Seguidas(matriz, fila, col, i, matriz[fila][col]);
                }
            } else if (matriz[fila][col] != 0 && col > 0) {
                finalEncontrado = posibleJugada3Seguidas(matriz, fila, col, 2, matriz[fila][col]);
            } else if (matriz[fila][col] != 0 && col == 0) {
                finalEncontrado= posibleJugada3Seguidas(matriz,fila,col,1, matriz[fila][col]);
            } if (!finalEncontrado) {
                if(col > 1) {
                    col = 0;
                    fila++;
                } else {
                    col++;
                }
            }
            cont++;
        }
        return finalEncontrado;
    }
}
