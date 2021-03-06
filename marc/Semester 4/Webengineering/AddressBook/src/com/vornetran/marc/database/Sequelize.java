package com.vornetran.marc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sequelize {

	private Connection connection;

	static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception ex){
            ex.printStackTrace();
        }
	}

	public Sequelize(String database, String username, String password) throws Exception {
		this.connection = DriverManager.getConnection("jdbc:mysql://localhost/" + database, username, password);
	}
	
	public PreparedStatement prepare(String sql) throws SQLException {
		return this.connection.prepareStatement(sql);
	}
	
	public void close() throws SQLException {
		this.connection.close();
	}
	
}