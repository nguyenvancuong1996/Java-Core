package fa.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.dao.CandidateDAO;
import fa.training.entity.Candidate;
import fa.training.entity.Experience;
import fa.training.entity.Fresher;
import fa.training.entity.Intern;
import fa.training.service.impl.CandidateServiceImpl;
import fa.training.utils.Constants;
import fa.training.utils.DBUtils;

public class CandidateDAOImpl implements CandidateDAO {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private CertificateDAOImpl certificateImpl = null;

	@Override
	public List<Candidate> getAllCandidate() {
		List<Candidate> listCandidates = null;
		certificateImpl = new CertificateDAOImpl();

		try {
			listCandidates = new ArrayList<>();
			con = DBUtils.getInstance().getConnection();
			ps = con.prepareStatement(Constants.QUERY_SELECT_ALL_CANDIDATE);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt("CandidateType") == 0) {
					Experience experience = new Experience();
					experience.setCandidateID(rs.getInt("CandidateID"));
					experience.setFullName(rs.getString("CandidateName"));
					experience.setBirthDay(rs.getDate("BirthDay"));
					experience.setPhone(rs.getString("Phone"));
					experience.setEmail(rs.getString("Email"));
					experience.setCandidateType(rs.getInt("CandidateType"));
					experience.setExpInYear(rs.getInt("ExpInYear"));
					experience.setProSkill(rs.getString("ProSkill"));
					experience.setListCertificate(
							certificateImpl.getListCertificateByCandidate(experience.getCandidateID()));
					listCandidates.add(experience);

				}
				if (rs.getInt("CandidateType") == 1) {
					Fresher fresher = new Fresher();
					fresher.setCandidateID(rs.getInt("CandidateID"));
					fresher.setFullName(rs.getString("CandidateName"));
					fresher.setBirthDay(rs.getDate("BirthDay"));
					fresher.setPhone(rs.getString("Phone"));
					fresher.setEmail(rs.getString("Email"));
					fresher.setCandidateType(rs.getInt("CandidateType"));
					fresher.setGraduationDate(rs.getDate("GraduationDate"));
					fresher.setGraduationRank(rs.getString("GraduationRank"));
					fresher.setEducation(rs.getString("Education"));
					listCandidates.add(fresher);

				}
				if (rs.getInt("CandidateType") == 2) {
					Intern intern = new Intern();
					intern.setCandidateID(rs.getInt("CandidateID"));
					intern.setFullName(rs.getString("CandidateName"));
					intern.setBirthDay(rs.getDate("BirthDay"));
					intern.setPhone(rs.getString("Phone"));
					intern.setEmail(rs.getString("Email"));
					intern.setCandidateType(rs.getInt("CandidateType"));
					intern.setMajors(rs.getString("Majors"));
					intern.setSemester(rs.getString("Semester"));
					intern.setUniversityName(rs.getString("UniversityName"));
					listCandidates.add(intern);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
			
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("Loi he thong !!!");
			}
		}

		return listCandidates;
	}

	public int insert(Candidate candidate) {

		try {
			con = DBUtils.getInstance().getConnection();

			if (candidate.getCandidateType() == 0) {
				Experience experience = (Experience) candidate;
				ps = con.prepareStatement(Constants.QUERY_INSERT_CANDIDATE_EXPERIENCE,
						Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, experience.getFullName());
				ps.setDate(2, new java.sql.Date(experience.getBirthDay().getTime()));
				ps.setString(3, experience.getPhone());
				ps.setString(4, experience.getEmail());
				ps.setInt(5, experience.getCandidateType());
				ps.setInt(6, experience.getExpInYear());
				ps.setString(7, experience.getProSkill());
			}
			if (candidate.getCandidateType() == 1) {
				Fresher fresher = (Fresher) candidate;
				ps = con.prepareStatement(Constants.QUERY_INSERT_CANDIDATE_FRESHER,
						Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, fresher.getFullName());
				ps.setDate(2, new java.sql.Date(fresher.getBirthDay().getTime()));
				ps.setString(3, fresher.getPhone());
				ps.setString(4, fresher.getEmail());
				ps.setInt(5, fresher.getCandidateType());
				ps.setDate(6, new java.sql.Date(fresher.getGraduationDate().getTime()));
				ps.setString(7, fresher.getGraduationRank());
				ps.setString(8, fresher.getEducation());
			}
			if (candidate.getCandidateType() == 2) {
				Intern intern = (Intern) candidate;
				ps = con.prepareStatement(Constants.QUERY_INSERT_CANDIDATE_INTERN,
						Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, intern.getFullName());
				ps.setDate(2, new java.sql.Date(intern.getBirthDay().getTime()));
				ps.setString(3, intern.getPhone());
				ps.setString(4, intern.getEmail());
				ps.setInt(5, intern.getCandidateType());
				ps.setString(6, intern.getMajors());
				ps.setString(7, intern.getSemester());
				ps.setString(8, intern.getUniversityName());

			}
			if (ps.executeUpdate() > 0) {
				Candidate.candidateCount++;
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					return rs.getInt(1);
				}
			} else {
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Loi he thong !");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("Loi he thong !");
			}
		}
		return -1;

	}

	public void updateViaResultSet() {
		ResultSet rs = null;
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			con = DBUtils.getInstance().getConnection();

			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			rs = stmt.executeQuery(Constants.QUERY_SELECT_ALL_CANDIDATE);

			System.out.println("Input row update: ");
			int updateRowNumber = scanner.nextInt();
			scanner.nextLine();

			rs.absolute(updateRowNumber);
			System.out.println("Old name is " + rs.getString("CandidateName") + " \n Nhap ten can cap nhat :");
			String tenMoi = scanner.nextLine();
			rs.updateString("CandidateName", tenMoi);
			rs.updateRow();
			System.out.println("cap nhat thanh cong");

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Loi he thong !");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Loi he thong !!");
			}
		}
	}

	public void insertViaResultSet() {
		ResultSet rs = null;
		try {
			CandidateServiceImpl candidateServiceImpl = new CandidateServiceImpl();
			con = DBUtils.getInstance().getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			rs = stmt.executeQuery(Constants.QUERY_SELECT_ALL_CANDIDATE);
			rs.moveToInsertRow();
			Candidate candidate = candidateServiceImpl.addCandidate();

			rs.updateString("CandidateName", candidate.getFullName());
			rs.updateDate("BirthDay", new java.sql.Date(candidate.getBirthDay().getTime()));
			rs.updateString("Phone", candidate.getPhone());
			rs.updateString("Email", candidate.getEmail());
			rs.updateInt("CandidateType", candidate.getCandidateType());
			if (candidate.getCandidateType() == 0) {
				Experience experience = (Experience) candidate;
				rs.updateInt("ExpInYear", experience.getExpInYear());
				rs.updateString("ProSkill", experience.getProSkill());
			}
			if (candidate.getCandidateType() == 1) {
				Fresher fresher = (Fresher) candidate;
				rs.updateDate("GraduationDate", new java.sql.Date(fresher.getBirthDay().getTime()));
				rs.updateString("GraduationRank", fresher.getGraduationRank());
				rs.updateString("Education", fresher.getEducation());
			}
			if (candidate.getCandidateType() == 2) {
				Intern intern = (Intern) candidate;
				rs.updateString("Majors", intern.getMajors());
				rs.updateString("Semester", intern.getSemester());
				rs.updateString("UniversityName", intern.getUniversityName());
			}
			System.out.println("Them thanh cong");
			rs.insertRow();
			rs.moveToCurrentRow();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
