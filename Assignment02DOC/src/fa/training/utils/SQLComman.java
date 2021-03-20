package fa.training.utils;

public class SQLComman {
	public static String CANDIDATE_QUERY_FIND_ALL            =   
		"SELECT * FROM CANDIDATE ";
	public static String EXPERIENCE_QUERY_FIND_ALL            =   
			"Candidate(CandidateID, FullName, BirthDay, Phone, Email, Candidate_type, ExplnYear, ProSkill, Graduation_date, Graduation_rank, Education, Majors, Semeter, University_name"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
