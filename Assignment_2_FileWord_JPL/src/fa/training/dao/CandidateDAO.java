package fa.training.dao;

import java.sql.SQLException;
import java.util.List;

import fa.training.entity.Candidate;

public interface CandidateDAO {
	List<Candidate> getAllCandidate();
	
	//tra ve int Auto generated candidateID
	int insert(Candidate candidate) throws SQLException;
}
