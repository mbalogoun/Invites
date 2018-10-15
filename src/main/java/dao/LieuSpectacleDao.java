package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Invitation;
import model.LieuSpectacle;

public class LieuSpectacleDao implements Dao<LieuSpectacle> {

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
			if(em != null)
				em.close();
		}
		return resultat;
	}

	public LieuSpectacle findById(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		LieuSpectacle inv = null;
		try {
			transaction.begin();
			inv = em.find(LieuSpectacle.class, id);
			Set<Invitation> set = new HashSet<Invitation>();
			set = inv.getInvitations();
			set.size();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			if(em != null)
				em.close();
		}
		return inv;
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
			if(em != null)
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
			LieuSpectacle inv = em.find(LieuSpectacle.class, id);
			em.remove(inv);
			transaction.commit();
			resultat = 1;
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			if(em != null)
				em.close();
		}
		return resultat;
	}

	public List<LieuSpectacle> findAll() {
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
			if(em != null)
				em.close();
		}
		return liste;
	}

}
