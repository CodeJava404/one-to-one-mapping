package org.info;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.info.pojo.Address;
import org.info.pojo.Person;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction tn = session.beginTransaction();

		Person person = new Person();
		person.setAge(101);
		person.setPersonName("Santosh");
		Address address = new Address();
		address.setCity("Ahmedpur");
		address.setPerson(person);
		address.setPincode(413515);
		person.setAddress(address);
		session.save(address);
		session.save(person);
		session.flush();
		tn.commit();

	}
}
