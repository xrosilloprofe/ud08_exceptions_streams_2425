package excepciones;

import java.io.FileReader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] vector = new double[5];

        for (int i = 0; i < vector.length; i++) {
            System.out.print("Valor de "+i+": ");
            try{
                vector[i] = scanner.nextDouble();
            } catch (InputMismatchException e){
                System.out.println("Incorrecto, valor no numérico");
                scanner.next();
                i--;
            }
        }

        System.out.println(Arrays.toString(vector));;

    }
}
