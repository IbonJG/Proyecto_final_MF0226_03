package com.elorrieta.proyectofinal;

import java.sql.SQLException;
import java.util.Scanner;



public class App {
	
	//abrir y declarar la introducion por teclado como publica para no abrirlo en cada una de las class porque da error, no es necesario cerrarlo
	public static Scanner sc = new Scanner(System.in);
	

	public static void main(String[] args) throws SQLException {


		// variable para recoger la opcion elegida por el ususario
		int opcion;

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
		System.out.println(" 9 - Listar Alumnos");
		System.out.println(" 10 - Insertar Nuevo Alumno");
		System.out.println(" 11 - Modificar Alumno Existente");
		System.out.println(" 12- Eliminar Alumno Existente");
		System.out.println("----------------------------------------------------");
		System.out.println("--- Consultas ---");
		System.out.println("----------------------------------------------------");
		System.out.println(" 13- Todos los cursos realizados");
		System.out.println(" 14- Detalle de un curso, junto con las reseñas");
		System.out.println("----------------------------------------------------");
		System.out.println(" 0 - Salir");
		System.out.println("----------------------------------------------------");

		// recoger el valor introducido
		opcion = Integer.parseInt(sc.next());

			switch (opcion) {
			case 0:
				System.out.println("Cerrando programa, Adios");
				break;
			case 1:
				//llama a listar cursos
				new ListarCursos().listarcurso();
				break;
			case 2:
				new InsertarCurso().insertarcurso(sc);
				break;
			case 3:
				new ModificarCurso().modificarcurso(sc);
				break;
			case 4:
				new EliminarCurso().eliminarcurso(sc);
				break;
			case 5:
				new ListarProfesores().listarprofesor();
				break;
			case 6:
				new InsertarProfesor().insertarprofesor(sc);
				break;
			case 7:
				new ModificarProfesor().modificarprofesor(sc);
				break;
			case 8:
				new EliminarProfesor().eliminarprofesor(sc);
				break;
			case 9:
				new ListarAlumnos().listaralumno();
				break;
			case 10:
				new InsertarAlumno().insertaralumno(sc);
				break;
			case 11:
				new ModificarAlumno().modificaralumno(sc);
				break;
			case 12:
				new EliminarAlumno().eliminaralumno(sc);
				break;
			case 13:
				new ConsultaCursos().consultacursos();
				break;
			case 14:
				new ConsultaResenias().consultaresenias();
				break;

			default:
				System.out.println("Opcion incorrecta, vuelva a seleccionar numero");
				break;
			}

		} while (opcion != 0);
		
		//TODO mensaje insertar alumno, eliminar alumno (sale la excepcion de que introduce letras en vez de numeros)
		//mensajes en modificar 
		//horas curso vieja en modificar (getfloat)
		//mas consultas
		
	}

}
