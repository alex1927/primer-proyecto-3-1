package modelo;

//import java.util.Calendar;

public abstract class Persona{
  private String cedula;
  private String nombre;
  private String apellido;
  //private Calendar fechaNacimiento;
  private String fechaNacimiento;
  
  public Persona(){
	  
  }
  
	public Persona(String cedula, String nombre, String apellido,
		String fechaNacimiento) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
    }

	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	} 
}
