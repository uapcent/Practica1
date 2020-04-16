package Fabricas;

import clientes.Cliente;
import clientes.Empresa;
import tarifas.*;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public enum FabricaTarifas implements Serializable {
    TARIFABASICA("Tarifa básica.", TarifaBasica.class),
    TARIFAPORDIA("Tarifa por dia.", TarifaPorDia.class),
    TARIFAPORHORAS("Tarifa por horas.", TarifaPorHoras.class),
    SALIR("Salir.", Salir.class);

    private String descripcion;
    private Class<? extends Tarifa> tarifa;
    private Tarifa noSePudoCrear = new TarifaBasica(-1);

    private FabricaTarifas(String descripcion, Class<? extends Tarifa> tarifa) {
        this.descripcion = descripcion;
        this.tarifa = tarifa;
    }

    public Tarifa getTarifa(Object... args) {
        try {
            if (args.length == 1)
                return tarifa.getConstructor(float.class).newInstance(args);
            else if (args.length == 3)
                return tarifa.getConstructor(Tarifa.class, float.class, String.class).newInstance(args);
            else if (args.length == 4)
                return tarifa.getConstructor(Tarifa.class, float.class, int.class, int.class).newInstance(args);
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
        for (FabricaTarifas tipo : values())
            sb.append(tipo.ordinal() + ".- " + tipo.descripcion + "\n");
        return sb.toString();
    }

    public static FabricaTarifas enteroATipo(int posicion) {
        return values()[posicion];
    }
}
