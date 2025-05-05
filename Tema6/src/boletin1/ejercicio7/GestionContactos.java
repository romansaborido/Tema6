package boletin1.ejercicio7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GestionContactos {

	private static String fileContactos = "src\\ejercicio7\\Contactos.txt"; 
	
	public static Contacto[] cargarContactos() {
		
		// Creamos el array contactos
		Contacto[] contactos = new Contacto[20];
		
		// Leemos el fichero
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileContactos));
			
			// Obtenemos la primera linea
			String linea = br.readLine();
			
			// Mientras que no lleguemos al final del fichero
			while (linea != null) {
				
			}
			
		// Capturamos las excepciones y mostramos un mensaje
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el fichero indicado");
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error en la lectura del fichero indicado");
		}
		
		// Devolvemos los contactos
		return contactos;
		
	}
}
