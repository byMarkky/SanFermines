import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;

public class Carrera {

    private int nToros;
    private int[] velocidades;
    private LocalDate fecha;
    private String fechaString;
    private int corredores;
    private int nHeridos;

    Carrera() {}

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Carrera(int nToros, int[] velocidades, String fecha, int corredores, int nHeridos) {
        this.nToros = nToros;
        this.velocidades = velocidades;
        //this.fechaString = fecha;
        try {
            this.fecha = parseFecha(fecha);
        } catch (ParseException pe) {
            System.out.println(pe);
        }
        this.corredores = corredores;
        this.nHeridos = nHeridos;
    }

    public String mostrarHeridos() {
        if (this.nHeridos <= 5) {
            return this.nHeridos + " Pocos heridos";
        } else if (this.nHeridos <= 10) {
            return this.nHeridos + " Algunos heridos";
        } else {
            return this.nHeridos + " Muchos heridos";
        }
    }

    // ### Obtener la velocidad maxima de una carrera ###
    public int getMaximaVelocidad() {
        int[] vels = this.velocidades;
        Arrays.sort(vels);
        return vels[vels.length - 1];
    }

    // Mostrar todos los datos de una carrera
    public static void mostrarDatosCarrera(Carrera carrera) {
        System.out.println("Numero de Toros: " + carrera.getnToros() +
                "\nVelocidades: " + Arrays.toString(carrera.getVelocidades()) +
                "\nFecha carrera: " + carrera.getFecha() +
                "\nNumero de corredores: " + carrera.getCorredores() +
                "\nNumero de heridos: " + carrera.getnHeridos() +
                "\nVelocidad maxima de la carrera: " + carrera.getMaximaVelocidad());
    }

    public static void mostrarDatosCarreras(Carrera[] carreras) {
        for (int i = 0; i < carreras.length; i++) {
            System.out.println("-------------------");
            Carrera.mostrarDatosCarrera(carreras[i]);
        }
        System.out.println("-------------------");
    }

    // Class Methods

    private LocalDate parseFecha(String fecha) throws ParseException {
        String[] data = fecha.split("-");
        int[] dataParsed = {
                Integer.parseInt(data[0]),
                Integer.parseInt(data[1]),
                Integer.parseInt(data[2])};
        return LocalDate.of(dataParsed[2], dataParsed[1], dataParsed[0]);
    }

    public int getnToros() {
        return nToros;
    }

    public int[] getVelocidades() {
        return velocidades;
    }

    public int getCorredores() {
        return corredores;
    }

    // ### Funcion para los heridos ###
    public String getnHeridos() {
        if (this.nHeridos <= 5) {
            return this.nHeridos + " Pocos heridos";
        } else if (this.nHeridos <= 10) {
            return this.nHeridos + " Algunos heridos";
        } else {
            return this.nHeridos + " Muchos heridos";
        }
    }

    public String toString() {
        return "Carrera{" +
                "nToros=" + nToros +
                ", velocidades=" + Arrays.toString(velocidades) +
                ", fecha=" + fecha +
                ", corredores=" + corredores +
                ", nHeridos=" + nHeridos +
                '}';
    }
}
