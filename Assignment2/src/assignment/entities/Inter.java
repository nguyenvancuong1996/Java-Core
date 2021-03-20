package assignment.entities;

import java.util.Date;

public class Inter extends Candidate {

	private String majors;
	private int semester;
	private String universityName;

	public String getMajors() {
		return majors;
	}

	public void setMajors(String majors) {
		this.majors = majors;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public Inter() {

	}

	public Inter(String cadidateID, String fullName, Date birthDay, String phone, String email, int candidate_type,
			String majors, int semester, String universityName) {
		super(cadidateID, fullName, birthDay, phone, email, candidate_type);
		this.majors = majors;
		this.semester = semester;
		this.universityName = universityName;
		super.setCandidate_count(getCandidate_count() + 1);
	}

	public Inter(String cadidateID, String fullName, Date birthDay, String phone, String email, int candidate_type) {
		super(cadidateID, fullName, birthDay, phone, email, candidate_type);

	}

	@Override
	public void showInfor() {
		System.out.println("CandidateID :" + getCadidateID() + "\n" + "CandidateName  : " + getFullName() + "\n"
				+ "BrithDay : " + getBirthDay() + "\n" + "Phone : " + getPhone() + "\n" + "Email :" + getEmail() + "\n"
				+ "CandidateType : " + getCandidate_type() + "\n" + "Majors : " + this.majors + "\n" + "semester : "
				+ this.semester + "\n" + "UniversityName : " + this.universityName);
	}

}
