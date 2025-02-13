package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example04 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        try {
            System.out.print("Numerador:");
            int numerador = scanner.nextInt();
            System.out.print("Denominador:");
            int denominador = scanner.nextInt();
            System.out.println("División: " + numerador / denominador);
        } catch (ArithmeticException objetoArithExp){
            System.out.println("Error dividir por cero");
            objetoArithExp.printStackTrace();
        } catch(InputMismatchException inputMismatchException){
            System.out.println(inputMismatchException.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("FIN del proceso");
        }

    }
}
