package logica;
//Lukas Paolo Toshisuke Cortés Alfaro, 22.108.123-4, ICCI
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
	public static Scanner sc;
	//Se inician variables para usar luego
	static String[] usuarios = new String[10];
	static String[] contraseñas = new String[10];
	static int cantUsuarios = 0;
	static String usuarioActivo = "";
	public static void main(String[] args) throws FileNotFoundException {
		leerRegistros(); //Lectura del archivo Registros.txt
		leerUsuarios();	//Lectura del archivo Usuarios.txt
		int opcion = 0; 
		
		sc = new Scanner(System.in); //Se crea un nuevo escaner para poder ingresar por consola
		do {
			System.out.println("1) Menu de Usuarios");
			System.out.println("2) Menu de Analisis");
			System.out.println("3) Salir");
			opcion = sc.nextInt();
			sc.nextLine(); //Para saltar la linea y que no hayan errores luego al seguir usando sc
			switch (opcion) {
			case 1:
				//Ingreso de usuario y contraseña
				System.out.print("Usuario: ");
				String usuario = sc.nextLine();
				System.out.print("Contraseña: ");
				String contraseña = sc.nextLine();
				if (inicioSesion(usuario, contraseña) == true) {//Llamamos al metodo que comprueba si existe el perfil ingresado
					System.out.println("Acceso correcto!");
					System.out.println("\nBienvenido " + usuarioActivo + "! \n\nQue deseas realizar?");
					System.out.println("\n1) Registrar actividad.");
					System.out.println("2) Modificar actividad.");
					System.out.println("3) Eliminar actividad.");
					System.out.println("4) Cambiar contraseña.");
					System.out.println("5) Salir.");
					opcion = 0; //Reseteamos la variable opcion por cualquier error que pueda haber
					do {
						switch (opcion) {
						case 1:
							registrarActividad();
							break;
						case 2:
							modificarActividad();
							break;
						case 3:
							eliminarActividad();
							break;
						case 4:
							cambiarContraseña();
							break;
						case 5:
							System.out.println("Salió del menú con exito...");
							break;
						default:
							System.out.println("Ingresó una opcion no valida.");
							break;
						}
					}while(opcion != 5);
				}else {
					System.out.println("Acceso incorrecto!");
				}
			
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
		}while (opcion != 3);
	}
	private static void registrarActividad() {
		// TODO Auto-generated method stub
		
	}
	private static void modificarActividad() {
		// TODO Auto-generated method stub
		
	}
	private static void eliminarActividad() {
		// TODO Auto-generated method stub
		
	}
	private static void cambiarContraseña() {
		// TODO Auto-generated method stub
		
	}
	private static boolean inicioSesion(String usuario, String contraseña) {
		for (int i = 0; i < cantUsuarios; i++) {
			if (usuario.equals(usuarios[i])) {
				if(contraseña.equals(contraseñas[i])) {
					usuarioActivo = usuarios[i]; //Guardamos el usuario de quien inicio sesion
					return true; //Si se encontró usuario y contraseña y estan conectados retorna true
				}else {
					return false; //Si no encuentra la contraseña conectada al usuario ingresado retorna false
				}	
			}
		}return false; //Si no encuentra el usuario en nuestra lista de usuarios retorna false
	}
	public static void menuAnalisis() {
		// TODO Auto-generated method stub
		
	}
	public static void leerUsuarios() throws FileNotFoundException {
		File arch = new File("datos/Usuarios.txt");
		sc = new Scanner(arch);
		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			String[] partes = linea.split(";");
			String ID = partes[0].trim();
			String contraseña = partes[1].trim();
			usuarios[cantUsuarios] = partes[0];
			contraseñas[cantUsuarios] = partes[1];
			cantUsuarios++;
		}
		
	}
	public static void leerRegistros() throws FileNotFoundException{
		File arch = new File("datos/Registros.txt");
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
