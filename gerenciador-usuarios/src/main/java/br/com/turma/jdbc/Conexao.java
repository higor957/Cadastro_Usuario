package br.com.turma.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection obterConexao() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbusuarios", "root", "root");
			System.out.println("BANCO DE DADOS CONECTADO COM SUCESSO!!!!");
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("NÃO FOI POSSÍVEL CONECTAR AO BANCO DE DADOS!!!");
			e.printStackTrace();
		}
		
		return con;
	}

}
