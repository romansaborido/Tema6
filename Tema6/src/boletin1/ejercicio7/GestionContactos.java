package boletin1.ejercicio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class GestionContactos {

	private static String fileContactos = "src\\ejercicio7\\Contactos.txt"; 
	
	
	public static void guardarContactos() {
		
		// Obtenemos el array que almacena los contactos
		TreeSet<Contacto> contactos = ContactoCRUD.getContactos();
		
		// Escribimos en el fichero
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileContactos))) {
			
			// Recorremos el arrayList
			for (Contacto c : contactos) {
				
				// Insertamos el contacto en la agenda
				bw.write(c.getNombre() + " " + c.getNumeroTelefono());
				bw.newLine();
			}
		
		// Capturamos las excepciones y mostramos un mensaje de error
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error de escritura");
		}
	}
	
	
	public static TreeSet<Contacto> cargarContactos() {
		
		// Creamos el arrayList contactos
		TreeSet<Contacto> contactos = new TreeSet<>();
		
		// Creamos el array dataContacto para obtener los atributos de este
		String[] dataContacto = new String[2];
		
		// Leemos el fichero
		try (BufferedReader br = new BufferedReader(new FileReader(fileContactos))) {
			
			// Obtenemos la primera linea
			String linea = br.readLine();
			
			// Mientras que no lleguemos al final del fichero
			while (linea != null) {
				
				// Obtenemos los atributos del contacto
				dataContacto = linea.split(" ");
				
				// Creamos el contacto y lo añadimos al arrayList
				Contacto c = new Contacto(dataContacto[0], dataContacto[1]);
				contactos.add(c);
				
				// Obtenemos la siguiente linea
				linea = br.readLine();
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
