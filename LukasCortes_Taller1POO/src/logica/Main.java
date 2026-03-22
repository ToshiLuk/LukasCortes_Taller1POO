package logica;
//Lukas Paolo Toshisuke Cortés Alfaro, 22.108.123-4, ICCI
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
	public static Scanner sc;
	public static void main(String[] args) throws FileNotFoundException {
		leerRegistros(); //Lectura del archivo Registros.txt
		leerUsuarios();	//Lectura del archivo Usuarios.txt
		
		int opcion = 0; 
		sc = new Scanner(System.in);
		do {
			System.out.println("1) Menu de Usuarios");
			System.out.println("2) Menu de Analisis");
			System.out.println("3) Salir");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				menuUsuarios();
				break;
			case 2:
				menuAnalisis();
				break;
			case 3:
				System.out.println("Cerró el programa con exito...");
				break;
			default:
				System.out.println("Ingresó algo equivocado. Intentelo de nuevo");
				break;
			}
		}while (opcion != 3 || opcion == 2 || opcion == 1);
	}
	private static void menuUsuarios() {
		// TODO Auto-generated method stub
		
	}
	private static void menuAnalisis() {
		// TODO Auto-generated method stub
		
	}
	private static void leerUsuarios() throws FileNotFoundException {
		File arch = new File("Usuarios.txt");
		sc = new Scanner(arch);
		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			String[] partes = linea.split(";");
			String ID = partes[0].trim();
			String contraseña = partes[1].trim();
		}
		
	}
	public static void leerRegistros() throws FileNotFoundException{
		File arch = new File("Registros.txt");
		sc = new Scanner(arch);
		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			String[] partes = linea.split(";");
			String ID = partes[0].trim();
			String fecha = partes[1].trim();
			int horas = Integer.parseInt(partes[2]);
			sc.nextLine();
			String actividad = partes[3].trim();
		}
	}
}
