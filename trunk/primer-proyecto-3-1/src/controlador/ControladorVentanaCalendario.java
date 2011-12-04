package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

import modelo.Liga;
import modelo.Partido;
import vista.VentanaAviso;
import vista.VentanaPrincipal;
import vista.VentanaReportes;
import vista.VentanaCalendario;
import vista.VistaLigaOrdenada;

public class ControladorVentanaCalendario  implements ActionListener,WindowListener {
	private VentanaCalendario ventana;
	private ControladorVentanaReportes controladorVentanaReporte;
	
	public ControladorVentanaCalendario(ControladorVentanaReportes c) {
		ventana = new VentanaCalendario();
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
	
	private void asignarInfoTabla(){
		List<Partido> listaPartido= VistaLigaOrdenada.getListaPartidoOrdenadoFecha();
	    Object[] encabezados= {"Fecha","Equipo Casa","Goles Casa","Equipo Visitante","Goles Visitante"};
	    Object[][] data= new Object[listaPartido.size()][5];
	    int i=0;
	    
	    for(Partido partido:listaPartido){
	    	 data[i][0]= String.format("%1$td/%1$tm/%1$tY", partido.getFechaPartido());
	    	 data[i][1]= partido.getEquipoCasa().getNombreEquipo();
	    	 data[i][2]= partido.getGolesCasa();
	    	 data[i][3]= partido.getEquipoVisitante().getNombreEquipo();
	    	 data[i][4]= partido.getGolesVisitante();
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

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Salir"))
		{
			cerrarVentana();
		}
		
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

