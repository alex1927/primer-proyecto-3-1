package vista;

import java.util.Comparator;

public class ComparadorFechaPartido<Partido> implements Comparator<Partido>
{

	@Override
	public int compare(Partido p1, Partido p2) {
	
		
	 return	((modelo.Partido) p1).getFechaPartido().compareTo(((modelo.Partido) p2).getFechaPartido());
		
		
	}
	
}
