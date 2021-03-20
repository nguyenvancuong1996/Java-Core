package fa.training.service;

import java.util.List;
import java.util.Set;

import fa.training.entity.Candidate;

public interface CandidateService {
	public Candidate addCandidate();
	
	public List<Candidate> getAllCandidate();

	public void printAllCandidateFullName();

	public Set<Candidate> readNonduplicateEmailCandidate();

	public List<Candidate> getSortCandidate();

	public void showInfo();
	public void addCandidateWithCertificate();
}
