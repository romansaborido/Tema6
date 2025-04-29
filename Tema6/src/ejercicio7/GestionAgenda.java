package ejercicio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Map;

public class GestionAgenda {

	private static String fileAgenda = "src\\ejercicio7\\Agenda.txt";
	
	
	public static TreeMap<String, String> cargarDatos() {
		
		// Creamos el TreeMap contactos
		TreeMap<String, String> contactos = new TreeMap<>();
		
		// Creamos el array contacto para almacenar cada contacto
		String dataContacto[] = new String[2];
		
		// Creamos la variable linea para ir almacenando cada linea del fichero
		String linea;
		
		// Leemos el fichero 
		try (BufferedReader br = new BufferedReader(new FileReader(fileAgenda))) {
			
			// Leemos la primera linea
			linea = br.readLine();
			
			// Mientras que no lleguemos al final del archivo
			while (linea != null) {
				
				// Obtenemos los datos del contacto
				dataContacto = linea.split(" ");
				
				// Almacenamos el contacto
				contactos.put(dataContacto[0], dataContacto[1]);
				
				// Volvemos a leer la linea
				linea = br.readLine();
			}
			
		// Capturamos las excepciones y mostramos un mensaje de error
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el archivo indicado");
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al leer el contenido del archivo indicado");
		}
		
		// Devolvemos el TreeMap
		return contactos;
		
	}
	
	
	public static void guardarDatos(TreeMap<String, String> contactos) {
		
		// Escribimos en el fichero sobreescribiendo su contenido
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileAgenda, false))) {
			
			// Recorremos el TreeMap contactos
			for (Map.Entry<String, String> entry : contactos.entrySet()) {
				
				// Insertamos el contacto
				bw.write(entry.getKey() + " " + entry.getValue());
				
				// Insertamos una nueva linea
				bw.newLine();
				
				// Limpiamos el buffer
				bw.flush();
			}
			
			// Cerramos el bw
			bw.close();
			
		// Capturamos las excepciones y mostramos un mensaje de error
		} catch (IOException e) {
			System.out.println("No se ha podido encontrar el archivo indicado");
		}
		
	}
}
