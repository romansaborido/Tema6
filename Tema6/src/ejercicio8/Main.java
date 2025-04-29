package ejercicio8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	static Scanner reader = new Scanner(System.in);
	static final String TEMPERATURAS = "src\\ejercicio8\\Temperaturas.txt";
	
	
	public static void main(String[] args) {
		
		int opcion;
		
		do {
			
			menu();
			
			System.out.println("Seleccione una opcion");
			opcion = reader.nextInt();
			
			reader.nextLine();
			
			switch (opcion) {
				
				case 1 -> {
					insertarRegistro();
				}
				case 2 -> {
					mostrarRegistros();
				}
				case 3 -> {
					System.out.println("\nFin del programa");
				}
				default -> {
					System.out.println("Introduzca una opción válida");
				}
			}
			
		} while (opcion != 3);

	}
	
	
	static void menu() {
		System.out.println("\n" + "--- AEMET ---");
		System.out.println("1. Registra nueva temperatura");
		System.out.println("2. Mostrar historial de registros");
		System.out.println("3. Salir" + "\n");
	}
	
	
	static void insertarRegistro() {
		
		String fecha;
		int temperaturaMax;
		int temperaturaMin;
		
		System.out.println("Introduzca la fecha");
		fecha = reader.nextLine();
		
		System.out.println("Introduzca la temperatura máxima");
		temperaturaMax = reader.nextInt();
		
		System.out.println("Introduzca la temperatura mínima");
		temperaturaMin = reader.nextInt();
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(TEMPERATURAS, true))) {
			
			bw.write(fecha + "," + temperaturaMax + "," + temperaturaMin);
			bw.newLine();
			
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			System.out.println("No se ha podido escribir en el archivo indicado");
		}
	}
	
	
	static void mostrarRegistros() {
	    String linea;
	    int temperaturaMax = Integer.MIN_VALUE;
	    int temperaturaMin = Integer.MAX_VALUE;
	    String[] minMax;

	    try (BufferedReader br = new BufferedReader(new FileReader(TEMPERATURAS))) {
	    	
	        linea = br.readLine();
	        
	        while (linea != null) {
	            
	            System.out.println(linea);
	            
	            minMax = obtenerTemperaturas(linea);
	           
	            int tempMax = Integer.parseInt(minMax[0]);
	            int tempMin = Integer.parseInt(minMax[1]);

	            if (tempMax > temperaturaMax) {
	                temperaturaMax = tempMax;
	            }
	            if (tempMin < temperaturaMin) {
	                temperaturaMin = tempMin;
	            }
	            
	            linea = br.readLine();
	        }
	        
	        System.out.println("\nTemperatura Máxima -> " + temperaturaMax);
	        System.out.println("Temperatura Mínima -> " + temperaturaMin);

	    } catch (FileNotFoundException e) {
	        System.out.println("No se ha podido encontrar el archivo indicado");
	    } catch (IOException e) {
	        System.out.println("No se ha podido leer el archivo indicado");
	    }
	}

	
	
	static String[] obtenerTemperaturas(String linea) {
		
		String minMax[] = new String[2]; 
		
		String temperaturas;
		
		temperaturas = linea.substring(12);
		
		minMax = temperaturas.split(",");
		
		return minMax;
	}

}
