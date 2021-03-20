package fa.training.entitis;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Intern extends Candidate {
	String Majors;
	String Semester;
	String University_name;

	public Intern() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Intern(String candidateID, String fullName, Date birthDay, String phone, String email, String candidate_type,
			String canidate_count, String majors, String semester, String university_name) {
		super(candidateID, fullName, birthDay, phone, email, candidate_type);

		this.Majors = majors;
		this.Semester = semester;
		this.University_name = university_name;
	}

	public Intern(String candidateID, String fullName, Date birthDay, String phone, String email, String candidate_type,
			String majors, String semester, String university_name) {
		super(candidateID, fullName, birthDay, phone, email, candidate_type);
		this.Majors = majors;
		this.Semester = semester;
		this.University_name = university_name;
	}

	public String getMajors() {
		return Majors;
	}

	public void setMajors(String majors) {
		Majors = majors;
	}

	public String getSemester() {
		return Semester;
	}

	public void setSemester(String semester) {
		Semester = semester;
	}

	public String getUniversity_name() {
		return University_name;
	}

	public void setUniversity_name(String university_name) {
		University_name = university_name;
	}

	@Override
	public String ShowMe() {
		return super.ShowInfo() + "Intern [Majors=" + Majors + ", Semester=" + Semester + ", University_name=" + University_name
				+ ", getList=" + getList() + ", getCandidateID=" + getCandidateID() + ", getFullName="
				+ getFullName() + ", getBirthDay=" + getBirthDay() + ", getPhone=" + getPhone() + ", getEmail="
				+ getEmail() + ", getCandidate_type=" + getCandidate_type() + "]";

	}

	@Override
	public String toString() {
		return "Intern [Majors=" + Majors + ", Semester=" + Semester + ", University_name=" + University_name
				+ ", getList()=" + getList() + ", getCandidateID()=" + getCandidateID() + ", getFullName()="
				+ getFullName() + ", getBirthDay()=" + getBirthDay() + ", getPhone()=" + getPhone() + ", getEmail()="
				+ getEmail() + ", getCandidate_type()=" + getCandidate_type() + "]";
	}

	

	

}
