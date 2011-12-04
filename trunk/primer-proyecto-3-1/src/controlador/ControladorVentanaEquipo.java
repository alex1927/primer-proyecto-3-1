package controlador;

import modelo.Jugador;

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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import modelo.Equipo;
import modelo.Liga;
import modelo.Partido;
import vista.VentanaEquipo;
import vista.VentanaAviso;
import vista.VentanaPrincipal;

public class ControladorVentanaEquipo implements ActionListener,KeyListener,FocusListener,ItemListener,WindowListener
{
	
	private VentanaEquipo ventana;
	

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

private void inicializarVentana(){
	if (isJuegosGenerados())
		this.ventana.deshabilitarGuardar();
	else
	this.ventana.habilitarGuardar();
	this.ventana.habilitarCancelar();
	this.ventana.habilitarSalir();
	this.ventana.setTxtCodigoEq("");
	this.ventana.setTxtNombreEq("");
	this.ventana.setTxtAnioFundEq("");
	this.ventana.setTxtNombEstEq("");
	this.ventana.setTxtCiudadEq("");
	
}

public void buscarEquipo(){
	   Equipo equipo=null;
	   
	   for (Equipo eq:Liga.getListaEquipo()){
		   if (eq.getCodigoEquipo().equals(ventana.getTxtCodigoEq())){
		      equipo= eq;
		      break;
		   }   
	   }
	   
	   if (equipo!=null){
		   ventana.setTxtCodigoEq(equipo.getCodigoEquipo());
		   ventana.setTxtNombreEq(equipo.getNombreEquipo());
		   ventana.setTxtNombEstEq(equipo.getNombreEstadio());
		   ventana.setTxtCiudadEq(equipo.getCodigoEquipo());
		   ventana.setTxtAnioFundEq(equipo.getAnioFundado());
		   ventana.guardado();
	   }
	   
}
		public ControladorVentanaEquipo() {
			
			
			ventana = new VentanaEquipo();
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

			if (a.getActionCommand().equalsIgnoreCase("Guardar"))
			{
               if (!ventana.getTxtCodigoEq().isEmpty() && 
            	   !ventana.getTxtNombreEq().isEmpty() &&
            	   !ventana.getTxtNombEstEq().isEmpty() &&
            	   !ventana.getTxtCiudadEq().isEmpty()  &&
            	   !ventana.getTxtAnioFundEq().isEmpty())
               {
            	   
				Equipo obj = new Equipo();
				obj.setCodigoEquipo(ventana.getTxtCodigoEq());
				obj.setNombreEquipo(ventana.getTxtNombreEq());
				obj.setNombreEstadio(ventana.getTxtNombEstEq());
				obj.setCiudad(ventana.getTxtCiudadEq());
				obj.setAnioFundado(ventana.getTxtAnioFundEq());
                
				
				File archivo;
	        		
				JFileChooser fc= new JFileChooser();
			    fc.setFileFilter(new FileNameExtensionFilter(".txt","txt"));     
			        
                try{
			         if (fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
			         {
			             archivo = fc.getSelectedFile();

			             BufferedReader entrada= new BufferedReader(new FileReader(archivo));
			             String s;       
			        
			             while ((s=entrada.readLine())!=null)
			        	 {
			        			Jugador jugador= new Jugador();
			        			
			        			jugador.setCedula(s);
			        			jugador.setNombre(entrada.readLine());
			        			jugador.setApellido(entrada.readLine());
			        			jugador.setFechaNacimiento(entrada.readLine());
			        			jugador.setPosicionJuego(entrada.readLine());
			        			
			        			obj.agregarJugador(jugador);
			        	 }
			        		
			        		
			        	  entrada.close();
			           }
			          Liga.agregarEquipo(obj);
			          VentanaAviso.mostrarAviso("El Equipo se ha Guardado con Exito");
			          
                   }
                   catch(IOException e){
                    	VentanaAviso.mostrarAviso("Error Cargando Jugadores de Equipo");
                   }
                   finally{
                	   inicializarVentana();
                   }
                   
                   

              }
              else{
              	VentanaAviso.mostrarAviso("Por Favor Introduzca todos los campos");
              }
            	   
			    
			}
			else if (a.getActionCommand().equalsIgnoreCase("Salir"))
			{
				cerrarVentana();
			}
			else if (a.getActionCommand().equalsIgnoreCase("Cancelar"))
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
				
				if (txt.getName().equalsIgnoreCase("txtCodigoEq"));
				{
					if (!ventana.getTxtCodigoEq().isEmpty()){
						ventana.habilitarGuardar();
						buscarEquipo();
					}
				}
			}

		}

		public void keyPressed(KeyEvent e) {
			if (e.getSource() instanceof javax.swing.text.JTextComponent)
			{
				javax.swing.text.JTextComponent txt= (javax.swing.text.JTextComponent) e.getSource();
				if (txt.getName().equalsIgnoreCase("txtCodigoEq"));
				{
					if (!ventana.getTxtCodigoEq().isEmpty()){
						if (e.getKeyCode()==KeyEvent.VK_ENTER){
							buscarEquipo();
						}
					}
				}
			}
		}

		public void keyReleased(KeyEvent arg0) {
		}

		public void keyTyped(KeyEvent arg0) {
			if (arg0.getSource() instanceof javax.swing.text.JTextComponent)
			{
				javax.swing.text.JTextComponent txt= (javax.swing.text.JTextComponent) arg0.getSource();
				
				if (txt.getName().equalsIgnoreCase("txtCodigoEq"))
				{
					 if (!(Character.isDigit(arg0.getKeyChar()) && ventana.getTxtCodigoEq().length() < 4)){
						  arg0.consume();
					}
				}
				else if (txt.getName().equalsIgnoreCase("txtAnioFundEq"))
				{
					 if (!(Character.isDigit(arg0.getKeyChar()) && ventana.getTxtAnioFundEq().length() < 4)){
						  arg0.consume();
					}
				}
				
				else if (txt.getName().equalsIgnoreCase("txtNombreEq"))
				{
					 if (!(Character.isLetter(arg0.getKeyChar()) || Character.isSpaceChar(arg0.getKeyChar()))){
						  arg0.consume();
					}
					 else
					 {
						 arg0.setKeyChar(Character.toUpperCase(arg0.getKeyChar()));
					 }
				}
				else if (txt.getName().equalsIgnoreCase("txtCiudadEq"))
				{
					 if (!(Character.isLetter(arg0.getKeyChar()) || Character.isSpaceChar(arg0.getKeyChar()))){
						  arg0.consume();
					}
					 else
					 {
						 arg0.setKeyChar(Character.toUpperCase(arg0.getKeyChar()));
					 }
				 }
				else if (txt.getName().equalsIgnoreCase("txtNombEstEq"))
				{
					 if (!(Character.isLetter(arg0.getKeyChar()) || Character.isSpaceChar(arg0.getKeyChar()))){
						  arg0.consume();
					}
					 else
					 {
						 arg0.setKeyChar(Character.toUpperCase(arg0.getKeyChar()));
					 }
				 }
				
				else if (txt.getName().equalsIgnoreCase("txtCiudadEq"))
						{
							 if (!(Character.isLetter(arg0.getKeyChar()) || Character.isSpaceChar(arg0.getKeyChar()))){
								  arg0.consume();
							}
							 else
							 {
								 arg0.setKeyChar(Character.toUpperCase(arg0.getKeyChar()));
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

		public void windowDeactivated(WindowEvent arg0){
		}

		public void windowDeiconified(WindowEvent arg0) {
		}

		public void windowIconified(WindowEvent arg0) {	
		}

}
