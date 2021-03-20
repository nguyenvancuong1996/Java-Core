package assignment.entities;

import java.util.Date;

public class Certificate {
	
	private String candidateID;
	private String certificateID;
	private String certificateName;
	private String certificateRank;
	private Date certificateDate;

	public String getCertificateID() {
		return certificateID;
	}

	public void setCertificateID(String certificateID) {
		this.certificateID = certificateID;
	}

	public String getCandidateID() {
		return candidateID;
	}

	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public String getCertificateRank() {
		return certificateRank;
	}

	public void setCertificateRank(String certificateRank) {
		this.certificateRank = certificateRank;
	}

	public Date getCertificateDate() {
		return certificateDate;
	}

	public void setCertificateDate(Date certificateDate) {
		this.certificateDate = certificateDate;
	}

	public Certificate(String certificateID, String candidateID, String certificateName, String certificateRank,
			Date certificateDate) {
		super();
		this.certificateID = certificateID;
		this.candidateID = candidateID;
		this.certificateName = certificateName;
		this.certificateRank = certificateRank;
		this.certificateDate = certificateDate;
	}

	public Certificate() {
		super();
	}

}
