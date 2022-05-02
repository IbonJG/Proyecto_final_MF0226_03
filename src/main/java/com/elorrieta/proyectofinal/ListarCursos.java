package com.elorrieta.proyectofinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ListarCursos {

	public void listarcurso() {
		
		try {
			// crear conexion a la bbdd
			Connection con = Conexion.getConnection();
			// declarar la consulta que queremos realizar contra la bbdd en una variable
			String sql = "SELECT id_curso, nombre, horas FROM curso;";
			// para poder interactuar desde java con la bbdd
			PreparedStatement pst = con.prepareStatement(sql);
			// muestra el resultado de la consulta
			ResultSet rs = pst.executeQuery();

			System.out.println("----------------------------------------------------");
			System.out.println("---------------LISTADO DE CURSOS-------------------");
			System.out.println("");
			System.out.println(" ID    Nombre                 Horas");
			System.out.println("----------------------------------------------------");

			// si encuentra datos y mientras haya un siguiente, los muestra
			while (rs.next()) {

				// guardas los datos que hay en la bbdd en variables
				int id = rs.getInt("id_curso");
				String nombre = rs.getString("nombre");
				int horas = rs.getInt("horas");

				// mostrar los resultados que se han recogido
				System.out.printf(" %-5s %-20s %5s \n", id, nombre ,horas);

			}

		} catch (Exception e) {
			System.out.println("Hemos tenido un problema");
		}

	}

}
