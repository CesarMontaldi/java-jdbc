package br.com.cesarmontaldi.DAO;

import java.sql.Connection;

import br.com.cesarmontaldi.conexaojdbc.SingleConnection;

public class UserDAO {
	
	private Connection connection;
	
	public UserDAO() {
		connection = SingleConnection.getConnection();
	}

}
