package OODB.oodb.dao;


import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import OODB.oodb.model.Asignatura;
import OODB.oodb.model.Profesor;

public class ProfesorDao implements Dao<Profesor>{

	@Override
	public Profesor get(String id) {
		
		return null;
	}

	@Override
	public List<Profesor> getAll(ODB odb) {
		List<Profesor> profesores = new ArrayList();
		IQuery query = new CriteriaQuery(Profesor.class);
		Objects<Profesor> objectsProfesor = odb.getObjects(query);
		
		while (objectsProfesor.hasNext()) {
			profesores.add(objectsProfesor.next());
		}
		return profesores;
	}

	public List<Profesor> getAllMen(ODB odb) {
		List<Profesor> profesores = new ArrayList();
		IQuery query = new CriteriaQuery(Profesor.class, Where.equal("sexo", "Hombre"));
		Objects<Profesor> objectsProfesor = odb.getObjects(query);
		
		while (objectsProfesor.hasNext()) {
			profesores.add(objectsProfesor.next());
		}
		return profesores;
	}
	
	public void getAllBeforeDate(ODB odb, String year) {
		IQuery query = new CriteriaQuery(Profesor.class, Where.lt("fechaNacimiento", year));
		Objects<Profesor> objectsProfesor = odb.getObjects(query);
		
		int i = 1;
		while (objectsProfesor.hasNext()) {
			System.out.println((i++) + "\t: " + objectsProfesor.next());
		}
	}

	@Override
	public void save(Profesor profesor, ODB odb) {		
		odb.store(profesor);    
	}

	@Override
	public void update(Profesor t, String nombreDocumento) {
		
		
	}

	@Override
	public void delete(Profesor t, String nombreDocumento) {
		
	}
	

	
}
