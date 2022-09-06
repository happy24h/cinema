package com.fpt.edu.dao;

import java.sql.*;

public class UserDao {
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cinemadatabase?useUnicode=true&characterEncoding=utf-8";
    private static final String DATABASE_NAME = "cinemadatabase";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PWD = "";
    private static Connection cnn;

    public static Connection getConnection() throws SQLException {
        if (cnn == null || cnn.isClosed()){
        	String dbClass = "com.mysql.cj.jdbc.Driver";
        	try {
				Class.forName(dbClass);
				cnn = DriverManager.getConnection(
						DATABASE_URL,
	                    DATABASE_USER,
	                    DATABASE_PWD);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        return cnn;
    }
}
