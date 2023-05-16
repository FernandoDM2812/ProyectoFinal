package ProyectoFinalPruebas;

import java.util.Scanner;
import java.io.IOException;
import java.util.Random;

public class Principal {
	
	
	public static void main(String[]args) throws IOException {	
				
		boolean opcionCorrecta=false;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("------------------------------------------");
		System.out.println("-         Seleccione una opcion          -");
		System.out.println("-                                        -");
		System.out.println("-    -Jugar Partida      -Ranking        -");
		System.out.println("-      -Historico       -Jugadores       -");
		System.out.println("-                -Salir                  -");
		System.out.println("-                                        -");
		System.out.println("------------------------------------------");
		
		
		while(opcionCorrecta == false) {
			String respuesta = entrada.next();
			respuesta.equalsIgnoreCase(respuesta);
			if(respuesta.equals("Jugar")) {
				jugarPartida();
				opcionCorrecta = true;
			}else if (respuesta.equals("Ranking")) {
				System.out.println("2");
				opcionCorrecta = true;
			}else if (respuesta.equals("Historico")) {
				System.out.println("3");
				opcionCorrecta = true;
			}else if (respuesta.equals("Jugadores")) {
				System.out.println("4");
				opcionCorrecta = true;
			}else if(respuesta.equals("Salir")) {
				System.out.println("5");
				opcionCorrecta = true;
			}else {
				System.out.println("Por favor seleccione una opcion correcta");
			}
		}
	
	}
	
	 
	public static void jugarPartida() throws IOException{
		Scanner entrada = new Scanner(System.in);
		boolean partidaIniziada = false;
		boolean jugadores = false;
		boolean seleccion = false;
		int numJugadores;
		
		
		while(partidaIniziada==false) {
			while(jugadores==false) {
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
					if(verdad==false) {
						System.out.println("Jugador no existente");
						i--;
					}else {
						Humano jugador1 = new Humano(jugador, 0);
					}
				}
			}
		}
		
	}
	
	  public static void preguntaMates() {
		    int numOperandos = new Random().nextInt(5) + 4; // número aleatorio de 4 a 8 operandos
		    StringBuilder sb = new StringBuilder();
		    
		    // generamos los operandos aleatorios
		    for (int i = 0; i < numOperandos; i++) {
		      sb.append(new Random().nextInt(11) + 2); // valores aleatorios de 2 a 12
		      if (i != numOperandos - 1) { // si no es el último operando, añadimos un operador
		        sb.append(generarOperadorAleatorio());
		      }
		    }
		    
		    String operacion = sb.toString();
		    System.out.println("La operación matemática generada es: " + operacion);
		  }
		  
		  private static char generarOperadorAleatorio() {
		    int numAleatorio = new Random().nextInt(3);
		    switch (numAleatorio) {
		      case 0:
		        return '+';
		      case 1:
		        return '-';
		      default:
		        return '*';
		    }
		  }
}
