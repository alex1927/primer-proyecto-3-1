package vista;

import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.io.File;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;

import modelo.Partido;

public class VentanaEquipo extends JFrame{

	private JTextField txtCodigoEq;
	private JTextField txtNombreEq;
	private JTextField txtAnioFundEq;
	private JTextField txtCiudadEq;
	private JTextField txtNombEstEq;
	private JButton btnCargarJugadores;
	private JButton btnGuardarEq;
	private JButton btnCancelarEq;
	private JButton btnSalirEq;

public VentanaEquipo(){
	
	super ("Liga de Futbol- Equipo");
    ImageIcon imgGuardar= new ImageIcon(getClass().getResource("imagenes" + File.separator + "guardar.jpg"));
    ImageIcon imgCancelar= new ImageIcon(getClass().getResource("imagenes" + File.separator + "cancelar.jpg"));
    ImageIcon imgSalir= new ImageIcon(getClass().getResource("imagenes" + File.separator + "salir.jpg"));
	
	
	
	JPanelGradiente panel= new JPanelGradiente();
	JLabel lblRegistrarEquipo = new JLabel ("EQUIPO");
	JLabel lblCodigoEq = new JLabel ("Codigo");
	JLabel lblNombreEq = new JLabel ("Nombre");
	JLabel lblAnioEq = new JLabel ("Año  de");
	JLabel lblFundEq = new JLabel ("Fundacion");
	JLabel lblCiudadEq =new JLabel ("Ciudad");
	JLabel lblNombEq = new JLabel ("Nombre");
	JLabel lblEstadioEq = new JLabel ("Estadio");
	txtCodigoEq = new JTextField();
	txtNombreEq = new JTextField();
	txtAnioFundEq = new JTextField();
	txtCiudadEq = new JTextField();
	txtNombEstEq = new JTextField();
	btnCargarJugadores = new JButton ("");
	btnGuardarEq = new JButton ("",imgGuardar);
	btnCancelarEq = new JButton ("",imgCancelar);
	btnSalirEq = new JButton ("",imgSalir);
	txtCodigoEq = new JTextField ();
	txtNombreEq  = new JTextField ();
	txtAnioFundEq = new JTextField ();
	txtNombEstEq = new JTextField ();
	
	txtCodigoEq.setName("txtCodigoEq");
	txtNombreEq.setName("txtNombreEq");
	txtAnioFundEq.setName("txtAnioFundEq");
	txtCiudadEq.setName("txtCiudadEq");
	txtNombEstEq.setName("txtNombEstEq");
	
	   
	btnGuardarEq.setActionCommand("Guardar");
	   	
	panel.setLayout(null);
	
	panel.add(lblRegistrarEquipo);
	lblRegistrarEquipo.setBounds(200, 20, 140, 20);
	
	panel.add(lblCodigoEq);
	lblCodigoEq.setBounds(60, 60, 120, 25);
	
	panel.add(txtCodigoEq);
	txtCodigoEq.setBounds(160, 60, 120, 25);
	
	panel.add(lblNombreEq);
	lblNombreEq.setBounds(60, 100, 50 , 25);
	
	panel.add(txtNombreEq);
	txtNombreEq.setBounds(160, 100 ,120 , 25);
	
	panel.add(lblAnioEq);
	lblAnioEq.setBounds(60, 130, 110, 25);
	
	panel.add(lblFundEq);
	lblFundEq.setBounds(60, 145, 110, 25);
	
	panel.add(txtAnioFundEq);
	txtAnioFundEq.setBounds(160, 140, 80, 25);
	
	
	panel.add(lblCiudadEq);
	lblCiudadEq.setBounds(60, 180, 130, 25);
	
	panel.add(txtCiudadEq);
	txtCiudadEq.setBounds(160, 180, 130, 25);
	
	panel.add(lblNombEq);
	lblNombEq.setBounds(60, 210, 130, 25);
	
	panel.add(lblEstadioEq);
	lblEstadioEq.setBounds(60, 225, 130, 25);
	
	panel.add(txtNombEstEq);
	txtNombEstEq.setBounds(160, 220, 130, 25);
	
	panel.add(btnGuardarEq);
	btnGuardarEq.setBounds(60, 280, 80, 80);
	
	panel.add(btnCancelarEq);
	btnCancelarEq.setBounds(180, 280, 80, 80);
	
	panel.add(btnSalirEq);
	btnSalirEq.setBounds(300, 280, 80, 80);
	
 	this.add(panel);
		this.setVisible(true);
		this.setSize(600, 450);	
   }

