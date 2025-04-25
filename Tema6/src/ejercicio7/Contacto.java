package ejercicio7;

import java.util.Objects;

public class Contacto implements Comparable<Contacto> {

	private String nombre;
	private int telefono;
	
	public Contacto(String nombre, int telefono) {
		
		if (nombre != null && !nombre.isBlank()) {
			this.nombre = nombre;
		}
		
		if (String.valueOf(telefono).length() == 9) {
			this.telefono = telefono;
		}
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getTelefono() {
		return String.valueOf(this.telefono);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean res = false;
		
		Contacto otroContacto = (Contacto) obj;
		
		if (this.nombre.equalsIgnoreCase(otroContacto.nombre)) {
			res = true;
		}
		
		return res;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	public String toString() {
		return "Nombre -> " + this.nombre + "\n" +
		"Teléfono -> " + this.telefono + "\n";
	}

	@Override
	public int compareTo(Contacto c) {
		return this.nombre.compareTo(c.nombre);
	}
}
