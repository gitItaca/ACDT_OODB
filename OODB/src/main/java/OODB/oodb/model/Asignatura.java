package OODB.oodb.model;

public class Asignatura {

	private int codigo;
	private String nombre;
// igual le tengo que meter un array de profesores para relacionarla, DUDAS	
	
//CONSTRUCTOR
	public Asignatura(int codigo, String nombre) {
		super();
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

//METODOS
	@Override
	public String toString() {
		return "Asignatura [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	
}
