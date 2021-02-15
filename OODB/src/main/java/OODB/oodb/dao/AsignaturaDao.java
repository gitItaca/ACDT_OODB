package OODB.oodb.dao;

import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import OODB.oodb.model.Asignatura;

public class AsignaturaDao implements Dao<Asignatura>{

	@Override
	public Asignatura get(String id) {
		
		return null;
	}
	
	public List<Asignatura> getNombre(ODB odb, String nombre) {
		List<Asignatura> asignaturas = new ArrayList();
		IQuery query = new CriteriaQuery(Asignatura.class, Where.equal("nombre", nombre));
		Objects<Asignatura> objectsAsignaturas = odb.getObjects(query);
		
		while(objectsAsignaturas.hasNext()) {
			asignaturas.add(objectsAsignaturas.next());
		}
		return asignaturas;
	}

	@Override
	public List<Asignatura> getAll(ODB odb) {
		List<Asignatura> asignaturas = new ArrayList();
		IQuery query = new CriteriaQuery(Asignatura.class);
		Objects<Asignatura> objectsAsignaturas = odb.getObjects(query);
		
		while (objectsAsignaturas.hasNext()) {
			asignaturas.add(objectsAsignaturas.next());
		}
		return asignaturas;
	}

	@Override
	public void save(Asignatura asignatura, ODB odb) {
		odb.store(asignatura);
		
	}

	@Override
	public void update(Asignatura asignatura, String nombreDocumento) {
		
		
	}

	@Override
	public void delete(Asignatura asignatura, String nombreDocumento) {
		
		
	}

	
}
