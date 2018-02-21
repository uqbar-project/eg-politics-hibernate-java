package ar.edu.politics.domain;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.annotations.Observable;
import org.uqbar.commons.model.exceptions.UserException;

@Observable
public class Partido extends Entity {
	
	private static final long serialVersionUID = 4340041658885203020L;
	private String nombre;
	private int afiliados;

	public void validar() {
		if (nombre == null) {
			throw new UserException("Debe ingresar nombre");
		}

		if ((this.afiliados < 1000)) {
			throw new UserException("El partido no tiene suficientes afiliados");
		}
	}

	public String toString() {
		return this.nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public int getAfiliados() {
		return this.afiliados;
	}

	public void setAfiliados(final int afiliados) {
		this.afiliados = afiliados;
	}

}
