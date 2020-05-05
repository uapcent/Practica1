package vista;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class TablaClientes extends JTable {
    public TablaClientes(AbstractTableModel modelo) {
        super(modelo);
        setAutoCreateRowSorter(true);
    }
}
