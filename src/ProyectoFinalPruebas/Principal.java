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
			System.out.println("-       -Jugar           -Ranking        -");
			System.out.println("-                                        -");
			System.out.println("-      -Historico       -Jugadores       -");
			System.out.println("-                                        -");
			System.out.println("-                -Salir                  -");
			System.out.println("-                                        -");
			System.out.println("------------------------------------------");
			
			String respuesta = entrada.nextLine();
			respuesta=respuesta.toLowerCase();
			if(respuesta.equals("jugar")) {
				jugarPartida();
				opcionCorrecta = true;
			}else if (respuesta.equals("ranking")) {
				System.out.println("2");
			}else if (respuesta.equals("historico")) {
				System.out.println("3");
			}else if (respuesta.equals("jugadores")) {
				menuJugadores();
			}else if(respuesta.equals("salir")) {
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
		int partida;
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
				System.out.println("**************Entrenamiento***************");
				System.out.println("******************************************");
				System.out.println("********Partida Rapida -3 Rondas**********");
				System.out.println("******************************************");
				System.out.println("********Partida Corta  -5 Rondas**********");
				System.out.println("******************************************");
				System.out.println("********Partida Normal -10 Rondas*********");
				System.out.println("******************************************");
				System.out.println("********Partida Normal -20 Rondas*********");
				System.out.println("******************************************");
				System.out.println("------------------------------------------");
				
				String duracion=sc.nextLine();
				duracion=duracion.toLowerCase();
				if(duracion.equals("entrenamiento")||duracion.equals("partida entrenamiento")) {
					partida=0;
					preguntas=true;
				}
				if(duracion.equals("3")||duracion.equals("rapida")) {
					partida=3;
					preguntas=true;					
				}else if(duracion.equals("5")||duracion.equals("corta")){
					partida=5;
					preguntas=true;
				}else if(duracion.equals("10")||duracion.equals("normal")){
					partida=10;
					preguntas=true;
				}else if(duracion.equals("20")||duracion.equals("larga")){
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
		}
	}
	
		  
		  public static void menuJugadores() throws IOException   {
			  Scanner entrada = new Scanner(System.in);
			  boolean menu=false;
			  String respuesta;				
				while(!menu) {
					  String opcion;
					  respuesta=null;
					  System.out.println("------------------------------------------");
						System.out.println("-            Menu Jugadores              -");
						System.out.println("-                                        -");
						System.out.println("-            -Ver Jugadores              -");
						System.out.println("-                                        -");
						System.out.println("-            -Añadir Jugador             -");
						System.out.println("-                                        -");				
						System.out.println("-      	     -Eliminar Jugador           -");
						System.out.println("-                                        -");
						System.out.println("-                -Salir                  -");
						System.out.println("-                                        -");
						System.out.println("------------------------------------------");
					
					respuesta = entrada.nextLine().toLowerCase();
				    
					if(respuesta.equals("ver jugadores")) {
						Jugador.verJugadores();
					}else if (respuesta.equals("añadir jugador")) {
						System.out.println("Que Jugador Desea Añadir?");
			            opcion = entrada.nextLine();
						Jugador.añadirJugador(opcion);
					}else if (respuesta.equals("eliminar jugador")) {
						System.out.println("Que Jugador Desea Eliminar?");
			            opcion = entrada.nextLine();
						Jugador.borrarJugador(opcion);
					}else if(respuesta.equals("salir")) {
						menu = true;
					}
				}
		  }
}
