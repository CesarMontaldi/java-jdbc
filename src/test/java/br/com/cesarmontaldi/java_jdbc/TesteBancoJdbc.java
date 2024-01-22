package br.com.cesarmontaldi.java_jdbc;

import java.util.List;

import org.junit.Test;

import br.com.cesarmontaldi.DAO.UserDAO;
import br.com.cesarmontaldi.model.User;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		UserDAO userDAO = new UserDAO();
		User user = new User();
		
		user.setId(5L);
		user.setNome("Carlos Silva");
		user.setEmail("carlos.silva@yahoo.com.br");
		userDAO.salvar(user);
	}
	
	@Test
	public void listar() {
		UserDAO dao = new UserDAO();
		List<User> users = dao.listar();
		
		for (User user : users) {
			System.out.println(user);
			System.out.println("-----------------------------------------------------------------------------");
		}
	}

	@Test
	public void buscar() {
		UserDAO dao = new UserDAO();
		
		User user = dao.buscar(1L);
		System.out.println(user);
	}
}
