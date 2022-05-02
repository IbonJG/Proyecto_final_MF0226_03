package com.elorrieta.proyectofinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultaCursos {

	public void consultacursos() {
		
		try {
			// crear conexion a la bbdd
			Connection con = Conexion.getConnection();
			// declarar la consulta que queremos realizar contra la bbdd en una variable
			String sql = "select imparticiones.fecha_inicio, curso.nombre as curso, imparticiones.cod_curso as identificador, curso.horas, profesor.nombre as nombre_profesor, profesor.apellidos as apellido_profesor from curso\r\n"
					+ "inner join imparticiones on curso.id_curso = imparticiones.id_curso\r\n"
					+ "inner join profesor on imparticiones.id_profesor = profesor.id_profesor\r\n"
					+ "order by imparticiones.fecha_inicio desc;";
			// para poder interactuar desde java con la bbdd
			PreparedStatement pst = con.prepareStatement(sql);
			// muestra el resultado de la consulta
			ResultSet rs = pst.executeQuery();

			System.out.println("----------------------------------------------------");
			System.out.println("---------------LISTADO DE CURSOS-------------------");
			System.out.println("");
			System.out.println(" Fecha Inicio    Curso                Identificador   Horas      Nombre Profesor      Apellidos Profesor   ");
			System.out.println("-----------------------------------------------------------------------------------------------------------");

			// si encuentra datos y mientras haya un siguiente, los muestra
			while (rs.next()) {

				// guardas los datos que hay en la bbdd en variables
				java.util.Date  fecha = rs.getDate("fecha_inicio"); 
				String nombre = rs.getString("curso");
				String identificador = rs.getString("identificador");
				float horas = rs.getFloat("horas");
				String nombreprofesor = rs.getString("nombre_profesor");
				String apellidosprofesor = rs.getString("apellido_profesor");

				// mostrar los resultados que se han recogido
				System.out.printf(" %-15s %-20s %-15s %-10s %-20s %-20s \n", fecha, nombre ,identificador, horas, nombreprofesor, apellidosprofesor);

			}

		} catch (Exception e) {
			System.out.println("Hemos tenido un problema");
			e.printStackTrace();
		}


	}

}
