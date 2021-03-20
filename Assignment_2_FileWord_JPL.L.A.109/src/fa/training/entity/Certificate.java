package fa.training.entity;

import java.util.Date;

public class Certificate {
	private int certificateID;
	private String certificateName;
	private String certificateRank;
	private Date certificateDate;
	
	public Certificate() {
		super();
	}
	public Certificate(int certificateID, String certificateName, String certificateRank, Date certificateDate) {
		super();
		this.certificateID = certificateID;
		this.certificateName = certificateName;
		this.certificateRank = certificateRank;
		this.certificateDate = certificateDate;
	}
	public int getCertificateID() {
		return certificateID;
	}
	public void setCertificateID(int certificateID) {
		this.certificateID = certificateID;
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
	@Override
	public String toString() {
		return "Certificate [certificateID=" + certificateID + ", certificateName=" + certificateName
				+ ", certificateRank=" + certificateRank + ", certificateDate=" + certificateDate + "]";
	}
	
}
