package assignment.entities;

import java.util.Date;

public class Experience extends Candidate {
	private int expInYear;
	private String proSkill;

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	public String getProSkill() {
		return this.proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	public Experience(String cadidateID, String fullName, Date birthDay, String phone, String email, int candidate_type,
			int expInYear, String proSkill) {
		super(cadidateID, fullName, birthDay, phone, email, candidate_type);
		this.expInYear = expInYear;
		this.proSkill = proSkill;
		super.setCandidate_count(getCandidate_count() + 1);

	}

	public Experience(String cadidateID, String fullName, Date birthDay, String phone, String email,
			int candidate_type) {
		super(cadidateID, fullName, birthDay, phone, email, candidate_type);

	}

	public Experience() {

	}

	@Override
	public void showInfor() {
		System.out.println("CandidateID :" + getCadidateID() + "\n" + "CandidateName  : " + getFullName() + "\n"
				+ "BrithDay : " + getBirthDay() +"\n"+ "Phone : " + getPhone() +"\n"+ "Email :" + getEmail() +"\n"+ "CandidateType : "
				+ getCandidate_type() +"\n"+ "ExpInYear : " + this.expInYear +"\n"+ "Proskill : " + this.proSkill
		);

	}

	@Override
	public String toString() {
		return "Experience [expInYear=" + expInYear + ", proSkill=" + proSkill + ", getCadidateID()=" + getCadidateID()
				+ ", getFullName()=" + getFullName() + ", getBirthDay()=" + getBirthDay() + ", getPhone()=" + getPhone()
				+ ", getEmail()=" + getEmail() + ", getCandidate_type()=" + getCandidate_type()
				+ ", getCandidate_count()=" + getCandidate_count() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
