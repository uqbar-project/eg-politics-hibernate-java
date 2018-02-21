package ar.edu.politics.appModel;

import java.util.List;

import org.uqbar.commons.model.annotations.Dependencies;
import org.uqbar.commons.model.annotations.Observable;

import ar.edu.politics.domain.Candidato;
import ar.edu.politics.domain.Zona;
import ar.edu.politics.repos.RepoZonas;

@Observable
public class ConsultaCandidatos {

	private Zona zonaSeleccionada;
	private Candidato candidatoSeleccionado;

	public ConsultaCandidatos() {
		zonaSeleccionada = getZonasDeVotacion().get(0);
	}
	
	@Dependencies("candidatoSeleccionado")
	public boolean getPuedeVerFicha() {
		return candidatoSeleccionado != null;
	}
	
	public List<Zona> getZonasDeVotacion() {
		return RepoZonas.getInstance().allInstances();
	}

	public Zona getZonaSeleccionada() {
		return zonaSeleccionada;
	}

	public void setZonaSeleccionada(Zona zonaSeleccionada) {
		this.zonaSeleccionada = zonaSeleccionada;
	}

	public Candidato getCandidatoSeleccionado() {
		return candidatoSeleccionado;
	}

	public void setCandidatoSeleccionado(Candidato candidatoSeleccionado) {
		this.candidatoSeleccionado = candidatoSeleccionado;
	}

}
