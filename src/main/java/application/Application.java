package application;

import dao.MyDao;
import model.Invitation;

public class Application {

	public static void main(String[] args) {
		MyDao dao = new MyDao();
		Invitation inv = new Invitation("Balogoun", "Mohamed", "Paris", "13/11/2018");
		Invitation inv0 = new Invitation("Marlon", "Mande", "Nice", "03/12/2019");
		Invitation inv1 = new Invitation("Drouot", "Fabien", "Nantes", "25/08/2020");

		System.out.println("Ici entier retourné par dao.create(Invitation) : " + dao.create(inv));
		System.out.println("Ici entier retourné par dao.create(Invitation) : " + dao.create(inv0));
		System.out.println("Ici entier retourné par dao.create(Invitation) : " + dao.create(inv1));

		System.out.println("Ici Invitation retournée par findById(id) : " + dao.findById(1));

		Invitation inv2 = dao.findById(2);
		inv2.setDate("01/10/2018");
		System.out.println("Ici entier retourné par dao.update(Invitation) : " + dao.update(inv2));

		System.out.println("Ici liste retour de dao.findAll() Avant suppression : " + dao.findAll());

		System.out.println("Ici entier retourné par deleteById(id) : " + dao.deleteById(3));

		System.out.println("Ici liste retour de dao.findAll() Apres suppression : " + dao.findAll());

	}

}
