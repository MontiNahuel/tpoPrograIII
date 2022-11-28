package tatetiTDA;

public interface tatetiTDA {
    int[][] inicializar();
    boolean turno();
    boolean jugar(int nro_columna, int nro_fila);
    int jugarMaquina();
    int[][] getTablero();

}
