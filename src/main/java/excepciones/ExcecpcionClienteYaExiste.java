package excepciones;

public class ExcecpcionClienteYaExiste extends Exception {

    public ExcecpcionClienteYaExiste() {
        super("El cliente ya existe en nuestra base de datos.");
    }
}
