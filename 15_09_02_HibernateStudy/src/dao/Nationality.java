package dao;

import java.util.*;

import javax.persistence.*;

@Entity
public class Nationality {
	
	@Id
	@GeneratedValue
	int id;
	String nationality;
	@OneToMany (mappedBy="nationality")
	List<Person> persons;
	
	public Nationality() {};
	
	public Nationality(String string) {
		this.nationality = string;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "Nationality [nationality=" + nationality + "]";
	}
	
	
	

}
