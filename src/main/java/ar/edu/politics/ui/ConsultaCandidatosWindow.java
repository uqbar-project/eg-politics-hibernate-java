package ar.edu.politics.ui;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import ar.edu.politics.appModel.ConsultaCandidatos;
import ar.edu.politics.appModel.VerCandidato;
import ar.edu.politics.domain.Candidato;
import ar.edu.politics.domain.Zona;

public class ConsultaCandidatosWindow extends SimpleWindow<ConsultaCandidatos> {

	private static final long serialVersionUID = -998931966763091828L;

	public ConsultaCandidatosWindow(WindowOwner parent) {
		super(parent, new ConsultaCandidatos());
	}
	
	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel)
			.setCaption("Ver ficha")
			.onClick(() -> {
				Candidato candidatoSeleccionado = this.getModelObject().getCandidatoSeleccionado();
				new VerCandidatoDialog(this, new VerCandidato(candidatoSeleccionado)).open();
			})
			.bindEnabledToProperty("puedeVerFicha");
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Consulta candidatos");
		
		new Label(mainPanel)
			.setText("Zona de votación");
		
		Selector<Zona> selectorVotacion = new Selector<Zona>(mainPanel);
		selectorVotacion.allowNull(false);
		selectorVotacion.bindValueToProperty("zonaSeleccionada");
		selectorVotacion.bindItemsToProperty("zonasDeVotacion");
		                		
		new Label(mainPanel).setText("Candidatos");
		
		Table<Candidato> gridCandidatos = new Table<Candidato>(mainPanel, Candidato.class);
		gridCandidatos.bindItemsToProperty("zonaSeleccionada.candidatos");
		gridCandidatos.bindValueToProperty("candidatoSeleccionado");
		gridCandidatos.setNumberVisibleRows(10);
		
		new Column<Candidato>(gridCandidatos)
			.setTitle("Candidato")
			.setFixedSize(200)
			.bindContentsToProperty("nombre");
		                		

		new Column<Candidato>(gridCandidatos)
			.setTitle("Partido")
			.setFixedSize(300)
			.bindContentsToProperty("partido");

	}

}
