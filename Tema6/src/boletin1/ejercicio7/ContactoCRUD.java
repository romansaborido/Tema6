package boletin1.ejercicio7;

import java.util.TreeSet;

public class ContactoCRUD {

	private static TreeSet<Contacto> contactos = GestionContactos.cargarContactos();
	
	
	public static TreeSet<Contacto> getContactos() {
		return contactos;
	}
	
	
	public static void listadoContactos() {
		for (Contacto c : contactos) {
			System.out.println(c);
			System.out.println("---------------");
		}
	}
	
	
	public static boolean insertarContacto(Contacto c) {
		
		boolean res = false;
		
		if (contactos.size() < 20) {
			res = contactos.add(c);
		}
		
		return res;
	}
	
	
	public static boolean eliminarContacto(Contacto c) {
		return contactos.remove(c);
	}
	
	
	public static String obtenerNumero(Contacto c) {
		
		String numeroTelefono = null;
		
		for (Contacto contacto : contactos) {
			if (c.getNombre().equalsIgnoreCase(contacto.getNombre())) {
				numeroTelefono = contacto.getNumeroTelefono();
			}
		}
		
		return numeroTelefono;
	}
	

}
