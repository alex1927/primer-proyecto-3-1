package vista;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import controlador.ControladorVentanaPrincipal;
import controlador.ControladorVentanaReportes;
import modelo.Partido;

public class VentanaReportes extends JFrame {
	
	private JButton btnTablaPosiciones;
	private JButton btnCalendario;
	private JButton btnSalirRep;
	
	
	public VentanaReportes (){
		super ("Liga de Futbol - Reporte");
		ImageIcon imgReportes= new ImageIcon(getClass().getResource("imagenes" + File.separator + "reporte.jpg"));
		ImageIcon imgTablaPosiciones= new ImageIcon(getClass().getResource("imagenes" + File.separator + "tabla posiciones.jpg"));
	    ImageIcon imgCalendario= new ImageIcon(getClass().getResource("imagenes" + File.separator + "calendario.jpg"));
	    ImageIcon imgSalir= new ImageIcon(getClass().getResource("imagenes" + File.separator + "salir.jpg"));

	    JPanelGradiente panel = new JPanelGradiente();
		JLabel lblLogo= new JLabel(imgReportes);
		JLabel lblReportes = new JLabel ("REPORTES");
		btnTablaPosiciones = new JButton ("",imgTablaPosiciones);
		btnCalendario = new JButton ("",imgCalendario);
		btnSalirRep = new JButton ("",imgSalir);
		
		btnTablaPosiciones.setActionCommand("Tabla Posiciones");
		btnCalendario.setActionCommand("Calendario");
		btnSalirRep.setActionCommand("Salir");
		
		
		panel.setLayout(null);
		
		panel.add(lblLogo);
		lblLogo.setBounds(160, 1, 140, 300);
		
		panel.add(lblReportes);
		lblReportes.setBounds(200, 20, 100, 25);
		
		panel.add(btnTablaPosiciones);
		btnTablaPosiciones.setBounds(50, 250, 80, 80);
		
		panel.add(btnCalendario);
		btnCalendario.setBounds(190, 250, 80, 80);
		
		panel.add(btnSalirRep);
		btnSalirRep.setBounds(340, 250, 80, 80);
		
		this.add(panel);
		this.setVisible(true);
		this.setSize(500, 400);	
		
		
}
	public void addListener(ActionListener l){
		btnTablaPosiciones.addActionListener(l);
		btnCalendario.addActionListener(l);
		btnSalirRep.addActionListener(l);
	}
	
	public void addListener(WindowListener l){
		this.addWindowListener(l);
	}	

}