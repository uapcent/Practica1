import java.util.Calendar;
import java.util.List;

public class Empresa extends Cliente{

    public Empresa(String nombre,String nif,Direccion dir,String email, Calendar fecha, Tarifa tarifa, List<Facturas> facturas, List<Llamadas> llamadas){
        super(nombre, nif, dir, email, fecha, tarifa, facturas,llamadas);

    }

}
