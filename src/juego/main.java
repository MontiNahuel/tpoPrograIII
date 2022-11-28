package juego;
import tatetiTDA.tatetiTDA;
import tatetiTDA.tateti;

import java.util.Arrays;
import java.util.Scanner;

import static juego.funcionesJuego.validarFinJuego;

public class main {
    public static void imprimirMatriz(int[][] matriz) {
        for(int i=0; i < matriz.length; i++) {
            System.out.print("[  ");
            for(int f=0; f < matriz[i].length; f++) {
                System.out.print(matriz[i][f] + "  ");
            }
            System.out.print("]");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        tatetiTDA tablero = new tateti();
        tablero.inicializar();
        Scanner scan = new Scanner(System.in);
        boolean turno = tablero.turno();
        boolean finPartida = false;
        boolean conPosibilidades= true;
        boolean posicionCorrecta;
        int posFila;
        int posCol;
        int posibilidadSeguir;
        int[][] matriz;
        matriz= tablero.getTablero();
        imprimirMatriz(matriz);
        while (!finPartida && conPosibilidades) {
            while (turno) {
                System.out.println("Introducir el numero de fila:");
                posFila = scan.nextInt() - 1;
                while(posFila < 0 || posFila > 2) {
                    System.out.println("Introducir el numero de fila correctamente:");
                    posFila = scan.nextInt() - 1;
                }
                System.out.println("Introducir el numero de columna:");
                posCol = scan.nextInt() - 1;
                while(posCol < 0 || posCol > 2) {
                    System.out.println("Introducir el numero de columna correctamente:");
                    posCol = scan.nextInt() -1;
                }
                posicionCorrecta= tablero.jugar(posCol, posFila);
                if (posicionCorrecta) {
                    turno=false;
                }
                matriz= tablero.getTablero();
                imprimirMatriz(matriz);
                finPartida= validarFinJuego(tablero);
            }

            if(!finPartida) {
                System.out.println("Turno del oponente...");
                posibilidadSeguir= tablero.jugarMaquina();
                if (posibilidadSeguir == 1) {
                    conPosibilidades=false;
                    System.out.println("Ya no hay mas posibilidades...");
                }
            }
            matriz= tablero.getTablero();
            imprimirMatriz(matriz);
            finPartida= validarFinJuego(tablero);
            turno=true;
        }
        if(finPartida) {
            System.out.println("Finalizó la partida...");
            matriz= tablero.getTablero();
            imprimirMatriz(matriz);
        }
    }
}
