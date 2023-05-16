package ProyectoFinalPruebas;

import java.util.Random;

public class CPU extends Jugador{
	int puntos;

	public CPU(String nombre, int puntos) {
		super(nombre);
		puntos = this.puntos;
	}
	private boolean responderMates() {
		return true;
	}
	private boolean responderLengua() {
		return false;
	}
	private boolean responderIngles() {
		int numAleatorio = (new Random().nextInt(4)+1);
		if(numAleatorio==1) {
			return true;
		}else {
			return false;
		}
	}
}