		public void addListener(ActionListener l){
			btnGuardarEq.addActionListener(l);
			btnCargarJugadores.addActionListener(l);
			btnCancelarEq.addActionListener(l);
			btnSalirEq.addActionListener(l);
			
		}
		
		public void addListener(WindowListener l){
			this.addWindowListener(l);
		}
		
		public void addListener(KeyListener l){
			txtCodigoEq.addKeyListener(l);
			txtNombreEq.addKeyListener(l);
			txtAnioFundEq.addKeyListener(l);
			txtCiudadEq.addKeyListener(l);
			txtNombEstEq.addKeyListener(l);
		}
		
		public void addListener(FocusListener l){
			txtCodigoEq.addFocusListener(l);
		}
		
		public void setTxtCodigoEq(String codigo){
			txtCodigoEq.setText(codigo);
		}
   
		public String getTxtCodigoEq(){
			return txtCodigoEq.getText();
		}
		
		public void setTxtNombreEq(String nombre){
			txtNombreEq.setText(nombre);
		}
   
		public String getTxtNombreEq(){
			return txtNombreEq.getText();	
		} 
  
		public void setTxtAnioFundEq(String aniofundacion){
			txtAnioFundEq.setText(aniofundacion);
		}
		public String getTxtAnioFundEq(){
    		return txtAnioFundEq.getText();
		}
		
		public void setTxtCiudadEq(String ciudad){
			txtCiudadEq.setText(ciudad);
		}
	
		public String getTxtCiudadEq(){
			return txtCiudadEq.getText();
		}
		
		public void setTxtNombEstEq(String estadio){
		    txtNombEstEq.setText(estadio);
		}
		
		public String getTxtNombEstEq(){
			return txtNombEstEq.getText();
		}

		 public void deshabilitarGuardar(){
				btnGuardarEq.setEnabled(false);
			}
			
			public void habilitarGuardar(){
				btnGuardarEq.setEnabled(true);
			}
			
			
			public void habilitarCancelar(){
				btnCancelarEq.setEnabled(true);
			}
			
			public void deshabilitarCancelar(){
				btnCancelarEq.setEnabled(false);
			}
			
			public void habilitarSalir(){
				btnSalirEq.setEnabled(true);
			}
			
			public JButton getBtnGuardarEq() {
				return btnGuardarEq;
			}

			public JButton getBtnCancelarEq() {
				return btnCancelarEq;
			}
	        
			public JButton getBtnSalirEq() {
				return btnSalirEq;
			}
	        
	        public void guardado(){
	        	txtCodigoEq.setEnabled(false);
	        	txtNombreEq.setEnabled(false);
	        	txtAnioFundEq.setEnabled(false);
	        	txtCiudadEq.setEnabled(false);
	        	txtNombEstEq.setEnabled(false);
	        	deshabilitarGuardar();
	        	habilitarCancelar();
	        }
	        
	        public void cancelar(){
	        	txtCodigoEq.setEnabled(true);
	        	txtNombreEq.setEnabled(true);
	        	txtAnioFundEq.setEnabled(true);
	        	txtCiudadEq.setEnabled(true);
	        	txtNombEstEq.setEnabled(true);
	        	//habilitarGuardar();
	        }
}
		   




