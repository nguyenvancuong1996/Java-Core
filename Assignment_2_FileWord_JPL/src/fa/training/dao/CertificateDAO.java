package fa.training.dao;

import java.util.List;

import fa.training.entity.CandidateCertificate;

public interface CertificateDAO {
	public boolean insertCertificate(CandidateCertificate candidateCer,int candidateID);
	public List<CandidateCertificate> getListCertificateByCandidate(int candidateID);
}
