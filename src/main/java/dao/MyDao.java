package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Invitation;
import model.LieuSpectacle;

public class MyDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("invites");

	public int create(Invitation inv) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		int resultat = -1;
		try {
			transaction.begin();
			em.persist(inv);
			transaction.commit();
			resultat = 1;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return resultat;
	}
	
	public int create(LieuSpectacle inv) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		int resultat = -1;
		try {
			transaction.begin();
			em.persist(inv);
			transaction.commit();
			resultat = 1;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return resultat;
	}

	public Invitation findById(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		Invitation inv = null;
		try {
			transaction.begin();
			inv = em.find(Invitation.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return inv;
	}
	
	public LieuSpectacle findLieuSpecById(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		LieuSpectacle inv = null;
		try {
			transaction.begin();
			inv = em.find(LieuSpectacle.class, id);
			transaction.commit();
		} catch (Exception e) {
//			if (transaction != null)
//				transaction.rollback();
//			e.printStackTrace();
		} finally {
			em.close();
		}
		return inv;
	}

	public int update(Invitation inv) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		int resultat = -1;
		try {
			transaction.begin();
			Invitation inv1 = em.find(Invitation.class, inv.getId());
			inv1.setDate(inv.getDate());
			inv1.setNom(inv.getNom());
			inv1.setLieuspectacle(inv.getLieuspectacle());
			inv1.setPrenom(inv.getPrenom());
			transaction.commit();
			resultat = 1;
		} catch (Exception e) {
//			if (transaction != null)
//				transaction.rollback();
//			e.printStackTrace();
		} finally {
			em.close();
		}
		return resultat;
	}
	
	public int update(LieuSpectacle inv) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		int resultat = -1;
		try {
			transaction.begin();
			LieuSpectacle inv1 = em.find(LieuSpectacle.class, inv.getId());
			inv1.setName(inv.getName());
			inv1.setAdresse(inv.getAdresse());
			transaction.commit();
			resultat = 1;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return resultat;
	}

	public int deleteById(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		int resultat = -1;
		try {
			transaction.begin();
			Invitation inv = em.find(Invitation.class, id);
			em.remove(inv);
			transaction.commit();
			resultat = 1;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return resultat;
	}
	
	public int deleteLieuSpecById(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		int resultat = -1;
		try {
			transaction.begin();
			LieuSpectacle inv = em.find(LieuSpectacle.class, id);
			em.remove(inv);
			transaction.commit();
			resultat = 1;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return resultat;
	}

	public List<Invitation> findAll() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		List<Invitation> liste = new ArrayList<Invitation>();
		try {
			transaction.begin();
			TypedQuery<Invitation> req = em.createNamedQuery("Invitation.findAll", Invitation.class);
			liste = req.getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return liste;
	}
	
	public List<LieuSpectacle> findLieuSpecAll() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		List<LieuSpectacle> liste = new ArrayList<LieuSpectacle>();
		try {
			transaction.begin();
			TypedQuery<LieuSpectacle> req = em.createNamedQuery("LieuSpectacle.findAll", LieuSpectacle.class);
			liste = req.getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return liste;
	}

}
