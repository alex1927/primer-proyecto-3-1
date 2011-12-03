package controlador;

import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.ArrayList;
import modelo.Arbitro;
import modelo.Liga;
import modelo.Partido;
import vista.VentanaArbitro;
import vista.VentanaAviso;
import vista.VentanaPrincipal;

public class ControladorVentanaArbitro implements ActionListener,KeyListener,FocusListener,ItemListener,WindowListener
{

	private VentanaArbitro ventana;
	private Liga liga;
	private Partido partido;
	
private void cerrarVentana()
    {
	new VentanaPrincipal();
    this.ventana.setVisible(false);
    this.ventana.dispose();  
    }

private void inicializarVentana(){
	if (partido.isJuegosGenerados())
		this.ventana.deshabilitarGuardar();
	else
	this.ventana.deshabilitarGuardar();
	this.ventana.habilitarCancelar();
	this.ventana.setTxtCedulaArb("");
	this.ventana.setTxtNombreArb("");
	this.ventana.setTxtApellidoArb("");
	this.ventana.setTxtFechaNacDiaArb("");
	this.ventana.setTxtFechaNacMesArb("");
	this.ventana.setTxtFechaNacAnioArb("");
	this.ventana.ocultarFechaConsulta();
}
	
public void buscarArbitro(){
   Arbitro arbitro=null;
   
   for (Arbitro arb:Liga.getListaArbitro()){
	   if (arb.getCedula().equals(ventana.getCmbCedulaArb()+ventana.getTxtCedulaArb())){
	      arbitro= arb;
	      break;
	   }   
   }
   
   if (arbitro!=null){
	   ventana.setTxtNombreArb(arbitro.getNombre());
	   ventana.setTxtApellidoArb(arbitro.getApellido());
	   ventana.visualizarFechaConsulta();
	   ventana.setTxtFechaNacimientoArb(arbitro.getFechaNacimiento());
	   ventana.guardado();
   }
}

public ControladorVentanaArbitro() {
	    partido= new Partido();
		ventana = new VentanaArbitro();
		ventana.addListener((WindowListener)this);
		ventana.addListener((FocusListener)this);
		ventana.addListener((ActionListener)this);
		ventana.addListener((KeyListener)this);
}

public void windowClosing(WindowEvent evt)
{
    cerrarVentana();
}
public void windowOpened(WindowEvent evt)
{
    inicializarVentana();
}

public void actionPerformed(ActionEvent a) {
	
		if (a.getSource()==ventana.getBtnGuardarArb())
		{
			
			Arbitro obj = new Arbitro();
			obj.setCedula(ventana.getCmbCedulaArb()+ventana.getTxtCedulaArb());
			obj.setNombre(ventana.getTxtNombreArb());
			obj.setApellido(ventana.getTxtApellidoArb());
			obj.setFechaNacimiento(ventana.getTxtFechaNacDiaArb()+"/"+ventana.getTxtFechaNacMesArb()+"/"+ventana.getTxtFechaNacAnioArb());
			
			Liga.agregarArbitro(obj);
			
		    VentanaAviso.mostrarAviso("El Arbitro se ha Registrado con Exito");
			inicializarVentana();
		}
		else if (a.getSource()==ventana.getBtnSalirArb())
		{
			cerrarVentana();
		}
		else if (a.getSource()==ventana.getBtnCancelarArb())
		{
			inicializarVentana();
			ventana.cancelar();
		}
	}

	

	public void focusGained(FocusEvent arg0) {
	}

	public void focusLost(FocusEvent e) {
		if (e.getSource() instanceof javax.swing.text.JTextComponent)
		{
			javax.swing.text.JTextComponent txt= (javax.swing.text.JTextComponent) e.getSource();
			
			if (txt.getName().equalsIgnoreCase("txtCedulaArb"));
			{
				if (!ventana.getTxtCedulaArb().isEmpty()){
					ventana.habilitarGuardar();
					buscarArbitro();
				}
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		
		if (e.getSource() instanceof javax.swing.text.JTextComponent)
		{
			javax.swing.text.JTextComponent txt= (javax.swing.text.JTextComponent) e.getSource();
			if (txt.getName().equalsIgnoreCase("txtCedulaArb"));
			{
				if (!ventana.getTxtCedulaArb().isEmpty()){
					if (e.getKeyCode()==KeyEvent.VK_ENTER){
						buscarArbitro();
					}
				}
			}
		}
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent e) {
		
		if (e.getSource() instanceof javax.swing.text.JTextComponent)
		{
			javax.swing.text.JTextComponent txt= (javax.swing.text.JTextComponent) e.getSource();
			
			if (txt.getName().equalsIgnoreCase("txtCedulaArb"))
			{
				 if (!(Character.isDigit(e.getKeyChar()) && ventana.getTxtCedulaArb().length() < 8)){
					  e.consume();
				}
			}
			else if (txt.getName().equalsIgnoreCase("txtFechaNacDiaArb"))
			{
				 if (!(Character.isDigit(e.getKeyChar()) && ventana.getTxtFechaNacDiaArb().length() < 2)){
					  e.consume();
				}
			}
			else if (txt.getName().equalsIgnoreCase("txtFechaNacMesArb"))
			{
				 if (!(Character.isDigit(e.getKeyChar()) && ventana.getTxtFechaNacMesArb().length() < 2)){
					  e.consume();
				}
			}
			else if (txt.getName().equalsIgnoreCase("txtFechaNacAnioArb"))
			{
				 if (!(Character.isDigit(e.getKeyChar()) && ventana.getTxtFechaNacAnioArb().length() < 4)){
					  e.consume();
				}
			}
			else if (txt.getName().equalsIgnoreCase("txtNombreArb"))
			{
				 if (!(Character.isLetter(e.getKeyChar()) || Character.isSpaceChar(e.getKeyChar()))){
					  e.consume();
				}
				 else
				 {
					 e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
				 }
			}
			else if (txt.getName().equalsIgnoreCase("txtApellidoArb"))
			{
				 if (!(Character.isLetter(e.getKeyChar()) || Character.isSpaceChar(e.getKeyChar()))){
					  e.consume();
				}
				 else
				 {
					 e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
				 }
			}

		}

	}

	public void itemStateChanged(ItemEvent arg0) {
	}

	public void windowActivated(WindowEvent arg0) {
	}

	public void windowClosed(WindowEvent arg0) {
	}

	public void windowDeactivated(WindowEvent arg0) {
	}

	public void windowDeiconified(WindowEvent arg0) {
	}
	
	public void windowIconified(WindowEvent arg0) {	
	}
	
}
