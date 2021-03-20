package assignment.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import assignment.common.CandidateSQL;
import assignment.common.DBConnection;
import assignment.entities.Certificate;
import assignment.utils.ConvertDateToLocalDate;

public class CertificateDaoImpl implements CertificateDao {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pst;

	@Override
	public boolean addCertificate(Certificate certificates) {
		conn = DBConnection.getConnectionDB();
		try {
			pst = conn.prepareStatement(CandidateSQL.ADD_CERTIFICATE);
			pst.setString(1, certificates.getCertificateID());
			pst.setString(2, certificates.getCandidateID());
			pst.setString(3, certificates.getCertificateName());
			pst.setString(4, certificates.getCertificateRank());
			pst.setDate(5, Date.valueOf(ConvertDateToLocalDate.oldDateToLocalDate(certificates.getCertificateDate())));
			if (pst.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

}
