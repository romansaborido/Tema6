package ejercicio7;

import java.util.HashSet;

public class AgendaCRUD {
	
	private static HashSet<Contacto> agenda = new HashSet<>();
	
	public static void listadoAgenda() {
		for (Contacto c : agenda) {
			System.out.println(c);
			System.out.println("----------------");
		}
	}
	
	public static boolean agregarContacto(Contacto contacto) {
		return agenda.add(contacto);
	}
	
	public static String mostrarTelefono(String nombre) {
		
		String res = nombre + " no existe entre tus contactos";
		
		for (Contacto c : agenda) {
			if (c.getNombre().equalsIgnoreCase(nombre)) {
				res = c.getTelefono();
			}
		}
		
		return res;
	}
		
}
