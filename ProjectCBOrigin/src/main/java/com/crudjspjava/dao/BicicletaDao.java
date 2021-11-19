package com.crudjspjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crudjspjava.factory.ConexaoFactory;

import com.crudjspjava.bean.Bicicleta;

//import br.com.CheckBike.factory.ConexaoFactory;


//import com.mysql.jdbc.PreparedStatement;

public class BicicletaDao {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USUARIO = "root";
	private static final String SENHA = "123@start";
	private static final String URL = "jdbc:mysql://localhost:3306/crudjsfjava?useTimezone=true&serverTimezone=UTC";
	
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
	
	
	
//	public static Connection getConnection() {
//		Connection con = null;
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdcb:mysql://localhost:3306/crudjspjava", "root", "123@start");
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//
//		return con;
//	}

	public static List<Bicicleta> getAllBicicletas(){
		
		List<Bicicleta> list = new ArrayList<Bicicleta>();
		
		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM bicicletas");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Bicicleta bicicleta = new Bicicleta();
				bicicleta.setId(rs.getInt("id"));
				bicicleta.setDescricao(rs.getString("descricao"));
				bicicleta.setModelo(rs.getString("modelo"));
				list.add(bicicleta);
			}
			
		} catch(Exception e){
			System.out.println(e);
		}
		
		return list;
	}
}