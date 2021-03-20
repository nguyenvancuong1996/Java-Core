package assignment.common;

public class ExprienceSQL {
	public static final String ADD="INSERT INTO CANDIDATE(CandidateID,CandidateName,BirthDay,Phone,Email,CandidateType,ExpInYear,ProSkill)"
			+ " VALUES(?,?,?,?,?,?,?,?)";
	public static final String ADDFRESHER="INSERT INTO CANDIDATE(CandidateID,CandidateName,BirthDay,Phone,Email,CandidateType,GraduationDate,GraduationRank,Education) "
			+" VALUES(?,?,?,?,?,?,?,?,?)";

}
