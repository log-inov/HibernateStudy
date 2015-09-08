package dao;

import javax.persistence.*;

@Entity
public class Phone {
	@Id
	@GeneratedValue
	private int id;
	String phone;
	
	public Phone() {
	}

	public Phone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Phone [phone=" + phone + "]";
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//comment to comment purposes
	
	//second comment to comment purposes



}
