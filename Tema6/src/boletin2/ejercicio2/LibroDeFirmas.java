package boletin2.ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LibroDeFirmas {

	static final String file = "src\\boletin2\\ejercicio2\\firmas.txt";
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion;

		boolean res;

		do {

			menu();

			System.out.println("\nSeleccione una opción");
			opcion = reader.nextInt();
			reader.nextLine();

			switch (opcion) {
			case 1 -> {
				res = nuevaFirma();

				if (res) {
					System.out.println("La firma se ha guardado correctamente");
				} else {
					System.out.println("Ya hay una firma con el mismo nombre");
				}
			}
			case 2 -> {
				System.out.println(visualizarLibro());
			}
			case 3 -> {
				System.out.println("Fin del programa");
			}
			default -> {
				System.out.println("Introduzca una opción válida");
			}
			}

		} while (opcion != 3);

	}

	static void menu() {
		System.out.println("--- Libro de Firmas ---");
		System.out.println("1. Nueva firma");
		System.out.println("2. Visualizar libro");
		System.out.println("3. Salir");
	}

	static boolean nuevaFirma() {

		boolean res = false;

		String nombre;

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {

			System.out.println("Introduzca su nombre");
			nombre = reader.nextLine();

			if (!nombreRepetido(nombre)) {
				bw.newLine();
				bw.write(nombre);
				res = true;
			}

		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al escribir");
		}

		return res;
	}

	static boolean nombreRepetido(String nombre) {

		boolean res = false;

		String linea;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			linea = br.readLine();

			while (linea != null && !res) {

				if (linea.trim().equalsIgnoreCase(nombre.trim())) {
					res = true;
				}

				linea = br.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el archivo indicado");
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al leer");
		}

		return res;
	}

	static String visualizarLibro() {
		
		String firma;
		String libro = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			firma = br.readLine();

			while (firma != null) {
				libro += firma + "\n";
				firma = br.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el archivo indicado");
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al leer");
		}
		
		return libro;
	}
}
