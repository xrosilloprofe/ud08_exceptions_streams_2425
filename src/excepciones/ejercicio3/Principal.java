package excepciones.ejercicio3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        List<Gato> camada = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            try {
                System.out.print("Nombre gato " + i + ": ");
                String nombre = scanner.next();
                System.out.print("Edad gato " + i + ": ");
                int edad = scanner.nextInt();
                camada.add(new Gato(nombre, edad));
            } catch (ExcepcionGatuna e) {
                System.out.println(e.getMessage());
                i--;
                scanner.nextLine();
            } catch (InputMismatchException e){
                e.printStackTrace();
                i--;
                scanner.nextLine();
            }
        }

        for(Gato gato:camada)
            System.out.println(gato);

    }
}
