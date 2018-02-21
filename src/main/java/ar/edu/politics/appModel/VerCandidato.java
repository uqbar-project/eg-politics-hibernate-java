package ar.edu.politics.appModel;

import org.uqbar.commons.model.annotations.Dependencies;
import org.uqbar.commons.model.annotations.Observable;

import ar.edu.politics.domain.Candidato;
import ar.edu.politics.repos.RepoCandidatos;

@Observable
public class VerCandidato {
	private Candidato candidato;
	private String nuevaPromesa;

	public VerCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public void agregarPromesa() {
		candidato.agregarPromesa(nuevaPromesa);
		nuevaPromesa = "";
	}

	@Dependencies("nuevaPromesa")
	public boolean getPuedeAgregarPromesa() {
		return nuevaPromesa != null && !nuevaPromesa.equals("");
	}

	public void actualizar() {
		RepoCandidatos.getInstance().update(candidato);
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public String getNuevaPromesa() {
		return nuevaPromesa;
	}

	public void setNuevaPromesa(String nuevaPromesa) {
		this.nuevaPromesa = nuevaPromesa;
	}

}
