package gestion;

public class MiExcepcion extends Exception {
    private int codigoError;

    public MiExcepcion(int codigoError){    //Constructor de la excepcion
        super();
        this.codigoError=codigoError;
    }

    @Override
    public String getMessage(){

        String mensaje="";

        switch(codigoError){
            case 101:
                mensaje="Error, intervalo de fechas no valido";
                break;
            case 102:
                mensaje="Error, el cliente ya está dado de alta";
                break;
            case 103:
                mensaje="Error, el cliente no existe";
                break;
        }

        return mensaje;

    }
}
