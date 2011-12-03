package vista;

import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import controlador.ControladorVentanaPrincipal;
import modelo.Partido;
import javax.swing.ImageIcon;;


public class VentanaPrincipal extends JFrame {

	private JButton btnArbitro;
	private JButton btnEquipo; 
	private JButton btnPartido;
	private JButton btnReporte;
	private JButton btnSalirPrincipal;


public VentanaPrincipal (){
	
	super ("Liga de Futbol");
	ImageIcon imgPrincipal= new ImageIcon(getClass().getResource("imagenes" + File.separator + "inicio.jpg"));
	ImageIcon imgArbitro= new ImageIcon(getClass().getResource("imagenes" + File.separator + "arbitro.jpg"));
    ImageIcon imgEquipo= new ImageIcon(getClass().getResource("imagenes" + File.separator + "equipo.jpg"));
    ImageIcon imgPartido= new ImageIcon(getClass().getResource("imagenes" + File.separator + "partidos.jpg"));
    ImageIcon imgReporte= new ImageIcon(getClass().getResource("imagenes" + File.separator + "reportes.jpg"));
    ImageIcon imgSalirPrincipal= new ImageIcon(getClass().getResource("imagenes" + File.separator + "salir.jpg"));
	
	   JPanel panel = new JPanel();
	   btnArbitro = new JButton ("",imgArbitro);
	   btnEquipo = new JButton ("",imgEquipo);
	   btnPartido = new JButton ("",imgPartido);
	   btnReporte = new JButton ("",imgReporte);
	   btnSalirPrincipal = new JButton ("",imgSalirPrincipal);
	   JLabel lblLogo= new JLabel(imgPrincipal);
	   
	   panel.setLayout(null);
	   
	   panel.add(lblLogo);
	   lblLogo.setBounds(90, 60, 600, 300);
	   
	   panel.add(btnArbitro);
	   btnArbitro.setBounds(50, 400, 80, 80);
	   
	   panel.add(btnEquipo);
	   btnEquipo.setBounds(200, 400, 80, 80);
	   
	   panel.add(btnPartido);
	   btnPartido.setBounds(350, 400, 80, 80);
	   
	   panel.add(btnReporte);
	   btnReporte.setBounds(500, 400, 80, 80);
	   
	   panel.add(btnSalirPrincipal);
	   btnSalirPrincipal.setBounds(650, 400, 80, 80);
	   
	   this.add(panel);
	   this.setVisible(true);
	   this.setSize(800, 600);
	   
	   /*Asociando la ventana con su Escuchador*/
	      ControladorVentanaPrincipal controlador= new ControladorVentanaPrincipal(this);
	      this.getBtnArbitro().addActionListener(controlador);
	      this.getBtnEquipo().addActionListener(controlador);
	      this.getBtnPartido().addActionListener(controlador);
	      this.getBtnReporte().addActionListener(controlador);
	      this.getBtnSalirPrincipal().addActionListener(controlador);
	      /*****************************************/
	   
}

		public JButton getBtnArbitro() {
			return btnArbitro;
		}

		public JButton getBtnEquipo() {
			return btnEquipo;
		}

		public JButton getBtnPartido() {
			return btnPartido;
		}
		
		public JButton getBtnReporte(){
			return btnReporte;
		}

		public JButton getBtnSalirPrincipal() {
			return btnSalirPrincipal;	
		}
}