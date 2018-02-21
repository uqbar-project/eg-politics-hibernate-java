package ar.edu.politics.domain;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.annotations.Observable;
import org.uqbar.commons.model.exceptions.UserException;

@Observable
public class Zona extends Entity {

	private static final long serialVersionUID = 5892343603843828245L;
	private String descripcion;
	private List<Candidato> candidatos = new ArrayList<>();

	public void validar() {
		if (descripcion == null) {
			throw new UserException("Debe ingresar descripcion");
		}
		if (candidatos.isEmpty()) {
			throw new UserException(
					"Debe haber al menos un candidato en la zona");
		}
	}

	public String toString() {
		return descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

}
