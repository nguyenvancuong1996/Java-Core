package assignment.dao;

import java.util.List;

import assignment.entities.Candidate;

public interface CandidateDao {

	boolean addCandidate(Candidate candidate);

	List<Candidate> selectAllCandidate();

	void updateResultSet();

	void insertResultSet();
}
