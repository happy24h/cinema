package com.fpt.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fpt.edu.entity.Movie;

public class MovieDao {
	public List<Movie> findAll() {
		List<Movie> listAll = new ArrayList<>();
		String query = "SELECT * FROM movies";
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
                String link = rs.getString("link");
                int year = rs.getInt("year");
                int idTypeMovie = rs.getInt("idTypeMovie");
                String description = rs.getString("description");
                LocalDateTime startTime = rs.getTimestamp("startTime").toLocalDateTime();
                LocalDateTime endTime = rs.getTimestamp("endTime").toLocalDateTime();
                int status = rs.getInt("status");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                Movie obj = new Movie(id,name,link,year,idTypeMovie,description,startTime,endTime,status,createdAt);
                listAll.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAll;
	}
	
	public boolean save(Movie obj) {
		String query = "INSERT INTO movies (name,link, year,idTypeMovie,description,startTime,endTime,createdAt) VALUES (?,?,?,?,?,?,?,?)";
		try {
			Connection cnn = UserDao.getConnection();
            if (cnn == null){
                return false;
            }
			PreparedStatement preparedStatement = cnn.prepareStatement(query);
			preparedStatement.setString(1, obj.getName());
			preparedStatement.setString(2, obj.getLink());
			preparedStatement.setInt(3, obj.getYear());
			preparedStatement.setInt(4, obj.getIdTypeMovie());
			preparedStatement.setString(5, obj.getDescription());
			preparedStatement.setTimestamp(6, Timestamp.valueOf(obj.getStartTime()));
			preparedStatement.setTimestamp(7, Timestamp.valueOf(obj.getEndTime()));
			preparedStatement.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
			if(preparedStatement.executeUpdate()>0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
