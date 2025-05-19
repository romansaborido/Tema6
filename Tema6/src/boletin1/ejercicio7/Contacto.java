package boletin1.ejercicio7;

public class Contacto implements Comparable<Contacto>{

	private String nombre;
	private String numeroTelefono;
	
	
	public Contacto(String nombre) {
		
		if (nombre != null && !nombre.isBlank()) {
			this.nombre = nombre;
		}
	}
	
	
	public Contacto(String nombre, String numeroTelefono) {
		
		if (nombre != null && !nombre.isBlank()) {
			this.nombre = nombre;
		}
		
		if (numeroTelefono != null && !numeroTelefono.isBlank() && numeroTelefono.length() == 9) {
			this.numeroTelefono = numeroTelefono;
		}
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getNumeroTelefono() {
		return this.numeroTelefono;
	}
	
	
	@Override
	public int compareTo(Contacto otro) {

		int res;
		 	
		// Si el nombre o el teléfono ya existen no es valido
	    if (this.nombre.equals(otro.nombre) || this.numeroTelefono.equals(otro.numeroTelefono)) {
	    	res = 0;
	    }
	     
	    // Si no son iguales ordenamos por nombre
	    res = this.nombre.compareTo(otro.nombre);
	     
	    return res;
	 }

	 
	 @Override
	 public String toString() {
		 return this.nombre + " - " + this.numeroTelefono;
	 }
}
