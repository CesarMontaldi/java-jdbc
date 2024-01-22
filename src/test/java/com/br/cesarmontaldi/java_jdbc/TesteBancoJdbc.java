package com.br.cesarmontaldi.java_jdbc;

import org.junit.Test;

import br.com.cesarmontaldi.conexaojdbc.SingleConnection;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		SingleConnection.getConnection();
	}

}
