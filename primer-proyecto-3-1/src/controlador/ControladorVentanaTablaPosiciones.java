package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import vista.VentanaAviso;
import vista.VentanaPrincipal;
import vista.VentanaReportes;
import vista.VentanaTablaPosiciones;

public class ControladorVentanaTablaPosiciones implements ActionListener,WindowListener {
	private VentanaTablaPosiciones ventana;
	private ControladorVentanaReportes controladorVentanaReporte;
	
	public ControladorVentanaTablaPosiciones(ControladorVentanaReportes c) {
		ventana = new VentanaTablaPosiciones();
		controladorVentanaReporte=c;
		ventana.addListener((ActionListener)this);
		ventana.addListener((WindowListener)this);
	}
	
	private void cerrarVentana()
    {
		controladorVentanaReporte.visualizarVentana();
        this.ventana.setVisible(false);
        this.ventana.dispose();  
 
   }

	
public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equalsIgnoreCase("Guardar"))
		{
		    VentanaAviso.mostrarAviso("Los Juegos se han Generado");
		}
		else if (e.getActionCommand().equalsIgnoreCase("Salir"))
		{
			cerrarVentana();
		}
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
