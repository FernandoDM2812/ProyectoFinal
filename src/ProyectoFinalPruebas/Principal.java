package ProyectoFinalPruebas;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Principal {
	
	
	public static void main(String[]args) throws IOException {
		Scanner entrada = new Scanner(System.in);
		boolean opcionCorrecta=false;
		System.out.println("Bienvenido a...");
		System.out.println("¿Eres mas Listo que una Maquina? (0o0)");
		
		while(!opcionCorrecta) {
			
			System.out.println("------------------------------------------");
			System.out.println("-         Seleccione una opcion          -");
			System.out.println("-                                        -");
			System.out.println("-       1-Jugar           2-Ranking      -");
			System.out.println("-                                        -");
			System.out.println("-      3-Historico       4-Jugadores     -");
			System.out.println("-                                        -");
			System.out.println("-                5-Salir                 -");
			System.out.println("-                                        -");
			System.out.println("------------------------------------------");
			
			String respuesta = entrada.nextLine();
			respuesta=respuesta.toLowerCase();
			if(respuesta.equals("1")) {
				jugarPartida();
				opcionCorrecta = true;
			}else if (respuesta.equals("2")) {
				HistoricoRanking.verRanking();
			}else if (respuesta.equals("3")) {
				HistoricoRanking.mostrarHistorico();
			}else if (respuesta.equals("4")) {
				menuJugadores();
			}else if(respuesta.equals("5")) {
				System.out.println("Hasta Luego Vuelva Pronto");
				opcionCorrecta = true;
			}else {
				System.out.println("Por favor seleccione una opcion correcta");
			}
		}
	entrada .close();
	}
	
	 
	public static void jugarPartida() throws IOException{
		Scanner entrada = new Scanner(System.in);
		ArrayList<Object> listaJugador = new ArrayList<>();
		boolean partidaIniziada = false;
		boolean jugadores = false;
		boolean preguntas = false;
		int partida=0;
		int numJugadores;
		
		ArrayList<Object> listaCPU = new ArrayList<>();
		CPU cpu1 = new CPU("CPU1", 0);
		CPU cpu2 = new CPU("CPU2", 0);
		CPU cpu3 = new CPU("CPU3", 0);
		CPU cpu4 = new CPU("CPU4", 0);
		listaCPU.add(cpu1);
		listaCPU.add(cpu2);
		listaCPU.add(cpu3);
		listaCPU.add(cpu4);
		
		while(!partidaIniziada) {
			while(!jugadores) {
				System.out.println("------------------------------------------");
				System.out.println("-     Seleccione Numero de Jugadores     -");
				System.out.println("------------------------------------------");
	
				numJugadores = entrada.nextInt();
				if(numJugadores<=4&&numJugadores>=0) {
					jugadores=true;
				}else {
					System.out.println("Seleccione un numero de jugadores entre 0 y 4");
				}
				for(int i=0;i<numJugadores;i++) {
					System.out.println("Seleccione Jugador");
					String jugador = entrada.next();
					boolean verdad = Jugador.comprobarJugador(jugador);
					if(!verdad) {
						System.out.println("Jugador no existente");
						i--;
					}else {
						Humano jugador1 = new Humano(jugador, 0);
						listaJugador.add(jugador1);
					}
				}
			while(numJugadores<4) {
				int indice = 3 - numJugadores;
				CPU jugadorCPU1 = (CPU) listaCPU.get(indice);
				listaJugador.add(jugadorCPU1);
				numJugadores++;
			}
			
			Collections.shuffle(listaJugador);
			System.out.println("Jugadores que van a Jugar la Partida:");
			for(int i=0;i<4;i++) {
				Jugador player = (Jugador) listaJugador.get(i);
				String nombre = player.getNombre();
				System.out.println(nombre);
			}
		}
			while(!preguntas) {
				Scanner sc=new Scanner(System.in);
				System.out.println("------------------------------------------");
				System.out.println("-   Seleccione Duracion De La Partida    -");
				System.out.println("******************************************");
				System.out.println("************1-Entrenamiento***************");
				System.out.println("******************************************");
				System.out.println("******2-Partida Rapida -3 Rondas**********");
				System.out.println("******************************************");
				System.out.println("******3-Partida Corta  -5 Rondas**********");
				System.out.println("******************************************");
				System.out.println("******4-Partida Normal -10 Rondas*********");
				System.out.println("******************************************");
				System.out.println("******5-Partida Normal -20 Rondas*********");
				System.out.println("******************************************");
				System.out.println("------------------------------------------");
				
				String duracion=sc.nextLine();
				duracion=duracion.toLowerCase();
				if(duracion.equals("entrenamiento")||duracion.equals("1")) {
					partida=0;
					preguntas=true;
				}
				if(duracion.equals("2")||duracion.equals("rapida")) {
					partida=3;
					preguntas=true;					
				}else if(duracion.equals("3")||duracion.equals("corta")){
					partida=5;
					preguntas=true;
				}else if(duracion.equals("4")||duracion.equals("normal")){
					partida=10;
					preguntas=true;
				}else if(duracion.equals("5")||duracion.equals("larga")){
					partida=20;
					preguntas=true;
				}else {
					System.out.println("Introduzca una duracion permitida");
				}sc.close();
			}
		System.out.println("**************************************************************");	
		System.out.println("*********************Inicio De La Partida*********************");	
		System.out.println("**************************************************************");
		partidaIniziada=true;
		if(partida>0) {
			iniciarPartida(listaJugador,partida);
		}else {
			entrenamiento();
		}
		}
	}
	
		  
		  public static void menuJugadores() throws IOException   {
			  Scanner entrada = new Scanner(System.in);
			  boolean menu=false;
			  String respuesta;				
				while(!menu) {
					  String opcion;
					  respuesta=null;
						System.out.println("******************************************");
						System.out.println("-            Menu Jugadores              -");
						System.out.println("******************************************");
						System.out.println("-            1-Ver Jugadores             -");
						System.out.println("******************************************");
						System.out.println("-            2-Añadir Jugador            -");
						System.out.println("******************************************");				
						System.out.println("-      	     3-Eliminar Jugador          -");
						System.out.println("******************************************");
						System.out.println("-                4-Salir                 -");
						System.out.println("******************************************");
						System.out.println("******************************************");
					
					respuesta = entrada.nextLine().toLowerCase();
				    
					if(respuesta.equals("1")) {
						Jugador.verJugadores();
					}else if (respuesta.equals("2")) {
						System.out.println("Que Jugador Desea Añadir?");
			            opcion = entrada.nextLine();
						Jugador.añadirJugador(opcion);
					}else if (respuesta.equals("3")) {
						System.out.println("Que Jugador Desea Eliminar?");
			            opcion = entrada.nextLine();
						Jugador.borrarJugador(opcion);
					}else if(respuesta.equals("4")) {
						menu = true;
					}
				}
		  }
		  public static void iniciarPartida(ArrayList<Object> jugadoresPartida,int duracion) {
			  duracion = duracion * 4;
			  Jugador jugador1 = (Jugador) jugadoresPartida.get(0);
			  Jugador jugador2 = (Jugador) jugadoresPartida.get(1);
			  Jugador jugador3 = (Jugador) jugadoresPartida.get(2);
			  Jugador jugador4 = (Jugador) jugadoresPartida.get(3);
			  for(int i=0;i<duracion;i++) {
				  
			  }
		  }
		  public static void entrenamiento() {
			  
		  }
}
