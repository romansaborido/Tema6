package ejercicio7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static final String agenda = "src\\ejercicio7\\Agenda.txt";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static void menu() {
		System.out.println("1. Nuevo contacto");
		System.out.println("2. Buscar por nombre");
		System.out.println("3. Mostrar todos");
		System.out.println("4. Salir");
	}
	
	static void cargarDatos() {
		
		// Leemos el fichero con el br
		try (BufferedReader br = new BufferedReader(new FileReader(agenda))) {
		
			
			
			// Obtenemos la primera linea
			String linea = br.readLine();
			
			// Almacenamos los datos en un array
			
		// Capturamos las excepciones y mostramos un mensaje de error
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el archivo indicado");
		} catch (IOException e) {
			System.out.println("No se ha podido modificar el archivo indicado");
		}
	}

}
