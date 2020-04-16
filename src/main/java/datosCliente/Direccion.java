package datosCliente;

import java.io.Serializable;

public class Direccion implements Serializable {
    private int codPostal;
    private String provincia;
    private String poblacion;

    public Direccion(int codpos, String prov, String pob){
        codPostal = codpos;
        provincia = prov;
        poblacion = pob;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setDireccion(int codPostal, String provincia, String poblacion) {
        this.codPostal = codPostal;
        this.provincia = provincia;
        this.poblacion = poblacion;

    }
}
