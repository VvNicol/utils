/**
 * 
 */
package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import controlador.inicio;
import dtos.citasDto;

/**
 * 
 */
public class ficheros {

	public static void LeerYGuardar() {

		try {
			File citasFichero = new File(inicio.citasFichero);
			if (!citasFichero.exists()) {
				try (BufferedWriter writer = new BufferedWriter(new FileWriter(citasFichero))) {
					writer.write("12345678Z;Alfonso;Fernández García;Psicologia;04-05-2024 03:30:00;true\n");
					writer.write("47166912T;Marta;Fernández Fernández;Psicologia;04-05-2024 13:00:00;false\n");
					writer.write("17165912O;Pedro;Collado Puente;Fisioterapia;04-05-2024 11:00:00;false\n");
					writer.write("37165912P;Laura;Quintero García;Psicologia;04-05-2024 13:30:00;true\n");
					writer.write("17165912O;Pedro;Collado Puente;Fisioterapia;04-05-2024 11:00:00;false\n");
					writer.write("37165912P;Laura;Quintero García;Psicologia;04-05-2024 13:30:00;false\n");
				}
			} else {
				try (BufferedReader reader = new BufferedReader(new FileReader(citasFichero))) {
					String linea;
					while ((linea = reader.readLine()) != null) {
						String[] partes = linea.split(";");
						citasDto citasAgregar = new citasDto(partes[0], partes[1], partes[2], partes[3],
								LocalDateTime.parse(partes[4], DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),
								Boolean.parseBoolean(partes[5]));
						inicio.citaLista.add(citasAgregar);
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("Error inesperado: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
