package modelo;

//import java.util.Calendar;

public class Jugador extends Persona {

	
	private String posicionJuego; 
	private int golesAnotados;
	
	
	public Jugador() {
		super();
	}

	public Jugador(String cedula, String nombre, String apellido,
			String fechaNacimiento, String posicionJuego, int golesAnotados) {
		super(cedula, nombre, apellido, fechaNacimiento);
		this.posicionJuego = posicionJuego;
		this.golesAnotados = golesAnotados;
	}

	public String getPosicionJuego() {
		return posicionJuego;
	}

	
	public void setPosicionJuego(String posicion) {
		this.posicionJuego = posicion;
	}

	public int getGolesAnotados() {
		return golesAnotados;
	}

	public void setGolesAnotados(int golesAnotados) {
		this.golesAnotados = golesAnotados;
	}

	@Override
	public boolean equals(Object obj) {
		
		Jugador jugador= (Jugador) obj;
		return this.getCedula().equals(jugador.getCedula());
	} 
}

