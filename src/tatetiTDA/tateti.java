package tatetiTDA;
import java.util.Random;

public class tateti implements tatetiTDA {
    static int[][] nuevo_tateti;

    @Override
    public int[][] inicializar() {
        nuevo_tateti = new int[2][2];
        return nuevo_tateti;
    }

    @Override
    public boolean turno() {
        Random aleatorio = new Random();
        int nro = aleatorio.nextInt(2);
        if (nro == 0) {
            return false;
        } else {
            return true;
        }
    }
    public int[][] getTablero(){
        return nuevo_tateti;
    }
    @Override
    public boolean jugar(int nro_columna, int nro_fila) {
        boolean jugada= true;
        if(nuevo_tateti[nro_fila][nro_columna] == 0) {
            nuevo_tateti[nro_fila][nro_columna]= 2;
        } else {
            jugada= false;
            System.out.println("Posición ya jugada, elegir otra");
        }
        return jugada;
    }

    private static boolean verificarPosicion(int nroFilaMaquina, int nroColumnaMaquina, int[][] tablero) {
        boolean verif = true;
        if (tablero[nroFilaMaquina][nroColumnaMaquina] == 2) {
            verif = false;
        }
        return verif;
    }

    private static boolean posibleJugada(int[][] tablero, int nroFila, int nroCol, int jugada) {
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

    public void jugarMaquina() {
        boolean ok = true;
        boolean jugadaEncontrada = false;
        int cont = 0;
        int nroFilaMaquina = 0;
        int nroColumnaMaquina = 0;
        while (!jugadaEncontrada) {
            boolean verif = false;
            while (!verif) {
                verif = verificarPosicion(nroFilaMaquina, nroColumnaMaquina, nuevo_tateti);
                if (verif == false) {
                    if (nroColumnaMaquina > 1) {
                        nroColumnaMaquina = 0; //Si es 2 la columna, paso a la fila de abajo
                        nroFilaMaquina++;
                    } else {
                        nroColumnaMaquina++;
                    }
                }
            }
            if (nroFilaMaquina == 0 && (nroColumnaMaquina == 0 || nroColumnaMaquina == 2)) {
                while (!jugadaEncontrada && cont < 3) {
                    jugadaEncontrada = posibleJugada(nuevo_tateti, nroFilaMaquina, nroColumnaMaquina, cont);
                    if (!jugadaEncontrada) {
                        cont++;
                    }
                }
            } else if (nroFilaMaquina == 0) {
                jugadaEncontrada = posibleJugada(nuevo_tateti, nroFilaMaquina, nroColumnaMaquina, 2);
            } else if (nroColumnaMaquina == 0) {
                jugadaEncontrada = posibleJugada(nuevo_tateti, nroFilaMaquina, nroColumnaMaquina, 1);
            }
            if (!jugadaEncontrada) { // Se puede implementar una funcion de adelantarPosicion que sea la pos como un objeto
                if (nroColumnaMaquina > 1) {
                    nroColumnaMaquina = 0; //Si es 2 la columna, paso a la fila de abajo
                    nroFilaMaquina++;
                } else {
                    nroColumnaMaquina++;
                }
            }
        }
    }
}
