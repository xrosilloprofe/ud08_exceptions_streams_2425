package excepciones;

public class Example06 {
    public static void main(String[] args){
        try{
            checkNumero(10);
            checkNumero(5);
        } catch (ExcepcionMayor10 e){
            e.printStackTrace();
        }
    }

    public static void checkNumero(int num) throws ExcepcionMayor10{
        if(num>=10)
            throw new ExcepcionMayor10("Número mayor de 10");
        System.out.println("Numero OK");
    }

}
