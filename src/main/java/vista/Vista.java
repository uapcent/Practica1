package vista;

import controlador.InterfazControlador;
import modelo.GestorModelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vista implements InterfazVista {
    private InterfazControlador controlador;
    private GestorModelo modelo;
    private Container container;

    //Atributos para añadir cliente
    private JTextField jtfNombre;
    private JTextField jtfApellidos;
    private JTextField jtfNifAñadirCliente;
    private JTextField jtfEmail;
    private JTextField jtfPoblacion;
    private JTextField jtfProvincia;
    private JTextField jtfCodigoPostal;
    private JTextField jtfPrecioTarifa;

    //Atributos para Borrar Cliente
    private JTextField jtfNifBorrar;

    //Atributos para obtener datos de un cliente
    private JTextField jtfNifCliDat;


    //Atributos añadir llamada
    private JTextField jtfNifLlam;
    private JTextField jtfMinutoLlam;
    private JTextField jtfHoraLlam;
    private JTextField jtfDiaLlam;
    private JTextField jtfMesLlam;
    private JTextField jtfAnyoLlam;
    private JTextField jtfTelefono;
    private JTextField jtfDuracion;

    //Atributos emitir factura
    private JTextField jtfNifEFac;
    private JTextField jtfDiaEFac;
    private JTextField jtfMesEFac;
    private JTextField jtfAnyoEfac;
    private  JTextField jtfDiaFinEfac;
    private  JTextField jtfMesFinEfac;
    private  JTextField jtfAnyoFinEfac;

    //Atributos Datos Factura
    private JTextField jtfNifDatFac;
    private JTextField jtfCodigoFactura;

    //Atributos Modificar Tarifa Básica
    private JTextField jtfNifTarBas;
    private JTextField jtfPrecioTarBas;

    //Atributos Modificar Tarifa Diaria
    private JTextField jtfNifTarDia;
    private JTextField jtfDiaTarDia;
    private JTextField jtfPrecioTarDia;

    //Atributos mostrar informacion
    private JTextArea jtaInfo;



    public Vista() {
       pestanyas();
   }

    public void setControlador(InterfazControlador controlador) {
        this.controlador = controlador;
    }

    public void setModelo(GestorModelo modelo) {
        this.modelo = modelo;
    }

    private void pestanyas() {
        JFrame ventana = new JFrame("Aplicación telefonía");
        JTabbedPane pestanyas = new JTabbedPane();
        pestanyas.add("Añadir cliente", panelAñadirCliente());
        pestanyas.add("Borrar cliente", panelBorrarCliente());
        pestanyas.add("Datos cliente", panelDatosDeUnCliente());
        //pestanyas.add("Lista clientes", panelListaClientes());
        pestanyas.add("Añadir lLamada", panelAñadirLlamada());
       // pestanyas.add("Lista llamadas", panelListaLlamadasCliente());
        //pestanyas.add("Emitir Factura", panelEmitirFactura());
        pestanyas.add("Datos factura", panelDatosDeUnaFactura());
        //pestanyas.add("Lista facturas", panelListaFacturas());
        pestanyas.add("Tarifa Dias", panelTarifaPorDías());
        pestanyas.add("Tarifa Basica", panelTarifaBásica());
        JButton jbLimpiarInfo = new JButton("Limpia");
        jbLimpiarInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaInfo.setText("");
            }
        });
        ventana.getContentPane().add(pestanyas, BorderLayout.NORTH);
        ventana.getContentPane().add(jbLimpiarInfo, BorderLayout.EAST);
        ventana.getContentPane().add(panelInformacion());
        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }


    //Panel Añadir cliente
    private JPanel panelAñadirCliente() {
        jtfNombre = new JTextField(10);
        jtfApellidos = new JTextField(10);
        jtfNifAñadirCliente = new JTextField(10);
        jtfEmail = new JTextField(10);
        jtfPoblacion = new JTextField(10);
        jtfProvincia = new JTextField(10);
        jtfCodigoPostal = new JTextField(10);
        jtfPrecioTarifa = new JTextField(10);
        JButton jbNuevoCliente = new JButton("Nuevo cliente");
        jbNuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.nuevoCliente();
            }
        });

        JPanel jpAnyadirCliente = new JPanel();

        jpAnyadirCliente.add(new JLabel("Nombre: "));
        jpAnyadirCliente.add(jtfNombre);
        jpAnyadirCliente.add(new JLabel("Apellidos: "));
        jpAnyadirCliente.add(jtfApellidos);
        jpAnyadirCliente.add(new JLabel("NIF: "));
        jpAnyadirCliente.add(jtfNifAñadirCliente);
        jpAnyadirCliente.add(new JLabel("E-mail: "));
        jpAnyadirCliente.add(jtfEmail);
        jpAnyadirCliente.add(new JLabel("Población: "));
        jpAnyadirCliente.add(jtfPoblacion);
        jpAnyadirCliente.add(new JLabel("Provincia: "));
        jpAnyadirCliente.add(jtfProvincia);
        jpAnyadirCliente.add(new JLabel("Código Postal: "));
        jpAnyadirCliente.add(jtfCodigoPostal);
        jpAnyadirCliente.add(new JLabel("Precio de Tarifa: "));
        jpAnyadirCliente.add(jtfPrecioTarifa);
        jpAnyadirCliente.add(jbNuevoCliente);
        return jpAnyadirCliente;
    }

    private JPanel panelBorrarCliente() {
        jtfNifBorrar = new JTextField(10);
        JButton jbBorrarCliente = new JButton("Borrar cliente");
        jbBorrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.borrarCliente();
            }
        });
        JPanel  jpBorrarCliente = new JPanel();
        jpBorrarCliente.add(new JLabel("NIF: "));
        jpBorrarCliente.add(jtfNifBorrar);
        jpBorrarCliente.add(jbBorrarCliente);
        return jpBorrarCliente;
    }

    private JPanel panelDatosDeUnCliente() {
        jtfNifCliDat = new JTextField(10);
        JButton jbObtenerDatosCliente = new JButton("Obtener datos del cliente");
        jbObtenerDatosCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    controlador.datosClienteTXT();
            }
        });

        JPanel jpDatosCliente = new JPanel();
        jpDatosCliente.add(new JLabel("NIF: "));
        jpDatosCliente.add(jtfNifCliDat);
        jpDatosCliente.add(jbObtenerDatosCliente);
        return jpDatosCliente;
    }

    private JPanel panelListaClientes() {
        ModeloTablaClientes modeloTablaClientes = new ModeloTablaClientes(modelo.devolverLista());
        TablaClientes tablaClientes = new TablaClientes(modeloTablaClientes);
        JButton jbActualizarTabla = new JButton("Actualiza la tabla");
        jbActualizarTabla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              tablaClientes.setModel(new ModeloTablaClientes(modelo.devolverLista()));
            }
        });
        JPanel jpListaClientes = new JPanel();
        jpListaClientes.add(tablaClientes);
        jpListaClientes.add(jbActualizarTabla);
        return  jpListaClientes;
    }

    private JPanel panelAñadirLlamada() {
        jtfNifLlam = new JTextField(10);
        jtfTelefono = new JTextField(10);
        jtfDiaLlam = new JTextField(10);
        jtfMesLlam = new JTextField(10);
        jtfAnyoLlam = new JTextField(10);
        jtfHoraLlam = new JTextField(10);
        jtfMinutoLlam = new JTextField(10);
        jtfDuracion = new JTextField(10);

        JButton jbAñadirLlamada = new JButton("Añadir llamada");
        jbAñadirLlamada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.nuevaLlamada();
            }
        });

        JPanel jpAñadirLlamada = new JPanel();
        jpAñadirLlamada.add(new JLabel("NIF: "));
        jpAñadirLlamada.add(jtfNifLlam);
        jpAñadirLlamada.add(new JLabel("Teléfono: "));
        jpAñadirLlamada.add(jtfTelefono);
        jpAñadirLlamada.add(new JLabel("Duracion (en minutos): "));
        jpAñadirLlamada.add(jtfDuracion);
        jpAñadirLlamada.add(new JLabel("Día (0-31): "));
        jpAñadirLlamada.add(jtfDiaLlam);
        jpAñadirLlamada.add(new JLabel("Mes (1-12): "));
        jpAñadirLlamada.add(jtfMesLlam);
        jpAñadirLlamada.add(new JLabel("Año (Actual o inferior): "));
        jpAñadirLlamada.add(jtfAnyoLlam);
        jpAñadirLlamada.add(new JLabel("Hora: "));
        jpAñadirLlamada.add(jtfHoraLlam);
        jpAñadirLlamada.add(new JLabel("Minuto: "));
        jpAñadirLlamada.add(jtfMinutoLlam);
        jpAñadirLlamada.add(jbAñadirLlamada);
        return jpAñadirLlamada;
    }


