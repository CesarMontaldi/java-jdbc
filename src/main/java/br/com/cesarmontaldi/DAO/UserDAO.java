package br.com.cesarmontaldi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cesarmontaldi.conexaojdbc.SingleConnection;
import br.com.cesarmontaldi.model.BeanUserFone;
import br.com.cesarmontaldi.model.Telefone;
import br.com.cesarmontaldi.model.User;

public class UserDAO {
	
	private Connection connection;
	
	public UserDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(User user) {
		try {
			String sql = "insert into users (nome, email) values (?, ?)";
			
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1, user.getNome());
			insert.setString(2, user.getEmail());
			insert.execute();
			
			connection.commit();// salva no banco de dados.
		
		}catch (Exception e) {
			try {
				connection.rollback();// reverte a operação caso aconteça algum erro.
			} catch (SQLException c) {
				c.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public List<User> listar() {
		List<User> list = new ArrayList<User>();
		
		try {
			String sql = "Select * from users";
			
			PreparedStatement select = connection.prepareStatement(sql);
			ResultSet resultSet = select.executeQuery();
			
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getLong("id"));
				user.setNome(resultSet.getString("nome"));
				user.setEmail(resultSet.getString("email"));
				
				list.add(user);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public User buscar(Long id) {
		User user = new User();
		
		try {
			String sql = "Select * from users where id = " + id;
			
			PreparedStatement select = connection.prepareStatement(sql);
			ResultSet resultSet = select.executeQuery();
			
			while (resultSet.next()) {// Retorna um ou nenhum.
				
				user.setId(resultSet.getLong("id"));
				user.setNome(resultSet.getString("nome"));
				user.setEmail(resultSet.getString("email"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public void atualizar(User user) {
		
		try {
			String sql = "update users set nome = ? where id = " + user.getId();
			PreparedStatement update = connection.prepareStatement(sql);
			
			update.setString(1, user.getNome());
			
			update.execute();
			connection.commit();
		
		} catch(Exception e) {
			try {
				connection.rollback();
			} catch (SQLException c) {
				c.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void deletar(Long id) {

		try {
			String sql = "delete from users where id = " + id;
			PreparedStatement delete = connection.prepareStatement(sql);
			
			delete.execute();
			connection.commit();
		
		} catch(Exception e) {
			try {
				connection.rollback();
			} catch (SQLException c) {
				c.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	//--------------------------TELEFONES------------------------------------
	
	public void salvarTelefone(Telefone telefone) { 
		
		try {
			String sql = "insert into telefoneuser (numero, tipo, usuariopessoa) values (?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1, telefone.getNumero());
			insert.setString(2, telefone.getTipo());
			insert.setLong(3, telefone.getUserId());
			insert.execute();

			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException c) {
				c.printStackTrace();
			}
		}
	}
	
	public List<BeanUserFone> listaUserFone (Long userId) {
		
		List<BeanUserFone> beanUserFones = new ArrayList<BeanUserFone>();
		
		try {
			String sql = "SELECT nome, numero, email from telefoneuser as fone inner join"
					+ " users as userfone on fone.usuariopessoa = userfone.id where userfone.id = " + userId;
			PreparedStatement selectJoin = connection.prepareStatement(sql);
		
			ResultSet resultSet = selectJoin.executeQuery();
			
			while (resultSet.next()) {
				
				BeanUserFone userFone = new BeanUserFone();
				userFone.setNome(resultSet.getString("nome"));
				userFone.setNumero(resultSet.getString("numero"));
				userFone.setEmail(resultSet.getString("email"));
				
				beanUserFones.add(userFone);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} 
		
		return beanUserFones;
	}

}









