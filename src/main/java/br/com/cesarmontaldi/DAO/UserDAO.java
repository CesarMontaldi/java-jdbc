package br.com.cesarmontaldi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.cesarmontaldi.conexaojdbc.SingleConnection;
import br.com.cesarmontaldi.model.User;

public class UserDAO {
	
	private Connection connection;
	
	public UserDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(User user) {
		try {
			String sql = "insert into users (id, nome, email) values (?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, user.getId());
			insert.setString(2, user.getNome());
			insert.setString(3, user.getEmail());
			insert.execute();
			connection.commit();// salva no banco de dados.
		
		}catch (Exception e) {
			try {
				connection.rollback();// reverte a operação caso aconteça algum erro.
			} catch (SQLException c) {
				// TODO Auto-generated catch block
				c.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
