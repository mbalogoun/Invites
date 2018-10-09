package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.*;

public class MyDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("invites");
	
	public void create(Invitation inv) {		
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(inv);
			transaction.commit();
			
		}catch(Exception e) {
			if(transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public Invitation findById(int id) {	
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		Invitation inv = null;
		try {
			transaction.begin();
			inv = em.find(Invitation.class, id);
			transaction.commit();
		}catch(Exception e) {
			if(transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		return inv;
	}
	
	public void update(Invitation inv) {	
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			Invitation inv1 = em.find(Invitation.class,inv.getId());
			inv1.setDate(inv.getDate());
			inv1.setNom(inv.getNom());
			inv1.setLieu(inv.getLieu());
			inv1.setPrenom(inv.getPrenom());
			transaction.commit();		
		}catch(Exception e) {
			if(transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public void deleteById(int id) {		
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			Invitation inv = em.find(Invitation.class,id);
			em.remove(inv);
			transaction.commit();
			
		}catch(Exception e) {
			if(transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

}
