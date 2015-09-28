package ar.edu.politics.repos;

import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;

import ar.edu.politics.domain.Partido;

public class RepoPartidos extends CollectionBasedHome<Partido> {

	private static RepoPartidos instance;
	
	static RepoPartidos getInstance() {
		if (instance == null) {
			instance = new RepoPartidos();
		}
		return instance;
	}
	
	@Override
	public Partido createExample() {
		return new Partido();
	}

	@Override
	public Class<Partido> getEntityType() {
		return Partido.class;
	}

	@Override
	protected Predicate<Partido> getCriterio(Partido example) {
		return (Partido partido) -> partido.getNombre().equalsIgnoreCase(example.getNombre());
	}

}
