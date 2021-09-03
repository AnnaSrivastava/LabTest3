package com.trainee.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.trainee.model.dao.factories.JDBCConnectionFactory;

public class TraineeDaoImpl implements TraineeDao{

	private Connection conn;
	public TraineeDaoImpl() {
		conn=JDBCConnectionFactory.getConnection();
	}
	@Override
	public List<Trainee> getAllTrainees() {

		List<Trainee> trainees = new ArrayList<>();
		Trainee tempTrainee;
		try {
			String all_trainees_query = "select * from trainee";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(all_trainees_query);
			while (rs.next()) {
				tempTrainee = new Trainee(rs.getInt("trainee_id"), 
						rs.getString("trainee_name"), 
						rs.getString("branch"),
						rs.getDouble("percentage"));

				trainees.add(tempTrainee);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return trainees;
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {
		try {
			String add_trainee_query=
			"insert into trainee(trainee_id, trainee_name, branch, percentage) values(?,?,?,?)";
			PreparedStatement pstmt=conn.prepareStatement(add_trainee_query, 
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, trainee.getTraineeID());
			pstmt.setString(2, trainee.getTraineeName());
			pstmt.setString(3, trainee.getBranch());
			pstmt.setDouble(4, trainee.getPercentage());
			int noOfRowsEffected=pstmt.executeUpdate();
			
			if(noOfRowsEffected>0) {
				ResultSet rs=pstmt.getGeneratedKeys();
				rs.next();
				trainee.setTraineeID(rs.getInt(1));
			}	
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return trainee;
	}

	@Override
	public Trainee getTrainee(String username) {
		Trainee trainee = null;
		String get_trainee = "select * from trainee where trainee_name=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(get_trainee);
			pstmt.setString(1, username);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				trainee = new Trainee(rs.getInt("trainee_id"), username, rs.getString("branch"), rs.getDouble("percentage"));
			} else {
				System.out.println("NO USER FOUND");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainee;
	}


}
