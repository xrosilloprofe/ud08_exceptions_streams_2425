package streams.ejercicios;

import excepciones.ejercicio3.ExcepcionGatuna;
import excepciones.ejercicio3.Gato;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) {
        List<Gato> listaGatos = new ArrayList<>();
        try{
            listaGatos.add(new Gato("Pep",3));
            listaGatos.add(new Gato("Pepa",13));
            listaGatos.add(new Gato("Missi",4));
            listaGatos.add(new Gato("Lluna",8));
        } catch (ExcepcionGatuna e){
            System.out.println(e.getMessage());
        }

        try{
            Gato.save("gatos.dat",listaGatos);
            System.out.println(Gato.load("gatos.dat"));
        } catch (Exception e){
            e.printStackTrace();
        }

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("gatos.csv"))){
            for(Gato gato:listaGatos) {
                bufferedWriter.write(gato.getNombre()+";"+gato.getEdad());
                bufferedWriter.newLine();
            }
        } catch (Exception e){
            e.printStackTrace();
        }



    }
}
