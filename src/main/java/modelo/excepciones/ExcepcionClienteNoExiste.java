package modelo.excepciones;

public class ExcepcionClienteNoExiste extends Exception {

    public ExcepcionClienteNoExiste() {
        super("El cliente no existe en nuestra base de datos.");
    }
}
