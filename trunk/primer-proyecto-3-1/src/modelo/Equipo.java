package modelo;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
private String codigoEquipo;
private String nombreEquipo;
private String anioFundado;
private String ciudad;
private String nombreEstadio;
private int juegosJugados;
private int juegosGanados;
private int juegosEmpatados;
private int juegosPerdidos;
private int puntosAcumulados;
private int golesFavor;
private int golesContra;
private List<Jugador> listaJugador;

public Equipo() {
	super();
	listaJugador= new ArrayList<Jugador>();
    
}

public Equipo(String codigoEquipo, String nombreEquipo, String anioFundado,
		String ciudad, String nombreEstadio, int juegosJugados,
		int juegosGanados, int juegosEmpatados, int juegosPerdidos,
		int puntosAcumulados, int golesFavor, int golesContra) {
	this();
	this.codigoEquipo = codigoEquipo;
	this.nombreEquipo = nombreEquipo;
	this.anioFundado = anioFundado;
	this.ciudad = ciudad;
	this.nombreEstadio = nombreEstadio;
	this.juegosJugados = juegosJugados;
	this.juegosGanados = juegosGanados;
	this.juegosEmpatados = juegosEmpatados;
	this.juegosPerdidos = juegosPerdidos;
	this.puntosAcumulados = puntosAcumulados;
	this.golesFavor = golesFavor;
	this.golesContra = golesContra;
}

public void agregarJugador(Jugador jugador){
	
		
		listaJugador.add(jugador);
	
	
}

public boolean isHayJugadores(){
	return !listaJugador.isEmpty();
}

public String getCodigoEquipo() {
	return codigoEquipo;
}

public void setCodigoEquipo(String codigoEquipo) {
	this.codigoEquipo = codigoEquipo;
}

public String getNombreEquipo() {
	return nombreEquipo;
}

public void setNombreEquipo(String nombreEquipo) {
	this.nombreEquipo = nombreEquipo;
}

public String getAnioFundado() {
	return anioFundado;
}

public void setAnioFundado(String anioFundado) {
	this.anioFundado = anioFundado;
}

public String getCiudad() {
	return ciudad;
}

public void setCiudad(String ciudad) {
	this.ciudad = ciudad;
}

public String getNombreEstadio() {
	return nombreEstadio;
}

public void setNombreEstadio(String nombreEstadio) {
	this.nombreEstadio = nombreEstadio;
}

public int getJuegosJugados() {
	return juegosJugados;
}

public void setJuegosJugados(int juegosJugados) {
	
	if(juegosJugados==juegosGanados+juegosEmpatados+juegosPerdidos)
	   this.juegosJugados = juegosJugados;
}

public int getJuegosGanados() {
	return juegosGanados;
}

public void setJuegosGanados(int juegosGanados) {
	this.juegosGanados = juegosGanados;
}

public int getJuegosEmpatados() {
	return juegosEmpatados;
}

public void setJuegosEmpatados(int juegosEmpatados) {
	this.juegosEmpatados = juegosEmpatados;
}

public int getJuegosPerdidos() {
	return juegosPerdidos;
}

public void setJuegosPerdidos(int juegosPerdidos) {
	this.juegosPerdidos = juegosPerdidos;
}

public int getPuntosAcumulados() {
	return puntosAcumulados;
}

public void setPuntosAcumulados(int puntosAcumulados) {
	this.puntosAcumulados = puntosAcumulados;
}

public int getGolesFavor() {
	return golesFavor;
}

public void setGolesFavor(int golesFavor) {
	this.golesFavor = golesFavor;
}

public int getGolesContra() {
	return golesContra;
}

public void setGolesContra(int golesContra) {
	this.golesContra = golesContra;
}

public List<Jugador> getListaJugador() {
	return listaJugador;
}
}
