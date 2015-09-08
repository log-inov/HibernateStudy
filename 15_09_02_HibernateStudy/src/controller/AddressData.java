package controller;

import java.util.*;

import dao.*;

public class AddressData {

	List<Address> addresses;

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "AddressData [addresses=" + addresses + "]";
	}

	public List<Address> getAddresses() {
		return addresses;
	}
	
	
	
	
	
	

}
