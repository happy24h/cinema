package com.fpt.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.fpt.edu.entity.Refund;

public class RefundDao {
	public Refund findById(int idRefund) {
		Refund refund = null;
		String query = String.format("SELECT * FROM `refunds` Where id = %d",idRefund);
		try {
			Connection cnn = UserDao.getConnection();
			if (cnn == null){
                throw new SQLException("Can't open connection!");
            }
			PreparedStatement preparedStatement = cnn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()){
				int id = rs.getInt("id");
                String timeRefund = rs.getString("timeRefund");
                Double percent = rs.getDouble("percent");
                refund = new Refund(id,timeRefund,percent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return refund;
	}
}
