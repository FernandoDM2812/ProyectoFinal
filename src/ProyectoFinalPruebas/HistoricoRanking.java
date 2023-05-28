package ProyectoFinalPruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HistoricoRanking {

	static File ranking = new File("src/ProyectoFinalPruebas/ranking.txt");
	static File historico = new File("src/ProyectoFinalPruebas/historico.txt");
	
	public static  void verRanking() throws IOException {
		BufferedReader leer = new BufferedReader(new FileReader(ranking));
		String line;
		ArrayList<String> lines = new ArrayList<String>();
	
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
			ArrayList<String> lines = new ArrayList<String>();
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
	public static void borrarJugadorRanking(String nombre) throws IOException {
			BufferedReader leer = new BufferedReader(new FileReader(ranking));
			String line;
			ArrayList<String> lines = new ArrayList<String>();
			while((line = leer.readLine()) != null) {
			    lines.add(line);
			}
			
			ArrayList<String> linesActualizado = new ArrayList<>();
			
			for(int i = 0; i<lines.size();i++) {
				
				String linea = lines.get(i);
				
				if(!linea.contains(nombre)) {
					linesActualizado.add(linea);
				}
			}
			 try {
		            FileWriter escritor = new FileWriter(ranking);

		            for(int i=0;i<linesActualizado.size();i++) {
		            escritor.write(linesActualizado.get(i)+"\n");
		            }            
		            escritor.close();
		        } catch (IOException e) {
		            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
		        }
			 leer.close();
	}
	public static void actualizarRanking(ArrayList<Jugador> jugadoresPartida) throws IOException {
	    Scanner leer = new Scanner(new FileReader(ranking));
	    ArrayList<String> lines = new ArrayList<String>();
	    ArrayList<Jugador> rankingJugadores = new ArrayList<>();
	    while (leer.hasNextLine()) {
	        String line = leer.nextLine();
	        lines.add(line);
	    }
	    
	    for(int i=0;i<lines.size();i++) {
	        String[] jugadores = lines.get(i).split(" ");
	        String nombre = jugadores[0];
	        int puntuacion = Integer.parseInt(jugadores[1]); 
	       	Jugador jugador = new Humano(nombre,puntuacion);
	        rankingJugadores.add(jugador);
	    }
	    rankingJugadores.addAll(jugadoresPartida);
	    
	    for(int i=0;i<rankingJugadores.size();i++) {
	    	Jugador jugador = rankingJugadores.get(i);
	    	for(int y = 0;y<rankingJugadores.size();y++) {
	    		Jugador aux = rankingJugadores.get(y);
	    		if(jugador.getNombre().equals(aux.getNombre())&&jugador.getPuntos()!=aux.getPuntos()) {
	    			jugador.setPuntos(jugador.getPuntos()+aux.getPuntos());
	    			rankingJugadores.remove(aux);
	    		}
	    	}
	    }
	    	    
	    Collections.sort(rankingJugadores, new Comparator<Jugador>() {
	        public int compare(Jugador jugador1, Jugador jugador2) {
	            return Integer.compare(jugador2.getPuntos(), jugador1.getPuntos());
	        }
	    });
	    
	    try {
	    	FileWriter escribirRanking = new FileWriter(ranking);
	    	
	    	for (int i=0;i<rankingJugadores.size();i++) {
	    		Jugador jugador = rankingJugadores.get(i);
	    		
	    		escribirRanking.write(jugador.getNombre() + " " + jugador.getPuntos()+"\n");
	    	}
	    	escribirRanking.close();
	    }catch(IOException e){
	    	
	    	System.out.println("OCURRIO UN ERROR AL ESCRIBIR EN EL FICHERO");
	    	
	    	e.printStackTrace();
	    }
	    	leer.close();
	    	
	}
	public static void mostrarHistorico() throws IOException {
		BufferedReader leer = new BufferedReader(new FileReader(historico));
		String line;
		ArrayList<String> lines = new ArrayList<String>();
	
		while((line = leer.readLine()) != null) {
		    lines.add(line);
		}
		leer.close();
		
		for(int i=0;i<lines.size();i++) {
			System.out.println(lines.get(i));
			}
		}
	public static void actualizarHistorico(String Resultado) throws IOException{
		BufferedReader leer = new BufferedReader(new FileReader(historico));
		String line;
		ArrayList<String> lines = new ArrayList<String>();
	
		while((line = leer.readLine()) != null) {
		    lines.add(line);
		}
		lines.add(Resultado);
		try {
	    	FileWriter escribirRanking = new FileWriter(historico);
	    	
	    	for (int i=0;i<lines.size();i++) {
	    		
	    		escribirRanking.write(lines.get(i)+"\n");
	    	}
	    	escribirRanking.close();
	    }catch(IOException e){
	    	
	    	System.out.println("OCURRIO UN ERROR AL ESCRIBIR EN EL FICHERO");
	    	
	    	e.printStackTrace();
	    }
		leer.close();
	}
		
}
