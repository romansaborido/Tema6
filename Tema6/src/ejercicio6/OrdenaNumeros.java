package ejercicio6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class OrdenaNumeros {

	// Ruta del fichero de los numeros desordenados
	static final String numerosDes = "src\\ejercicio6\\NumerosDesordenados.txt";
	
	// Ruta del fichero de los numeros ordenados
	static final String numerosOrd = "src\\ejercicio6\\NumerosOrdenados.txt";
	
	
	public static void main(String[] args) {
		
		// Creamos la lista ordNum para almacenar los numeros y ordenarlos
		ArrayList<Integer> ordNum = new ArrayList<Integer>();
		
		
		// Leemos los numeros desordenados usando el br
		try (BufferedReader br = new BufferedReader(new FileReader(numerosDes))) {
			
			// Leemos la primera linea
			String linea = br.readLine();
			
			// Mientras que no lleguemos al final del fichero
			while (linea != null) {
				
				// Almacenamos el entero en la lista
				ordNum.add(Integer.parseInt(linea.trim()));
				
				// Leemos la siguiente linea
				linea = br.readLine();
			}
			
		// Capturamos las excepciones y mostramos un mensaje de error
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido acceder al archivo indicado");
		} catch (IOException e) {
			System.out.println("No se ha podido leer el archivo indicado");
		}
		
		// Ordenamos la lista
		Collections.sort(ordNum);
		
		
		// Insertamos los numeros ordenados usando el bw
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(numerosOrd))) {
			
			// Recorremos la lista
			for (int numero : ordNum) {
				
				// Insertamos el numero
				bw.append(String.valueOf(numero));
				
				// Insertamos un salto de linea
				bw.newLine();
				
				// Limpiamos el buffer del scanner
				bw.flush();
			}
			
			// Cerramos el bw
			bw.close();
			
		// Capturamos las excepciones y mostramos un mensaje de error
		} catch (IOException e) {
			System.out.println("No se ha podido leer el archivo indicado");
		}

	}

}
