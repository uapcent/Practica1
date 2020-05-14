package controlador;

import modelo.GestorModelo;
import modelo.clientes.Cliente;
import modelo.datosCliente.Direccion;
import modelo.datosCliente.Llamadas;
import modelo.excepciones.ExcecpcionClienteYaExiste;
import modelo.excepciones.ExcepcionClienteNoExiste;
import modelo.excepciones.ExcepcionIntervaloFechas;
import modelo.tarifas.Tarifa;
import vista.InterfazVista;
import modelo.Fabricas.*;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class Controlador implements InterfazControlador {
    private InterfazVista vista;
    private GestorModelo modelo;

    public Controlador() {
    }

    public void setVista(InterfazVista vista) {
        this.vista = vista;
    }

    public void setModelo(GestorModelo modelo) {
        this.modelo = modelo;
    }


    @Override
    public void nuevoCliente() {
        String nombre = vista.getNombre();
        String apellidos = vista.getApellidos();
        String nif = vista.getNIFAñadirCliente();
        String poblacion = vista.getPoblación();
        String provincia = vista.getProvincia();
        int codigoPostal = vista.getCodigoPostal();
        Direccion direccion = new Direccion(codigoPostal, provincia, poblacion);
        String email = vista.getEmail();
        Calendar fecha = Calendar.getInstance();
        float precio = vista.getPrecio();
        FabricaClientes cliente = new FabricaClientes();
        FabricaTarifas tarifaFabrica = new FabricaTarifas();
        if (apellidos.equals("")) {
            try {
                Tarifa tarifa = tarifaFabrica.crearTarifaBásica(precio);
                modelo.darAltaCliente(cliente.crearEmpresa(nombre, nif, direccion, email, fecha, tarifa));
            } catch (ExcecpcionClienteYaExiste e) {
                e.printStackTrace();
            }
        } else {
            try {
                Tarifa tarifa = tarifaFabrica.crearTarifaBásica(precio);
                modelo.darAltaCliente(cliente.crearParticular(nombre, apellidos, nif, direccion, email, fecha, tarifa));
            } catch (ExcecpcionClienteYaExiste e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void borrarCliente() {
        try {
            String nif = vista.getNIFBorrar();
            modelo.borrar(nif);
        } catch (ExcepcionClienteNoExiste e) {
            e.printStackTrace();
        }

    }

    @Override
    public void listarClientesTXT() {
        modelo.listaClientesTXT();
    }

    public void listarLlamadasClientesTXT() throws ExcepcionClienteNoExiste {
        String nif = vista.getNifLlamada();
        modelo.listaLlamadasTXT(nif);
    }

//    public void listaFacturasClientesTXT() throws ExcepcionClienteNoExiste {
//        String nif = vista.getNIF();
//        modelo.listaFacturasTXT(nif);
//    }

    public void datosClienteTXT() {
        try {
            String nif = vista.getNifDatosCliente();
            System.out.println(nif);
            modelo.datosClienteTXT(nif);
        } catch (ExcepcionClienteNoExiste e) {
            e.printStackTrace();
        }
    }

    public void datosFacturaTXT() {
        try {
            String nif = vista.getNifDatosFactura();
            int codigo = vista.getCodigoFactura();
            modelo.datosFacturaTXT(nif, codigo);
        } catch (ExcepcionClienteNoExiste e) {
            e.printStackTrace();
        }
    }


    @Override
    public void nuevaTarifaDiaria() {
        try {
            String nif = vista.getNifTarDia();
            String dia = vista.getDiaTarDia();
            float precio = vista.getPrecioTarDia();
            Tarifa preTarifaCliente = modelo.buscarCliente(nif).getTarifa();
            FabricaTarifas tarifaFabrica = new FabricaTarifas();
            preTarifaCliente = tarifaFabrica.crearTarifaPorDías(preTarifaCliente, precio, dia);
            modelo.cambiarTarifa(nif, preTarifaCliente);
        } catch (ExcepcionClienteNoExiste e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nuevaTarifaBasica() {
        try {
            String nif = vista.getNifTarBas();
            float precio = vista.getPrecioTarBas();
            FabricaTarifas tarifaFabrica = new FabricaTarifas();
            Tarifa tarifa = tarifaFabrica.crearTarifaBásica(precio);
            modelo.cambiarTarifa(nif, tarifa);
        } catch (ExcepcionClienteNoExiste e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nuevaLlamada() {
       try {
            String nif = vista.getNifLlamada();
           String telefono = vista.getTelefono();
            int año = vista.getAnyoLlamada();
            int mes = vista.getMesLlamada();
            int dia = vista.getDiaLlamada();
            int hora = vista.getHoraLlamada();
            int minuto = vista.getMinutoLlamada();
            Calendar fechaLlamada = new Calendar.Builder().setDate(año, mes, dia).setTimeOfDay(hora,minuto, 0).build();
            int duracion = vista.getDuracionLlamada();
            Llamadas llamada = new Llamadas(telefono, fechaLlamada, duracion);
            modelo.darAltaLlamada(llamada, nif);
       }catch (ExcepcionClienteNoExiste e) {
            e.printStackTrace();
        }
   }

        @Override
        public void emitirFactura() {
            try {
                String nif = vista.getNifEmitFactura();
                int diaIni = vista.getDiaIniEmitFactura();
                int mesIni = vista.getMesIniEmitFactura();
                int anyoIni = vista.getAnyoIniEmitFactura();
                int diaFin = vista.getDiaFinEmitFactura();
                int mesFin = vista.getMesFinEmitFactura();
                int anyoFin = vista.getAnyoFinEmitFactura();
                Calendar fechaInicial = new Calendar.Builder().setDate(anyoIni, mesIni, diaIni).build();
                Calendar fechaFinal = new Calendar.Builder().setDate(anyoFin, mesFin, diaFin).build();
                modelo.emitirFactura(nif, fechaInicial, fechaFinal);
            } catch (ExcepcionClienteNoExiste e) {
                e.printStackTrace();
            } catch (ExcepcionIntervaloFechas e) {
                e.printStackTrace();
            }
        }
}


