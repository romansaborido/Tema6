package boletin2.ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encriptador {

	static final String file = "src\\boletin2\\ejercicio4\\DatosEncriptados.txt";
	
	public static void main(String[] args) {
	
		Scanner reader = new Scanner(System.in);
		
		int opcion;
		
		String info;
		
		do {
			
			menu();
			
			System.out.println("Seleccione una opcion");
			opcion = reader.nextInt();
			reader.nextLine();
			
			switch (opcion) {
				case 1 -> {
					System.out.println("Escriba la informacion a codificar");
					info = reader.nextLine();
					
					insertarInformacion(info);
				}
				case 2 -> {
								
				}
				case 3 -> {
					
				}
				default -> {
					
				}
			}
			
		} while (opcion != 3);

		
		reader.close();
	}
	
	static void menu() {
		System.out.println("--- Ciframus ---");
		System.out.println("1. Insertar informacion");
		System.out.println("2. Visualizar contenido cifrado");
		System.out.println("3. Salir");
	}
	
	static void insertarInformacion(String info) {
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			
			bw.newLine();
			bw.write(info);
			
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al escribir");
		}
	}

}
