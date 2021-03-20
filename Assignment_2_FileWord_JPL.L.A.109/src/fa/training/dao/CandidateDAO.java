package fa.training.dao;

import java.sql.SQLException;
import java.util.List;

import fa.training.entity.Candidate;

public interface CandidateDAO {
	List<Candidate> getAllCandidate();
	
	//return id tao tu dong trong bd
	int insert(Candidate candidate) throws SQLException;
}
