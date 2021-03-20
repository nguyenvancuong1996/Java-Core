package assignment.common;

public class CandidateSQL {
	public static final String ADD = "INSERT INTO Candidate(CandidateID,CandidateName,BirthDay,Phone,Email,CandidateType,ExpInYear,ProSkill,GraduationDate,GraduationRank,Education,Majors,Semester,UniversityName)"
			+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String SELECTALLCANDIDATE="SELECT * FROM CANDIDATE";
	
	public static final String ADD_CERTIFICATE="INSERT INTO CANDIDATE_CERTIFICATE VALUES(?,?,?,?,?)";
	

}
