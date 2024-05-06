/**
 * 
 */
package controlador;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dtos.citasDto;
import servicios.menuImplementacion;
import servicios.menuInterface;
import servicios.registroImplementacion;
import servicios.registroInterface;

/**
 * 
 */
public class inicio {

	/**
	 * @param args
	 */
	public static List<citasDto> citaLista = new ArrayList<citasDto>();
    static LocalDateTime fechaActual = LocalDateTime.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    static String fechaFormateada = fechaActual.format(formatter);
    ///public static String ficheroLog = fechaFormateada + "ficheroLog.txt";
    public static String ficheroLogConcat = fechaFormateada.concat(" ficheroLog.txt");
    public static String citasFichero = fechaFormateada.concat(" citas.txt");
    //poner la fichero log con el sin el "+"
	public static void main(String[] args) {

		menuInterface mi = new menuImplementacion();
		registroInterface ri = new registroImplementacion();
		
		
		int opcionSeleccionada;
		boolean esCerrado = false;

		try {
			
			utils.ficheros.LeerYGuardar();
			
			FileWriter fileWriter = new FileWriter(ficheroLogConcat,true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			
			do {

				opcionSeleccionada = mi.MenuPrincipal() ;
				//String mensajeLog = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "- Opcion elegida: " + opcionSeleccionada;
				String mensajeConcat = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).concat("- Opcion elegida: ").concat(String.valueOf(opcionSeleccionada));

				switch (opcionSeleccionada) {

				case 0:
					mensajeConcat += " - Menu cerrado";
					esCerrado = true;
					System.out.println("El menu se ha cerrado");
					break;
				case 1:
					mensajeConcat += " - Registro de llegada";

					ri.RegistroLlegada();
					break;
				case 2:
					mensajeConcat += " en SubMenu Listado consultas";
					mi.SubMenuMostrarImprimir();
					
					break;

				default:
					
					mensajeConcat += " - Opcion invalida";
					System.out.println("La opcion no es valida");
					break;
				}
				
				printWriter.println(mensajeConcat);
				
			} while (!esCerrado);
			
			printWriter.close();
			fileWriter.close();
			
		} catch(IOException e ) {
			System.out.println("No se ha podido leer/escribir" + e.getMessage());
			e.printStackTrace();

		} catch (Exception ex) {
	        System.out.println("Error inesperado: " + ex.getMessage());
	        ex.printStackTrace();
	    }

	}

}
