package vista;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VentanaGenerarPartido extends JFrame{
	
	private JButton btnGenerarPartidos;
	private JButton btnSalirGp; 
	
	
	public VentanaGenerarPartido(){
		super ("Liga de Futbol- Partido");
		JPanel panel = new JPanel();
		
	    ImageIcon imgCancha= new ImageIcon(getClass().getResource("imagenes" + File.separator + "cancha.jpg"));
        ImageIcon imgGenerarp= new ImageIcon(getClass().getResource("imagenes" + File.separator + "generar partido.jpg"));
        ImageIcon imgSalir= new ImageIcon(getClass().getResource("imagenes" + File.separator + "salir.jpg"));
		
		JLabel lblPartidos = new JLabel ("Generar Partidos");
		JLabel lblLogo= new JLabel(imgCancha);
		
		btnGenerarPartidos = new JButton(imgGenerarp);
		btnSalirGp = new JButton(imgSalir);

		btnGenerarPartidos.setActionCommand("Generar Partidos");
		btnSalirGp.setActionCommand("Salir");
		
		panel.setLayout(null);
		
		panel.add(lblPartidos);
		lblPartidos.setBounds(210, 20, 100, 20);
		
		panel.add(lblLogo);
	    lblLogo.setBounds(70, 50, 400, 260);
		
		
		panel.add(btnGenerarPartidos);
		btnGenerarPartidos.setBounds(140, 330, 80, 80);
		
		panel.add(btnSalirGp);
		btnSalirGp.setBounds(310, 330, 80, 80);
		
		this.add(panel);
		this.setVisible(true);
		this.setSize(550, 500);	
   }
	
	public void addListener(ActionListener l){
		btnGenerarPartidos.addActionListener(l);
		btnSalirGp.addActionListener(l);
	}
	
	public void addListener(WindowListener l){
		this.addWindowListener(l);
	}
	
	public void deshabilitarGenerarPartido(){
		btnGenerarPartidos.setEnabled(false);
	}
	
	public void habilitarGenerarPartido(){
		btnGenerarPartidos.setEnabled(true);
	}
	
	public JButton getBtnGenerarPartidos(){
		return btnGenerarPartidos;
	}
	
	public JButton getBtnSalirGp(){
		return btnSalirGp;
	}
}

