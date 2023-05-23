package ProyectoFinalPruebas;

import java.util.Scanner;

public class Humano extends Jugador{
	int puntos;
	
	public Humano( String nombre, int puntos) {
		super(nombre,puntos);
	}
	static Scanner entrada = new Scanner(System.in);
	
	
	@Override
	boolean responderLengua(String resultado) {
		return false;
	}
	@Override
	boolean responderIngles(String resultado) {
		String opcion="A";
		String respuesta;
		respuesta = entrada.next();
		if(respuesta.equals(opcion)) {
			System.out.println("La respuesta de " + nombre + " es: A");
			return true;
		}else {
			System.out.println("La respuesta de " + nombre + " es: " + respuesta);
			System.out.println("La respuesta correcta era: "+resultado);
			return false;
		}
	}
	@Override
	boolean responderMates(String resultado) {
		String respuesta = entrada.next();
		return false;
	}
}