//    private JPanel panelListaLlamadasCliente() {
//        jtfNif = new JTextField(10);
//        JButton jbListarLlamadas = new JButton("Lista las llamadas");
//        JPanel jpListaLlamadas = new JPanel();
//        jpListaLlamadas.add(new JLabel("NIF: "));
//        jpListaLlamadas.add(jtfNif);
//        jpListaLlamadas.add(jbListarLlamadas);
//        return jpListaLlamadas;
//    }

    private JPanel panelEmitirFactura() {
        jtfNifEFac = new JTextField(10);
        jtfDiaEFac = new JTextField(10);
        jtfMesEFac = new JTextField(10);
        jtfAnyoEfac = new JTextField(10);
        jtfDiaFinEfac = new JTextField(10);
        jtfMesFinEfac = new JTextField(10);
        jtfAnyoFinEfac = new JTextField(10);

        JButton jbEmitirFactura = new JButton("Emite factura");
        jbEmitirFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.emitirFactura();
            }
        });

        JPanel jpEmitirFactura = new JPanel();
        jpEmitirFactura.add(new JLabel("NIF: "));
        jpEmitirFactura.add(jtfNifEFac);
        jpEmitirFactura.add(new JLabel("Dia inicial: "));
        jpEmitirFactura.add(jtfDiaEFac);
        jpEmitirFactura.add(new JLabel("Mes inicial: "));
        jpEmitirFactura.add(jtfMesEFac);
        jpEmitirFactura.add(new JLabel("Año inicial: "));
        jpEmitirFactura.add(jtfAnyoEfac);
        jpEmitirFactura.add(new JLabel("Dia final: "));
        jpEmitirFactura.add(jtfDiaFinEfac);
        jpEmitirFactura.add(new JLabel("Mes final: "));
        jpEmitirFactura.add(jtfMesFinEfac);
        jpEmitirFactura.add(new JLabel("Año final: "));
        jpEmitirFactura.add(jtfAnyoFinEfac);
        jpEmitirFactura.add(jbEmitirFactura);
        return jpEmitirFactura;
    }

    private JPanel panelDatosDeUnaFactura() {
        jtfNifDatFac = new JTextField(10);
        jtfCodigoFactura = new JTextField(10);
        JButton jbObtenerDatosCliente = new JButton("Obtener datos factura");
        jbObtenerDatosCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.datosFacturaTXT();
            }
        });

        JPanel jpDatosFactura = new JPanel();
        jpDatosFactura.add(new JLabel("NIF: "));
        jpDatosFactura.add(jtfNifDatFac);
        jpDatosFactura.add(new JLabel("Codigo factura: "));
        jpDatosFactura.add(jtfCodigoFactura);
        jpDatosFactura.add(jbObtenerDatosCliente);
        return jpDatosFactura;
    }

