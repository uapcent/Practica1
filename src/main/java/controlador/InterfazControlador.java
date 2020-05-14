package controlador;

import modelo.clientes.Cliente;
import modelo.excepciones.ExcepcionClienteNoExiste;
import modelo.excepciones.ExcepcionIntervaloFechas;

import java.util.List;

public interface InterfazControlador {

    void nuevoCliente();

    void borrarCliente();

    void datosClienteTXT();

    void listarClientesTXT();

    void nuevaLlamada();

    void listarLlamadasClientesTXT();

    void emitirFactura();

    void datosFacturaTXT();

    void listarFacturasClientesTXT();

    void nuevaTarifaDiaria();

    void nuevaTarifaBasica();

    void nuevaTarifaProHoras();






}
