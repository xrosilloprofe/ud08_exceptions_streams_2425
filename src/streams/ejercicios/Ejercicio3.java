package streams.ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Ejercicio3 {
    public static final String RUTA = "src/streams/ejercicios/Documentos/";

    public static void main(String[] args){
        List<String> estudiantes = readFile();
        Map<String, Double> mediasEstudiantes = new HashMap<>();
        try {
            mediasEstudiantes = rellenarMapa(estudiantes);
        } catch (Exception e){
            e.printStackTrace();
        }

        //ORDENAR MAPAS POR VALOR CON STREAMS DE COLECCIONES
        System.out.println("Resultado 1");
        mediasEstudiantes.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                forEach(System.out::println);
    }

    private static Map<String, Double> rellenarMapa(List<String> estudiantes) throws Exception{
        Map<String, Double> mediasEstudiantes = new HashMap<>();
        for(String estudiante:estudiantes){
            String nombreCompleto;
            String[] arrayEstudiante = estudiante.split(" ");
            Double average, suma=0.0;
            if(arrayEstudiante.length<2)
                throw new Exception("Error en los datos");
            nombreCompleto = arrayEstudiante[0] + " " + arrayEstudiante[1];
            for (int i = 2; i < arrayEstudiante.length; i++) {
                suma += Double.parseDouble(arrayEstudiante[i]);
            }
            average = suma/(arrayEstudiante.length-2);
            mediasEstudiantes.put(nombreCompleto,average);
        }
        return mediasEstudiantes;
    }

    private static List<String> readFile(){
        List<String> lineas = new ArrayList<>();
        try(BufferedReader reader =
                    new BufferedReader(new FileReader(RUTA+"alumnos_notas.txt"))){
            String linea;
            while((linea=reader.readLine())!=null)
                lineas.add(linea);
        } catch (IOException exception){
            exception.printStackTrace();
        }
        return lineas;
    }

}
