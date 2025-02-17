package streams;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EjemploStreamObjetos {
    public static void main(String[] args) {
        Set<Persona> personas = new HashSet<>();
        personas.add(new Persona("Xavier","Rosillo", LocalDate.of(1973,2,14)));
        personas.add(new Persona("Lucía","Torán", LocalDate.of(1977,9,7)));
        personas.add(new Persona("Fernando","Ponce", LocalDate.of(1983,3,15)));
        personas.add(new Persona("Carmen","Hervás", LocalDate.of(1999,11,11)));
        personas.add(new Persona("Pepe","Sáez", LocalDate.of(1995,12,14)));

        guardar("personas.dat", personas);
        List<Persona> listaPersonas = leer("personas.dat");
        System.out.println(listaPersonas);

        guardarConjunto("personasConjunto.dat",personas);
        System.out.println(leerCojunto("personasConjunto.dat"));
    }

    private static void guardar(String fichero,Set<Persona> personas){
        try(ObjectOutputStream objOut =
                    new ObjectOutputStream(new FileOutputStream(fichero))){
            for(Persona persona:personas){
                objOut.writeObject(persona);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    private static List<Persona> leer(String fichero){
        List<Persona> lista = new ArrayList<>();
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(fichero))){
            Persona persona;
            while((persona = (Persona) input.readObject())!=null)
                lista.add(persona);
        } catch (EOFException e){
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return lista;
    }

    private static void guardarConjunto(String fichero,Set<Persona> personas){
        try(ObjectOutputStream objOut =
                    new ObjectOutputStream(new FileOutputStream(fichero))){
            objOut.writeObject(personas);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static List<Persona> leerCojunto(String fichero){
        List<Persona> lista = new ArrayList<>();
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(fichero))){
            lista.addAll((Set<Persona>) input.readObject());
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return lista;
    }

}
