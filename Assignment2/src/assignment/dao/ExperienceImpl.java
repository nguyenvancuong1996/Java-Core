package assignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import assignment.common.DBConnection;
import assignment.common.CandidateSQL;
import assignment.entities.Experience;

public class ExperienceImpl implements ExperienceDao {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pst;

	@Override
	public boolean add(Experience experience) {
		
		return false;
	}

}
