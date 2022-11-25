package tatetiTDA;
import java.util.Random;

public class tateti implements tatetiTDA{
    int[][] nuevo_tateti;

    @Override
    public int[][] inicializar() {
        nuevo_tateti= new int[2][2];
        return nuevo_tateti;
    }

    @Override
    public boolean turno() {
        Random aleatorio= new Random();
        int nro= aleatorio.nextInt(2);
        if (nro == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void jugar(int nro_columna, int nro_fila) {
        boolean ok = true;
        int nroFilaMaquina= 0;
        int nroColumnaMaquina= 0;
        while (ok) {
            if (nro_columna == nroColumnaMaquina && nro_fila == nroFilaMaquina) {
                if (nroColumnaMaquina < 2) {
                    nroColumnaMaquina++;
                } else {
                    nroColumnaMaquina = 0;
                    nroFilaMaquina++;
                }
            }
        }
    }
}
