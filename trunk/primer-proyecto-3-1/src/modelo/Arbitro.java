package modelo;

//import java.util.Calendar;

public class Arbitro extends Persona {
	
	private int cantidadPartidosArbitrados;

	public Arbitro() {
		super();
	}

	public Arbitro(String cedula, String nombre, String apellido,
			String fechaNacimiento, int cantidadPartidosArbitrados) {
		
		super(cedula, nombre, apellido, fechaNacimiento);
		
		this.cantidadPartidosArbitrados = cantidadPartidosArbitrados;
	}

	public int getCantidadPartidosArbitrados() {
		return cantidadPartidosArbitrados;
	}

	public void setCantidadPartidosArbitrados(int cantidadPartidosArbitrados) {
		this.cantidadPartidosArbitrados = cantidadPartidosArbitrados;
	}
	
	
}
