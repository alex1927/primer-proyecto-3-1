package controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import vista.VentanaEquipo;
import vista.VentanaGenerarPartido;
import vista.VentanaPrincipal;
import vista.VentanaArbitro;
import vista.VentanaReportes;
import modelo.Liga;




public class ControladorVentanaPrincipal implements ActionListener{

	private VentanaPrincipal ventana; 
	private Liga liga;

	public ControladorVentanaPrincipal(VentanaPrincipal vp)
	{
		this.ventana = vp;
		this.ventana.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent a) {
		
		if(a.getSource()==ventana.getBtnArbitro())
		{
			new ControladorVentanaArbitro();
			this.ventana.setVisible(false);
			this.ventana.dispose();
		}
		else if (a.getSource()==ventana.getBtnEquipo())
		{
			new ControladorVentanaEquipo();
			this.ventana.setVisible(false);
			this.ventana.dispose();
		}
		else if (a.getSource()==ventana.getBtnPartido())
		{
			new ControladorVentanaGenerarPartido();
			this.ventana.setVisible(false);
			this.ventana.dispose();
		}
		else if (a.getSource()==ventana.getBtnReporte())
		{
			new ControladorVentanaReportes();
			this.ventana.setVisible(false);
			this.ventana.dispose();
		}
		else if (a.getSource()==ventana.getBtnSalirPrincipal())
        {
           this.ventana.setVisible(false);
           this.ventana.dispose();
           System.exit(0);
        }
			
		
	}

	public ControladorVentanaPrincipal() {
		ventana = new VentanaPrincipal();
		
	
    }


}
