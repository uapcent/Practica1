package gestion;

import controlador.Controlador;
import modelo.GestorClientes;
import modelo.GestorModelo;
import vista.Vista;

import javax.swing.*;

public class ProgramaPrincipalSwing {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Vista vista = new Vista();
                GestorClientes modelo = new GestorClientes();
                Controlador controlador = new Controlador();
                vista.setControlador(controlador);
                vista.setModelo(modelo);
                modelo.setVista(vista);
                controlador.setModelo(modelo);
                controlador.setVista(vista);
                vista.setModelo(modelo);
                vista.setControlador(controlador);
                vista.creaGUI();
            }
        });
    }
}
