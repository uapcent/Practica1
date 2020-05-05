package controlador;

import modelo.clientes.Cliente;
import modelo.excepciones.ExcepcionClienteNoExiste;
import modelo.excepciones.ExcepcionIntervaloFechas;

import java.util.List;

public interface InterfazControlador {
    void nuevoCliente();

    void borrarCliente();

    void listarClientesTXT();

    void nuevaLlamada() throws ExcepcionClienteNoExiste;

    void emitirFactura() throws ExcepcionClienteNoExiste, ExcepcionIntervaloFechas;





}
