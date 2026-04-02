package logica;
import java.io.BufferedWriter;
//Lukas Paolo Toshisuke Cortés Alfaro, 22.108.123-4, ICCI
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
	public static Scanner sc; //Para Inputs
	public static Scanner lector; //Para los txt
	//Se inician variables para usar luego
	static String[] usuarios = new String[10];
	static String[] contraseñas = new String[10];
	static int cantUsuarios = 0;
	static String usuarioActivo = "";
	static String[] tipoActividad = new String[10];
	public static void main(String[] args) throws IOException {
		leerRegistros(); //Lectura del archivo Registros.txt
		leerUsuarios();	//Lectura del archivo Usuarios.txt
		int opcion = 0; 
		
		sc = new Scanner(System.in); //Se crea un nuevo escaner para poder ingresar por consola
		do {
			System.out.println("1) Menu de Usuarios");
			System.out.println("2) Menu de Analisis");
			System.out.println("3) Salir");
			do {
				try {
				opcion = Integer.parseInt(sc.nextLine());	
				}catch(InputMismatchException e) {
					System.out.println("Ingresó un valido no valido para el menú, intentelo de nuevo.");
					System.out.println("\n1) Menu de Usuarios");
					System.out.println("2) Menu de Analisis");
					System.out.println("3) Salir");
					sc.next();
				}catch(NumberFormatException e) {
					System.out.println("Ingresó un valido no valido para el menú, intentelo de nuevo.");
					System.out.println("\n1) Menu de Usuarios");
					System.out.println("2) Menu de Analisis");
					System.out.println("3) Salir");
					sc.next();
				}
			}while(opcion!= 0 || opcion!= 1 || opcion != 2|| opcion != 3);
			switch (opcion) {
			case 1:
				//Ingreso de usuario y contraseña
				System.out.print("Usuario: ");
				String usuario = sc.nextLine();
				System.out.print("Contraseña: ");
				String contraseña = sc.nextLine();
				if (inicioSesion(usuario, contraseña) == true) {//Llamamos al metodo que comprueba si existe el perfil ingresado
					do {
						System.out.println("Acceso correcto!");
						System.out.println("\nBienvenido " + usuarioActivo + "! \n\nQue deseas realizar?");
						System.out.println("\n1) Registrar actividad.");
						System.out.println("2) Modificar actividad.");
						System.out.println("3) Eliminar actividad.");
						System.out.println("4) Cambiar contraseña.");
						System.out.println("5) Salir.");
						do {
							try {
							opcion = Integer.parseInt(sc.nextLine());	
							}catch(InputMismatchException e) {
								System.out.println("Ingresó un valido no valido para el menú, intentelo de nuevo.");
								System.out.println("\nBienvenido " + usuarioActivo + "! \n\nQue deseas realizar?");
								System.out.println("\n1) Registrar actividad.");
								System.out.println("2) Modificar actividad.");
								System.out.println("3) Eliminar actividad.");
								System.out.println("4) Cambiar contraseña.");
								System.out.println("5) Salir.");
								sc.next();
							}catch(NumberFormatException e) {
								System.out.println("Ingresó un valido no valido para el menú, intentelo de nuevo.");
								System.out.println("\nBienvenido " + usuarioActivo + "! \n\nQue deseas realizar?");
								System.out.println("\n1) Registrar actividad.");
								System.out.println("2) Modificar actividad.");
								System.out.println("3) Eliminar actividad.");
								System.out.println("4) Cambiar contraseña.");
								System.out.println("5) Salir.");
								sc.next();
							}
						}while(opcion!= 0 || opcion!= 1 || opcion != 2|| opcion != 3 || opcion != 4 || opcion != 5);
						switch (opcion) {
						case 1:
							registrarActividad();
							opcion = 0;
							break;
						case 2:
							modificarActividad();
							opcion = 0;
							break;
						case 3:
							eliminarActividad();
							opcion = 0;
							break;
						case 4:
							cambiarContraseña();
							opcion = 0;
							break;
						case 5:
							System.out.println("Salió del menú con exito...");
							break;
						default:
							System.out.println("Ingresó una opcion no valida.");
							break;
						}
					}while(opcion != 5 );
				}else {
					System.out.println("Acceso incorrecto!");
				}
			
				break;
			case 2:
				do {
					System.out.println("Bienvenido al menú de analisis!");
					System.out.println("\nQue deseas realizar?");
					System.out.println("\n1) Actividad más realizada.");
					System.out.println("2) Actividad más realizada por cada usuario.");
					System.out.println("3) Usuario con mayor procastinacion.");
					System.out.println("4) Ver todas las actividades.");
					System.out.println("5) Salir.");
					do {
						try {
						opcion = Integer.parseInt(sc.nextLine());	
						}catch(InputMismatchException e) {
							System.out.println("Ingresó un valido no valido para el menú, intentelo de nuevo.");
							System.out.println("Bienvenido al menú de analisis!");
							System.out.println("\nQue deseas realizar?");
							System.out.println("\n1) Actividad más realizada.");
							System.out.println("2) Actividad más realizada por cada usuario.");
							System.out.println("3) Usuario con mayor procastinacion.");
							System.out.println("4) Ver todas las actividades.");
							System.out.println("5) Salir.");
							sc.next();
						}catch(NumberFormatException e) {
							System.out.println("Ingresó un valido no valido para el menú, intentelo de nuevo.");
							System.out.println("Bienvenido al menú de analisis!");
							System.out.println("\nQue deseas realizar?");
							System.out.println("\n1) Actividad más realizada.");
							System.out.println("2) Actividad más realizada por cada usuario.");
							System.out.println("3) Usuario con mayor procastinacion.");
							System.out.println("4) Ver todas las actividades.");
							System.out.println("5) Salir.");
							sc.next();
						}
					}while(opcion!= 0 || opcion!= 1 || opcion != 2|| opcion != 3 || opcion != 4 || opcion != 5);
					switch(opcion) {
					case 1:
						actividadMasRealizada();
						break;
					case 2:
						actividadMasRealizadaUsuario();
						break;
					case 3:
						usuarioConMayorProcastinacion();
						break;
					case 4:
						verTodasLasActividades();
						break;
					case 5:
						break;
					default:
						System.out.println("Ingresó una opcion no valida.");
						break;	
					}
				}while(opcion != 5);
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
	private static void actividadMasRealizada() {
		try {
			String[] actividadesUnicas = new String[300];
			int[] frecuencias = new int[300];
			int totalUnicas = 0; //Cuantas actividades unicas hay
			File arch = new File("datos/Registros.txt");
			lector = new Scanner(arch);
			while(lector.hasNextLine()) {
				String linea = lector.nextLine();
				if (linea.trim().isEmpty()) {
		            continue; // Salta las lineas vacias
		        }
				String[] partes = linea.split(";");
				if (partes.length < 4) continue; //Por si hay lineas con un formato erroneo
				String actividad = partes[3].trim().toLowerCase();
				//Buscamos si esta actividad ya la habiamos guardado en nuestra lista
				boolean encontrada = false;
				for (int i = 0; i < totalUnicas; i++) {
					if (actividadesUnicas[i].equals(actividad)) {
						frecuencias[i]++; //Si ya existe, le sumamos 1 al contador
						encontrada = true;
						break; //Salimos del for porque ya la encontramos
					}				
				}
				//Si terminó el ciclo for y no la encontró, es una actividad NUEVA
				if (!encontrada) {
					actividadesUnicas[totalUnicas] = actividad; //La guardamos
					frecuencias[totalUnicas] = 1; //Es la primera vez que aparece
					totalUnicas++;
				}
			}
			lector.close();
			//Si el archivo estaba vacio o no habia registros, avisamos y salimos
			if (totalUnicas == 0) {
				System.out.println("No hay actividades registradas aun.");
				return;
			}
			//Ahora buscamos cual es el numero mas alto en la lista
			int maxFrecuencia = 0;
			String actividadTop = "";
			
			for (int i = 0; i < totalUnicas; i++) {
				if (frecuencias[i] > maxFrecuencia) {
					maxFrecuencia = frecuencias[i];
					actividadTop = actividadesUnicas[i];
				}
			}
			//Imprimimos el resultado 
			System.out.println("\n=== RESULTADO GLOBAL ===");
			System.out.println("La actividad mas realizada es: " + actividadTop + " veces.");
			System.out.println("Se repite un total de: " + maxFrecuencia + " veces.");
			System.out.println("========================");
		} catch (FileNotFoundException e) {
			System.out.println("Error: No se encontró el archivo Registros.txt en la carpeta datos/.");
		} catch (Exception e) {
			System.out.println("Ocurrio un error inesperado al calcular la actividad mas realizada.");
		}
	}
	private static void actividadMasRealizadaUsuario() {
		
		
	}
	private static void usuarioConMayorProcastinacion() {
		// TODO Auto-generated method stub
		
	}
	private static void verTodasLasActividades() {
		// TODO Auto-generated method stub
		
	}
	private static void registrarActividad() throws IOException {
		System.out.println("~~~ Registro de actividad de " + usuarioActivo + " ~~~");
		System.out.print("Ingrese la fecha de la actividad: ");
		String fecha = sc.nextLine();
		System.out.print("Ingrese las horas de la actividad: ");
		int horas = sc.nextInt();
		sc.nextLine();
		System.out.print("Ingrese la actividad: ");
		String actividad = sc.nextLine();
		String actividadNueva = usuarioActivo + ";" + fecha + ";" + horas + ";" + actividad;
		BufferedWriter bw = new BufferedWriter(new FileWriter("datos/Registros.txt", true));
		bw.newLine();
		bw.write(actividadNueva);
		bw.close();
	}
	private static void modificarActividad() throws FileNotFoundException {
		 try {
			//Cargar todo el archivo en un arreglo (máximo 300 actividades)
		        String[] lineasArchivo = new String[300];
		        int totalLineas = 0;
		        File arch = new File("datos/Registros.txt");
		        lector = new Scanner(arch);
		        while (lector.hasNextLine() && totalLineas < 300) {
		            lineasArchivo[totalLineas] = lector.nextLine();
		            totalLineas++;
		        }
		        lector.close(); 
		        //Mostrar solo las actividades del usuario activo
		        System.out.println("\n~~~ Actividades de " + usuarioActivo + " ~~~");
		        boolean tieneActividades = false;
		        for (int i = 0; i < totalLineas; i++) {
		            if (lineasArchivo[i].trim().isEmpty()) continue;
		            
		            String[] partes = lineasArchivo[i].split(";");
		            if (partes.length >= 4 && partes[0].trim().equals(usuarioActivo)) {
		                //Imprimimos 'i' que es el índice real dentro de nuestro arreglo
		                System.out.println(i + ") " + lineasArchivo[i]);
		                tieneActividades = true;
		            }
		        }
		        if (!tieneActividades) {
		            System.out.println("No tienes actividades registradas.");
		            return; //Salimos del método si no hay nada que modificar
		        }
		        //Pedir el índice a modificar
		        System.out.print("\nSeleccione la actividad a modificar, ingrese su indice (o un numero negativo para cancelar): ");
		        int indiceElegido = Integer.parseInt(sc.nextLine()); // Leemos como String y convertimos a int para evitar tener que saltar linea manualmente
		        if (indiceElegido < 0) {
		            return; //El usuario decidió cancelar
		        }
		        //Validar que el índice exista y pertenezca realmente al usuario activo
		        if (indiceElegido >= 0 && indiceElegido < totalLineas && lineasArchivo[indiceElegido].startsWith(usuarioActivo)) {
		            System.out.println("\nQue deseas modificar?");
		            System.out.println("1) Fecha");
		            System.out.println("2) Duracion");
		            System.out.println("3) Tipo de actividad");
		            System.out.print("Opcion: ");
		            int opcionMod = Integer.parseInt(sc.nextLine());
		            // Separar la línea específica que eligió el usuario
		            String[] partes = lineasArchivo[indiceElegido].split(";");
		            if (opcionMod == 1) {
		                System.out.print("Ingrese nueva fecha: ");
		                partes[1] = sc.nextLine();
		            } else if (opcionMod == 2) {
		                System.out.print("Ingrese nueva duracion (horas): ");
		                partes[2] = sc.nextLine();
		            } else if (opcionMod == 3) {
		                System.out.print("Ingrese nuevo tipo de actividad: ");
		                partes[3] = sc.nextLine();
		            } else {
		                System.out.println("Opcion no valida.");
		                return;
		            }
		            // Reconstruimos la línea con los datos nuevos
		            lineasArchivo[indiceElegido] = partes[0] + ";" + partes[1] + ";" + partes[2] + ";" + partes[3];
		            //Sobreescribir el archivo completo para aplicar la persistencia
		            PrintWriter escritor = new PrintWriter(arch);
		            for (int i = 0; i < totalLineas; i++) {
		                escritor.println(lineasArchivo[i]); // Escribimos línea por línea de vuelta al txt
		            }
		            escritor.close(); // Cerramos el escritor para que se guarden los cambios
		            
		            System.out.println("Actividad modificada con exito!");
		            
		        } else {
		            System.out.println("Error: El indice ingresado no es valido o no te pertenece.");
		        }
		        
		    } catch (FileNotFoundException e) {
		        System.out.println("Error: No se encontró el archivo Registros.txt en la carpeta datos/.");
		    } catch (NumberFormatException e) {
		        System.out.println("Error: Por favor ingresa un numero valido. Operacion cancelada.");
		    } catch (Exception e) {
		        System.out.println("Ocurrio un error inesperado al modificar la actividad.");
		    }
	}
	//Para este metodo se usó bastante codigo de modificarActividad()
	private static void eliminarActividad() {
		try {
			//Cargar todo el archivo en un arreglo (máximo 300 actividades)
		        String[] lineasArchivo = new String[300];
		        int totalLineas = 0;
		        File arch = new File("datos/Registros.txt");
		        lector = new Scanner(arch);
		        while (lector.hasNextLine() && totalLineas < 300) {
		            lineasArchivo[totalLineas] = lector.nextLine();
		            totalLineas++;
		        }
		        lector.close(); 
		        //Mostrar solo las actividades del usuario activo
		        System.out.println("\n~~~ Actividades de " + usuarioActivo + " ~~~");
		        boolean tieneActividades = false;
		        for (int i = 0; i < totalLineas; i++) {
		            if (lineasArchivo[i].trim().isEmpty()) continue;
		            
		            String[] partes = lineasArchivo[i].split(";");
		            if (partes.length >= 4 && partes[0].trim().equals(usuarioActivo)) {
		                //Imprimimos 'i' que es el índice real dentro de nuestro arreglo
		                System.out.println(i + ") " + lineasArchivo[i]);
		                tieneActividades = true;
		            }
		        }
		        if (!tieneActividades) {
		            System.out.println("No tienes actividades registradas.");
		            return; //Salimos del método si no hay nada que modificar
		        }
		        //Pedir el índice a eliminar
		        System.out.print("\nSeleccione la actividad a eliminar, ingrese su indice (o un numero negativo para cancelar): ");
		        int indiceElegido = Integer.parseInt(sc.nextLine()); // Leemos como String y convertimos a int para evitar tener que saltar linea manualmente
		        if (indiceElegido < 0) {
		            return; //El usuario decidió cancelar
		        }
		        //Validar que el índice exista y pertenezca realmente al usuario activo
		        if (indiceElegido >= 0 && indiceElegido < totalLineas && lineasArchivo[indiceElegido].startsWith(usuarioActivo)) {
		        	//Se desplaza a todos los elementos hacia la izquierda
		        	//Empezamos del indice que se borrara y se copia el siguiente en su posicion
		            for (int i = indiceElegido; i < totalLineas - 1; i++) {
		            	lineasArchivo[i] = lineasArchivo[i+1];
		            }
		            //Se limpia el ultimo  espacio que quedó duplicado
		        lineasArchivo[totalLineas - 1] = null;
		        totalLineas--; //Se achica el contador total de lineas de Registros.txt
		        //Ahora se sobrescribe el archivo para que persistan los datos
		        PrintWriter escritor = new PrintWriter(arch);
		        for (int i= 0; i< totalLineas; i++) {
		        	//Chequeo para no escribir lineas null o vacias
		        	if (lineasArchivo[i] != null && !lineasArchivo[i].trim().isEmpty()) {
		        		escritor.println(lineasArchivo[i]);
		        	}
		        }
		        escritor.close();
		        System.out.println("\nActividad eliminada con exito!");
		        }else {
		        	System.out.println("\nError: El indice ingresado no es valido o no te pertenece.");
		        }
		    } catch (FileNotFoundException e) {
		        System.out.println("Error: No se encontró el archivo Registros.txt en la carpeta datos/.");
		    } catch (NumberFormatException e) {
		        System.out.println("Error: Por favor ingresa un numero valido. Operacion cancelada.");
		    } catch (Exception e) {
		        System.out.println("Ocurrio un error inesperado al modificar la actividad.");
		    }
	}
	private static void cambiarContraseña() throws FileNotFoundException{
		try {
		System.out.println("~~~ Cambiando contraseña del usuario " + usuarioActivo + " ~~~");
		System.out.print("\nIngrese su nueva contraseña: ");
		String contraseñaNueva = sc.nextLine();
		for(int i = 0; i < cantUsuarios; i++) {//Buscamos en la lista usuarios[] hasta encontrar al usuario activo y usamos el indice para cambiar la contraseña
			if (usuarios[i].equals(usuarioActivo)) {
				contraseñas[i] = contraseñaNueva;
			}
		}//Ahora a sobrescribir Usuarios.txt
		File arch = new File("datos/Usuarios.txt");
		PrintWriter escritor = new PrintWriter(arch);
		//Recorremos a los usuarios registrados
		for (int i = 0; i < cantUsuarios; i++) {
			//Se guarda con el formato ID;Contraseña
			escritor.println(usuarios[i] + ";" + contraseñas[i]);
		}
		escritor.close();
		System.out.println("\n¡Contraseña actualizada con exito!");	
    }catch (FileNotFoundException e) {
    	System.out.println("Error: No se encontró el archivo Usuarios.txt en la carpeta datos/.");
    }catch(Exception e) {
    	System.out.println("Ocurrio un error inesperado al intentar cambiar la contraseña.");
    }
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
	public static void leerUsuarios() throws FileNotFoundException {
		File arch = new File("datos/Usuarios.txt");
		lector = new Scanner(arch);
		while (lector.hasNextLine()) {
			String linea = lector.nextLine();
			String[] partes = linea.split(";");
			usuarios[cantUsuarios] = partes[0];
			contraseñas[cantUsuarios] = partes[1];
			cantUsuarios++;
		}
	}
	public static void leerRegistros() throws FileNotFoundException{
		File arch = new File("datos/Registros.txt");
		lector = new Scanner(arch);
		while (lector.hasNextLine()) {
			String linea = lector.nextLine();
			if (linea.trim().isEmpty()) {
	            continue; // Salta las lineas vacias
	        }
			String[] partes = linea.split(";");
			if (partes.length < 4) {
	            continue; //
	        }
			String ID = partes[0].trim();
			String fecha = partes[1].trim();
			int horas = Integer.parseInt(partes[2]);
			String actividad = partes[3].trim();
		}
	}
}
