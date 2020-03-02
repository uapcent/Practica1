import java.util.Calendar;

public class Llamadas{
    private String telefono;
    private Calendar fecha;
    private int duracion;

    public Llamadas(String telefono, Calendar fecha, int duracion) {
        this.telefono = telefono;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public String getTelefono() {
        return telefono;
    }

    public Calendar getFecha(){
        return fecha;
    }

    public int getDuracion() {
        return duracion;
    }

}
