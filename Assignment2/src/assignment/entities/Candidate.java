package assignment.entities;

import java.util.Date;

public abstract class Candidate  {
	
	private String cadidateID;
	private String fullName;
	private Date birthDay;
	private String phone;
	private String email;
	private int candidate_type;
	private int candidate_count;
	

	public String getCadidateID() {
		return cadidateID;
	}

	public void setCadidateID(String cadidateID) {
		this.cadidateID = cadidateID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCandidate_type() {
		return candidate_type;
	}

	public void setCandidate_type(int candidate_type) {
		this.candidate_type = candidate_type;
	}

	public int getCandidate_count() {
		return candidate_count;
	}

	public void setCandidate_count(int candidate_count) {
		this.candidate_count = candidate_count;
	}

	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candidate(String cadidateID, String fullName, Date birthDay, String phone, String email, int candidate_type,
			int candidate_count) {
		super();
		this.cadidateID = cadidateID;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.phone = phone;
		this.email = email;
		this.candidate_type = candidate_type;
		this.candidate_count = candidate_count;
	}
	
	

	public Candidate(String cadidateID, String fullName, Date birthDay, String phone, String email,
			int candidate_type) {
		super();
		this.cadidateID = cadidateID;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.phone = phone;
		this.email = email;
		this.candidate_type = candidate_type;
	}
	
	

	public abstract void showInfor();
	

}
