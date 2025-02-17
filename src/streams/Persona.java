package streams;

import java.io.Serializable;
import java.time.LocalDate;

public class Persona implements Comparable<Persona>, Serializable {
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if(o==null || !(o instanceof Persona))
            return false;
        Persona persona = (Persona) o;
        return persona.getNombre().equals(nombre) &&
                persona.getApellidos().equals(apellidos);
    }

    @Override
    public int hashCode(){
        return nombre.hashCode() + apellidos.hashCode();
    }


    @Override
    public int compareTo(Persona o) {
        if(apellidos.equals(o.getApellidos()))
            return nombre.compareTo(o.getNombre());
        return apellidos.compareTo(o.getApellidos());
    }
}
