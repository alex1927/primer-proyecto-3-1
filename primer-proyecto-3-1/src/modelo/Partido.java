package modelo;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

public class Partido {

	private String codigoPartido;
	private Calendar fechaPartido;
	private Equipo equipoCasa;
	private Equipo equipoVisitante;
	private Arbitro arbitroJuego;
	private int golesCasa;
	private int golesVisitante; 
	List<Jugador> jugadoresGolCasa;
	List<Jugador> jugadoresGolVisitante;
	private boolean juegosGenerados;
	
	public Partido() {
		super();
		jugadoresGolCasa= new ArrayList<Jugador>();
		jugadoresGolVisitante= new ArrayList<Jugador>();
	}

	
	public Partido(String codigoPartido, Calendar fechaPartido,
			Equipo equipoCasa, Equipo equipoVisitante, Arbitro arbitroJuego,
			int golesCasa, int golesVisitante) {
		super();
		this.codigoPartido = codigoPartido;
		this.fechaPartido = fechaPartido;
		this.equipoCasa = equipoCasa;
		this.equipoVisitante = equipoVisitante;
		this.arbitroJuego = arbitroJuego;
		this.golesCasa = golesCasa;
		this.golesVisitante = golesVisitante;
	}



	public String getCodigoPartido() {
		return codigoPartido;
	}

	public void setCodigoPartido(String codigoPartido) {
		this.codigoPartido = codigoPartido;
	}

	public Calendar getFechaPartido() {
		return fechaPartido;
	}

	public void setFechaPartido(Calendar fechaPartido) {
		this.fechaPartido = fechaPartido;
	}

	public Equipo getEquipoCasa() {
		return equipoCasa;
	}

	public void setEquipoCasa(Equipo equipoCasa) {
		this.equipoCasa = equipoCasa;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public Arbitro getArbitroJuego() {
		return arbitroJuego;
	}

	public void setArbitroJuego(Arbitro arbitroJuego) {
		this.arbitroJuego = arbitroJuego;
	}

	public int getGolesCasa() {
		return golesCasa;
	}

	public void setGolesCasa(int golesCasa) {
		this.golesCasa = golesCasa;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	public boolean isJuegosGenerados() {
        return juegosGenerados;
    }

}
