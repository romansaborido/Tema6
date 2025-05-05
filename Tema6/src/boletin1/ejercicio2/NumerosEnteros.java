package boletin1.ejercicio2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class NumerosEnteros {

	public static void main(String[] args) {
		
		// Creamos la variable numero para almacenar los numeros reales que vamos a leer
		int numero;
		
		// Creamos la variable suma para almacenar la suma de los numeros del fichero
		int suma = 0;
		
		// Creamos la variable contador para saber cuantos numeros hay
		int contador = 0;
		
		
		// Leemos el archivo usando el scanner
		try (Scanner reader = new Scanner(new FileReader("src\\ejercicio2\\NumerosEnteros.txt"))) {
			
			// Mientras que la linea tenga mas numeros enteros
			while (reader.hasNextInt()) {
				
				// Leemos y obtenemos el numero
				numero = reader.nextInt();
				
				// Calculamos la suma
				suma += numero;
				
				// Incrementamos el contador
				contador++;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el archivo que indicas");
		}
		
		
		// Imprimimos los resultados
		System.out.println("Suma -> " + suma);
		System.out.println("Media -> " + suma / contador);
		
		
	}

}
