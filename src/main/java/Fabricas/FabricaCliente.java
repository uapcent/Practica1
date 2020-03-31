package Fabricas;


import clientes.Cliente;
import clientes.Empresa;
import clientes.Particular;
import clientes.Salir;


import java.lang.reflect.InvocationTargetException;

public enum FabricaCliente {
    PARTICULAR("Particular.", Particular.class),
    EMPRESA("Empresa.", Empresa.class),
    SALIR("Salir.", Salir.class);


    private String descripcion;
    private Class<? extends Cliente> cliente;
    private Cliente noSePudoCrear = new Empresa("No se pudo crear.", "", null,"", null, null);

    private FabricaCliente(String descripcion, Class<? extends Cliente> cliente ) {
        this.descripcion = descripcion;
        this.cliente = cliente;
    }

    public Cliente getCliente(String... args) {
        try {
            if (args.length == 6)
                return cliente.getConstructor(String.class, String.class, String.class, String.class, String.class, String.class).newInstance(args);
            else if (args.length == 7 )
                return cliente.getConstructor(String.class, String.class, String.class, String.class, String.class, String.class, String.class).newInstance(args);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return noSePudoCrear;
    }

    public static String opciones() {
        StringBuilder sb = new StringBuilder();
        for (FabricaCliente tipo : values())
            sb.append(tipo.ordinal() + ".- " + tipo.descripcion + "\n");
        return sb.toString();
    }

    public static FabricaCliente enteroATipo(int posicion) {
        return values()[posicion];
    }
}
