package streams;

import java.io.*;

public class FicherosTexto {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("hola.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("adios.txt"))){
            String copia;
            while ((copia= reader.readLine())!=null){
                writer.write(copia);
                writer.newLine();
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
