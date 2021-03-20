package fa.training.entity;

import java.util.Date;

public class Experience extends Candidate {
	private int expInYear;
	private String proSkill;

	public Experience(int expInYear, String proSkill) {
		super();
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}

	public Experience(int candidateID, String fullName, Date birthDay, String phone, String email, int candidateType,
			int expInYear, String proSkill) {
		super(candidateID, fullName, birthDay, phone, email, candidateType);
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}

	public Experience() {

	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	@Override
	public void showMe() {
		super.showInfo();
		System.out.println(" CandidateType: Fresher"
				+ "\n ExpInYear: " + this.getExpInYear() 
				+ "\n ProSkill: " + this.getProSkill());
//		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Candidate: Experience [expInYear=" + expInYear + ", proSkill=" + proSkill + ", getCandidateID()="
				+ getCandidateID() + ", FullName=" + getFullName() + ", Birthday=" + getBirthDay()
				+ ", getPhone()=" + getPhone() + ", getEmail()=" + getEmail() + ", getCandidateType()="
				+ getCandidateType() + ", getListCertificate()=" + getListCertificate() + "]";
	}

}
