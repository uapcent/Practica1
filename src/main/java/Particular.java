import java.util.Calendar;
import java.util.List;

public class Particular extends Cliente {

    private String apellidos;

    private List<Facturas> listaFacturas;

    public Particular(String nombre,String apellidos,String nif,Direccion dir,String email, Calendar fecha, Tarifa tarifa){
        super(nombre, nif, dir, email, fecha, tarifa);
        this.apellidos = apellidos;

    }

    public String getApellidos() {
        return apellidos;
    }

}
