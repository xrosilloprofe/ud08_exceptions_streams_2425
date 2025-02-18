package streams.ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2 {
    public static void main(String[] args) {
        int mayor=0,menor=0;
        try(BufferedReader lector =
                    new BufferedReader(
                            new FileReader("src/streams/ejercicios/Documentos/numeros.txt"))){
            String numeroFichero;

            boolean firstiteration=true;

            while((numeroFichero= lector.readLine())!=null){
                if(!firstiteration){
                    int numero = Integer.parseInt(numeroFichero);
                    if(numero<menor)
                        menor=numero;
                    if(numero>mayor)
                        mayor=numero;
                } else{
                    mayor=menor=Integer.parseInt(numeroFichero);
                    firstiteration=false;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("Mayor: " + mayor + " y menor: " + menor);
    }
}
