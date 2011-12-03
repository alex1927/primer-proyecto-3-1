package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import modelo.Arbitro;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Liga;
import modelo.Partido;
import vista.VentanaAviso;
import vista.VentanaGenerarPartido;
import vista.VentanaPrincipal;
import vista.VistaLigaOrdenada;

public class ControladorVentanaGenerarPartido implements ActionListener {
	
	private VentanaGenerarPartido ventana;

	public ControladorVentanaGenerarPartido() {
		ventana = new VentanaGenerarPartido();
        ventana.addListener(this);
	}

	private void cerrarVentana()
    {
	  new VentanaPrincipal();
      this.ventana.setVisible(false);
      this.ventana.dispose();  
    }
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equalsIgnoreCase("Generar Partidos"))
		{
			try{
				if (Liga.getListaEquipo().isEmpty())
				{
					throw new Exception("La Lista de Equipos esta Vacia!!!");
				}
				if (Liga.getListaArbitro().isEmpty())
				{
					throw new Exception("La Lista de Arbitros esta Vacia!!!");
				}
				if(Liga.getListaEquipo().size()%2!=0){
					throw new Exception("El Nro de Equipos deben ser pares!!!");
				}
	     		for (Equipo equipo:Liga.getListaEquipo()){
					if (!equipo.isHayJugadores())
						throw new Exception("Todos los Equipo Deben tener Jugadores!!!");
				}
				
				
				cargarJuegos();
				
				if (Liga.getListaPartido().isEmpty())
					throw new Exception("Los Partidos no pudieron Generarse!!!");
				
				asignarFechas();
				
				for (Partido p:Liga.getListaPartido()){
					if (p.getFechaPartido()==null)
						throw new Exception("Error Generando la Fecha de los Partidos!!!");
				}
				
				int partidosSemanales= Liga.getListaEquipo().size()/2;
				
				if (partidosSemanales > Liga.getListaArbitro().size())
					throw new Exception("No Hay suficientes Arbitros para los Partidos!!!");
				
				asignarArbitros();
				
				asignarGoles();
					
				VentanaAviso.mostrarAviso("Los Juegos se han Generado");
				
			}catch(Exception exception){
				VentanaAviso.mostrarAviso(exception.getMessage());
				Liga.getListaPartido().clear();
			}
			
		    
		}
		else if (e.getActionCommand().equalsIgnoreCase("Salir"))
		{
			cerrarVentana();
		}
	}
	
	
	private void cargarJuegos(){
		Partido partido;	
		
		for (int indiceCasa=0; indiceCasa < Liga.getListaEquipo().size(); ++indiceCasa){
			for (int indiceVisitante=0; indiceVisitante < Liga.getListaEquipo().size(); ++indiceVisitante){
				if (indiceCasa!=indiceVisitante){
					partido= new Partido();
					partido.setEquipoCasa(Liga.getListaEquipo().get(indiceCasa));
					partido.setEquipoVisitante(Liga.getListaEquipo().get(indiceVisitante));
					Liga.agregarPartido(partido);
				}
			}	
		}
	}
	
	
	private void asignarFechas(){
		Calendar fechaInicio= Calendar.getInstance();
		List<Partido> juegosCopia= new ArrayList<Partido>(Liga.getListaPartido());
		int nroSemanas= (Liga.getListaEquipo().size()-1)*2;
		int partidosSemanales= Liga.getListaEquipo().size()/2;
		
		//La ultima fecha del juego sea la fecha actual.
		fechaInicio.add(Calendar.DAY_OF_MONTH, nroSemanas*(-7));
			
       try {
    	   List<Partido> list; 
		   int dias;
		   Calendar fechaIteradorInicio;
		   
			do{
				list= getJuegosSemana(juegosCopia,partidosSemanales);
				
				fechaIteradorInicio= (Calendar)fechaInicio.clone();
				dias=0;
				//asignar juego por dia
				for (Partido j:list){
					j.setFechaPartido(fechaIteradorInicio);
					fechaIteradorInicio= (Calendar)fechaIteradorInicio.clone();
					fechaIteradorInicio.add(Calendar.DAY_OF_MONTH, 1);
					++dias;
					
					if (dias==7){
						fechaIteradorInicio= (Calendar)fechaInicio.clone();
						dias=0;
					}
				}
				
				fechaInicio.add(Calendar.DAY_OF_MONTH, 7);
			
			}while(!juegosCopia.isEmpty());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	private List<Partido> getJuegosSemana(List<Partido> juegosCopia,final int nroJuegosSemana) throws Exception{
		List<Partido> listaJuegosSemana= new ArrayList<Partido>();
		
		if (!juegosCopia.isEmpty()){
		   Partido juego= juegosCopia.get(0);
		   listaJuegosSemana.add(juego);
		   juegosCopia.remove(0);
	
				
		     for (int cantidadJuegos=1,i=0; cantidadJuegos < nroJuegosSemana && i <juegosCopia.size();++i){
				  juego= juegosCopia.get(i);
				  
				  if (!contieneEquipo(listaJuegosSemana,juego)){
					  listaJuegosSemana.add(juego);
					  juegosCopia.remove(i);
					  ++cantidadJuegos;
				  } 
			 }   
			   	   
		}
		else
			throw new Exception("No Existen Juegos por Asignar!!!");
		
		return listaJuegosSemana;
	}
	
	
	private boolean contieneEquipo(List<Partido> listaJuegos,Partido juego){
		boolean contieneEquipo= false;
		
		for (Partido j:listaJuegos){
			if (j.getEquipoCasa().getCodigoEquipo()==juego.getEquipoCasa().getCodigoEquipo() ||
			    j.getEquipoVisitante().getCodigoEquipo()==juego.getEquipoCasa().getCodigoEquipo() ||	
			    j.getEquipoCasa().getCodigoEquipo()==juego.getEquipoVisitante().getCodigoEquipo() || 
			    j.getEquipoVisitante().getCodigoEquipo()==juego.getEquipoVisitante().getCodigoEquipo()){
				contieneEquipo=true;
				break;
			}
				
		}
		
		return contieneEquipo;
	}
	
	/*Asigna los Arbitros a los Partidos (se llama al pulsar el boton de generar partido)
	  Precondicion: -Requiere que todos los Partidos se hayan cargado
	                -El Nro de Arbitros debe ser igual o mayor al nro de partidos por semana
	                
	                
	                if (partidosSemanales <=Liga.getListaArbitro().size() && !Liga.getListaPartido().isEmpty())
	  */
	private void asignarArbitros(){
		List<Arbitro> listArbitroCopia= new ArrayList<Arbitro>(Liga.getListaArbitro());
		List<Partido> listPartidoCopia= VistaLigaOrdenada.getListaPartidoOrdenadoFecha();
		Random aleatorio= new Random();
		int indiceArbitro=0;
		
		for (int i=0; i < listPartidoCopia.size(); ++i){
			
			if (listArbitroCopia.isEmpty()){
				listArbitroCopia= new ArrayList<Arbitro>(Liga.getListaArbitro());
			}
			
			indiceArbitro= aleatorio.nextInt(listArbitroCopia.size());
			Arbitro arbitro= listArbitroCopia.remove(indiceArbitro);
			
			listPartidoCopia.get(i).setArbitroJuego(arbitro);
			
		}	
		
	}
	
	/*Asigna los goles de cada Equipo en los Partidos(se llama al pulsar el boton de generar partido)
	  Precondicion: -Requiere que todos los Partidos se hayan cargado
	             
	  */
	
	private void asignarGoles(){
		Random aleatorio= new Random();
		Partido partido;
		Equipo equipoCasa,equipoVisitante;
		int golesEquipoCasa=0,golesEquipoVisitante=0;
		
		//Asignando los Goles
		for (int i=0;i < Liga.getListaPartido().size();++i){
			partido= Liga.getListaPartido().get(i);
			equipoCasa= partido.getEquipoCasa();
			equipoVisitante= partido.getEquipoVisitante();
			
		    golesEquipoCasa= aleatorio.nextInt(6);	
		    golesEquipoVisitante= aleatorio.nextInt(6);
		    
		    //Asignando los goles de los Jugadores del EquipoCasa
		    for (int cantGolesAsignados=0; cantGolesAsignados<golesEquipoCasa;++cantGolesAsignados){
		    	int indiceJugador= aleatorio.nextInt(equipoCasa.getListaJugador().size());
		    	Jugador jugador= equipoCasa.getListaJugador().get(indiceJugador);
		    	jugador.setGolesAnotados(jugador.getGolesAnotados() + 1);
		    	partido.agregarJugadorAnotadorCasa(jugador);
		    }
		    
		    //Asignando atributos al Equipo Casa
		    equipoCasa.setJuegosJugados(equipoCasa.getJuegosJugados()+1);
		    equipoCasa.setGolesFavor(equipoCasa.getGolesFavor()+golesEquipoCasa);
		    equipoCasa.setGolesContra(equipoCasa.getGolesContra() + golesEquipoVisitante);
		    
		    
		  //Asignando los goles de los Jugadores del EquipoVisitante
		    for (int cantGolesAsignados=0; cantGolesAsignados<golesEquipoVisitante;++cantGolesAsignados){
		    	int indiceJugador= aleatorio.nextInt(equipoVisitante.getListaJugador().size());
		    	Jugador jugador= equipoVisitante.getListaJugador().get(indiceJugador);
		    	jugador.setGolesAnotados(jugador.getGolesAnotados() + 1);
		    	partido.agregarJugadorAnotadorVisitante(jugador);
		    }
		    
		    //Asignando atributos al Equipo Visitante
		    equipoVisitante.setJuegosJugados(equipoVisitante.getJuegosJugados()+1);
		    equipoVisitante.setGolesFavor(equipoVisitante.getGolesFavor()+golesEquipoVisitante);
		    equipoVisitante.setGolesContra(equipoVisitante.getGolesContra() + golesEquipoCasa);
		    
		    //Los Demas Atributos de los Equipos
		    if (golesEquipoCasa>golesEquipoVisitante){
		    	equipoCasa.setJuegosGanados(equipoCasa.getJuegosGanados()+1);
		    	equipoVisitante.setJuegosPerdidos(equipoVisitante.getJuegosPerdidos()+1);
		    }
		    else if (golesEquipoCasa<golesEquipoVisitante){
		    	equipoVisitante.setJuegosGanados(equipoVisitante.getJuegosGanados()+1);
		    	equipoCasa.setJuegosPerdidos(equipoCasa.getJuegosPerdidos()+1);
		    }
		    else if (golesEquipoCasa==golesEquipoVisitante){
		    	equipoCasa.setJuegosEmpatados(equipoCasa.getJuegosEmpatados()+1);
		    	equipoVisitante.setJuegosEmpatados(equipoVisitante.getJuegosEmpatados()+1);
		    }
		    
		    
		    
		}
		
		//Asignar a los Puntos
		for (int i=0;i < Liga.getListaEquipo().size();++i){
			Equipo equipo= Liga.getListaEquipo().get(i);
			int puntosEquipo= (equipo.getJuegosGanados()*3) + equipo.getJuegosEmpatados();
			
			equipo.setPuntosAcumulados(puntosEquipo);
		}
		
	}
	
	
	
}
