package excepciones.ejercicio3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Gato implements Serializable {
    private String nombre;
    private int edad;

    public Gato(String nombre, int edad) throws ExcepcionGatuna{
        if(nombre.length()<3)
            throw new ExcepcionGatuna("Nombre incorrecto");
        this.nombre = nombre;
        if(edad<0)
            throw new ExcepcionGatuna("Edad negativa");
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws ExcepcionGatuna {
        if(nombre.length()<3)
            throw new ExcepcionGatuna("Nombre incorrecto");
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws ExcepcionGatuna{
        if(edad<0)
            throw new ExcepcionGatuna("Edad negativa");
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    //Es estático para que sea llamado como un método de clase
    //Podríamos no devolver las excepciones, pero lo hacemos así
    // para que las gestione quien llame
    public static List<Gato> load(String fichero) throws IOException,
            ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(fichero));
        return (List<Gato>) input.readObject();
    }

    public static void save(String fichero, List<Gato> gatos) throws IOException{
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fichero));
        output.writeObject(gatos);
    }

}
