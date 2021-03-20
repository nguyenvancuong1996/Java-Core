package fa.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import fa.training.comman.DAO.CommonDAO;
import fa.training.dao.CertificateDAO;
import fa.training.entitis.Certificate;
import fa.training.exception.BirthDayException;
import fa.training.utils.Validator;

public class CertificateDAOImpl extends CommonDAO implements CertificateDAO {
	Validator validator = new Validator();

	@Override
	public void addCertificate(String id) {

		Scanner scanner = new Scanner(System.in);
		String check = null;
		do {
			Certificate certificate = new Certificate();
			Validator validator = new Validator();
			String dateCertstr = null;
			System.out.println("Nhap Certificate  name:");
			String nameCert = scanner.nextLine();
			System.out.println("Nhap rank Certificate");
			String rankCert = scanner.nextLine();
			try {
				do {
					try {
						System.out.println("Nhap date Certificate dd/MM/yyyy :");
						SimpleDateFormat stf = new SimpleDateFormat("dd/MM/yyyy");
						dateCertstr = scanner.next();
						if (!validator.checkBirthday(dateCertstr)) {
							throw new BirthDayException("loi validate date");
						}
					} catch (BirthDayException e) {
						System.out.println(e);
					}

				} while (!validator.checkBirthday(dateCertstr));
			} catch (BirthDayException e) {
				e.printStackTrace();
			}
			certificate.setCandidateID(id);
			certificate.setCertificateName(nameCert);
			certificate.setCertificateRank(rankCert);
			certificate.setCertificatedDate(dateCertstr);
			try {
				adddata(certificate);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.println("Nhap n de nhap tiep:");
			scanner.nextLine();
			check = scanner.nextLine();
		} while (check.equalsIgnoreCase("n"));
		

	}
	public  boolean adddata(Certificate one) {
		PreparedStatement ps = null;
		Connection con = null;
		try {
		    con = super.getConnection();
			String sql = "insert into Certificate(CandidateID,CertificateName,CertificateRank,CertificatedDate) values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setNString(1, one.getCandidateID());
			ps.setString(2, one.getCertificateName());
			ps.setNString(3, one.getCertificateRank());
			ps.setString(4, one.getCertificatedDate());
			ps.execute();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}

	}

}
