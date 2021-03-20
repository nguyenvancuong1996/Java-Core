package fa.training.dao;

import java.util.List;

import fa.training.entity.Certificate;

public interface CertificateDAO {
	public boolean insertCertificate(Certificate candidateCer,int candidateID);
	public List<Certificate> getListCertificateByCandidate(int candidateID);
}
