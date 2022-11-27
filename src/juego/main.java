package juego;
import tatetiTDA.tatetiTDA;
import tatetiTDA.tateti;
import java.util.Scanner;

import static juego.funcionesJuego.validarFinJuego;

public class main {
    public static void main(String[] args) {
        tatetiTDA tablero = new tateti();
        tablero.inicializar();
        Scanner scan = new Scanner(System.in);
        boolean turno = tablero.turno();
        boolean finPartida = false;
        boolean posicionCorrecta;
        int posFila;
        int posCol;
        int[][] matriz;
        while (!finPartida) {
            matriz= tablero.getTablero();
            System.out.println(matriz);
            while (turno) {
                System.out.println("Introducir el numero de fila:");
                posFila = scan.nextInt() - 1;
                while(posFila < 0 || posFila > 2) {
                    System.out.println("Introducir el numero de fila correctamente:");
                    posFila = scan.nextInt() - 1;
                }
                System.out.println("Introducir el numero de columna:");
                posCol = scan.nextInt();
                while(posCol < 0 || posCol > 2) {
                    System.out.println("Introducir el numero de columna correctamente:");
                    posCol = scan.nextInt() - 1;
                }
                posicionCorrecta= tablero.jugar(posCol, posFila);
                if (posicionCorrecta) {
                    turno=false;
                }
            }
            matriz= tablero.getTablero();
            System.out.println(matriz);
            finPartida= validarFinJuego(tablero);
            if(!finPartida) {
                tablero.jugarMaquina();
            }
            matriz= tablero.getTablero();
            System.out.println(matriz);
            finPartida= validarFinJuego(tablero);
            turno=true;
        }
        if(finPartida) {
            System.out.println("Finalizó la partida...");
            matriz= tablero.getTablero();
            System.out.println(matriz);
        }
    }
}
