package fa.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.dao.CertificateDAO;
import fa.training.entity.CandidateCertificate;
import fa.training.utils.Constants;
import fa.training.utils.DBUtils;

public class CertificateDAOImpl implements CertificateDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;

	@Override
	public boolean insertCertificate(CandidateCertificate candidateCer, int candidateID) {

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(Constants.QUERY_INSERT_CERTIFICATE);
			preparedStatement.setInt(1, candidateID);
			preparedStatement.setString(2, candidateCer.getCertificateName());
			preparedStatement.setString(3, candidateCer.getCertificateRank());
			preparedStatement.setDate(4, new java.sql.Date(candidateCer.getCertificateDate().getTime()));
			if (preparedStatement.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!");
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
//				e.printStackTrace();
				System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!");
			}
		}
		return false;
	}

	@Override
	public List<CandidateCertificate> getListCertificateByCandidate(int candidateID) {
		List<CandidateCertificate> listCandidateCer = null;
		CandidateCertificate candidateCer = null;

		try {

			listCandidateCer = new ArrayList<>();

			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(Constants.QUERY_CERTIFICATE_BY_CANDIDATEID);
			preparedStatement.setInt(1, candidateID);
			results = preparedStatement.executeQuery();
			while (results.next()) {
				candidateCer = new CandidateCertificate();
				candidateCer.setCertificateID(results.getInt("CertificateID"));
				candidateCer.setCertificateName(results.getString("CertificateName"));
				candidateCer.setCertificateRank(results.getString("CertificateRank"));
				candidateCer.setCertificateDate(results.getDate("CertificateDate"));
				listCandidateCer.add(candidateCer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (results != null) {
					results.close();
				}
//				if (connection != null) {
//					//connection.close();
//				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!");
			}
		}

		return listCandidateCer;
	}

}
