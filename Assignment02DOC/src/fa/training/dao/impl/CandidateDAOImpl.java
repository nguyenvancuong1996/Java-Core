package fa.training.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fa.training.comman.DAO.CommonDAO;
import fa.training.dao.CandidateDAO;
import fa.training.entitis.Candidate;
import fa.training.entitis.Experience;
import fa.training.entitis.Fresher;
import fa.training.entitis.Intern;
import fa.training.service.CandidateService;
import fa.training.utils.Constants;
import fa.training.utils.DatetoLocalday;

public class CandidateDAOImpl extends CommonDAO implements CandidateDAO {

	@Override
	public boolean Candidateinsert(Candidate candidate) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO CANDIDATE(CandidateID,FullName,BirthDay,Phone,Email,Candidate_type,ExpInYear,ProSkill,Graduation_date,Graduation_rank,Education,Majors,Semester,University_name) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			con = new CommonDAO().getConnection();
			ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, candidate.getCandidateID());
			ps.setString(2, candidate.getFullName());
			ps.setDate(3, Date.valueOf(DatetoLocalday.oldDateToLocalDate(candidate.getBirthDay())));
			ps.setString(4, candidate.getPhone());
			ps.setString(5, candidate.getEmail());
			ps.setString(6, candidate.getCandidate_type());
			System.out.println(candidate.getCandidate_type());
			if (candidate.getCandidate_type().equals("0")) {
				Experience experience = (Experience) candidate;
				experience.ShowInfo();
				ps.setInt(7, experience.getExpInYear());
				ps.setString(8, experience.getProSkill());
				ps.setString(9, null);
				ps.setString(10, null);
				ps.setString(11, null);
				ps.setString(12, null);
				ps.setString(13, null);
				ps.setString(14, null);
			}
			if (candidate.getCandidate_type().equals("1")) {
				Fresher fresher = (Fresher) candidate;
				ps.setString(7, null);
				ps.setString(8, null);
				ps.setDate(9, Date.valueOf(DatetoLocalday.oldDateToLocalDate(fresher.getGraduation_date())));
				ps.setString(10, fresher.getGraduation_rank());
				ps.setString(11, fresher.getEducation());
				ps.setString(12, null);
				ps.setString(13, null);
				ps.setString(14, null);
			}
			if (candidate.getCandidate_type().equals("2")) {
				Intern intern = (Intern) candidate;
				ps.setString(7, null);
				ps.setString(8, null);
				ps.setString(9, null);
				ps.setString(10, null);
				ps.setString(11, null);
				ps.setString(12, intern.getMajors());
				ps.setString(13, intern.getSemester());
				ps.setString(14, intern.getUniversity_name());
			}
			System.out.println(ps.executeUpdate());
			System.out.println("THEM THANH CONG");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				super.getConnection();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return false;
	}

	public List<Candidate> getAllCandidate() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		List<Candidate> list = new ArrayList<Candidate>();
		String sql = "select * from CANDIDATE";
		try {
			con=new CommonDAO().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString("Candidate_type").equals("0")) {
//					System.out.println("Test");
					Experience experience = new Experience(rs.getString("CandidateID"), 
							rs.getString("FullName"),
							rs.getDate("BirthDay"),
							rs.getString("Phone"),
							rs.getString("Email"),
							rs.getString("Candidate_type"), 
							rs.getInt("ExpInYear"),
							rs.getString("ProSkill"));
					list.add(experience);
				}
				if (rs.getString("Candidate_type").equals("1")) {
					System.out.println("test");
					Fresher fresher = new Fresher(rs.getString("CandidateID"), rs.getString("FullName"),
							rs.getDate("BirthDay"), rs.getString("Phone"), rs.getString("Email"),
							rs.getString("Candidate_type"), rs.getDate("Graduation_date"),
							rs.getString("Graduation_rank"), rs.getString("Education"));
					list.add(fresher);

				}
				if (rs.getString("Candidate_type").equals("2")) {
					Intern intern = new Intern(rs.getString("CandidateID"), rs.getString("FullName"),
							rs.getDate("BirthDay"), rs.getString("Phone"), rs.getString("Email"),
							rs.getString("Candidate_type"), rs.getString("Majors"), rs.getString("Semester"),
							rs.getString("University_name"));
					list.add(intern);

				}

			}
		} catch (Exception e) {
			System.out.println("Loi");
			e.printStackTrace();
		}
		return list;
	}



	@Override
	public boolean update(String name, int row) {
		Connection con = super.getConnection();
		   PreparedStatement ps = null;
		   ResultSet rs = null;
		   try {
			String sql ="select * from Candidate";
			 ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			 rs = ps.executeQuery();
			 rs.absolute(row);
			 rs.updateString("FullName",name);
			 rs.updateRow();
			 System.out.println("thanh cong");
			 return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (Exception e2) {
				System.err.println(e2);
			}
		}
		
	}

	@Override
	public void addCertificate() {
		// TODO Auto-generated method stub
		
	}
	public void insertViaResultSet() {
		ResultSet rs = null;
		Connection connection = null;
		try {
			CandidateService candidateServiceImpl = new CandidateService();
			connection = new CommonDAO().getConnection();
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			rs = stmt.executeQuery(Constants.QUERY_SELECT_ALL_CANDIDATE);
			rs.moveToInsertRow();
			List<Candidate> listCandidate = candidateServiceImpl.inputCandidate();
			for(Candidate candidate:listCandidate) {
				rs.updateString("CandidateID", candidate.getCandidateID());
				rs.updateString("FullName", candidate.getFullName());
				rs.updateDate("BirthDay", new java.sql.Date(candidate.getBirthDay().getTime()));
				rs.updateString("Phone", candidate.getPhone());
				rs.updateString("Email", candidate.getEmail());
				rs.updateString("Candidate_type", candidate.getCandidate_type());
				if (candidate.getCandidate_type().equals("0")) {
					Experience experience = (Experience) candidate;
					rs.updateInt("ExpInYear", experience.getExpInYear());
					rs.updateString("ProSkill", experience.getProSkill());
				}
				if (candidate.getCandidate_type().equals("1")) {
					Fresher fresher = (Fresher) candidate;
					rs.updateDate("Graduation_date", new java.sql.Date(fresher.getBirthDay().getTime()));
					rs.updateString("Graduation_rank", fresher.getGraduation_rank());
					rs.updateString("Education", fresher.getEducation());
				}
				if (candidate.getCandidate_type().equals("2")) {
					Intern intern = (Intern) candidate;
					rs.updateString("Majors", intern.getMajors());
					rs.updateString("Semester", intern.getSemester());
					rs.updateString("University_name", intern.getUniversity_name());
				}
				System.out.println("complete insert by resultset");
				rs.insertRow();
				rs.moveToCurrentRow();
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
