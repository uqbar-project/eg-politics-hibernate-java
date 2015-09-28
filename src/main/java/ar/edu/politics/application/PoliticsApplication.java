package ar.edu.politics.application;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import ar.edu.politics.repos.JuegoDeDatos;
import ar.edu.politics.ui.ConsultaCandidatosWindow;

@SuppressWarnings("all")
public class PoliticsApplication extends Application {
	
  protected Window<?> createMainWindow() {
    return new ConsultaCandidatosWindow(this);
  }
  
  public static void main(final String[] args) {
    JuegoDeDatos juegoDeDatos = new JuegoDeDatos();
    juegoDeDatos.init();
    PoliticsApplication politicsApplication = new PoliticsApplication();
    politicsApplication.start();
  }
}
