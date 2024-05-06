/**
 * 
 */
package servicios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import controlador.inicio;

/**
 * 
 */
public class menuImplementacion implements menuInterface {

	Scanner sc = new Scanner(System.in);
	consultasInterface ci = new consultasImplementacion();

	private void escribirEnFicheroLog(String mensaje) throws IOException {
		try (PrintWriter printWriter = new PrintWriter(new FileWriter(inicio.ficheroLogConcat, true))) {
			printWriter.println(mensaje);
		}
	}

	@Override
	public int MenuPrincipal() throws IOException {
		System.out.println("-----------------------------");
		System.out.println("Menu principal");
		System.out.println("0. Cerrar");
		System.out.println("1. Consultar cita");
		System.out.println("2. Listado registro");
		System.out.println("-----------------------------");

		int opcionElegir = sc.nextInt();

		return opcionElegir;
	}

	@Override
	public void SubMenuMostrarImprimir() throws IOException {

		int opcionSeleccionada;
		boolean esCerrado = false;

		do {

			opcionSeleccionada = MenuListadoConsultas();
			String mensajeLog = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
					+ " - Opción seleccionada en Menu Listado Consultas : " + opcionSeleccionada;
			
			switch (opcionSeleccionada) {

			case 0:
				mensajeLog += " - Volver";
				esCerrado = true;
				System.out.println("Volver");
				break;
			case 1:
				mensajeLog += " - Mostrar consultas";
				MenuConsultas();
				break;
			case 2:
				mensajeLog += " - Imprimir consultas";
				ci.ImprimirConsultasFichero();

				break;

			default:

				mensajeLog += " - Opcion invalida";
				System.out.println("La opcion no es valida");
				break;
			}

			escribirEnFicheroLog(mensajeLog);

		} while (!esCerrado);

	}


	private void MenuConsultas() throws IOException {
		
		int opcionSeleccionada;
		boolean esCerrado = false;

		do {

			opcionSeleccionada = MenuConsultasEspecialistas();
			String mensajeLog = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
					+ " - Opción seleccionada en Menu Consultas Especialistas : " + opcionSeleccionada;
			
			switch (opcionSeleccionada) {

			case 0:
				mensajeLog += " - Volver";
				esCerrado = true;
				System.out.println("Volver");
				break;
			case 1:
				String psicologia = "Psicologia";
				mensajeLog += " - Psicología";
				ci.ConsultasEspecialistasDia(psicologia);

				break;
			case 2:
				String traumatologia = "Traumatologia";
				mensajeLog += " - Traumatología";
				//ci.ImprimirConsultas();
				ci.ConsultasEspecialistasDia(traumatologia);

				break;
			case 3:
				String fisioterapia = "Fisioterapia";
				mensajeLog += " - Fisioterapia";
				ci.ConsultasEspecialistasDia(fisioterapia);

				break;

			default:

				mensajeLog += " - Opcion invalida";
				System.out.println("La opcion no es valida");
				break;
			}

			escribirEnFicheroLog(mensajeLog);

		} while (!esCerrado);

	}

	private int MenuConsultasEspecialistas() throws IOException {
		System.out.println("-----------------------------");
		System.out.println("Menu Consultas Especialistas");
		System.out.println("0. Volver");
		System.out.println("1. Psicología");
		System.out.println("2. Traumatología");
		System.out.println("3. Fisioterapia");
		System.out.println("-----------------------------");

		int opcionElegir = sc.nextInt();

		return opcionElegir;
	}

	private int MenuListadoConsultas() throws IOException {
		System.out.println("-----------------------------");
		System.out.println("Menu Listado Registro");
		System.out.println("0. Volver");
		System.out.println("1. Mostrar consultas");
		System.out.println("2. Imprimir consultas");
		System.out.println("-----------------------------");

		int opcionElegir = sc.nextInt();

		return opcionElegir;
	}

}
