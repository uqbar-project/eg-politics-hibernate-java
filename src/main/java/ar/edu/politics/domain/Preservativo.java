package ar.edu.politics.domain;

import java.util.Date;

import org.uqbar.commons.model.UserException;

public class Preservativo extends Partido {

	private Date fechaCreacion;

	@Override
	public void validar() {
		super.validar();

		if (fechaCreacion == null) {
			throw new UserException("Debe ingresar fecha de creación");
		}

		if (fechaCreacion.after(new Date())) {
			throw new UserException(
					"La fecha de creación debe ser anterior a la de hoy");
		}
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
