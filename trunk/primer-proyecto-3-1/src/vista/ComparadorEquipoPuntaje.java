package vista;

import java.util.Comparator;

public class ComparadorEquipoPuntaje<Equipo> implements Comparator<Equipo> {

	public int compare(Equipo o1, Equipo o2) {
		int valor=  ((modelo.Equipo)o2).getPuntosAcumulados() - ((modelo.Equipo)o1).getPuntosAcumulados();
		return valor;		
	}

}
