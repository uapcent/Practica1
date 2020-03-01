import java.util.Calendar;
import java.util.List;

public class Particular extends Cliente {

    private String apellidos;

    public Particular(String nombre,String apellidos,String nif,Direccion dir,String email, Calendar fecha, Tarifa tarifa, List<Facturas> facturas, List<Llamadas> llamadas){
        super(nombre, nif, dir, email, fecha, tarifa, facturas, llamadas);
        this.apellidos = apellidos;

    }

    public String getApellidos() {
        return apellidos;
    }

}
