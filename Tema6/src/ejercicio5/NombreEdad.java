package ejercicio5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NombreEdad {

	public static final String FICHERO = "src\\ejercicio5\\NombreEdad.txt";
	
	public static void main(String[] args) {
		
		// Creamos la variable nombre para almacenar el nombre del usuario
		String nombre;
		
		// Creamos la variable edad para almacenar la edad del usuario
		int edad;
		
		// Creamos el scanner
		Scanner reader = new Scanner(System.in);
		
		// Pedimos al usuario que introduzca su nombre
		System.out.println("Introduzca tu nombre");
		nombre = reader.nextLine();
		
		// Pedimos al usuario que introduzca su edad
		System.out.println("Introduzca su edad");
		edad = reader.nextInt();
		
		// Bw para insertar datos utilizando el append
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO, true))) {
			
			// Insertamos el nombre y la edad
			bw.write(nombre + " " + edad);
			
			// Insertamos un salto de linea
			bw.newLine();
			
			// Limpiamos el buffer del writer
			bw.flush();
			
			// Cerramos el writer
			bw.close();
		
		// Capturamos las excepciones y mostramos un mensaje de error
		} catch (IOException e) {
			System.out.println("No se ha podido modificar el archivo indicado");
		}
		
		// Cerramos el scanner
		reader.close();
		
	}

}
