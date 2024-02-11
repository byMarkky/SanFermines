import java.io.File;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception{

        File file = new File("src/input.txt");
        Scanner fileReader = new Scanner(file);

        Carrera[] carreras;

        carreras = getData(fileReader);
        fileReader.close();

        // --- Mostrar velocidad maxima de una carrera
        //System.out.println(carreras[0].getMaximaVelocidad());

        // --- Mostrar heridos
        //System.out.println(carreras[0].mostrarHeridos());

        // --- Mostrar datos de una carrera
        //Carrera.mostrarDatosCarrera(carreras[0]);

        // --- Mostrar los datos de todas las carreras
        //Carrera.mostrarDatosCarreras(carreras);

    }
    public static Carrera[] getData(Scanner reader) {
        int nCarreras;
        nCarreras = Integer.parseInt(reader.nextLine());
        Carrera[] tmp = new Carrera[nCarreras];

        for (int i = 0; i < nCarreras; i++) {
            int nToros = Integer.parseInt(reader.next());
            int[] velocidades = new int[nToros];

            for (int j = 0; j < nToros; j++) {
                velocidades[j] = Integer.parseInt(reader.next());
            }

            String fecha = reader.next();
            int nCorredores = Integer.parseInt(reader.next());
            int nHeridos = Integer.parseInt(reader.next());

            tmp[i] = new Carrera(nToros, velocidades, fecha, nCorredores, nHeridos);

        }
        return tmp;
    }

}