package assignment.entities;

import java.util.Date;

public class Fresher extends Candidate {
	private Date gradutionDate;
	private String gradutionRank;
	private String education;

	public Date getGradutionDate() {
		return gradutionDate;
	}

	public void setGradutionDate(Date gradutionDate) {
		this.gradutionDate = gradutionDate;
	}

	public String getGradutionRank() {
		return gradutionRank;
	}

	public void setGradutionRank(String gradutionRank) {
		this.gradutionRank = gradutionRank;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Fresher() {

	}

	public Fresher(String cadidateID, String fullName, Date birthDay, String phone, String email, int candidate_type,
			Date gradutionDate, String gradutionRank, String education) {

		super(cadidateID, fullName, birthDay, phone, email, candidate_type);
		this.gradutionDate = gradutionDate;
		this.gradutionRank = gradutionRank;
		this.education = education;
		super.setCandidate_count(getCandidate_count() + 1);

	}

	public Fresher(String cadidateID, String fullName, Date birthDay, String phone, String email, int candidate_type) {

		super(cadidateID, fullName, birthDay, phone, email, candidate_type);

	}

	@Override
	public void showInfor() {
		System.out.println("CandidateID :" + getCadidateID() + "\n" + "CandidateName  : " + getFullName() + "\n"
				+ "BrithDay : " + getBirthDay() +"\n"+ "Phone : " + getPhone() +"\n"+ "Email :" + getEmail() +"\n"+ "CandidateType : "
				+ getCandidate_type() +"\n"+ "GradutionDate : " + this.gradutionDate + "GradutionRank : "
				+ this.gradutionRank +"\n"+ "Education : " + this.education);
	}

	@Override
	public String toString() {
		return "Fresher [gradutionDate=" + gradutionDate + ", gradutionRank=" + gradutionRank + ", education="
				+ education + ", getCadidateID()=" + getCadidateID() + ", getFullName()=" + getFullName()
				+ ", getBirthDay()=" + getBirthDay() + ", getPhone()=" + getPhone() + ", getEmail()=" + getEmail()
				+ ", getCandidate_type()=" + getCandidate_type() + ", getCandidate_count()=" + getCandidate_count()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
