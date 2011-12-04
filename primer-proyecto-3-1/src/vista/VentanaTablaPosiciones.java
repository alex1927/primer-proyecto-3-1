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

public class VentanaTablaPosiciones extends JFrame{
	
	private JButton btnGuardarTp,btnSalirTp;
    private JTable reporteGenerado;
    
    public VentanaTablaPosiciones (){
    	    	
		super ("Liga de Futbol - Reporte - Tabla de Posiciones");
    	ImageIcon imgSalir= new ImageIcon(getClass().getResource("imagenes" + File.separator + "salir.jpg"));
    	
    	
        JPanelGradiente panel = new JPanelGradiente();
    	JLabel lblTitulo= new JLabel("TABLA DE POSICIONES");  
    	 
    	reporteGenerado= new JTable();
        JScrollPane scroll= new JScrollPane(reporteGenerado);

        btnSalirTp= new JButton("",imgSalir);

        btnSalirTp.setActionCommand("Salir");
        
        panel.setLayout(null);
        
        panel.add(scroll);
        scroll.setBounds(10, 10, 615, 200);
        
        panel.add(lblTitulo);
        lblTitulo.setBounds(250, 10,150, 30);
  	     
  	    panel.add(btnSalirTp);
	    btnSalirTp.setBounds(270, 240, 80, 80);
	    
	    
		this.add(panel);
		this.setVisible(true);
		
		this.setSize(650, 400);
		
		}
		
    public void setModelo(TableModel modelo){
    	reporteGenerado.setModel(modelo);
    }
    
	public void addListener(ActionListener l){
		btnSalirTp.addActionListener(l);
    }
	
	public void addListener(WindowListener l){
		
		this.addWindowListener(l);
	}

   
}