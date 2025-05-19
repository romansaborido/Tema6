package boletin2.ejercicio5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Comp {

	public static void main(String[] args) {
		
		// Ruta del archivo 1
		final String file1 = "src\\boletin2\\ejercicio5\\File1.txt";
		
		// Ruta del archivo 2
		final String file2 = "src\\boletin2\\ejercicio5\\File2.txt";
		
		// Variables para obtener las lineas de cada uno de los ficheros
		String lineaF1;
		String lineaF2;
		
		// Creamos el booleano equals para almacenar si son iguales o no
		boolean equals = true;
		
		// Variable para controlar el numero de linea
		int nLinea = 1;
		
		// Variable para almacenar la posicion del caracter distinto
		int posChar;
		
		// Leemos los dos ficheros
		try (BufferedReader br1 = new BufferedReader(new FileReader(file1)); 
			 BufferedReader br2 = new BufferedReader(new FileReader(file2))) {
		
			// Obtenemos la primera de los dos ficheros
			lineaF1 = br1.readLine().trim();
			lineaF2 = br2.readLine().trim();
			
			// Mientras que no lleguemos al final en ninguno de los dos archivos
			while (lineaF1 != null && lineaF2 != null && equals) {
				
				// Si las lineas no son iguales
				if (!lineaF1.equalsIgnoreCase(lineaF2)) {
					
					// Los ficheros ya no son iguales
					equals = false;
				}
				
				// Obtenemos la siguiente linea de los dos ficheros
				lineaF1 = br1.readLine();
				lineaF2 = br2.readLine();
				
				// Incrementamos el numero de linea
				nLinea++;
			}
			
		// Capturamos las excepciones y mostramos un mensaje de error
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el archivo indicado");
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al leer el fichero");
		}

	}

}
