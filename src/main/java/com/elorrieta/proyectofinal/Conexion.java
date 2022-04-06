package com.elorrieta.proyectofinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	/**
	 * Obtenemos la conexion a la bbdd
	 * @param 
	 */
	
	public static Connection getConnection(){
		
		Connection con = null;
		
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mf0226_3?useSSL=false", "root", "root");
			
		} catch (SQLException e) {
			System.out.println("Error de conexion con la base de datos");
			e.printStackTrace();//para ver las trazas (lineas rojas) del fallo
		}
		
		
		
		return con;
		

	}

}
