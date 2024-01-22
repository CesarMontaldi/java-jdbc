package br.com.cesarmontaldi.java_jdbc;

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

}
