package boletin2.ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Creamos el scanner para realizar el conteo de caracteres
		Scanner reader = new Scanner(System.in);
		
		// Variable para obtener cada linea del fichero
		String linea;
		
		// Array para almacenar cada palabra que contiene cada linea
		String palabras[];
		
		// Leemos el fichero carta.txt
		try (BufferedReader br = new BufferedReader(new FileReader ("src\\boletin2\\ejercicio1\\Carta.txt"))) {
			
			// Leemos la primera linea del fichero
			linea = br.readLine();
			
			// Obtenemos las palabras por separado
			palabras = linea.split(" ");
			
			// Recorremos cada palabra de la linea y contamos los tipos de caracteres
			for (int i = 0 ; i < palabras.length ; i++) {
				
				//
			}
			
		// Capturamos las excepciones y mostramos un mensaje de error
		} catch (FileNotFoundException e) {
			System.out.println("El archivo indicado no se pudo encontrar");
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al leer el archivo indicado");
		}

		// Cerramos el scanner
		reader.close();
	}

}
