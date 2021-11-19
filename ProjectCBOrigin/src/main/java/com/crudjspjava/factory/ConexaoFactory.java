package com.crudjspjava.factory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USUARIO = "root";
	private static final String SENHA = "123@start";
	private static final String URL = "jdbc:mysql://localhost:3306/crudjspjava?useTimezone=true&serverTimezone=UTC";
	
	public static Connection conectar() throws SQLException { 
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
	
	public static void main(String[] args) {
		try {
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conexão realizada com sucesso!");
			conexao.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Não foi possível realizar a conexão.");
		}
		
	}
	
	
	
}
