package boletin2.ejercicio7;

import java.util.Objects;

public class Cliente implements Comparable<Cliente>{

	private String dni;
	
	private String nombreCompleto;
	
	private String fechaNacimiento;
	
	private double saldo;
	
	
	public Cliente(String dni) {
		
		if (dni.length() == 9) {
			this.dni = dni;
		}
	}
	
	public Cliente(String dni, String nombreCompleto, String fechaNacimiento, double saldo) {
		
		if (dni.length() == 9) {
			this.dni = dni;
		}
		
		if (nombreCompleto != null && !nombreCompleto.isBlank()) {
			this.nombreCompleto = nombreCompleto;
		}
		
		if (fechaNacimiento.length() == 10) {
			this.fechaNacimiento = fechaNacimiento;
		}
		
		if (saldo > 0) {
			this.saldo = saldo;
		}
	}

	
	@Override
	public int compareTo(Cliente otroCliente) {
		return this.dni.compareToIgnoreCase(otroCliente.dni);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		boolean res = false;
		
		Cliente otroCliente = (Cliente) obj;
		
		if (this.dni.equalsIgnoreCase(otroCliente.dni)) {
			res = true;
		}
		
		return res;
	}
	
	
	public String getDni() {
		return this.dni;
	}
	
	public String getNombreCompleto() {
		return this.nombreCompleto;
	}
	
	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	
	@Override
	public String toString() {
		return "Dni -> " + this.dni + "\n" +
			   "Nombre -> " + this.nombreCompleto + "\n" +
			   "Fecha de Nacimiento -> " + this.fechaNacimiento + "\n" +
			   "Saldo -> " + this.saldo;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	
	
	
}
