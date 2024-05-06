/**
 * 
 */
package servicios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import controlador.inicio;
import dtos.citasDto;

/**
 * 
 */
public class registroImplementacion implements registroInterface {

	Scanner sc = new Scanner(System.in);

	@Override
	public void RegistroLlegada() {

		String dniPaciente = null;
		boolean esValidoDni = false;

		do {
			System.out.println("--------------------");
			System.out.println("Ingrese su dni (8 digitos)");
			int dniDigitos = sc.nextInt();

			System.out.println("Ingrese la letra de su dni (ej: z)");
			char letraDni = Character.toUpperCase(sc.next().charAt(0));

			int[] resto = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22 };
			char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
					'H', 'L', 'C', 'K', 'E' };

			int divisor = 23;
			int operacion = dniDigitos % divisor;

			int posicionResto = resto[operacion];

			if (letraDni == letras[posicionResto]) {
				esValidoDni = true;
				dniPaciente = dniDigitos + String.valueOf(letraDni);
			} else {
				esValidoDni = false;
				System.out.println("No es valido Intentelo otravez");
			}

		} while (!esValidoDni);
		verificarConsulta(dniPaciente);

	}

	private void verificarConsulta(String dni) {

	    LocalDateTime fechaHoy = LocalDateTime.now();
	    boolean tieneCita = false;

	    for (citasDto cita : inicio.citaLista) {
	        LocalDateTime fechaCita = cita.getFechaCita(); // Obtener la fecha de la cita
	        if (cita.getDniPaciente().equals(dni) && fechaCita.toLocalDate().equals(fechaHoy.toLocalDate())) {
	            tieneCita = true;
	            System.out.println("Espere su turno para la consulta de " + cita.getConsulta()
	                    + " en la sala de espera. Su especialista le avisará.");
	            break;
	        }
	    }

	    if (!tieneCita) {
	        System.out.println("No dispone de ninguna cita previa para hoy.");
	    }

	}

}
