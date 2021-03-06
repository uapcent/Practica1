package modelo.datosCliente;

import java.io.Serializable;
import java.util.Calendar;

public class Llamadas implements Fecha, Serializable {
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

    public String toString(){
        return "Teléfono: " + getTelefono() + "\n" +
                "Fecha: " + getFecha().getTime() + "\n" +
                "Duración: " + getDuracion() + "\n";
    }

}
