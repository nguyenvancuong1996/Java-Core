package fa.training.entity;

import java.util.Date;

public class Fresher extends Candidate{
	private Date graduationDate;
	private String graduationRank;
	private String education;
	
	public Fresher() {
		super();
	}

	public Fresher(Date graduationDate, String graduationRank, String education) {
		super();
		this.graduationDate = graduationDate;
		this.graduationRank = graduationRank;
		this.education = education;
	}
	
	public Fresher(int candidateID, String fullName, Date birthDay, String phone, String email, int candidateType,
			 Date graduationDate, String graduationRank, String education) {
		super(candidateID, fullName, birthDay, phone, email, candidateType);
		this.graduationDate = graduationDate;
		this.graduationRank = graduationRank;
		this.education = education;
	}

	public Date getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getGraduationRank() {
		return graduationRank;
	}

	public void setGraduationRank(String graduationRank) {
		this.graduationRank = graduationRank;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public void showMe() {
		super.showInfo();
		System.out.println(" CandidateType: Fresher"
				+ "\n GraduationDate: " + this.getGraduationDate() 
				+ "\n GraduationRank: " + this.getGraduationRank() 
				+ "\n Education: " + this.getEducation());
		
	}

	@Override
	public String toString() {
		return "Fresher [graduationDate=" + graduationDate + ", graduationRank=" + graduationRank + ", education="
				+ education + ", getGraduationDate()=" + getGraduationDate() + ", getGraduationRank()="
				+ getGraduationRank() + ", getCandidateID()=" + getCandidateID() + ", getFullName()=" + getFullName()
				+ ", getBirthDay()=" + getBirthDay() + ", getPhone()=" + getPhone() + ", getEmail()=" + getEmail()
				+ ", getCandidateType()=" + getCandidateType() + ", getListCertificate()=" + getListCertificate() + "]";
	}

	
	
	
}
