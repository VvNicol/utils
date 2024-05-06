/**
 * 
 */
package servicios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import controlador.inicio;
import dtos.citasDto;

/**
 * 
 */
public class consultasImplementacion implements consultasInterface {
	Scanner sc = new Scanner(System.in);

	@Override
	public void ConsultasEspecialistasDia(String especialidad) throws IOException {
		LocalDate fechaSeleccionada = leerFecha();
		String consulta = especialidad;
		boolean esEncontrado = false;

		for (citasDto cita : inicio.citaLista) {

			LocalDate citaDate = cita.getFechaCita().toLocalDate();

			if (consulta.equals(cita.getConsulta()) && fechaSeleccionada.equals(citaDate)) {
				
				esEncontrado = true;
				System.out.println("-----------------------------------------------");
				System.out.println("Consultas para " + consulta + " el "
						+ fechaSeleccionada.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ":");
				System.out.println("Nombre completo: " + cita.getNombrePaciente() + " " + cita.getApellidosPaciente()
						+ ", Hora: " + cita.getFechaCita().format(DateTimeFormatter.ofPattern("HH:mm")));
				System.out.println("-----------------------------------------------");

			}
		}
		if(!esEncontrado) {
			System.out.println("No hay datos disponibles para la especialidad y fecha indicada.");
		}
	}

	private LocalDate leerFecha() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("Elija una fecha (yyyy-MM-dd)");
		String fechaEscogida = sc.next();

		try {
			return LocalDate.parse(fechaEscogida, formato);
		} catch (DateTimeParseException e) {
			System.out.println(
					"Error: La fecha ingresada no es válida. Por favor, ingrese una fecha en formato dd-MM-yyyy.");
			return leerFecha(); // recursive call to prompt user again
		}
	}

	@Override
	public void ImprimirConsultasFichero() throws IOException {

		LocalDateTime fechaActual = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
		String fechaFormateada = fechaActual.format(formatter);
		String ficheroAsistencia = "citasConAsistencia".concat(fechaFormateada).concat(".txt");

		boolean hayAsistencias = false;

		for (citasDto citaFichero : inicio.citaLista) {

			if (citaFichero.isEsAsistencia() == true) {
				hayAsistencias = true;
				break;
			}
		}
		if (hayAsistencias) {
			
			FileWriter fw = new FileWriter(ficheroAsistencia, true);
			PrintWriter pw = new PrintWriter(fw);

			for (citasDto citaFichero : inicio.citaLista) {

				if (citaFichero.isEsAsistencia() == true) {
					String Asistencia = citaFichero.toString();
					pw.println(Asistencia);
				}
			}
			pw.close();
			fw.close();
			System.out.println("Se ha creado el archivo '" + ficheroAsistencia + "' correctamente.");
		} else {
			System.out.println("No hay asistencias");
		}
	}
}
