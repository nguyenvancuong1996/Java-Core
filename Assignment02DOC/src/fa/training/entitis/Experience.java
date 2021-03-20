package fa.training.entitis;

import java.util.Date;

public class Experience extends Candidate {
	int expInYear;
	String proSkill;

	public Experience() {

	}

	public Experience(String candidateID, String fullName, Date birthDay, String phone, String email,
			String candidate_type, int expInYear, String proSkill) {
		super(candidateID, fullName, birthDay, phone, email, candidate_type);
		this.expInYear = expInYear;
		this.proSkill = proSkill;
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
	public String ShowMe() {
		return super.ShowInfo() + "Experience [expInYear=" + expInYear + ", proSkill=" + proSkill + ", getList="
				+ getList() + ", getCandidateID=" + getCandidateID() + ", getFullName=" + getFullName()
				+ ", getBirthDay=" + getBirthDay() + ", getPhone=" + getPhone() + ", getEmail()=" + getEmail()
				+ ", getCandidate_type()=" + getCandidate_type() + "]";

	}

}
