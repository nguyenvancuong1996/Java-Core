package fa.training.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class Candidate implements Comparable<Candidate> {
	private int candidateID;
	private String fullName;
	private Date birthDay;
	private String phone;
	private String email;
	private int candidateType;
	private List<Certificate> listCertificate;

	public static int candidateCount = 0;

	public Candidate() {
		super();
	}

	public Candidate(int candidateID, String fullName, Date birthDay, String phone, String email, int candidateType) {
		super();
		this.candidateID = candidateID;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.phone = phone;
		this.email = email;
		this.candidateType = candidateType;
	}

	public int getCandidateID() {
		return candidateID;
	}

	public void setCandidateID(int candidateID) {
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

	public int getCandidateType() {
		return candidateType;
	}

	public void setCandidateType(int candidateType) {
		this.candidateType = candidateType;
	}

	public List<Certificate> getListCertificate() {
		return listCertificate;
	}

	public void setListCertificate(List<Certificate> listCertificate) {
		this.listCertificate = listCertificate;
	}

	public void showInfo() {
		System.out.println("CandidateID: " + this.getCandidateID() + "\n FullName: " + this.getFullName()
				+ "\n Birthdate: " + this.getBirthDay() + "\n Phone: " + this.getPhone() + "\n Email: "
				+ this.getEmail() + "\n CandidateTypeNumber: " + this.getCandidateType());
	}

	public abstract void showMe();

	// muon override trung lap thi alt shift s roi chon generate hashcode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidate other = (Candidate) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public int compareTo(Candidate one) {
		if (one.getCandidateType() > this.getCandidateType()) {
			return -1;
			// neu muon tangdan/giamdan thi dao nguoc -1 va 1
		} else if (one.getCandidateType() < this.getCandidateType()) {
			return 1;
		} else {
			// so sanh nam
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			if (Integer.parseInt(df.format(this.getBirthDay())) > Integer.parseInt(df.format(this.getBirthDay()))) {
				return 1;
			} else if (Integer.parseInt(df.format(this.getBirthDay())) < Integer
					.parseInt(df.format(this.getBirthDay()))) {
				return -1;
			} else {
				return 0;
			}
		}
	}

}
