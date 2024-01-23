package br.com.cesarmontaldi.java_jdbc;

import java.util.List;

import org.junit.Test;

import br.com.cesarmontaldi.DAO.UserDAO;
import br.com.cesarmontaldi.model.BeanUserFone;
import br.com.cesarmontaldi.model.Telefone;
import br.com.cesarmontaldi.model.User;

public class TesteBancoJdbc {
	 
	@Test
	public void create() {
		UserDAO userDAO = new UserDAO();
		User user = new User();
		
		user.setNome("Marcos Roberto");
		user.setEmail("marcos.roberto@gmail.com");
		
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
	
	@Test
	public void atualizar() {
		try {
			UserDAO dao = new UserDAO();
		
			User userBanco = dao.buscar(5L);
			userBanco.setNome("Carlos Eduardo Da Silva");
			
			dao.atualizar(userBanco);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deletar() {
		
		try {
			UserDAO dao = new UserDAO();
			dao.deletar(6L);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//--------------------------TELEFONES------------------------------------
	
	@Test
	public void salvarTelefone() {
		
		Telefone telefone = new Telefone();
		telefone.setNumero("(19)9 8852-0023");
		telefone.setTipo("Celular");
		telefone.setUserId(1L);
		
		UserDAO dao = new UserDAO();
		dao.salvarTelefone(telefone);
	}
	
	@Test
	public void listaUserFones() {
		
		UserDAO dao = new UserDAO();
		
		List<BeanUserFone> beanUserFones = dao.listaUserFone(1L);
		
		for (BeanUserFone beanUserFone : beanUserFones) {
			
			System.out.println(beanUserFone);
			System.out.println("--------------------------------------------");
		}
	}
	
}






