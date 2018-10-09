package application;

import dao.MyDao;
import model.Invitation;

public class Application {

	public static void main(String[] args) {
		MyDao dao = new MyDao();
//		Invitation inv = new Invitation("Balogoun", "Mohamed", "Paris", "13/11/2018");
//		Invitation inv1 = new Invitation("Marlon", "Mande", "Nice", "13/11/2019");
		
//		dao.create(inv);
//		dao.create(inv1);
		Invitation inv = dao.findById(1);
		inv.setDate("01/10/2018");
		dao.update(inv);

	}

}
