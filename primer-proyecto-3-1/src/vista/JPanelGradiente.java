package vista;


import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;


public class JPanelGradiente extends JPanel implements Serializable{
	
	private Color primerColor;
	private Color segundoColor;
	
	
	public JPanelGradiente(){
		primerColor= new Color(51,255,153);
		segundoColor= new Color(255,255,153);
		
	}
	
	public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2d= (Graphics2D) g;

        g2d.setPaint(new GradientPaint(0,0,primerColor,0,getHeight(),segundoColor));
        g2d.fill(new Rectangle2D.Double(0,0,this.getWidth(),this.getHeight()));

    }
	
	
	
	public Color getPrimerColor() {
		return primerColor;
	}
	
	public int[] getPrimerColorArray() {
		int[] rgb= {primerColor.getRed(),primerColor.getGreen(),primerColor.getBlue()};
		
		return rgb;
	}

	public void setPrimerColor(int rojo,int verde,int azul) {
		this.primerColor = new Color(rojo,verde,azul);
		repaint();
	}
	
	public void setPrimerColor(Color primerColor) {
		this.primerColor = primerColor;
		repaint();
	}

	public Color getSegundoColor() {
		return segundoColor;
	}
	
	public int[] getSegundoColorArray() {
        int[] rgb= {segundoColor.getRed(),segundoColor.getGreen(),segundoColor.getBlue()};
		
		return rgb;
	}

	public void setSegundoColor(int rojo,int verde,int azul) {
		this.segundoColor = new Color(rojo,verde,azul);
		repaint();
	}
	
	public void setSegundoColor(Color segundoColor) {
		this.segundoColor = segundoColor;
		repaint();
	}


	
	
}
