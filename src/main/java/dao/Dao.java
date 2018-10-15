package dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface Dao<T> {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("invites");
	
	public int create(T inv);
	
	public T findById(Long id);

	public int update(T inv);
	
	
	public int deleteById(Long id);

	public List<T> findAll();
	
//	public void closeEmf() {
//		if(this.emf != null)
//			this.emf.close();
//	}

}
