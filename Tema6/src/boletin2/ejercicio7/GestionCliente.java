package boletin2.ejercicio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class GestionCliente {
	
	private static final String FILE = "src\\boletin2\\ejercicio7\\Clientes.txt";

	public static HashSet<Cliente> cargarDatos() {

		String linea;

		String cliente[];

		HashSet<Cliente> clientes = new HashSet<>();

		try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {

			linea = br.readLine();

			while (linea != null) {

				cliente = linea.split(";");

				Cliente c = new Cliente(cliente[0], cliente[1], cliente[2], Double.parseDouble(cliente[3]));
				clientes.add(c);
				
				linea = br.readLine();
			}

		} catch (FileNotFoundException e) {
			System.err.println("No se ha podido encontrar el archivo indicado");
		} catch (IOException e) {
			System.err.println("Ha ocurrido un error al leer el archivo indicado");
		}

		return clientes;
	}

	
	public static void guardarDatos(HashSet<Cliente> clientes) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {

			for (Cliente c : clientes) {

				bw.write(c.getDni() + ";" + c.getNombreCompleto() + ";" + c.getFechaNacimiento() + ";" + c.getSaldo());

				bw.newLine();
				bw.flush();
			}

		} catch (IOException e) {
			System.err.println("Ha ocurrido un error al escribir en el archivo indicado");
		}
	}
}
