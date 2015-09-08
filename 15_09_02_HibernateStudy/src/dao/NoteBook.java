package dao;

import java.util.List;

import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;

public class NoteBook {
	
	@PersistenceContext(unitName="springHibernate",type=PersistenceContextType.EXTENDED)
	EntityManager em;
	
	@Transactional
	public Address addAddress(Address address){
		Query query = em.createQuery("SELECT address FROM Address address WHERE country=?1 AND city=?2 AND street=?3 " + 
				                      "AND house =?4 AND app=?5");
		query.setParameter(1, address.getCountry())
		     .setParameter(2, address.getCity())
		     .setParameter(3, address.getStreet())
		     .setParameter(4, address.getHouse())
		     .setParameter(5, address.getApp());
		Address res=null;
		try {
			res = (Address) query.getSingleResult();
		} catch (Exception e) {
		}
		if (res==null){
			em.persist(address);
		}
		return res;
	}
	
	@Transactional
	public Phone addPhone(Phone phone){
		Query query = em.createQuery("SELECT ph FROM Phone ph WHERE phone=?1");
		query.setParameter(1, phone.getPhone());
		Phone res = null;
		try {
			res = (Phone) query.getSingleResult();
		} catch (Exception e) {
		}
		if (res==null){
			em.persist(phone);
		}
		return res;
	}
	
	@Transactional
	public Boolean addPerson(Person person){
		em.persist(person);
		return true;
	}
	
	@Transactional
	public Iterable<Person> getPersonByAddressId(int id) {
		Query query = em.createQuery("SELECT person FROM Person person, Address address WHERE Address.id=?1");
		query.setParameter(1, id);
		List<Person> persons = query.getResultList();
		return persons;
	}

	public Nationality addNationality(Nationality nationality) {
		Query query = em.createQuery("SELECT n FROM Nationality n WHERE nationality=?1");
		query.setParameter(1, nationality.getNationality());
		Nationality res = null;
		try {
			res = (Nationality) query.getSingleResult();
		} catch (Exception e) {
		}
		if (res==null){
			em.persist(nationality);
		}
		return res;

	}

}
