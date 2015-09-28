package ar.edu.politics.ui;

import java.awt.Color;
import java.text.SimpleDateFormat;

import org.apache.commons.collections15.Transformer;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import ar.edu.politics.appModel.VerCandidato;
import ar.edu.politics.domain.Promesa;

public class VerCandidatoDialog extends Dialog<VerCandidato> {

	public VerCandidatoDialog(WindowOwner owner, VerCandidato model) {
		super(owner, model);
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		setTitle("Ver ficha de Candidato");	
		
		mainPanel.setLayout(new HorizontalLayout());
		
		Panel panelIzquierdo = new Panel(mainPanel);
		new Label(panelIzquierdo)
			.setText("Candidato")
			.setForeground(Color.DARK_GRAY);
		
		new Label(panelIzquierdo)
			.setBackground(Color.LIGHT_GRAY)
			.setFontSize(12)
			.bindValueToProperty("candidato.nombre");
		
		new Label(panelIzquierdo)
			.setText("Partido")
			.setForeground(Color.DARK_GRAY);
		
		new Label(panelIzquierdo)
			.setBackground(Color.LIGHT_GRAY)
			.setFontSize(12)
			.bindValueToProperty("candidato.partido.nombre");

		Panel panelDerecho = new Panel(mainPanel);

		new Label(panelDerecho)
			.setText("Promesas")
			.setForeground(Color.DARK_GRAY);

		Panel panelPromesaNueva = new Panel(panelDerecho);
		panelPromesaNueva.setLayout(new HorizontalLayout());
		
		new TextBox(panelPromesaNueva)
			.setWidth(200)
			.bindValueToProperty("nuevaPromesa");

		new Button(panelPromesaNueva)
			.setCaption("Agregar promesa")
			.onClick(() -> this.getModelObject().agregarPromesa())
			.bindEnabledToProperty("puedeAgregarPromesa");

		Table<Promesa> gridPromesas = new Table(panelDerecho, Promesa.class);
		gridPromesas.bindItemsToProperty("candidato.promesas");
		
		new Column<Promesa>(gridPromesas)
			.setTitle("Fecha")
			.setFixedSize(100)
			.bindContentsToTransformer( new Transformer<Promesa, String>() {
				@Override
				public String transform(Promesa promesa) {
					return new SimpleDateFormat("dd/MM/yyyy").format(promesa.getFecha());
				}
			});
			
		new Column<Promesa>(gridPromesas)
			.setTitle("Promesa")
			.setFixedSize(500)
			.bindContentsToProperty("accionPrometida");
		
		
		new Button(panelDerecho)
			.setCaption("Actualizar candidato")
			.onClick( () -> {
				this.getModelObject().actualizar();
				this.close();
			});
		
	}

}

