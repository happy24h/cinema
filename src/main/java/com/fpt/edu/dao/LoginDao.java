package com.fpt.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fpt.edu.entity.Account;
import com.fpt.edu.entity.Movie;
import com.fpt.edu.entity.Ticket;

public class LoginDao {
	public Account login (String user, String password) {
		Account account= null;
		String query = String.format("SELECT * FROM accounts Where user = '%s' And password='%s'",user,password);
		try {
			Connection cnn = UserDao.getConnection();
			if (cnn == null){
                throw new SQLException("Can't open connection!");
            }
			PreparedStatement preparedStatement = cnn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()){
				String userName = rs.getString("user");
                
				account = new Account(userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
	}
}
