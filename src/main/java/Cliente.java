import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

public class Cliente {

    //Constructor
    private String nombre;
    private String nif;
    private Direccion direccion;
    private String email;
    private Calendar fechaAlta;
    private Tarifa tarifa;
    private List<Facturas> listaFacturas;
    private List<Llamadas> listaLlamadas;

    public Cliente(String nombre,String nif,Direccion dir,String email, Calendar fecha, Tarifa tarifa){
        this.nombre = nombre;
        this.nif=nif;
        this.direccion=dir;
        this.email=email;
        this.fechaAlta=fecha;
        this.tarifa=tarifa;
    }



    public String getNombre() {
        return nombre;
    }

    public String getNif() {
        return nif;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }
    //GetFecha
    public Calendar getFecha(){
        return fechaAlta;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public List<Facturas> getListaFacturas() {
        return listaFacturas;
    }

    public List<Llamadas> getListaLlamadas() {
        return listaLlamadas;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

}
