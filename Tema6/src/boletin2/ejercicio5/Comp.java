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
		
		// Creamos el booleano fileEquals para controlar si los ficheros son iguales o no
		boolean fileEquals = true;
		
		// Creamos el booleano charEquals para controlar si los caracteres son iguales o no
		boolean charEquals = true;
		
		// Variable para controlar el numero de linea
		int nLinea = 0;
		
		// Variable para almacenar la posicion del caracter distinto
		int posChar = 0;
		
		// Variable para almacenar la longitud de la linea mas corta
		int minLen;
		
		// Leemos los dos ficheros
		try (BufferedReader br1 = new BufferedReader(new FileReader(file1)); 
			 BufferedReader br2 = new BufferedReader(new FileReader(file2))) {
		
			// Obtenemos la primera de los dos ficheros
			lineaF1 = br1.readLine().trim().toLowerCase();
			lineaF2 = br2.readLine().trim().toLowerCase();
			
			// Mientras que no lleguemos al final en ninguno de los dos archivos
			while (lineaF1 != null && lineaF2 != null && fileEquals) {
				
				// Si las lineas no son iguales
				if (!lineaF1.equalsIgnoreCase(lineaF2)) {
					
					// Los ficheros ya no son iguales
					fileEquals = false;
						
					// Obtenemos la longitud de la cadena mas corta
					minLen = lineaF1.length() < lineaF2.length() ? lineaF1.length() : lineaF2.length();
						
					// Mientras que los caracteres sean iguales recorremos la cadena
					while (posChar < minLen && charEquals) {
							
						// Comparamos los caracteres, si no son iguales salimos del bucle
						if (lineaF1.charAt(posChar) != lineaF2.charAt(posChar)) {
							charEquals = false;
						}
							
						// Incrementamos la posicion
						posChar++;
					}
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
		
		
		// Si los ficheros no son iguales mostramos la posicion de la primera diferencia
		if (!fileEquals) {
			System.out.println("Linea -> " + nLinea);
			System.out.println("Caracter -> " + posChar);
		} else {
			System.out.println("Los ficheros son iguales");
		}
	
	}

}
