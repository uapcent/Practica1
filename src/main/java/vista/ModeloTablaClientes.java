package vista;

import modelo.clientes.Cliente;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


public class ModeloTablaClientes extends AbstractTableModel {
    final List<String> cabeceras = Arrays.asList("Nombre", "Apellidos", "NIF","Dirección", "E-mail","Fecha añdido", "Tarifa" );
    List<Cliente> datos;

    public ModeloTablaClientes(final List<Cliente> datos) {
        this.datos = datos;
    }

    public ModeloTablaClientes setDatos(final List<Cliente> datos) {
        this.datos = datos;
        return this;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return cabeceras.size();
    }

    @Override
    public String getValueAt(int fila, int columna) {
        if (columna == 0) return datos.get(fila).getNombre();
        if (columna == 1) return datos.get(fila).getApellidos();
        if (columna == 2) return datos.get(fila).getNif();
        if (columna == 3) return datos.get(fila).getDireccion().toString();
        if (columna == 4) return datos.get(fila).getEmail();
        if (columna == 5) return datos.get(fila).getFecha().getTime().toString();
        if (columna == 6) return datos.get(fila).getTarifa().descripcion();
        else {
            return "";
        }
    }

    public String getColumnName(int column) {
        return cabeceras.get(column);
    }
}
