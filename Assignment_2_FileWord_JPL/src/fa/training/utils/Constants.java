package fa.training.utils;

public class Constants {
	public static final String FILE_PATH = "candidate.dat";
	public static final String VALID_PHONE_REGEX = "(03|07|08|09|01[2|6|8|9])+([0-9]){8}";
	public static final String VALID_EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
//	^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$
													
	public static final String DATETIMEFORMAT = "dd/MM/yyyy";
	
	
	public static final String QUERY_SELECT_ALL_CANDIDATE="SELECT * FROM CANDIDATE";
	public static final String QUERY_INSERT_CANDIDATE_EXPERIENCE = ""
			+ "INSERT INTO Candidate"
			+ "(CandidateName,Birthday,Phone,Email,CandidateType,ExpInYear,ProSkill)"
			+ " VALUES(?,?,?,?,?,?,?)";
	public static final String QUERY_INSERT_CANDIDATE_FRESHER = ""
			+ "INSERT INTO Candidate"
			+ "(CandidateName,Birthday,Phone,Email,CandidateType,GraduationDate,GraduationRank,Education)"
			+ " VALUES(?,?,?,?,?,?,?,?)";
	public static final String QUERY_INSERT_CANDIDATE_INTERN = ""
			+ "INSERT INTO Candidate"
			+ "(CandidateName,Birthday,Phone,Email,CandidateType,Majors,Semester,UniversityName)"
			+ " VALUES(?,?,?,?,?,?,?,?)";
	public static final String QUERY_INSERT_CERTIFICATE = ""
			+ "INSERT INTO CANDIDATE_CERTIFICATE(CandidateID,CertificateName,CertificateRank,CertificateDate)"
			+ "VALUES(?,?,?,?)";
	public static final String QUERY_CERTIFICATE_BY_CANDIDATEID = ""
			+ "SELECT CertificateID,CandidateID,CertificateName,CertificateRank,CertificateDate"
			+ " FROM CANDIDATE_CERTIFICATE"
			+ " WHERE CandidateID = ?";
}
