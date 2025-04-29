package ejercicio7;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static final String agenda = "src\\ejercicio7\\Agenda.txt";
	
	public static void main(String[] args) {
		
		// Creamos el treeMap contactos
		TreeMap<String, String> contactos;
		
		// Cargamos los datos
		contactos = GestionAgenda.cargarDatos();
		
		// Creamos la variable opcion para almacenar la opcion que introduzca el usuario
		int opcion;
		
		// Creamos la variable nombre para almacenar el nombre del nuevo contacto que inserte el usuario
		String nombre;
		
		// Creamos la variable telefono para almacenar el telefono del nuevo contacto que inserte el usuario
		int telefono;
		
		// Creamos el scanner
		Scanner reader = new Scanner(System.in);
		
		
		do {
		
			// Pintamos el menu
			menu();
			
			// Pedimos al usuario que seleccione una opcion
			System.out.println("Seleccione una opcion");
			opcion = reader.nextInt();
			
			// Limpiamos el buffer del scanner
			reader.nextLine();
			
			// Switcheamos la opcion del usuario
			switch (opcion) {
				
				// Nuevo contacto
				case 1 -> {
					
					// Si la agenda no esta llena
					if (contactos.size() < 20) {
						
						// Pedimos al usuario que introduzca el nombre del nuevo contacto
						System.out.println("Introduzca el nombre del contacto");
						nombre = reader.nextLine();
						
						do {
							// Pedimos al usuario que introduzca el telefono del nuevo contacto
							System.out.println("Introduzca el telefono del contacto");
							telefono = reader.nextInt();
							
						} while (String.valueOf(telefono).length() != 9);
						
						// Si no existe un contacto con el mismo nombre
						if (!contactos.containsKey(nombre)) {
							
					        // Añadimos el contacto
					        contactos.put(nombre, String.valueOf(telefono));
					        
					    // Si existe un contacto con el mismo nombre
					    } else {
					    	
					        // Si ya existe, mostramos un mensaje
					        System.out.println("El contacto con el nombre " + nombre + " ya existe");
					    }
					}
				}
				
				// Buscar por nombre
				case 2 -> {
					
					// Pedimos al usuario que introduzca el nombre del nuevo contacto
					System.out.println("Introduzca el nombre del contacto");
					nombre = reader.nextLine();
					
					// Si existe el contacto indicado
					if (contactos.containsKey(nombre)) {
						
						// Imprimimos el telefono
						System.out.println(contactos.get(nombre));
						
					// Si no existe el contacto indicado
				    } else {
				    	
				    	// Imprimimos un mensaje
				        System.out.println("El contacto indicado no existe");
				    }
				}
				
				// Mostrar todos
				case 3 -> {
					
					// Recorremos el TreeMap
					for (Map.Entry<String, String> entry : contactos.entrySet()) {
						
						// Imprimimos el contacto
						System.out.println(entry.getKey() + "\t" + entry.getValue());
					}
				}
				
				// Salir
				case 4 -> {
					System.out.println("\nFin del programa");
				}
			}
			
		// Mientras que no introduzca la opcion 4 para salir
		} while (opcion != 4);
		
		// Cerramos el scanner
		reader.close();
		
		// Guardamos los cambios
		GestionAgenda.guardarDatos(contactos);

	}
	
	static void menu() {
		System.out.println("\n" + "--- AGENDA ---");
		System.out.println("1. Nuevo contacto");
		System.out.println("2. Buscar por nombre");
		System.out.println("3. Mostrar todos");
		System.out.println("4. Salir" + "\n");
	}

}
