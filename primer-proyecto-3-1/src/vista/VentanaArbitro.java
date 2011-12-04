package vista;

import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;



public class VentanaArbitro extends JFrame {
	
	private JTextField txtCedulaArb ;
	private JComboBox cmbCedulaArb; 
	private JTextField txtNombreArb;
	private JTextField txtApellidoArb;
	private JTextField txtFechaNacDiaArb;
	private JTextField txtFechaNacMesArb;
	private JTextField txtFechaNacAnioArb;
	private JTextField txtFechaNacimientoArb;
	private JButton btnGuardarArb;
	private JButton btnCancelarArb;
	private JButton btnSalirArb;
	
	
   public VentanaArbitro (){
	   
	   super ("Liga de Futbol - Arbitro");
	   ImageIcon imgArbitro= new ImageIcon(getClass().getResource("imagenes" + File.separator + "arbitros.jpg"));
       ImageIcon imgGuardar= new ImageIcon(getClass().getResource("imagenes" + File.separator + "guardar.jpg"));
       ImageIcon imgCancelar= new ImageIcon(getClass().getResource("imagenes" + File.separator + "cancelar.jpg"));
       ImageIcon imgSalir= new ImageIcon(getClass().getResource("imagenes" + File.separator + "salir.jpg"));

	   
       JPanelGradiente panel = new JPanelGradiente();
	   JLabel lblLogo= new JLabel(imgArbitro);
	   
	   JLabel lblRegistrarArbitro = new JLabel ("ARBITRO");
	   JLabel lblCedulaArb = new JLabel ("Cedula");
	   cmbCedulaArb = new JComboBox (new String[] {"V", "E"} ); 
	   JLabel lblNombreArb = new JLabel ("Nombre");
	   JLabel lblApellidoArb = new JLabel ("Apellido");
	   JLabel lblFechadeArb = new JLabel ("Fecha de");
	   JLabel lblNacimientoArb = new JLabel ("Nacimiento");
	   
	   
	   btnGuardarArb = new JButton (imgGuardar);
	   btnCancelarArb = new JButton (imgCancelar);
	   btnSalirArb = new JButton (imgSalir);
	   
	   txtCedulaArb = new JTextField();
	   txtNombreArb = new JTextField();
	   txtApellidoArb = new JTextField();
	   txtFechaNacDiaArb = new JTextField();
	   txtFechaNacMesArb = new JTextField();
	   txtFechaNacAnioArb = new JTextField();
	   txtFechaNacimientoArb= new JTextField();
	   
	   txtCedulaArb.setName("txtCedulaArb");
	   txtNombreArb.setName("txtNombreArb");
	   txtApellidoArb.setName("txtApellidoArb");
	   txtFechaNacDiaArb.setName("txtFechaNacDiaArb");
	   txtFechaNacMesArb.setName("txtFechaNacMesArb");
	   txtFechaNacAnioArb.setName("txtFechaNacAnioArb");
	   
	   btnGuardarArb.setActionCommand("Guardar");
	   btnCancelarArb.setActionCommand("Cancelar");
	   btnSalirArb.setActionCommand("Salir");
	   
	   panel.setLayout(null);
	   
	   panel.add(lblLogo);
	   lblLogo.setBounds(370, 50, 80, 80);
	   
	   panel.add(lblRegistrarArbitro);
	   lblRegistrarArbitro.setBounds(100, 20, 100, 20);
	   
	   panel.add(lblCedulaArb);
	   lblCedulaArb.setBounds(60, 50, 60, 25);
	   
	   panel.add(txtCedulaArb);
	   txtCedulaArb.setBounds(200, 50 , 80, 25);
	   
	   panel.add(cmbCedulaArb);
	   cmbCedulaArb.setBounds(160, 50, 35, 25);
	   
	   panel.add(lblNombreArb);
	   lblNombreArb.setBounds(60, 90, 60, 25);
	   
	   panel.add(txtNombreArb);
	   txtNombreArb.setBounds(160, 90, 190, 25);
	   
	  panel.add(lblApellidoArb);
	   lblApellidoArb.setBounds(60, 130, 60, 25);
	   
	   panel.add(txtApellidoArb);
	   txtApellidoArb.setBounds(160, 130, 190, 25);
	  
	   panel.add(lblFechadeArb);
	   lblFechadeArb.setBounds(60, 162, 80, 25);
	   
	   panel.add(lblNacimientoArb);
	   lblNacimientoArb.setBounds(60, 178, 80, 25);
	   
	   panel.add(txtFechaNacimientoArb);
	   txtFechaNacimientoArb.setBounds(160, 170, 90, 25);
	   
	   panel.add(txtFechaNacDiaArb);
	   txtFechaNacDiaArb.setBounds(160, 170, 30, 25);
	   
	   panel.add(txtFechaNacMesArb);
	   txtFechaNacMesArb.setBounds(195, 170, 30, 25);
	   
	   panel.add(txtFechaNacAnioArb);
	   txtFechaNacAnioArb.setBounds(230, 170, 55, 25);
	   
	   panel.add(btnGuardarArb);
	   btnGuardarArb.setBounds(60, 220, 80 , 80);
	   
	   panel.add(btnCancelarArb);
	   btnCancelarArb.setBounds(180, 220, 80, 80);
	   
	   panel.add(btnSalirArb);
	   btnSalirArb.setBounds(300, 220, 80, 80);
	   
	   	this.add(panel);
		this.setVisible(true);
		this.setSize(500, 400);	
   }
   
