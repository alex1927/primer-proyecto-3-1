package vista;

import javax.swing.JOptionPane;

public class VentanaAviso {
	
	public static void mostrarAviso(String aviso){
		JOptionPane.showMessageDialog(null, aviso,"Aviso",JOptionPane.INFORMATION_MESSAGE);
	}
	
	

}
