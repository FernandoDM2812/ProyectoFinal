package ProyectoFinalPruebas;

import java.util.Scanner;

public class Humano extends Jugador{
	int puntos;
	
	public Humano( String nombre, int puntos) {
		super(nombre);
		puntos= this.puntos;
	}
	static Scanner entrada = new Scanner(System.in);
	
	protected boolean responderMates() {
		respuesta = entrada.next();
		return false;
	}
	protected boolean responderLengua() {
		respuesta = entrada.next();
		return false;
	}
	protected boolean responderIngles() {
		respuesta = entrada.next();
		return false;
	}
}
