package fa.training.entitis;

import java.util.Date;

public class Certificate {
	String CandidateID;
	String CertificatedID;
	String CertificateName;
	String CertificateRank;
	String CertificatedDate;
	public String getCandidateID() {
		return CandidateID;
	}
	public void setCandidateID(String candidateID) {
		CandidateID = candidateID;
	}
	public String getCertificatedID() {
		return CertificatedID;
	}
	public void setCertificatedID(String certificatedID) {
		CertificatedID = certificatedID;
	}
	public String getCertificateName() {
		return CertificateName;
	}
	public void setCertificateName(String certificateName) {
		CertificateName = certificateName;
	}
	public String getCertificateRank() {
		return CertificateRank;
	}
	public void setCertificateRank(String certificateRank) {
		CertificateRank = certificateRank;
	}
	public String getCertificatedDate() {
		return CertificatedDate;
	}
	public void setCertificatedDate(String certificatedDate) {
		CertificatedDate = certificatedDate;
	}
	public Certificate() {
		
	}
	public Certificate(String candidateID, String certificatedID, String certificateName, String certificateRank,
			String certificatedDate) {
		super();
		CandidateID = candidateID;
		CertificatedID = certificatedID;
		CertificateName = certificateName;
		CertificateRank = certificateRank;
		CertificatedDate = certificatedDate;
	}
	@Override
	public String toString() {
		return "CandidateID=" + CandidateID + ", CertificatedID=" + CertificatedID + ", CertificateName="
				+ CertificateName + ", CertificateRank=" + CertificateRank + ", CertificatedDate=" + CertificatedDate
				+ "]";
	}


}
