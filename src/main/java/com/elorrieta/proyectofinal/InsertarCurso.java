package com.elorrieta.proyectofinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertarCurso {

	public static void ejecutar(Scanner sc) {

		// no hay resulSet porque la consulta no devuelve ningun resultado, no es una
		// SELECT
		// lo que tiene que haber es executeUpdate porque es una consulta de INSERT

		// creracion de las variables que necesitamos para recoger los datos
		String nombre;
		float horas;
		// preparar el scaner para recoger los datos introducidos por teclado
	

		// establecer conexion con la base de datos y proponer la sentencia sql
		try (			
				Connection con = Conexion.getConnection();
				PreparedStatement pst = con.prepareStatement("INSERT INTO curso (nombre, horas) VALUES (?, ?)");
			) {

			// pedir nombre y nombre vacio
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

			// pedir horas y horas vacias o formato
			boolean horasVacias = true;
			
			do {
				
				try {
					System.out.println("Introduce las horas");
					horas = Float.parseFloat(sc.nextLine());
					// asignar dato introducido de variable a interrogante de sql
					pst.setFloat(2, horas);
					horasVacias=false;
				} catch (Exception e) {
					System.out.println("La horas no pueden estar vacias, ni contener caracteres");
				}
					
			} while (horasVacias);
			
			// ejecutar la sentencia
			pst.executeUpdate();
			System.out.println("Curso insertado\n");
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		// cerrar el teclado
		//sc.close();

	}

}
