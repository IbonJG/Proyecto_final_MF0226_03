package com.elorrieta.proyectofinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ModificarCurso {

	public static void ejecutar(Scanner sc) {

		// declaracion de variables
		int id = 0;

		// abrir scanner
		//Scanner sc = new Scanner(System.in);

		// establecer conexion
		try (Connection con = Conexion.getConnection();
				PreparedStatement pst = con.prepareStatement("UPDATE curso SET nombre = ?, horas = ? WHERE id_curso = ?;");

		) {
			
			//gestion de error si mete letras en vez de numeros
			boolean volverApedir = true;
			while (volverApedir) {
				System.out.println("Introduce la id del curso que deseas modificar");
				try {
					id = Integer.parseInt(sc.nextLine());
					volverApedir = false;
				} catch (Exception e) {
					System.out.println("No has introducido un valor correcto, intentalo de nuevo:");
				}

				//sentencia para preguntar si la id introducida existe en la bbdd
				String sql2 = "SELECT id_curso, nombre, horas FROM curso WHERE id_curso = ?;";
				PreparedStatement pst2 = con.prepareStatement(sql2);
				// asignar datos introducidos a los interrogantes
				pst2.setInt(1, id);
				ResultSet rs2 = pst2.executeQuery();
		
				if(rs2.next()){
					//si la id existe pedimos los datos
					String nombreNuevo = "";
					String nombreViejo =  rs2.getString("nombre");
					
					float horasNuevo;
					//float horasViejo =  rs2.getFLoat(horas);
				
					
					System.out.println("El nombre actual es : " + nombreViejo.toUpperCase() + " ,pulsa enter para no cambiarlo");
		            System.out.println("Introduce un nuevo nombre");
		            nombreNuevo = sc.nextLine();
		            //si mete enter sin escribir nada recoge el que ya estaba puesto
		            if ( "".equalsIgnoreCase(nombreNuevo)) {
		            	nombreNuevo = nombreViejo;
		            }
		            
		            System.out.println("Introduce las horas");
		            horasNuevo = Float.parseFloat(sc.nextLine());
	
					//System.out.println("El email actual es : " + horasViejo.toUpperCase() + " ,pulsa enter para no cambiarlo");
					//System.out.println("Introduce un email");
					//horasNuevo = Float.parseFloat(sc.nextLine());
					 //if ( "".equalsIgnoreCase(horasNuevo)) {
						 //horasNuevo = horasViejo;
			            //}
	
					// asignar datos introducidos a los interrogantes
					pst.setString(1, nombreNuevo);
					pst.setFloat(2, horasNuevo);
					pst.setInt(3, id);
					// ejecutar la select
					pst.executeUpdate();
					System.out.println("Curso Actualizado");
		
				}
		        else{
		           System.out.println("La id introducida no se encuentra en la base de datos, el curso no existe");
		           volverApedir=true;
		        }
		
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//sc.close();

	}

}
