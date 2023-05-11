package ProyectoFinalPruebas;

import java.util.Scanner;
import java.util.Random;

public class Principal {
	

	public static void main(String[]args) {
		boolean opcionCorrecta=false;
		
		
		System.out.println("------------------------------------------");
		System.out.println("-         Seleccione una opcion          -");
		System.out.println("-                                        -");
		System.out.println("-    -Jugar Partida      -Ranking        -");
		System.out.println("-      -Historico       -Jugadores       -");
		System.out.println("-                -Salir                  -");
		System.out.println("-                                        -");
		System.out.println("------------------------------------------");
		
		
		while(opcionCorrecta == false) {
			Scanner entrada = new Scanner(System.in);
			String respuesta = entrada.nextLine();
			respuesta.equalsIgnoreCase(respuesta);
			if(respuesta.equals("Jugar Partida")) {
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
	

	public class GeneradorOperacionMatematica {
	  
	  public static void main(String[] args) {
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

	
	public static void jugarPartida(){
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
