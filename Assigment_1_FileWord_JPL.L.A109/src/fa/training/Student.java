package fa.training;

public class Student {
	private String stdNo;
	private String stdName;
	private String stdPhone;
	private String stdEmail;
	private double gradePoint;
	
	public Student() {
		super();
	}
	public Student(String stdNo, String stdName, String stdPhone, String stdEmail, double gradePoint) {
		super();
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.stdPhone = stdPhone;
		this.stdEmail = stdEmail;
		this.gradePoint = gradePoint;
	}
	public String getStdNo() {
		return stdNo;
	}
	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdPhone() {
		return stdPhone;
	}
	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}
	public String getStdEmail() {
		return stdEmail;
	}
	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}
	public double getGradePoint() {
		return gradePoint;
	}
	public void setGradePoint(double gradePoint) {
		this.gradePoint = gradePoint;
	}
	@Override
	public String toString() {
		return "Student [stdNo=" + stdNo + ", stdName=" + stdName + ", stdPhone=" + stdPhone + ", stdEmail=" + stdEmail
				+ ", gradePoint=" + gradePoint + "]";
	}
	
	
}
