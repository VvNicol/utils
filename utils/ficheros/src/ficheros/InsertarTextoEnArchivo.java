package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertarTextoEnArchivo {

	public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Por favor, ingresa el mensaje que deseas escribir en el archivo:");
            String mensaje = br.readLine();

            File archivo = new File("mensaje.txt");

            FileWriter escritor = new FileWriter(archivo);

            escritor.write(mensaje);

            escritor.close();

            System.out.println("El mensaje se ha escrito correctamente en el archivo 'mensaje.txt'.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
