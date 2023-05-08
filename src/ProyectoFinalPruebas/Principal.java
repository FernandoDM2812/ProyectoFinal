package ProyectoFinalPruebas;

import java.util.Scanner;

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
				System.out.println("1");
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
}
