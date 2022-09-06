package com.fpt.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fpt.edu.entity.TypeRoom;

public class TypeRoomDao {
	public List<TypeRoom> findAll() {
		List<TypeRoom> listAll = new ArrayList<>();
		String query = "SELECT * FROM type_rooms";
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
                TypeRoom obj = new TypeRoom(id,name);
                listAll.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAll;
	}
}
