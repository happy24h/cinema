package com.fpt.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fpt.edu.entity.ShowTime;
import com.fpt.edu.entity.Ticket;

public class ShowTimeDao {
	public List<ShowTime> findAll() {
		List<ShowTime> listAll = new ArrayList<>();
		String query = "SELECT * FROM showtimes";
		try {
			Connection cnn = UserDao.getConnection();
			if (cnn == null){
                throw new SQLException("Can't open connection!");
            }
			PreparedStatement preparedStatement = cnn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Time start_time = rs.getTime("start_time");
                Time end_time = rs.getTime("end_time");
                double price = rs.getDouble("price");
                ShowTime obj = new ShowTime(id,name,start_time,end_time,price);
                listAll.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAll;
	}
	
	public ShowTime findById(int idShowTime) {
		ShowTime showTime = null;
		String query = String.format("SELECT * FROM `showtimes` Where id = %d",idShowTime);
		try {
			Connection cnn = UserDao.getConnection();
			if (cnn == null){
                throw new SQLException("Can't open connection!");
            }
			PreparedStatement preparedStatement = cnn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()){
				int id = rs.getInt("id");
                String name = rs.getString("name");
                Time start_time = rs.getTime("start_time");
                Time end_time = rs.getTime("end_time");
                double price = rs.getDouble("price");
                showTime = new ShowTime(id,name,start_time,end_time,price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showTime;
	}
}
