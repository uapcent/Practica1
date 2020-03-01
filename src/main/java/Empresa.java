import java.util.Calendar;
import java.util.List;

public class Empresa extends Cliente{

    public Empresa(String nombre,String nif,Direccion dir,String email, Calendar fecha, Tarifa tarifa){
        super(nombre, nif, dir, email, fecha, tarifa);

    }

}
