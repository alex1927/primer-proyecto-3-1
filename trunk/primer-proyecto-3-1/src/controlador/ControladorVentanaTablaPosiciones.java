package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import modelo.Liga;
import modelo.Equipo;
import vista.VentanaAviso;
import vista.VentanaPrincipal;
import vista.VentanaReportes;
import vista.VentanaTablaPosiciones;
import vista.VistaLigaOrdenada;

public class ControladorVentanaTablaPosiciones implements ActionListener,WindowListener {
	private VentanaTablaPosiciones ventana;
	private ControladorVentanaReportes controladorVentanaReporte;
	
	public ControladorVentanaTablaPosiciones(ControladorVentanaReportes c) {
		ventana = new VentanaTablaPosiciones();
		controladorVentanaReporte=c;
		ventana.addListener((ActionListener)this);
		ventana.addListener((WindowListener)this);
		asignarInfoTabla();
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
		   
		}
		else if (e.getActionCommand().equalsIgnoreCase("Salir"))
		{
			cerrarVentana();
		}
	}

private void asignarInfoTabla(){
	List<Equipo> listaEquipo= VistaLigaOrdenada.getListaEquipoOrdenadoPuntaje();
    Object[] encabezados= {"Nombre Equipo","J. Ganados","J. Perdidos","J. Empatados","G. Favor","G. Contra","P. Final"};
    Object[][] data= new Object[listaEquipo.size()][7];
    int i=0;
    
    for(Equipo equipo:listaEquipo){
    	data[i][0]= equipo.getNombreEquipo();
    	data[i][1]= equipo.getJuegosGanados();
    	data[i][2]= equipo.getJuegosPerdidos();
    	data[i][3]= equipo.getJuegosEmpatados();
    	data[i][4]= equipo.getGolesFavor();
    	data[i][5]= equipo.getGolesContra();
    	data[i][6]= equipo.getPuntosAcumulados();
    	i++;
    }
    ModeloTabla modeloTabla= new ModeloTabla(data, encabezados);
    ventana.setModelo(modeloTabla);
}

public void windowOpened(WindowEvent e) {
}

public void windowClosing(WindowEvent e) {
	cerrarVentana();
}

public void windowClosed(WindowEvent e) {
}

public void windowIconified(WindowEvent e) {
}

public void windowDeiconified(WindowEvent e) {
}

public void windowActivated(WindowEvent e) {
}

public void windowDeactivated(WindowEvent e) {
}


private class ModeloTabla extends DefaultTableModel
{
	public ModeloTabla() {
		super();
}

public ModeloTabla(int rowCount, int columnCount) {
	super(rowCount, columnCount);
}

public ModeloTabla(Object[] columnNames, int rowCount) {
	super(columnNames, rowCount);
}

public ModeloTabla(Object[][] data, Object[] columnNames) {
	super(data, columnNames);
}

public ModeloTabla(Vector columnNames, int rowCount) {
	super(columnNames, rowCount);
}

public ModeloTabla(Vector data, Vector columnNames) {
	super(data, columnNames);
}
	
public boolean isCellEditable(int row,int col){
	return false;
}	
}
}
