package ar.edu.politics.domain;

import java.time.LocalDate;

import org.uqbar.commons.model.UserException;

public class Preservativo extends Partido {

	private LocalDate fechaCreacion;

	@Override
	public void validar() {
		super.validar();

		if (fechaCreacion == null) {
			throw new UserException("Debe ingresar fecha de creación");
		}

		if (fechaCreacion.compareTo(LocalDate.now()) > 0) {
			throw new UserException(
					"La fecha de creación debe ser anterior a la de hoy");
		}
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
