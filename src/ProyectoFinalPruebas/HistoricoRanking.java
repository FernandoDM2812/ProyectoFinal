package ProyectoFinalPruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HistoricoRanking {

	static File ranking = new File("src/ProyectoFinalPruebas/ranking.txt");
	File historico = new File("src/ProyectoFinalPruebas/historico.txt");
	
	public static  void verRanking() throws IOException {
		BufferedReader leer = new BufferedReader(new FileReader(ranking));
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
	public static void añadirJugador(String nombre) throws IOException {
		
			BufferedReader leer = new BufferedReader(new FileReader(ranking));
			String line;
			List<String> lines = new ArrayList<String>();
			while((line = leer.readLine()) != null) {
			    lines.add(line);
			}
			lines.add(nombre + " 0");
			 try {
		            FileWriter escritor = new FileWriter("src/ProyectoFinalPruebas/ranking.txt");

		            for(int i=0;i<lines.size();i++) {
		            escritor.write(lines.get(i)+"\n");
		            }            
		            escritor.close();
		        } catch (IOException e) {
		            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
		        }
			 leer.close();
		}
	public static boolean borrarJugadorRanking(String nombre) throws IOException {
			boolean borrado=false;
			BufferedReader leer = new BufferedReader(new FileReader(ranking));
			String line;
			List<String> lines = new ArrayList<String>();
			while((line = leer.readLine()) != null) {
			    lines.add(line);
			}
			while(!borrado) {
				for(int i=0;i<lines.size();i++) {
					if(!lines.contains(nombre)) {
						nombre = nombre + " " + String.valueOf(i); 
						lines.remove(nombre);
						borrado=true;
					}
				}
		}
			 try {
		            FileWriter escritor = new FileWriter("src/ProyectoFinalPruebas/ranking.txt");

		            for(int i=0;i<lines.size();i++) {
		            escritor.write(lines.get(i)+"\n");
		            }            
		            escritor.close();
		        } catch (IOException e) {
		            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
		        }
			 leer.close();
		return false;
	}
}

