package OODB.oodb.model;

public class Profesor {

	private int codigo;
	private String nombre;
	private String apellidos;
	private String sexo;
	private String fechaNacimiento;
	private int codigoCentro;
	private Centro centroProfesor;
	
//CONSTRUCTOR
	public Profesor(int codigo, String nombre, String apellidos, String sexo, String fechaNacimiento, int codigoCentro) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.codigoCentro = codigoCentro;
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

	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getCodigoCentro() {
		return codigoCentro;
	}

	public void setCodigoCentro(int codigoCentro) {
		this.codigoCentro = codigoCentro;
	}

	public Centro getCentroProfesor() {
		return centroProfesor;
	}

	public void setCentroProfesor(Centro centroProfesor) {
		this.centroProfesor = centroProfesor;
	}
	
	
	//METODOS	
	@Override
	public String toString() {
		return "Profesor [codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", sexo=" + sexo
				+ ", fechaNacimiento=" + fechaNacimiento + ", codigoCentro=" + codigoCentro + ", centroProfesor="
				+ centroProfesor.getNombre() + "]";
	}

	

	
	
}
