package ar.edu.politics.domain;

import java.util.Date;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
public class Promesa {

	private String accionPrometida;
	private Date fecha;

	public Promesa(String accionPrometida) {
		this.fecha = new Date();
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
