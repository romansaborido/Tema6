package boletin1.ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Alumnos {

	public static void main(String[] args) {
	
		// Creamos el array data de longitud 3
		String data[] = new String[3];
		
		// Creamos la variable suma edades para obtener la suma de las edades
		int sumaEdades = 0;
		
		// Creamos la variable suma alturas para obtener la suma de las alturas
		double sumaAlturas = 0;
		
		// Creamos la variable cont para almacenar el numero de lineas que tiene el fichero
		int cont = 0;
		
		// Leemos el fichero linea a linea
		try (BufferedReader br = new BufferedReader(new FileReader("src\\ejercicio3\\Alumnos.txt"))) {
			
			// Obtenemos la primera linea del fichero
			String linea = br.readLine();
			
			// Mientras que se pueda seguir leyendo el fichero
			while (linea != null) {
				
				// Almacenamos los datos en el array
				data = linea.split(" ");
				
				// Mostramos los datos de la persona
				System.out.println("Nombre -> " + data[0] + "\n" + "Edad -> " + data[1] + "\n" + "Altura -> " + data[2] + "\n" + "------------------");
				
				// Sumamos la edad
				sumaEdades += Integer.parseInt(data[1]);
				
				// Sumamos la altura
				sumaAlturas += Double.parseDouble(data[2]);
				
				// Incrementamos el contador
				cont++;
				
				// Obtenemos la siguiente linea
				linea = br.readLine();	
			}
		
		// Capturamos las excepciones y mostramos un mensaje de error
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el archivo indicado");
		} catch (IOException e) {
			System.out.println("Ocurrió un error al leer el archivo");
		} catch (NumberFormatException e) {
			System.out.println("Error de formato numérico");
		}
		
		// Imprimimos la altura media
		System.out.println("\nALTURA MEDIA -> " + sumaAlturas / cont);
		
		// Imprimimos la edad media
		System.out.println("EDAD MEDIA -> " + sumaEdades / cont);

	}

}
