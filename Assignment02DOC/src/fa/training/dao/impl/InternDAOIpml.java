package fa.training.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fa.training.comman.DAO.CommonDAO;
import fa.training.dao.InternDAO;
import fa.training.entitis.Intern;

public class InternDAOIpml extends CommonDAO implements InternDAO {

	@Override
	public boolean insertIntern(Intern intern) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			super.getConnection();
			String sql = "INSERT INTO Candidate(CandidateID, FullName, BirthDay, Phone, Email, Candidate_type, ExplnYear, ProSkill, Graduation_date, Graduation_rank, Education, Majors, Semeter, University_name"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			//ps = super.con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ps.setString(1, intern.getCandidateID());
				ps.setString(2, intern.getFullName());
				ps.setDate(3, (Date) intern.getBirthDay());
				ps.setString(4, intern.getPhone());
				ps.setString(5, intern.getEmail());
				ps.setString(6, intern.getCandidate_type());
				ps.setInt(7, 0);
				ps.setString(8, "");
				ps.setDate(9, null);
				ps.setString(10, "");
				ps.setString(11, "");
				ps.setString(12, intern.getMajors());
				ps.setString(13, intern.getSemester());
				ps.setString(14, intern.getUniversity_name());
			}
		} catch (Exception e) {
			System.out.println(e);// neu gap loi thi se tra ve null va in ra loi
		} finally {//
			try {
				rs.close();
				ps.close();
		//		super.closeConnection();
			} catch (Exception e2) {
				System.out.println(e2);
			}

		}
		return false;
	}

}
