package fa.training.service;

import java.util.List;
import java.util.Set;

import fa.training.entity.Candidate;

public interface CandidateService {
	public Candidate addCandidate();
	
	public List<Candidate> getAllCandidate();

	public void printCandidateFullName();

	public Set<Candidate> duplicateEmailCandidate();

	public List<Candidate> sortCandidate();

	public void showInfo();
	public void addCandidateCertificate();
}
