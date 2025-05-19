package boletin2.ejercicio7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ClienteCRUD {

	private static HashSet<Cliente> clientes = GestionCliente.cargarDatos();

	public static HashSet<Cliente> getClientes() {
		return clientes;
	}

	public static void listarClientes() {
		List<Cliente> listaClientes = new ArrayList<>(clientes);
		Collections.sort(listaClientes);
		for (Cliente cliente : listaClientes) {
			System.out.println(cliente);
			System.out.println("-----------------------");
		}
	}

	public static boolean añadirCliente(Cliente c) {
		return clientes.add(c);
	}
	
	public static boolean eliminarCliente(Cliente c) {
		return clientes.remove(c);
	}
}

