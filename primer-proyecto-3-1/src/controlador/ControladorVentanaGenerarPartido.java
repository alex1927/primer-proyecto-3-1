package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import modelo.Equipo;
import modelo.Liga;
import modelo.Partido;
import vista.VentanaArbitro;
import vista.VentanaAviso;
import vista.VentanaGenerarPartido;
import vista.VentanaPrincipal;

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
		
		if (e.getSource()==ventana.getBtnGenerarPartidos())
		{
		    VentanaAviso.mostrarAviso("Los Juegos se han Generado");
		}
		else if (e.getSource()==ventana.getBtnSalirGp())
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
	
	
}
