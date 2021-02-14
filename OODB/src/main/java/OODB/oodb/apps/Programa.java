package OODB.oodb.apps;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import OODB.oodb.model.Profesor;

public class Programa {

	public static void main(String[] args) {
		//Conecto la base de datos
    	ODB odb = ODBFactory.open("pomelo.neodatis");
    	
    	//Creo un profesor
    	Profesor p1 = new Profesor(1,"Fedemina", "Fris", "Mujer", "12/02/2000");
    	
    	odb.store(p1);
    	
    	
    	odb.close();

	}

}
