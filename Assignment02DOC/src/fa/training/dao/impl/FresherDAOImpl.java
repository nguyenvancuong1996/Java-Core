package fa.training.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fa.training.comman.DAO.CommonDAO;
import fa.training.dao.FresherDAO;
import fa.training.entitis.Fresher;

public class FresherDAOImpl extends CommonDAO implements FresherDAO {

	@Override
	public boolean insertFresher(Fresher fresher) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			super.getConnection();
			String sql = "INSERT INTO Candidate(CandidateID, FullName, BirthDay, Phone, Email, Candidate_type, ExplnYear, ProSkill, Graduation_date, Graduation_rank, Education, Majors, Semeter, University_name"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			//ps = super.con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ps.setString(1, fresher.getCandidateID());
				ps.setString(2, fresher.getFullName());
				//ps.setDate(3, Date.valueOf(fresher.getBirthDay()));
				ps.setString(4, fresher.getPhone());
				ps.setString(5, fresher.getEmail());
				ps.setString(6, fresher.getCandidate_type());
				ps.setInt(7, 0);
				ps.setString(8, "");
				ps.setDate(9, (Date) fresher.getGraduation_date());
				ps.setString(10, fresher.getGraduation_rank());
				ps.setString(11, fresher.getEducation());
			}
		} catch (Exception e) {
			System.out.println(e);// neu gap loi thi se tra ve null va in ra loi
		} finally {//
			try {
				rs.close();
				ps.close();
			//	super.closeConnection();
			} catch (Exception e2) {
				System.out.println(e2);
			}

		}
		return false;
	}
}
