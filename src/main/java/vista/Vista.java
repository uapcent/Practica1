package vista;

import controlador.InterfazControlador;
import modelo.GestorModelo;
import modelo.clientes.Cliente;
import modelo.excepciones.ExcepcionClienteNoExiste;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vista implements InterfazVista {
    private InterfazControlador controlador;
    private GestorModelo modelo;
    private Container container;
    private JTextField jtfNombre;
    private JTextField jtfApellidos;
    private JTextField jtfNif;
    private JTextField jtfEmail;
    private JTextField jtfPoblacion;
    private JTextField jtfProvincia;
    private JTextField jtfCodigoPostal;
    private JTextField jtfPrecioTarifa;
    private JTextField jtfCodigoFactura;
    private JTextField jtfMinuto;
    private JTextField jtfHora;
    private JTextField jtfDia;
    private JTextField jtfMes;
    private JTextField jtfAnyo;
    private JTextField jtfDiaSemana;
    private JTextField jtfTelefono;
    private JTextField jtfDuracion;
    private  JTextField jtfDiaFin;
    private  JTextField jtfMesFin;
    private  JTextField jtfAnyoFin;
    private JTextField jtfDiaDeLaSemana;
    private JTextArea jtaInfo;
    private JTextField jtfPrecioTatifaDiaría;


    public Vista() {
       pestanyas();
   }

    public void setControlador(InterfazControlador controlador) {
        this.controlador = controlador;
    }

    public void setModelo(GestorModelo modelo) {
        this.modelo = modelo;
    }

    private void pestanyasCliente() {
        JFrame ventana = new JFrame("Aplicación telefonía");
        JTabbedPane pestanyas = new JTabbedPane();
        pestanyas.add("Añadir cliente", panelAñadirCliente());
        pestanyas.add("Borrar cliente", panelBorrarCliente());
        pestanyas.add("Datos cliente", panelDatosDeUnCliente());
        //pestanyas.add("Lista clientes", panelListaClientes());
        pestanyas.add("Añadir lLamada", panelAñadirLlamada());
        pestanyas.add("Lista llamadas", panelListaLlamadasCliente());
       // pestanyas.add("Emitir Factura", panelEmitirFactura());
        pestanyas.add("Datos factura", panelDatosDeUnaFactura());
        pestanyas.add("Lista facturas", panelListaFacturas());
        pestanyas.add("Tarifa Diaria", panelTarifaPorDías());
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

    private void pestanyas() {
        JFrame ventana = new JFrame("Aplicación telefonía");
        JTabbedPane pestanyas = new JTabbedPane();
        pestanyas.add("Añadir cliente", panelAñadirCliente());
        pestanyas.add("Borrar cliente", panelBorrarCliente());
        pestanyas.add("Datos cliente", panelDatosDeUnCliente());
        //pestanyas.add("Lista clientes", panelListaClientes());
        pestanyas.add("Añadir lLamada", panelAñadirLlamada());
        pestanyas.add("Lista llamadas", panelListaLlamadasCliente());
        pestanyas.add("Emitir Factura", panelEmitirFactura());
        pestanyas.add("Datos factura", panelDatosDeUnaFactura());
        pestanyas.add("Lista facturas", panelListaFacturas());
        pestanyas.add("Añadir tarifa dias", panelAñadirTarifaDias());
        pestanyas.add("Añadir tarifa horas", panelAñadirTarifaHoras());
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
        jtfNif = new JTextField(10);
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
        jpAnyadirCliente.add(jtfNif);
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
        jtfNif = new JTextField(10);
        JButton jbBorrarCliente = new JButton("Borrar cliente");
        jbBorrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.borrarCliente();
            }
        });
        JPanel  jpBorrarCliente = new JPanel();
        jpBorrarCliente.add(new JLabel("NIF: "));
        jpBorrarCliente.add(jtfNif);
        jpBorrarCliente.add(jbBorrarCliente);
        return jpBorrarCliente;
    }

    private JPanel panelDatosDeUnCliente() {
        jtfNif = new JTextField(10);
        JButton jbObtenerDatosCliente = new JButton("Obtener datos del cliente");
        jbObtenerDatosCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    controlador.datosClienteTXT();
            }
        });

        JPanel jpDatosCliente = new JPanel();
        jpDatosCliente.add(new JLabel("NIF: "));
        jpDatosCliente.add(jtfNif);
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
        jtfNif = new JTextField(10);
        jtfTelefono = new JTextField(10);
        jtfDia = new JTextField(10);
        jtfMes = new JTextField(10);
        jtfAnyo = new JTextField(10);
        jtfHora = new JTextField(10);
        jtfMinuto = new JTextField(10);
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
        jpAñadirLlamada.add(jtfNif);
        jpAñadirLlamada.add(new JLabel("Teléfono: "));
        jpAñadirLlamada.add(jtfTelefono);
        jpAñadirLlamada.add(new JLabel("Duracion (en minutos): "));
        jpAñadirLlamada.add(jtfDuracion);
        jpAñadirLlamada.add(new JLabel("Día (0-31): "));
        jpAñadirLlamada.add(jtfDia);
        jpAñadirLlamada.add(new JLabel("Mes (1-12): "));
        jpAñadirLlamada.add(jtfMes);
        jpAñadirLlamada.add(new JLabel("Año (Actual o inferior): "));
        jpAñadirLlamada.add(jtfAnyo);
        jpAñadirLlamada.add(new JLabel("Hora: "));
        jpAñadirLlamada.add(jtfHora);
        jpAñadirLlamada.add(new JLabel("Minuto: "));
        jpAñadirLlamada.add(jtfMinuto);
        jpAñadirLlamada.add(jbAñadirLlamada);
        return jpAñadirLlamada;
    }


    private JPanel panelListaLlamadasCliente() {
        jtfNif = new JTextField(10);
        JButton jbListarLlamadas = new JButton("Lista las llamadas");
        JPanel jpListaLlamadas = new JPanel();
        jpListaLlamadas.add(new JLabel("NIF: "));
        jpListaLlamadas.add(jtfNif);
        jpListaLlamadas.add(jbListarLlamadas);
        return jpListaLlamadas;
    }

    private JPanel panelEmitirFactura() {
        jtfNif = new JTextField(10);
        jtfDia = new JTextField(10);
        jtfMes = new JTextField(10);
        jtfAnyo = new JTextField(10);
        jtfDiaFin = new JTextField(10);
        jtfMesFin = new JTextField(10);
        jtfAnyoFin = new JTextField(10);

        JButton jbEmitirFactura = new JButton("Emite factura");
        jbEmitirFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.emitirFactura();
            }
        });

        JPanel jpEmitirFactura = new JPanel();
        jpEmitirFactura.add(new JLabel("NIF: "));
        jpEmitirFactura.add(jtfNif);
        jpEmitirFactura.add(new JLabel("Dia inicial: "));
        jpEmitirFactura.add(jtfDia);
        jpEmitirFactura.add(new JLabel("Mes inicial: "));
        jpEmitirFactura.add(jtfMes);
        jpEmitirFactura.add(new JLabel("Año inicial: "));
        jpEmitirFactura.add(jtfAnyo);
        jpEmitirFactura.add(new JLabel("Dia final: "));
        jpEmitirFactura.add(jtfDiaFin);
        jpEmitirFactura.add(new JLabel("Mes final: "));
        jpEmitirFactura.add(jtfMesFin);
        jpEmitirFactura.add(new JLabel("Año final: "));
        jpEmitirFactura.add(jtfAnyoFin);
        jpEmitirFactura.add(jbEmitirFactura);
        return jpEmitirFactura;
    }

    private JPanel panelDatosDeUnaFactura() {
        jtfNif = new JTextField(10);
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
        jpDatosFactura.add(jtfNif);
        jpDatosFactura.add(new JLabel("Codigo factura: "));
        jpDatosFactura.add(jtfCodigoFactura);
        jpDatosFactura.add(jbObtenerDatosCliente);
        return jpDatosFactura;
    }

    private JPanel panelListaFacturas() {
        jtfNif = new JTextField(10);
        JButton jbListaFacturas = new JButton("Lista las facturas");
        JPanel jpListaFacturas = new JPanel();
        jpListaFacturas.add(new JLabel("NIF: "));
        jpListaFacturas.add(jtfNif);
        jpListaFacturas.add(jbListaFacturas);
        return jpListaFacturas;
    }

    private JPanel panelAñadirTarifaDias(){
        jtfNif = new JTextField(10);
        jtfPrecioTarifa = new JTextField(10);
        jtfDiaSemana = new JTextField(10);
        JButton jbNuevaTarifaDias = new JButton("Nueva tarifa dias");
        jbNuevaTarifaDias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.nuevaTarifaDias();
            }
        });

        JPanel jpAnyadirTarifaDias = new JPanel();
        jpAnyadirTarifaDias.add(new JLabel("Nif cliente: "));
        jpAnyadirTarifaDias.add(jtfNif);
        jpAnyadirTarifaDias.add(new JLabel("Dia: "));
        jpAnyadirTarifaDias.add(jtfDiaSemana);
        jpAnyadirTarifaDias.add(new JLabel("Precio de Tarifa: "));
        jpAnyadirTarifaDias.add(jtfPrecioTarifa);
        jpAnyadirTarifaDias.add(jbNuevaTarifaDias);

        return jpAnyadirTarifaDias;
    }

    private JPanel panelAñadirTarifaHoras(){
        jtfNif = new JTextField(10);
        jtfPrecioTarifa = new JTextField(10);
        JButton jbNuevaTarifaHoras = new JButton("Nueva tarifa horas");
        jbNuevaTarifaHoras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.nuevaTarifaHoras();
            }
        });

        JPanel jpAnyadirTarifaHoras = new JPanel();
        jpAnyadirTarifaHoras.add(new JLabel("Nif cliente: "));
        jpAnyadirTarifaHoras.add(jtfNif);
        jpAnyadirTarifaHoras.add(new JLabel("Hora: "));
        jpAnyadirTarifaHoras.add(jtfHora);
        jpAnyadirTarifaHoras.add(new JLabel("Precio de Tarifa: "));
        jpAnyadirTarifaHoras.add(jtfPrecioTarifa);
        jpAnyadirTarifaHoras.add(jbNuevaTarifaHoras);

        return jpAnyadirTarifaHoras;
    }

    private JScrollPane panelInformacion() {
        jtaInfo = new JTextArea(20, 50);
        JScrollPane jspMostrarInfo = new JScrollPane(jtaInfo);
        jspMostrarInfo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jspMostrarInfo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        return jspMostrarInfo;

    }

    private JPanel panelTarifaPorDías() {
        jtfNif = new JTextField(10);
        jtfDiaDeLaSemana = new JTextField(10);
        jtfPrecioTatifaDiaría = new JTextField(10);
        JButton jbTarifaDias = new JButton("Modificar tarifa");
        jbTarifaDias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.nuevaTarifaDiaria();
            }
        });

        JPanel jpTarifaDias =  new JPanel();
        jpTarifaDias.add(new JLabel("NIF: "));
        jpTarifaDias.add(jtfNif);
        jpTarifaDias.add(new JLabel("Dia (en letra): "));
        jpTarifaDias.add(jtfDiaDeLaSemana);
        jpTarifaDias.add(new JLabel ("Precio Tarifa Diaría: "));
        jpTarifaDias.add(jtfPrecioTatifaDiaría);
        jpTarifaDias.add(jbTarifaDias);
        return jpTarifaDias;

    }

    private JPanel panelTarifaBásica() {
        jtfNif = new JTextField(10);
        jtfPrecioTatifaDiaría = new JTextField(10);
        JButton jbTarifaBasica = new JButton("Modificar Tarifa");
        jbTarifaBasica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.nuevaTarifaBasica();
            }
        });

        JPanel jpTarifaBasica = new JPanel();
        jpTarifaBasica.add(new JLabel("NIF: "));
        jpTarifaBasica.add(jtfNif);
        jpTarifaBasica.add(new JLabel("Precio Tarifa: "));
        jpTarifaBasica.add(jtfPrecioTatifaDiaría);
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
    public String getNIF() {
        return jtfNif.getText();
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
    public int getCodigoFactura() {
        int numero = Integer.parseInt(jtfCodigoFactura.getText());
        return numero;
    }

    @Override
    public int getMinuto() {
        int numero = Integer.parseInt(jtfMinuto.getText());
        return numero;
    }

    @Override
    public int getHora() {
        int numero = Integer.parseInt(jtfHora.getText());
        return numero;
    }

    @Override
    public int getDia() {
        int numero = Integer.parseInt(jtfDia.getText());
        return numero;
    }

    @Override
    public int getMes() {
        int numero = Integer.parseInt(jtfMes.getText());
        return numero;
    }

    @Override
    public int getAnyo() {
        int numero = Integer.parseInt(jtfAnyo.getText());
        return numero;
    }

    @Override
    public String getTelefono() {
        return jtfTelefono.getText();
    }

    @Override
    public int getDuracionLlamada() {
        int numero = Integer.parseInt(jtfDuracion.getText());
        return numero;
    }

    @Override
    public int getDiaFinal() {
        int numero = Integer.parseInt(jtfDiaFin.getText());
        return numero;
    }

    @Override
    public int getMesFinal() {
        int numero = Integer.parseInt(jtfMesFin.getText());
        return numero;
    }

    @Override
    public int getAnyoFinal() {
        int numero = Integer.parseInt(jtfAnyoFin.getText());
        return numero;
    }

    @Override
    public String getDiaDeLaSemana() {
        return jtfDiaDeLaSemana.getText();
    }

    @Override
    public float getPrecioTDiaria() {
        float numero = Float.parseFloat(jtfPrecioTatifaDiaría.getText());
        return numero;
    }


    @Override
    public void getDescripcion() {
        jtaInfo.append(modelo.getDescriptor() + "\n");

    }

    @Override
    public String getDiaSemana() {
        return jtfDiaSemana.getText();
    }

    @Override
    public void creaGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { GUI(); }
        });
    }

    private void GUI() {
        JFrame ventana = new JFrame("Modelo/Vista/Controlador");    //Creamos ventana
        Container contenedor = ventana.getContentPane();
        Escuchador escuchador = new Escuchador();
        JButton jbNuevo = new JButton("Nuevo");
        jbNuevo.addActionListener(escuchador);
    }

    class Escuchador implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int i = 0;
            JButton boton = (JButton)e.getSource();
            String texto = boton.getText();
            if(texto.equals("Nuevo"))
                //controlador.atras();
                i=1;
            else if(texto.equals("Atras"))
                //controlador.atras();
                i=2;
            else if(texto.equals("Adelante"))
                //controlador.adelante();
                i=3;
        }
    }
}
