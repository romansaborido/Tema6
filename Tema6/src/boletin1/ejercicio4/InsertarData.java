package boletin1.ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InsertarData {

	public static void main(String[] args) {
		
		// Creamos la variable lineaW para almacenar la linea a escribir del usuario
		String lineaW;
		
		// Creamos el scanner
		Scanner reader = new Scanner(System.in);
		
		// Creamos el bw para insertar datos en el fichero
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\ejercicio4\\Data.txt"))) {
			
			// Pedimos al usuario que introduzca la linea a escribir
			System.out.println("Introduzca la linea que quieres escribir en el fichero");
			lineaW = reader.nextLine();
			
			// Mientras que no introduzca fin
			while (!lineaW.equalsIgnoreCase("fin")) {
				
				// Escribimos la linea en el fichero
				bw.write(lineaW);
				
				// Insertamos un salto de linea
				bw.newLine();
				
				// Limpiamos el buffer del writer
				bw.flush();
				
				// Pedimos al usuario que introduzca la linea a escribir
				System.out.println("Introduzca la linea que quieres escribir en el fichero");
				lineaW = reader.nextLine();
			}
			
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
