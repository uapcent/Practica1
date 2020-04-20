package gestion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class EscribirFichero implements Serializable {
    public void escribirFichero(GestorClientes gestionClientes) {
        try {
            FileOutputStream fos = null;
            fos = new FileOutputStream("agenda.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(gestionClientes);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
