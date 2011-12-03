package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Liga;
import vista.VentanaAviso;
import vista.VentanaPrincipal;
import vista.VentanaReportes;
import vista.VentanaTablaPosiciones;

public class ControladorVentanaReportes implements ActionListener {
	
	private VentanaReportes ventana;

	public ControladorVentanaReportes() {
		ventana = new VentanaReportes();
		ventana.addListener((ActionListener)this);
		
	}

	private void cerrarVentana()
    {
	 new VentanaPrincipal();
     this.ventana.setVisible(false);
     this.ventana.dispose();  
    }
	
		
	public void actionPerformed(ActionEvent a) {
		
		if (a.getSource()==ventana.getBtnTablaPosiciones())
		{
			new ControladorVentanaTablaPosiciones(this);
			this.ventana.setVisible(false);
			this.ventana.dispose();
		}
		else if(a.getSource()==ventana.getBtnSalirRep())
		{
			cerrarVentana();
		}
		
	}
	
	public void visualizarVentana(){
		ventana.setVisible(true);
	}
	
	public void ocultarVentana(){
		ventana.setVisible(false);
	}
}
