package fa.training.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fa.training.comman.DAO.CommonDAO;
import fa.training.dao.ExperienceDAO;
import fa.training.entitis.Experience;

public class ExperienceDAOImpl extends CommonDAO implements ExperienceDAO {

	@Override
	public boolean insertExperience(Experience experience) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			getConnection();
			String sql = "INSERT INTO CANDIDATE(CandidateID,FullName,BirthDay,Phone,Email,Candidate_type,ExplnYear,ProSkill,Graduation_date,Graduation_rank,Education,Majors,Semester,University_name) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
			ps.setString(1, experience.getCandidateID());
			ps.setString(2, experience.getFullName());
			//ps.setDate(3, Date.valueOf(experience.getBirthDay()));
			ps.setString(4, experience.getPhone());
			ps.setString(5, experience.getEmail());
			ps.setString(6, experience.getCandidate_type());
			ps.setInt(7, 0);
			ps.setString(8, experience.getProSkill());
			}
		} catch (Exception e) {
			System.out.println(e);// neu gap loi thi se tra ve null va in ra loi
		} finally {//
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}

		}
		return false;
	}

}
