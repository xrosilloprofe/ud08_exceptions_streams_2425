package streams.ejercicios;

import excepciones.Ejercicio2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ejercicio4 {
    public static void main(String[] args) {
        List<String> nombres = readFile(Ejercicio3.RUTA+"usa_nombres.txt");
        List<String> apellidos = readFile(Ejercicio3.RUTA+"usa_apellidos.txt");
        escribeFichero(nombres, apellidos, 400);
    }

    public static List<String> readFile(String file){
        List<String> lista = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String linea;
            while((linea= reader.readLine())!=null)
                lista.add(linea);
        } catch (IOException e){
            e.printStackTrace();
        }
        return lista;
    }

    public static void escribeFichero(List<String> nombres, List<String> apellidos, int limite){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("usa_personas.txt"))){
            Random aleatorio = new Random();
            Random aleatorio2 = new Random();
            for (int i = 0; i < limite; i++) {
                String nombreCompleto = nombres.get(aleatorio.nextInt(nombres.size())) + " " +
                        apellidos.get(aleatorio2.nextInt(apellidos.size()));
                writer.write(nombreCompleto);
                writer.newLine();
            }
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }

}
