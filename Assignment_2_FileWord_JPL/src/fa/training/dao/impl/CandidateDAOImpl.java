package fa.training.dao.impl;

//import java.sql.CallableStatement;
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
	private Connection connection = null;
//	private CallableStatement caStatement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;
	private CertificateDAOImpl certificateDaoImpl = null;

	@Override
	public List<Candidate> getAllCandidate() {
		List<Candidate> listCandidates = null;
		// Candidate candidate = null;
		certificateDaoImpl = new CertificateDAOImpl();

		try {
			listCandidates = new ArrayList<>();
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(Constants.QUERY_SELECT_ALL_CANDIDATE);
			results = preparedStatement.executeQuery();
			while (results.next()) {
				if (results.getInt("CandidateType") == 0) {
					Experience experience = new Experience();
					experience.setCandidateID(results.getInt("CandidateID"));
					experience.setFullName(results.getString("CandidateName"));
					experience.setBirthDay(results.getDate("BirthDay"));
					experience.setPhone(results.getString("Phone"));
					experience.setEmail(results.getString("Email"));
					experience.setCandidateType(results.getInt("CandidateType"));
					experience.setExpInYear(results.getInt("ExpInYear"));
					experience.setProSkill(results.getString("ProSkill"));
					experience.setListCertificate(
							certificateDaoImpl.getListCertificateByCandidate(experience.getCandidateID()));
					listCandidates.add(experience);

				}
				if (results.getInt("CandidateType") == 1) {
					Fresher fresher = new Fresher();
					fresher.setCandidateID(results.getInt("CandidateID"));
					fresher.setFullName(results.getString("CandidateName"));
					fresher.setBirthDay(results.getDate("BirthDay"));
					fresher.setPhone(results.getString("Phone"));
					fresher.setEmail(results.getString("Email"));
					fresher.setCandidateType(results.getInt("CandidateType"));
					fresher.setGraduationDate(results.getDate("GraduationDate"));
					fresher.setGraduationRank(results.getString("GraduationRank"));
					fresher.setEducation(results.getString("Education"));
					listCandidates.add(fresher);

				}
				if (results.getInt("CandidateType") == 2) {
					Intern intern = new Intern();
					intern.setCandidateID(results.getInt("CandidateID"));
					intern.setFullName(results.getString("CandidateName"));
					intern.setBirthDay(results.getDate("BirthDay"));
					intern.setPhone(results.getString("Phone"));
					intern.setEmail(results.getString("Email"));
					intern.setCandidateType(results.getInt("CandidateType"));
					intern.setMajors(results.getString("Majors"));
					intern.setSemester(results.getString("Semester"));
					intern.setUniversityName(results.getString("UniversityName"));
					listCandidates.add(intern);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
			
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (results != null) {
					results.close();
				}
			} catch (SQLException e) {
				System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!");
			}
		}

		return listCandidates;
	}

	public int insert(Candidate candidate) {

		try {
			connection = DBUtils.getInstance().getConnection();

			if (candidate.getCandidateType() == 0) {
				Experience experience = (Experience) candidate;
				preparedStatement = connection.prepareStatement(Constants.QUERY_INSERT_CANDIDATE_EXPERIENCE,
						Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, experience.getFullName());
				preparedStatement.setDate(2, new java.sql.Date(experience.getBirthDay().getTime()));
				preparedStatement.setString(3, experience.getPhone());
				preparedStatement.setString(4, experience.getEmail());
				preparedStatement.setInt(5, experience.getCandidateType());
				preparedStatement.setInt(6, experience.getExpInYear());
				preparedStatement.setString(7, experience.getProSkill());
			}
			if (candidate.getCandidateType() == 1) {
				Fresher fresher = (Fresher) candidate;
				preparedStatement = connection.prepareStatement(Constants.QUERY_INSERT_CANDIDATE_FRESHER,
						Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, fresher.getFullName());
				preparedStatement.setDate(2, new java.sql.Date(fresher.getBirthDay().getTime()));
				preparedStatement.setString(3, fresher.getPhone());
				preparedStatement.setString(4, fresher.getEmail());
				preparedStatement.setInt(5, fresher.getCandidateType());
				preparedStatement.setDate(6, new java.sql.Date(fresher.getGraduationDate().getTime()));
				preparedStatement.setString(7, fresher.getGraduationRank());
				preparedStatement.setString(8, fresher.getEducation());
			}
			if (candidate.getCandidateType() == 2) {
				Intern intern = (Intern) candidate;
				preparedStatement = connection.prepareStatement(Constants.QUERY_INSERT_CANDIDATE_INTERN,
						Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, intern.getFullName());
				preparedStatement.setDate(2, new java.sql.Date(intern.getBirthDay().getTime()));
				preparedStatement.setString(3, intern.getPhone());
				preparedStatement.setString(4, intern.getEmail());
				preparedStatement.setInt(5, intern.getCandidateType());
				preparedStatement.setString(6, intern.getMajors());
				preparedStatement.setString(7, intern.getSemester());
				preparedStatement.setString(8, intern.getUniversityName());

			}
			if (preparedStatement.executeUpdate() > 0) {
				Candidate.candidateCount++;
				ResultSet rs = preparedStatement.getGeneratedKeys();
				if (rs.next()) {
					return rs.getInt(1);
				}
			} else {
				return -1;
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
				if (results != null) {
					results.close();
				}
			} catch (SQLException e) {
//				e.printStackTrace();
				System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!");
			}
		}
		return -1;

	}

	public void updateViaResultSet() {
		ResultSet rs = null;
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			connection = DBUtils.getInstance().getConnection();
//			System.out.println("Creating statement...");
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//			String sql = "SELECT CandidateName,Phone FROM Candidate";
			rs = stmt.executeQuery(Constants.QUERY_SELECT_ALL_CANDIDATE);
//			System.out.println("List result set for reference....");
			System.out.println("Enter row you want to update: ");
			int updateRowNumber = scanner.nextInt();
			scanner.nextLine();
			// printRs(rs);
			rs.absolute(updateRowNumber);
			System.out.println("Old name is " + rs.getString("CandidateName") + " \n Enter name to update");
			String newName = scanner.nextLine();
			rs.updateString("CandidateName", newName);
			rs.updateRow();
			System.out.println("complete update resultset");

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("The system has encountered an unexpected problem, sincerely sorry !!!");
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
				System.err.println("The system has encountered an unexpected problem, sincerely sorry !!!");
			}
		}
	}

	public void insertViaResultSet() {
		ResultSet rs = null;
		try {
			CandidateServiceImpl candidateServiceImpl = new CandidateServiceImpl();
			connection = DBUtils.getInstance().getConnection();
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

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
			System.out.println("complete insert by resultset");
			rs.insertRow();
			rs.moveToCurrentRow();

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

//	public void printRs(ResultSet rs) {
//		try {
//			rs.beforeFirst();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			while (rs.next()) {
//				// Retrieve by column name
//				int id = rs.getInt("id");
//				int age = rs.getInt("age");
//				String first = rs.getString("first");
//				String last = rs.getString("last");
//
//				// Display values
//				System.out.print("ID: " + id);
//				System.out.print(", Age: " + age);
//				System.out.print(", First: " + first);
//				System.out.println(", Last: " + last);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println();
//	}
}
