/**
 * 
 */
package dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * 
 */
public class citasDto {
	
	long idCitas;
    String dniPaciente = "aaaaa";
    String nombrePaciente = "aaaaa";
    String apellidosPaciente = "aaaaa";
    String consulta = "aaaaa";
    LocalDateTime fechaCita = LocalDateTime.of(9999, 12, 31,00,00,00);
    boolean esAsistencia = false;
    
    
    
    
    
    
    
	@Override
	public String toString() {
		
		String fichero = "--------------------------------------------\n"+
						 "Nombre completo" + nombrePaciente + " " + apellidosPaciente + "\n" +
						 "Fecha hora : " + fechaCita.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		
		return fichero;
	}

	/**
	 * @param dniPaciente
	 * @param nombrePaciente
	 * @param apellidosPaciente
	 * @param consulta
	 * @param fechaCita
	 * @param esAsistencia
	 */
	public citasDto(String dniPaciente, String nombrePaciente, String apellidosPaciente, String consulta,
			LocalDateTime fechaCita, boolean esAsistencia) {
		super();
		this.dniPaciente = dniPaciente;
		this.nombrePaciente = nombrePaciente;
		this.apellidosPaciente = apellidosPaciente;
		this.consulta = consulta;
		this.fechaCita = fechaCita;
		this.esAsistencia = esAsistencia;
	}
	
	/**
	 * @return the dniPaciente
	 */
	public String getDniPaciente() {
		return dniPaciente;
	}
	/**
	 * @param dniPaciente the dniPaciente to set
	 */
	public void setDniPaciente(String dniPaciente) {
		this.dniPaciente = dniPaciente;
	}
	/**
	 * @return the nombrePaciente
	 */
	public String getNombrePaciente() {
		return nombrePaciente;
	}
	/**
	 * @param nombrePaciente the nombrePaciente to set
	 */
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
	/**
	 * @return the apellidosPaciente
	 */
	public String getApellidosPaciente() {
		return apellidosPaciente;
	}
	/**
	 * @param apellidosPaciente the apellidosPaciente to set
	 */
	public void setApellidosPaciente(String apellidosPaciente) {
		this.apellidosPaciente = apellidosPaciente;
	}
	/**
	 * @return the consulta
	 */
	public String getConsulta() {
		return consulta;
	}
	/**
	 * @param consulta the consulta to set
	 */
	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}
	/**
	 * @return the fechaCita
	 */
	public LocalDateTime getFechaCita() {
		return fechaCita;
	}
	/**
	 * @param fechaCita the fechaCita to set
	 */
	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}
	/**
	 * @return the esAsistencia
	 */
	public boolean isEsAsistencia() {
		return esAsistencia;
	}
	/**
	 * @param esAsistencia the esAsistencia to set
	 */
	public void setEsAsistencia(boolean esAsistencia) {
		this.esAsistencia = esAsistencia;
	}

	
	public Map<LocalDateTime, List<citasDto>> get(LocalDate fechaSeleccionada) {
		// TODO Auto-generated method stub
		return null;
	}

    
}
