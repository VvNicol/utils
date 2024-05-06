package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class inicio {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Ingrese el nombre del archivo:");
            String nombreArchivo = scanner.nextLine();

            File archivo = new File(nombreArchivo);
            BufferedReader lectorArchivo = new BufferedReader(new FileReader(archivo));
            StringBuilder contenido = new StringBuilder();

            String linea;
            while ((linea = lectorArchivo.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            lectorArchivo.close();

            System.out.println("Ingrese el número de la línea donde desea insertar el texto:");
            int numeroLinea = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese la posición donde desea insertar el texto en la línea:");
            int posicion = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese el texto que desea insertar:");
            String textoInsertar = scanner.nextLine();

            String[] lineas = contenido.toString().split("\n");
            if (numeroLinea <= lineas.length && numeroLinea > 0) {
                StringBuilder lineaModificar = new StringBuilder(lineas[numeroLinea - 1]);
                if (posicion <= lineaModificar.length() && posicion >= 0) {
                    lineaModificar.insert(posicion, textoInsertar);
                    lineas[numeroLinea - 1] = lineaModificar.toString();
                } else {
                    System.out.println("La posición especificada no es válida.");
                }
            } else {
                System.out.println("El número de línea especificado no es válido.");
            }

            FileWriter escritorArchivo = new FileWriter(archivo);
            for (String l : lineas) {
                escritorArchivo.write(l + "\n");
            }
            escritorArchivo.close();

            System.out.println("El texto se ha insertado correctamente en el archivo.");

        } catch (IOException e) {
            System.out.println("Error al manipular el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número válido para la línea y la posición.");
        } finally {
            scanner.close();
        }
    }
}

