package application;

import dao.*;
import model.Invitation;
import model.LieuSpectacle;

public class Application {

	public static void main(String[] args) {
		InvitationDao daoInv = new InvitationDao();
		LieuSpectacleDao daoLieu = new LieuSpectacleDao();
		
		Invitation inv1 = new Invitation("Mohamed", "Mohamed", "13/11/2018");
		Invitation inv2 = new Invitation("Ahmed", "Mande", "03/12/2019");
		Invitation inv3 = new Invitation("Amina", "Fabien", "25/08/2020");
		
		System.out.println(daoInv.create(inv1));
		daoInv.create(inv2);
		daoInv.create(inv3);
		
		LieuSpectacle lieuspec1 = new LieuSpectacle("Boom2", "Paris");
//		daoInv.update(inv1, lieuspec1);
//		inv1.addLieuSpectacle(lieuspec1);
//		lieuspec1.addInvitation(inv1);
		inv1.setLieuspectacle(lieuspec1);
		daoInv.update(inv1);
		
		LieuSpectacle lieuspec2 = new LieuSpectacle("Anniversaire2", "Lyon");
//		daoInv.update(inv2, lieuspec2);
//		inv2.addLieuSpectacle(lieuspec2);
//		lieuspec2.addInvitation(inv2);
		inv2.setLieuspectacle(lieuspec2);
		daoInv.update(inv2);
		
		inv3.setLieuspectacle(daoLieu.findById(1L));
		daoInv.update(inv3);
//		daoInv.update(inv3, daoLieu.findById(1L));
//		inv3.addLieuSpectacle(lieuspec1);
//		daoLieu.findById(5L).addInvitation(inv3);
//		inv3.setLieuspectacle(daoLieu.findById(3L));
//		daoInv.update(inv3);
		
		System.out.println(daoInv.findAll());
		
		System.out.println(daoLieu.findAll());
		
//		System.out.println("Ici entier retourné par dao.create(Invitation) : " + dao.create(inv1));
//		System.out.println("Ici entier retourné par dao.create(Invitation) : " + dao.create(inv2));
//		System.out.println("Ici entier retourné par dao.create(Invitation) : " + dao.create(inv3));
//
//		System.out.println("Ici Invitation retournée par findById(id) : " + dao.findById(1L));
//
//		Invitation inv2 = dao.findById(2L);
//		inv2.setDate("01/01/2018");
//		System.out.println("Ici entier retourné par dao.update(Invitation) : " + dao.update(inv2));
//
//		System.out.println("Ici liste retour de dao.findAll() Avant suppression : " + dao.findAll());
//
//		System.out.println("Ici entier retourné par deleteById(id) : " + dao.deleteById(4L));
//
//		System.out.println("Ici liste retour de dao.findAll() Apres suppression : " + dao.findAll());

		if(Dao.emf != null)
				Dao.emf.close();
	}

}
