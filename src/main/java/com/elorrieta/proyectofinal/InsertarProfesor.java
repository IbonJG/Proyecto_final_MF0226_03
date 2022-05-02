package com.elorrieta.proyectofinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertarProfesor {

	public static void ejecutar(Scanner sc) throws SQLException {

		// no hay resulSet porque la consulta no devuelve ningun resultado, no es una
		// SELECT
		// lo que tiene que haber es executeUpdate porque es una consulta de INSERT

		// creracion de las variables que necesitamos para recoger los datos

		String nombre;
		String apellidos;

		// preparar el scaner para recoger los datos introducidos por teclado
		//Scanner sc = new Scanner(System.in);

		try (Connection con = Conexion.getConnection();
				PreparedStatement pst = (PreparedStatement) con.prepareStatement("INSERT INTO profesor (nombre, apellidos) VALUES (?, ?)");) {

			// nombre vacio o mayor de 45 caracteres
			boolean nombreVacio = true;

			do {
				// pedir datos por teclado y guardar en variables
				System.out.println("Introduce un nombre");
				nombre = sc.nextLine().trim();

				if ("".equalsIgnoreCase(nombre) || nombre.length() > 45) {

					System.out.println("El nombre no puede estar vacio o superar 45 caracteres");
				}

				else {
					// asignar dato introducido de variable a interrogante de sql
					pst.setString(1, nombre);
					nombreVacio = false;
				}

			} while (nombreVacio);

			// apellido vacio o mayor de 150 caracteres
			boolean apellidoVacio = true;

			do {

				// pedir datos por teclado y guardar en variables
				System.out.println("Introduce los apellidos");
				apellidos = sc.nextLine().trim();

				if ("".equalsIgnoreCase(apellidos) || apellidos.length() > 150) {

					System.out.println("El nombre no puede estar vacio o superar 150 caracteres");
				}

				else {

					// asignar dato introducido de variable a interrogante de sql
					pst.setString(2, apellidos);
					apellidoVacio = false;
				}

			} while (apellidoVacio);
			
			//si los datos son correctos ejecutar la sentencia
			pst.executeUpdate();
			System.out.println("Profesor insertado\n");

		} catch (Exception e) {
			
		}
		
		//cerrar el teclado
		//sc.close();

	}

}
