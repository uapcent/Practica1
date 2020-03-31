package clientes;
import datosCliente.Direccion;
import datosCliente.Tarifa;
import java.util.Calendar;

public class Salir extends Cliente {
    public Salir(String nombre, String nif, Direccion dir, String email, Calendar fecha, Tarifa tarifa) {
        super(nombre, nif, dir, email, fecha, tarifa);
    }
}
