package application;

import dao.MyDao;
import model.Invitation;
import model.LieuSpectacle;

public class Application {

	public static void main(String[] args) {
		MyDao dao = new MyDao();
		
		Invitation inv1 = new Invitation("Balogoun2", "Mohamed", "13/11/2018");
		Invitation inv2 = new Invitation("Marlon2", "Mande", "03/12/2019");
		Invitation inv3 = new Invitation("Drouot2", "Fabien", "25/08/2020");
		
		dao.create(inv1);
		dao.create(inv2);
		dao.create(inv3);
		
		LieuSpectacle lieuspec1 = new LieuSpectacle("Boom", "Paris");
		inv1.setLieuspectacle(lieuspec1);
		dao.update(inv1);
		
		LieuSpectacle lieuspec2 = new LieuSpectacle("Anniversaire", "Lyon");
		inv2.setLieuspectacle(lieuspec2);
		dao.update(inv2);
		
		inv3.setLieuspectacle(dao.findLieuSpecById(1L));
		dao.update(inv3);
		
		System.out.println(dao.findAll());
		
		System.out.println(dao.findLieuSpecAll());
		
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

		dao.getEmf().close();
	}

}
