package boletin1.ejercicio7;

import java.util.Scanner;

public class PrincipalContacto {

	static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int opcion;
		
		Contacto contacto;
		
		
		do {
			
			menu();
			
			System.out.println("Introduzca una opcion");
			opcion = reader.nextInt();
			reader.nextLine();
			
			switch (opcion) {
				case 1 -> {
					contacto = creaContacto();
					
					if (ContactoCRUD.insertarContacto(contacto)) {
						System.out.println("El contacto se ha insertado correctamente");
					} else {
						System.out.println("El contacto no se ha podido insertar");
					}
				}
				case 2 -> {
					contacto = creaContactoPk();
					
					if (ContactoCRUD.obtenerNumero(contacto) != null) {
						System.out.println(ContactoCRUD.obtenerNumero(contacto));
					} else {
						System.out.println("El numero de telefono no se ha podido obtener");
					}
				}
				case 3 -> {
					ContactoCRUD.listadoContactos();
				}
				case 4 -> {
					GestionContactos.guardarContactos();
					System.out.println("Los cambios se han guardado correctamente");
				}
				default -> {
					System.out.println("Introduzca una opción válida");
				}
			}
			
		} while (opcion != 4);
	}
	
	
	static void menu() {
		System.out.println("1. Nuevo contacto");
		System.out.println("2. Buscar por nombre");
		System.out.println("3. Mostrar todos");
		System.out.println("4. Salir");
	}
	
	
	static Contacto creaContacto() {
		
		String nombre;
		int numeroTelefono;
		
		System.out.println("Introduzca el nombre del contacto");
		nombre = reader.nextLine();
		
		System.out.println("Introduzca el numero de telefono");
		numeroTelefono = reader.nextInt();
		
		Contacto c = new Contacto(nombre, String.valueOf(numeroTelefono));
		
		return c;
	}
	
	
	static Contacto creaContactoPk() {
		
		String nombre;
		
		System.out.println("Introduzca el nombre del contacto");
		nombre = reader.nextLine();
		
		Contacto c = new Contacto(nombre);
		
		return c;
	}
}
