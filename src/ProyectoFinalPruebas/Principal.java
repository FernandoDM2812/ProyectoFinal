package ProyectoFinalPruebas;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

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
	}
	
	 
	public static void jugarPartida() throws IOException{
		Scanner entrada = new Scanner(System.in);
		ArrayList<Object> listaJugador = new ArrayList<>();
		boolean partidaIniziada = false;
		boolean jugadores = false;
		boolean preguntas = false;
		int partida=0;
		int numJugadores=0;
		
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
	
				String a = entrada.nextLine();
				numJugadores = Integer.parseInt(a);
				if(numJugadores<=4&&numJugadores>=0) {
					jugadores=true;
				}else {
					System.out.println("Seleccione un numero de jugadores entre 0 y 4");
				}
				for(int i=0;i<numJugadores;i++) {
					System.out.println("Seleccione Jugador");
					String jugador = entrada.nextLine();
					boolean verdad = Jugador.comprobarJugador(jugador);
					if(!verdad) {
						System.out.println("Jugador no existente");
						i--;
					}else {
						Humano jugador1 = new Humano(jugador, 0);
						listaJugador.add(jugador1);
					}
				}
				int aux = numJugadores;
			while(aux<4) {
				int indice = 3 - aux;
				CPU jugadorCPU1 = (CPU) listaCPU.get(indice);
				listaJugador.add(jugadorCPU1);
				aux++;
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
					if(numJugadores!=1) {
						System.out.println("Solo un jugador puede jugar al entrenamiento");
					}else {
					partida=0;
					preguntas=true;
					}
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
				};
			}
		System.out.println("**************************************************************");	
		System.out.println("*********************Inicio De La Partida*********************");	
		System.out.println("**************************************************************");
		partidaIniziada=true;
		if(partida>0) {
			iniciarPartida(listaJugador,partida);
		}else {
			for(int i=0;i<listaJugador.size();i++) {
			if(listaJugador.get(i)instanceof Humano) {
				Jugador aux = (Jugador) listaJugador.get(i); 
			entrenamiento(aux);
			}
			}
		}
		}
	}
	
		  
		  public static void menuJugadores() throws IOException   {
			  Scanner sc = new Scanner(System.in);
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
					
					respuesta = sc.nextLine().toLowerCase();
				    
					if(respuesta.equals("1")) {
						Jugador.verJugadores();
					}else if (respuesta.equals("2")) {
						System.out.println("Que Jugador Desea Añadir?");
			            opcion = sc.nextLine();
						Jugador.añadirJugador(opcion);
					}else if (respuesta.equals("3")) {
						System.out.println("Que Jugador Desea Eliminar?");
			            opcion = sc.nextLine();
						Jugador.borrarJugador(opcion);
					}else if(respuesta.equals("4")) {
						menu = true;
					}
				}
		  }
		  public static void iniciarPartida(ArrayList<Object> jugadoresPartida,int duracion) throws IOException {
			  Scanner entrada = new Scanner(System.in);
			  duracion = duracion * 4;
			  boolean respuesta; 
			  Jugador jugador1 = (Jugador) jugadoresPartida.get(0);
			  Jugador jugador2 = (Jugador) jugadoresPartida.get(1);
			  Jugador jugador3 = (Jugador) jugadoresPartida.get(2);
			  Jugador jugador4 = (Jugador) jugadoresPartida.get(3);
			  for(int i=0;i<duracion;i++) {
				  if(i%4==1) {
					  System.out.println("Turno de " + jugador1.getNombre());
				  }else if(i%4==2) {
					  System.out.println("Turno de " + jugador2.getNombre());
				  }else if(i%4==3) {
					  System.out.println("Turno de " + jugador3.getNombre());
				  }else{
					  System.out.println("Turno de " + jugador4.getNombre());
				  }
				  String respuesta5 = Preguntas.generarPreguntaAleatoria();
				  int opcion = Preguntas.getOpcion();
				  if(i%4==1) {
					  if (opcion==1) {
						  respuesta = jugador1.responderLengua(respuesta5);
						  if(respuesta==true) {
							  jugador1.setPuntos(jugador1.getPuntos()+1);
						  }else {
							 System.out.println("La Respuesta No es Correcta"); 
						  }
					  }else if (opcion==2) {
						  respuesta = jugador1.responderIngles(respuesta5);
						  if(respuesta==true) {
							  jugador1.setPuntos(jugador1.getPuntos()+1);
						  }else {
							 System.out.println("La Respuesta No es Correcta"); 
						  }
					  }else{
						  respuesta = jugador1.responderMates(respuesta5);
						  if(respuesta==true) {
							  jugador1.setPuntos(jugador1.getPuntos()+1);
						  }else {
							 System.out.println("La Respuesta No es Correcta"); 
						  }
					  }
				  }else if(i%4==2) {
					  if (opcion==1) {
						  respuesta = jugador2.responderLengua(respuesta5);
						  if(respuesta==true) {
							  jugador2.setPuntos(jugador2.getPuntos()+1);
						  }else {
							 System.out.println("La Respuesta No es Correcta"); 
						  }
					  }else if (opcion==2) {
						  respuesta = jugador2.responderIngles(respuesta5);
						  if(respuesta==true) {
							  jugador2.setPuntos(jugador2.getPuntos()+1);
						  }else {
							 System.out.println("La Respuesta No es Correcta"); 
						  }
					  }else{
						  respuesta = jugador2.responderMates(respuesta5);
						  if(respuesta==true) {
							  jugador2.setPuntos(jugador2.getPuntos()+1);
						  }else {
							 System.out.println("La Respuesta No es Correcta"); 
						  }
					  }
				  }else if(i%4==3) {
					  if (opcion==1) {
						  respuesta = jugador3.responderLengua(respuesta5);
						  if(respuesta==true) {
							  jugador3.setPuntos(jugador3.getPuntos()+1);
						  }else {
							 System.out.println("La Respuesta No es Correcta"); 
						  }
					  }else if (opcion==2) {
						  respuesta = jugador3.responderIngles(respuesta5);
						  if(respuesta==true) {
							  jugador3.setPuntos(jugador3.getPuntos()+1);
						  }else {
							 System.out.println("La Respuesta No es Correcta"); 
						  }
					  }else{
						  respuesta = jugador3.responderMates(respuesta5);
						  if(respuesta==true) {
							  jugador3.setPuntos(jugador3.getPuntos()+1);
						  }else {
							 System.out.println("La Respuesta No es Correcta"); 
						  }
					  }
				  }else{
					  if (opcion==1) {
						  respuesta = jugador4.responderLengua(respuesta5);
						  if(respuesta==true) {
							  jugador4.setPuntos(jugador4.getPuntos()+1);
						  }else {
							 System.out.println("La Respuesta No es Correcta"); 
						  }
					  }else if (opcion==2) {
						  respuesta = jugador4.responderIngles(respuesta5);
						  if(respuesta==true) {
							  jugador4.setPuntos(jugador4.getPuntos()+1);
						  }else {
							 System.out.println("La Respuesta No es Correcta"); 
						  }
					  }else{
						  respuesta = jugador4.responderMates(respuesta5);
						  if(respuesta==true) {
							  jugador4.setPuntos(jugador4.getPuntos()+1);
						  }else {
							 System.out.println("La Respuesta No es Correcta"); 
						  }
					  }
				  }
				  
			  }
			  System.out.println("La Partida ha terminado de la siguiente forma: " );
			  System.out.println(jugador1.getNombre() + ": " + jugador1.getPuntos());
			  System.out.println(jugador2.getNombre() + ": " + jugador2.getPuntos());
			  System.out.println(jugador3.getNombre() + ": " + jugador3.getPuntos());
			  System.out.println(jugador4.getNombre() + ": " + jugador4.getPuntos());
			  String historico = (jugador1.getNombre()+ " " +jugador1.getPuntos()+ " " +jugador2.getNombre()+ " " +jugador2.getPuntos()+ " "+jugador3.getNombre()+ " " +jugador3.getPuntos()+ " "+jugador4.getNombre()+ " " +jugador4.getPuntos());
			  ArrayList<Jugador> aux = new ArrayList<>();
			  for(int i=0;i<jugadoresPartida.size();i++) {
				  if(jugadoresPartida.get(i)instanceof Humano) {
					  Jugador jugador = (Jugador) jugadoresPartida.get(i);
					  aux.add(jugador);
				  }
			  }
			  HistoricoRanking.actualizarHistorico(historico);
			  HistoricoRanking.actualizarRanking(aux);
		  }
		  
		  public static void entrenamiento(Jugador jugador) throws FileNotFoundException {
			  Scanner entrada = new Scanner(System.in);			  
			  boolean aux = false;
			  boolean respuesta;
			  while(!aux) {
				  String respuesta5 = Preguntas.generarPreguntaAleatoria();
				  int opcion = Preguntas.getOpcion();
				  if (opcion==1) {
					  respuesta = jugador.responderLengua(respuesta5);
					  if(respuesta==true) {
						  jugador.setPuntos(jugador.getPuntos()+1);
					  }else {
						 System.out.println("La Respuesta No es Correcta"); 
					  }
				  }else if (opcion==2) {
					  respuesta = jugador.responderIngles(respuesta5);
					  if(respuesta==true) {
						  jugador.setPuntos(jugador.getPuntos()+1);
					  }else {
						 System.out.println("La Respuesta No es Correcta"); 
					  }
				  }else{
					  respuesta = jugador.responderMates(respuesta5);
					  if(respuesta==true) {
						  jugador.setPuntos(jugador.getPuntos()+1);
					  }else {
						 System.out.println("La Respuesta No es Correcta"); 
					  }
			}
				  System.out.println("Desea Seguir Practicando?(Indique *No* en caso Contrario)");
					String salir = entrada.nextLine().toLowerCase();
					if(salir.equals("no")) {
						aux=true;
					}
		  }
	  }
}
