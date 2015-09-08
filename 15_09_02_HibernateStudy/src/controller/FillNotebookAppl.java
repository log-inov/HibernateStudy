package controller;

import java.util.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import dao.*;



public class FillNotebookAppl {

	private static final int NUMBER_OF_PERSONS = 200;
	private static final int MAX_NUM_ADDRESSES = 3;
	
	private static final String[] FIRST_NAMES = {"Isaac","Shlomo","Avi","Sergey","Alex","John","Dado"};
	private static final String[] LAST_NAMES = {"Gerzog","Ivanov","Smith","Hopeckins","Slon","Sherman","Хреенов"};
	private static final String[] COUNTRIES = {"Israel","Russia","Germany","USA","France","Spain","Argentina"};
	private static final String[] CITIES = {"Toronto","Chickago","Boston","Paris","Moscow","Praga","Tel-Aviv"};
	private static final String[] STREETS = {"Lenina","Washingtonova","Ben-Yehuda","Herzl","32nd West","Stalina","20 let VLKSM"};
	private static final int MAX_NUM_HOUSE = 25;
	private static final int MAX_NUM_APP = 500;
	private static final int MAX_PHONE_NUM = 999999999;
	private static final int MAX_NUM_PHONES = 3;
	

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		NoteBook notebook = (NoteBook) ctx.getBean("database");
		
		for (int i=0; i < NUMBER_OF_PERSONS; i++)
			addPersonToDatabase(notebook, createRandomPerson());
		
	/*	PersonsData personsData=(PersonsData)ctx.getBean("PersonsList");  */
	}

	private static void addPersonToDatabase(NoteBook notebook, Person person) {
		{
	    Nationality res = notebook.addNationality(person.getNationality());
	    if (res!=null)
			person.setNationality(res);
		}
		
		int i=0;
		for (Address address:person.getAddresses()){
			Address res=notebook.addAddress(address);
			if (res!=null)
					person.modifyAddressOfPerson(i++, res);
		}
		
		i = 0;
		for (Phone phone:person.getPhones()){
			Phone res = notebook.addPhone(phone);
			if (res!=null)
					person.modifyPhoneOfPerson(i++, res);
		}
		notebook.addPerson(person);
		System.out.println(person);
		
	}

	private static Person createRandomPerson() {
		Person person = new Person();
		Random random = new Random();
		
		person.setFirstName(FIRST_NAMES[random.nextInt(FIRST_NAMES.length)]);
		person.setLastName(LAST_NAMES[random.nextInt(LAST_NAMES.length)]);
		person.setNationality(new Nationality(COUNTRIES[random.nextInt(COUNTRIES.length)]));
		
		int numAddresses = 1 + random.nextInt(MAX_NUM_ADDRESSES);
		List<Address> addresses = new ArrayList();
		for (int i=0; i < numAddresses; i++)
			addresses.add(new Address(COUNTRIES[random.nextInt(COUNTRIES.length)],
					                  CITIES[random.nextInt(CITIES.length)],
					                  STREETS[random.nextInt(STREETS.length)],
					                  ((Integer)random.nextInt(1+MAX_NUM_HOUSE)).toString(),
					                  ((Integer)random.nextInt(1+MAX_NUM_APP)).toString()));
		person.setAddresses(addresses);
		
		int numPhones = 1 + random.nextInt(1+MAX_NUM_PHONES);
		List<Phone> phones = new ArrayList();
		for (int i=0; i < numAddresses; i++)
			phones.add(new Phone(((Integer)random.nextInt(10000000+MAX_PHONE_NUM)).toString()));               
		person.setPhones(phones);
		
		return person;
	}
	
	
}
