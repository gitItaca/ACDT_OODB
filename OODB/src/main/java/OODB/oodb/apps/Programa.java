package OODB.oodb.apps;

import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import OODB.oodb.dao.AsignaturaDao;
import OODB.oodb.dao.CentroDao;
import OODB.oodb.dao.ProfesorDao;
import OODB.oodb.model.Asignatura;
import OODB.oodb.model.Centro;
import OODB.oodb.model.Profesor;
import OODB.oodb.utils.Leer;

public class Programa {
private static final String NOMBRE_DOCUMENTO = "pomelu.neodatis";

	public static void main(String[] args) {
		//Conecto la base de datos.
    	ODB odb = ODBFactory.open(NOMBRE_DOCUMENTO); 	

    	ProfesorDao pDao = new ProfesorDao();   
    	CentroDao cDao = new CentroDao();
    	AsignaturaDao aDao = new AsignaturaDao();
    	
    	rellenarBaseDatos(odb, pDao, aDao, cDao);
    		
//Menu
    	int opcion;
    	List<Profesor> profesores;
    	List<Asignatura> asignaturas;
    	
    	do {
			opcion = menu();		
					
			switch (opcion) {
			case 1: //Listar todos los centros.
				List<Centro> centros = cDao.getAll(odb);
				for(Centro centro : centros) {
					System.out.println(centro);
				}
				break;
			case 2: //Listar todos los profesores.
				profesores = pDao.getAll(odb);
				for(Profesor profesor : profesores) {
					System.out.println(profesor);
				}
				break;
			case 3: //Listar los profesores de un centro cuya fecha de nacimiento sea anterior a 1993.
//				pDao.getAllBeforeDate(odb, "1993");
				profesores = pDao.getAll(odb);
				for(Profesor profesor : profesores) {
					String fecha = profesor.getFechaNacimiento();
					int year = Integer.parseInt(fecha.substring(6, 10));
					if(year < 1993) {
						System.out.println(profesor);
					}
				}
				break;
			case 4: //Listar los profesores de sexo masculino que impartan la asignatura de Acceso a datos.
				asignaturas = aDao.getNombre(odb, "Acceso a datos");		//Meto en una lista las asignaturas que se llamen Acceso a datos.
				for(Asignatura asignatura : asignaturas) {
					profesores = asignatura.getListaProfesoresAsignatura();
					for(Profesor p : profesores) {
						if(p.getSexo().contentEquals("Hombre")) {
							System.out.println(p.toString());				//Saco por pantalla los profesores hombres que imparten acceso a datos.
						}
					}
				}				
				break;
			case 5: //Comprobar que un profesor ya existe.				
				System.out.println("Escribe el nombre del profesor.");
				String nombre = Leer.pedirCadena();
				System.out.println("Escribe su apellido.");
				String apellido = Leer.pedirCadena();
				
				profesores = pDao.getAllSameName(odb, nombre, apellido);
				if(profesores.isEmpty()) {
					System.out.println("El profesor no esta en la base de datos.");
				}else {
					for(Profesor prof : profesores) {
						System.out.println(prof);
					}
				}
				break;		
			case 6: //Eliminar un profesor.				
				System.out.println("Escribe el código del profesor.");
				int codigo = Leer.pedirEnteroValidar();
				
				pDao.delete(odb, codigo);
				break;		
			case 0: System.out.println("Has salido.");
				odb.close();	//Cierro la base de datos.
				break;
			}
			
		} while(opcion != 0);
    	  

	}//FIN MAIN

//METODOS
	public static int menu() {
		
			System.out.println("Elige una de las siguientes opciones, para salir pulse 0.");
			System.out.println("1- Listar todos los centros.");
			System.out.println("2- Listar todos los profesores.");
			System.out.println("3- Listar los profesores de un centro cuya fecha de nacimiento sea anterior a 1993.");
			System.out.println("4- Listar los profesores de sexo masculino que impartan la asignatura de Acceso a datos.");
			System.out.println("5- Comprobar que un profesor ya existe.");
			System.out.println("6- Eliminar un profesor.");
			int opcion = Leer.pedirEnteroValidar();		
		
		return opcion;
	}
	
