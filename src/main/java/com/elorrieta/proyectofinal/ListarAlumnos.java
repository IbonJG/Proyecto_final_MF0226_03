package com.elorrieta.proyectofinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ListarAlumnos {

	public static void main(String[] args) {

		// conectar con la base de datos

		try {
			// crear conexion a la bbdd
			Connection con = Conexion.getConnection();
			// declarar la consulta que queremos realizar contra la bbdd en una variable
			String sql = "SELECT id_alumno, nombre, apellidos FROM mf0226_3.alumno;";
			// para poder interactuar desde java con la bbdd
			PreparedStatement pst = con.prepareStatement(sql);
			// muestra el resultado de la consulta
			ResultSet rs = pst.executeQuery();

			System.out.println("---------------LISTADO DE ALUMNOS-------------------");
			System.out.println(" ID      Nombre           Apellidos ");

			// si encuentra datos y mientras haya un siguiente, los muestra
			while (rs.next()) {

				// guardas los datos que hay en la bbdd en variables
				int id = rs.getInt("id_alumno");
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");

				// mostrar los resultados que se han recogido

				System.out.println("ID: " + id + " " + nombre + " " + apellidos);
				System.out.println("Nombre: " + nombre);
				System.out.println("Apellidos: " + apellidos);

			}

		} catch (Exception e) {
			System.out.println("Hemos tenido un problema");
		}


	}

}
