package boletin2.ejercicio6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataDeportistas {

	public static void main(String[] args) {
		
		// Constante que almacena la ruta del archivo 
		final String FILE = "src\\boletin2\\ejercicio6\\Deportistas.txt";
		
		// Variable para ir almacenando la linea que estamos leyendo del fichero
		String linea;
		
		// Array para almacenar la informacion del deportista
		String[] dataDeportista;
		
		// Variable para almacenar el nombre del deportista de mayor edad
		String nombreMayorEdad = "";
		
		// Variable para almacenar el nombre del deportista de mayor peso
		String nombreMayorPeso = "";
		
		// Variable para almacenar el nombre del deportista de mayor estatura
		String nombreMayorEstatura = "";

		// Variables para almacenar la mayor altura, la mayor estatura y el mayor peso
		int mayorEdad = Integer.MIN_VALUE;
		double mayorPeso = Double.MIN_VALUE;
		double mayorEstatura = Double.MIN_VALUE;
		
		// Leemos el fichero deportistas
		try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
			
			// Ignoramos la primera linea
			br.readLine();
			
			// Leemos la siguiente linea
			linea = br.readLine();
			
			// Mientras que el fichero tenga contenido
			while (linea != null) {
				
				// Reemplazamos los tabuladores por un punto y coma
				linea = linea.replaceAll("\t+", ";");
				
				// Almacenamos la informacion del deportista
				dataDeportista = linea.split(";"); 
				
				// Obtenemos los datos del deportista
				String nombre = dataDeportista[0];
				int edad = Integer.parseInt(dataDeportista[1]);
				double peso = Double.parseDouble(dataDeportista[2]);
				double estatura = Double.parseDouble(dataDeportista[3]);

				// Si la altura es mayor se actualiza y almacenamos el nombre del deportista
				if (edad > mayorEdad) {
					mayorEdad = edad;
					nombreMayorEdad = nombre;
				}
				
				// Si el peso es mayor se actualiza y almacenamos el nombre del deportista
				if (peso > mayorPeso) {
					mayorPeso = peso;
					nombreMayorPeso = nombre;
				}
				
				// Si la estatura es mayor se actualiza y almacenamos el nombre del deportista
				if (estatura > mayorEstatura) {
					mayorEstatura = estatura;
					nombreMayorEstatura = nombre;
				}
	
				// Volvemos a leer la proxima linea
				linea = br.readLine();
			}
			
			// Mostramos los resultados
			System.out.println("Deportista con mayor edad: " + nombreMayorEdad + " (" + mayorEdad + ")");
			System.out.println("Deportista con mayor peso: " + nombreMayorPeso + " (" + mayorPeso + ")");
			System.out.println("Deportista con mayor estatura: " + nombreMayorEstatura + " (" + mayorEstatura + ")");

		// Capturamos las excepciones y mostramos un mensaje de error
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el archivo indicado");
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al leer el archivo");
		}
	}

}
