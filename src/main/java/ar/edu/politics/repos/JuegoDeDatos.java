package ar.edu.politics.repos;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import ar.edu.politics.domain.Candidato;
import ar.edu.politics.domain.Partido;
import ar.edu.politics.domain.Peronista;
import ar.edu.politics.domain.Preservativo;
import ar.edu.politics.domain.Promesa;
import ar.edu.politics.domain.Zona;

public class JuegoDeDatos {
	
	private Peronista frejuli;
	private Peronista perone;
	private Preservativo prime;

	private Candidato sosa;
	private Candidato benitez;
	private Candidato yapura;
	private Candidato ramos;
	private Candidato monti;
	private Candidato rota;
	private Candidato cafrune;

	private Zona nacional;
	private Zona springfield;

	public void initPartidos() {
		frejuli = new Peronista();
		frejuli.setAfiliados(60000);
		frejuli.setNombre("FREJULI");
		frejuli.setPopulista(true);

		perone = new Peronista();
		perone.setAfiliados(5000);
		perone.setNombre("Perone");
		perone.setPopulista(false);

		prime = new Preservativo();
		prime.setAfiliados(1200);
		prime.setNombre("PRIME");
		prime.setFechaCreacion(new Date(109, 1, 2));

		this.crearPartidos(frejuli);
		this.crearPartidos(perone);
		this.crearPartidos(prime);
	}

	public void crearPartidos(Partido partido) {
		RepoPartidos repoPartidos = RepoPartidos.getInstance();
		if (repoPartidos.searchByExample(partido).isEmpty()) {
			repoPartidos.create(partido);
			System.out.println("Partido " + partido.getNombre() + " creado");
		}
	}

	public void initCandidatos() {
		sosa = new Candidato();
		sosa.setNombre("Julio Sosa");
		sosa.setPartido(frejuli);
		sosa.setPromesas(new ArrayList<Promesa>(
			asList(
				new Promesa("Terminar con la inseguridad"),
				new Promesa("Aborto para unos, banderitas para otros"))));
		
		benitez = new Candidato();
		benitez.setNombre("Myriam Benitez");
		benitez.setPartido(frejuli);
		benitez.setPromesas(new ArrayList<Promesa>(
			asList(
				new Promesa("Girar y girar hacia la libertad"))));
		
		yapura = new Candidato();
		yapura.setNombre("Marcelo Yapura");
		yapura.setPartido(frejuli);
		yapura.setPromesas(new ArrayList<Promesa>(
			asList(
				new Promesa("Terminar con la pobreza"),
				new Promesa("Que todos los docentes de la UTN cobren en euros"))));
		
		ramos = new Candidato();
		ramos.setNombre("Manuel Ramos");
		ramos.setPartido(perone);
		ramos.setPromesas(new ArrayList<Promesa>(
			asList(
				new Promesa("Terminar con la inseguridad"),
				new Promesa("Recuperar la confianza de los argentinos"))));
		
		monti = new Candidato();
		monti.setNombre("Yaco Monti");
		monti.setPartido(perone);
		monti.setPromesas(new ArrayList<Promesa>(
			asList(
				new Promesa("Terminar con la inseguridad"), 
				new Promesa("Recuperar la dignidad"))));
		
		rota = new Candidato();
		rota.setNombre("Nino Rota");
		rota.setPartido(prime);
		rota.setPromesas(new ArrayList<Promesa>(
			asList(
				new Promesa("Ganarle a la pobreza"), 
				new Promesa("Sacar el cepo a la moneda extranjera"),
				new Promesa("Eliminar el impuesto a las ganancias"))));
		
		cafrune = new Candidato();
		cafrune.setNombre("Yamila Cafrune");
		cafrune.setPartido(prime);
		cafrune.setPromesas(new ArrayList<Promesa>(
			asList(
				new Promesa("Terminar con Futbol para Todos"),
				new Promesa("Privatizar las empresas del estado"), 
				new Promesa("Dolarizar la economia"))));
		
		this.crearCandidato(sosa);
		this.crearCandidato(benitez);
		this.crearCandidato(yapura);
		this.crearCandidato(ramos);
		this.crearCandidato(monti);
		this.crearCandidato(rota);
		this.crearCandidato(cafrune);
	}

	public void crearCandidato(Candidato candidato) {
		RepoCandidatos repoCandidatos = RepoCandidatos.getInstance();
		if (repoCandidatos.searchByExample(candidato).isEmpty()) {
			repoCandidatos.create(candidato);
			System.out.println("Candidato " + candidato.getNombre() + " creado");
		}
	}

	public void initZonas() {
		nacional = new Zona();
		nacional.setDescripcion("Elecciones nacionales");
		nacional.setCandidatos(Arrays.asList(sosa, benitez, ramos, rota));
		
		springfield = new Zona();
		springfield.setDescripcion("Springfield");
		springfield.setCandidatos(Arrays.asList(yapura, monti, cafrune));
		
		this.crearZona(nacional);
		this.crearZona(springfield);
	}

	public void crearZona(Zona zona) {
		RepoZonas repoZonas = RepoZonas.getInstance();
		if (repoZonas.searchByExample(zona).isEmpty()) {
			repoZonas.create(zona);
			System.out.println("Zona " + zona.getDescripcion() + " creada");
		}
	}

	public void init() {
		initPartidos();
		initCandidatos();
		initZonas();
	}

}
