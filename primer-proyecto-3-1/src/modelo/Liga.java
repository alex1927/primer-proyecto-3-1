package modelo;

import java.util.ArrayList;
import java.util.List;

public class Liga {
	private static List<Equipo> listaEquipo= new ArrayList<Equipo>();
	private static List<Arbitro> listaArbitro= new ArrayList<Arbitro>();
	private static List<Partido> listaPartido= new ArrayList<Partido>();
	
	public Liga() {
		super();
		
	}

	public static List<Equipo> getListaEquipo() {
		return listaEquipo;
	}

	
	public static List<Arbitro> getListaArbitro() {
		return listaArbitro;
	}

	public static List<Partido> getListaPartido() {
		return listaPartido;
	}
	
	public static void agregarArbitro(Arbitro arbitro){
		listaArbitro.add(arbitro);
	}
	
	public static void agregarEquipo(Equipo equipo){
		listaEquipo.add(equipo);
	}
	
	public static void agregarPartido(Partido partido){
		listaPartido.add(partido);
	}

	
	
}
