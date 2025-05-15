package boletin2.ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class More {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		
		final String fichero = "src\\boletin2\\ejercicio3\\Fichero.txt";
		
		String linea;
		int cont = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
		
			linea = br.readLine();
			
			while (linea != null) {
				
				System.out.println(linea);
				
				cont++;
				
				if (cont % 24 == 0) {
					System.out.println("\nPulse Enter para seguir visualizando el fichero\n");
					reader.nextLine();
				}
				
				linea = br.readLine();
			}
			
			System.out.println("\nFin del fichero");
		
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el archivo indicado");
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al leer");
		}
			
		reader.close();

	}

}
