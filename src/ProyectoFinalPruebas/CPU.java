package ProyectoFinalPruebas;

import java.util.Random;

public class CPU extends Jugador{
	int puntos;

	public CPU( String nombre, int puntos) {
		super(nombre,puntos);
	}
	@Override
	boolean responderMates(String resultado) {
		System.out.println("La respuesta de " + nombre + "es: " +resultado);
		return true;
	}
	@Override
	boolean responderLengua(String resultado) {
		System.out.println("La respuesta de " + nombre + "es: " + resultado);
		return false;
	}
	@Override
	boolean responderIngles(String resultado) {
		int numAleatorio = (new Random().nextInt(4)+1);
		if(numAleatorio==1) {
			System.out.println("La respuesta de " + nombre + "es: " +resultado);
			return true;
		}else {
			return false;
		}
	}
}
