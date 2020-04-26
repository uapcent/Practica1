package modelo.clientes;
import modelo.datosCliente.Direccion;
import modelo.tarifas.Tarifa;

import java.io.Serializable;
import java.util.Calendar;

public class Salir extends Cliente implements Serializable {
    public Salir(String nombre, String nif, Direccion dir, String email, Calendar fecha, Tarifa tarifa) {
        super(nombre, nif, dir, email, fecha, tarifa);
    }
}
