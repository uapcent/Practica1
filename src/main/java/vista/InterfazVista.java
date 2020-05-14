package vista;

public interface InterfazVista {
    //Gets para añadir cliente
    String getNombre();
    String getApellidos();
    String getNIFAñadirCliente();
    String getPoblación();
    String getProvincia();
    int getCodigoPostal();
    String getEmail();
    float getPrecio();

    //Gets para borrar cliente
    String getNIFBorrar();

    //Gets para obtener datos de un cliente
    String getNifDatosCliente();

    //Gets para añadir llamada.
    String  getNifLlamada();
    String getTelefono();
    int getMinutoLlamada();
    int getHoraLlamada();
    int getDiaLlamada();
    int getMesLlamada();
    int getAnyoLlamada();
    int getDuracionLlamada();

    //Gets para la lista de llamadas
    String getNifListaLlamadas();

    //Gets para emitir factura
    String getNifEmitFactura();
    int getDiaIniEmitFactura();
    int getMesIniEmitFactura();
    int getAnyoIniEmitFactura();
    int getDiaFinEmitFactura();
    int getMesFinEmitFactura();
    int getAnyoFinEmitFactura();

    //Gets para la lista de facturas
    String getNifListaFacturas();

    //Gets para datos de factura
    String getNifDatosFactura();
    int getCodigoFactura();

    //Gets para modificar Tarifa Básica
    String getNifTarBas();
    float getPrecioTarBas();


    //Gets para modificar la Tarifa Diaria.
    String getNifTarDia();
    String getDiaTarDia();
    float getPrecioTarDia();

    //Gets para modificar la Tarifa por horas
    String getNifTarHor();
    int getHoraIniTarHor();
    int getHoraFinTarHor();
    float getPrecioTarHora();

    //Para pasar los datos a cadena.
    void getDescripcion();
}
