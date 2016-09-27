package ar.edu.politics.application;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import ar.edu.politics.ui.ConsultaCandidatosWindow;

@SuppressWarnings("all")
public class PoliticsApplication extends Application {

	public PoliticsApplication(PoliticsBootstrap politicsBootstrap) {
		super(politicsBootstrap);
	}

	protected Window<?> createMainWindow() {
		return new ConsultaCandidatosWindow(this);
	}

	public static void main(final String[] args) {
		PoliticsApplication politicsApplication = new PoliticsApplication(new PoliticsBootstrap());
		politicsApplication.start();
	}
	
}
