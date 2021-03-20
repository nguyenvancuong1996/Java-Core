package fa.training.dao;

import java.util.List;

import fa.training.entitis.Candidate;

public interface CandidateDAO {
	public List<Candidate> getAllCandidate();

	public boolean Candidateinsert(Candidate candidate);


	public void addCertificate();
	public boolean update(String name,int row);
	public void insertViaResultSet();
}
