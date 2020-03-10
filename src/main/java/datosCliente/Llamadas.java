package datosCliente;

import java.util.Calendar;

public class Llamadas implements Fecha {
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

    @Override
    public Calendar getFecha(){
        return fecha;
    }

    public int getDuracion() {
        return duracion;
    }

}
