package OODB.oodb;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import OODB.oodb.model.Profesor;

public class App 
{
    public static void main (String[] args) {
    	String nombre = "p";
    	for(int x = 1; x<10; x++) {
    		nombre = nombre + x;
    		System.out.println(nombre);
    		nombre = "p";
    	}
    	//NO ACEPTA ATRIBUTOS TIPO CALENDAR
    	//Si te da fallo, cambiar el nombre de la base de datos creada para que se te genere otra.
    	
    	//Conecto la base de datos
//    	ODB odb = ODBFactory.open("patatas.neodatis");
    	
    	//Creo un profesor
//    	Profesor p1 = new Profesor(1,"Fedemina", "Fris", "Mujer", "fechaaa");
    	
//    	odb.store(p1);
    	
    	
//    	odb.close();
    	
    }
}
