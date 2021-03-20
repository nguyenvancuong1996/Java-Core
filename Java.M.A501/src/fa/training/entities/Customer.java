package fa.training.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.utils.Validator;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String phone;
	String address;

	private List<Order> list = new ArrayList<Order>();

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Order> getList() {
		return list;
	}

	public void setList(List<Order> list2) {
		this.list = list2;
	}

	public Customer() {
		
	}

	public Customer(String name, String phone, String address, ArrayList<Order> list) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.list = list;
	}


	@Override
	public String toString() {
		String order="";
		for(Order x: this.list) {
			order+=x.getNumber();
			order+=x.getDate();
		}
		return name + ",\t\t" + address + ",\t\t" + phone + ",\t\t" +order;
 
	}

}
