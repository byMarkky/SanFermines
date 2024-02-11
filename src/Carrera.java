import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;

public class Carrera {
        /*
        --- METODOS OBLIGATORIOS ---
        Obtener y mostrar la velocidad maxima de una carrera
        Mostra el mensaje de cuantos heridos hay
        Mostrar todos los datos de una carrera
        TODO: Mostrar todos los datos de las carreras
         */

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

    private LocalDate parseFecha(String fecha) throws ParseException {
        String[] data = fecha.split("-");
        int[] dataParsed = {
                Integer.parseInt(data[0]),
                Integer.parseInt(data[1]),
                Integer.parseInt(data[2])};
        return LocalDate.of(dataParsed[2], dataParsed[1], dataParsed[0]);
    }

    public void mostrarHeridos() {
        System.out.println("Heridos: " + this.nHeridos);
    }

    public int getMaximaVelocidad() {
        int[] vels = this.velocidades;
        int v_max = vels[vels.length - 1];
        Arrays.sort(vels);
        System.out.println("Velocidad maxima: " + v_max);
        return v_max;
    }

    // Class Methods

    public int getnToros() {
        return nToros;
    }

    public void setnToros(int nToros) {
        this.nToros = nToros;
    }

    public int[] getVelocidades() {
        return velocidades;
    }

    public void setVelocidades(int[] velocidades) {
        this.velocidades = velocidades;
    }

    public int getCorredores() {
        return corredores;
    }

    public void setCorredores(int corredores) {
        this.corredores = corredores;
    }

    public int getnHeridos() {
        return nHeridos;
    }

    public void setnHeridos(int nHeridos) {
        this.nHeridos = nHeridos;
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
