package vista;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;

public class VentanaCalendario extends JFrame{
	
	private JButton btnSalirCal;
	private JTable reporteGenerado;
	
	public VentanaCalendario(){
	
		super ("Liga de Futbol - Reporte - Calendario");
    	ImageIcon imgSalir= new ImageIcon(getClass().getResource("imagenes" + File.separator + "salir.jpg"));
    	
        JPanelGradiente panel = new JPanelGradiente();
    	 
    	JLabel lblTitulo= new JLabel("CALENDARIO DE JUEGOS");
    	 
    	reporteGenerado= new JTable();
        JScrollPane scroll= new JScrollPane(reporteGenerado);
         
        btnSalirCal= new JButton("",imgSalir);
        
        btnSalirCal.setActionCommand("Salir");
        
        panel.setLayout(null);
        
        panel.add(scroll);
        scroll.setBounds(10, 10, 615, 250);
        
        panel.add(lblTitulo);
        lblTitulo.setBounds(250, 10,150, 30);
  	     
  	    panel.add(btnSalirCal);
	    btnSalirCal.setBounds(270, 300, 80, 80);
	    
	    
		this.add(panel);
		this.setVisible(true);
		
		this.setSize(650, 450);
	}
	
    public void setModelo(TableModel modelo){
    	reporteGenerado.setModel(modelo);
    }
    
	public void addListener(ActionListener l){
		btnSalirCal.addActionListener(l);
    }
	
	public void addListener(WindowListener l){
		this.addWindowListener(l);
	}
}