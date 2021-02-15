package OODB.oodb.model;

import java.util.List;

public class Centro {

	private int codigo;
	private String nombre;
	private Profesor director;
	private String direccion;
	private String localidad;
	private String provincia;
	private List<Profesor> listaProfesoresCentro;
	
	
//CONSTRUCTOR
	public Centro(int codigo, String nombre, Profesor director, String direccion, String localidad, String provincia) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.director = director;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
	}
	
//GETTERS Y SETTERS
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Profesor getDirector() {
		return director;
	}

	public void setDirector(Profesor director) {
		this.director = director;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<Profesor> getListaProfesoresCentro() {
		return listaProfesoresCentro;
	}

	public void setListaProfesoresCentro(List<Profesor> listaProfesoresCentro) {
		this.listaProfesoresCentro = listaProfesoresCentro;
	}
	
	
//METODOS
	@Override
	public String toString() {
		return "Centro [codigo=" + codigo + ", nombre=" + nombre + ", director=" + director.getNombre() + " " + director.getApellidos() + ", direccion=" + direccion
				+ ", localidad=" + localidad + ", provincia=" + provincia + "]";
	}
	
}
