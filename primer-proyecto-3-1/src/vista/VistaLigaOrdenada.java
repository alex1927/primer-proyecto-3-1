package vista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modelo.Equipo;
import modelo.Liga;
import modelo.Partido;

public class VistaLigaOrdenada {

	
    public static List<Partido> getListaPartidoOrdenadoFecha() {
		
		List<Partido> listaPartidoFecha= new ArrayList<Partido>(Liga.getListaPartido());
		Collections.sort(listaPartidoFecha, new ComparadorFechaPartido<Partido>());
		
		return listaPartidoFecha;
	}
    
    public static List<Equipo> getListaEquipoOrdenadoPuntaje(){
    	List<Equipo> listEquipo= new ArrayList<Equipo>(Liga.getListaEquipo());
    	
    	Collections.sort(listEquipo, new ComparadorEquipoPuntaje<Equipo>());
    	
    	return listEquipo;
    }
    
}