		public void addListener(ActionListener l){
			btnGuardarArb.addActionListener(l);
			btnCancelarArb.addActionListener(l);
			btnSalirArb.addActionListener(l);
		}
		
		public void addListener(WindowListener l){
			this.addWindowListener(l);
		}
		
		public void addListener(KeyListener l){
			txtCedulaArb.addKeyListener(l);
			txtFechaNacDiaArb.addKeyListener(l);
			txtFechaNacMesArb.addKeyListener(l);
			txtFechaNacAnioArb.addKeyListener(l);
			txtNombreArb.addKeyListener(l);
			txtApellidoArb.addKeyListener(l);
		}
		
		public void addListener(FocusListener l){
			txtCedulaArb.addFocusListener(l);
		}
		
		public void setTxtCedulaArb(String cedula){
			txtCedulaArb.setText(cedula);
		}
		
		public String getTxtCedulaArb(){
			return txtCedulaArb.getText();	
		}
		
		public void setCmbCedulaArb(String tipoced){
			cmbCedulaArb.setActionCommand(tipoced);
		}
		
		public String getCmbCedulaArb(){
			return (String) cmbCedulaArb.getSelectedItem();
			
		}
		public void setTxtNombreArb(String nombre){
			txtNombreArb.setText(nombre);
		}
		
		public String getTxtNombreArb(){
			return txtNombreArb.getText();
		}
		
		public void setTxtApellidoArb(String apellido){
			txtApellidoArb.setText(apellido);
		}
		
		public String getTxtApellidoArb(){
			return txtApellidoArb.getText();
		}
	   
		public void setTxtFechaNacDiaArb(String fecha){
			txtFechaNacDiaArb.setText(fecha);
		}
		
		public String getTxtFechaNacDiaArb(){
			return txtFechaNacDiaArb.getText();
		} 
		
		public void setTxtFechaNacMesArb(String fecha){
			txtFechaNacMesArb.setText(fecha);
		}
		
		public String getTxtFechaNacMesArb(){
			return txtFechaNacMesArb.getText();
		} 
		
		public void setTxtFechaNacAnioArb(String fecha){
			txtFechaNacAnioArb.setText(fecha);
		}
		
		public String getTxtFechaNacAnioArb(){
			return txtFechaNacAnioArb.getText();
		}
		
		public void deshabilitarGuardar(){
			btnGuardarArb.setEnabled(false);
		}
		
		public void habilitarGuardar(){
			btnGuardarArb.setEnabled(true);
		}
		
		public void deshabilitarCancelar(){
			btnCancelarArb.setEnabled(false);
		}
		
		public void habilitarCancelar(){
			btnCancelarArb.setEnabled(true);
		}
		
		public void visualizarFechaConsulta(){
			txtFechaNacimientoArb.setVisible(true);
			txtFechaNacDiaArb.setVisible(false);
			txtFechaNacMesArb.setVisible(false);
			txtFechaNacAnioArb.setVisible(false);
		}
		
        public void ocultarFechaConsulta(){
        	txtFechaNacimientoArb.setText("");
        	txtFechaNacimientoArb.setVisible(false);
			txtFechaNacDiaArb.setVisible(true);
			txtFechaNacMesArb.setVisible(true);
			txtFechaNacAnioArb.setVisible(true);
		}
        
        public void setTxtFechaNacimientoArb(String txt){
        	txtFechaNacimientoArb.setText(txt);
        }
        
        public void guardado(){
        	txtCedulaArb.setEnabled(false);
        	txtNombreArb.setEnabled(false);
        	txtApellidoArb.setEnabled(false);
        	txtFechaNacimientoArb.setEnabled(false);
        	cmbCedulaArb.setEnabled(false);
        	deshabilitarGuardar();
        	habilitarCancelar();
        }
        
        public void cancelar(){
        	txtCedulaArb.setEnabled(true);
        	txtNombreArb.setEnabled(true);
        	txtApellidoArb.setEnabled(true);
        	cmbCedulaArb.setEnabled(true);
        }
}
	   
