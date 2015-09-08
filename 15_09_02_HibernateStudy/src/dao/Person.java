package dao;

import java.util.*;

import javax.persistence.*;

@Entity
public class Person {
	

	@Id
	@GeneratedValue
	private int id;
	String firstName;
	String lastName;
	@ManyToOne
	Nationality nationality;
	@ManyToMany 
	List<Address> addresses;
	@ManyToMany
	List<Phone> phones;

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", nationality=" + nationality + ", addresses="
				+ addresses + ", phones=" + phones + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public void modifyAddressOfPerson(int index, Address address){
		addresses.set(index, address);
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public void modifyPhoneOfPerson(int index, Phone phone) {
		phones.set(index, phone);
		
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	
	
}
