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
		return false;
	}
	@Override
	boolean responderMates(String resultado) {
		respuesta = entrada.next();
		return false;
	}
}
