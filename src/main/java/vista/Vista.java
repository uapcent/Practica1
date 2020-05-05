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


    public Vista() {
        creaInterfazVisual();
    }

    public void setControlador(InterfazControlador controlador) {
        this.controlador = controlador;
    }

    public void setModelo(GestorModelo modelo) {
        this.modelo = modelo;
    }

    private void creaInterfazVisual() {
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
        JButton jbBorrarCliente = new JButton("Borrar cliente");
        jbBorrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.borrarCliente();
            }
        });
        JPanel jpDatos = new JPanel();
        jpDatos.add(new JLabel("Nombre: "));
        jpDatos.add(jtfNombre);
        jpDatos.add(new JLabel("Apellidos: "));
        jpDatos.add(jtfApellidos);
        jpDatos.add(new JLabel("NIF: "));
        jpDatos.add(jtfNif);
        jpDatos.add(new JLabel("E-mail: "));
        jpDatos.add(jtfEmail);
        jpDatos.add(new JLabel("Población: "));
        jpDatos.add(jtfPoblacion);
        jpDatos.add(new JLabel("Provincia: "));
        jpDatos.add(jtfProvincia);
        jpDatos.add(new JLabel("Código Postal: "));
        jpDatos.add(jtfCodigoPostal);
        jpDatos.add(new JLabel("Precio de Tarifa: "));
        jpDatos.add(jtfPrecioTarifa);
        jpDatos.add(jbNuevoCliente);
        jpDatos.add(jbBorrarCliente);
        JFrame ventana = new JFrame("Aplicación Telefónica");
        ventana.getContentPane().add(jpDatos, BorderLayout.NORTH);
        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
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
    public void getDescripcion() {

    }
}
