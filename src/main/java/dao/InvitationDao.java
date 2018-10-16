package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Invitation;
import model.LieuSpectacle;

public class InvitationDao implements Dao<Invitation> {

	public int create(Invitation inv) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		int resultat = -1;
		List<Invitation> findAll()
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

	public Invitation findById(Long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		Invitation inv = null;
		try {
			transaction.begin();
			inv = em.find(Invitation.class, id);
			inv.getLieuspectacle().getInvitations().size();
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

	public int update(Invitation inv) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		int resultat = -1;
		try {
			transaction.begin();
			Invitation inv1 = em.find(Invitation.class, inv.getId());
			inv1.setDate(inv.getDate());
			inv1.setNom(inv.getNom());
			inv1.setPrenom(inv.getPrenom());
			if(inv.getLieuspectacle()!=null) {
				if(inv.getLieuspectacle().getId()!=null) {
					inv1.addLieuSpectacle(em.find(LieuSpectacle.class, inv.getLieuspectacle().getId()));
				}else {
					inv1.setLieuspectacle(inv.getLieuspectacle());
				}
			}
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
	
	public int update(Invitation inv, LieuSpectacle lieu) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		int resultat = -1;
		try {
			transaction.begin();
			Invitation inv1 = em.find(Invitation.class, inv.getId());
			inv1.addLieuSpectacle(em.find(LieuSpectacle.class, lieu.getId()));			
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
			Invitation inv = em.find(Invitation.class, id);
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
			if(em != null)
				em.close();
		}
		return liste;
	}

}
