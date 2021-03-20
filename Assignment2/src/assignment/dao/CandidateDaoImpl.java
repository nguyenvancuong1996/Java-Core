package assignment.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import assignment.common.CandidateSQL;
import assignment.common.DBConnection;
import assignment.entities.Candidate;
import assignment.entities.Experience;
import assignment.entities.Fresher;
import assignment.entities.Inter;
import assignment.service.CandidateService;
import assignment.service.ExperienceService;
import assignment.service.FresherService;
import assignment.service.InterService;
import assignment.utils.ConvertDateToLocalDate;

public class CandidateDaoImpl implements CandidateDao {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pst;

	@Override
	public boolean addCandidate(Candidate candidate) {
		ExperienceService experienceService = new ExperienceService();
		FresherService fresherService = new FresherService();
		InterService interService = new InterService();
		conn = DBConnection.getConnectionDB();
		System.out.println(candidate.getCandidate_type());
		try {
			pst = conn.prepareStatement(CandidateSQL.ADD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (candidate.getCandidate_type() == 0) {
			Experience experience = experienceService.createrExperience(candidate);
			try {
				pst.setString(1, experience.getCadidateID());
				pst.setString(2, experience.getFullName());
				pst.setDate(3, Date.valueOf(ConvertDateToLocalDate.oldDateToLocalDate(experience.getBirthDay())));
				pst.setString(4, experience.getPhone());
				pst.setString(5, experience.getEmail());
				pst.setInt(6, experience.getCandidate_type());
				pst.setInt(7, experience.getExpInYear());
				pst.setString(8, experience.getProSkill());
				pst.setDate(9, null);
				pst.setString(10, null);
				pst.setString(11, null);
				pst.setString(12, null);
				pst.setInt(13, 0);
				pst.setString(14, null);

				if (pst.executeUpdate() > 0) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (candidate.getCandidate_type() == 1) {
			Fresher fresher = fresherService.createrFresher(candidate);
			try {
				pst.setString(1, fresher.getCadidateID());
				pst.setString(2, fresher.getFullName());
				pst.setDate(3, Date.valueOf(ConvertDateToLocalDate.oldDateToLocalDate(fresher.getBirthDay())));
				pst.setString(4, fresher.getPhone());
				pst.setString(5, fresher.getEmail());
				pst.setInt(6, fresher.getCandidate_type());
				pst.setInt(7, 0);
				pst.setString(8, null);
				pst.setDate(9, Date.valueOf(ConvertDateToLocalDate.oldDateToLocalDate(fresher.getGradutionDate())));
				pst.setString(10, fresher.getGradutionRank());
				pst.setString(11, fresher.getEducation());
				pst.setString(12, null);
				pst.setInt(13, 0);
				pst.setString(14, null);

				if (pst.executeUpdate() > 0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if (candidate.getCandidate_type() == 2) {
			Inter inter = interService.createrInter(candidate);
			try {
				pst.setString(1, inter.getCadidateID());
				pst.setString(2, inter.getFullName());
				pst.setDate(3, Date.valueOf(ConvertDateToLocalDate.oldDateToLocalDate(inter.getBirthDay())));
				pst.setString(4, inter.getPhone());
				pst.setString(5, inter.getEmail());
				pst.setInt(6, inter.getCandidate_type());
				pst.setInt(7, 0);
				pst.setString(8, null);
				pst.setDate(9, null);
				pst.setString(10, null);
				pst.setString(11, null);
				pst.setString(12, inter.getMajors());
				pst.setInt(13, inter.getSemester());
				pst.setString(14, inter.getUniversityName());

				if (pst.executeUpdate() > 0) {
					return true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					DBConnection.close(pst);
					DBConnection.close(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public List<Candidate> selectAllCandidate() {
		List<Candidate> listCandidates = new ArrayList<>();
		conn = DBConnection.getConnectionDB();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(CandidateSQL.SELECTALLCANDIDATE);
			while (rs.next()) {
				if (rs.getInt("CandidateType") == 0) {
					Experience experience = new Experience(rs.getString("CandidateID"), rs.getString("CandidateName"),
							rs.getDate("BirthDay"), rs.getString("Phone"), rs.getString("Email"),
							rs.getInt("CandidateType"), rs.getInt("ExpInYear"), rs.getString("ProSkill"));
					listCandidates.add(experience);
				}
				if (rs.getInt("CandidateType") == 1) {
					Fresher fresher = new Fresher(rs.getString("CandidateID"), rs.getString("CandidateName"),
							rs.getDate("BirthDay"), rs.getString("Phone"), rs.getString("Email"),
							rs.getInt("CandidateType"), rs.getDate("GraduationDate"), rs.getString("GraduationRank"),
							rs.getString("Education"));
					listCandidates.add(fresher);
				}
				if (rs.getInt("CandidateType") == 2) {
					Inter inter = new Inter(rs.getString("CandidateID"), rs.getString("CandidateName"),
							rs.getDate("BirthDay"), rs.getString("Phone"), rs.getString("Email"),
							rs.getInt("CandidateType"), rs.getString("Majors"), rs.getInt("Semester"),
							rs.getString("UniversityName"));
					listCandidates.add(inter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.close(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listCandidates;
	}

	@Override
	public void updateResultSet() {
		Scanner sc = new Scanner(System.in);
		conn = DBConnection.getConnectionDB();
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(CandidateSQL.SELECTALLCANDIDATE);
			System.out.println("Nhap hang can update : ");
			int updateRow = Integer.parseInt(sc.nextLine());
			rs.absolute(updateRow);
			System.out.println("Nhap ten can update :");
			String name = sc.nextLine();
			rs.updateString("CandidateName", name);
			rs.updateRow();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.close(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void insertResultSet() {
		Scanner sc = new Scanner(System.in);
		CandidateService can = new CandidateService();
		ExperienceService ex = new ExperienceService();
		FresherService fr = new FresherService();
		InterService interService = new InterService();
		Candidate candidate = null;
		conn = DBConnection.getConnectionDB();
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(CandidateSQL.SELECTALLCANDIDATE);
			rs.moveToInsertRow();
			candidate = can.createrCandidate();
			if (candidate.getCandidate_type() == 0) {
				Experience experience = ex.createrExperience(candidate);
				rs.updateString("CandidateID", experience.getCadidateID());
				rs.updateString("CandidateName", experience.getFullName());
				rs.updateDate("BirthDay",
						Date.valueOf(ConvertDateToLocalDate.oldDateToLocalDate(experience.getBirthDay())));
				rs.updateString("Email", experience.getPhone());
				rs.updateString("Email", experience.getEmail());
				rs.updateInt("CandidateType", experience.getCandidate_type());
				rs.updateInt("ExpInYear", experience.getExpInYear());
				rs.updateString("ProSkill", experience.getProSkill());
				rs.insertRow();
			}
			if (candidate.getCandidate_type() == 1) {
				Fresher fresher = fr.createrFresher(candidate);
				rs.updateString("CandidateID", fresher.getCadidateID());
				rs.updateString("CandidateName", fresher.getFullName());
				rs.updateDate("BirthDay",
						Date.valueOf(ConvertDateToLocalDate.oldDateToLocalDate(fresher.getBirthDay())));
				rs.updateString("Email", fresher.getEmail());
				rs.updateInt("CandidateType", fresher.getCandidate_type());
				rs.updateDate("GraduationDate",
						Date.valueOf(ConvertDateToLocalDate.oldDateToLocalDate(fresher.getGradutionDate())));
				rs.updateString("GraduationRank", fresher.getGradutionRank());
				rs.insertRow();
			}
			if (candidate.getCandidate_type() == 2) {
				Inter inter = interService.createrInter(candidate);
				rs.updateString("CandidateID", inter.getCadidateID());
				rs.updateString("CandidateName", inter.getFullName());
				rs.updateDate("BirthDay", Date.valueOf(ConvertDateToLocalDate.oldDateToLocalDate(inter.getBirthDay())));
				rs.updateString("Email", inter.getEmail());
				rs.updateInt("CandidateType", inter.getCandidate_type());
				rs.updateString("Majors", inter.getMajors());
				rs.updateInt("Semester", inter.getSemester());
				rs.updateString("UniversityName", inter.getUniversityName());
				rs.insertRow();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.close(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
