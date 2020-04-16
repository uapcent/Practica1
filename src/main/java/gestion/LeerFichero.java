package gestion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class LeerFichero implements Serializable {
    public void leerFichero(GestorClientes gestionClientes) {
        try {
            FileInputStream fis = null;
            fis = new FileInputStream("agenda.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            gestionClientes = (GestorClientes) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
