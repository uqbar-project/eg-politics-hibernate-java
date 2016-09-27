package ar.edu.politics.repos;


import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedRepo;

import ar.edu.politics.domain.Zona;

public class RepoZonas extends CollectionBasedRepo<Zona> {

	private static RepoZonas instance;
	
	public static RepoZonas getInstance() {
		if (instance == null) {
			instance = new RepoZonas();
		}
		return instance;
	}
		
	@Override
	protected Predicate<Zona> getCriterio(Zona example) {
		return (Zona zona) -> zona.getDescripcion().equals(example.getDescripcion());
	}

	@Override
	public Zona createExample() {
		return new Zona();
	}
	
	@Override
	public Class<Zona> getEntityType() {
		return Zona.class;
	}

}
