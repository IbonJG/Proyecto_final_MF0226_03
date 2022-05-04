package com.elorrieta.proyectofinal;

import java.sql.SQLException;
import java.util.Scanner;



public class App {
	
	//abrir y declarar la introducion por teclado como publica para no abrirlo en cada una de las class porque da error, no es necesario cerrarlo
	public static Scanner sc = new Scanner(System.in);
	

	public static void main(String[] args) throws SQLException {


		// variable para recoger la opcion elegida por el ususario
		int opcion;
		boolean volverApedir = true;
		while (volverApedir) {
		
			try {
				do {
					
				// menu principal
				System.out.println("----------------------------------------------------");
				System.out.println("-----            APP GESTION CURSOS            -----");
				System.out.println("----------------------------------------------------");
				System.out.println("--- Cursos ---");
				System.out.println("----------------------------------------------------");
				System.out.println(" 1 - Listar Cursos");
				System.out.println(" 2 - Insertar Nuevo Curso");
				System.out.println(" 3 - Modificar Curso Existente");
				System.out.println(" 4 - Eliminar Curso Existente");
				System.out.println("----------------------------------------------------");
				System.out.println("--- Profesores ---");
				System.out.println("----------------------------------------------------");
				System.out.println(" 5 - Listar Profesores");
				System.out.println(" 6 - Insertar Nuevo Profesor");
				System.out.println(" 7 - Modificar Profesor Existente");
				System.out.println(" 8 - Eliminar Profesor Existente");
				System.out.println("----------------------------------------------------");
				System.out.println("--- Alumnos ---");
				System.out.println("----------------------------------------------------");
				System.out.println(" 9 -  Listar Alumnos");
				System.out.println(" 10 - Insertar Nuevo Alumno");
				System.out.println(" 11 - Modificar Alumno Existente");
				System.out.println(" 12 - Eliminar Alumno Existente");
				System.out.println("----------------------------------------------------");
				System.out.println("--- Consultas ---");
				System.out.println("----------------------------------------------------");
				System.out.println(" 13 - Todos los cursos realizados");
				System.out.println(" 14 - Detalle de un curso, junto con las reseñas");
				System.out.println(" 15 - Curso con mejor valoracion");
				System.out.println("----------------------------------------------------");
				System.out.println(" 0 - Salir");
				System.out.println("----------------------------------------------------");
				//System.out.println("---------------Elige una opcion---------------------");
				
				// recoger el valor introducido
					
				
				opcion = Integer.parseInt(sc.nextLine());
				volverApedir = false;
					switch (opcion) {
					case 0:
						System.out.println("Cerrando programa, Adios");
						break;
					case 1:
						//llama a listar cursos
						ListarCursos.ejecutar();
						break;
					case 2:
						InsertarCurso.ejecutar(sc);
						break;
					case 3:
						ModificarCurso.ejecutar(sc);
						break;
					case 4:
						EliminarCurso.ejecutar(sc);
						break;
					case 5:
						ListarProfesores.ejecutar();
						break;
					case 6:
						InsertarProfesor.ejecutar(sc);
						break;
					case 7:
						ModificarProfesor.ejecutar(sc);
						break;
					case 8:
						EliminarProfesor.ejecutar(sc);
						break;
					case 9:
						ListarAlumnos.ejecutar();
						break;
					case 10:
						InsertarAlumno.ejecutar(sc);
						break;
					case 11:
						ModificarAlumno.ejecutar(sc);
						break;
					case 12:
						EliminarAlumno.ejecutar(sc);
						break;
					case 13:
						ConsultaCursos.ejecutar();
						break;
					case 14:
						ConsultaResenias.ejecutar();
						break;
					case 15:
						ConsultaMejorValoracion.ejecutar();
						break;

					default:
						System.out.println("Opcion incorrecta, elige un numero del menu");
						break;
					}//swicth
				}//do
				 while (opcion != 0);
				
				
				} catch (Exception e) {
					System.out.println("Has introducido letras, elige una opcion correcta");
					volverApedir = true;
					
				}
			
			
		}
		
		
		/*
		 * TODO 
		 * consultas detalle de un curso: pedir que curso queremos consultar
		 * errores: introduce id o identificador de curso que no existe
		 * doble menu: cursos---- crud, profesores----crud, alumnos---crud
		 */ 
		
		}//main
	}//class





