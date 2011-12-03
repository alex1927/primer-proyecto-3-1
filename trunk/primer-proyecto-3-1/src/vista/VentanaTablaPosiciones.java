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
    	    	
    	super ("Reportes");
    	ImageIcon imgGuardar= new ImageIcon(getClass().getResource("imagenes" + File.separator + "guardar.jpg"));	
    	ImageIcon imgSalir= new ImageIcon(getClass().getResource("imagenes" + File.separator + "salir.jpg"));
    	
    	
    	JPanel panel = new JPanel();
    	
    	 
    	JLabel lblTitulo= new JLabel("TABLA DE POSICIONES");  
    	 
    	reporteGenerado= new JTable();
        JScrollPane scroll= new JScrollPane(reporteGenerado);
         
        btnGuardarTp= new JButton("",imgGuardar);
        btnSalirTp= new JButton("",imgSalir);
        
        btnGuardarTp.setActionCommand("Guardar");
        btnSalirTp.setActionCommand("Salir");
        
        panel.setLayout(null);
        
        panel.add(scroll);
        scroll.setBounds(10, 10, 615, 170);
        
        panel.add(lblTitulo);
        lblTitulo.setBounds(250, 10,150, 30);
         
        panel.add(btnGuardarTp);
  	    btnGuardarTp.setBounds(220, 220, 80 , 80);
  	     
  	    panel.add(btnSalirTp);
	    btnSalirTp.setBounds(340, 220, 80, 80);
	    
	    
		this.add(panel);
		this.setVisible(true);
		
		this.setSize(640, 400);
		
		}
		
    public void setModelo(TableModel modelo){
    	reporteGenerado.setModel(modelo);
    }
    
	public void addListener(ActionListener l){
		btnGuardarTp.addActionListener(l);
		btnSalirTp.addActionListener(l);
    }
	
	public void addListener(WindowListener l){
		
		this.addWindowListener(l);
	}

   
}