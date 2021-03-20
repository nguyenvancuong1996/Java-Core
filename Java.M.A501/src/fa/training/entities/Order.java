package fa.training.entities;

import java.io.Serializable;
import java.util.Date;


public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String number;
	Date date;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {

		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Order() {
		super();
	}

	public Order(String number, Date date) {
		super();
		this.number = number;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Order number=" + number + ", date=" + date +"\t";
	}

}
