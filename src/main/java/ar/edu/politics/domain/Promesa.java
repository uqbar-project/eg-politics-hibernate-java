package ar.edu.politics.domain;

import java.time.LocalDate;

import org.uqbar.commons.model.annotations.Observable;
import org.uqbar.commons.model.exceptions.UserException;

@Observable
public class Promesa {

	private String accionPrometida;
	private LocalDate fecha;

	public Promesa(String accionPrometida) {
		this.fecha = LocalDate.now();
		this.accionPrometida = accionPrometida;
	}

	public void validar() {
		if (fecha == null) {
			throw new UserException("Debe ingresar fecha");
		}

		if (accionPrometida == null) {
			throw new UserException("Debe ingresar una acción en la promesa");
		}
	}

	public String getAccionPrometida() {
		return accionPrometida;
	}

	public void setAccionPrometida(String accionPrometida) {
		this.accionPrometida = accionPrometida;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}
