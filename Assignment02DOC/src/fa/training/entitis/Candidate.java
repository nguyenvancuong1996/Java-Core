package fa.training.entitis;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Candidate implements Comparable<Candidate> {
	String candidateID;
	String fullName;
	Date birthDay;
	String phone;
	String email;
	String candidate_type;
	int canidate_count;
	// tao cai list Certificate
	private List<Certificate> list = new ArrayList<>();

	public List<Certificate> getList() {
		return list;
	}

	public void setList(List<Certificate> list) {
		this.list = list;
	}

	public String getCandidateID() {
		return candidateID;
	}

	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
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

	public String getCandidate_type() {
		return candidate_type;
	}

	public void setCandidate_type(String candidate_type) {
		this.candidate_type = candidate_type;
	}

	public int getCanidate_count() {
		return canidate_count;
	}

	public void setCanidate_count(int canidate_count) {
		this.canidate_count = canidate_count;
	}

	public Candidate() {
	}

	@Override
	public boolean equals(Object one) {
		if (one instanceof Candidate) {
			Candidate candidate = (Candidate) one;
			if (this.getEmail().equals(candidate.getEmail())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public Candidate(String candidateID, String fullName, Date birthDay, String phone, String email,
			String candidate_type, int canidate_count) {
		super();
		this.candidateID = candidateID;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.phone = phone;
		this.email = email;
		this.candidate_type = candidate_type;
	}

	public Candidate(String candidateID, String fullName, Date birthDay, String phone, String email,
			String candidate_type) {
		super();
		this.candidateID = candidateID;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.phone = phone;
		this.email = email;
		this.candidate_type = candidate_type;
	}
	

	public String ShowInfo() {
		return "candidateID=" + candidateID + ", fullName=" + fullName + ", birthDay=" + birthDay
				+ ", phone=" + phone + ", email=" + email + ", candidate_type=" + candidate_type + ", canidate_count="
				+ canidate_count;
	};
			
	public abstract String ShowMe();

	@Override
	public int compareTo(Candidate one) {
		if (one.getCandidate_type().equals(this.getCandidate_type())) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			if (Integer.parseInt(df.format(this.getBirthDay())) > Integer.parseInt(df.format(this.getBirthDay()))) {
				return 1;
			} else if (Integer.parseInt(df.format(this.getBirthDay())) < Integer
					.parseInt(df.format(this.getBirthDay()))) {
				return -1;
			} else {
				return 0;
			}
		} else {
			return this.getCandidate_type().compareTo(one.getCandidate_type());
		}
	}

}
