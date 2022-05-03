package com.elorrieta.proyectofinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ModificarProfesor {

	public static void ejecutar(Scanner sc) {

		// declaracion de variables
		int id = 0;
		
		//abrir teclado
		//Scanner sc = new Scanner(System.in);

		// sentencia sql que necesitamos
		String sql = "UPDATE profesor SET nombre = ?, apellidos = ? WHERE id_profesor = ?;";

		// conectar con la bbdd
		try (Connection con = Conexion.getConnection(); PreparedStatement pst = con.prepareStatement(sql);

		) {

			// gestion de error si mete letras en vez de numeros
			boolean volverApedir = true;
			while (volverApedir) {
				System.out.println("Introduce la id del profesor que deseas modificar");
				try {
					id = Integer.parseInt(sc.nextLine());
					volverApedir = false;
				} catch (Exception e) {
					System.out.println("No has introducido un valor correcto, intentalo de nuevo:");
				}

				// sentencia para preguntar si la id introducida existe en la bbdd
				String sql2 = "SELECT id_profesor, nombre, apellidos FROM profesor WHERE id_profesor = ?;";
				PreparedStatement pst2 = con.prepareStatement(sql2);
				// asignar datos introducidos a los interrogantes
				pst2.setInt(1, id);
				ResultSet rs2 = pst2.executeQuery();

				if (rs2.next()) {
					// si la id existe pedimos los datos
					String nombreNuevo = "";
					String nombreViejo = rs2.getString("nombre");

					String apellidoNuevo = "";
					String apellidoViejo = rs2.getString("apellidos");

					System.out.println(
							"El nombre actual es : " + nombreViejo.toUpperCase() + " ,pulsa enter para no cambiarlo");
					System.out.println("Introduce un nuevo nombre");
					nombreNuevo = sc.nextLine();
					if ("".equalsIgnoreCase(nombreNuevo)) {
						nombreNuevo = nombreViejo;
					}

					System.out.println(
							"Los apellidos actuales son : " + apellidoViejo.toUpperCase() + " ,pulsa enter para no cambiarlo");
					System.out.println("Introduce los apellidos");
					apellidoNuevo = sc.nextLine();
					if ("".equalsIgnoreCase(apellidoNuevo)) {
						apellidoNuevo = apellidoViejo;
					}

					// asignar datos introducidos a los interrogantes
					pst.setString(1, nombreNuevo);
					pst.setString(2, apellidoNuevo);
					pst.setInt(3, id);

					//ejecutar la sentencia
					pst.executeUpdate();
					System.out.println("Profesor Actualizado");
					
					// ejecutar la select y controlar que el email no este repetido
					/*boolean emailRepetido = true;
					do {

						try {
							pst.executeUpdate();
							System.out.println("Alumno Actualizado");
							emailRepetido = false;

						} catch (Exception e) {
							System.out.println("*** Email repetido, por favor dime otro:");
							emailNuevo = sc.nextLine();
							pst.setString(2, emailNuevo);
						}

					} while (emailRepetido);
					*/
				} else {
					System.out.println("La id introducida no se encuentra en la base de datos, el profesor no existe");
					volverApedir = true;
				}
			}//end while

		} catch (Exception e) {
			System.out.println("Error Inexperado, por favor contacta con el administrador.");
			e.printStackTrace();
		}
		
		//sc.close();

	}

}
