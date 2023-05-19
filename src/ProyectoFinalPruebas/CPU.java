package ProyectoFinalPruebas;

import java.util.Random;

public class CPU extends Jugador{
	int puntos;

	public CPU(String nombre, int puntos) {
		super(nombre);
		puntos = this.puntos;
	}
	protected boolean responderMates() {
		return true;
	}
	protected boolean responderLengua() {
		return false;
	}
	protected boolean responderIngles() {
		int numAleatorio = (new Random().nextInt(4)+1);
		if(numAleatorio==1) {
			return true;
		}else {
			return false;
		}
	}
}
