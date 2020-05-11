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
    private JTextField jtfTelefono;
    private JTextField jtfDuracion;
    private  JTextField jtfDiaFin;
    private  JTextField jtfMesFin;
    private  JTextField jtfAnyoFin;



//    public Vista() {
//        creaInterfazVisual();
//    }

    public void setControlador(InterfazControlador controlador) {
        this.controlador = controlador;
    }

    public void setModelo(GestorModelo modelo) {
        this.modelo = modelo;
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
        jtfDuracion = new JTextField(10);
        jtfDia = new JTextField(10);
        jtfMes = new JTextField(10);
        jtfAnyo = new JTextField(10);
        jtfHora = new JTextField(10);
        jtfMinuto = new JTextField(10);

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
        jpAñadirLlamada.add(new JLabel("Día (0-31): "));
        jpAñadirLlamada.add(jtfDia);
        jpAñadirLlamada.add(new JLabel("Mes (1-12): "));
        jpAñadirLlamada.add(jtfMes);
        jpAñadirLlamada.add(new JLabel("Año (Actual o inferior): "));
        jpAñadirLlamada.add(jtfAnyo);
        jpAñadirLlamada.add(new JLabel("Duracion (en minutos): "));
        jbAñadirLlamada.add(jtfDuracion);
        jpAñadirLlamada.add(jbAñadirLlamada);
        return jpAñadirLlamada;
    }


    private JPanel panelListaLlamadasCliente() {
        jtfNif = new JTextField(10);
        JButton jbListarLlamadas = new JButton();
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

        JButton jbEmitirFactura = new JButton();
        jbEmitirFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.emitirFactura();
            }
        });

        JPanel jpEmitirFactura = new JPanel();
        jpEmitirFactura.add(new JLabel("NIF: "));
        jpEmitirFactura.add(jtfNif);
        jpEmitirFactura.add(new JLabel("NIF: "));
        jpEmitirFactura.add(jtfDia);
        jpEmitirFactura.add(new JLabel("NIF: "));
        jpEmitirFactura.add(jtfMes);
        jpEmitirFactura.add(new JLabel("NIF: "));
        jpEmitirFactura.add(jtfAnyo);
        jpEmitirFactura.add(new JLabel("NIF: "));
        jpEmitirFactura.add(jtfDiaFin);
        jpEmitirFactura.add(new JLabel("NIF: "));
        jpEmitirFactura.add(jtfMesFin);
        jpEmitirFactura.add(new JLabel("NIF: "));
        jpEmitirFactura.add(jtfAnyoFin);
        jpEmitirFactura.add(jbEmitirFactura);
        return jpEmitirFactura;
    }

    private JPanel panelDatosDeUnaFactura() {
        jtfNif = new JTextField(10);
        jtfCodigoFactura = new JTextField();
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
        jpDatosFactura.add(jbObtenerDatosCliente);
        return jpDatosFactura;
    }

    private JPanel listaFacturas() {
        jtfNif = new JTextField(10);
        JButton jbListaFacturas = new JButton();
        JPanel jpListaFacturas = new JPanel();
        jpListaFacturas.add(new JLabel("NIF: "));
        jpListaFacturas.add(jtfNif);
        jpListaFacturas.add(jbListaFacturas);
        return jpListaFacturas;
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
    public void getDescripcion() {

    }
}
