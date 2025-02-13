package excepciones;

public class ExcepcionMayor10 extends Exception{

    private String mensaje;

    public ExcepcionMayor10(String mensaje){
        super(mensaje);
        this.mensaje=mensaje;
    }

    @Override
    public String toString(){
        return mensaje;
    }

}
