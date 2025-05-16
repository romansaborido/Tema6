package boletin2.ejercicio4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encriptador {

	static final String fileWriter = "src\\boletin2\\ejercicio4\\DatosEncriptados.txt";
	static final String fileReader = "src\\boletin2\\ejercicio4\\Codec.txt";
	
	public static void main(String[] args) {
	
		Scanner reader = new Scanner(System.in);
		
		int opcion;
		
		String info;
		String infoCodificada;
		
		do {
			
			menu();
			
			System.out.println("Seleccione una opcion");
			opcion = reader.nextInt();
			reader.nextLine();
			
			switch (opcion) {
				case 1 -> {
					System.out.println("Escriba la informacion a codificar");
					info = reader.nextLine();
					
					infoCodificada = codificarInformacion(info);
					
					insertarInformacion(infoCodificada);
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
		System.out.println("--- Ecripta y protege ---");
		System.out.println("1. Insertar informacion");
		System.out.println("2. Visualizar contenido cifrado");
		System.out.println("3. Salir");
	}
	
	
	static void insertarInformacion(String infoEncriptada) {
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileWriter, true))) {
			
			bw.newLine();
			bw.write(infoEncriptada);
			
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al escribir");
		}
	}
	
	
	static String codificarInformacion(String info) {
		
		// Creamos dos arrays para almacenar los dos abecedarios de encriptado
		String[] code1 = null;
		String[] code2 = null;
		
		// Creamos la cadena caracter para almacenar cada caracter de la palabra
		String caracter;
		
		// Variable para almacenar la informacion encriptada
		String infoEncriptada = "";
		
		// Posicion para recorrer la palabra a encriptar
		int pos = 0;
		
		// Leemos el fichero que tiene almacenado el algoritmo de encriptado
		try (BufferedReader br = new BufferedReader(new FileReader(fileReader))) {
			
			// Obtenemos el code1
			String linea = br.readLine();
			code1 = linea.split(" ");
			
			// Obtenemos el code2
			linea = br.readLine();
			code2 = linea.split(" ");
		
		// Capturamos las excepciones y mostramos un mensaje de error
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el archivo indicado");
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al encriptar");
		}
		
		// Recorremos la informacion recibida
		for (int i = 0 ; i < info.length() ; i++) {
			
			// Obtenemos caracter a caracter
			caracter = String.valueOf(info.charAt(i));
			
			// Recorremos code1
			while (pos < code1.length && !caracter.equals(code1[pos])) {
				pos++;
			}
			
			// Si el caracter se encuentra en code1
			if (pos < code1.length) {
				
				// Codificamos el caracter
				caracter = code2[pos];
			}

			// Concatenamos el caracter a la informacion encriptada
			infoEncriptada += caracter;
		}
		
		// Devolvemos la informacion encriptada
		return infoEncriptada;
	}

}