//    private JPanel panelListaFacturas() {
//        jtfNif = new JTextField(10);
//        JButton jbListaFacturas = new JButton("Lista las facturas");
//        JPanel jpListaFacturas = new JPanel();
//        jpListaFacturas.add(new JLabel("NIF: "));
//        jpListaFacturas.add(jtfNif);
//        jpListaFacturas.add(jbListaFacturas);
//        return jpListaFacturas;
//    }


    private JScrollPane panelInformacion() {
        jtaInfo = new JTextArea(20, 50);
        JScrollPane jspMostrarInfo = new JScrollPane(jtaInfo);
        jspMostrarInfo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jspMostrarInfo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        return jspMostrarInfo;

    }

    private JPanel panelTarifaPorDías() {
        jtfNifTarDia = new JTextField(10);
        jtfDiaTarDia = new JTextField(10);
        jtfPrecioTarDia = new JTextField(10);
        JButton jbTarifaDias = new JButton("Modificar tarifa");
        jbTarifaDias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.nuevaTarifaDiaria();
            }
        });

        JPanel jpTarifaDias =  new JPanel();
        jpTarifaDias.add(new JLabel("NIF: "));
        jpTarifaDias.add(jtfNifTarDia);
        jpTarifaDias.add(new JLabel("Dia (en letra): "));
        jpTarifaDias.add(jtfDiaTarDia);
        jpTarifaDias.add(new JLabel ("Precio Tarifa Diaría: "));
        jpTarifaDias.add(jtfPrecioTarDia);
        jpTarifaDias.add(jbTarifaDias);
        return jpTarifaDias;

    }

    private JPanel panelTarifaBásica() {
        jtfNifTarBas = new JTextField(10);
        jtfPrecioTarBas = new JTextField(10);
        JButton jbTarifaBasica = new JButton("Modificar Tarifa");
        jbTarifaBasica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.nuevaTarifaBasica();
            }
        });

        JPanel jpTarifaBasica = new JPanel();
        jpTarifaBasica.add(new JLabel("NIF: "));
        jpTarifaBasica.add(jtfNifTarBas);
        jpTarifaBasica.add(new JLabel("Precio Tarifa: "));
        jpTarifaBasica.add(jtfPrecioTarBas);
        jpTarifaBasica.add(jbTarifaBasica);
        return jpTarifaBasica;
    }




    @Override
    public String getNombre() {
        return jtfNombre.getText();
    }

    @Override
    public String getApellidos() {
        return jtfApellidos.getText();
    }

    @Override
    public String getNIFAñadirCliente() {
        return jtfNifAñadirCliente.getText();
    }

    @Override
    public String getPoblación() {
        return jtfPoblacion.getText();
    }

    @Override
    public String getProvincia() {
        return jtfProvincia.getText();
    }

    @Override
    public int getCodigoPostal() {
        int numero = Integer.parseInt(jtfCodigoPostal.getText());
        return numero;
    }

    @Override
    public String getEmail() {
        return jtfEmail.getText();
    }

    @Override
    public float getPrecio() {
        float numero = Float.parseFloat(jtfPrecioTarifa.getText());
        return numero;
    }

    @Override
    public String getNIFBorrar() {
        return jtfNifBorrar.getText();
    }

    @Override
    public String getNifDatosCliente() {
        return jtfNifCliDat.getText();
    }

    @Override
    public String getNifLlamada() {
        return jtfNifLlam.getText();
    }

    @Override
    public String getTelefono() {
        return jtfTelefono.getText();
    }

    @Override
    public int getMinutoLlamada() {
        int minuto = Integer.parseInt(jtfMinutoLlam.getText());
        return minuto;
    }

    @Override
    public int getHoraLlamada() {
        int hora = Integer.parseInt(jtfHoraLlam.getText());
        return hora;
    }

    @Override
    public int getDiaLlamada() {
        int dia = Integer.parseInt(jtfDiaLlam.getText());
        return dia;
    }

    @Override
    public int getMesLlamada() {
        int mes = Integer.parseInt(jtfMesLlam.getText());
        return mes;
    }

    @Override
    public int getAnyoLlamada() {
        int anyo = Integer.parseInt(jtfAnyoLlam.getText());
        return anyo;
    }

    @Override
    public int getDuracionLlamada() {
        int duracion = Integer.parseInt(jtfDuracion.getText());
        return duracion;
    }

    @Override
    public String getNifEmitFactura() {
        return jtfNifEFac.getText();
    }

    @Override
    public int getDiaIniEmitFactura() {
        int dia = Integer.parseInt(jtfDiaEFac.getText());
        return dia;
    }

    @Override
    public int getMesIniEmitFactura() {
        int mes = Integer.parseInt(jtfMesEFac.getText());
        return mes;    }

    @Override
    public int getAnyoIniEmitFactura() {
        int anyo = Integer.parseInt(jtfAnyoEfac.getText());
        return anyo;
    }

    @Override
    public int getDiaFinEmitFactura() {
        int dia = Integer.parseInt(jtfDiaFinEfac.getText());
        return dia;
    }

    @Override
    public int getMesFinEmitFactura() {
        int mes = Integer.parseInt(jtfMesFinEfac.getText());
        return mes;
    }

    @Override
    public int getAnyoFinEmitFactura() {
        int anyo = Integer.parseInt(jtfAnyoFinEfac.getText());
        return anyo;
    }

    @Override
    public String getNifDatosFactura() {
        return jtfNifDatFac.getText();
    }

    @Override
    public int getCodigoFactura() {
        int numero = Integer.parseInt(jtfCodigoFactura.getText());
        return numero;
    }

    @Override
    public String getNifTarBas() {
        return jtfNifTarBas.getText();
    }

    @Override
    public float getPrecioTarBas() {
        float numero = Float.parseFloat(jtfPrecioTarBas.getText());
        return numero;
    }

    @Override
    public String getNifTarDia() {
        return jtfNifTarDia.getText();
    }

    @Override
    public String getDiaTarDia() {
        return jtfDiaTarDia.getText();
    }

    @Override
    public float getPrecioTarDia() {
        float numero = Float.parseFloat(jtfPrecioTarDia.getText());
        return numero;
    }


    @Override
    public void getDescripcion() {
        jtaInfo.append(modelo.getDescriptor() + "\n");

    }

}
