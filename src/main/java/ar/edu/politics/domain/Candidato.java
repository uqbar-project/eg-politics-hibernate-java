package ar.edu.politics.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
public class Candidato extends Entity {

	private String nombre;
	private Partido partido;
	private List<Promesa> promesas = new ArrayList<>();

	public void validar() {
		if (nombre == null) {
			throw new UserException("Debe ingresar descripcion");
		}
		if (partido == null) {
			throw new UserException(
					"El candidato debe estar participando en un partido político");
		}
	}

	@Override
	public String toString() {
		return nombre;
	}

	public void agregarPromesa(String nuevaPromesa) {
		promesas.add(new Promesa(nuevaPromesa));
		ObservableUtils.firePropertyChanged(this, "promesas", promesas);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public List<Promesa> getPromesas() {
		return promesas;
	}

	public void setPromesas(List<Promesa> promesas) {
		this.promesas = new ArrayList<Promesa>(promesas);
	}
	
}
