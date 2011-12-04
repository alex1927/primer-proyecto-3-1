package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import modelo.Liga;
import modelo.Partido;
import vista.VentanaAviso;
import vista.VentanaPrincipal;
import vista.VentanaReportes;
import vista.VentanaTablaPosiciones;

public class ControladorVentanaReportes implements ActionListener,WindowListener {
	
	private VentanaReportes ventana;

	public ControladorVentanaReportes() {
		ventana = new VentanaReportes();
		ventana.addListener((ActionListener)this);
		ventana.addListener((WindowListener)this);
	}

	private void cerrarVentana()
    {
	 new VentanaPrincipal();
     this.ventana.setVisible(false);
     this.ventana.dispose();  
    }
	
	public boolean isJuegosGenerados(){
		boolean juegosGenerados= true;
		
		for (Partido p:Liga.getListaPartido()){
			if (!p.isJuegosGenerados()){
				juegosGenerados= false;
				break;
			}	
		}
		
		return juegosGenerados;
	}


	public void actionPerformed(ActionEvent a) {

		if (!isJuegosGenerados())
		{
		if (a.getActionCommand().equalsIgnoreCase("Tabla Posiciones"))
		{
			new ControladorVentanaTablaPosiciones(this);
			this.ventana.setVisible(false);
			this.ventana.dispose();
		}
		else if (a.getActionCommand().equalsIgnoreCase("Calendario"))
		{
			new ControladorVentanaCalendario(this);
			this.ventana.setVisible(false);
			this.ventana.dispose();
		}
		else if(a.getActionCommand().equalsIgnoreCase("Salir"))
		{
			cerrarVentana();
		}
		}
		else
		{
			if (a.getActionCommand().equalsIgnoreCase("Tabla Posiciones"))
			{
              	VentanaAviso.mostrarAviso("Deben Generarse Primero los Juegos");
			}
			else if (a.getActionCommand().equalsIgnoreCase("Calendario"))
			{
              	VentanaAviso.mostrarAviso("Deben Generarse Primero los Juegos");
			}
			if(a.getActionCommand().equalsIgnoreCase("Salir"))
			{
				cerrarVentana();
			}
		}
		
	}
	
	public void visualizarVentana(){
		ventana.setVisible(true);
	}
	
	public void ocultarVentana(){
		ventana.setVisible(false);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		cerrarVentana();
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
