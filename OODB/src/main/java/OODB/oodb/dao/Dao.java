package OODB.oodb.dao;

import java.util.List;


public interface Dao<T> {
	T get(String id);
    
    List<T> getAll();
    
    void save(T t);
    
    void update(T t);
    
    void delete(T t);
}
