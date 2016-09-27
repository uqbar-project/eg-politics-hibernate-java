package ar.edu.politics.repos;

import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedRepo;

import ar.edu.politics.domain.Candidato;

public class RepoCandidatos extends CollectionBasedRepo<Candidato> {

	private static RepoCandidatos instance;
	
	public static RepoCandidatos getInstance() {
		if (instance == null) {
			instance = new RepoCandidatos();
		}
		return instance;
	}
	
	@Override
	public Candidato createExample() {
		return new Candidato();
	}

	@Override
	public Class<Candidato> getEntityType() {
		return Candidato.class;
	}

	@Override
	protected Predicate<Candidato> getCriterio(Candidato example) {
		return (Candidato candidato) -> candidato.getNombre().equals(example.getNombre());
	}

}
