package com.elorrieta.proyectofinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultaResenias {

	public static void ejecutar()  {
		
		try {
			// crear conexion a la bbdd
			Connection con = Conexion.getConnection();
			// declarar la consulta que queremos realizar contra la bbdd en una variable
			String sql = "select profesor.nombre as nombre_profesor, profesor.apellidos as apellidos_profesor , curso.nombre as curso, imparticiones.cod_curso as identificador, imparticiones.fecha_inicio, imparticiones.fecha_fin, curso.horas,\r\n"
					+ "	alumno.nombre as alumno_nombre, alumno.apellidos as alumno_apellidos, participantes.resenia_valoracion, participantes.resenia_descripcion\r\n"
					+ "    from curso\r\n"
					+ "    inner join imparticiones on curso.id_curso = imparticiones.id_curso\r\n"
					+ "    inner join profesor on imparticiones.id_profesor = profesor.id_profesor\r\n"
					+ "    inner join participantes on imparticiones.cod_curso = participantes.cod_curso\r\n"
					+ "    inner join alumno on participantes.id_alumno = alumno.id_alumno\r\n"
					+ "    -- where imparticiones.id_curso = 3;\r\n"
					+ "    where imparticiones.cod_curso = 'DESWEB-45'\r\n"
					+ "    ;";
			// para poder interactuar desde java con la bbdd
			PreparedStatement pst = con.prepareStatement(sql);
			// muestra el resultado de la consulta
			ResultSet rs = pst.executeQuery();

			System.out.println("----------------------------------------------------");
			System.out.println("---------------LISTADO DE CURSOS-------------------");
			System.out.println("");
			System.out.println("Profesor          Curso          Identificador   Fecha Inicio    Fecha Fin       Horas      Alumno                Valoracion Descripcion");
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

			// si encuentra datos y mientras haya un siguiente, los muestra
			while (rs.next()) {

				// guardas los datos que hay en la bbdd en variables
				String nombreprofesor = rs.getString("nombre_profesor");
				String apellidosprofesor = rs.getString("apellidos_profesor");
				String nombrecurso = rs.getString("curso");
				String identificador = rs.getString("identificador");
				java.util.Date  fechainicio = rs.getDate("fecha_inicio"); 
				java.util.Date fechafin = rs.getDate("fecha_fin");
				float horas = rs.getFloat("horas");
				String nombrealumno = rs.getString("alumno_nombre");
				String apellidosalumno = rs.getString("alumno_apellidos");
				int valoracion = rs.getInt("resenia_valoracion");
				String descripcion =rs.getString("resenia_descripcion");
				

				// mostrar los resultados que se han recogido
				System.out.printf(" %-5s %-10s %-10s %-15s %-15s %-15s %-10s %-10s %-10s %-10s %-10s \n", nombreprofesor, apellidosprofesor, nombrecurso , identificador, fechainicio, fechafin, horas, nombrealumno, apellidosalumno, valoracion, descripcion);

			}

		} catch (Exception e) {
			System.out.println("Hemos tenido un problema");
			e.printStackTrace();
		}

		
	}

}
