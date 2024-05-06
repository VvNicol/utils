package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ModificarArchivo {

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

            System.out.println("Seleccione una opción:");
            System.out.println("1. Modificar una línea específica.");
            System.out.println("2. Insertar texto en una posición específica de una línea.");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el número de la línea que desea modificar:");
                    int numeroLineaModificar = Integer.parseInt(scanner.nextLine());

                    System.out.println("Ingrese el nuevo contenido para la línea:");
                    String nuevoContenido = scanner.nextLine();

                    modificarLinea(contenido, numeroLineaModificar, nuevoContenido);
                    break;
                case 2:
                    System.out.println("Ingrese el número de la línea donde desea insertar el texto:");
                    int numeroLineaInsertar = Integer.parseInt(scanner.nextLine());

                    System.out.println("Ingrese la posición donde desea insertar el texto en la línea:");
                    int posicionInsertar = Integer.parseInt(scanner.nextLine());

                    System.out.println("Ingrese el texto que desea insertar:");
                    String textoInsertar = scanner.nextLine();

                    insertarTextoEnLinea(contenido, numeroLineaInsertar, posicionInsertar, textoInsertar);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            FileWriter escritorArchivo = new FileWriter(archivo);
            escritorArchivo.write(contenido.toString());
            escritorArchivo.close();

            System.out.println("El archivo ha sido modificado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al manipular el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número válido para la opción, línea y posición.");
        } finally {
            scanner.close();
        }
    }

    private static void modificarLinea(StringBuilder contenido, int numeroLinea, String nuevoContenido) {
        String[] lineas = contenido.toString().split("\n");
        if (numeroLinea <= lineas.length && numeroLinea > 0) {
            lineas[numeroLinea - 1] = nuevoContenido;
            contenido.setLength(0); // Limpiar el contenido actual
            for (String linea : lineas) {
                contenido.append(linea).append("\n");
            }
        } else {
            System.out.println("El número de línea especificado no es válido.");
        }
    }

    private static void insertarTextoEnLinea(StringBuilder contenido, int numeroLinea, int posicion, String textoInsertar) {
        String[] lineas = contenido.toString().split("\n");
        if (numeroLinea <= lineas.length && numeroLinea > 0) {
            StringBuilder lineaModificar = new StringBuilder(lineas[numeroLinea - 1]);
            if (posicion <= lineaModificar.length() && posicion >= 0) {
                lineaModificar.insert(posicion, textoInsertar);
                lineas[numeroLinea - 1] = lineaModificar.toString();
                contenido.setLength(0); 
                for (String linea : lineas) {
                    contenido.append(linea).append("\n");
                }
            } else {
                System.out.println("La posición especificada no es válida.");
            }
        } else {
            System.out.println("El número de línea especificado no es válido.");
        }
    }
}
