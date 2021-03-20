package fa.training.entitis;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Fresher extends Candidate {

	Date graduation_date;
	String graduation_rank;
	String education;

	public Fresher() {

	}

	public Date getGraduation_date() {
		return graduation_date;
	}

	public void setGraduation_date(Date graduation_date) {
		this.graduation_date = graduation_date;
	}

	public String getGraduation_rank() {
		return graduation_rank;
	}

	public void setGraduation_rank(String graduation_rank) {
		this.graduation_rank = graduation_rank;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	

	
	public Fresher(String candidateID, String fullName, Date birthDay, String phone, String email,
			String candidate_type, Date graduation_date, String graduation_rank, String education) {
		super(candidateID, fullName, birthDay, phone, email, candidate_type);
		this.graduation_date = graduation_date;
		this.graduation_rank = graduation_rank;
		this.education = education;
		super.setCanidate_count(getCanidate_count() + 1);
	}


	

	public Fresher(String candidateID, String fullName, Date birthDay, String phone, String email, int candidate_type) {
		super(candidateID, fullName, birthDay, phone, email, email, candidate_type);
		
	}

	@Override
	public String toString() {
		return "Fresher [Graduation_date=" + graduation_date + ", Graduation_rank=" + graduation_rank + ", Education="
				+ education + ", getList=" + getList() + ", getCandidateID=" + getCandidateID() + ", getFullName="
				+ getFullName() + ", getBirthDay=" + getBirthDay() + ", getPhone=" + getPhone() + ", getEmail="
				+ getEmail() + ", getCandidate_type()=" + getCandidate_type() + "]";
	}
	
	@Override
	public String ShowMe() {
		return super.ShowInfo() + "Fresher [Graduation_date=" + graduation_date + ", Graduation_rank=" + graduation_rank + ", Education="
				+ education + ", getList=" + getList() + ", getCandidateID=" + getCandidateID() + ", getFullName()="
				+ getFullName() + ", getBirthDay()=" + getBirthDay() + ", getPhone()=" + getPhone() + ", getEmail()="
				+ getEmail() + ", getCandidate_type()=" + getCandidate_type() + "]";
	}
	

	

}
