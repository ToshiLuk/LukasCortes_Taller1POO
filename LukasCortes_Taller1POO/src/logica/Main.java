package logica;
//Lukas Paolo Toshisuke Cortés Alfaro, 22.108.123-4, ICCI
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
	public static Scanner sc;
	public static void main(String[] args) throws FileNotFoundException {
		leerRegistros();
		leerUsuarios();
		
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
