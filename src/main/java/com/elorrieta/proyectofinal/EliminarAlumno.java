package com.elorrieta.proyectofinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EliminarAlumno {

	public void eliminaralumno(Scanner sc) {

		// declaracon variable para recoger la id a eliminar
		int id = 0;

		// abrir el scanner
		//Scanner sc = new Scanner(System.in);

		// declarar la sentencia que queremos
		String sql = ("DELETE FROM alumno WHERE id_alumno = ?;");

		// conectar con la bbdd y preparar la sentencia
		try (Connection con = Conexion.getConnection(); PreparedStatement pst = con.prepareStatement(sql);)

		{

			// si mete letras en vez de numeros
			boolean volverApedir = true;
			while (volverApedir) {

				System.out.println("Introduce la id del alumno que deseas eliminar");
				try {
					id = Integer.parseInt(sc.nextLine());
					volverApedir = false;
				}

				catch (Exception e) {
					System.out.println("Debes introducir una id de un alumno existente, intentalo de nuevo");
					volverApedir = true;
				}

			} // while

			// Buscar id introducida y comprobar que existe ne la bbdd
			String sql2 = "SELECT id_alumno, nombre, apellidos FROM alumno WHERE id_alumno = ?;";
			PreparedStatement pst2 = con.prepareStatement(sql2);
			// asignar valor introducido a interrogante y ejecutar la query
			pst2.setInt(1, id);
			ResultSet rs2 = pst2.executeQuery();

			// si ha encontrado datos
			if (rs2.next()) {
				// se asigna el valor intrucido a la primera sentencia y se ejecuta
				pst.setInt(1, id);
				pst.executeUpdate();
				// mostrar datos del profesor que se va a eliminar
				String nombre = rs2.getString("nombre");
				String apellidos = rs2.getString("apellidos");
				System.out.println("Alumno " + nombre + " " + apellidos + " eliminado correctamente\n");
				// si no a encontrado ningun dato con esa id
			} else {
				System.out.println("No exite ningun alumno registrado con la id " + id + ", volvemos al menu\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		//sc.close();

	}// void

}// class
