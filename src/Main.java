import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception{

        /*
        --- METODOS OBLIGATORIOS ---
        TODO: Mostrar todos los datos de las carreras
         */

        File file = new File("src/input.txt");
        Scanner reader = new Scanner(file);
        int nCarreras;
        Carrera[] carreras;

        nCarreras = Integer.parseInt(reader.nextLine());
        carreras = new Carrera[nCarreras];

        for (int i = 0; i < nCarreras; i++) {
            int nToros = Integer.parseInt(reader.next());
            int[] velocidades = new int[nToros];

            for (int j = 0; j < nToros; j++) {
                velocidades[j] = Integer.parseInt(reader.next());
            }

            String fecha = reader.next();
            int nCorredores = Integer.parseInt(reader.next());
            int nHeridos = Integer.parseInt(reader.next());

            System.out.println(
                    "Numero de toros: " + nToros +
                    "\nVelocidades: " + Arrays.toString(velocidades) +
                    "\nFecha: " + fecha +
                    "\nCorredores: " + nCorredores +
                    "\nHeridos: " + nHeridos
            );

            carreras[i] = new Carrera(nToros, velocidades, fecha, nCorredores, nHeridos);

        }

    }
}