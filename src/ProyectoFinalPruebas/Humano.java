package ProyectoFinalPruebas;

import java.util.Scanner;

public class Humano extends Jugador{
	int puntos;
	
	public Humano( String nombre, int puntos) {
		super(nombre);
		puntos= this.puntos;
	}
	static Scanner entrada = new Scanner(System.in);
	
	private void responderMates() {
		respuesta = entrada.next();
	}
	private void responderLengua() {
		respuesta = entrada.next();
	}
	private void responderIngles() {
		respuesta = entrada.next();
	}
}
