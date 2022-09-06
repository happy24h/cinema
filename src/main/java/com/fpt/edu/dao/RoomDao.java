package com.fpt.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fpt.edu.entity.Room;


public class RoomDao {
	public List<Room> findAll() {
		List<Room> listAll = new ArrayList<>();
		String query = "SELECT * FROM rooms";
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
                int num = rs.getInt("num");
                int idTypeRoom = rs.getInt("idTypeRoom");
                int rowRoom = rs.getInt("rowRoom");
                int columnRoom = rs.getInt("columnRoom");
                int status = rs.getInt("status");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                Room obj = new Room(id,name,num,idTypeRoom,idTypeRoom,status,createdAt);
                listAll.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAll;
	}
	
	public List<Room> findAllGroupByName() {
		List<Room> listAll = new ArrayList<>();
		String query = "SELECT * FROM `rooms` GROUP BY name";
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
                int num = rs.getInt("num");
                int idCinema = rs.getInt("idCinema");
                int idTypeRoom = rs.getInt("idTypeRoom");
                int status = rs.getInt("status");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                Room obj = new Room(id,name,num,idCinema,idTypeRoom,status,createdAt);
                listAll.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAll;
	}
	
	public List<Room> findAllByName(String nameRoom) {
		List<Room> listAll = new ArrayList<>();
		String query = String.format("SELECT * FROM `rooms` GROUP BY name = '%s'",nameRoom);
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
                int num = rs.getInt("num");
                int idCinema = rs.getInt("idCinema");
                int idTypeRoom = rs.getInt("idTypeRoom");
                int status = rs.getInt("status");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                Room obj = new Room(id,name,num,idCinema,idTypeRoom,status,createdAt);
                listAll.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAll;
	}
	
	public Room findById(int idRoom) {
		Room room = null;
		String query = String.format("SELECT * FROM `rooms` Where id = %d",idRoom);
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
                int num = rs.getInt("num");
                int idCinema = rs.getInt("idCinema");
                int idTypeRoom = rs.getInt("idTypeRoom");
                int status = rs.getInt("status");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                room = new Room(id,name,num,idCinema,idTypeRoom,status,createdAt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
	}
	
	public boolean save(Room obj) {
		String query = "INSERT INTO rooms (name,num,idCinema,idTypeRoom,createdAt) VALUES (?,?,?,?,?)";
		try {
			Connection cnn = UserDao.getConnection();
            if (cnn == null){
                return false;
            }
			PreparedStatement preparedStatement = cnn.prepareStatement(query);
			preparedStatement.setString(1, obj.getName());
			preparedStatement.setInt(2, obj.getNum());
			preparedStatement.setInt(3, obj.getIdCinema());
			preparedStatement.setInt(4, obj.getIdTypeRoom());
			preparedStatement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
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
