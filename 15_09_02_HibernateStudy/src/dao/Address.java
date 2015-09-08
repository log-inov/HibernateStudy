package dao;

import java.util.List;

import javax.persistence.*;

@Entity
public class Address {
	@Id
	@GeneratedValue
	int id;
	String country;
	String city;
	String street;
	String house;
	String app;
	//@OneToMany
	//List<Person> persons;
	
	public Address() {
		super();
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", country=" + country + ", city=" + city
				+ ", street=" + street + ", house=" + house + ", app=" + app
				+ "]";
	}
	
	
	public Address(String country, String city, String street,
			String house, String app) {
		super();
		this.country = country;
		this.city = city;
		this.street = street;
		this.house = house;
		this.app = app;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}
	
	

}