	public static void rellenarBaseDatos(ODB odb, ProfesorDao pDao, AsignaturaDao aDao, CentroDao cDao) {
		//Creo 9 profesores, 3 centros y 8 asignaturas
    	Profesor p1 = new Profesor(1,"Fedemina", "Fris", "Mujer", "12/02/1990", 5);
    	Profesor p2 = new Profesor(2,"Fermin", "Fros", "Hombre", "12/02/1996", 5);
    	Profesor p3 = new Profesor(3,"Francisca", "Frus", "Mujer", "12/02/1980", 5);
    	
    	Profesor p4 = new Profesor(4,"Jorge", "Fris", "Hombre", "12/02/1960", 8);
    	Profesor p5 = new Profesor(5,"Jessy", "Polo", "Mujer", "12/02/1972", 8);
    	Profesor p6 = new Profesor(6,"Jonas", "Jolina", "Hombre", "12/02/1956", 8);
    	
    	Profesor p7 = new Profesor(7,"Mirta", "Vreda", "Mujer", "12/02/1967", 2);
    	Profesor p8 = new Profesor(8,"Mariano", "Crod", "Hombre", "12/02/1999", 2);
    	Profesor p9 = new Profesor(9,"Marta", "Biuea", "Mujer", "12/02/1955", 2);
    	
    	List<Profesor> listaProfesores1 = new ArrayList();
    	listaProfesores1.add(p1);
    	listaProfesores1.add(p4);
    	listaProfesores1.add(p7);
    	List<Profesor> listaProfesores2 = new ArrayList();
    	listaProfesores2.add(p2);
    	listaProfesores2.add(p5);
    	listaProfesores2.add(p8);
    	List<Profesor> listaProfesores3 = new ArrayList();
    	listaProfesores3.add(p3);
    	listaProfesores3.add(p6);
    	listaProfesores3.add(p9);
    	
    	Centro c1 = new Centro(5, "IES Goya", p1, "Avenida Goya", "Zaragoza", "Zaragoza");
    	c1.setListaProfesoresCentro(listaProfesores1);
    	p1.setCentroProfesor(c1);
    	p4.setCentroProfesor(c1);
    	p7.setCentroProfesor(c1);
    	Centro c2 = new Centro(8, "IES Itaca", p2, "Avenida Estudiantes", "Zaragoza", "Zaragoza");
    	c2.setListaProfesoresCentro(listaProfesores2);
    	p2.setCentroProfesor(c2);
    	p5.setCentroProfesor(c2);
    	p8.setCentroProfesor(c2);
    	Centro c3 = new Centro(2, "IES Luna", p3, "Avenida San Juan", "Huesca", "Huesca");
    	c3.setListaProfesoresCentro(listaProfesores3);
    	p3.setCentroProfesor(c3);
    	p6.setCentroProfesor(c3);
    	p9.setCentroProfesor(c3);
    	
    	
    	List<Profesor> profesoresIngles = new ArrayList();
    	profesoresIngles.add(p1);
    	profesoresIngles.add(p8);
    	List<Profesor> profesoresEmpresa = new ArrayList();
    	profesoresEmpresa.add(p2);
    	profesoresEmpresa.add(p3);
    	List<Profesor> profesoresInterfaces = new ArrayList();
    	profesoresInterfaces.add(p6);
    	profesoresInterfaces.add(p7);
    	List<Profesor> profesoresProgramacion = new ArrayList();
    	profesoresProgramacion.add(p5);
    	profesoresProgramacion.add(p7);
    	profesoresProgramacion.add(p4);
    	List<Profesor> profesoresDatos = new ArrayList();
    	profesoresDatos.add(p5);
    	profesoresDatos.add(p4);
    	List<Profesor> profesoresProcesos = new ArrayList();
    	profesoresProcesos.add(p6);
    	profesoresProcesos.add(p9);
    	List<Profesor> profesoresGestion = new ArrayList();
    	profesoresGestion.add(p6);
    	profesoresGestion.add(p3);
    	List<Profesor> profesoresBasesDatos = new ArrayList();
    	profesoresBasesDatos.add(p5);
    	profesoresBasesDatos.add(p9);
    	
    	Asignatura a1 = new Asignatura(20, "Ingles");
    	a1.setListaProfesoresAsignatura(profesoresIngles);
    	Asignatura a2 = new Asignatura(21, "Empresa");
    	a2.setListaProfesoresAsignatura(profesoresEmpresa);
    	Asignatura a3 = new Asignatura(22, "Desarrollo interfaces");
    	a3.setListaProfesoresAsignatura(profesoresInterfaces);
    	Asignatura a4 = new Asignatura(23, "Programacion");
    	a4.setListaProfesoresAsignatura(profesoresProgramacion);
    	Asignatura a5 = new Asignatura(24, "Acceso a datos");
    	a5.setListaProfesoresAsignatura(profesoresDatos);
    	Asignatura a6 = new Asignatura(25, "Servicios y procesos");
    	a6.setListaProfesoresAsignatura(profesoresProcesos);
    	Asignatura a7 = new Asignatura(26, "Gestion empresarial");
    	a7.setListaProfesoresAsignatura(profesoresGestion);
    	Asignatura a8 = new Asignatura(27, "Bases de datos");
    	a8.setListaProfesoresAsignatura(profesoresBasesDatos);
    	
    	//Los meto en la base de datos    	
    	pDao.save(p1, odb);
    	pDao.save(p2, odb);
    	pDao.save(p3, odb);
    	pDao.save(p4, odb);
    	pDao.save(p5, odb);
    	pDao.save(p6, odb);
    	pDao.save(p7, odb);
    	pDao.save(p8, odb);
    	pDao.save(p9, odb);
    	
    	cDao.save(c1, odb);
    	cDao.save(c2, odb);
    	cDao.save(c3, odb);
    	
    	aDao.save(a1, odb);
    	aDao.save(a2, odb);
    	aDao.save(a3, odb);
    	aDao.save(a4, odb);
    	aDao.save(a5, odb);
    	aDao.save(a6, odb);
    	aDao.save(a7, odb);
    	aDao.save(a8, odb);
	}
		
}//FIN PROGRAMA
