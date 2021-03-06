package com.elorrieta.proyectofinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultaMejorValoracion {

	public static void ejecutar() {
		
		try {
			
			// crear conexion a la bbdd
			Connection con = Conexion.getConnection();
			// declarar la consulta que queremos realizar contra la bbdd en una variable
			String sql = ("select curso.nombre as curso, imparticiones.cod_curso, format(avg(participantes.resenia_valoracion),2) as media_valoracion from curso\r\n"
					+ "inner join imparticiones on curso.id_curso = imparticiones.id_curso\r\n"
					+ "inner join participantes on imparticiones.cod_curso = participantes.cod_curso\r\n"
					+ "group by cod_curso\r\n"
					+ "order by media_valoracion desc;");
			
			// para poder interactuar desde java con la bbdd
			PreparedStatement pst = con.prepareStatement(sql);
			// muestra el resultado de la consulta
			ResultSet rs = pst.executeQuery();
			
			System.out.println("----------------------------------------------------");
			System.out.println("---------------LISTADO DE CURSOS-------------------");
			System.out.println("");
			System.out.println(" Curso                Identificador        Media Valoracion");
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
			
			// si encuentra datos y mientras haya un siguiente, los muestra
			while (rs.next()) {
			
				// guardas los datos que hay en la bbdd en variables
				String nombrecurso = rs.getString("curso");
				String codigocurso = rs.getString("imparticiones.cod_curso");
				int valoracion = rs.getInt("media_valoracion");
				
				// mostrar los resultados que se han recogido
				System.out.printf(" %-20s %-20s %-10s \n" , nombrecurso, codigocurso, valoracion);
				
				
				
			}
			
			
		} catch (Exception e) {
			System.out.println("Hemos tenido un problema");
			e.printStackTrace();
		}

	}

}
