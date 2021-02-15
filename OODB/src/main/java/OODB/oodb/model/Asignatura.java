package OODB.oodb.model;

import java.util.List;

public class Asignatura {

	private int codigo;
	private String nombre;
	private List<Profesor> listaProfesoresAsignatura;	
	
//CONSTRUCTOR
	public Asignatura(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

//GETTERS AND SETTERS
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

	public List<Profesor> getListaProfesoresAsignatura() {
		return listaProfesoresAsignatura;
	}

	public void setListaProfesoresAsignatura(List<Profesor> listaProfesoresAsignatura) {
		this.listaProfesoresAsignatura = listaProfesoresAsignatura;
	}
	

//METODOS
	@Override
	public String toString() {
		return "Asignatura [codigo=" + codigo + ", nombre=" + nombre + "]";
	}

	
	
}
