package ProyectoFinalPruebas;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Jugador {
	static File file = new File ("src/ProyectoFinalPruebas/jugadores.txt");
	
	public int puntos;
	public  String nombre;
	public static String respuesta;
	
	public Jugador(String nombre, int puntos) {
		this.nombre = nombre;
		this.puntos = puntos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	abstract boolean responderMates(String resultado);
	abstract boolean responderLengua(String resultado);
	abstract boolean responderIngles(String resultado);

	public static  void verJugadores() throws IOException {
		BufferedReader leer = new BufferedReader(new FileReader(file));
		String line;
		List<String> lines = new ArrayList<String>();
	
		while((line = leer.readLine()) != null) {
		    lines.add(line);
		}
		leer.close();
		
		for(int i=0;i<lines.size();i++) {
			System.out.println(lines.get(i));
			}
		}
	
	
	public static boolean comprobarJugador(String jugador) throws IOException {
		boolean bool = false;
		
		BufferedReader leer = new BufferedReader(new FileReader(file));
		String line;

	
		while((line = leer.readLine()) != null) {
			if (jugador.equals(line)) {
				bool = true;
				break;
			}else {
				bool = false;
			}
		}
		leer.close();
		return bool;
	}
	public static boolean añadirJugador(String jugador) throws IOException {
		
		boolean aux = comprobarJugador(jugador);
		if (aux){
			System.out.println("Jugador Ya Existente en el Sistema");
		}else {
			BufferedReader leer = new BufferedReader(new FileReader(file));
			String line;
			List<String> lines = new ArrayList<String>();
			while((line = leer.readLine()) != null) {
			    lines.add(line);
			}
			lines.add(jugador);
			 try {
		            FileWriter escritor = new FileWriter("src/ProyectoFinalPruebas/jugadores.txt");

		            for(int i=0;i<lines.size();i++) {
		            escritor.write(lines.get(i)+"\n");
		            }            
		            escritor.close();
		            System.out.println("Se ha escrito correctamente el Jugador.");
		        } catch (IOException e) {
		            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
		        }
			 leer.close();
		}
		
		return false;
		
	}
	public static boolean borrarJugador(String jugador) throws IOException {
			
			boolean aux = comprobarJugador(jugador);
			if (!aux){
				System.out.println("Jugador No Existente en el Sistema");
			}else {
				BufferedReader leer = new BufferedReader(new FileReader(file));
				String line;
				List<String> lines = new ArrayList<String>();
				while((line = leer.readLine()) != null) {
				    lines.add(line);
				}
				
				for(int i=0;i<lines.size();i++) {
					if(jugador.equals(lines.get(i))) {
						lines.remove(i);
					}
				}
				 try {
			            FileWriter escritor = new FileWriter("src/ProyectoFinalPruebas/jugadores.txt");
	
			            for(int i=0;i<lines.size();i++) {
			            escritor.write(lines.get(i)+"\n");
			            }            
			            escritor.close();
			            System.out.println("Se ha escrito correctamente en el archivo.");
			        } catch (IOException e) {
			            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
			        }
				 leer.close();
			}
			return false;
			
		}
}